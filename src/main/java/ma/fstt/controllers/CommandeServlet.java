
package ma.fstt.controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneDeCommande;
import ma.fstt.entities.Produit;

import ma.fstt.service.ClientService;
import ma.fstt.service.CommandeService;
import ma.fstt.service.LigneDeCommandeService;
import ma.fstt.service.ProduitService;

@WebServlet("/commandes")
public class CommandeServlet extends HttpServlet {

    @Inject
    private CommandeService commandeService;

    @Inject
    private ClientService clientService;

    @Inject
    private ProduitService produitService;

    @Inject
    private LigneDeCommandeService ligneService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; }
       
        if (action.equals("new")) {
            request.setAttribute("clients", clientService.findAll());

            request.getRequestDispatcher(
                "/WEB-INF/views/commande-form.jsp"  ).forward(request, response);
          
        } else if (action.equals("edit")) {

            int id = Integer.parseInt(request.getParameter("id"));

            request.setAttribute(
                "commande",commandeService.findById(id));
                    
                
            request.setAttribute("clients", clientService.findAll());

            request.getRequestDispatcher( "/WEB-INF/views/commande-form.jsp" ).forward(request, response);

        } else if (action.equals("detail")) {

            int id = Integer.parseInt(request.getParameter("id"));

            Commande c = commandeService.findById(id);
            c.setLignes(ligneService.findByCommande(id));

            request.setAttribute("commande", c);
            request.setAttribute("produits", produitService.findAll());

            request.getRequestDispatcher(
                "/WEB-INF/views/commande-detail.jsp"
            ).forward(request, response);

        } else if (action.equals("delete")) {

            int id = Integer.parseInt(request.getParameter("id"));

            commandeService.delete(id); 
            response.sendRedirect("commandes");

        } else if (action.equals("deleteLigne")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String idCommande = request.getParameter("idCommande");

            ligneService.delete(id);

            response.sendRedirect(
                "commandes?action=detail&id=" + idCommande);

        } else {

            request.setAttribute(
                "commandes",
                commandeService.findAll());

            request.getRequestDispatcher(
                "/WEB-INF/views/commande-list.jsp"
            ).forward(request, response);} }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");

        if (action != null && action.equals("addLigne")) {

            int idCommande = Integer.parseInt(request.getParameter("idCommande"));

            int idProduit = Integer.parseInt(request.getParameter("idProduit"));

            int quantite = Integer.parseInt(request.getParameter("quantite"));

            Produit p = produitService.findById(idProduit);

            LigneDeCommande ligne = new LigneDeCommande();

            ligne.setIdCommande(idCommande);
            ligne.setProduit(p);
            ligne.setQuantite(quantite);
            ligne.setPrixUnitaire(p.getPrix());

            ligneService.save(ligne);

            response.sendRedirect(  "commandes?action=detail&id=" + idCommande   );

        } else {

            Client client = new Client();
            client.setId(
                Integer.parseInt(request.getParameter("idClient")));

            Commande c = new Commande();

            c.setClient(client);
            c.setDateCommande(
                LocalDate.parse(request.getParameter("dateCommande")));
            c.setStatut(request.getParameter("statut"));

            String id = request.getParameter("id");

            if (id == null || id.isEmpty()) {

                int newId = commandeService.save(c);

                response.sendRedirect(
                    "commandes?action=detail&id=" + newId );

            } else {

                c.setId(Integer.parseInt(id));
                commandeService.update(c);

                response.sendRedirect(
                    "commandes?action=detail&id=" + id ); }
        }
    }
}