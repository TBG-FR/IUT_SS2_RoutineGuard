# /!\ ATTENTION : Ce Project est actuellement en Developpement [INSTABLE] /!\

# *RoutineGuard* [FR]

Ce Projet a pour but d'**aider les personnes en situation de dépendance** (personnes agées par exemple) avec des **solutions technologiques basées sur une routine**, pour les "surveiller" et anlyser si tout va bien, à tout moment.  
Le but est aussi de **rendre la communication plus simple en cas d'incident** et de faire en sorte que les secours arrivent plus rapidement si besoin.  

# Solutions Techniques

Le projet utilise principalement une *Raspberry Pi* avec un *GrovePi*, un *Arduino*, et une floppée de capteurs.  
La **Raspberry Pi est le coeur du système**, elle contrôle tout le reste.  
Elle **communique avec les capteurs** placés aux quatre coins de la maison, et avec l'Arduino (et ses propres capteurs) qui forme un bracelet que la personne porte.  

# Comment ça marche ?

L'ensemble du système utilise le concept de *"Routine"*, que l'on représente par une *Journée, contenant des Évènements*.
La Routine est la *"Journée Idéale"*, et le programme la comparera avec la *"Journée Actuelle"* pour voir si tout est normal.

L'un de nos buts est de connecter le Système (Raspberry Pi) avec le Bracelet ("Arduino" Feather 32u4), dans le but de les faire communiquer.  
Avec une telle liaison, nous serions capable de **récupérer les informations des Capteurs du Bracelet** (*Battements-par-Minute*, *Intervale entre deux Battements*, *Accéleration*) pour **analyser l'État de Santé** de l'utilisateur, mais aussi pour **envoyer des alertes** (*Vibrations*, *Signaux Lumineux et/ou Sonores*, *Voix*, *...*) et récupérer l'état des Boutons (le Bracelet est censé avoir deux boutons, un Rouge (*Appeller à l'Aide* ou *"Réponse Négative"*) et un Vert (*"Réponse Positive"*).

	[BRACELET IMAGE]
	
[T] Moreover, the system contains **different sensors set in many places of the house** to garantee the user’s safety.  
[T] There are **motion sensors** in the bedroom, the bathroom and the kitchen, and contact sensors on the fridge (to detect the beginning of a lunch), the toilets and the main entrance's door.  
  
[T] Those differents sensors allow the system to **check wether everything happen** as it is set in the routine (which is settable) or not.  
[T] Furthermore, the system contains a **temperature and humidity sensor** as well as **brightness sensors**, all set in the house, to act like a micro meteo station.

# Comment l'utiliser ?

**IMPORTANT : A ce jour (20/06/2017), tout n'est pas fonctionnel/implementé, jettez un oeil à la section « Statut du Projet » ci-dessous.

### Pré-requis :
- Une *Raspberry Pi* (la notre est sous *Raspbian*) avec un module *GrovePi* et ses *Capteurs*
- Un "Arduino-like" *Feather 32u4* d'*Adafruit*
- Un *Écran Tactile 7"* pour *Raspberry Pi*

### Construire et Lancer - Instructions :
1. Clonez/Téléchargez ce *Dépôt Github*
      1.5 Customisez le code pour vos propres besoins, si besoin (n'hésitez pas a nous demander de l'aide !)
2. Construisez (Build) le Projet Java "ArduinoGuard_App" (Situé ici : 'Raspberry/RoutineGuard_App/')
      2.5 Si vous ne pouvez pas construire le fichier JAR, n'hésitez pas à nous contacter, nous pouvons vous le fournir !
3. Déplacez le dossier '/dist/' dans votre *Raspberry Pi* et lancez le avec la commande "java -jar /chemin/ArduinoGuard_App.jar"
4. Tout est prêt ! Vous pouvez d"sormais **utiliser l'Interface Graphique** et tester notre Système !

### Interface (Touchscreen-friendly)

[INSERT TRANSLATED TEXT HERE]

### Routine Configuration

[INSERT TRANSLATED TEXT HERE]

# Project Status
In the current state (20/06/2017) :
- We are able to **establish a connection between the *Arduino* and the *Raspberry* **(check the "ArduinoConnectionTest" Project).
- We aren't able to **send/receive data between those two units**.
      -> In consequence, many pieces of the code are commented, and we've coded some "Simulation" classes & methods.
- The **GUI (Graphical User Interface)** mainly works, even if some actions are unimplemented.
- **Sensors & System's "IA"** are mainly working too, you'll see the output in the command prompt
- There isn't any **interface to see the Statistics**, as we didn't have a working **Database** yet.
- Alerts aren't implemented (Alerts sent to the Bracelet, SMS/Emails to the relatives, Call to the TeleAssistant

# Informations sur le Projet

*IUT Lyon 1* - Bourg-en-Bresse - Informatique  
1ère Année - **Semaine Spéciale #2 - Sujet 2.2**  
« Assistance aux personnes en situation de dépendance »  
« Surveillance basée sur la routine »  
