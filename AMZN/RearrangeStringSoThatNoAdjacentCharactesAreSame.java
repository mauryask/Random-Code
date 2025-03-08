/*
* T(n) : O(n) : Since we are sorting only 26 characters
* S(n) : O(n) : charArr[] array going to take n space
*/
import static java.lang.System.*;
import java.util.*;

public class RearrangeStringSoThatNoAdjacentCharactesAreSame
{	
    static void fillCharArr(List<Character> list, Map<Character, Integer> map, char[] charArr, int index){
        int n = charArr.length;

        for(int i = index; i < n; i+=2){
            char ch = list.get(0);
            charArr[i] = ch;
            map.put(ch, map.get(ch)-1);            
            if(map.get(ch) == 0){
               list.remove(0);              
            }
        }
    }
    
    static String rearrangeString(String s) {
        int n = s.length();
        
        if(n <= 1)
           return s;
           
        int maxFreq = 0;
        // int evenIndexCount = 0;
                   
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new LinkedList<>();
		        
        for(int i=0; i<n; i++){
			// Instead of below operation we can directly get the even index count as
			// (n+1)/2
            // if(i % 2 == 0)
            //   evenIndexCount++;
              
            char ch = s.charAt(i);
            
            if(map.containsKey(ch)){
                map.replace(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
                list.add(ch);
            }
            
            maxFreq = Math.max(maxFreq, map.get(ch));
        }   
        
	   // If max freqeuncy is greater than the even index count
	   // It is not possible to rearrange the charcaters of given string 
	   // as per given rules	
       if(maxFreq > (n+1)/2)
		   return "";
        
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        
        
        char[] charArr = s.toCharArray();
        fillCharArr(list, map, charArr, 0);
        fillCharArr(list, map, charArr, 1);
        
        return String.valueOf(charArr);
    }

   public static void main(String [] args)
   {
	   String str = "baaba";
	   out.println(rearrangeString(str));
   }
}