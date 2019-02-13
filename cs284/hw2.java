/*
 * Alexander Lu
 * I pledge my Honor that I have abided by the Stevens Honor System
 */
public class Complexity {
    
    /**
     * Loop with complexity O(n)
     * @param int n represents the number the loop stops at
     */
    
    public void method0(int n) { 
        int counter =0;
        for(int i=0; i<n; i++)
        {
            System.out.println("Operation "+counter);
            counter ++;
        }
    }
    
    /**
     * Loop with complexity O(n^2)
     * @param int n represents the number the loop stops at
     */

    public void method1(int n)
    {
        int counter = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.println("Operation "+counter);
                counter ++;
            }
        }
    }
    
    
    /**
     * Loop with complexity O(n^3)
     * @param int n represents the number the loop stops at
     */
    
    public void method4(int n)
    {
        int counter = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                for(int k=0; k<n; k++)
                {
                    System.out.println("Operation "+counter);
                    counter ++;
                }
            }
        }
    }
    
    /**
     * Loop with complexity O(log(n))
     * @param int n represents the number the loop stops at
     */
    
    public void method2(int n)
    {
        int counter = 0;
        for(int i=1; i<n; i*=2)
        {
            System.out.println("Operation "+counter);
            counter ++;
        }
    }
    
    
    /**
     * Loop with complexity O(nlog(n))
     * @param int n represents the number the loop stops at
     */
    
    public void method3(int n)
    {
        int counter = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=1; j<n; j*=2)
            {
                System.out.println("Operation "+counter);
                counter ++;
            }
        }
    }
    
    /**
     * Loop with complexity O(log(log(n)))
     * @param int n represents the number the loop stops at
     */
    
    public void method5(int n)
    {
        int counter = 0;
        for(int i=2; i<n; i = (int)Math.pow(i, 2))
        {
            System.out.println("Operation "+counter);
            counter ++;
        }
    }
    
    /**
     * Recursive function with complexity O(2^n)
     * @param int n represents the number the loop stops at
     */
    public int method6(int n) {
        int counter = 0;
        if (n <= 1) 
        {
            System.out.println("Operation "+counter);
            counter++;
            return 1;
        }
        else 
        {
            System.out.println("Operation "+counter);
            counter++;
            return method6(n - 1) + method6(n - 1);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Complexity one = new Complexity();
        one.method1(300000000);
    }

}