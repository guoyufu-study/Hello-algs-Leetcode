package com.jasper.algs.interview.qu1602.solu2;

/**
 * 面试题 16.02. 单词频率
 * 
 * <p> 前缀树
 */
class WordsFrequency {

	Trie trie;
	
    public WordsFrequency(String[] book) {
    	trie = new Trie();
    	for(String word : book)
    		trie.addWord(word);
    }
    
    public int get(String word) {

    	return trie.getCount(word);
    }
}

class Trie {
	TrieNode root;
	
	Trie() {
		root = new TrieNode();
	}
	
	void addWord(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(!node.containsKey(ch)) 
				node.put(ch, new TrieNode());
			node = node.get(ch);
		}
		node.setEnd();
	}
	
	int getCount(String word) {
		TrieNode node = root;
		for (int i = 0; i<word.length() && node!=null; i++) {
			node = node.get(word.charAt(i));
		}
		
		return node==null ? 0 : node.count;
	}
}

class TrieNode {
	
	TrieNode[] links;
	int count;
	
	public TrieNode() {
		links = new TrieNode[26];
	}
	
	public boolean containsKey(char ch) {
		return links[ch-'a']!=null;
	}

	void setEnd() {
		count++;
	}
	
	TrieNode get(char ch) {
		return links[ch-'a'];
	}
	
	void put(char ch, TrieNode node) {
		links[ch-'a'] = node;
	}
}