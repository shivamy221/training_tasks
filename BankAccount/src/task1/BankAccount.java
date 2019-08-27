package task1;

public class BankAccount {

	// instance(non-static) variables
	long accno;
	String name;
	long accbalance;
	String acctype;

	// class(static) variables
	static int total_deposit;
	static int total_withdrawl;
	static long total_withdrawl_amount;
	static long total_deposit_amount;

	// parameterized constructor
	public BankAccount(long accno, String name, long accbalance, String acctype) {
		super();
		this.accno = accno;
		this.name = name;
		this.accbalance = accbalance;
		this.acctype = acctype;
	}

	// constructor with no parameters
	public BankAccount() {
		super();
		this.name = this.acctype = "";
	}

	// Initialize method
	public void initialization(long no, String aname, long balance, String type) {
		this.accno = no;
		this.name = aname;
		this.accbalance = balance;
		this.acctype = type;
	}

	// display account detail
	public static void displayDetail(BankAccount obj) {
		System.out.println("Account name :   " + obj.name);
		System.out.println("Account number : " + obj.accno);
		System.out.println("Account type:    " + obj.acctype);
		System.out.println("Accoutn balance: " + obj.accbalance+"\n");
	}

	// withdraw method
	public void withdraw(long withdrawl_amount) {
		if (this.accbalance < withdrawl_amount)
			System.out.println("balance not sufficient please enter smaller amount \n");
		else {
			this.accbalance = this.accbalance - withdrawl_amount;
			System.out.println("withdrawn amount : " + withdrawl_amount + ", remaining balance : " + this.accbalance+"\n");
			total_withdrawl++;
			total_withdrawl_amount += withdrawl_amount;
		}
	}

	// deposit method
	public void deposit(long deposit_amount) {
		this.accbalance += deposit_amount;
		System.out.println(deposit_amount + " deposited in your account");
		System.out.println("your current balance is : " + this.accbalance+"\n");
		total_deposit++;
		total_deposit_amount += deposit_amount;
	}

	// total transactions
	public static void totalTransaction() {
		System.out.println("Total deposits  : " + total_deposit);
		System.out.println("Total withdrawls: " + total_withdrawl+"\n");
	}

	//total deposits
	public static void displayTotalDeposit() {
		System.out.println("Total Deposites : " + total_deposit_amount+"\n");
	}

	//total withdraws
	public static void displayTotalWithdraw() {
		System.out.println("Total Withdraw : " + total_withdrawl_amount+"\n");
	}

	// average balance
	public static void avgBalance(BankAccount... v) {
		long sum = 0;
		for (BankAccount tmp : v) {
			sum += tmp.accbalance;
		}
		System.out.println("average of accounts balance : " + (sum / v.length)+"\n");
	}

	public static void main(String[] args) {
		BankAccount obj1 = new BankAccount(352441644, "Aditya", 10000, "savings"); // initialization through constructor
		BankAccount obj2 = new BankAccount();

		obj2.initialization(352441648, "krish", 20000, "savings");

		obj1.deposit(500);
		obj2.withdraw(600);

		displayDetail(obj1);
		displayDetail(obj2);

		obj2.deposit(1000);
		obj1.withdraw(250);
		
		displayTotalDeposit();
		displayTotalWithdraw();
		
		totalTransaction();
		avgBalance(obj1,obj2);
	}

}
