package TICTAC;





import java.util.Scanner;

public class TicTacdemo {

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      
      int player = 2;

      PlayTicTac ticTacToe = new PlayTicTac();

      ticTacToe.drawBoard();
      while (!ticTacToe.win( player))
      {
         player = setPlayer(player);

         if (player ==1)
           	System.out.print("Player " + player + " (X) choose a row and column: ");
         else System.out.print("Player " + player + " (O) choose a row and column: ");
         int row = in.nextInt()-1;
         int column = in.nextInt()-1;
         try {
            ticTacToe.choose(row, column, player);
         } catch (Exception e) {
            System.out.println(e.getMessage());
            //Changing player back
            player = setPlayer(player);
         }

         ticTacToe.drawBoard();
         
         
      }
      System.out.println("Player " + player + " wins!");
   }

   private static int setPlayer(int player) {
      if (player == 1)
      {
         player = 2;
      }
      else
      {
         player = 1;
      }
      return player;
   }

}
