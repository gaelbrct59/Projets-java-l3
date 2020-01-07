Binome : 
========
***************************************
** ~ Bricout Gael | Bearez Antoine ~ **
***************************************

Objectif
========

Creation d'un Questionnaire qui lit dans un fichier donne, les questions/reponses/et points donnes par reponses correctes. Ici, le projet est de repondre aux questions, et gagner des points si la reponse est bonne.
Il y a plusieurs types de reponses : 

	* les reponses "numeriques" avec des entier, 
	* des reponses "textuelles" avec des chaînes de caractere, 
	* des reponses "YesNo" avec comme unique choix oui ou non.
	* des reponses multiples (avec plusieurs reponses correctes)
	* des choix multiples (une bonne reponse se glisse parmis les choix proposes)
 
Mise en oeuvre du TP
--------------------

Projet termine et fonctionnel.
Probleme dans la version console : lorsqu'on donne une reponse incorrecte au MulitpleChoice, le programme renvoie tous les choix, et pas seulement "Bill"

Instructions
------------

	* mvn package
	* mvn javadoc:javadoc
	* L'uml est dans le dossier, sous le nom umlQuestionnaire.png
	* Afin de lancer l'application, et ses differentes versions, nous avons mis un Choix comme premiere etape, afin de savoir si l'application lance :
		1) La version console sans mutli Answer ou multiple Choice
		2) La version console avec multi Answer et multiple Choice
		3) La version IHM sans mutli Answer ou multiple Choice
		4) La version IHM avec mutli Answer et multiple Choice

Notes de conception
-------------------

**IMPORTANT** : suite à une erreur au debut de la creation du projet, celui-ci se nomme Gestionnaire. Pour eviter tout probleme avec git, nous avons prefere laisser ce nom.

A chaque question, est lie une reponse. Si la reponse donnee est differente de celle fixee, alors la reponse est fausse.

Afin de tester correctement la validite des reponses, il y a une comparaison des objets (answer) et de les chaines de caractere avec **equalsIgnoreCase**
(afin que si l'utilisateur reponde toklien au lieu de Tolkien, la reponse est valide tout de meme).

Certaines methodes ont ete extraites, par soucis de lisibilite du code, et respect des principes SOLID. Ceux-ci ont ete notes par **"EXTRACTED"** dans la doc.

Nous avons ajoute a la methode **askAll** de Questionnaire, un booleen, afin d'afficher et de demander (a l'utilisateur), ou non, afin de bien gerer les tests.

Les tests de Question n'ont pas ete fait, du aux methodes presentes (uniquement des getters/setters).

Concernant les tests, a chaque tests d'Answer, nous avons cree une reponse correcte avec la variable globale **ANS_TRUE**  et une reponse fausse, avec la variable globale **ANS_FALSE**

L'ensemble des elements de l'IHM est geree par **QuestionnaireFactoryIHM** (JFrame, JPanel...) ils sont implementes via des objets crees par les classes du package **Ihm**.

La classe **AnswerFactoryIHM** est la methode qui creera le bon type de reponses.

La classe **Ihm_AnswerContent** est celle qui cree le bon type de remplissage pour l'utilisateur (oui/non ; remplissage de texte...). Celle-ci ne respecte cependant pas du tout les principes SOLID.

La classe **SendQuestionnaire** est celle qui envoie les réponses de l'utilisateur a tester, afin verifier les bonnes reponses et compter les points(equivalente a **askAll**)

Nous avons bloque les textField qui sont cense prendre des entiers, afin de n'avoir que des entiers. Les autres lettres ou autre touches ne sont pas autorisees. (mis a part suppr et del) A l'aide d'un keyListener (**getKeyChar()** & **getExtendedKeyCode**)
