package app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;


public class Motors extends Thread {
  
    static EV3LargeRegulatedMotor motorA = new EV3LargeRegulatedMotor(MotorPort.A);
    static EV3LargeRegulatedMotor motorD = new EV3LargeRegulatedMotor(MotorPort.D);

    static int getMotorSpeedFromServer() {
        URL url = null;
        HttpURLConnection conn = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String s = null;
        try {
            url = new URL("http://192.168.0.111:8180/rest/tadaa/tuduu");
            conn = (HttpURLConnection) url.openConnection();
            InputStream is = null;
            try {
                is = conn.getInputStream();
            } catch (Exception e) {
                System.out.println("Exception conn.getInputSteam()");
                e.printStackTrace();
                System.out.println("Cannot get InputStream!");
            }
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            s = br.readLine();

            return Integer.parseInt(s);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some problem!");
            return 0;
        }
    }
    public static void run6(float output) {
//      while (true) {
        int speedA = getMotorSpeedFromServer();

      Motors.motorA.setSpeed(speedA + output);
      Motors.motorD.setSpeed(speedA - output);
      Motors.motorA.forward();
      Motors.motorD.forward();
//      }
      }

//    public EV3LargeRegulatedMotor getMotorA() {
//        return motorA;
//      }
//
//      public EV3LargeRegulatedMotor getMotorD() {
//        return motorD;
//      }

//      public static void run1() {
//        motorA.setSpeed(200);
//        motorD.setSpeed(100);
//        motorA.forward();
//        motorD.forward();
//      }
//
//      public static void run2() {
//        motorA.setSpeed(100);
//        motorD.setSpeed(200);
//        motorA.forward();
//        motorD.forward();
//      }
//
//      public static void run3() {
//        motorA.stop();
//        motorD.stop();
//        Delay.msDelay(1);
//        motorA.setSpeed(90);
//        motorD.setSpeed(90);
//        motorA.backward();
//        motorD.forward();
//        Delay.msDelay(1000);
//        motorA.setSpeed(250);
//        motorD.setSpeed(150);
//        motorA.forward();
//        motorD.forward();
//        Delay.msDelay(100);
//      }
//
//      public static void run4() {
//        motorA.stop();
//        motorD.stop();
//        Delay.msDelay(100);
//      }
//
//      public static void run5() {
//        motorA.setSpeed(500);
//        motorD.setSpeed(100);
//        motorA.forward();
//        motorD.backward();
//
//      }
//
//      public static void run7() {
//          motorA.setSpeed(50);
//          motorD.setSpeed(50);
//          motorA.backward();
//          motorD.forward();
//          Delay.msDelay(10);
//      }
    }