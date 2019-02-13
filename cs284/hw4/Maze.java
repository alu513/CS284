import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * 
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

	/** The maze */
	private TwoDimGrid maze;

	public Maze(TwoDimGrid m) {
		maze = m;
	}

	/** Wrapper method. */
	public boolean findMazePath() {
		findAllMazePaths(0, 0);
		findMazePathMin(0,0);
		return findMazePath(0, 0); // (0, 0) is the start point.
	}

	/**
	 * Attempts to find a path through point (x, y).
	 * 
	 * @pre Possible path cells are in BACKGROUND color; barrier cells are in
	 *      ABNORMAL color.
	 * @post If a path is found, all cells on it are set to the PATH color; all
	 *       cells that were visited but are not on the path are in the
	 *       TEMPORARY color.
	 * @param x
	 *            The x-coordinate of current point
	 * @param y
	 *            The y-coordinate of current point
	 * @return If a path through (x, y) is found, true; otherwise, false
	 */
	public boolean findMazePath(int x, int y) {
		if (x < 0 || y < 0 || x > maze.getNCols() - 1 || y > maze.getNRows() - 1) {
			return false;
		}
		if (!maze.getColor(x, y).equals(NON_BACKGROUND)) {
			return false;
		}
		maze.recolor(x, y, PATH);
		if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
			return true;
		}
		if (findMazePath(x - 1, y) || findMazePath(x + 1, y) || findMazePath(x, y + 1) || findMazePath(x, y - 1)) {
			return true;
		} else {
			maze.recolor(x, y, TEMPORARY);
			return false;
		}

	}
	
	/**
	 * Helper function for finding all the paths to the exit
	 * @param x, x coordinate
	 * @param y, y coordinate
	 * @param result, list of successful paths up until now
	 * @param trace, current path being explored
	 */

	public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
		if (x < 0 || y < 0 || x > maze.getNCols() - 1 || y > maze.getNRows() - 1) {
			;
		} else if (!maze.getColor(x, y).equals(NON_BACKGROUND)) {
			;
		} else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) {
			// maze.recolor(x, y, PATH);
			trace.push(new PairInt(x, y));
			ArrayList<PairInt> z = new ArrayList<PairInt>();
			z.addAll(trace);
			trace.pop();
			result.add(z);
		} else {
			maze.recolor(x, y, TEMPORARY);
			trace.push(new PairInt(x, y));
			findMazePathStackBased(x + 1, y, result, trace);
			findMazePathStackBased(x - 1, y, result, trace);
			findMazePathStackBased(x, y + 1, result, trace);
			findMazePathStackBased(x, y - 1, result, trace);
			maze.recolor(x, y, NON_BACKGROUND);
			trace.pop();
		}

	}
	
	/**
	 * Finds and returns all the possible paths to the exit
	 * @param x, x coordinate
	 * @param y, y coordinate
	 * @return returns the arraylist of paths
	 */

	public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
		ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
		Stack<PairInt> trace = new Stack<>();
		findMazePathStackBased(0, 0, result, trace);
		System.out.println("All paths: " + result);
		return result;
	}

	/**
	 * Finds the shortest path to the exit
	 * @param x, x coordinate
	 * @param y, y coordinate
	 * @return returns the shortest path
	 */
	public ArrayList<PairInt> findMazePathMin(int x, int y)
	{
		ArrayList<ArrayList<PairInt>> a = findAllMazePaths(x,y);
		System.out.println(a);
		ArrayList<PairInt> temp = new ArrayList<PairInt>();
		int q=maze.getNCols()*maze.getNRows()+1;
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i).size()<q)
			{
				temp = a.get(i);
				q = a.get(i).size();
			}
				
		}
		System.out.println(temp);
		return temp;
	}

	/* <exercise chapter="5" section="6" type="programming" number="2"> */
	public void resetTemp() {
		maze.recolor(TEMPORARY, BACKGROUND);
	}
	/* </exercise> */

	/* <exercise chapter="5" section="6" type="programming" number="3"> */
	public void restore() {
		resetTemp();
		maze.recolor(PATH, BACKGROUND);
		maze.recolor(NON_BACKGROUND, BACKGROUND);
	}
	/* </exercise> */

	
}
/* </listing> */
