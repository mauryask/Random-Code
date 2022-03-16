import java.util.*;
public class JavaComparator
{
	public static void main(String args[])
	{
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(5);
		list.add(89);
		list.add(45);
		list.add(32);
		
		System.out.println(list);
		
		/*
		*sorting in ascending oreder
		*/
		
		//Comparator<Integer> cmp = new Test();
		
		/*
		*sorting based on last digit
		*/
		
		/*
		Comparator<Integer> cmp = new Comparator<>(){
			@Override 
			public int compare(Integer o1, Integer o2)
			{
				if(o1%10 > o2%10)
					return 1;
				return -1;
			}
		};
		*/
		
		/*
		* The above expression could be reduced to folowing
		*/
		
		/*
		Comparator<Integer> cmp = (o1,o2)->{
			if(o1 > o2)
				return 1;
			return -1;
		};
		*/
		
		/*
		Comparator<Integer> cmp = (o1, o2)->{
			return o1%10>o2%10 ? 1:-1;
		};
		
		Colections.sort(list, cmp);
		
		*/
		
		//==> or just use it in one line
		//==> this is the best approach
		Collections.sort(list,(o1, o2)->{
			return o1%10>o2%10 ? 1:-1;
		});
		
		System.out.println(list);
	}
}

//sorting in ascending oredr
class Test implements Comparator<Integer>
{
	@Override
	public int compare(Integer o1, Integer o2)
	{
		if(o1 > o2) //swap
			return 1;
		return -1; //don't swap
	}
}