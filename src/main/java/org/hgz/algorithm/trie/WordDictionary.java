package org.hgz.algorithm.trie;

import com.sun.tools.javac.util.Assert;

import java.text.CharacterIterator;

/**
 * https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
 */
public class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root =new TrieNode();
    }

    public void addWord(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        return root.find(word, 0);
    }


    class TrieNode {
        TrieNode[] child;
        boolean hasWord;

        public TrieNode() {
            this.child = new TrieNode[26];
            hasWord = false;
        }

        public void insert(String word, int index) {
            if (index == word.length()) {
                hasWord  = true;
                return;
            }



            int pos = word.charAt(index) - 'a';

            if (child[pos] == null) {
                child[pos] = new TrieNode();
            }
            child[pos].insert(word, index + 1);
        }

        public boolean find(String word, int index) {
            if (index == word.length()) {
                return this.hasWord;
            }

            char c = word.charAt(index);
            // 模糊匹配, 开始分治
            if (c == '.') {
                for (int i = 0; i < child.length; i++) {
                    if(child[i] != null) {
                        boolean b = child[i].find(word, index + 1);
                        if (!b) {
                            continue;
                        }
                        return true;
                    }
                }
                return false;
            } else {
                int pos = word.charAt(index) - 'a';

                if(child[pos] == null) {
                    return false;
                }
                return child[pos].find(word, index + 1);
            }

        }

    }


    public static void main(String[] args) {
    //["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
    //[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
        // [null,null,null,null,null,false,false,null,true,true,false,false,true,false]


        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");

        Assert.check(!wordDictionary.search("a"));
        Assert.check(!wordDictionary.search(".at"));


        wordDictionary.addWord("bat");



        Assert.check(wordDictionary.search(".at"));
        Assert.check(wordDictionary.search("an."));
        Assert.check(!wordDictionary.search("a.d."));
        Assert.check(!wordDictionary.search("b."));
        Assert.check(wordDictionary.search("a.d"));
        Assert.check(!wordDictionary.search("."));


    }
}
