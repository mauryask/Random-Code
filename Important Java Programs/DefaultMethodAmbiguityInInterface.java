// Here since we are using the same default method x() int A and B
// if use multiple inheritence then there will be ambiguity
// to resolve this provide impelemntation of the methos and 
// give your own implementation to it
interface A 
{
	default void x()
	{
		System.out.println("Form A..");
	}
}

interface B 
{
	default void x()
	{
	   System.out.println("From B..");
	}
}

public class DefaultMethodAmbiguityInInterface implements A, B 
{
	@Override 
     public void x() //here impelemenation resolves ambiguity
	 {
		 /**
		 * but if here you want to call default implementation
		 * use this: A.super.x();
		 */
		 
		 A.super.x();
		 
		 System.out.println("From Rest...");
	 }		 
	
	public static void main(String [] args)
	{
		Rest r = new Rest();
		r.x();
	}
}