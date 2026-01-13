    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            int i = m-1;


            while(i >= 0){

                List<Integer> each = new ArrayList<>();
                int row = i;
                int col =0;

                while(row < m && col < n){
                    each.add(mat[row][col]);
                    row++;
                    col++;
                }
                Collections.sort(each);
                row = i;
                col = 0;
                int index = 0;
                while(row < m && col < n){
                    mat[row][col] = each.get(index);
                    row++;
                    col++;
                    index++;
                }
                i--;
            }


            int j = 1;
            while(j < n){
                
                List<Integer> each = new ArrayList<>();

                int row = 0;
                int col = j;

                while(row < m && col < n){
                    each.add(mat[row][col]);
                    row++;
                    col++;

                }
                Collections.sort(each);
                row = 0;
                col = j;
                int index = 0;

                while(row < m && col < n){
                    mat[row][col] = each.get(index);
                    index++;
                    row++;
                    col++;

                }
                j++;
            }

            return mat;
        }
    }