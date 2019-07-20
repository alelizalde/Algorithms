package com.practices;

public class Main {

    public static void main(String [ ] args){
        Trie trie = new Trie();
        while(true) {
            trie.addWord("google");
            trie.addWord("walmart");
            trie.addWord("googl");
            trie.addWord("walnart");
        }
    }
}
