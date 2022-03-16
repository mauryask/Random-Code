import java.io.*;
import java.util.*;
import java.util.stream.*;

public class FindCharacterSum 
{
	public static void main(String [] args) throws IOException
	{
	   BufferedReader br = new 
	   BufferedReader(new InputStreamReader(System.in));
	  
	   String str = br.readLine();
	   
	   List<Integer> list = str.chars()
	   .mapToObj(x->(int)x)
	   .map(x->x-96)
	   .collect(Collectors.toList());
	   
	   int sum = 0;
	   for(int c : list)
		   sum += c;
       System.out.println(sum);	   
	}
}