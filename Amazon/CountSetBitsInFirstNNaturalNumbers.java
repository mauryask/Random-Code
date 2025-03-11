/*
* T(n) : O(log n)
* S(n) : O(1)
** Since the problem size is decresing 
** everytime almost half k/2..k/..k/8..
** That's why the time complexity : O(log n)
*/
import static java.lang.System.*;
import java.util.*;

public class CountSetBitsInFirstNNaturalNumbers
{
    static int setBits(int n)
    {
        if(n==0)
            return 0;
        
        int x = largestPower(n);        
        int setbit1 = x * (1<<(x-1));
        int setbit2 = n-(1<<x)+1;
        int rest = n-(1<<x);
        return setbit1 + setbit2 + setBits(rest);
    }
    
    static int largestPower(int n)
    {
        int x = 0;
        
        while((1<<x) <= n)
            x++;
        
        return x-1;
    }
    
    public static void main(String [] args)
    {
       int n = 7;
       out.println(setBits(n));       
    }
}