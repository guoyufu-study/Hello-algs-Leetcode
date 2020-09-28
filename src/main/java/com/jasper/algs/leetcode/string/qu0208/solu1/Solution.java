package com.jasper.algs.leetcode.string.qu0208.solu1;

/**
 * 0208. 实现 Trie (前缀树)
 *
 */
class Trie {

	private TrieNode root;

	/** 初始化 */
	public Trie() {
		root = new TrieNode();
	}

	/** 插入一个单词 */
	public void insert(String word) {
		TrieNode node = root;
		// 逐个字符插入
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containsKey(ch)) {
				node.put(ch, new TrieNode());
			}
			node = node.get(ch);
		}
		// 终点
		node.setEnd();
	}
	
	 private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length() && node!=null; i++) 
           node = node.get(word.charAt(i));
        return node;
    }

	/** 检测单词是否在前缀树中 */
	public boolean search(String word) {
		TrieNode node = searchPrefix(word);
		return node!=null && node.isEnd();
	}

	/** 检测是否前缀 */
	public boolean startsWith(String prefix) {
		return searchPrefix(prefix) != null;
	}
}

/**
 * Trie 对象将被实例化并调用，代码如下: 
 * Trie obj = new Trie(); 
 * obj.insert(word); 
 * boolean param_2 = obj.search(word); 
 * boolean param_3 = obj.startsWith(prefix);
 */

class TrieNode {

	// 最多R个子结点
	private final int R = 26;
	private TrieNode[] links;
	private boolean isEnd;

	public TrieNode() {
		links = new TrieNode[R];
	}

	public boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}

	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}

	public void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}

	public void setEnd() {
		isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}
}
