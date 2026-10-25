package ma.fstt.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.entities.Produit;
import ma.fstt.service.ProduitService;

@WebServlet("/produits")
public class ProduitServlet extends HttpServlet {

    @Inject
    private ProduitService produitService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; }

        if (action.equals("new")) {
            request.getRequestDispatcher("/WEB-INF/views/produit-form.jsp").forward(request, response);

        } else if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("produit", produitService.findById(id));
            
            request.getRequestDispatcher("/WEB-INF/views/produit-form.jsp").forward(request, response);

        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            produitService.delete(id);
            response.sendRedirect("produits");

        } else {
            request.setAttribute("produits", produitService.findAll());
            request.getRequestDispatcher("/WEB-INF/views/produit-list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Produit p = new Produit();
        p.setNom(request.getParameter("nom"));
        
        p.setDescription(request.getParameter("description"));
        
        p.setPrix(Double.parseDouble(request.getParameter("prix")));
        p.setStock(Integer.parseInt(request.getParameter("stock")));

        String id = request.getParameter("id");
        if (id == null || id.isEmpty()) {
            produitService.save(p);
        } else {
            p.setId(Integer.parseInt(id));
            produitService.update(p);
        }

        response.sendRedirect("produits");
    }
}