package bankaccountapp;

import java.io.*;
import java.util.*;


public class BankAccountApp {
	public static void main(String args[]) {
		
		try {
			
			List<Account>accounts = new ArrayList<Account>();
			
			String s = "bank.txt";
			
			File f = new File(s);
			
			FileReader fr = new FileReader(f);
			
			int i = fr.read();
			
			String bank = "";
			
			while(i != -1) {
				bank += (char) i;
				i = fr.read();
			}
			String [] account = bank.split("\n");
			
			String number = "";
			for(int index = 0; index < account.length; index++) {
				String acc1 [] = account[index].split(",");
				for(int inner = 0; inner < acc1[3].length(); inner++) {
					if(Character.isDigit(acc1[3].charAt(inner))) {
						 number += acc1[3].charAt(inner);
					}
				}
				String name = acc1[0];
				String pin = acc1[1];
				int value = Integer.parseInt(number);
				if(acc1[2].equals( "Savings")) {
					accounts.add(new Savings(name, pin, value));
				}
				else {
					accounts.add(new Checking(name, pin, value));
				}
				number = "";
			}
	
			for(int index = 0; i < accounts.size(); index++) {
				accounts.get(index).showInfo();
				System.out.println("\n*****************************");
			}
	
		
		}
		catch(Exception e) {
			
		}
		
	}

}
