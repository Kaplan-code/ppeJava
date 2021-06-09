Cloner le projet :
  
    https://gitlab.com/Kaplan-K/ppejava.git

Sur l'IDE, aller dans les propriété du projet et ajouté toute les librairies contenu dans le dossier "LibsForHibernate" importer avec le projet.
   
    (properties -> Java Build Path -> Libraries -> Add Jars -> LibsForHibernate -> Apply and Close)

Changer s'il le faut le fichier "hibernate.cfg.xml" avec les informations correspondantes.

Injecter le script sql :
    
    mysql  -u root < PPE2/sql/fichier.sql

Voici les comptes pour se connecter :

-Compte délégue régional:

    login : m
    mdp  : 12

-Compte visiteur :
   
    login : k
    mdp  : 123
