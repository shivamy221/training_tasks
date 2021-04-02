package task3;

public class Question7 {

	public static void main(String[] args) {
		String str = "hye! aditya mob No. is 9536485 email xyww@gmail.com";
		int smallAlphabets = 0;
		int capitalAlphabets = 0;
		int digits = 0;
		int symbols = 0;
		int spaces = 0;

		for (int i = 0; i < str.length(); i++) {
			int asci = (int) str.charAt(i);
			if (asci >= 65 && asci <= 90)
				capitalAlphabets++;
			else if (asci >= 97 && asci <= 123)
				smallAlphabets++;
			else if (asci >= 48 && asci <= 57)
				digits++;
			else if (asci == ' ')
				spaces++;
			else
				symbols++;

		}
		System.out.println("No. of Small Alphabets = " + smallAlphabets);
		System.out.println("No. of Capital Alphabets = " + capitalAlphabets);
		System.out.println("No. of Digits = " + digits);
		System.out.println("No. of Symbols = " + symbols);
		System.out.println("No. of Spaces = " + spaces);
	}

}
