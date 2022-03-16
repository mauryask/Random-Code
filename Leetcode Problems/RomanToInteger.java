import static java.lang.System.*;
import java.util.*;

public class RomanToInteger 
{
    Map<Character, Integer> map = new HashMap<>();
	
	RomanToInteger()
	{
	   map.put('I',1);	
	   map.put('V',5);	
	   map.put('X',10);	
	   map.put('L',50);	
	   map.put('C',100);	
	   map.put('D',500);	
	   map.put('M',1000);	
	}
	
	public int findInt(String roman)
	{
	    int n = roman.length();
		int sum = 0;
		for(int i=0;i<n; i++)
		{
			sum += map.get(roman.charAt(i));
			if(i!=0 && map.get(roman.charAt(i)) > map.get(roman.charAt(i-1)))
				sum -= 2*map.get(roman.charAt(i-1));
		}
		
		return sum;
	}
	
	public static void main(String [] args)
	{
		out.println(new RomanToInteger().findInt("MCMLXXXVI"));
	}
}