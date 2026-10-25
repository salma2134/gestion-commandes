
package ma.fstt.controllers;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.entities.Client;
import ma.fstt.service.ClientService;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet {

    @Inject
    private ClientService clientService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        if (action.equals("new")) {

            request.getRequestDispatcher(
                "/WEB-INF/views/client-form.jsp"
            ).forward(request, response);

        } else if (action.equals("edit")) {

            int id = Integer.parseInt(request.getParameter("id"));
            Client client = clientService.findById(id);

            request.setAttribute("client", client);

            request.getRequestDispatcher(
                "/WEB-INF/views/client-form.jsp"
            ).forward(request, response);

        } else if (action.equals("delete")) {

            int id = Integer.parseInt(request.getParameter("id"));
            clientService.delete(id);

            response.sendRedirect("clients");

        } else {

            request.setAttribute("clients", clientService.findAll());

            request.getRequestDispatcher(
                "/WEB-INF/views/client-list.jsp"
            ).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Client c = new Client();

        c.setNom(request.getParameter("nom"));
        c.setPrenom(request.getParameter("prenom"));
        c.setEmail(request.getParameter("email"));
        c.setTelephone(request.getParameter("telephone"));
        c.setAdresse(request.getParameter("adresse"));

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {

            clientService.save(c);

        } else {

            c.setId(Integer.parseInt(id));
            clientService.update(c);
        }

        response.sendRedirect("clients");
    }
}
