//https://www.geeksforgeeks.org/happy-number/
//see the logic behind this number
package com.pnstech;

import java.util.Scanner;
public class HappyNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(isHappy(n));
		sc.close();
	}
	
		
	static boolean isHappy(int n)
	{
		int slow, fast;
		slow = fast = n;

		do {
			
			slow = squareSum(slow);
			fast = squareSum(squareSum(fast));
			
			//see how slow and fast are being changed
			System.out.println(slow+" "+fast);
			
			//one day slow and fast will become equal either 1 or something else
		}while(slow!=fast); 
		
		return(slow==1);
	}

	//finding the Square-Sum of numbers
	static int squareSum(int n)
	{
		int sum = 0;
		while(n!=0)
		{
			sum = sum + (n%10) * (n%10);
			n = n/10;
		}
		
		return sum;
	}
	
}
