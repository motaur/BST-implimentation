import java.util.Scanner;

public class Menu 
{	
	private static Scanner sc = new Scanner(System.in);
	private static int input = -1;
	public static BST bst = null;
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to BINARY SEARCH TREE\n");
		generalMenu();
	}
	
	private static void generalMenu()
	{
		while(input != 0)
		{
			System.out.println("input numbers for next possible actions:");
			if(bst == null)
			{
				System.out.println("1. create binary tree and insert root node");
				System.out.println("0. exit");
			}
			else
			{
				System.out.println("1. insert");
				System.out.println("2. find");
				System.out.println("3. delete");
				System.out.println("4. inorder print");
				System.out.println("5. preorder print");
				System.out.println("6. postorder print");
				System.out.println("7. breadth print");
				System.out.println("0. exit");
			}
			
			input = input();
			
			if(bst == null && (input == 2 || input == 3 || input == 4 || input == 5 || input == 6 || input == 7))
			{
				System.out.println("input must be only 1 or 0");
				input = -1;
			}
			
			switch(input)
			{
				case 1: insertion();
					break;
				case 2: foundation();
					break;
				case 3: deleting();
					break;
				case 4: bst.inOrderPrint(bst.getRoot());
						System.out.println("");
					break;
				case 5: bst.preOrderPrint(bst.getRoot());
						System.out.println("");
					break;
				case 6: bst.postOrderPrint(bst.getRoot());
						System.out.println("");	
					break;
				case 7: bst.breadthPrint(bst.getRoot());
						System.out.println("");	
					break;
				case 0: break;
			}
		}
	}
	
	private static void deleting() 
	{
		System.out.println("input an integer for delete from the tree:");
		input = input();
		
		if(bst.delete(input) == false)
			System.out.println("There is no number " + input + " in the tree");
		else
			System.out.println("number " + input + " deleted successfuly");
	}

	private static void insertion()
	{
		System.out.println("input an integer for insertion:");
		input = input();
		
		if(bst == null)
			bst = new BST(input);
		else
		{
			boolean check = bst.insert(input);
			
			if(check)
				System.out.println("number " + input + " was inserted into the tree");
			else
				System.out.println("error, this value already exist");
		}
		
		if(input == 0)
			input = -1;
	}
	
	private static int input() 
	{	
		String s = null;
		boolean check = false;
		
		while(check == false)
		{
			s = sc.nextLine();
			for(int i = 0; check == false && i < s.length(); i++)											
			{
			     if ((s.charAt(i) > '9' || s.charAt(i) < '0') && (s.charAt(0) != '-') )			
	                  	System.out.println("Invalid input. Input must be only an integer");
		         else  
	                  	check = true;
			}
		}
		return Integer.parseInt(s);
	}

	private static void foundation()
	{
		System.out.println("input an integer for search in the tree:");
		input = input();
		BSTNode node = bst.find(input);
		
		if(node == null)
			System.out.println(input + " there was not found");
		else 
			System.out.println(input + " there is in the tree");
	}
}
