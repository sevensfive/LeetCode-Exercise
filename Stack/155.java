class MinStack {

    Stack<Integer> stk = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        // 当 x 小于当前最小值 min， 将 min 和 x 先后push到stack里， 并更新此时的最小值 min = x
        if (x <= min) {
            stk.push(min);
            min = x;
        }
        stk.push(x);

    }

    public void pop() {
        // 当pop的值等于当前最小值 min， 多进行一次pop操作，并更新此时的最小值
        if (stk.pop() == min)
            min = stk.pop();
    }

    public int top() {
        return stk.peek();

    }

    public int getMin() {
        return min;

    }
}
