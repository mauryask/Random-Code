/*
https://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
*/

import static java.lang.System.*;
import java.util.*;

class Node 
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
		next = null;
	}
}

public class RemoveDuplicatesFromLinkedLists
{
	static Node head = null;
	static Node tail = null;
	
	static void insertNode(int data)
	{
		Node temp = new Node(data);
		
		if(head == null)
			head = temp;
		else
			tail.next = temp;
		tail = temp;
	}
	
	static void printList()
	{
		Node ptr = head;
		
		while(ptr != null)
		{
			out.print(ptr.data+" ");
			ptr = ptr.next;
		}
		out.println();
	}
	
	/*Method-1
	***********
	* T(n) : O(n)
	* S(n) : O(1)
	*/
	
	static void removeDulicates()
	{
		if(head == null)
			return;
		
		Node p1 = head;
		Node p2 = head.next;
		
		while(true)
		{
			if(p2 == null)
			{
				p1.next = p2;
				return;
			}
			
			if(p1.data == p2.data)
				p2 = p2.next;
			else
			{
				p1.next = p2;
				p1 = p2;
				p2= p2.next;
			}
		}
	}
	
	/* Method-2
	*********
	* T(n) = O(n)
	* S(n) = O(n)
	*/
	
	static void removeDulicates2()
	{
		Map<Integer, Node> map = new HashMap<>();
		Node prev = new Node(-1);
		Node ptr = head;
		
		while(ptr != null)
		{
			if(!map.containsKey(ptr.data))
			{
				map.put(ptr.data, ptr);
				prev.next = ptr;
				prev = ptr;
			}
			
			ptr = ptr.next;
		}
		
	   // 2 2 6 7 8 9 9 9 
		prev.next = ptr;
	}
	
	public static void main(String [] args)
	{
		insertNode(2);
		insertNode(2);
		insertNode(6);
		insertNode(7);
		insertNode(8);
		insertNode(9);
		insertNode(9);
		insertNode(9);
		
		printList();
		
		removeDulicates2();
		
		printList();
	}
}