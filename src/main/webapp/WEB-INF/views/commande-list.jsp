
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des commandes</title>
</head>
<body>

    <h1>Liste des commandes</h1>

    <p>
        <a href="${pageContext.request.contextPath}/commandes?action=new">
            Nouvelle commande
        </a>
    </p>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Client</th>
            <th>Statut</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="c" items="${commandes}">
            <tr>
                <td>${c.id}</td>
                <td>${c.dateCommande}</td>
                <td>${c.client.nom} ${c.client.prenom}</td>
                <td>${c.statut}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/commandes?action=detail&id=${c.id}">
                        Détail
                    </a>

                    |

                    <a href="${pageContext.request.contextPath}/commandes?action=edit&id=${c.id}">
                        Modifier
                    </a>

                    |

                    <a href="${pageContext.request.contextPath}/commandes?action=delete&id=${c.id}"
                       onclick="return confirm('Voulez-vous vraiment supprimer cette commande ?');">
                        Supprimer
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${empty commandes}">
        <p>Aucune commande enregistrée.</p>
    </c:if>

    <p>
        <a href="${pageContext.request.contextPath}/clients">Gérer les clients</a>
        |
        <a href="${pageContext.request.contextPath}/produits">Gérer les produits</a>
    </p>

</body>
</html>