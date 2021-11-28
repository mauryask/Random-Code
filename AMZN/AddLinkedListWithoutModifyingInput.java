/**
* Time complexity: O(n)
* Space complexity : O(1)
*/

/**
* Interview round-4
* https://www.geeksforgeeks.org/amazon-interview-experience-for-sde-1-off-campus-4/ 
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
	   next =  null;
	}
}

public class AddLinkedListWithoutModifyingInput
{
	 static Node tail = null;
	 
	 static Node insertNode(Node head,int data)
	 {
		 Node temp = new Node(data);
		 Node ptr = null;
		 
		if(head == null)
		{
			head = temp;
			tail = head;
			return head;
		}
		
        tail.next = temp;
        tail = temp;
		
		return tail;
	 }
	 
	 
	 static void displayList(Node head)
	 {
		 Node ptr = head;
		
		 while(ptr != null)
		 {
			 out.print(ptr.data+" ");
			 ptr = ptr.next;
		 }
		 
		 out.println();
	 }	
				
	 static void addList(Node l1, Node l2)
	 { 
         int carry  = 0;
         String cum_sum = "";
        
         while(l1 != null || l2 != null)
         {   
            int a = l1 == null ? 0 : l1.data;
			int b = l2 == null ? 0 : l2.data;
			
			int sum = a + b + carry;
			int temp = sum %10;
			carry = sum / 10;
			
			cum_sum += temp;
			
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
         }
        
        if(carry != 0)
           cum_sum += carry;
        
       out.println(cum_sum);
	 }	 
   		
					
	public static void main(String [] args) 
	{
		Node head1 =  null;
		head1 = insertNode(head1, 3);
		insertNode(head1, 2);
		insertNode(head1, 4);
		
		displayList(head1);
		
		Node head2 =  null;
		head2 = insertNode(head2, 9);
		insertNode(head2, 7);
		insertNode(head2, 8);
		
		displayList(head2);
       
        addList(head1, head2);
	}
}