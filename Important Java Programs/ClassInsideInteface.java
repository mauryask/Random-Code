//class Insidde interface
//very important example

import static java.lang.System.*;

interface A 
{
	class B 
	{
		void show()
		{
			out.println("Hello world...");
		}
		
	}
}

public class ClassInsideInteface implements A
{
     static String msg = "Go to hell";	  
	 public static void main(String [] args) 
	 {
		 B b = new B();
		 b.show();
	 }
}