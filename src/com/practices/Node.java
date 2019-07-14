package com.practices;

class Node
{
	int data;
	Node left;
	Node right;
	Node parent;
	
   Node(int data, Node parent)
   {
	   this.data=data;
	   this.left=null;
	   this.right=null;
	   this.parent=parent;
   }
   
   public boolean add(int value)
   {
	   if(this.data==value)
	   return false;
	   else if(value<this.data)
	   {
		   if(this.left==null)
		   {
			   this.left=new Node(value, this);
			   return true;
		   }
		   else
			   return left.add(value);	   
	   }
	   else if(value>this.data)
	   {
		   if(this.right==null)
		   {
			   this.right=new Node(value, this);
			   return true;
		   }
		   else
			   return right.add(value);
	   }
	   return false;
   }
  
   
   public Node searchparent(int value)
   {
	   if(this.data==value)
		   return this.parent;
	   else if(value<this.data)
	   {
		   if(this.left==null)
			   return null;
		   else
		   return this.left.searchparent(value);
	   }
	   else if(value>this.data)
	   {
		   if(this.right==null)
		   return null;
	       else
		   return this.right.searchparent(value);
	   }
	   return null;
   }
   
   public Node search(int value)
   {
	   if(this.data==value)
		   return this;
	   else if(value<this.data)
	   {
		   if(this.left==null)
			   return null;
		   else
		   return this.left.search(value);
	   }
	   else if(value>this.data)
	   {
		   if(this.right==null)
		   return null;
	       else
		   return this.right.search(value);
	   }
	   return null;
   }
}