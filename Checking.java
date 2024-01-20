package bankaccountapp;

public class Checking extends Account{

	//list properies specific to checking acc
	
	private int debitCardNumber;
	private int debitCardPIN;
	
	//Constructor to intialize checking account properties
	
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		this.accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println("Your Checking Account Features" +
		"\n Debit Card Number: " + debitCardNumber +
		"\n Debit Card PIN: " + debitCardPIN +
		"\n RATE: " + rate);
	}
	
	private void setDebitCard() {
		debitCardNumber = getRandomNumber(9);
		debitCardPIN = getRandomNumber(4);

		
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
		rate = getBaseRate() * 0.15;
	}
	

	// List any methods specific to the checking account
	

	
}
