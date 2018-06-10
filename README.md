
# escalade

Avant de lancer le programme, il faut savoir qu'il est conçu pour fonctionner sous JAVA 8, PostgreSQL 9 et Tomcat 9.


Pour la base de données, vous trouverez ce qu'il vous faut dans le dossier script:
* D'abord lancer le script create_user.sql pour créer le propriétaire de la bdd.
* Ensuite lancer le script create_bdd.sql pour créer la bdd.
* Enfin lancer le restore avec data.backup pour insérer les données.

Si vous passez par pgAdmin, il faut :
* créer un nouveau rôle, le nommer "adm-escalade", mettre en password "azerty", et lui donner tous les privilèges.
* créer une nouvelle database, la nommer "db-escalade" et mettre "adm-escalade" en tant que propriétaire.
* faire un restore avec le fichier data.backup.

Il se peut qu'il y ai un soucis lors de la phase de "restore", c'est parce que le fichier a été créé sous PostgreSQL 9.6.8-1. Il faut juste mettre à jour PostgreSQL sous la version 9.6.8-1 ou supérieur.

Dans le dossier script, vous trouverez aussi le fichier escalade-webapp.war. Il faut copier/coller ce fichier dans le dossier webapp du server Tomcat.

Pour vos tests, le compte administrateur du projet est :
* Pseudo: vianney
* Password: azerty