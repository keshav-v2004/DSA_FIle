class Solution {
    public String sortVowels(String s) {
        
        Map<Character , Each> map = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                map.putIfAbsent(ch , new Each(ch,i , 0));

                map.get(ch).freq = map.get(ch).freq+1;
            }
        }

        PriorityQueue<Each> pq = new PriorityQueue<>((a,b)->{
            if(a.freq != b.freq){
                return Integer.compare(b.freq , a.freq);
            }
            else{
                return Integer.compare(a.index , b.index);
            }
        });

        for(Each each : map.values()){
            pq.offer(each);
        }

        StringBuilder answer = new StringBuilder(s);
        int i = 0;

        int n = s.length();

        while(!pq.isEmpty()){
            
            Each each = pq.poll();
            char ch = each.ch;
            int freq = each.freq;

            while(i < n){
                char current = answer.charAt(i);

                if(!(current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u')){
                    i++;
                }
                else{
                    answer.setCharAt(i , ch);
                    freq--;
                    i++;

                    if(freq == 0){
                        break;
                    }
                }
            }
        }
        return answer.toString();
    }
}

class Each{
    char ch;
    int index;
    int freq;

    Each(char ch ,int index , int freq){
        this.index = index;
        this.freq = freq;
        this.ch = ch;
    }
}