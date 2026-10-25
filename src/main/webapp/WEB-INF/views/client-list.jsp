<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, ma.fstt.entities.Client" %>
<html>
<body>
<h1>Liste des clients</h1>
<a href="clients?action=new">Ajouter un client</a>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
    </thead>

    <% List<Client> liste = (List<Client>) request.getAttribute("clients"); %>
    <tbody>
    <% for (int i = 0; i < liste.size(); i++) { %>
        <tr>
            <td><%= liste.get(i).getId() %></td>
            <td><%= liste.get(i).getNom() %></td>
            <td><%= liste.get(i).getPrenom() %></td>
            <td><%= liste.get(i).getEmail() %></td>
            <td>
                <a href="clients?action=edit&id=<%= liste.get(i).getId() %>">Modifier</a>
                <a href="clients?action=delete&id=<%= liste.get(i).getId() %>">Supprimer</a>
            </td>
        </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>