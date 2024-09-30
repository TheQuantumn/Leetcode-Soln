class CustomStack {
    private int[] stack;
    private int top;

    // Constructor to initialize the stack with maxSize
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;  // Start with an empty stack
    }
    
    // Push operation: Add element if stack isn't full
    public void push(int x) {
        if (top < stack.length - 1) {
            stack[++top] = x;
        }
    }
    
    // Pop operation: Remove and return the top element
    public int pop() {
        if (top == -1) {
            return -1;  // Stack is empty
        }
        return stack[top--];
    }
    
    // Increment operation: Increment bottom k elements by val
    public void increment(int k, int val) {
        // We only want to increment the bottom k elements (or all if fewer than k)
        int limit = Math.min(k, top + 1);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}
