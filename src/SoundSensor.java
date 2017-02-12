import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.objectdetection.RangeFeatureDetector;


public class SoundSensor implements FeatureListener {
   
   private int scanPeriod = 600;
   
   public void searchAndDestroy() {   
      SoundSensor listener = new SoundSensor();
      int maxDistance = 80;
      scanPeriod = 600;
      UltrasonicSensor us = new UltrasonicSensor(SensorPort.S1);
      RangeFeatureDetector fd = new RangeFeatureDetector(us, maxDistance, scanPeriod);
      fd.addListener(listener);
      System.out.println("press any button");
      Button.ENTER.waitForPressAndRelease();      
      
   }
   
   
   
   public void featureDetected(Feature feature, FeatureDetector detector) {
      
      int range = (int)feature.getRangeReading().getRange();
      
      if(detector.scan() != null) {
         System.out.println("Range:" + range);
         if(range <= 30) {
            System.out.println("Range:" + range);
         }
      }
      
//      if(detector.scan() != null && range <= 30) {         
//         Sound.playTone(1200 - (range * 10), 70);
//         System.out.println("Range:" + range);
//         try
//         {
//            Thread.sleep(2000000);
//         }
//         catch (InterruptedException e)
//         {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//         }
//      } 
//      else if (detector.scan() != null && range > 30) {
//         LegoMovement.moveLeftWheel(500, 70);
//         System.out.println("Range:" + range + ", turning...");
//      } else {
//         // no object in range, turn around
//         LegoMovement.moveLeftWheel(500, 70);
//         System.out.println("no senosr data!");
//      }
   }
}
