class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        boolean found = false;

        for(String str : wordList){
            if(str.equals(endWord)){
                found = true;
                break;
            }
        }

        if(found==false) return 0;

        Set<String> allPossible = new HashSet<>();


        for(String str : wordList){
            allPossible.add(str);
        }

        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        visited.add(beginWord);


        int steps = 1;

        while(!q.isEmpty()){

            int size = q.size();

            for(int i = 0 ; i < size ; i++){

                StringBuilder currentWord = new StringBuilder(q.poll());
                int n = currentWord.length();

                for(int k = 0 ; k < n ; k++){

                    StringBuilder updatedWord = new StringBuilder(currentWord.toString());

                    for(int j = 0 ; j < 26 ; j++){

                        char updated = (char)((int)('a') + j)  ;
                        updatedWord.setCharAt(k , updated);

                        if(currentWord.charAt(k) == updated) continue;

                        if(updatedWord.toString().equals(endWord)){
                            return steps+1;
                        }

                        if(allPossible.contains(updatedWord.toString()) && !visited.contains(updatedWord.toString())){
                            visited.add(updatedWord.toString());
                            q.offer(updatedWord.toString());

                        }
                    }
                }

            }
            steps++;

        }

        return 0;
    }



}