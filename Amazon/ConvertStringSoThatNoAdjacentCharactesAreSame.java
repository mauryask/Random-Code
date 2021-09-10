import static java.lang.System.*;
import java.util.*;

public class ConvertStringSoThatNoAdjacentCharactesAreSame
{	
   static String changeString(String str, int n)
   {
	   // convert the string into character array
	   char ch[] = str.toCharArray();
	   
	   // map to store charcater frequency
	   Map<Character, Integer> map = new HashMap<>();
	   
	   // list to maintain order of chacater
	   // in descending order of frequency
	   List<Character> list =  new LinkedList<>();
	   int maxFreq = 0;
	   
	   // populating the map
	   for(char c : ch)
	   {
		   if(map.containsKey(c))
		   {
			    map.replace(c, map.get(c)+1);
				maxFreq = Math.max(maxFreq, map.get(c));
		   }
		   else
		   {
			   map.put(c,1);
			   list.add(c);
			   maxFreq = Math.max(maxFreq, 1);
		   }
	   }
	   
	   // Check if such string possibles
	   // see notes
	   if(!((n+1)/2 >= maxFreq))
		   return "No!!";

	   
	   // Sort the list acording to character
	   // frequency in descending order
	   Collections.sort(list, (a, b)->{
		   return map.get(b) > map.get(a) ? 1 : -1;
	   });
	   
	   // first fill the even positions
	   for(int i = 0; i<n; i+=2)
	   {
		 char c = list.get(0);
         
		 map.replace(c, map.get(c)-1);	
         
		 if(map.get(c) == 0)
		 {
			 map.remove(c);
			 list.remove(0);
		 }
		 
		 ch[i] = c;
 	   }


	   // then fill the odd positions
	   for(int i=1; i<n; i+=2)
	   {
		  char c = list.get(0);
         
		  map.replace(c, map.get(c)-1);	
         
		  if(map.get(c) == 0)
		  {
			 map.remove(c);
			 list.remove(0);
		  }
		 
		  ch[i] = c;
	   }
	   
	   // return the final result
	   return String.valueOf(ch);
   }

   public static void main(String [] args)
   {
	   String str = "baaba";
	   int n = str.length();
	   out.println(changeString(str, n));
   }
}