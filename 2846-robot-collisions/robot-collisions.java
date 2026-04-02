class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        
        ArrayList<Each> arr = new ArrayList<>();

        int n = healths.length;

        for(int i = 0 ; i < n ; i++){

            int pos = positions[i];
            int health = healths[i];
            char dir = directions.charAt(i);
            int index = i;

            Each each = new Each(pos , health,dir,index);
            arr.add(each);
        }

        Collections.sort(arr , (a,b)->{
            return Integer.compare(a.pos , b.pos);
        });

        Stack<Each> stack = new Stack<>();

        int i = 0;

        while(i < n){

            Each each = arr.get(i);

            if(stack.isEmpty() || stack.peek().dir == 'L' || each.dir == 'R'){
                stack.push(each);
                i++;
            }

            else if(stack.peek().dir == 'R' && each.dir == 'L'){
                while(
                    !stack.isEmpty() && stack.peek().dir == 'R' && each.dir == 'L' && 
                    each.health > stack.peek().health
                ){
                    stack.pop();
                    each.health = each.health-1;
                }

                if(stack.isEmpty() || stack.peek().dir == 'L' ){
                    stack.push(each);
                    i++;
                }
                else if(each.health < stack.peek().health){
                    stack.peek().health--;
                    i++;
                }
                else if(each.health == stack.peek().health){
                    stack.pop();
                    i++;
                }
            }
        }


        List<Each> answer = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        while(!stack.isEmpty()){
            answer.add(stack.pop());

        }
        Collections.sort(answer , (a,b)->{
            return Integer.compare(a.index , b.index);
        });

        for(Each each : answer){
            output.add(each.health);
        }



        return output;

        

    }
}

class Each{
    int pos;
    int health;
    char dir;

    int index;

    Each(int pos , int health , char dir , int index){
        this.pos = pos;
        this.health = health;
        this.dir = dir;
        this.index = index;
    }
}