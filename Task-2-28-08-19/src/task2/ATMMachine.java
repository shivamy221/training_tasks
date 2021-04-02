package task2;

public class ATMMachine {

	ATMCard atmCard;				//dynamic data binding
	
	//injecting ATMcard 
	public void injectAtmCard(ATMCard atmCard) {      
		this.atmCard = atmCard;

	}

	public void balanceEnquiry() {
		if (atmCard != null) {
			this.balanceEnquiry();
		} else {
			System.out.println("please insert ATMcard");
		}
	}

	public void withdrawl() {
		if (atmCard != null) {
			this.withdrawl();
		} else {
			System.out.println("please insert ATMcard");
		}
	}

	public void deposit() {
		if (atmCard != null) {
			this.deposit();
		} else {
			System.out.println("please insert ATMcard");
		}
	}

	public void transfer() {
		if (atmCard != null) {
			this.transfer();
		} else {
			System.out.println("please insert ATMcard");
		}
	}

	public void changePin() {
		if (atmCard != null) {
			this.changePin();
		} else {
			System.out.println("please insert ATMcard");
		}
	}

	public static void main(String[] args) {
		ATMMachine atmMachine = new ATMMachine();				//instanciation of ATMMachine class
		
		atmMachine.injectAtmCard(new HDFCCard());				
		
		atmMachine.balanceEnquiry();
		atmMachine.changePin();
		
		atmMachine.injectAtmCard(new SBICard());
		atmMachine.withdrawl();
		atmMachine.deposit();
	}

}
