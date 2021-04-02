package task3;

import java.util.StringTokenizer;

public class Question10 {

	public static void main(String[] args) {
		
		String s="ad3daddfd5443dfsfss";
		StringTokenizer str = new StringTokenizer(s,"0123456789");
		String snew="";
		while(str.hasMoreTokens())
		{
			snew=snew+str.nextToken();
		}
		System.out.println(snew);

	}

}
