//https://www.youtube.com/watch?v=JyLrPSJNfYw

import static java.lang.System.*;

public class IntegerToRoman 
{
	    public static String units[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		public static String tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		public static String hundreds[] = {"", "C", "CC", "CCC", "CD","D", "DC", "DCC", "DCCC", "CM"};
		public static String thousands[] = {"", "M", "MM", "MMM"};
    
        static String intToRoman(int num) 
        {
		  return thousands[num/1000] + hundreds[(num%1000)/100] 
	   	  + tens[(num%100)/10] + units[num%10]; 
        }
		
		public static void main(String [] args)
		{
			out.println(intToRoman(1986));
		}
}