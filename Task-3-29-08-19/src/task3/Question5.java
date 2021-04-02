package task3;

public class Question5 {

	public static void main(String[] args) {

		String s = "this is java and java is object oriented and java is powerful. I love java language";

		int count = 0, index = 0, i = 0;
		while (i < s.length()) {
			if (index == -1)
				break;
			if (i == 0)
				System.out.print("position(s) of java : " + index);
			index = s.indexOf("java", i);
			i = index + 1;
			count++;
			System.out.print("," + index);

		}
		System.out.println("\nTotal occurance of java = " + count);

	}

}
