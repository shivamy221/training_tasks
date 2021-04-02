package task3;

public class Question2 {

	public static void main(String[] args) {
		String rollno[] = new String[] { "12345454", "3412434", "5633232", "787564125", "3785656" };

		int cs = 0, it = 0, mech = 0, civil = 0;

		for (int i = 0; i < rollno.length; i++) {
			for (int j = 0; j < rollno[i].length() - 1; j++) {
				String check = rollno[i].substring(j, j + 2);
				switch (check) {
				case "12":
					cs++;
					break;
				case "34":
					it++;
					break;
				case "56":
					mech++;
					break;
				case "78":
					civil++;
					break;

				}

			}
		}

		System.out.println("Total CS   : " + cs);
		System.out.println("Total Mech : " + mech);
		System.out.println("Total IT   : " + it);
		System.out.println("Total Civil: " + civil);

	}

}
