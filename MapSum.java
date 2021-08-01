public class MapSum {

    TrieNode root;

    public MapSum() {
        root = new TrieNode(0);
    }

    public void insert(String key, int val) {
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (current.branches[ch - 'a'] == null) {
                current.branches[ch - 'a'] = new TrieNode(0);
            }
            current = current.branches[ch - 'a'];
        }
        current.val = val;
    }

    public int sum(String prefix) {
        TrieNode current = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (current.branches[ch - 'a'] == null) {
                return 0;
            }
            current = current.branches[ch - 'a'];
        }

        return sum(current);
    }

    public int sum(TrieNode current) {
        int sum = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (current.branches[ch - 'a'] != null) {
                sum += sum(current.branches[ch - 'a']);
            }
        }
        return sum + current.val;
    }

}

class TrieNode {

    TrieNode[] branches;
    int CHARS_IN_ALPHABET = 26;
    int val;

    public TrieNode(int val) {
        this.val = val;
        branches = new TrieNode[CHARS_IN_ALPHABET];
    }
}
