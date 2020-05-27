package LevenshteinTracing;

import java.util.Arrays;

public class LevenshteinTrace {

    //Levenshtein's Distance Array var
	private static int[][] distance;

	/**
       Basic constructor for Levenshtein's Tracing. Subject to potential future change.
     */

	public LevenshteinTrace() {
	}

	/**
       Computes the minimum of three integers using Math class functionality.
       Important for finding the minimum of edge cells in the distance array.
       @param top - the cell above the target cell
       @param diag - the cell left diagonal to the target cell
       @param left - the cell left of the target cell
       @return the minimum value of the parameters
    */

	private int minimum(int top, int diag, int left) {
		return Math.min(Math.min(top, diag), left);
	}

	/**
       Computes LevenshteinsDistance using two character sequences for comparison.
       @param lhs - the initial string for comparison
       @param rhs - the latter string for comparison
       @return Levenshtein's Distance
     */

	public int computeLevenshteinDistance(CharSequence lhs, CharSequence rhs) {
        //initializing distance 2d array
        distance = new int[lhs.length() + 1][rhs.length() + 1];

        //computes algorithm
		for (int i = 0; i <= lhs.length(); i++)
			distance[i][0] = i;
		for (int j = 1; j <= rhs.length(); j++)
			distance[0][j] = j;

		for (int i = 1; i <= lhs.length(); i++)
			for (int j = 1; j <= rhs.length(); j++)
				distance[i][j] = minimum(
                    distance[i - 1][j] + 1,
                    distance[i][j - 1] + 1,
                    distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

		//prints Levenshtein's Array
		for (int i = 0; i < distance.length; i ++) {
			System.out.println(Arrays.toString(distance[i]));
		} //for

		System.out.println();

		//prints Levensthein's distance
		return distance[lhs.length()][rhs.length()];
	}

    /**
       Generates one optimal path through Levenshtein's Array and corresponding
       character manipulations using two character sequences.
       @param lhs - the initial string for comparison
       @param rhs - the latter string for comparison
       @return a string array of one optimal path through Levenshtein's Array
     */

	public String [][] pathGen(CharSequence lhs, CharSequence rhs) {

        //variable declarations
		int top;
		int diag;
		int left;
		int minim;

        //initializing path array and initial target location
		String[][] path = new String [lhs.length() + 1] [rhs.length() + 1];
		int [] targetLocation = new int[2];

		targetLocation[0] = lhs.length();
		targetLocation[1] = rhs.length();

		//sets all path values to "x"
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < rhs.length() + 1; j++) {
				path [i] [j] = "x";
			} //for
		} //for

        //math initial targetLocation on path
		path[targetLocation[0]][targetLocation[1]] = "O";

		while ((targetLocation[0] != 0) && (targetLocation[1] != 0)) {
			//finds top value
			if(checkNull(targetLocation[0] - 1, targetLocation[1])) {
				top = distance[targetLocation[0] - 1][targetLocation[1]];
			} else {
				top = Integer.MAX_VALUE;
			}
			//finds diagonal value
			if(checkNull(targetLocation[0] - 1, targetLocation[1] - 1)) {
				diag = distance[targetLocation[0] - 1][targetLocation[1] - 1];
			} else {
				diag = Integer.MAX_VALUE;
			}
			//finds left value
			if(checkNull(targetLocation[0], targetLocation[1] - 1)) {
				left = distance[targetLocation[0]][targetLocation[1] - 1];
			} else {
				left = Integer.MAX_VALUE;
			}

            //calculates minimum of cells adjacent to targetLocation
			minim = minimum(top,diag,left);

            //checks for insertion
			if (minim != Integer.MAX_VALUE && minim == top) {
				targetLocation[0] -= 1;
				path[targetLocation[0]][targetLocation[1]] = "-";
				System.out.println("INSERTION");
				System.out.println();
			} //top

            //checks for substitution
			if (minim != Integer.MAX_VALUE && minim == diag) {
				targetLocation[0] -= 1;
				targetLocation[1] -= 1;
				path[targetLocation[0]][targetLocation[1]] = "\\";
				System.out.println("SUBSTITUTION");
				System.out.println();
			} //top

            //checks for deletion
			if (minim != Integer.MAX_VALUE && minim == left) {
				targetLocation[1] -= 1;
				path[targetLocation[0]][targetLocation[1]] = "-";
				System.out.println("DELETION");
				System.out.println();
			} //top


		} //while

		//prints Path Array
		for (int i = 0; i < path.length; i ++) {
			System.out.println(Arrays.toString(path[i]));
		} //for

		System.out.println();



		return path;
	}

    /**
       checks if a particular location on the distance array is null based on params.
       @param x is the x index of the distance array to check
       @param y is the y location of the distance array to check
       @return true if a location is valid (non-null)
     */

	private boolean checkNull(int x, int y) {
		if (distance[x][y] >= 0) {
			return true;
		} else {
			return false;
		} //if

	} //checkNull


}
