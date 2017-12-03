package com.examples;
import java.util.*;

public class Tree
{
	public Node root;
	public ArrayList<LinkedList<Node>> lists=new ArrayList<LinkedList<Node>>();
	public LinkedList<Node> list=new LinkedList<Node>();

	public Tree()
	{
		this.root=null;
	}

	public void printlevelnodes(Node root, int level)
	{
		if(root==null||level<0)
			return;
		if(level==0)
			list.add(root);
		if(root.left!=null)
			printlevelnodes(root.left,level-1);
		if(root.right!=null)
			printlevelnodes(root.right, level-1);
	}

	public void levellists(Node root)
	{
		int i=0;
		while(i<this.depth(this.root))
		{
			printlevelnodes(root, i);
			LinkedList<Node> s=new  LinkedList<Node>();
			for(int j=0;j<this.list.size();j++)
				s.add(this.list.get(j));
			lists.add(i,s);
			list.clear();
			i++;
		}
	}

	public int nodes(Node root)
	{
		int count=1;
		if(root.left!=null)
			count+=nodes(root.left);
		if(root.right!=null)
			count+=nodes(root.right);
		return count;
	}

	public boolean add(int data)
	{
		if(this.root==null)
		{
			root=new Node(data, null);
			return true;
		}
		else
			return root.add(data);
	}

	public int depth(Node root)
	{
		int h1=0, h2=0;
		if(root==null)
			return -1;
		else
		{
			if(root.left!=null)
				h1=depth(root.left);
			if(root.right!=null)
				h2=depth(root.right);
			return Math.max(h1,h2)+1;
		}
	}

	public Node search(int value)
	{
		if(this.root==null)
			return null;
		else 
			return this.root.search(value);
	}

	public Node searchparent(int value)
	{
		if(this.root==null)
			return null;
		else 
			return this.root.searchparent(value);
	}


	public void minimaheight(int[] nums)
	{
		int mid=nums.length/2;
		add(nums[mid]);
		int left=mid, right=mid;
		while(left>0 && right <nums.length-1)
		{
			left--;
			right++;
			add(nums[left]);
			add(nums[right]);
		}
	}

	public Node commonAncestor(Node n1, Node n2)
	{
		if(this.search(n1.data)!=null&&this.search(n2.data)!=null)
		{
			if(n1.parent!=null&&n2.parent!=null) {
				if(n1.parent.data==n2.parent.data)
					return n1.parent;
				else
					return commonAncestor(n1.parent, n2.parent);
			}
			else
				return null;
		}else return null;
	}

	public static void main(String[] args)
	{
		Tree l=new Tree();
		int numbers[]={21,43,55,32,12,1,3,9,43,2,54,19,10};
		//int numbers[]={6,7,10,12,19,23,24,33,44,45,76};

		//4.3
		//l.minimaheight(numbers);
		for(int i=0;i<numbers.length;i++)
			l.add(numbers[i]);

		//////////////////////4.4
		System.out.println("Depth:" + l.depth(l.root));
		System.out.println("Tree:");
		l.levellists(l.root);
		for(int i=0;i<l.lists.size();i++)
		{
			for(int j=0;j<l.lists.get(i).size();j++)
				System.out.print(" "+l.lists.get(i).get(j).data);
			System.out.println();
		}
		///////////////
		////4.6
		int num1=3, num2=9;
		Node n1=l.search(num1);
		Node n2=l.search(num2);
		Node ancestor=new Node(0,null);
		if(n1!=null&&n2!=null)
		{
			ancestor=l.commonAncestor(n1, n2);
			if(ancestor!=null)System.out.println(ancestor.data);
		}


		System.out.println("Find parent: "+String.valueOf(l.searchparent(76).data));
		//l.printTree(l.root);
		//System.out.println(l.nodes(l.root));
	}
}