class Solution {

    DisjointSet ds;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        ds = new DisjointSet(accounts.size());
        

        ArrayList<Account> details = new ArrayList<>();

        for(int i = 0 ; i < accounts.size() ; i++){

            List<String> each = accounts.get(i);

            int number = i;
            String username = each.get(0);

            List<String> emails = each.subList(1 , each.size());

            details.add(new Account(number , username , emails));

        }

        Map<String , Integer> map = new HashMap<>();

        for(int i = 0 ; i < details.size() ; i++){
            Account each = details.get(i);

            int number = each.number;
            List<String> emails = each.emails;

            for(String eachEmail : emails){

                if(map.containsKey(eachEmail)){
                    int user1 = map.get(eachEmail);
                    int user2 = number;

                    ds.unionByRank(user1 , user2);

                }
                else{
                    map.put(eachEmail , number);

                }
            }
        }

        Map<Integer, List<String>> merged = new HashMap<>();

        for(Map.Entry<String , Integer> entry : map.entrySet()){

            String email = entry.getKey();
            int number = entry.getValue();

            int ultimate_parent = ds.findParent(number);

            merged.putIfAbsent(ultimate_parent , new ArrayList<>());

            merged.get(ultimate_parent).add(email);
        }

        List<List<String>> finalAnswer = new ArrayList<>();

        for(Map.Entry<Integer,List<String>> entry : merged.entrySet()){

            int number = entry.getKey();

            String username = accounts.get(number).get(0);

            List<String> allEmails = entry.getValue();

            Collections.sort(allEmails);

            allEmails.add(0 , username);

            finalAnswer.add(allEmails);
        }
        return finalAnswer;




    }
}

class Account{
    int number;
    String username;

    List<String> emails;

    Account(int number , String username , List<String> emails){
        this.number = number;
        this.username = username;
        this.emails = emails;

    }
}

class DisjointSet{

    int n;
    int[] parent;
    int[] rank;

    DisjointSet(int n){
        this.n = n;
        parent = new int[n];
        rank = new int[n];

        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
    }

    public int findParent(int u){
        if(parent[u] == u){
            return u;

        }
        return parent[u] = findParent(parent[u]);

    }

    public void unionByRank(int u , int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu==pv) return;

        if(rank[pu] < rank[pv]){
            parent[pu] = pv;

        }
        else if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }
} 