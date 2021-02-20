package trie;

import java.util.HashMap;
import java.util.Map;

public class HashMapImplementation {

	public static void main(String[] args) {
		Tries t= new Tries();
		t.insertIterative("word");
		t.insertIterative("prakhar");
		t.insertIterative("prerna");
	    t.insertRecursive("work");
		/*System.out.println(t.searchCompleteWord("prakhar"));
		System.out.println(t.searchCompleteWord("wor"));
		System.out.println(t.searchCompleteWord("prerna"));
		System.out.println(t.searchstartsWith("word" ));
		t.delete("word");
		System.out.println(t.searchCompleteWord("word"));
		System.out.println(t.searchstartsWith("wor"));
		*/t.delete("pr");
		System.out.println(t.searchCompleteWord("prakhar"));
		System.out.println(t.searchstartsWith("pr3"));
	}
}

class Tries {

	private final TrieNode root;

	public Tries() {
		root = new TrieNode();
	}

	class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			super();

			children = new HashMap();
			endOfWord = false;
		}

	}

	public void insertIterative(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;

		}
		current.endOfWord = true;
	}

	public void insertRecursive(String word) {

		insertRecursive(root, word, 0);
	}

	private void insertRecursive(TrieNode current, String word, int index) {
		if (index == word.length()) {
			current.endOfWord = true;
			return;
		}

		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			node = new TrieNode();
			current.children.put(ch, node);
		}

		insertRecursive(node, word, index + 1);

	}

	public boolean searchCompleteWord(String word) {
		  //TrieNode node= iterativeSearch( word);
		  //return node!=null && node.endOfWord;
		  TrieNode node= iterativeSearch( word);
		  return node!=null && node.endOfWord;
	}

	public boolean searchstartsWith(String word) {
		 // TrieNode node= iterativeSearch( word);
		  //return node!=null;
		  TrieNode node= iterativeSearch( word);
		  return node!=null;
		  
	}
	
	private TrieNode iterativeSearch(String word) {
		TrieNode current =root;
		for(int i=0;i<word.length();i++) {
			char ch=word.charAt(i);
			TrieNode node =current.children.get(ch);
			if(node==null)
				return null;
			current =node;
		}
		return current;
		
		
	}
	
	private TrieNode recursiveSearch(String word) {
		return recursiveSearch(root,word,0);
	}
	
	private TrieNode recursiveSearch(TrieNode current, String word, int index) {
		if(index==word.length())
		{
			return current;
		}
		
		char ch= word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node==null)
			return null;
		
		return recursiveSearch(node,word,index+1);
		
	}
	
	public void delete(String word) {
		deleteRecursive(root,word,0);
	}
	
	private boolean deleteRecursive(TrieNode current, String word, int index) {
		if(index==word.length()) {
			
			if(!current.endOfWord)
				return false;
			
			current.endOfWord=false;
			
			return current.children.size()==0;
		}
		
		char ch= word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node==null)
			return false;
		
		boolean shouldDeleteCurrentNode = deleteRecursive(node, word, index+1);
		
		if(shouldDeleteCurrentNode) {
			current.children.remove(ch);
			
			return current.children.size()==0;
		}
		return false;
	}
	
	
	
}
