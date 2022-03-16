// Singleton class allows to create only one object of a class
// https://www.javatpoint.com/how-to-create-singleton-class-in-java

class Rest 
{
    int x = 20;
	private static Rest instance = null;
	
	private Rest()
	{
		
	}
	
	static public Rest getInstance()
	{
		if(instance == null)
			instance = new Rest();
		return instance;
	}
}

public class SingletonClass 
{
	public static void main(String []arg)
	{
		  Rest r = Rest.getInstance();
		  Rest rs = Rest.getInstance();
		  r.x = r.x +10;
		  System.out.println(r.x);
		  System.out.println(rs.x);
	}
}