/*
** T(n) : O(n)
** S(n) : O(1) https://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/
*/
import static java.lang.System.*;

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

public class SortLinkedListAlreadySortedWithAbsoluteValues
{
	static void printList(Node head)
	{
		while(head != null)
		{
			out.print(head.data+" ");
			head = head.next;
		}
		out.println();
	}
	
	
	static Node sort(Node head)
	{
		if(head == null)
			return head;
		
		Node prev = head;
		Node ptr = head.next;
		
		while(ptr != null)
		{
			 if(ptr.data < 0)
			 {
				 prev.next = ptr.next;
				 ptr.next = head;
				 head = ptr;
				 ptr = prev.next;
			 }
			 else
			 {
				 prev = prev.next;
				 ptr = prev.next;
			 }
		}
		
		return head;
	}
	
	public static void main(String [] args)
	{
	    Node head = new Node(1);	
	    Node n2 = new Node(-2);	
	    Node n3 = new Node(-3);	
	    Node n4 = new Node(4);	
	    Node n5 = new Node(-5);	
	    Node n6 = new Node(6);

		head.next = n2;
		n2.next = n3;		
		n3.next = n4;		
		n4.next = n5;		
		n5.next = n6;	

        printList(head);	
        printList(sort(head));		
	}
}