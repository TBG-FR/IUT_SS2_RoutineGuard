# /!\ WARNING : Project currently in Development [INSTABLE] /!\

# *RoutineGuard* [**EN**]

This Project aims to **help dependent persons** (elderly, for example) with **technological solutions based on a routine**, to keep an eye on them and to analyse if everything is alright, at any time.  
It aims also in **making the communications easier in case of incident** and ensuring that the emergency services will be there faster if needed.  

# Technical Solutions

This projects uses mainly a *Raspberry Pi* with a *GrovePi*, an *Arduino*, and a fleet of various sensors.  
The **Raspberry Pi is the core of the entire system**, it controls everything else.  
It **communicates with the sensors** placed all around the house, and with the **Arduino** (and its own sensors) which makes a Bracelet that the person wears.  

# How does it work ?

The whole system use the **"Routine"** concept, that we represented with a **Day, containing Events**.  
The Routine is the **"Ideal Day"**, and the program will compare it with the **"Current Day"** to see if everything is normal.  
  
One of our goals is to connect the System (Raspberry Pi) with the Bracelet ("Arduino" Feather 32u4), in order to make them communicate.  
With such a link, we would be able to **get the Bracelet's Sensors informations** (*Beats-per-Minute*, *Interbeat Interval*, *Acceleration*) to **analyse the Health Status** of the user, but also to **send alerts** (*Vibrations*, *Light and/or Sound Signals*, *Voice*, *...*) and to **get the status of the Buttons** (as the Bracelet should have two buttons, a Red one (*Ask for Help* or *"Negative Answer"*) and a Green one (*"Positive Answer"*).

	[BRACELET IMAGE]
	
Moreover, the system contains **different sensors set in many places of the house** to guarantee the user’s safety.  
There are **motion sensors** in the bedroom, the bathroom and the kitchen, as well as **contact sensors** on the fridge (to detect the beginning of a lunch), the toilets and the main entrance's door.  
  
Those differents sensors allow the System to **check wether everything happen** as it is set in the Routine (which is settable) or not.  
Furthermore, the system also contains a **temperature and humidity sensor** as well as **brightness sensors**, all set in the house, to act like a home weather station.

# How to use it ?

**IMPORTANT : To this day (20/06/2017), everything isn't working/implemented, check the "Project Status" section below !**

### Requirements :
- A *Raspberry Pi* (ours in under *Raspbian*) with *GrovePi* extension and it's *Sensors*
- An "Arduino-like" *Feather 32u4* from *Adafruit*
- A *7" TouchScreen* for *Raspberry Pi*

### Building and Launching - Instructions :
1. Clone/Download this *Github Repository*
      1.5 Customize the code for your own needs, if needed (feel free to ask for help !)
2. Build the Java Project "RoutineGuard_App" (Located here : 'Raspberry/RoutineGuard_App/')
      2.5 If you can't build the JAR file, feel free to contact us, we can provide it !
3. Move the generated '/dist/' folder into your *Raspberry Pi* and start it with "java -jar /path/RoutineGuard_App.jar"
4. You're all set ! You can now **use the Graphical Interface** and test our System !

### Interface (Touchscreen-friendly)

The user can access to a very simple interface, made for touchscreens.

![alt text][Interface1]
    
It is divided in two major parts, respectively to the left and to the right sides of the screen :
- A "Display" part : It allows to view in real time the temperature, the humidity rate and the luminosity.
- An "Interaction" part, made of 4 buttons :
    - A "Helpline Call" button, which should allow an immediate online linking with a Helpline Operator
    - A "Visit" button, allowing to tell the program that the user is currently visited
    - Un "Outing" button, allowing to tell the program that the user is currently out of his home
    - Un "Settings" button, allowing the access to a menu, for various options

For the "Visit" and "Outing" buttons, the user only have to push once to indicate an outing or a visit (the button's color then changes)
When the outing/visit is ended, another push permit to gets back to the normal state (the button takes back its color)

![alt text][Interface2]
    
The "Settings" button (located in the top right of the screen) allows access to the following options :
    - Routine Configuration
    - Reboot the System
    - Shutdown the System
    
![alt text][Settings]

### Routine Configuration

To access this menu, you need to click on the "Settings" button, and then on "Routine Configuration".
In this menu, Routine's events are displayed ont the left, organized by beginning hour.

On the left side, two buttons allows to add or remove events, one by one.

![alt text][Routine1]

In order to add and event, one needs to fill in all the required fields, and then to push the button "Validate". The list will then be updated.
(We'll explain the fields one by one later, if required. Know that in the end the "importance" field we'll be automatically filled, depending on the event)

![alt text][Routine2]

In order to remove an event, one only needs to put the event's number that should be deleted. The list will then be updated.
(The number is displayed on the left of each event, on the interface)

![alt text][Routine3]

# Project Status
In the current state (20/06/2017) :
- We are able to **establish a connection between the *Arduino* and the *Raspberry* **(check the "ArduinoConnectionTest" Project).
- We aren't able to **send/receive data between those two units**.
      -> In consequence, many pieces of the code are commented, and we've coded some "Simulation/Fake" classes & methods.
- The **GUI (Graphical User Interface)** mainly works, even if some actions are unimplemented.
- **Sensors & System's "IA"** are mainly working too, you'll see the output in the command prompt.
- We did not have any brightness sensors, so we had to simulate the brightness according to the current hour.
- There isn't any **interface to display the Statistics or the History**, as we didn't have a working **Database** yet.
- **Alerts** aren't implemented (Alerts sent to the Bracelet, SMS/Emails sent to the relatives, Call to the Helpline Operator, ...).

# Project Informations

*IUT Lyon 1* - Bourg-en-Bresse - Computing Sciences  
1st Year - **Special Week #2 - Subject 2.2**  
" Assistance to persons in a dependent situation "
" Routine-based monitoring "

Project made by Dyvia FLEURY, Alexandre VIGNAND, Enzo CONTINI and Tom-Brian GARCIA

[Interface1]: https://github.com/TBG-FR/RoutineGuard/raw/master/src/docs/images/Interface_1.png "Graphical Interface"
[Interface2]: https://github.com/TBG-FR/RoutineGuard/raw/master/src/docs/images/Interface_2.png "Visit Button ON"
[Interface3]: https://github.com/TBG-FR/RoutineGuard/raw/master/src/docs/images/Interface_3.png "Outing Button ON"
[Settings]: https://github.com/TBG-FR/RoutineGuard/raw/master/src/docs/images/Settings.png "Settings Menu"
[Routine1]: https://github.com/TBG-FR/RoutineGuard/raw/master/src/docs/images/Routine_Display.png "Routine Menu"
[Routine2]: https://github.com/TBG-FR/RoutineGuard/raw/master/src/docs/images/Routine_Add.png "Routine : Add Event"
[Routine3]: https://github.com/TBG-FR/RoutineGuard/raw/master/src/docs/images/Routine_Remove.png "Routine : Remove Event"

https://github.com/TBG-FR/RoutineGuard/raw/master/src/docs/images/Routine_Remove.png "Logo Title Text 2"
https://raw.githubusercontent.com/TBG-FR/RoutineGuard/master/docs/images/Routine_Remove.png