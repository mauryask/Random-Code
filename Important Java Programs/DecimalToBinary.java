//decimal to binary conversion
//https://www.javatpoint.com/java-decimal-to-binary
package com.pnstech;

public class DecimalToBinary
{
	public static void main(String [] args)
	{
		toBinary(10);
	}
	
	public static void toBinary(int decimal)
	{
		int index =  0;
		
		int ch[] = new int[40];
		
		while(decimal >0)
		{
			ch[index++] = decimal % 2;
			decimal = decimal / 2;
		}
		
		for(int i= index-1; i>=0; i--)
		{
			System.out.print(ch[i]);
		}
		
		System.out.println();
	}
}