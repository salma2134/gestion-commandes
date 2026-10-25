<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
    <h1>Produit</h1>
    <form action="produits" method="post">
    
        <input type="hidden" name="id" value="${produit.id}">
        
        Nom : <input type="text" name="nom" value="${produit.nom}"><br>
        Description : <input type="text" name="description" value="${produit.description}"><br>
        Prix : <input type="number" step="0.01" name="prix" value="${produit.prix}" required><br>
        Stock : <input type="number" name="stock" value="${produit.stock}" required><br>
        <input type="submit" value="Enregistrer">
    </form>
</body>
</html>