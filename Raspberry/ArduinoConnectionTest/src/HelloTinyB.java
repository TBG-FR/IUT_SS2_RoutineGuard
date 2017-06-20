/*
    Here we copied the "HelloTinyB.java" file content.
    "HelloTinyB" is an Java example coming from Intel's TinyB Library.
    We then adapted it for our needs and our device (Adafruit's Feather 32u4).

    * "sensor" is now "ArduinoDevice"
    * "tempService" is now "UART_Service"
*/

// Output & Input LIBS
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Bluetooth LIBS
import tinyb.*;
import java.util.*;

public class HelloTinyB {
    static boolean running = true;

    static void printDevice(BluetoothDevice device) {
        System.out.print("Address = " + getDeviceAddress(device));
        System.out.print(" Name = " + getDeviceName(device));
        System.out.print(" Connected = " + getDeviceConnected(device));
        System.out.println();
    }

    // <editor-fold desc="CODE : Divided "printDevice" original methode into 3 "submethods" ">
    
    static String getDeviceAddress(BluetoothDevice device) {        
        return device.getAddress();
    }
    static String getDeviceName(BluetoothDevice device) {
        return device.getName();
    }
    static boolean getDeviceConnected(BluetoothDevice device) {
        return device.getConnected();
    }
    
    // </editor-fold>

    /*
     * After discovery is started, new devices will be detected. We can get a list of all devices through the manager's
     * getDevices method. We can the look through the list of devices to find the device with the MAC which we provided
     * as a parameter. We continue looking until we find it, or we try 15 times (1 minutes).
     */
    static BluetoothDevice getDevice(String address) throws InterruptedException {
        BluetoothManager manager = BluetoothManager.getBluetoothManager();
        
        BluetoothDevice sensor = null;
        for (int i = 0; (i < 15) && running; ++i) {
            List<BluetoothDevice> list = manager.getDevices();
            if (list == null)
                return null;

            for (BluetoothDevice device : list) {
                //REMOVED//printDevice(device);
                /*
                 * Here we check if the address matches.
                 */
                if (device.getAddress().equals(address))
                    sensor = device;
            }

            if (sensor != null) {
                return sensor;
            }
            Thread.sleep(4000);
        }
        return null;
    }

    /*
     * Our device should expose a temperature service, which has a UUID we can find out from the data sheet. The service
     * description of the SensorTag can be found here:
     * http://processors.wiki.ti.com/images/a/a8/BLE_SensorTag_GATT_Server.pdf. The service we are looking for has the
     * short UUID AA00 which we insert into the TI Base UUID: f000XXXX-0451-4000-b000-000000000000
     */
    static BluetoothGattService getService(BluetoothDevice device, String UUID) throws InterruptedException {
        System.out.println("Services exposed by device:");
        BluetoothGattService tempService = null;
        List<BluetoothGattService> bluetoothServices = null;
        do {
            bluetoothServices = device.getServices();
            if (bluetoothServices == null)
                return null;

            for (BluetoothGattService service : bluetoothServices) {
                System.out.println("UUID: " + service.getUUID());
                if (service.getUUID().equals(UUID))
                    tempService = service;
            }
            Thread.sleep(4000);
        } while (bluetoothServices.isEmpty() && running);
        return tempService;
    }

    static BluetoothGattCharacteristic getCharacteristic(BluetoothGattService service, String UUID) {
        List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
        if (characteristics == null)
            return null;

        for (BluetoothGattCharacteristic characteristic : characteristics) {
            if (characteristic.getUUID().equals(UUID))
                return characteristic;
        }
        return null;
    }

    /*
     * This program connects to a Bluetooth Low Energy (BLE) Device.
     * The parameter provided to the program should be the MAC address of the device.
     * ------ ------ ------ ------ ------ ------ ------ ------ ------ ------ ------ ------ 
     * The API used in this example is based on TinyB v0.3, which only supports polling,
     * but v0.4 will introduce a simplied API for discovering devices and services.
     */
    public static void main(String[] args) throws InterruptedException {

        // <editor-fold desc="CODE : Bluetooth Connection to Arduino Device">
        
        if (args.length < 1) {
            System.err.println("Run with <device_address> argument");
            System.exit(-1);
        }

        /*
         * To start looking of the device, we first must initialize the TinyB library. The way of interacting with the
         * library is through the BluetoothManager. There can be only one BluetoothManager at one time, and the
         * reference to it is obtained through the getBluetoothManager method.
         */
        BluetoothManager manager = BluetoothManager.getBluetoothManager();

        /*
         * The manager will try to initialize a BluetoothAdapter if any adapter is present in the system. To initialize
         * discovery we can call startDiscovery, which will put the default adapter in discovery mode.
         */
        boolean discoveryStarted = manager.startDiscovery();

        System.out.println("The discovery started: " + (discoveryStarted ? "true" : "false"));
        
        BluetoothDevice ArduinoDevice = getDevice(args[0]);

        /*
         * After we find the device we can stop looking for other devices.
         */
        try {
            manager.stopDiscovery();
        } catch (BluetoothException e) {
            System.err.println("Discovery could not be stopped.");
        }

        if (ArduinoDevice == null) {
            System.err.println("No sensor found with the provided address.");
            System.exit(-1);
        }

        //REMOVED//System.out.print("Found device: ");
        //REMOVED//printDevice(sensor);

        if (ArduinoDevice.connect()) {
            //REMOVED//System.out.println("Sensor with the provided address connected");
            System.out.println(" ----- ----- ----- ----- ----- ");
            System.out.println("Established connection with the following device :");
            System.out.println("Name : "+getDeviceName(ArduinoDevice));
            System.out.println("Address : "+getDeviceAddress(ArduinoDevice));
            System.out.println("Connected ? : "+getDeviceConnected(ArduinoDevice));        
            System.out.println(" ----- ----- ----- ----- ----- ");
        }
        else {
            System.out.println("Could not connect device.");
            System.exit(-1);
        }
        
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="REMOVED : Original code from Intel : "Lock" things.">
        /*
        Lock lock = new ReentrantLock();
        Condition cv = lock.newCondition();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                running = false;
                lock.lock();
                try {
                    cv.signalAll();
                } finally {
                    lock.unlock();
                }

            }
        });
        */
        // </editor-fold>
        
        // <editor-fold desc="CODE : Link with UART Service and it's Characteristics">
        
        // https://learn.adafruit.com/adafruit-feather-32u4-bluefruit-le/uart-service
        BluetoothGattService UART_Service = getService(ArduinoDevice, "6e400001-b5a3-f393-e0a9-e50e24dcca9e");
        if (UART_Service == null) {
            System.err.println("Unable to find the UART Service... Can't communicate with Arduino !");
            //REMOVED//sensor.disconnect();
            System.exit(-1);
        }
        System.out.println("Service UART Service found ! (" + UART_Service.getUUID()+")");
        
        // "This characteristic is used to send data back to the sensor node"
        BluetoothGattCharacteristic TX_Write = getCharacteristic(UART_Service, "6e400002-b5a3-f393-e0a9-e50e24dcca9e");
        // "This characteristic is used to send data out to the connected Central device"
        BluetoothGattCharacteristic RX_Read = getCharacteristic(UART_Service, "6e400003-b5a3-f393-e0a9-e50e24dcca9e");
        
        if (TX_Write == null || RX_Read == null) {
            System.err.println("Error while trying to find UART_Service's caracteristics.");
            //REMOVED//ArduinoDevice.disconnect();
            System.exit(-1);
        }

        System.out.println("UART_Service caracteristics found !");
        
        // </editor-fold>

        //byte[] config = { 0x01 };
        byte[] config = { 2 };
        TX_Write.writeValue(config);
//        
//        Thread.sleep(1000);
//            
//            byte[] tempRaw = RX_Read.readValue();
//            System.out.print("Temp raw = {");
//            for (byte b : tempRaw) {
//                System.out.print(String.format("%02x,", b));
//            }
//            System.out.print("}");
        

//            while (running) {
//            
//            byte[] tempRaw = RX_Read.readValue();
//            System.out.print("Temp raw = {");
//            for (byte b : tempRaw) {
//                System.out.print(String.format("%02x,", b));
//            }
//            System.out.print("}");
//            }


//        /*
//         * Turn on the Temperature Service by writing 1 in the configuration characteristic, as mentioned in the PDF
//         * mentioned above. We could also modify the update interval, by writing in the period characteristic, but the
//         * default 1s is good enough for our purposes.
//         */
//        byte[] config = { 0x01 };
//        tempConfig.writeValue(config);
//
//        /*
//         * Each second read the value characteristic and display it in a human readable format.
//         */
//        while (running) {
//            byte[] tempRaw = tempValue.readValue();
//            System.out.print("Temp raw = {");
//            for (byte b : tempRaw) {
//                System.out.print(String.format("%02x,", b));
//            }
//            System.out.print("}");
//
//            /*
//             * The temperature service returns the data in an encoded format which can be found in the wiki. Convert the
//             * raw temperature format to celsius and print it. Conversion for object temperature depends on ambient
//             * according to wiki, but assume result is good enough for our purposes without conversion.
//             */
//            int objectTempRaw = (tempRaw[0] & 0xff) | (tempRaw[1] << 8);
//            int ambientTempRaw = (tempRaw[2] & 0xff) | (tempRaw[3] << 8);
//
//            float objectTempCelsius = convertCelsius(objectTempRaw);
//            float ambientTempCelsius = convertCelsius(ambientTempRaw);
//
//            System.out.println(
//                    String.format(" Temp: Object = %fC, Ambient = %fC", objectTempCelsius, ambientTempCelsius));
//
//            lock.lock();
//            try {
//                cv.await(1, TimeUnit.SECONDS);
//            } finally {
//                lock.unlock();
//            }
//        }
//        sensor.disconnect();

    }
}
