import java.io.*;  
import java.util.*; 

public class ComparableInterface 
{
	public static void main(String [] args)
	{
          ArrayList<Student> st_list = new ArrayList<>();
		  st_list.add(new Student("Shubham", 12, 7));
		  st_list.add(new Student("Abhay", 45, 65));
		  st_list.add(new Student("Lokesh", 41, 89));
		  st_list.add(new Student("Yashneet", 102, 85));
		  
		  Collections.sort(st_list);
		  
		  st_list.forEach(System.out::println);
		 		  
	}  
	 
}

class Student implements Comparable<Student>
{
	String name;
        int id;
	int roll;
	
	public Student(String name, int id, int roll)
	{
		this.name = name;
		this.id = id;
		this.roll = roll;
	}
	
	@Override
	public int compareTo(Student st)
	{
		if(id > st.id)
			return 1;
		else if (id < st.id)
			return -1;
		else
			return 0;
	}
	
	    public String toString()
		  {
			  return name+"  "+roll+"  "+id;
		  }
}	