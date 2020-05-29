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

        String rnaSample1 = "CAAACTACCCTGGGTTGCCAT";
        String rnaSameple2 = "ATGGCAACCCAGGGTAGTTTG";

		LevenshteinTrace d = new LevenshteinTrace();
		d.computeLevenshteinDistance(rnaSample1,rnaSample2);
		d.pathGen(rnaSample1,rnaSample2);
	} //main

} //Levenshtein Analysis
