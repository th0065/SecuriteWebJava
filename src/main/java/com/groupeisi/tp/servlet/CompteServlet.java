package com.groupeisi.tp.servlet;

import com.groupeisi.tp.dao.CompteDAO;
import com.groupeisi.tp.entities.Compte;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(value = "/compte", name = "compte")
public class CompteServlet extends HttpServlet {
    private static String VIEW_PATH = "/WEB-INF/views/comptes/";
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if(username == null){ // si l'utilisateur n'est pas authentifié
            response.sendRedirect("logout");
        }else{
            String param = request.getParameter("param");


            if(param != null){
                if(param.equals("add")){
                    this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
                }



            }else{
                CompteDAO compteDAO = new CompteDAO();
                Compte c = new Compte();
                List<Compte> listCompte = compteDAO.getAllCompte();
                request.setAttribute("listCompte", listCompte);
                request.setAttribute("username", username);
                this.getServletContext().getRequestDispatcher(VIEW_PATH + "list.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password  = request.getParameter("password");
        if(username.equals("") && password.equals("")){
            request.setAttribute("error", "Veuillez renseigner tous les champs");
            this.getServletContext().getRequestDispatcher(VIEW_PATH + "add.jsp").forward(request, response);
        }else{
            CompteDAO compteDAO = new CompteDAO();
            Compte compte = new Compte();
            compte.setUsername(username);
            compte.setPassword(password);
            int result = compteDAO.add(compte);
            if(result == 1){
                request.setAttribute("success", "Crée avec succès");
            }else{
                request.setAttribute("error", "Une erreur s'est produite");
            }

            response.sendRedirect("compte");
        }
    }

   @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password  = req.getParameter("password");
        int id  = Integer.parseInt(req.getParameter("id"));
       CompteDAO compteDAO = new CompteDAO();
       Compte compte = new Compte();
       compte.setId(id);
       compte.setUsername(username);
       compte.setPassword(password);
       if(compteDAO.update(compte) == 1){

           resp.sendRedirect("compte");
       }else{
           req.setAttribute("error", "Modification a échoué");
           this.getServletContext().getRequestDispatcher("compte").forward(req, resp);
       }
    }


}

