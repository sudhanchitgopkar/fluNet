## Abstract
> This study investigates the potential of a two-stage mathematical model to predict antigenic shifts in the Influenza Virus. The primary stage consists of a Bayesian Network that will be trained to understand the nature of the Influenza Virus and how each strain may mutate. The secondary stage, primarily researched here, seeks to create a means by which to effectively remove erroneous output from the Bayesian Network.

~ Deriving a Mathematical Model for Influenza Strain Prediction, Sudhan Chitgopkar

## Details
This project was developed by [sudhan chitgopkar](https://sudhanchitgopkar.com) during his time as a summer fellow for the Center for Undergraduate Research Opportunities at the University of Georgia. His work was supervised by Dr. Gerasim Iliev over a 6 month span. This work was reviewed and submitted to the Center for Undergraduate Research's Fellowship Final Forum as a talk and to the Summer Undergraduate Mathematics Research Conference as a poster presentation.

**This project is now defunct.**

## Methodology
### Introduction
This project took a variety of approaches to both align and categorize RNA and DNA sequences for alignment to test the best possible Bayesian output-testing.
Such efforts began with initial, naïve string parsing in order to determine what patterns could be readily picked up amongst RNA sequences. Naïve parsing is preferable here as it may prime the data set for more rigorous analysis without constraining the data set in a way that would hinder future analysis. 
### Walk Models & Dyck Paths
Following naïve parsing, walk models and dyck paths are used in order to visualize RNA strands in three (3) categories: the HA Protein, the NA protein, and synthetic strands derived through a Bayesian model. These models are also later used in a novel context for alignment algorithm visualization and prove to be an elegant, intuitive representation of otherwise cumbersome data.
### Algorithm Analysis
Two algorithms are chosen for analysis based on the results of the aforedescribed Walk Models and Dyck Paths: The Needleman-Wunsch Algorithm and Levenshtein's Distance Algorithm. Visualizations are completed manually for experimental and poster examples. A recursive algorithm was developed from scratch for understanding optimal moves of Levensthein's Distance. The two algorithms were thus analyzed.
### Algorithm Visualization
Dyck Paths were used for a visualization of Algorithm performance in RNA sequence alignment with a focus on how algorithm efficiency varied on local and global RNA segments. An interesting, inverse relationship was found regarding complications and accuracy here that may indicate significant differences on optimal algorithm usage for Bayesian output checking.

## Featured Segments
### Backtracing Optimal Levenshtein's Distance Moves 
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
      } //while
      `

## Contact & Permissions
To learn more about this project, [sudhan chitgopkar](https://sudhanchitgopkar.com) is reachable at sudhanchitgopkar@uga.edu.
All diagrams, figures, and the Gemini TeX Poster template are held under an MIT License. Original figures are available upon request.
