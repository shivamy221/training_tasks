package task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Question1 {

	public static void main(String args[]) {

		String[] strArray = { "ab@gmail.com", "cd@outlook.com", "ef@yahoo.com","ab@gmail.com", "cd@outlook.com", "ef@yahoo.com","ab@gmail.com", "cd@outlook.com", "ef@yahoo.com" };
		
		
		ArrayList<String> strArray1 = new ArrayList<String>();
		
		
		for(String strarr:strArray) {
			String[] arrOfStr = strarr.split("@");
			strArray1.add(arrOfStr[1]);
		}
		
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		
		for(int i=0;i<strArray1.size();i++)
		{
			if(map.containsKey(strArray1.get(i)))
			{
				map.put(strArray1.get(i),map.get(strArray1.get(i))+1);
			}
			else
			{
				map.put(strArray1.get(i),1);
			}
		}

		
		for(Map.Entry<String, Integer> entry:map.entrySet())
		{
			System.out.println(entry.getKey()+"   "+entry.getValue());
		}
	}
}
