/*
* T(n) : O(n)
* S(n) : O(n)
*************
https://www.geeksforgeeks.org/amazon-interview-experience-for-sde-1-6-months-experienced/
*/

import static java.lang.System.*;
import java.util.*;

class Tree 
{
	// Get head pointer in the Tree class
	static Node head =  null;
	
	Tree(Node listHead)
	{
		head = listHead;
	}
	
	// Get a node from DLL 
	// to create the Spiral Tree
	
	static Node getNode()
	{
		if(head == null)
			return null;
		
		Node ptr = head.right;
		Node temp = head;
		head.right = null;
		head = ptr;
		
		return temp;
	}
		
	static void createSpiralTree()
	{
	   Stack<Node> s1 = new Stack<>();
	   Stack<Node> s2 = new Stack<>();
	   Node root = getNode();
	   if(root == null)
		   return; // return null

	   s1.push(root);
		
	   boolean lr =  true;
		
		while(!s1.isEmpty() || !s2.isEmpty())
		{
		  // Add node left to right 
           if(lr)
		   {
			   while(!s1.isEmpty())
			   {
				   Node node = s1.pop();
				   
				   node.left = getNode();
				   if(node.left != null)
					   s2.push(node.left);
				   node.right = getNode();
				   if(node.right != null)
					   s2.push(node.right);
			   }
			   
			    lr  = false;
		   }
		    else // Add node right to left
			{
				   while(!s2.isEmpty())
				   {
					   Node node = s2.pop();
					   
					   node.right = getNode();
					   if(node.right != null)
						   s1.push(node.right);
					   node.left = getNode();
					   if(node.left != null)
						   s1.push(node.left);
				   }
				   
				   lr = true;
			}
		}
		
		// Print Tree
		printTree(root);
   }

   // Preorder Traersal of the tree	
	static void printTree(Node root)
	{
		if(root != null)
		{
			out.print(root.data+" ");
			printTree(root.left);
			printTree(root.right);
		}
	}
}

/*
* Code to create a DLL
*/

class Node 
{
	int data;
	Node right;
	Node left;
	
	Node(int data)
	{
		this.data = data;
		right = null;
		left = null;
	}
}

public class ConvertDLLToSpiralTree
{	   
   static Node addNode(int data, Node tail)
   {
	   Node temp = new Node(data);
	   
	   if(tail != null)
	   {
		   tail.right = temp;
		   temp.left = tail;
	   }
	   
	   tail = temp;
	   
	   return temp;
   }

   static void printList(Node head)
   {
	   Node ptr = head;
	   
	   while(ptr != null)
	   {
		   out.print(ptr.data+" ");
		   ptr = ptr.right;
	   }
   }

	public static void main(String [] args)
	{
       Node head = addNode(1, null);
       Node n2 = addNode(2, head);
       Node n3 = addNode(3, n2);
       Node n4 = addNode(4, n3);
       Node n5 = addNode(5, n4);
       Node n6 = addNode(6, n5);
       Node n7 = addNode(7, n6);
       addNode(8, n7);

	   new Tree(head).createSpiralTree();
	}
}