import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BST 
{
	private BSTNode root; //getter, setter, constructor
	
	BST(int num)
	{
		root = new BSTNode(num, null); //object gets value and parent as arguments
	}
	
	public BSTNode getRoot()
	{
		return root;
	}
	
	//returns Node if found, or null if not
	public BSTNode find(int num)
	{
		BSTNode tmp = root;
		
		while(tmp != null)
		{
			if(num == tmp.getKey())
				return tmp;
			
			if(num < tmp.getKey())
				tmp = tmp.getLeft();
			else
				tmp = tmp.getRight();
		}
		
		return tmp;
	}
	
	public boolean insert(int num)
	{
		if(find(num) != null)
			return false;
		
		BSTNode tmp = root;
		BSTNode parent = null;
		
		while(tmp != null)
		{
			if(num >= tmp.getKey())
			{
				parent = tmp;
				tmp = tmp.getRight();
				
				if(tmp == null)
					parent.setRight(new BSTNode(num, parent));
			}
			else
			{	
				parent = tmp;
				tmp = tmp.getLeft();
				
				if(tmp == null)
					parent.setLeft(new BSTNode(num, parent));
			}
		}
		return true;
	}
	
	//root as argument
	public BSTNode min(BSTNode tmp)
	{		
		while(tmp.getLeft() != null)
			tmp = tmp.getLeft();
	
		return tmp;
	}
	
	//returns true if found and deleted, or false if not found
	public boolean delete(int num)
	{
		BSTNode tmp = find(num);
		BSTNode tmp1 = null;
		BSTNode tmp2 = null;
		
		if(find(num) == null)
			return false;
		
		//delete root if root is only one node
		if(num == root.getKey() && root.getLeft() == null && root.getRight() == null)
		{
			Menu.bst = null;
			return true;
		}
		
		//delete root
		if(num == root.getKey())	
		{
			BSTNode node = min(root.getRight());	//searching for minimal value in right subTree
			root.setKey(node.getKey());				//replace root value on this value
			tmp = node;								//delete this node
		}
		
		if (tmp.getLeft() == null || tmp.getRight() == null)
			tmp1 = tmp;
		else
		{
			tmp1 = min(tmp.getRight());
			tmp.setKey(tmp1.getKey()) ;
		}
				
		if(tmp1.getLeft() != null)
			tmp2 = tmp1.getLeft();
		else if(tmp1.getRight() != null)
			tmp2 = tmp1.getRight();
				
		if(tmp2 != null)
			tmp2.setParent(tmp1.getParent());
				
		BSTNode p = tmp1.getParent();
		
		if(tmp1 == p.getLeft())
			p.setLeft(tmp2);
		else
			p.setRight(tmp2);
		
		return true;
	}
	
	//root as argument
	public void inOrderPrint(BSTNode tmp)
	{
		if(tmp != null)
		{
			inOrderPrint(tmp.getLeft());
			System.out.print(tmp.getKey() + " ");
			inOrderPrint(tmp.getRight());
		}
	}
	
	//root as argument
	public void postOrderPrint(BSTNode tmp)
	{
		if(tmp != null)
		{
			postOrderPrint(tmp.getLeft());
			postOrderPrint(tmp.getRight());
			System.out.print(tmp.getKey() + " ");
		}
	}
	
	//root as argument
	public void preOrderPrint(BSTNode tmp)
	{
		if(tmp != null)
		{
			System.out.print(tmp.getKey() + " ");
			preOrderPrint(tmp.getLeft());
			preOrderPrint(tmp.getRight());
		}
		
	}
	
	//root as argument 
	public void breadthPrint(BSTNode tmp)
    {
    	Queue<BSTNode> queue = new LinkedBlockingQueue<>();
    		
    	if(tmp != null)
    		queue.add(tmp);
    	
    	while(!queue.isEmpty())
    	{
    		tmp = queue.remove();
    		System.out.print(tmp.getKey() + " ");
    		
    		if(tmp.getLeft() != null)
    			queue.add(tmp.getLeft());
    		
    		if(tmp.getRight() != null)
    			queue.add(tmp.getRight());
    	}
    }
    
}	