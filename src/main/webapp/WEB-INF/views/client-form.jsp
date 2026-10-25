<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Client</title>
</head>
<body>
    <c:if test="${empty client}">
        <h1>Ajouter un client</h1>
    </c:if>
    <c:if test="${not empty client}">
        <h1>Modifier le client</h1>
    </c:if>

    <form action="clients" method="post">
        <input type="hidden" name="id" value="${client.id}">

        Nom : <input type="text" name="nom" value="${client.nom}" required><br><br>
        Prénom : <input type="text" name="prenom" value="${client.prenom}" required><br><br>
        Email : <input type="email" name="email" value="${client.email}" required><br><br>
        Téléphone : <input type="text" name="telephone" value="${client.telephone}"><br><br>
        Adresse : <input type="text" name="adresse" value="${client.adresse}"><br><br>

        <input type="submit" value="Enregistrer">
        <a href="clients">Annuler</a>
    </form>
</body>
</html>