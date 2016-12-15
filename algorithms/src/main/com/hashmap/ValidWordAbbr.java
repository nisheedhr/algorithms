package com.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
Show Company Tags
Show Tags
Show Similar Problems

 * @author nraveend
 *
 */
public class ValidWordAbbr {

	private Map<String, String> lookup = new HashMap<>();
	private Set<String> dups = new HashSet<>();
	
	public ValidWordAbbr(String[] dictionary) {
		for (int i = 0; i < dictionary.length; ++i) {
			String word = dictionary[i];
			if (word.length() <= 2) {
				if (!lookup.containsKey(word)) {
					lookup.put(word, word);
				}
			} else if (word.length() > 2) {
				String abbr = getAbbr(word);
				if (!lookup.containsKey(abbr)) {
					lookup.put(abbr, word);
				}
				else {
					dups.add(abbr);
				}
			}
		}
	}



    private String getAbbr(String word) {
		StringBuilder sb = new StringBuilder();
		sb.append(word.charAt(0));
		sb.append(word.length() - 2);
		sb.append(word.charAt(word.length() -1));
		return sb.toString();
	}

	public boolean isUnique(String word) {
		if(word.length() > 2){
        	return !lookup.containsKey(getAbbr(word)) ||
        			( lookup.get(getAbbr(word)).equals(word) && !dups.contains(getAbbr(word)));
        }	else {
        	return !lookup.containsKey(word) ||
        			(lookup.get(word).equals(word) && !dups.contains(word));
        }
    }
}
