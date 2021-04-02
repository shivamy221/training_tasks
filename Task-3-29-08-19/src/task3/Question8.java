package task3;

public class Question8 {

	public static void main(String[] args) {
		String s = "India,Australia,England,Canada,UnitedStates,Japan,China";
		String tmp;
		int index = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			index = s.indexOf(',', index);
			if (index == -1)
				break;
			tmp = s.substring(i, index);
			i = index;
			index += 1;
			System.out.println(tmp);
		}

	}

}
