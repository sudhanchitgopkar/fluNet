package LevenshteinTracing;

import LevenshteinTracing.*;
import java.util.Arrays;

/**
   Driver class to test and work with Levenshtein's Tracing.
   @author sudhan.chitgopkar
 */

public class Driver {
	int substitution = 0;
	int insertion = 0;
	int deletion = 0;

	public static void main(String[] args) {
		LevenshteinTrace d = new LevenshteinTrace();
		d.computeLevenshteinDistance("CAAACTACCCTGGGTTGCCAT", "ATGGCAACCCAGGGTAGTTTG");
		d.pathGen("CAAACTACCCTGGGTTGCCAT","ATGGCAACCCAGGGTAGTTTG");
	} //main

} //Levenshtein Analysis
