class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> banmap = new HashSet<String>();
        HashSet<String> messageMap = new HashSet<String >();

        for(String str : message){
            messageMap.add(str);
        }
        for(String str : bannedWords){
            banmap.add(str);
        }
        int count = 0;
        for(String str : message){
            if(banmap.contains(str)) count++;
        }
        return count>=2;
    }
}