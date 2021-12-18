/*
* Not working for all the cases
** at interviewbit
** https://www.interviewbit.com/problems/next-smallest-palindrome/
*/
import static java.lang.System.*;
import java.util.*;

public class NextASmallestPalindrome
{
    static int nextMinPalin(int num)
    {
        if(num < 9)
            return num+1;
        if(num < 11)
            return 11;
        
        int totalDigits = (int)(Math.log10(num) + 1);
        int mid = totalDigits / 2;
        int mult = (int)Math.pow(10, mid);
        String leftHalf = "";
        String rightHalf = "";
        String result = "";
        StringBuilder sb = new StringBuilder();
        int tempLeft = 0;
        int tempRight = 0;
        
        if(totalDigits % 2 == 0)
        {
            tempLeft = num / mult;
            tempRight = num % mult;
            
            if(tempLeft <= tempRight)
               tempLeft += 1;

            leftHalf += tempLeft;
        }
        else 
        {
            tempLeft = num / (mult*10);
            tempRight = num % mult;
            
            if(tempLeft <= tempRight)
                leftHalf += (num/mult)+1;
            else
                leftHalf += num/mult;                
        }
        
        rightHalf = sb.append(tempLeft)
                .reverse().toString();
        result = leftHalf + rightHalf;
        
        return Integer.parseInt(result);
    }
    
    public static void main(String [] args) 
    {
        int num  = 1207;
        out.println(nextMinPalin(num));
    }
}