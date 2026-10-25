# Gestion des commandes

Application web de gestion des clients, des produits et des commandes, développée avec Java EE et une architecture basée sur les Servlets, les JSP et JDBC.

## Présentation du projet

Ce projet a pour objectif de faciliter la gestion des principales opérations commerciales à travers une application web permettant de centraliser les informations relatives aux clients, aux produits et aux commandes.

L'application suit une architecture organisée en plusieurs couches afin de séparer la présentation, la logique métier et l'accès aux données.

## Fonctionnalités

- **Gestion des clients** : consulter la liste des clients et accéder aux formulaires de gestion.
- **Gestion des produits** : consulter les produits et accéder aux formulaires correspondants.
- **Gestion des commandes** : consulter les commandes, accéder aux formulaires de création et afficher les détails d'une commande.
- **Gestion des données** : accès à la base de données via JDBC et des classes DAO.



## Technologies utilisées

- **Langage :** Java
- **Technologies web :** Java Servlets et JSP
- **Accès aux données :** JDBC
- **Architecture :** DAO et couche Service
- **Injection de dépendances :** CDI
- **Gestion des dépendances :** Maven
- **Serveur d'applications :** Apache Tomcat 9
- **Base de données :** MySQL
- **Environnement de développement :** Eclipse IDE

## Architecture du projet

```text
gestion-commandes/
├── src/
│   └── main/
│       ├── java/
│       │   └── ma/fstt/
│       │       ├── controllers/
│       │       ├── dao/
│       │       ├── entities/
│       │       └── service/
│       └── webapp/
│           ├── META-INF/
│           ├── WEB-INF/
│           │   ├── beans.xml
│           │   └── views/
│           └── index.jsp
├── pom.xml
├── .gitignore
└── README.md
```

### Rôle des principales couches

- **Controllers** : gèrent les requêtes HTTP et coordonnent les traitements.
- **DAO** : assurent l'accès à la base de données.
- **Entities** : représentent les objets métier, notamment les clients, les produits et les commandes.
- **Service** : regroupe les opérations métier.
- **Views (JSP)** : assurent l'affichage des pages web.
- **`pom.xml`** : définit les dépendances et la configuration Maven.

## Prérequis

Avant de lancer le projet, assurez-vous de disposer des éléments suivants :

- JDK 11
- Apache Maven
- Apache Tomcat 9
- MySQL Server
- Eclipse IDE ou un environnement Java équivalent

## Installation et lancement

### 1. Cloner le dépôt

```bash
git clone https://github.com/salma2134/gestion-commandes.git
cd gestion-commandes
```

### 2. Configurer la base de données

- Créer une base de données MySQL.
- Créer les tables nécessaires à partir du modèle de données du projet.
- Configurer les paramètres de connexion dans `DBConnection.java` ou dans le mécanisme de configuration utilisé par l'application.



### 3. Configurer le projet

Importer le projet dans Eclipse comme projet Maven existant, puis vérifier que les dépendances sont correctement téléchargées.

### 4. Déployer l'application

- Configurer Apache Tomcat 9 dans Eclipse.
- Ajouter le projet au serveur.
- Démarrer Tomcat et déployer l'application.

L'URL d'accès dépend du nom de contexte utilisé lors du déploiement, par exemple :

```text
http://localhost:8080/gestion-commandes/
```


Étudiante en cycle d'ingénieur — Logiciels et Systèmes Intelligents.

## Dépôt GitHub

[https://github.com/salma2134/gestion-commandes](https://github.com/salma2134/gestion-commandes)
