package Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) throws Exception{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("1.New Game ");
		System.out.println("2.Load Previous Game ");
		
		int choice=sc.nextInt();
		
		Game3d g3d;

		if(choice==1)
		{
			g3d=new Game3d();
						
			System.out.println("\nEnter Horizontal Move ");
			int x=sc.nextInt();
			g3d.xMove(x);
			
			System.out.println("\nEnter Vertical Move ");
			int y=sc.nextInt();
			g3d.yMove(y);
			
			System.out.println("\nEnter Z Direction Move ");
			int z=sc.nextInt();
			g3d.zMove(z);
			
			System.out.println("X-Move "+g3d.xPos+" Y-Move "+g3d.yPos+" Z-Move "+g3d.zPos);
			
			File f=new File("F:/javatask/Serialize.txt");
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(g3d);
			System.out.println("\nGame Loaded");
			
			fos.close();
			oos.close();
		}
		
		else
		{
			FileInputStream fis=new FileInputStream("F:/javatask/Serialize.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			g3d = (Game3d) ois.readObject();
			
			
			System.out.println("\nEnter Horizontal Move ");
			int x=sc.nextInt();
			g3d.xMove(x);
			
			System.out.println("\nEnter Vertical Move ");
			int y=sc.nextInt();
			g3d.yMove(y);
			
			System.out.println("\nEnter Z Direction Move ");
			int z=sc.nextInt();
			g3d.zMove(z);
			
			System.out.println("X-Move "+g3d.xPos+" Y-Move "+g3d.yPos+" Z-Move "+g3d.zPos);
			
			File f=new File("F:/javatask/Serialize.txt");
			FileOutputStream fos=new FileOutputStream(f);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(g3d);
			
			System.out.println("\nGame Loaded");
			
			fos.close();
			oos.close();
			
			fis.close();
			ois.close();
		}
		
		System.out.println("\nGame Exit");
		
		sc.close();
		
		
		
	}

}
