package com.groupeisi.tp.servlet;

import com.groupeisi.tp.dao.CompteDAO;
import com.groupeisi.tp.dao.DroitDAO;
import com.groupeisi.tp.entities.Compte;
import com.groupeisi.tp.entities.Droit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/login", name = "login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        CompteDAO compteDAO = new CompteDAO();
//        int value = compteDAO.validate(username, password);
//        response.getWriter().println(value);
        if(compteDAO.validate(username, password) == 1){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("compte");
        }else{
            request.setAttribute("error", "Username ou Password  incorrect !!!");
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }
}
