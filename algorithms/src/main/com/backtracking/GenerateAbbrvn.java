package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4
 * @author nisheedh
 *
 */
public class GenerateAbbrvn {

	private static class NumBuilder {
		StringBuilder prefix;
		int num;
		
		NumBuilder(StringBuilder prefix, int num) {
			this.prefix = prefix;
			this.num = num;
		}
	}
	/**
	 * Use recursive calls. by adding char and number to existing string list
	 * Maintain 2 lists. One for text and another for numeric.
	 * Text is built by appending char to previous text and numeric list.
	 * numeric list is built by adding number to text and numeric list.
	 * Merge 2 lists to generate final result.
	 * Complexity 2^(n +1) -2 . Total 2^n strings generated.
	 * @param word
	 * @return
	 */
    public List<String> generateAbbreviations(String word) {
        List<String> textList = new ArrayList<>();
        List<NumBuilder>numList = new ArrayList<>();
        for (int i = 0; i < word.length(); ++i) {
        	generateLists(numList, textList, word.charAt(i));
        }
        
        for (NumBuilder num : numList){
        	textList.add(num.prefix.append(num.num).toString());
        }
        	
        return textList;
    }
    
	private void generateLists(List<NumBuilder> numList, List<String> textList, char ch) {
		List<NumBuilder> numListCopy = new ArrayList<>(numList);
		List<String> textListCopy = new ArrayList<>(textList);
		numList.clear();
		textList.clear();
		
		if (textListCopy.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append(ch);
			textList.add(sb.toString());
			sb.deleteCharAt(sb.length() -1);
			numList.add(new NumBuilder(sb, 1));
			return;
		}
		
		for (String str: textListCopy) {
			StringBuilder sb = new StringBuilder(str);
			sb.append(ch);
			textList.add(sb.toString());
			sb.deleteCharAt(sb.length() -1);
			numList.add(new NumBuilder(sb, 1));
		}
		
		for (NumBuilder num : numListCopy) {
			StringBuilder sb =  new StringBuilder(num.prefix);
			sb.append(num.num);
			sb.append(ch);
			textList.add(sb.toString());
			num.num += 1;
			numList.add(num);
		}
		
	}
}
