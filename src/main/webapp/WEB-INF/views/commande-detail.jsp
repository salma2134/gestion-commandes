<%@ page %>

<html>
<body>
    <h1>Commande ${commande.id}</h1>
    Client : ${commande.client.nom} ${commande.client.prenom}<br>
    Date : ${commande.dateCommande}<br>
    Statut : ${commande.statut}<br>

    <h2>Lignes</h2>
    <table border="1">
        <tr>
            <th>produit</th>
            <th>quantité</th>
            <th>prix unitaire</th>
            <th>total</th>
            <th>Action</th>
        </tr>
        <c:forEach var="l" items="${commande.lignes}">
            <tr>
                <td>${l.produit.nom}</td>
                <td>${l.quantite}</td>
                <td>${l.prixUnitaire}</td>
                <td>${l.total}</td>
                <td>
                    <a href="commandes?action=deleteLigne&id=${l.id}&idCommande=${commande.id}">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
    <h3>Total : ${commande.total}</h3>

    <h2>Ajouter un produit</h2>
    <form action="commandes" method="post">
        <input type="hidden" name="action" value="addLigne">
        <input type="hidden" name="idCommande" value="${commande.id}">

        Produit :
        <select name="idProduit">
            <c:forEach var="p" items="${produits}">
                <option value="${p.id}">${p.nom} (${p.prix})</option>
            </c:forEach>
        </select>

        Quantité : <input type="number" name="quantite" value="1" required>
        <input type="submit" value="Ajouter">
    </form>

    <a href="commandes">Retour à la liste</a>
</body>
</html>