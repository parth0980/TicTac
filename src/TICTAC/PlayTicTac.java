
package TICTAC;

public class PlayTicTac {
	
	
	 
	  private int[][] board;
		
	   public PlayTicTac() {
		   this.board = new int[3][3];
	   }
	   
	 
	   private boolean wonDiagonal( int player)
	   {
			boolean resultMaj = true;
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++) {
					if(i == j && resultMaj) {
						resultMaj = (this.board[i][j] == player) ? true : false;
					}
				}
			}
			
			boolean resultMin = true;
			for(int i = 3; i >= 0; i--){
				for(int j = 3; j >= 0; j--) {
					if((i + j) == (3 - 1) && resultMin) {
						resultMin = (this.board[i][j] == player) ? true : false;
					}
				}
			}
			return (resultMaj || resultMin) ? true : false;
	   }

	
	   private boolean wonStraightLines( int player)
	   {
			boolean result = true;
			int i = 0;
			do{
				//horizontal
				for(int j = 0; j < 3; j++) {
					if(result) {
						result = (this.board[i][j] == player) ? true : false;
					}
				}
				//if no match with horizontal, try vertical
				if(!result){
					//vertical
					result = true;
					for(int j = 0; j < 3; j++) {
						if(result){
							result = (this.board[j][i] == player) ? true : false;
						}
					}
				}
				i++;
			}while(!result && i < 3);
			return result;
	   }

	  
	   public boolean win(int player)
	   {
	    return (this.wonDiagonal(player) || this.wonStraightLines(player)) ? true : false;
	   }

	   /**
	      Draws gameboard, player 1 is X, player 2 is O.
	   */
	   public void drawBoard()
	   {
	      System.out.println("|-----|");
	      for (int i = 0; i < 3; i++)
	      {
	         for (int j = 0; j < 3; j++)
	         {
	            if (board[i][j] == 1)
	            {
	               System.out.print("|X");
	            }
	            else if (board[i][j] == 2)
	            {
	               System.out.print("|O");
	            }
	            else
	            {
	               System.out.print("| ");
	            }
	         }
	         System.out.println("|\n|-----|");
	      }
	   }
	   
	  
	   
	   public void choose(int r, int c, int player) throws UnavailableCellException,ArrayOutOfBoundException {
			if( r > 2 || c > 2) {
				throw  new ArrayOutOfBoundException();
			}
			else if(this.board[r][c] == 0) { 
				this.board[r][c] = player;
			} else {
				throw new UnavailableCellException("Cell is already occupied");
			}
		   
	   }	}