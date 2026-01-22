import java.util.*;
public class Main 
{	
 
 
//////////////////////////////////////////////////////////////////////////

    static Scanner reader = new Scanner(System.in);

	public static Queue<Integer> buildQueue (int [] arr) 
	{	
	    Queue <Integer> q = new Queue<>();     
      
	    for (int i=0; i<arr.length; i++)
	    {
            q.insert(arr[i]);
	    }
	    return q;
	}
	
	
	


	public static Queue<Integer> copy (Queue <Integer> q) 
	{
        Queue <Integer> newQ1 = new Queue<>();     
        Queue <Integer> newQ2 = new Queue<>();
        
	    while (!q.isEmpty())
	    {
	        newQ1.insert(q.head());
            newQ2.insert(q.remove());
	    }
	    
	    while (!newQ1.isEmpty())
	    {
            q.insert(newQ1.remove());
	    }
	    return newQ2;
	}
	
//////////////////////////////////////////////////////////////////////////	
	
	
	
    

	public static int max (Queue <Integer> q) 
	{
        Queue <Integer> copy = copy(q);
        
        int max = copy.remove();
        
	    while (!copy.isEmpty())
	    {
        	if (max < copy.head())
        	{
        	    max = copy.remove();
        	}
        	else
        	{
        	    copy.remove();
        	}
	    }
	    return max;
	}
	
	
	
	
	public static int digitsCount (int num) 
	{
	    int count = 0;
	    
	    while (num!=0)
	    {
            num=num/10;
            count++;
	    }
	    return count;
	}
	
	
	
	
	public static int digit (int num, int index) 
	{
	    if (digitsCount(num) < index)
	        return 0; 
	    
	    for (int i=0; i<(index-1); i++)
	    {
	        num=num/10;
	    }
	    int digit = num%10;
	    return digit;

	}
	

	
	public static Queue<Integer> sort (Queue <Integer> q)
	{
        Queue <Integer> copy = copy(q);
        Queue <Integer> newQ = new Queue<>();     
        
        Queue <Integer> [] arr = new Queue [10];
        for (int k=0; k<10; k++)
        {
            arr[k] = new Queue<>();
        }
	    
	    int biggest = max(copy);
        copy = copy(q);
        
        for(int i=0; i<digitsCount(biggest); i++)
        {
            while(!copy.isEmpty())
            {
                int current = copy.remove();
                arr[digit(current, i)].insert(current);                
            }
            
            for(int j=0; j<10; j++)
            {
                while (!arr[j].isEmpty())
                {
                    copy.insert(arr[j].remove());    
                }
            }
            
	    }
	    return copy;
	}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public static void tree11a (BinNode<Integer> t) 
	{
        if (t == null) 
            return;
        
        if (t.getValue() % 2 == 0) 
        {
            boolean hasEvenChild = false;

            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (t.hasRight() && t.getRight().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (!hasEvenChild) 
                System.out.println(t.getValue());
        }
        tree11a(t.getLeft());
        tree11a(t.getRight());
	}
	
	
	
	
	public static int tree11b (BinNode<Integer> t) 
	{
        if (t == null) 
            return 0;
        
        int count=0;
        
        if (t.getValue() % 2 == 0) 
        {
            boolean hasEvenChild = false;

            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (t.hasRight() && t.getRight().getValue() % 2 == 1) 
                hasEvenChild = true;

            if (!hasEvenChild) 
                count=1;
        }
        return count + tree11b(t.getLeft()) + tree11b(t.getRight());
	}
	
	
	
	
    public static boolean tree11c(BinNode<Integer> t)
    {
        if (t == null)
            return false;
    
        boolean bool = false;
    
        if (t.getValue() % 2 == 0)
        {
            boolean hasOddChild = false;
    
            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1)
                hasOddChild = true;
    
            if (t.hasRight() && t.getRight().getValue() % 2 == 1)
                hasOddChild = true;
    
            if (!hasOddChild)
                bool = true;
        }
        return bool || tree11c(t.getLeft()) || tree11c(t.getRight());
    }
    
    
   
    
    public static boolean tree11d(BinNode<Integer> t)
    {
        if (t == null)
            return false;   
    
        boolean bool = true;
    
        if (t.getValue() % 2 == 0)
        {
            if (t.hasLeft() && t.getLeft().getValue() % 2 == 1)
                bool = false;
    
            if (t.hasRight() && t.getRight().getValue() % 2 == 1)
                bool = false;
        }
        return bool && tree11d(t.getLeft()) && tree11d(t.getRight());
    }
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	
	public static void main(String [] args)
	{
	    int [] a = {1,2,2,5};
	    int [] b = {3,18,21,81};
        Queue <Integer> q1 = buildQueue(a);
        Queue <Integer> q2 = buildQueue(b);
        
	    System.out.println(max(q1));
	    System.out.println(digitsCount(3895));
	    System.out.println(digit(3895, 3));
	    System.out.println(sort(q2));


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		BinNode<Integer> t15 = new BinNode<Integer>(15);
		BinNode<Integer> t14 = new BinNode<Integer>(14);
		BinNode<Integer> tree = new BinNode<Integer>(t15, 3, t14);
		BinNode<Integer> t9 = new BinNode<Integer>(9);
		tree.getLeft().setLeft(new BinNode<Integer>(t9, 6, new BinNode<Integer>(7)));
		tree.getLeft().setRight(new BinNode<Integer>(new BinNode<Integer>(34), 56, new BinNode<Integer>(12)));

		
	    tree11a(tree);
		System.out.println(tree11b(tree));
		System.out.println(tree11c(tree));
		System.out.println(tree11d(tree));
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	    
	    
	}
	

}   




