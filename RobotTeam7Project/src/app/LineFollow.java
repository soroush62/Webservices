package app;

import lejos.hardware.Button;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;


import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;


public class LineFollow implements Runnable {

  static float lastReading = 0;
  static float distance = 0;
  static long startTime = System.currentTimeMillis();

public LineFollow() {
	// TODO Auto-generated constructor stub
}

//  private static void sendMileage(float mileage, long duration) {
  private static void sendMileage(float mileage, long duration) {
      HttpURLConnection conn = null;

      try {
          URL url = new URL("http://192.168.0.111:8180/rest/motor/mileage/"+ mileage + "/" + duration);
          conn = (HttpURLConnection)url.openConnection();
          conn.setDoOutput(true);  
          int responseCode = conn.getResponseCode();
          System.out.println("Response Code: " + responseCode);
      } catch (IOException e) {
          System.out.println("Error sending mileage data: " + e.getMessage());
      }
  }


  EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
  SampleProvider colorProvider = colorSensor.getRedMode();
  float[] sample = new float[colorProvider.sampleSize()];
  
  static final float KP =500.0f;
	static final float KD = 30.0f;
	static final float KI = 0.000001f;
	float integral = 0;
	float lastError = 0;

  @Override
  public void run() {
    while (true) {

		colorProvider.fetchSample(sample, 0);
		float redValue = sample[0];

		// Calculate PID control output
		float error = 0.13f - redValue;
		integral += error;
		float derivative = error - lastError;
		lastError = error;
		float output = KP * error + KI * integral + KD * derivative;
		
        Motors.run6(output);


	    
      if (Button.DOWN.isDown()) {
    	  int NewSpeed = Motors.getMotorSpeedFromServer();
    	// Calculate distance and duration
          float x = (float) (NewSpeed*Math.PI*5.5/360);
          long duration = System.currentTimeMillis() - startTime;
          float mileage = x*(duration/1000);
          // Send mileage data
          sendMileage(mileage, duration/1000);

          // Update lastReading and startTime
//          lastReading = currentReading;
          startTime = System.currentTimeMillis();
      }
    	
      }
    }
  }
