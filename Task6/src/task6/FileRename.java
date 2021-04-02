package task6;
/*Question: Write a java program that will accept 2 file
names from command line arguments. 
it will try to rename the first file and the
new name will be second one.f		

	before try to change name

	a) check for the existance of the file
	   for which you are changing name.
	
	b) check whether its a file or not.

	c) check for the existance of the second
        file.

	d) only change the names of the file
        below 500 bytes.

	e) at the end show a message that
        name of xyz file has been changed to abc.
*/
import java.io.File;
import java.util.Scanner;

public class FileRename {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter file name : ");
		String fileName = scanner.next();
		System.out.println("Enter new name : ");
		String fileRename = scanner.next();

		File f1 = new File("E:/data/" + fileName + ".txt");
		File f2 = new File("E:/data/" + fileRename + ".txt");
		if (f1.exists()) {
			if (f1.isFile()) {
				System.out.println(fileName + " is a file");
				if (!f2.exists()) {
					if (f1.length() <= 500) {
						if (f1.renameTo(f2))
							System.out.println("file " + fileName + " is renamed to " + fileRename);
						else
							System.out.println("file rename was unsuccessfull");

					} else {
						System.out.println("file is bigger than 500Bytes cannot change name.");
					}
				} else {
					System.out.println("A file with name " + fileRename + " already exists");
				}
			} else {
				System.out.println(fileName + " is a directory");
				System.out.println("Enter valid filename");
			}
		} else {
			System.out.println("File does not exists.");
		}
		scanner.close();
	}

}
