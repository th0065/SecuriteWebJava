# SecuriteWebJava
Projet JEE en groupe de 3
Dans ce que j'ai eu à faire il y a les servlets et les fichiers jsp 

Pour le servlet login:
----on utilise la méthode doPost pour recuperer la les parametres saisies et recuperer le compte qui coorespond au username et ensuite comparer les password s'ils sont identiques, si correct on est redirigé vers la page de gestion des users et roles sinon on reçcoit un message indiquant qu'il y a erreur sur username ou password.

----on utilise la methode doGet juste pour pouvoir atteindre l'accueil


Pour le servlet logout:
---- on a que doGet il va recuperer la session et effacer toutes les données de celle ci principaleement le username

Pour le servlet compte:

------dans doGet on recupere la session et verifie qu'elle contient un username sinon on est redirigé vers l'accueil et on verifie s'r y a une requete avec un parametre de valeur add , si c'est le cas elle redirige vers ajouter utilisateur et enfin elle recupere la liste compte en utilisant  l'entité compte
------dans doPost pour verifie s'il y a une requete post avec des parametres username et password si oui elle fait appel à entité compte pour créer un nouveau compte sinon il envoie une erreur 

Pour le servlet de droit même procedure que le servlet compte

-----------------------------------------------------------------------------------------------------------------

Pour les fichiers jsp l'index affiche un formulaire de connexion avec les champs username et password 
dans le dossier webapp/views/compte  on a add list et upd que j'ai pas fini pareil pour webapp/views/droit


----add formulaire d'ajout
----list tableau de compte/droit
----upd formulaire de modification (non géré pour le moment)


merci d'avoir pris le temps de lire
