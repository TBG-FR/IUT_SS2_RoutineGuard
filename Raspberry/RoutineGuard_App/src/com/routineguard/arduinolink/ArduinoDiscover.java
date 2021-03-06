///*
// *
// */
//
//package com.routineguard.arduinolink;
//
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
//public class ArduinoDiscover {
//
//    boolean scanFinished = false;
//    RemoteDevice ArduinoDiscoverdevice;
//    String ArduinoDiscoverUrl;
//
//    public static void main(String[] args) {
//        try {
//            new ArduinoDiscover().go();
//        } catch (Exception ex) {
//            Logger.getLogger(ArduinoDiscover.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private /*public*/ void go() throws Exception {
//        //scan for all devices:
//        scanFinished = false;
//        LocalDevice.getLocalDevice().getDiscoveryAgent().startInquiry(DiscoveryAgent.GIAC, new DiscoveryListener() {
//            @Override
//            public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
//                try {
//                    String name = btDevice.getFriendlyName(false);
//                    System.out.format("%s (%s)\n", name, btDevice.getBluetoothAddress());
//                    if (name.matches("Adafruit Bluefruit LE")) {
//                        ArduinoDiscoverdevice = btDevice;
//                        System.out.println("[----] Device Found ! ( "+name+" : "+btDevice.getBluetoothAddress()+" )");
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void inquiryCompleted(int discType) {
//                scanFinished = true;
//            }
//
//            @Override
//            public void serviceSearchCompleted(int transID, int respCode) {
//            }
//
//            @Override
//            public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
//            }
//        });
//        while (!scanFinished) {
//            //this is easier to understand (for me) as the thread stuff examples from bluecove
//            Thread.sleep(500);
//        }
//
//        //search for services:
//        UUID uuid = new UUID(0x1101); //scan for btspp://... services (as HC-05 offers it)
//        UUID[] searchUuidSet = new UUID[]{uuid};
//        int[] attrIDs = new int[]{
//            0x0100 // service name
//        };
//        scanFinished = false;
//        LocalDevice.getLocalDevice().getDiscoveryAgent().searchServices(attrIDs, searchUuidSet,
//                ArduinoDiscoverdevice, new DiscoveryListener() {
//                    @Override
//                    public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
//                    }
//
//                    @Override
//                    public void inquiryCompleted(int discType) {
//                    }
//
//                    @Override
//                    public void serviceSearchCompleted(int transID, int respCode) {
//                        scanFinished = true;
//                    }
//
//                    @Override
//                    public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
//                        for (int i = 0; i < servRecord.length; i++) {
//                            ArduinoDiscoverUrl = servRecord[i].getConnectionURL(ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
//                            if (ArduinoDiscoverUrl != null) {
//                                break; //take the first one
//                            }
//                        }
//                    }
//                });
//
//        while (!scanFinished) {
//            Thread.sleep(500);
//        }
//
//        System.out.println(ArduinoDiscoverdevice.getBluetoothAddress());
//        System.out.println(ArduinoDiscoverUrl);
//
//        //if you know your ArduinoDiscoverUrl this is all you need:
//        StreamConnection streamConnection = (StreamConnection) Connector.open(ArduinoDiscoverUrl);
//        OutputStream os = streamConnection.openOutputStream();
//        InputStream is = streamConnection.openInputStream();
//
//        os.write("1".getBytes()); //just send '1' to the device
//        os.close();
//        is.close();
//        streamConnection.close();
//    }
//}