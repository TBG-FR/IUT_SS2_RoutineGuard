# /!\ WARNING : This Project is currently in Development /!\

# *RoutineGuard* [EN]

Project aiming to **help dependent persons** (elderly, for example) with technological **solutions based on a routine**, to monitor them and to analyse if everything is alright, at any time.  
It aims also in **making the communications easier in case of incident**, reducing the time between the incident and rescue intervention.  

# Technical Solutions

This projects uses mainly a *Raspberry Pi* with a *GrovePi*, an *Arduino*, and a bunch of sensors. The Raspberry Pi controls everything, it's the core of the entire system.  
It communicates with the sensors placed all around the house, and with the Arduino (and its dedicated sensors) which makes a bracelet that the person wears.  

# How Does it Work ?

The whole system use the "Routine" concept, that we represented with a Day, containing Events.  
The Routine is the "Ideal Day", and the program will compare it with the "Current Day" to see if everything is normal.  
  
One of our goals is to connect the System (Raspberry Pi) with the Bracelet ("Arduino" Feather 32u4), in order to make them communicate.  
With such a link, we would be able to get the Bracelet's Sensors informations (Beats-per-Minute, Interbeat Interval, Acceleration) to analyse the Health Status of the user, but also to send alerts (Vibrations, Light and/or Sound Signals, Voice, ...) and to get the status of the Buttons (as the Bracelet should have two buttons, a Red one (Ask for Help or "Negative Answer") and a Green one ("Positive Answer").
 
# How to Use ?

**IMPORTANT : From now, everything isn't working/implemented, check the "Project Status" section below !**

### Requirements :
- A *Raspberry Pi* (ours in under *Raspbian*) with *GrovePi* extension and it's *Sensors*
- An "Arduino-like" *Feather 32u4* from *Adafruit*
- A *7" TouchScreen* for *Raspberry Pi*

### Building and Launching Instructions :
1. Clone/Download this *Github Repository*
      1.5 Customize the code for your own needs, if needed (feel free to ask for help !)
2. Build the Java Project "ArduinoGuard_App" (Located here : 'Raspberry/RoutineGuard_App/')
      2.5 If you can't build the JAR file, feel free to contact us, we can provite it !
3. Move the '/dist/' folder into your *Raspberry Pi* and start it with "java -jar /path/ArduinoGuard_App.jar"
4. You're all set ! You can now **use the Graphical Interface** and test our System !

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

# Project Informations

*IUT Lyon 1* - Bourg-en-Bresse - Computing Sciences  
1st Year - **Special Week #2 - Subject 2.2**  
« Assistance to persons in a dependent situation »  
« Routine-based monitoring »  

______________________________________________

# /!\ ATTENTION : Ce Project est actuellement en Developpement [INSTABLE] /!\

# *RoutineGuard* [FR]

Projet ayant pour but d'**aider les personnes en situation de dépendance** (personnes agées par exemple) avec des **solutions technologiques basées sur une routine**, pour les "surveiller" et anlyser si tout va bien, à tout moment.  
Le but est aussi de **rendre la communication plus simple en cas d'incident** et de faire en sorte que les secours arrivent plus rapidement si besoin.  

# Solutions Techniques

Le projet utilise principalement une *Raspberry Pi* avec un *GrovePi*, un *Arduino*, et une floppée de capteurs. La Raspberry Pi contrôle tout le reste, c'est le coeur du système.  
Elle communique avec les capteurs placés aux quatre coins de la maison, et avec l'Arduino (et ses propres capteurs) qui forme un bracelet que la personne porte.  

# Comment ça marche ?

L'ensemble du système utilise le concept de "Routine", que l'on représente par une Journée, contenant des Évènements.
La Routine est la "Journée Idéale", et le programme la comparera avec la "Journée Actuelle" pour voir si tout est normal.

L'un de nos buts est de connecter le Système (Raspberry Pi) avec le Bracelet ("Arduino" Feather 32u4), dans le but de les faire communiquer.  
Avec une telle liaison, nous serions capable de récupérer les informations des Capteurs du Bracelet (Battements-par-Minute, Intervale entre deux Battements, Accéleration) pour analyser l'État de Santé de l'utilisateur, mais aussi pour envoyer des alertes (Vibrations, Signaux Lumineux et/ou Sonores, Voix, ...) et récupérer l'état des Boutons (le Bracelet est censé avoir deux boutons, un Rouge (Appeller à l'Aide ou "Réponse Négative") et un Vert ("Réponse Positive").

# Comment l'utiliser ?

# Informations sur le Projet

*IUT Lyon 1* - Bourg-en-Bresse - Informatique  
1ère Année - **Semaine Spéciale #2 - Sujet 2.2**  
« Assistance aux personnes en situation de dépendance »  
« Surveillance basée sur la routine »  
