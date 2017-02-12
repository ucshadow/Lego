import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.MotorPort;

public class Entry
{
   
   static MotorPort leftWheel;
   static MotorPort rightWheel;
   static MotorPort sensorWheel;
   static SoundSensor soundSensor;
   
   public static void main(String[] args) {
      
      leftWheel = MotorPort.A;
      rightWheel = MotorPort.B;
      sensorWheel = MotorPort.C;
      soundSensor = new SoundSensor();
      soundSensor.searchAndDestroy();
      //LegoMovement.moveLeftWheel(1000, 100);
      
//      double angle = 180;
      
//      moveForward(1000, 100);
//      threadSleeper(1000);
//      moveBackwards(1000, 100);
//      threadSleeper(1000);
//      stopMotor();
//      
//      double formula = ((2*Math.PI*11*((angle)/360))/((Math.PI*5.6)/360));
//      int toInt = (int) formula;
//      moveForward(toInt, 100);
//      showTacho(leftWheel);
      
   }
   
   public static void showTacho(MotorPort m) {
      LCD.drawString(String.valueOf(m.getTachoCount()), 0, 0);
      Button.ENTER.waitForPressAndRelease();
   }
   
   public static void moveBackwards(int miliseconds, int thrust) {
      leftWheel.controlMotor(thrust, 2);
      rightWheel.controlMotor(thrust, 2);
      threadSleeper(miliseconds);
   }
   
   public static void moveForward(int miliseconds, int thrust) {
      leftWheel.controlMotor(thrust, 1);
      rightWheel.controlMotor(thrust, 1);
      threadSleeper(miliseconds);
   }
   
   public static void moveSensorWheel(int miliseconds, int thrust) {
      sensorWheel.controlMotor(thrust, 1);
      threadSleeper(miliseconds);
      stopSensorMother();
   }
   
   public static void stopMotor() {
      leftWheel.controlMotor(0, 3);
      rightWheel.controlMotor(0, 3);
   }
   
   public static void stopSensorMother() {
      sensorWheel.controlMotor(0, 3);
   }
   
   public static void resetTacho() {
      leftWheel.resetTachoCount();
      rightWheel.resetTachoCount();
      sensorWheel.resetTachoCount();
   }
   
   public static void threadSleeper(int miliseconds) {
      try
      {
         Thread.sleep(miliseconds);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      } 
   }
   
   public static boolean waiter(long moveTime, long startingTime) {
      while(true) {
          long current = System.currentTimeMillis();
          if(current - startingTime >= 0) {
              System.out.println("done");
              return true;
          }
      }
   }
}
