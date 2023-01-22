package com.groupeisi.tp.servlet;

import com.groupeisi.tp.dao.CompteDAO;
import com.groupeisi.tp.dao.DroitDAO;
import com.groupeisi.tp.entities.Compte;
import com.groupeisi.tp.entities.Droit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/droit", name = "droit")
public class DroitServlet extends HttpServlet {

    private static String VIEW_PATH = "/WEB-INF/views/droits/";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username == null){ // si l'utilisateur n'est pas authentifié
            response.sendRedirect("/logout");
        }else{
            String param = request.getParameter("param");
            if(param != null){
                if(param.equals("add")){
                    this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
                }
            }else{
                DroitDAO droitDAO = new DroitDAO();
                Droit d = new Droit();
                List<Droit> listDroit = droitDAO.getAllDroit();
                request.setAttribute("listDroits", listDroit);
                request.setAttribute("username", username);
                this.getServletContext().getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if(name.equals("")){
            request.setAttribute("error", "Veuillez renseigner le role");
            this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
        }else{
            DroitDAO droitDAO = new DroitDAO();
            Droit droit = new Droit();
            droit.setName(name);
            int result = droitDAO.add(droit);
            if(result == 1){
                request.setAttribute("success", "Crée avec succès");
            }else{
                request.setAttribute("error", "Une erreur s'est produite");
            }

            response.sendRedirect("droit");
        }
    }
}
