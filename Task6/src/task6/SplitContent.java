package task6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*Question 4: Write a program to split the contents of
a file in multiple files.

	java SplitData data.txt 4

	datasplit
	data1.txt, data2.txt, data3.txt,data4.txt
*/
public class SplitContent {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter File Name: ");
		String fileName=scanner.next();
		
		System.out.println("Enter Split Number: ");
		int n=scanner.nextInt();
		
		File f=new File("E:/data/" + fileName + ".txt");
		
		if(f.exists())
		{
			FileInputStream fis=new FileInputStream(f);
			byte b[]=new byte[fis.available()];
			while(fis.available()>0)
			{
				fis.read(b);
				
			}
			fis.close();
			String res=new String(b);
			
			ArrayList<String> list=new ArrayList<>();
			int split=res.length()/n;
			int start=0;
			int end=split;
			
			for(int i=0;i<n-1;i++)
			{
				list.add(res.substring(start,end));
				start=end;
				end+=split;
			}
			
			String last=res.substring(start,res.length());
			list.add(last);
			
			File folder=new File("f:/javatask/splitFil");
			if(!folder.exists())
			folder.mkdir();
			
			
				for(int i=1;i<=n;i++)
				{
					String file="E:/data/" + fileName +i+ ".txt";
					System.out.println(file);
					FileOutputStream fos=new FileOutputStream(file);
					fos.write(list.get(i-1).getBytes());
					fos.close();
					
					
				}
				System.out.println("File splitted");
			
			}
			
			
			
			else
			{
				System.out.println("File does not exists");
			}
		
		scanner.close();
		
		
	}

}
