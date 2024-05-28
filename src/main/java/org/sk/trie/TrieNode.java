package org.sk.trie;


public class TrieNode {
    private final TrieNode[] childNode;
    private boolean endOfWord;

    public TrieNode() {
        childNode = new TrieNode[26];
    }
    public void setEndOfWord(boolean value) {
        endOfWord = value;
    }

    public TrieNode[] getChildNode() {
        return childNode;
    }
    public boolean isEndOfWord() {
        return endOfWord;
    }
}
