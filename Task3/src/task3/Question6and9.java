package task3;

public class Question6and9 {

	public static void main(String[] args) {

		// without using string buffer
		System.out.println("Checked without using String buffer");
		String word = "malayalam";
		char wordArray[] = word.toCharArray();
		int halfLength = (wordArray.length) / 2;
		int backCount = wordArray.length - 1;
		boolean flag = true;
		for (int i = 0; i <= halfLength; i++) {
			if (wordArray[i] != wordArray[backCount])
				flag = false;
			if (flag)
				break;
			backCount = backCount - 1;
		}
		if (flag)
			System.out.println("word is palindrome ");
		else
			System.out.println("word is not palindrome");

		// using string buffer
		System.out.println("------------------------------------------------------");
		System.out.println("Checked using String buffer");
		StringBuffer bWord = new StringBuffer(word);
		String reverseWord = bWord.reverse().toString();
		if (reverseWord.equals(word))
			System.out.println("word is palindrome");
		else
			System.out.println("word is not palindrome");
	}

}
