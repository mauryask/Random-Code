import java.io.*;
import java.util.*;
import java.util.stream.*;

public class JoinArrayOfStringWithDelimiter
{
	public static void main(String [] args)
	{
		String str[] =  {"Shubham", "Kumar", "Maurya"};
		
		String new_str = 
		Arrays.asList(str)
		.stream()
		//.collect(Collectors.joining(",");
		.collect(Collectors.joining(",","(",")"));
		
		
		//for(char x: list)
			System.out.print(new_str);
	}
}
