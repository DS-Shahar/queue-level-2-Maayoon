import java.util.*;
public class Main 
{	
    
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
	
	
	
	
    

	public static Queue<String> copyString (Queue <String> q) 
	{
        Queue <String> newQ1 = new Queue<>();     
        Queue <String> newQ2 = new Queue<>();
        
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
	
	
	
    
    // גודל קלט: n (מספר האיברים בתור)
    // סיבוכיות : O(n)
	public static Queue<Integer> ex1 (Queue <Integer> q)
	{
        Queue <Integer> copy = copy(q);
	    Queue <Integer> newQ = new Queue<>();

	    int count=0;
	    int last;
	    
	    while (!copy.isEmpty())
	    {
	        count = 1;
	        last = copy.remove();
	        
            while (!copy.isEmpty() && last==copy.head())
            {
                count++;
                copy.remove();
        	}

        	newQ.insert(count);
	    }
	    return newQ;
	}
	
	
	
	
	
	// גודל קלט: n (מספר האיברים בתור)
    // סיבוכיות : O(n^3)
    public static boolean ex2 (Queue <String> q)
	{
        Queue <String> copy = copyString(q);
        String curent = copy.remove();
        int count=0;
	    
	    while (!copy.isEmpty())
	    {
	        copy = copyString(q);
	        for(int i=0; i<count; i++)
	        {
	            copy.remove();
	        }
	        curent=copy.remove();
	        
            while (!copy.isEmpty())
    	    {
                if (curent.equals(copy.remove()))
                {
                    return true;
                }
    	    }
    	    count++;
	    }
	    return false;
	}
	
	
	
	
	// גודל קלט: n (מספר האיברים בתור)
    // סיבוכיות : O(n^2)
	public static Queue <Integer> ex3 (Queue <Integer> q)
	{
        Queue <Integer> copy = copy(q);
        Queue <Integer> newQ = new Queue<>();
        Queue <Integer> temp = new Queue<>();


        boolean bool = false;
        int curent;
        
	    while (!copy.isEmpty())
	    {
	        curent = copy.remove();
            temp = copy(newQ);
            bool = false;

            while (!temp.isEmpty())
    	    {
                if (curent == (temp.head()))
                {
                    bool = true;
                }
                temp.remove();
    	    }
            if (!bool)
            {
                newQ.insert(curent);
            }
	    }
	    return newQ;
	}
	
	
	
	
	// גודל קלט: n (מספר האיברים בתור)
    // סיבוכיות : O(n^2)
    public static Queue<Integer> ex4(Queue<Integer> q)
    {
        Queue<Integer> copy = copy(q);
        Queue<Integer> temp1 = new Queue<>(); 
        Queue<Integer> temp2 = new Queue<>();
        
        while (!copy.isEmpty())
        {
            int min = copy.head();
    
            while (!copy.isEmpty())
            {
                int x = copy.remove();
                if (x < min) 
                    min = x;
                temp1.insert(x);
            }
    
            boolean removed = false;
            while (!temp1.isEmpty())
            {
                int x = temp1.remove();
                if (!removed && x == min) 
                    removed = true;
                else copy.insert(x);
            }
            temp2.insert(min);
        }
        return temp2;
    }
	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args)
	{
	    int [] a = {1,2,2,5};
	    int [] b = {18,21,81,3};
        Queue <Integer> q1 = buildQueue(a);
        Queue <Integer> q2 = buildQueue(b);
        
        Queue <String> qString = new Queue<>();
        qString.insert("hello");
        qString.insert("by");
        qString.insert("no");
        qString.insert("yes");
        qString.insert("police");
        
	    System.out.println(ex1(q1));
	    System.out.println(ex2(qString));
	    System.out.println(ex3(q1));
	    System.out.println(ex4(q2));


	    
	    
	}
	

}   




