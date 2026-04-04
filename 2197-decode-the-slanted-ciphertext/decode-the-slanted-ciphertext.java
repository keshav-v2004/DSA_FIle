class Solution {
    public String decodeCiphertext(String encodedText, int rows) {

        if(rows == 1) return encodedText;

        
        int cols = encodedText.length()/rows;

        char[][] mat = new char[rows][cols];

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                mat[i][j] = ' ';
            }
        }

        int ptr = 0;

        int i = 0;
        int j = 0;

        while(ptr < encodedText.length()){

            char ch = encodedText.charAt(ptr);
            mat[i][j] = ch;
            j++;

            ptr++;

            if(j == cols){
                i = i+1;
                j = 0;
            }


        }

        StringBuilder answer = new StringBuilder();

        int origJ = 0;
        
        j = origJ;
        i = 0;

        while(origJ < cols){
            char ch = mat[i][j];

            answer.append(ch);
            i++;
            j++;
            if(i == rows || j == cols){
                i = 0;
                origJ++;
                j = origJ;
            }
        }

        while(answer.length() > 0){
            if(answer.charAt(answer.length()-1) == ' '){
                answer.deleteCharAt(answer.length()-1);
            }
            else{
                break;
            }
        }
        return answer.toString();

    }
}