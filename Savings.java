package bankaccountapp;

public class Savings extends Account{

		//list properies specific to savings acc
	
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
		//Constructor to intialize savings account properties
	
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		this.accountNumber = "1" + accountNumber;
		setSafetyDepositBox();

	}
	
	private void setSafetyDepositBox() {
		safetyDepositBoxID = getRandomNumber(3);
		safetyDepositBoxKey = getRandomNumber(4);
}
	
	private int getRandomNumber(int amount) {
		String randomNumber = "";
		for(int i = 0; i < amount; i++) {
			int rand = (int) (10 * Math.random() + 0);
			while(i == 0 && rand == 0) 
				rand = (int) (10 * Math.random() + 0);
			randomNumber += rand;	
		}
		return Integer.parseInt(randomNumber);
	}
	
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Yuor Savings Account Features: "+
							"\n Safety Deposit Box ID: " + safetyDepositBoxID + 
							"\n Safety Deposit Box KEY: " + safetyDepositBoxKey +
							"\n RATE: " + rate);
	}
		
		// List any methods specific to the savings account
	
}
