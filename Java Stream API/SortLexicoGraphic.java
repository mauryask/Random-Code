// Sorting the words lexico grphically
// Using stream API

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class SortLexicoGraphic
{
	public static void main(String [] args)
	{
		String str =  "Shubham Abhay Aman Akhil Lamal";
		
		List<Student> A= Stream.of(str.split(" "))
		.map(x -> new Student(x))
		.collect(Collectors.toList());
		
		Collections.sort(A, new Student());
		
		for(Student x: A)
			System.out.print(x+" ");
	}
}

class Student implements Comparator<Student>
{
	String num;
	Student(String num)
	{
		this.num = num;
	}
	
	Student()
	{
		
	}
	
	@Override
	public int compare(Student o1, Student o2)
	{
		return o1.num.compareTo(o2.num);
	}
	
	@Override
	public String toString()
	{
		return num;
	}

}