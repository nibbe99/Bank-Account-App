package bankaccountapp;

public abstract class Account implements IBaseRate{

	//List Common properties for saving and checking accounts
	private String name;
	private String sSN;
	private double balance;

	
	private static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	//Constructor to set base properties and initialize the account
	
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;
		index++;
		this.accountNumber = setAccountNumber();
		setRate();
	
	}
	
	public abstract void setRate();
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance += accruedInterest;
		System.out.println("AccruedInteret: " + accruedInterest);
		printBalance();
	}

	public void deposit(double amount) {
		balance+= amount;
		System.out.println("Depositing $: " + amount);
		printBalance();
	}
	public void withdraw(double amount) {
		balance -= amount;
		System.out.println("Withdrawing $: " + amount);
		printBalance();
	}
	public void transfer(String toWhere, double amount) {
		balance -= amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now $ " + balance);
	}
	
	public void showInfo() {
		System.out.println(""
				+ "Name: " + this.name
				+  "\nACCOUNT NUMBER: " + this.accountNumber
				+  "\nBALANCE: " + this.balance);
		
	}
	
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length()-2);
		String randomNumber = "";
		for(int i = 0; i < 3; i++) {
			int rand = (int) (10 * Math.random() + 0);
			randomNumber += rand;

		}

		return lastTwoOfSSN+index+randomNumber;
	}
	
	//deposit() witdhraw() transfer() showInfo()
	
}
