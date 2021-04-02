package task6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;
import java.util.Scanner;

public class MergeSplitted {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1st file Name.");
		String fileName1 = scanner.next();
		System.out.println("Enter 1st file Name.");
		String fileName2 = scanner.next();
		
		File file1 = new File("E:/data/" + fileName1 + ".txt");
		File file2 = new File("E:/data/" + fileName2 + ".txt");
		
		FileInputStream fis1 = new FileInputStream(file1);
		FileInputStream fis2 = new FileInputStream(file2);
		
		File folder = new File("E:/data/mergefolder");
		boolean folderCheck = folder.mkdir();
		if(!folderCheck) {
			System.out.println("Folder creation was unsuccessfull ");
		}
		else
		{	
			File file = new File("E:/data/mergefolder/merge.txt");
			boolean check = file.createNewFile();
			if(!check)
				System.out.println("file not created");
			else
			{
				FileOutputStream fos = new FileOutputStream(file);
				SequenceInputStream sos = new SequenceInputStream(fis1,fis2);
			
				byte b[] = new byte[100];
				sos.read(b);
				fos.write(b);
				System.out.println("Merge file succesfully created in "+folder+" with name "+file);
				
			}
		
		}
		
		fis1.close();
		fis2.close();

	}

}
