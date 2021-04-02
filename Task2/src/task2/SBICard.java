package task2;

public class SBICard implements ATMCard {

	@Override
	public void balanceEnquiry() {
		System.out.println("Showing balance : ");
	}

	@Override
	public void withdrawl() {
		System.out.println("withdrawal done");

	}

	@Override
	public void deposit() {
		System.out.println("Deopsited in account");

	}

	@Override
	public void transfer() {
		System.out.println("transferd the amount");

	}

	@Override
	public void changePin() {
		System.out.println("pin changed");

	}

}
