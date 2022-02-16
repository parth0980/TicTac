package combinationlock;
import java.util.Random;
import java.util.Scanner;

/**
   A test for the ComboLock class.
*/
public class ComboLockTester {
	

	
	   public static void main(String[] args)
	   {
	     

	      int secret1 = 10;//randomizer.nextInt(40);
	      int secret2 = 20;//randomizer.nextInt(40);
	      int secret3 = 30;//randomizer.nextInt(40);

	      ComboLock lock = new ComboLock(secret1, secret2, secret3);

	      Scanner in = new Scanner(System.in);
	      boolean opened = false;
	      boolean turningRight = true;
	      while (!opened)
	      {
	         System.out.println("Enter number of ticks to turn to the "
	               + (turningRight ? "right" : "left")
	               + " 0 - 39. Enter an invalid number to quit.");
	         int ticks = in.nextInt();
	         if ((ticks < 0) || (ticks > 39))
	         {
	            System.out.println("Invalid entry. The program will now exit.");
	            return;
	         }
	         if (turningRight)
	         {  lock.turnRight(ticks);  turningRight = !turningRight;}
	         
	         else
	            {lock.turnLeft(ticks);
	         turningRight = !turningRight;}
	         opened = lock.open();
	      }
	      System.out.println("You opened the lock!");
	   }
	}



