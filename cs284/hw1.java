/**
 * 
 * 
 * @author Alexander Lu
 * I pledge my Honor that I have abided by the Stevens Honor System
 */


public class BinaryNumber {
	private int data[];
	private boolean overflow;
	
	/**
	 * 
	 * Creates a binary number with only zero's of Length length
	 */
	
	public BinaryNumber(int length)
	{
		data = new int[length];
	}
	
	/**
	 * 
	 * Creates a binary number given a string binary number
	 */
	
	public BinaryNumber(String str)
	{
		data = new int[str.length()];
		for(int i=0;i<str.length();i++)
		{
			char s = str.charAt(i);
			int a = Character.getNumericValue(s);
			data[i] = a;
		}
	}
	
	/**
	 * 
	 * returns the length of the binary number
	 */
	
	public int getLength()
	{
		return data.length;
	}
	
	/**
	 * 
	 * returns the digit of a binary number at a specific index
	 */
	
	public int getDigit(int index)
	{
		if(index<0 || index>data.length)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		return data[index];
	}
	
	
	
	/**
	 * 
	 * shifts the binary number to the right with zeros given a specific amount
	 */
	
	public void shiftR(int amount)
	{
		int newData[] = new int[data.length+amount];
		int n=1;
		for(int i=0;i<newData.length;i++)
		{
			if(n>amount)
			{
				newData[i] = data[i-amount];
			}
			n+=1;
		}
		data=newData;
	}
	
	/**
	 * 
	 * adds two binary numbers 
	 */
	
	public void add(BinaryNumber aBinaryNumber)
	{
		if (this.getLength()!=aBinaryNumber.getLength())
		{
			System.out.println("These Binary Numbers are not the same length.");
		}
		else
		{
			int newData[] = new int[aBinaryNumber.getLength()];
			int carry=0;
			for(int i=0;i<newData.length;i++)
			{
				int a = carry + this.getDigit(i) + aBinaryNumber.getDigit(i);
				
				if (a==1)
				{
					carry=0;
					newData[i]=1;
				}
				else if (a==2)
				{
					carry=1;
					newData[i]=0;
				}
				else if (a==3)
				{
					carry=1;
					newData[i]=1;
				}
				
			}
			data=newData;
			
			if(carry==1)
			{
				overflow=true;
			}
			
		}
		
	}
	
	/**
	 * 
	 * converts the binary number to a string and returns it
	 */
	
	public String toString()
	{
		if(overflow==true)
		{
			return "Overflow";
		}
		else
		{
			String s = "";
			for(int i=0; i<data.length; i++)
			{
				s += Integer.toString(data[i]);
			}
			return s;
		}
	}
	
	/**
	 * 
	 * returns the decimal form of a binary number
	 */
	
	public int toDecimal()
	{
		int n=0;
		int total=0;
		for(int i=0;i<data.length;i++)
		{
			total+=(data[i]*Math.pow(2, n));
			n+=1;
		}
		return total;
	}
	
	/**
	 * 
	 * clears overflow
	 */
	
	public void clearOverflow() 
	{
		overflow = false;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}