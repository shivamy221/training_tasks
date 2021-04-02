package task3;

public class Question4 {

	public static void main(String[] args) {

		String cities[] = new String[] { "bhopal", "agra", "mumbai", "chennai", "pune", "delhi", "indore" };

		for (int i = 0; i < cities.length; i++) {
			for (int j = i + 1; j < cities.length; j++) {
				if (cities[i].compareTo(cities[j]) > 0) {
					String tmp = cities[i];
					cities[i] = cities[j];
					cities[j] = tmp;
				}
			}
		}
		for (String i : cities)
			System.out.println(i);
	}

}
