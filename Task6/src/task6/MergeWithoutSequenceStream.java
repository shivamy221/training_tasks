package task6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class MergeWithoutSequenceStream {

	public static void main(String[] args) throws Exception {

		Scanner scanner=new Scanner(System.in);
		System.out.println("\nEnter Folder Name");
		
		String folderName=scanner.next();
		
		System.out.println("\nEnter Target file");
		String fileName=scanner.next();
		
		File f=new File("E:/data/" + folderName + ".txt");
		
		if(f.isDirectory())
		{
			File files[] = f.listFiles();
			Arrays.sort(files);
			StringBuffer sb=new StringBuffer();
			
			for(File file:files)
			{
				FileInputStream fis=new FileInputStream(file);
				byte b[]=new byte[fis.available()];
				while(fis.available()>0)
				{
					fis.read(b);
					
				}
				
				sb.append(new StringBuffer(new String(b)));
				fis.close();
			}
			
			FileOutputStream fos=new FileOutputStream("E:/data/" + fileName + ".txt");
			fos.write(sb.toString().getBytes());
			System.out.println("File Merged Successfully");
			
			fos.close();
			}
		else
			System.out.println("Given folder either doesnot exist or is not a directory");
		
		
		scanner.close();
		}


}
