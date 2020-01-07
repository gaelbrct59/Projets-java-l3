Binôme : 
========

-Bricout Gael
-Bearez Antoine


Objectif
========

Creation d'un jeu de type Donjon : le joueur arrive dans la premiere salle avec, comme unique choix, la possibilité de bouger. 
Il changera de salle et lancera dans le même temps le jeux, et le premier tour.
Dans les salles, il peut y avoir des monstres, ou des items, ou les deux. Les monstres sont meilleurs au fur et à mesure des tours.
 
	* Nous trouverons différents items dans le salles comme par exemple :
		1°) Potion de force (StrenghtPotion) : qui ajoute de la force au joueur
		2°) Potion de vie (LifePotion) : qui ajoute de la vie au joueur
		3°) Des sous (GoldPurse) : qui ajoute de l'argent au joueur
		4°) Il est aussi possible que le bandit manchot (OneArmedBandit) qui peut vendre un objet aléatoire au joueur, contre une somme d'argent(30)


	* Dans chaque salles, il est possible de choisir l'action a effectuer, comme :
		1°) Regarder autour (Look) : le joueur observe la présence de monstres/items/issues.
		2°) Attaquer un des monstres de la salle (Attack): le joueur attaque le monstre, mais attention ! Le monstre riposte.
		3°) Changer de salle (Move) : uniquement si les monstres de la salle sont vaincus
		4°) Recuperer de la vie (Rest) : Si les monstres ont ete vaincus. 

Une salle est spéciale, la salle EXIT, qui permet, une fois les monstres vaincus, de gagner la partie.
Cette salle apparait aléatoirement, au bout d'au moins 3 tours de jeux.
 Si le joueur meurt avant d'atteindre cette salle, c'est GAME OVER 

Mise en oeuvre du TP
--------------------

Le TP a été réalisé dans sa totalité. La javadoc est fonctionnelle. Le .jar est cree et fonctionnel. Les tests sont fonctionnels
Cependant : problème d'input (demande a l'utilisateur) dans les tests. Ils sont fonctionnels sur l'ide eclipse, mais non fonctionnels sur un terminal avec maven.
Nous avons donc mis en commentaire chaque "a.perform(p)" des classes test, ainsi que "testCanPerform" dans la classe "TestAction"

Instructions
------------

mvn package
mvn javadoc:javadoc
L'uml est dans le dossier, sous le nom umldonjon.png

Notes de conception
-------------------

A chaque changement de salle, une des room disponible est la room de sortie (a partir du troisieme tour). Le choix de la sortie est donc aléatoire, et pas prédéfini.

Utilisation reccurente de la classe Choose, définie au tp précédent, a chaque choix possible pour l'utilisateur

Nous avons choisi de ne pas pouvoir retourner dans les salles précédentes, nous avons donc instancié que trois direcions differentes possible.

Nous avons décidé de créer une nouvelle "Room" a chaque changement de salle. Les salles ne sont donc pas prédéfinie, et le choix de la même direction a chaque fois ne fait donc pas de tours.
Cela implique que chaque nouvelle salle est créée aléaoirement dans la méthode playerMoveTo

Par souci de visibilité, nous avons multiplié les méthodes extraites afin de mieux comprendre les méthodes les plus importantes
Dans ce cas, nous avons ajouté le commentaire //Extract method

Player initialisé dans le GameMain

La création et l'ajout des items dans une salle sont gérés dans la classe Room, dans createItemsInTheRoom()

La création et l'ajout des monstres dans une salle sont gérés dans la classe AdventureGame dans createMonstersInTheRoom()

Afin de faciliter la réutilisation du code, nous avons ajouté la possibilité de modifier chaque max de chaque valeurs aléatoires (Le minimum d'or par monstre et par gold purse, …)
