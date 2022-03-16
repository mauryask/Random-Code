//this problems shows to find all the multiples between given range
//only two out of test cases satisfied (for remaining time limit exceeds) 
//https://www.hackerearth.com/codearena/ring/5bd3ca4/
package com.pnstech;
import java.util.*;
public class FindTheNumberOfMultiplesBetweenGivenRange {
	public static void main(String args[] ) throws Exception {
	       Scanner sc = new Scanner(System.in);
	       int T = sc.nextInt();
	       for(int j=0; j<T; j++)
	       {
	           long A = sc.nextLong(); //lower limit
	           long B = sc.nextLong(); //upper limit
	           long M = sc.nextLong(); //number which multiple is to be find
	 

	          long a;
	          long l;
	          for(long i=A; ;i++) //finding first term
	          {
	              if(i % M == 0)
	                {
	                    a=i;
	                    break;
	                }
	          }

	          for(long k = B; ;k--) //finding last term
	          {
	              if(k % M ==0)
	                {
	                    l=k;
	                    break;
	                }
	          }

	          // as l = a + (n-1) * M 
	          // here we want to find n, d = M is
	            System.out.println(((l-a)/M)+1); 
	       }

	       sc.close();
	       
	    }
}
