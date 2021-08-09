package mx.com.gamers.model.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.com.gamers.model.games.BeanGame;
import mx.com.gamers.model.games.DaoGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "ServletGame", value = "/ServletGame")
public class ServletGame extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletGame.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listGame",new DaoGame().findAll());
        request.getRequestDispatcher("/views/main.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name")!=null?request.getParameter("name"):"Sin nombre";
        String fecha = request.getParameter("fecha");
        String status = request.getParameter("status");
        String descripcion = request.getParameter("descripcion");

        BeanGame beanGame = new BeanGame(0,name,fecha, status, descripcion);
        if (new DaoGame().create(beanGame)){
            request.setAttribute("message","Videojuego registrado correctamente");
        }else{
            request.setAttribute("message","Videojuego no registrado");
        }
        doGet(request,response);
    }
}
