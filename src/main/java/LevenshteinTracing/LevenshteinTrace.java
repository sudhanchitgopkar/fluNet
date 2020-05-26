package LevenshteinTracing;

import java.util.Arrays;

public class LevenshteinTrace {

	private static int[][] distance;

	//constructor
	public LevenshteinTrace() {

	}

	//computes the minimum of three integers
	private int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	//computes Levenshtein's distance
	public int computeLevenshteinDistance(CharSequence lhs, CharSequence rhs) {
		distance = new int[lhs.length() + 1][rhs.length() + 1];

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

	public String [][] pathGen(CharSequence lhs, CharSequence rhs) {

		int top;
		int diag;
		int left;
		int minim;

		String[][] path = new String [lhs.length() + 1] [rhs.length() + 1];
		int [] targetLocation = new int[2];

		targetLocation[0] = lhs.length();
		targetLocation[1] = rhs.length();

		//sets all path [][] values to "x"
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < rhs.length() + 1; j++) {
				path [i] [j] = "x";
			} //for
		} //for

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

			minim = minimum(top,diag,left);

			if (minim != Integer.MAX_VALUE && minim == top) {
				targetLocation[0] -= 1;
				path[targetLocation[0]][targetLocation[1]] = "\\";
				System.out.println("INSERTION");
				System.out.println();
			} //top

			if (minim != Integer.MAX_VALUE && minim == diag) {
				targetLocation[0] -= 1;
				targetLocation[1] -= 1;
				path[targetLocation[0]][targetLocation[1]] = "-";
				System.out.println("SUBSTITUTION");
				System.out.println();
			} //top

			if (minim != Integer.MAX_VALUE && minim == left) {
				targetLocation[1] -= 1;
				path[targetLocation[0]][targetLocation[1]] = "/";
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

	private boolean checkNull(int x, int y) {
		if (distance[x][y] >= 0) {
			return true;
		} else {
			return false;
		} //if

	} //checkNull


}
