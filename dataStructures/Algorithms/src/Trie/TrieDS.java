package Trie;

public class TrieDS {
	
	static final int alphaSize = 26;
	
	static class TrieNode {
		TrieNode[] children = new TrieNode[alphaSize];
		
		boolean isEndOfWord;
		
		TrieNode() {
			for (int i = 0; i < alphaSize; i++) {
				children[i] = null;
			}
			isEndOfWord = false;
		}
	}
	
	static TrieNode root;
	
	
	static boolean search(String key) {
		TrieNode pCrawl = root;
		int index = 0;
		for (int i = 0; i < key.length(); i++) {
			index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null)		
				return false;
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl != null && pCrawl.isEndOfWord);
	}
	
	static void insert(String key) {
		TrieNode pCrawl = root;
		int index = 0;
		for (int i = 0; i < key.length(); i++) {
			index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();
			pCrawl = pCrawl.children[index];
		}
		pCrawl.isEndOfWord = true;
	}
	
	
	
	public static void main(String[] args) {
		 String keys[] = {"the", "dog", "came", "and", "a", "there", "answer", "any", 
                 "by", "bye", "their"};
		 root = new TrieNode();
		 for (int i = 0; i < keys.length; i ++) {
			 insert(keys[i]);
		 }
		 
		 System.out.println("dog " + search("dog"));
		 System.out.println("ans " + search("ans"));
		 System.out.println("byte " + search("byte"));
		 
		
		
	}
}
