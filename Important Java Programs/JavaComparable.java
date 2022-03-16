import java.util.*;
public class JavaComparable
{
	public static void main(String [] args)
	{
		ArrayList<Laptop> list = new ArrayList<>();
		list.add(new Laptop(4,14999,4));
		list.add(new Laptop(8,36554,5));
		list.add(new Laptop(2,15099,2));
		list.add(new Laptop(16,80789,4));
		list.add(new Laptop(4,32569,3));
		list.add(new Laptop(8,50859,5));
		
		Collections.sort(list);
		
		for(Laptop l : list)
		{
			System.out.println(l);
		}
	}
}

class Laptop implements Comparable<Laptop>
{
	int ram;
	int price;
	int rating;
	
	Laptop(int ram,int price, int rating)
	{
		this.rating = rating;
		this.ram = ram;
		this.price = price;
	}
	
	public int getRam()
	{
		return ram;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public int getRating()
	{
		return rating;
	}
	
	@Override
	public int compareTo(Laptop lap)
	{
		if(this.getRating() > lap.getRating())
			return 1;
		return-1;
	}
	
	public String toString()
	{
		return ram+" "+price+" "+rating;
	}
}

