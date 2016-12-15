package com.suffixtree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegexGenerator {

	private static class TrieNode {
		Map<Character, TrieNode> nodeMap = new HashMap<>();
	}
	
	public String buildRegex(List<String> input) {
		TrieNode root = buildTrie(input);
		return generateRgex(root);
	}

	private String generateRgex(TrieNode root) {
		StringBuilder sb = new StringBuilder();
		visit(root, sb);
		return sb.toString();
	}

	private void visit(TrieNode node, StringBuilder sb) {
		if(node.nodeMap.isEmpty()) {
			return ;
		}
		
		boolean multiChildren = false;
		if(node.nodeMap.size() > 1) {
			multiChildren = true;
			sb.append("(");
		}
		
		for (Map.Entry<Character, TrieNode> entry: node.nodeMap.entrySet()) {
			sb.append(entry.getKey());
			visit(entry.getValue(), sb);
			if (multiChildren) {
				sb.append("|");
			}
		}
		
		if(multiChildren) {
			sb.deleteCharAt(sb.length() -1);
			sb.append(")");
		}
		
	}

	private TrieNode buildTrie(List<String> input) {
		TrieNode root = new TrieNode();
		for(String str: input) {
			TrieNode tmp = root;
			for(int i = 0; i < str.length(); ++i) {
				Character ch = str.charAt(i);
				if(tmp.nodeMap.containsKey(ch)) {
					tmp = tmp.nodeMap.get(ch);
				}
				else {
					TrieNode node = new TrieNode();
					tmp.nodeMap.put(ch, node);
					tmp = node;
				}
			}
		}
		return root;
	}
}
