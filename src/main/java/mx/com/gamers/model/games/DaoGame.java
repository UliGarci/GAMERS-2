package mx.com.gamers.model.games;
import mx.com.gamers.model.service.ConnectionMySQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoGame {
    Connection con;
    CallableStatement cstm;
    ResultSet rs;
    Logger logger= LoggerFactory.getLogger(DaoGame.class);

    public List<BeanGame> findAll(){
        List<BeanGame> listGame=new ArrayList<>();
        try {
            con= ConnectionMySQL.getConnection();
            Statement stm=con.createStatement();
            rs=stm.executeQuery("{call findgames}");

            while (rs.next()){
                BeanGame game = new BeanGame();
                game.setId(rs.getInt("id"));
                game.setNombre(rs.getString("nombre"));
                game.setFecha(rs.getDate("fecha"));
                game.setStatus(rs.getInt("status"));
                game.setDescripcion(rs.getString("descripcion"));

                listGame.add(game);
            }
        }catch (SQLException e){
            logger.error("Ha surgido el siguiente error: "+e.getMessage());
        }finally {
            try {
                if(con!=null){
                    con.close();
                }
                if(rs!=null){
                    rs.close();
                }
            }catch (SQLException e){
            }
        }
        return listGame;
    }

    //CREATE
    public boolean create(BeanGame game){
        boolean flag=false;
        try {
            con=ConnectionMySQL.getConnection();
            cstm=con.prepareCall("{call registergames(?,?,?,?)}");
            cstm.setString(1, game.getNombre());
            cstm.setDate(2, (Date) game.getFecha());
            cstm.setInt(3,game.getStatus());
            cstm.setString(4,game.getDescripcion());
            cstm.execute();
            flag=true;
        }catch (SQLException e){
            logger.error("Error: "+e.getMessage());
        }finally {
            try {
                if(con!=null){
                    con.close();
                }
                if(cstm!=null){
                    cstm.close();
                }
            }catch (SQLException e){
            }
        }
        return flag;
    }

//ACTUALZAR
public boolean actualizar(BeanGame game){
    boolean flag=false;
    try{
        con = ConnectionMySQL.getConnection();
        cstm = con.prepareCall("{call modifygame(?,?,?,?)}");
        cstm.setInt(1,game.getId());
        cstm.setString(2, game.getNombre());
        cstm.setDate(3, (Date) game.getFecha());
        cstm.setInt(4,game.getStatus());
        cstm.setString(5,game.getDescripcion());
        flag=cstm.execute();
    }catch (SQLException e){
        logger.error("Ha ocurrido un error: " + e.getMessage());
    }finally {
        try {
            if(con!=null){
                con.close();
            }
            if(cstm!=null){
                cstm.close();
            }
        }catch (SQLException e){
        }
    }
    return flag;
}

//ELIMINAR
public boolean eliminar(int id){
        boolean flag=false;
    try{
        con = ConnectionMySQL.getConnection();
        cstm = con.prepareCall("{call deletegame(?)}");
        cstm.setInt(1,id);
        cstm.executeUpdate();
        flag=true;
    }catch(SQLException e){
        logger.error("Ha ocurrido un error: " + e.getMessage());
    }finally {
        try {
            if (con != null) {
                con.close();
            }
            if (cstm != null) {
                cstm.close();
            }
        }catch (SQLException e){
        }
    }
    return flag;
}
}