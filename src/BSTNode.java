
public class BSTNode 
{
	private BSTNode left = null;	//getter, setter
	private BSTNode right = null;	//getter, setter
	private BSTNode parent; 		//getter, constructor
	private int key;				//getter, constructor
	
	BSTNode(int key, BSTNode parent)
	{
		this.key = key;
		this.parent = parent;
	}
	
	public int getKey()
	{
		return key;
	}
	
	public void setKey(int num)
	{
		key = num;
	}
	
	public BSTNode getParent()
	{
		return parent;
	}
	
	public void setParent(BSTNode parent)
	{
		this.parent = parent;
	}
	
	public BSTNode getLeft()
	{
		return left;
	}
	
	public BSTNode getRight()
	{
		return right;
	}
	
	public void setRight(BSTNode right)
	{
		this.right = right;
	}
	
	public void setLeft(BSTNode left)
	{
		this.left = left;
	}
	
}
