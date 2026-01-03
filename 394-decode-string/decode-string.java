class Solution {
    public int index = 0;

    public String decodeString(String s) {

        Stack<Integer> stack = new Stack<>();

        return helper(s,stack).toString();

    }

    public StringBuilder helper(String s , Stack<Integer> stack){

        StringBuilder temp = new StringBuilder();

        while(index < s.length()){

            char ch = s.charAt(index);
            if(ch=='['){
                index++;
                temp.append(helper(s,stack));
            }
            else if(ch==']'){
                index++;
                StringBuilder rep = new StringBuilder();
                int count = stack.pop();
                for(int i = 0 ; i <count ; i++){
                    rep.append(temp);
                }
                return rep;

            }
            else if(Character.isDigit(ch)){
                String freq = "";
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    freq += s.charAt(index);
                    index++;
                }
                stack.push(Integer.parseInt(freq));

            }
            else{
                    temp.append(s.charAt(index));
                    index++;
            }
        }  
        return temp;


    }
}