class CustomStack {
    int maxSize;
    ArrayList<Integer> arr;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new ArrayList<>();


    }
    
    public void push(int x) {
        if(arr.size() < maxSize){
            arr.add(x);
        }

    }
    
    public int pop() {
        if(arr.isEmpty()) return -1;
        int val =  arr.get(arr.size()-1);
        arr.remove(arr.size()-1);

        return val;
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, arr.size());

        for (int i = 0; i < limit; i++) {
            arr.set(i, arr.get(i) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */