<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h1>Produits</h1>
    <a href="produits?action=new">Ajouter</a>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Description</th>
            <th>Prix</th>
            <th>Stock</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="p" items="${produits}">
            <tr>
                <td>${p.id}</td>
                <td>${p.nom}</td>
                <td>${p.description}</td>
                <td>${p.prix}</td>
                <td>${p.stock}</td>
                <td>
                    <a href="produits?action=edit&id=${p.id}">Modifier</a>
                    <a href="produits?action=delete&id=${p.id}">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>