package org.sk.trie;

import lombok.Getter;

@Getter
public class TrieNode {


    private final TrieNode[] childNode;
    private boolean endOfWord;

    public TrieNode() {
        childNode = new TrieNode[26];
    }
    public void setEndOfWord(boolean value) {
        endOfWord = value;
    }

}
