package task6;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class DeletAfterShow {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter name of file ");
		String fileName = scanner.next();
		try{
			
			File file = new File("E:/data/" + fileName + ".txt");
			FileInputStream fis = new FileInputStream(file);
		
			byte b[] = new byte[fis.available()];
			fis.read(b);
		
			String show = new String(b);
			System.out.println(show);
		
			if(file.delete()) {
				System.out.println("file successfully deleted");
			
			}
			else
			{
				System.out.println("file deletion unsuccessfull");
			}
			fis.close();
		}
		catch(Exception e)
		{
			System.out.println("something went wrong"+e);
		}
		
		scanner.close();
	}
	

}
