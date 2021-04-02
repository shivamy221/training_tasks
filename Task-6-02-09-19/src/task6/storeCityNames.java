package task6;
/*Question 3: Write a program to store the names of 
   cities to file. Data must be appended and not be overwritten.*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class storeCityNames {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter file name : ");
		String fileName = scanner.next();
		
		File file = new File("E:/data/" + fileName + ".txt");
		
		FileWriter fileWriter = new FileWriter(file,true);
		System.out.println("Enter no. of the cities you want to enter : ");
		int n=scanner.nextInt();
		System.out.println("Enter name of the cities : ");
		String str;
		for(int i=0;i<n;i++) {
			str=scanner.next();
			fileWriter.write(str);
		}
		
		System.out.println("Entry successfull");
		fileWriter.close();

	}

}
