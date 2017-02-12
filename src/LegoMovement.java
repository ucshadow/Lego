import lejos.nxt.MotorPort;

public class LegoMovement {
   
   static MotorPort leftWheel = MotorPort.A;;
   static MotorPort rightWheel = MotorPort.B;;
   
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
   
   public static void moveLeftWheel(int miliseconds, int thrust) {
      new Thread() {
         public void run() {
            leftWheel.controlMotor(thrust, 1);
            //threadSleeper(miliseconds);
            try
            {
               Thread.sleep(miliseconds);
            }
            catch (InterruptedException e)
            {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         }
      }.start();
   }
   
   public static void moveRightWheel(int miliseconds, int thrust) {
      rightWheel.controlMotor(thrust, 1);
      threadSleeper(miliseconds);
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

}
