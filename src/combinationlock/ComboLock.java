package combinationlock;


	
	public class ComboLock
	{
	   private int secret1;
	   private int secret2;
	   private int secret3;

	  
	   private int lockState;

	   private int currentNumber;
	   private boolean validSoFar;

	   
	   public ComboLock(int secret1, int secret2, int secret3)
	   {
				this.secret1 = secret1;
				this.secret2 = secret2;
				this.secret3 = secret3;
	   }

	 
	   public void reset()
	   {
	     this.lockState = 0;
		 }
		 

	   
	   public void turnLeft(int ticks)
	   {
				int tempTracker = this.currentNumber - ticks;
				this.currentNumber = (tempTracker < 0 ) ? (39 + 1) + tempTracker : tempTracker;
				
				//check secret2
				if(this.lockState == 1) {
					checkCurrentNumAgainstSecret(this.secret2);
				}

	   }

	  
	   public void turnRight(int ticks)
	   {
				int tempTracker = this.currentNumber + ticks;
				this.currentNumber = (tempTracker > 39 ) ? tempTracker - (39 + 1) : tempTracker; 

				//check secret1
				if(this.lockState == 0) {
					checkCurrentNumAgainstSecret(this.secret1);
				} else if (this.lockState == 2 && this.validSoFar) {
					checkCurrentNumAgainstSecret(this.secret3);
				}
		 }
		
		 
		private void checkCurrentNumAgainstSecret(int secret){
			if ((this.currentNumber == secret)) {
				this.lockState ++;
				this.validSoFar = true;
			} else {
				this.validSoFar = false;
			}
		}

	 
	   public boolean open()
	   {
	      return (this.lockState == 3) ? this.validSoFar : false;
		 }
		 
		 
			public Integer getCurrentNumber() {
				return this.currentNumber;
			}

			
			public boolean getIsValidSoFar() {
				return this.validSoFar;
			}

			
			public Integer getLockState() {
				return this.lockState;
			}
	}