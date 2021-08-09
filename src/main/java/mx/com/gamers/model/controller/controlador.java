package mx.com.gamers.model.controller;

import mx.com.gamers.model.games.BeanGame;
import mx.com.gamers.model.games.DaoGame;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.util.List;

public class controlador extends HttpServlet {

    BeanGame beanGame = new BeanGame();
    DaoGame daoGame = new DaoGame();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws SerialException, IOException{
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        menu="videojuegos";
        if(menu.equals("videojuegos")) {
            switch (accion) {
                case "Listar":
                    List lista = daoGame.findAll();
                    request.setAttribute("videojuegos", lista);
                    break;
                case "Agregar":
                    break;
                case "Editar":
                    break;
                case "Eliminar":
                    break;
            }
        }
    }
}
