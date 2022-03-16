import java.util.*;
import java.io.*;
import static java.lang.System.*;

@FunctionalInterface
interface Drawing 
{
	String draw(String a);
}

class Student implements Comparator<Student>
{
    String id;
	String name;
	int roll;
	
	Student(){} //default constructor
	
	//parameterized constructor
	Student(String id, String name, int roll)
	{
		this.id = id;
		this.name = name;
		this.roll = roll;
	}

	@Override 
	public int compare(Student o1, Student o2)
	{
		return o1.roll - o2.roll;
	}
	
	@Override
	public String toString()
	{
		return "id: "+id+"\nroll: "+roll+"\nname: "+name+"\n============\n";
	}
}


public class CustomComparator
{
	public static void main(String [] args) throws IOException
	{
           List<Student> list = new ArrayList<>();
		   list.add(new Student("457KJ", "Shubham Maurya", 89));
		   list.add(new Student("201GD", "Priya Khangan", 78));
		   list.add(new Student("896HJ", "Lokesh Yadav", 88));
		   list.add(new Student("856FR", "Abhay Mishra", 65));
		  
		   Collections.sort(list, new Student());

		   for(Student x: list)
			   out.print(x);
	}
}