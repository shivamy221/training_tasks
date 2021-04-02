package task3;

import java.util.StringTokenizer;

public class Question11 {

	public static void main(String[] args) {
		
		String s ="1.java,2.oracle,3.python,4.php,5.linux,6.javascipt,7.c++";
		StringTokenizer str = new StringTokenizer(s,"0123456789,.");
		while(str.hasMoreTokens())
		{
			System.out.println(str.nextToken());
		}
	}

}
