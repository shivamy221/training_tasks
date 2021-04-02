package task6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class CopyContentOfFile {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the source file : ");
		String sourceFile = scanner.next();
		System.out.println("Enter the destination file name : ");
		String destinationFile = scanner.next();
		
		File f1 = new File("E:/data/" + sourceFile + ".txt");
		File f2 = new File("E:/data/" + destinationFile + ".txt");
		
		if(!f1.exists()&&!f2.exists()) {
			System.out.println("Either "+sourceFile+" or "+destinationFile+" does not exits");
			System.exit(0);
		}else
			
		{
		FileInputStream fis = new FileInputStream(f1);
		FileOutputStream fos = new FileOutputStream(f2);
		
		byte b[] = new byte[100];
		fis.read(b);
		fos.write(b);
		
		System.out.println("copying successfull");
		
		fis.close();
		fos.close();	
		}
		scanner.close();
	}
	

}
