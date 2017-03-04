# TP Architecture Logicielle / Inf4043 - 2017 - Jeux de lettres

Projet réalisé par :

    Najim LAWANI TCSI2 4A ESIEA Paris
    Julien RATEAU TCSE2 4A ESIEA Paris

Nous avons utilisé 'Maven' pour la gestion du projet. Nous travaillons avec un seul package, fr.esiea.unique.elayathamby.saada, mais l'ensemble du projet est découpé en différentes classes :

# Explications sur l'architecture utilisée

On a choisit de réaliser 5 classes permettant de créer des objets précis


  StartGame: Cette classe lance le jeu et demande à l'utilisateur s'il veut jouer contre un autre joueur ou contre une IA
  
   Main : Permet d'initialiser le jeu. C'est la classe principale, le programme commence donc par cette classe. Elle permet de lancer une nouvelle partie. Elle gère essentiellementt, le choix des premières lettres à tirer pour savoir qui commence la partie. Elle affecte ainsi à chaque joueur un numéro.
   
   
   
    File : Cette classe permet de lire et faire le lien entre les mots du  fichier dico et tous les autres mots rentrés par l'utilisateur.
    
    Player : Cette classe permet de faire tourner le jeu. Elle contient les différentes méthodes pour le respect des règles du jeu. Dans cette partie, nous gérons le pot commun. A travers cette classe un utilisateur peut ajouter ou retirer des lettres du pot, piocher une lettre aléatoire (voir plusieurs lettres).
    
    StartBag : Cette classe permet de définir un mot, voir s'il est valide. On va ensuite comparer chaque mot entré par l'utilisateur avec les mots présents dans le dico.txt. Si le mot est correct, on le sauvegarde. On utilise cette classe pour dissocier un mot en deux mots (par exemple : bien-être en bien et être ou encore abaisse-langue en abaisse et langue). On utilise la méthode searchWordInDico() pour vérifier la présence d'un mot dans le dico.

 
 # Exercice sur les principes SOLID/Design Patterns
 
 Nous avons utilisé le principe SOLID dans l'architecture de notre code au lieu des designs patterns, c'est-à-dire nous avons respecté les critères suivants :

    Une seule responsabilité par classe et méthodes. Chaque méthode ne réalise qu'une seule tâche

    La capacité d'avoir une classe étendu et modifiable seulement via l'extension.

    Nous avons utilisé deux principes SOLID, à savoir le S et le O dans notre code, comme nous n'avons pas d'interfaces ni d'instances nous n'avons pas pu implémenté les autres principes.


