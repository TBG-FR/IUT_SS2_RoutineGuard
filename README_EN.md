# /!\ WARNING : This Project is currently in Development /!\

# *RoutineGuard* [EN]

This Project aims to **help dependent persons** (elderly, for example) with technological **solutions based on a routine**, to monitor them and to analyse if everything is alright, at any time.  
It aims also in **making the communications easier in case of incident**, reducing the time between the incident and rescue intervention.  

# Technical Solutions

This projects uses mainly a *Raspberry Pi* with a *GrovePi*, an *Arduino*, and a bunch of sensors.  
The **Raspberry Pi is the core of the entire system** and it controls everything.  
It **communicates with the sensors** placed all around the house, and with the **Arduino-Bracelet** (and its sensors) that the person wears.  

# How does it work ?

The whole system use the **"Routine"** concept, that we represented with a **Day, containing Events**.  
The Routine is the **"Ideal Day"**, and the program will compare it with the **"Current Day"** to see if everything is normal.  
  
One of our goals is to connect the System (Raspberry Pi) with the Bracelet ("Arduino" Feather 32u4), in order to make them communicate.  
With such a link, we would be able to **get the Bracelet's Sensors informations** (*Beats-per-Minute*, *Interbeat Interval*, *Acceleration*) to **analyse the Health Status** of the user, but also to **send alerts** (*Vibrations*, *Light and/or Sound Signals*, *Voice*, *...*) and to **get the status of the Buttons** (as the Bracelet should have two buttons, a Red one (*Ask for Help* or *"Negative Answer"*) and a Green one (*"Positive Answer"*).

	[BRACELET IMAGE]
	
Moreover, the system contains **different sensors set in many places of the house** to garantee the user’s safety.  
There are **motion sensors** in the bedroom, the bathroom and the kitchen, and contact sensors on the fridge (to detect the beginning of a lunch), the toilets and the main entrance's door.  
  
Those differents sensors allow the system to **check wether everything happen** as it is set in the routine (which is settable) or not.  
Furthermore, the system contains a **temperature and humidity sensor** as well as **brightness sensors**, all set in the house, to act like a micro meteo station.

# How to use it ?

**IMPORTANT : From now, everything isn't working/implemented, check the "Project Status" section below !**

### Requirements :
- A *Raspberry Pi* (ours in under *Raspbian*) with *GrovePi* extension and it's *Sensors*
- An "Arduino-like" *Feather 32u4* from *Adafruit*
- A *7" TouchScreen* for *Raspberry Pi*

### Building and Launching - Instructions :
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
- **Sensors & System's "IA"** are mainly working too, you'll see the output in the command prompt.
- We did not have any brightness sensors, so we had to simulate the brightness according to the current hour.
- There isn't any **interface to see the Statistics**, as we didn't have a working **Database** yet.
- Alerts aren't implemented (Alerts sent to the Bracelet, SMS/Emails to the relatives, Call to the TeleAssistant.

# Project Informations

*IUT Lyon 1* - Bourg-en-Bresse - Computing Sciences  
1st Year - **Special Week #2 - Subject 2.2**  
« Assistance to persons in a dependent situation »  
« Routine-based monitoring » 