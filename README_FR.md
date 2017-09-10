# /!\ ATTENTION : Ce Project est actuellement en Developpement [INSTABLE] /!\

# *RoutineGuard* [**FR**]

Ce Projet a pour but d'**aider les personnes en situation de dépendance** (personnes agées par exemple) avec des **solutions technologiques basées sur une routine**, pour garder un oeil sur eux et analyser si tout va bien, à tout moment.  
Le but est aussi de **rendre la communication plus simple en cas d'incident** et de faire en sorte que les secours arrivent plus rapidement si besoin.  

# Solutions Techniques

Le projet utilise principalement une *Raspberry Pi* avec un *GrovePi*, un *Arduino*, et une floppée de capteurs divers et variés.  
La **Raspberry Pi est le coeur du système**, elle contrôle tout le reste.  
Elle **communique avec les capteurs** placés aux quatre coins de la maison, et avec l'**Arduino** (et ses propres capteurs) qui forme un Bracelet que la personne porte.  

# Comment ça marche ?

L'ensemble du système utilise le concept de **"Routine"**, que l'on représente par une **Journée, contenant des Évènements**.
La Routine est la **"Journée Idéale"**, et le programme la comparera avec la **"Journée Actuelle"** pour voir si tout est normal.

L'un de nos buts est de connecter le Système (Raspberry Pi) avec le Bracelet ("Arduino" Feather 32u4), dans le but de les faire communiquer.  
Avec une telle liaison, nous serions capable de **récupérer les informations des Capteurs du Bracelet** (*Battements-par-Minute*, *Intervale entre deux Battements*, *Accéleration*) pour **analyser l'État de Santé** de l'utilisateur, mais aussi pour **envoyer des alertes** (*Vibrations*, *Signaux Lumineux et/ou Sonores*, *Voix*, *...*) et de récupérer l'état des Boutons (le Bracelet est censé avoir deux boutons, un Rouge (*Appeller à l'Aide* ou *"Réponse Négative"*) et un Vert (*"Réponse Positive"*).

	[BRACELET IMAGE]
	
De plus, le système est composé de **différents capteurs installés dans plusieurs endroits de la maison** pour garantir la sécurité de l'utilisateur.  
Il y a des **capteurs de mouvement** dans la chambre, la salle de bain et la cuisine, ainsi que des **capteurs de contact** sur le frigo (pour détecter le début d'un repas), les toilettes et la porte de l'entrée principale.
  
Ce différents capteurs permettent au Système de **vérifier si tout se passe** comme il est prévu dans la Routine (qui est configurable) ou non.  
Par ailleurs, le système contient également un **campteur de températeur et d'humidité** ainsi qu'un **capteur de luminosité**, tous placés dans la maison, pour faire une sorte de station météo.

# Comment l'utiliser ?

**IMPORTANT : A ce jour (20/06/2017), tout n'est pas fonctionnel/implementé, jettez un oeil à la section « Statut du Projet » ci-dessous.

### Pré-requis :
- Une *Raspberry Pi* (la notre est sous *Raspbian*) avec un module *GrovePi* et ses *Capteurs*
- Un « Arduino-like » *Feather 32u4* d'*Adafruit*
- Un *Écran Tactile 7"* pour *Raspberry Pi*

### Construire et Lancer - Instructions :
1. Clonez/Téléchargez ce *Dépôt Github*
      1.5 Customisez le code pour vos propres besoins, si besoin (n'hésitez pas a nous demander de l'aide !)
2. Construisez (Build) le Projet Java "RoutineGuard_App" (Situé ici : 'Raspberry/RoutineGuard_App/')
      2.5 Si vous ne pouvez pas construire le fichier JAR, n'hésitez pas à nous contacter, nous pouvons vous le fournir !
3. Déplacez le dossier '/dist/' généré dans votre *Raspberry Pi* et lancez le avec la commande "java -jar /chemin/RoutineGuard_App.jar"
4. Tout est prêt ! Vous pouvez d"sormais **utiliser l'Interface Graphique** et tester notre Système !

### Interface (Touchscreen-friendly)

L’utilisateur a accès à une interface graphique tactile très simple, faite pour les écrans tactiles.

	[INTERFACE IMAGE]
    
Elle est divisée en deux parties, respectivement à gauche et à droite de l'écran :
- Une partie "Affichage" : Elle permet de consulter en temps réel la température, le taux d’humidité et la luminosité.
- Une partie "Intéraction", composée de 4 boutons :
    - Un bouton "Appel à la téléassistance", qui devrait permettre une mise en ligne immédiate avec un téléassistant
    - Un bouton "Visite", permettant d'indiquer au programme que l'utilisateur reçoit de la visite
    - Un bouton "Sortie", permettant d'indiquer au programme que l'utilisateur sort de chez lui
    - Un bouton "Paramètres", permettant d'accéder à un menu, pour diverses options

Pour les boutons "Visite" et "Sortie", il suffit à l'utilisateur d'appuyer une fois pour indiquer une sortie ou une visite (le bouton change alors de couleur)
Une fois que la sortie/visite est terminée, il suffit d'appuyer à nouveau sur le bouton, pour revenir à l'état normal (le bouton reprend alors sa couleur normale)

	[INTERFACE IMAGE 2]
    
Le bouton "Paramètres" (en haut à droite) permet d’accéder aux options suivantes :
    - Configurer la Routine
    - Redémarrer le Système
    - Arrêter le Système
    
	[INTERFACE IMAGE 3]

### Configuration de la Routine

On accède au menu de configuration en passant par le bouton "Paramètres", puis "Configurer la Routine".
Dans ce menu, les événements de la Routine sont affichés sur la gauche et classés par heure de début.

Sur le côté gauche, deux boutons permettent d'ajouter ou de supprimer les événements, un par un.

    [ROUTINE IMAGE 1]

Pour ajouter un événement, il faut remplir tous les champs requis puis appuyer sur le bouton "Valider". La liste des évènements sera alors mise à jour.
(Nous détaillerons les champs un par un plus tard, si nécessaire. Sachez qu'à terme le champ importance sera rempli automatiquement selon l'évènement)

    [ROUTINE IMAGE 2]

Pour supprimer un événement, il suffit de rentrer le numéro de l'évènement que l'on veut supprimer. La liste des évènements sera alors mise à jour.
(Le numéro est affiché à gauche de chaque évènement, sur l'interface)

    [ROUTINE IMAGE 3]

# Project Status
En l'état actuel (20/06/2017) :
- Nous sommes capables d'**établir la connexion entre l'*Arduino* et la *Raspberry* **(voir le Projet "ArduinoConnectionTest").
- Nous ne sommes pas capables d'**envoyer/recevoir des données entre ces deux appareils**.
      -> En conséquence, plusieurs morceaux de code sont commentés, et nous avons codé des "Fausses" classes et méthodes, de "Simulation".
- L' **IHM (Interface Homme Machine)** fonctionne en grande partie, même si certaines actions ne sont pas implémentées.
- Les **Capteurs & l'"IA" du Système** marchent en grande partie également, vous pourrez voir des messages l'indiquant dans la console.
- Nous n'avions pas de capteur de luminosité, nous avons donc fait en sorte de simuler la luminosité selon l'heure de la journée.
- Il n'y a pas d' **interface pour afficher les Statistiques ou l'Historique**, car nous n'avons pas encore de **Base de Données** fonctionnelle.
- Les **Alertes** ne sont pas implémentées (Alertes enovyées au Bracelet, SMS/Emails envoyés aux proches, Appel au TéléAssistant, ...).

# Informations sur le Projet

*IUT Lyon 1* - Bourg-en-Bresse - Informatique  
1ère Année - **Semaine Spéciale #2 - Sujet 2.2**  
« Assistance aux personnes en situation de dépendance »  
« Surveillance basée sur la routine »

Project réalisé par Dyvia FLEURY, Alexandre VIGNAND, Enzo CONTINI et Tom-Brian GARCIA
