class Node{
    Node[] nodes= new Node[26];
    boolean isEnd = false;

    boolean containsKey(char ch){
        if(nodes[ch - 'a'] != null){
            return true;
        }
        return false;

    }

    void setEnd(){
        isEnd = true;
    }

    void put(char ch , Node mover){
        nodes[ch - 'a'] = mover;
    }

    Node get(char ch){
        return nodes[ch-'a'];
    }

    Node(){}

}

class Trie {
    Node root;

    public Trie() {
        root = new Node();

    }
    
    public void insert(String word) {
        Node mover = root;
        int n = word.length();
        for(int i = 0 ; i < n ; i++){
            
            if(!mover.containsKey(word.charAt(i))){
                mover.put(word.charAt(i) , new Node());
            }
            mover = mover.get(word.charAt(i));
        }
        mover.setEnd();
    }
    
    public boolean search(String word) {
        Node mover = root;
        int n = word.length();

        for(int i = 0 ; i < n ; i++){
            char ch = word.charAt(i);

            if(!mover.containsKey(ch)){
                return false;
            }

            mover = mover.get(ch);
        }
        if(mover.isEnd==false) return false;
        return true;

    }
    
    public boolean startsWith(String prefix) {
        Node mover = root;

        int n = prefix.length();
        for(int i = 0 ; i < n ; i++){
            char ch = prefix.charAt(i);

            if(!mover.containsKey(ch)){
                return false;
            }
            mover = mover.get(ch);
        }
        return true;  
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */