///*
// *
// */
//
//import java.awt.Font;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.bluetooth.DeviceClass;
//import javax.bluetooth.DiscoveryAgent;
//import javax.bluetooth.DiscoveryListener;
//import javax.bluetooth.LocalDevice;
//import javax.bluetooth.RemoteDevice;
//import javax.bluetooth.ServiceRecord;
//import javax.bluetooth.UUID;
//import javax.microedition.io.Connector;
//import javax.microedition.io.StreamConnection;
//
///**
// * @author Tom-Brian Garcia <tom-brian.garcia@etu.univ-lyon1.fr>
// * @author Dyvia Fleury <dyvia.fleury@etu.univ-lyon1.fr>
// * @author Enzo Contini <enzo.contini@etu.univ-lyon1.fr>
// * @author Alexandre Vignand <alexandre.vignand@etu.univ-lyon1.fr>
// */
//
//public class ArduinoLink {
//    
//    boolean scanFinished = false;
//    //Replace this with your bluetooth URL    
//    //String hc05Url = "btspp://d08ba54f422c:1;authenticate=false;encrypt=false;master=false";
//    //String bleUrl = "btspp://D08BA54F422C:1;authenticate=false;encrypt=false;master=false";
//    String bleUrl = "org/bluez/hci0/dev_D0_8B_A5_4F_42_2C:1;authenticate=false;encrypt=false;master=false";
//    
//    public static void main(String[] args) {
//        
//        try {
//            new ArduinoLink().go();
//        } catch (Exception ex) {
//            Logger.getLogger(ArduinoLink.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    private /*public*/ void go() throws Exception {
//        StreamConnection streamConnection = (StreamConnection)
//            //Connector.open(hc05Url);
//            Connector.open(bleUrl);
//        OutputStream os = streamConnection.openOutputStream();
//        InputStream is = streamConnection.openInputStream();
//        os.write("1".getBytes()); //'1' means ON and '0' means OFF
//        os.close();
//        byte[] b = new byte[200];
//        Thread.sleep(200);
//        is.read(b);
//        is.close();
//        streamConnection.close();
//        System.out.println("received " + new String(b));
//    }
//}