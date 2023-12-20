package org.sk.trie;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word.isEmpty()) return;
        TrieNode[] curChildNodes = root.getChildNode();
        TrieNode curRootNode = null;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            curRootNode = curChildNodes[c];
            if (curRootNode == null) {
                curRootNode = curChildNodes[c] = new TrieNode();
            }
            curChildNodes = curRootNode.getChildNode();
        }
        // update last character to true
        curRootNode.setEndOfWord(true);
    }

    public boolean search(String word) {
        if (word.isEmpty()) return false;
        TrieNode[] curChildNodes = root.getChildNode();
        TrieNode curRootNode = null;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            curRootNode = curChildNodes[c];
            if (curRootNode == null) return false;
            curChildNodes = curChildNodes[c].getChildNode();
        }
        return curRootNode.isEndOfWord();
    }

    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) return false;
        TrieNode[] curChildNodes = root.getChildNode();
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (curChildNodes[c] == null) return false;
            curChildNodes = curChildNodes[c].getChildNode();
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.search("app"));
        System.out.println(t.startsWith("app"));
    }

}
