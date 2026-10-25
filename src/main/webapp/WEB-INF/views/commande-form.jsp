<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h1>COMMANDE</h1>
    <form action="commandes" method="post">
        <input type="hidden" name="action" value="save">
        <input type="hidden" name="id" value="${commande.id}">

        Client :
        <select name="idClient">
            <c:forEach var="cl" items="${clients}">
                <c:if test="${cl.id == commande.client.id}">
                    <option value="${cl.id}" selected>${cl.nom} ${cl.prenom}</option>
                </c:if>
                <c:if test="${cl.id != commande.client.id}">
                    <option value="${cl.id}">${cl.nom} ${cl.prenom}</option>
                </c:if>
            </c:forEach>
        </select><br>

        Date : <input type="date" name="dateCommande" value="${commande.dateCommande}" required><br>
        Statut : <input type="text" name="statut" value="${commande.statut}"><br>

        <input type="submit" value="enregistrer">
    </form>
</body>
</html>