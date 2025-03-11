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
	
	/*
	* Method-1
	* Removing duplicate the node completely
	***********
	* T(n) : O(n)
	* S(n) : O(1)
	*/
	
	static void method1()
	{
		if(head == null)
			return;
		
		Node p1 = head;
		Node p2 = head.next;
		Node temp = p2;
		
		while(p2 != null)
		{
			if(p1.data == p2.data)
			{
				p1.next = temp.next;
				temp = temp.next;
				p2.next = null;
				p2 = temp;
			}
			else
			{
				p1 = p1.next;
				temp = temp.next;
				p2 = temp;
			}
		}
	}
		
	/*
	 * Method-2
	 * removing the duplicates by replacement 
	 * the simplest method
	 */
	
	static void method2()
	{
		if(head == null)
			return;
		
		Node p1 = head;
		Node p2 = head.next;
		Node  temp = p2;
		
		while(p2 != null)
		{
			if(p1.data == p2.data)
				p2 = p2.next;
			else 
			{
				temp.data = p2.data;
				temp = temp.next; 
				p1 = p1.next;
			}
		}
		
		p1.next =  null;
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
		method2();
		//method3();
		printList();
	}
}