package com.strings;

/**
 * Given a rows x cols screen and a sentence represented by a list of words, find 
 * how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output: 
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output: 
2

Explanation:
a-bcd- 
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
Example 3:

Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

Output: 
1

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
 * @author nraveend
 *
 */
public class MaxWordsTyping {

	/**
	 * Optimisation for large number of rows. 
	 * Find number of rows where the sentence ends at row end.
	 * Find number of times senetence fully fits and multiply it by total rows/ number of rows.
	 * On the mode value find how many times sentence fits.
	 * @param sentence
	 * @param rows
	 * @param cols
	 * @return
	 */
	public int wordsTyping(String[] sentence, int rows, int cols) {

		int numFit = 0;
		int totLen = rows * cols;
		int lineEnd = cols;
		int arrIndex = 0;
		for(int i = 0; i < totLen;) {
			int wordLenght = sentence[arrIndex].length();
			// move to next line if word overlaps
			if(i + wordLenght > lineEnd) {
				i = lineEnd ;
				lineEnd += cols;
				continue;
			}
			
			if (i + wordLenght <= totLen) {
				i += wordLenght;
				if( i != lineEnd) {
					i = i + 1;
				}

				arrIndex++;
				if(arrIndex == sentence.length) {
					numFit++;
					arrIndex = 0;
					// Optimization by using completely filled rows
					if(i == lineEnd){
						int numRowsForSentence = lineEnd / cols;
						int totalFullyFilledRows = rows / numRowsForSentence;
						numFit = numFit * totalFullyFilledRows;
						i = totalFullyFilledRows * cols * numRowsForSentence;
						lineEnd = i;
					}
				}
			}
			else {
				break;
			}
		}
		return numFit;
	}
}
