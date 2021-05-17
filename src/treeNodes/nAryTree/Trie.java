package treeNodes.nAryTree;

/**Структура префиксного дерева, содержащая в себе строки (слова), состоящие из латинских строчных букв
 * @author Сергей Шершавин*/

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**Добавляет новое слово в дерево*/
    public void insert(String word) {
        TrieNode current = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    /** @return  true если переданный параметр содержится в дереве, в противном случае - false */
    public boolean search(String word) {
        TrieNode current = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
        }
        return current.isWord;
    }

    /** @return true если переданный параметр является префиксом по меньшей мере одного из слов в дереве,
     * в противном случае - false */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
        }
        return true;
    }

    static class TrieNode {
        private final TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }

    }
}
