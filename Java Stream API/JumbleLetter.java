//https://www.hackerearth.com/problem/algorithm/jumble-letter/
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class JumbleLetter 
{
	public static void main(String [] args) throws IOException
	{
	   BufferedReader br = new 
	   BufferedReader(new InputStreamReader(System.in));
	  
	  int T = Integer.parseInt(br.readLine());
	  
	  while(T-->0)
	  {
		 String str = br.readLine();
	   
		   List<Character> list = str.chars()
		   .mapToObj(x->(char)x)
		   .filter(x-> x!= 'A' && x!='E' && x!='I'&&
		   x!='O' && x!= 'U' && x!='Y'&&
		   x!='a' && x!= 'e' && x!='i'&&
		   x!='y' && x!= 'u' && x!='o')
		   .map(x-> ((int)x>=65 && (int)x <=90) ? (char)((int)x+32) : x)
		   .collect(Collectors.toList());

		   for(char c : list)
			 System.out.print("."+c);

		   System.out.println();	   
	  }
	}
}