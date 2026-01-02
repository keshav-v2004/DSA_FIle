class Solution {
    public String simplifyPath(String path) {

        StringBuilder segment = new StringBuilder();
        int n = path.length();
        Stack<String> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {

            if (i == n || path.charAt(i) == '/') {

                String str = segment.toString();

                if (str.equals("..")) {
                    if (!stack.isEmpty()) {   
                        stack.pop();
                    }
                }
                else if (!str.equals("") && !str.equals(".")) { 
                    stack.push(str);
                }

                segment = new StringBuilder(); 
            }
            else {
                segment.append(path.charAt(i));
            }
        }

        StringBuilder segmentBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            segmentBuilder.insert(0, "/"+stack.pop()); 
        
        }
        
        return segmentBuilder.length() == 0 ? "/" : segmentBuilder.toString();
    }
}
