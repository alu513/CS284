
public class PairInt {
private int X;
private int Y;


/**
 * Constructor for PairInt
 * @param x, x coordinate
 * @param y, y coordinate
 */
public PairInt(int x,int y)
{
	X = x;
	Y = y;
}


/**
 * gets the x
 * @return, returns the x coordinate
 */
public int getX()
{
	return X;
}

/**
 * gets the y
 * @return, returns the y coordinate
 */
public int getY()
{
	return Y;
}


/**
 * sets the x
 * @param x, sets the x coordinate
 */
public void setX(int x)
{
	X = x;
}

/**
 * sets the y
 * @param y, sets the y coordinate
 */
public void setY(int y)
{
	Y = y;
}

/**
 * checks if the object is equal to the current PairInt
 */
public boolean equals(Object p)
{
	PairInt a = (PairInt)p;
	if(a.getX()==(this.X) && a.getY()==(this.Y))
		return true;
	else
		return false;
}

/**
 * 
 * @return, returns the string of coordinates
 * 
 */
public String toString()
{
	return "C" + this.X + "," + this.Y + ")";
}

/**
 * 
 * makes a copy of the current PairInt 
 * @return, returns the copy
 */
public PairInt copy()
{
	PairInt a = new PairInt(this.X,this.Y);
	return a;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
