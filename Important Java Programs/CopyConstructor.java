class Rest
{
	int id;
	String name;
	
	//parameterized constructor
	Rest(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	//copy constructor
	Rest(Rest obj)
	{
		id = obj.id;
		name = obj.name;
	}
	
	public String toString()
	{
		return id+" "+name;
	}
}

public class CopyConstructor
{
	public static void main(String [] args)
	{	
	   Rest r = new Rest(1,"Shubham");
	   
	   //this is shallow copy(since we are using only primitive types in Rest class)
	   Rest copy  = new Rest(r); //calling copy constructor
	   
	   copy.id = 12;
	   copy.name = "Priya";
	   
	   System.out.println(r);
	   System.out.println(copy);
	}
}