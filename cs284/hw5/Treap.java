import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>> {

	private Random priorityGenerator ;
	private Node<E> root;
	
	/**
	 * Constructor for Treap
	 */
	public Treap ()
	{
		priorityGenerator = new Random();
		root = null;
	}
	
	/**
	 * Constructor for Treap with a set seed for the random number generator
	 */
	public Treap (long seed)
	{
		priorityGenerator = new Random(seed);
		root = null;
	}
	
	/**
	 * adds a node to the treap
	 * @param key, the key that you are putting into the treap for BST
	 * @return returns true if successfully added, else false
	 */
	public boolean add(E key)
	{
		int temp = this.priorityGenerator.nextInt(20);
		return add(key,temp);
	}
	
	/**
	 * adds a node to the treap
	 * @param key, the key that you are putting into the treap for BST
	 * @param priority, priority for the heap
	 * @return returns true if successfully added, else false
	 */
	public boolean add(E key , int priority )
	{
		if(root==null)
		{
			Node<E> newR = new Node<E>(key, priority);
			root = newR;
			return true;
		}
		
		Stack<Node<E>> s = new Stack<Node<E>>();
		Node<E> temp = root;
		
		while(temp!=null){
		
			s.push(temp);
			if(find(key)==key)
			{
				return false;
			}
	        
	        else if (key.compareTo(temp.data)<0) 
	        { 
	        	if(temp.left==null)
	        	{
		           temp.left = new Node<E>(key, priority);
		           reheap(temp.left,s);
		           return true;
	        	}
	        	temp = temp.left;
	        }
	        else if (key.compareTo(temp.data)>0) 
	        {

	        	if(temp.right==null)
	        	{
		           temp.right = new Node<E>(key, priority);
		           reheap(temp.right,s);
		           return true;
	        	}
	        	temp = temp.right;
	        }
		}
		return false;
	}
	
	/**
	 * Rebuilds the treap to follow the heap 
	 * @param temp, the root of the treap
	 * @param s, stack that contains the nodes leading to the node you added
	 */
	private void reheap(Node<E> temp, Stack<Node<E>> s)
	{
		while(!s.isEmpty())
		{
			Node<E> p = s.pop();
			if(temp.priority>p.priority)
			{
				if(temp.data.compareTo(p.data)<0)
				{
					temp = p.rotateRight();
				}
				else
				{
					temp = p.rotateLeft();
				}
				
				if(!s.isEmpty())
				{
					if(s.peek().left==p)
					{
						s.peek().left=temp;
					}
					else
					{
						s.peek().right = temp;
					}
				}
				else
				{
					root = temp;
				}
				
			}
			else 
				break;
		}
	}
	
	/**
	 * deletes a node from the treap
	 * @param key, the key of the node you want to delete
	 * @return, returns true if successfully deleted
	 */
	public boolean delete (E key)
	{
	
		Node<E> temp = root;
		Node<E> parent = null;
		if(find(key)==null)
		{
			return false;
		}
			while(temp!=null)
			{
				
				if(key.compareTo(temp.data)<0)
				{
					parent=temp;
					temp=temp.left;
					
				}
				else if(key.compareTo(temp.data)>0)
				{
					
					parent=temp;
					temp=temp.right;
					
				}
				else
				{
					
					
					if(temp.left==null && temp.right==null)
					{
						if(parent.data.compareTo(temp.data)>0)
						{
							parent.left=null;
							return true;
						}
						else
						{
							parent.right=null;
							return true;
						}
					}
					
					if(key.compareTo(this.root.data)==0)
					{
						if(this.root.right==null)
						{
							this.root=this.root.left;
							return true;
						}
						else if (this.root.left==null){
							this.root=this.root.right;
							return true;
						}
						
						if(this.root.left.priority > this.root.right.priority)
							{
								this.root=this.root.rotateRight();
								parent = root;
							}
							else
							{
								this.root=this.root.rotateLeft();	
								parent = root;
							}
					}
					
					else if (temp.right == null && temp.left!=null)
					{
						
						
						if(parent.left==temp){
							parent.left= temp.rotateRight();
							parent=parent.left;
						}
						else{
							parent.right= temp.rotateRight();
							parent=parent.right;
						}
						
						
					}
					
					else if (temp.left == null && temp.right!=null)
					{
						
						if(parent.left==temp){
						parent.left=temp.rotateLeft();
						parent=parent.left;
						}
						else {
							parent.right=temp.rotateLeft();
							parent=parent.right;
						}
					
					}
				
					else if (temp.left!=null && temp.right!=null)
					{
						
						if(temp.left.priority > temp.right.priority)
						{
							
							
							if(parent.left==temp){
								parent.left=temp.rotateRight();
								parent=parent.left;
								}
							else{
								parent.right=temp.rotateRight();
								parent=parent.right;
							}
							
						}
						else
						{
							
							
							if(parent.left==temp){
								parent.left=temp.rotateLeft();
								parent=parent.left;
								}
							else{
								parent.right=temp.rotateLeft();
								parent=parent.right;
							}
							
						}
					}
					
				}
				
			}
			return false;
	}
	
	/**
	 * finds a node in the treap
	 * @param root, root of the treap
	 * @param key, key of the node you want to find
	 * @return, returns the key if it is found, returns null if not found
	 */
	private E find(Node <E> root , E key )
	{
		Node<E> temp = root;
		while(temp!=null)
		{
		   if(key.compareTo(temp.data)==0)
			{
				return key;
			}
			else if(key.compareTo(temp.data)<0)
			{
				temp=temp.left;
			}
			else if(key.compareTo(temp.data)>0)
			{
				temp=temp.right;
			}
			
		}
		return null;
			
	}
	/**
	 * finds the node given the key
	 * @param key, key of the node you want to find
	 * @return, returns the key if it is found, returns null if not found
	 */
	public E find ( E key )
	{
		Node<E> temp = root;
		return find(temp,key);
	}
	
	/**
	 * returns String representation of the treap
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder(); 
		preOrderTraverse(root, 1, sb); 
		return sb.toString();
	}
	
	/**
	 * Makes the string model of the treap
	 * @param node, current node
	 * @param depth, the height
	 * @param sb, the actual string
	 */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) 
	{
		for (int i = 1; i < depth; i++) 
		{ 
			sb.append(" "); 
		} 
		if (node == null)
		{
			sb.append("null\n"); 
		}
		else 
		{ 
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth + 1, sb); 
			preOrderTraverse(node.right, depth + 1, sb); 
		} 
	}
	
	/**
	 * 
	 * Node class
	 */
	private static class Node<E extends Comparable<E>>{
		public E data; // key for the search
		public int priority; // random heap priority
		public Node <E> left;
		public Node <E> right;
		
		
		/**
		 * constructor for node
		 * @param data, the key for the BST
		 * @param priority, priority for the heap
		 */
		public Node(E data , int priority)
		{
			this.data = data;
			this.priority = priority;
			left =null;
			right=null;
		}
		
		
		/**
		 * rotates around the root to the right
		 * @return, returns the new root
		 */
		public Node<E> rotateRight()
		{
			 Node<E> root = this;
			 Node<E> l = root.left;
		     root.left = l.right;
		     l.right = root;
		     return l;
		}
		
		/**
		 * rotates around the root to the left
		 * @return, returns the new root
		 */
		public Node<E> rotateLeft()
		{
			 Node<E> root = this;
			 Node<E> r = root.right;
		     root.right = r.left;
		     r.left = root;
		     return r;
		}
		
		/**
		 * string of the key and the priority for the node
		 */
		public String toString()
		{
			return "(key=" + data + ", priority=" + priority + ")";
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Treap<Integer> testTree = new Treap <Integer>();
		testTree.add (4 ,19);
		testTree.add (2 ,31);
		testTree.add (6 ,70);
		testTree.add (1 ,84);
		testTree.add (3 ,12);
		testTree.add (5 ,83);
		testTree.add (7 ,26);
		
		
		System.out.println(testTree.delete(1));
		System.out.println(testTree.toString());
		System.out.println(testTree.delete(5));
		System.out.println(testTree.toString());
		
	}

}
