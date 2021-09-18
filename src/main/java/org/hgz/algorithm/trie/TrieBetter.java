package org.hgz.algorithm.trie;

import com.sun.tools.javac.util.Assert;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree
 */
public class TrieBetter {

    private TrieNode root;

    public TrieBetter() {
        root = new TrieNode();
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        TrieNode trieNode = root.find(word, 0);
        return trieNode != null && trieNode.hasWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode trieNode = root.find(prefix, 0);
        return trieNode != null;

    }



    public static void main(String[] args) {
        TrieBetter trie = new TrieBetter();

        trie.insert("abc");
        trie.insert("abcd");


        boolean abc = trie.search("abc");
        Assert.check(abc);


    }

    class TrieNode {
        TrieNode[] child;
        boolean hasWord;


        public TrieNode() {
            this.child = new TrieNode[26];
            this.hasWord = false;
        }

        public void insert(String word, int index) {
            if (index == word.length()) {
                this.hasWord = true;
                return;
            }

            int pos = word.charAt(index) - 'a';

            if (child[pos] == null) {
                child[pos] = new TrieNode();
            }
            child[pos].insert(word, index + 1);
        }


        public TrieNode find(String word, int index) {
            if (index == word.length()) {
                return this;
            }

            int pos = word.charAt(index) - 'a';

            if (child[pos] == null) {
                return null;
            }
            return child[pos].find(word, index + 1);
        }

    }
}
