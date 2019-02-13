import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.net.SocketTimeoutException;
import java.util.Arrays;
public class Sort {

	
	private static class Interval {
		private int lower;
		private int upper;
		
		/**
		 * Constructor for interval
		 * @param lower, lower bound
		 * @param upper, upper bound
		 */
		public Interval (int lower , int upper )
		{
			this.lower=lower;
			this.upper=upper;
		}
		
		/**
		 * 
		 * @return returns lower bound
		 */
		public int getLower()
		{
			return lower;
		}
		
		/**
		 * 
		 * @return returns upper bound
		 */
		public int getUpper ()
		{
			return upper;
		}
		
		/**
		 * Checks if two itervals have the same lower and upper bounds
		 */
		public boolean equals ( Object o )
		{
			Interval a = (Interval)o;
			if(this.getLower()==a.getLower() && this.getUpper()==a.getUpper())
			{
				return true;
			}
			return false;
		}
		/**
		 * generates the hashcode
		 */
		public int hashCode() 
		{
			return lower*lower+upper;
		}


	}
	
	/**
	 * Helper function that partitions the array, uses a stack
	 * @param q, given array
	 * @param i, given interval
	 * @param s, stack that stores the intervals 
	 */
	public static <T extends Comparable<T>> void part(Stack<Interval> s,T[] q, Interval i) {
		int f = i.getLower();
		int m = (i.getUpper()+1)/2;
		int l = i.getUpper();
		int temp = f;
		int a = temp + 1;
		
		findMid(q,f,m,l);

		while (a < l) {
			
			if (q[a].compareTo(q[f]) < 0) 
			{
				temp++;
				swap(temp,a,q);
				a++;
			} 
			else 
			{
				a++;
			}
		}
		
		swap(temp,f,q);
		s.push(new Interval(0, temp-1));
		s.push(new Interval(temp+1, l));
		s.pop();
	}
	
	/**
	 * Swaps two elements in the given array
	 * @param arr, given array
	 * @param a, index one
	 * @param b, index two
	 */
		public static <T extends Comparable<T>> void swap(int a, int b,T[] arr) {
			T temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}

	/**
	 * Regular bubble sort
	 * @param arr, given array that is sorted
	 */
		public static <T extends Comparable<T>> void bubble(T[] arr) {
			boolean swap = true;
			T temp;
			
			while(swap)
			{
				swap = false;
				for (int i = 0; i < arr.length-1; i++)
				{
					if (arr[i].compareTo(arr[i+1])>0) 
					{
						temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
						swap = true;
					}
				}
			}
		}

	/**
	 * Finds middle value from the first,middle,last and swaps with the first element if necessary 
	 * @param arr, given array 
	 * @param a, index of first element
	 * @param b, index of middle element
	 * @param c, index of last element
	 */
		public static <T extends Comparable<T>> void findMid(T[] arr, int a, int b, int c) {
			T i = arr[a];
			T j = arr[b];
			T k = arr[c];

			if (i.compareTo(j) < 0)
			{
				if (j.compareTo(k) < 0) 
				{
					swap(a,b,arr);
				} 
				else 
				{
					swap(a,c,arr);
				}
			} 
			else if  (i.compareTo(k) > 0) 
			{
					swap(a,c,arr);
			}
		}
		

		/**
		 * quick sort method
		 * @param array, array that needs to be sorted
		 * @return returns the sorted array
		 */
		public static <T extends Comparable<T>> T[] sort(T[] array) {
			Stack<Interval> s = new Stack<>();
			s.push(new Interval(0, array.length-1));
			
			while (!s.isEmpty()) 
			{
				Interval a = s.pop();
				if (a.getUpper() - a.getLower() <= 3) 
				{
					bubble(array);
				} 
				else 
				{
					part(s,array,a);
				}
			}
			
			return array;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
