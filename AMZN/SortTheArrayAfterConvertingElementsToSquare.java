/**
* T(n) : O(n)
* S(n) : O(n)
*/
import static java.lang.System.*;
import java.util.*;

public class SortTheArrayAfterConvertingElementsToSquare
{
    static void bruteForce(int[] A, int n)
    {
        for(int i=0; i<n; i++)
            A[i] = Math.abs(A[i]);
        Arrays.sort(A);
        int rslt[] = new int[n];
        int i = 0;
        for(int x: A)
            rslt[i++] = x*x;
        
        for(int x: rslt)
            out.print(x+" ");
    }
    
    static void sort(int[] A, int n)
    {
        int rslt[] =  new int[n];
        
        int left = 0;
        int right = n-1;
        int  k = n-1;
        
        while(left < right)
        {
            int a = Math.abs(A[left]);
            int b = Math.abs(A[right]);
            
            if(a > b)
            {
                rslt[k--] = a*a;
                left++;
            }
            else
            {
                rslt[k--] = b*b;
                right--;
            }
        }
        
        if(left == right)
            rslt[k] = A[left] * A[left];   

        for(int x: rslt)
          out.print(x+" ");            
    }
    
    public static void main(String [] args) 
    {
       int A[] = {-6, -3, -1, 2, 4, 5};
       int n = A.length;
       
       //sort(A, n);
       bruteForce(A, n);
    }
}