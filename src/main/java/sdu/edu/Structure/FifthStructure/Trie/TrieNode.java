package sdu.edu.Structure.FifthStructure.Trie;

public class TrieNode {
	public int path;
	public int end;
	public TrieNode[] map;
	public TrieNode(){
		path = 0;
		end = 0;
		map = new TrieNode[26];
	}

}
