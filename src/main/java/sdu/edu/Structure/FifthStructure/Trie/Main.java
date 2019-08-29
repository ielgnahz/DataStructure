package sdu.edu.Structure.FifthStructure.Trie;

public class Main {
	public TrieNode root;

	public Main() {
		root = new TrieNode();
	}

	public void insert(String word) {
		if (word == null) {
			return;
		}
		char[] str = word.toCharArray();
		int index = 0;
		TrieNode cur = root;
		for (int i = 0; i < str.length; i++) {
			index = str[i] - 'a';
			if (cur.map[index] == null) {
				cur.map[index] = new TrieNode();
			}
			cur = cur.map[index];
			cur.path++;
		}
		cur.end++;
	}
	
	public void delete(String word){
		if(search(word)){
			char[] str = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for(int i = 0;i<str.length;i++){
				index = str[i] - 'a';
				if(node.map[index].path-- == 1){
					node.map[index] = null;
					return;
				}
				node = node.map[index];
			}
			node.end--;
		}
	}
	public int prefixNumber(String pre){
		int index = 0;
		TrieNode node = root;
		char[] str = pre.toCharArray();
		for(int i = 0;i<str.length;i++){
			index = str[i]- 'a';
			if(node.map[index] == null){
				return 0;
			}
			node = node.map[index];
		}
		return node.path;
	}
	
	public boolean search(String word) {
		int index = 0;
		TrieNode node = root;
		char[] str = word.toCharArray();
		for (int i = 0; i < str.length; i++) {
			index = str[i] - 'a';
			if (node.map[index] == null) {
				return false;
			}
			node = node.map[index];
		}
		return node.end != 0;
	}
}
