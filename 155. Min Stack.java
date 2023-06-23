// Credit to https://leetcode.com/problems/min-stack/solutions/49010/clean-6ms-java-solution/
// Tail variation

class MinStack {
    private class Node {
        // 10 min
        // (9, 9) --> (10, 9) --> (10, 8) min --> (10, 7)
        // 10 --> 8 --> 12 
        private int val;
        private int min;
        private Node prev;

        public Node(int val, int min, Node prev) {
            this.val = val;
            this.min = min;
            this.prev = prev;
        }
    }

    private Node tail;

    public MinStack() {
    }

    public void push(int val) {
        if (tail == null) {
            tail = new Node(val, val, null);
        }
        else {
            tail = new Node(val, Math.min(val, tail.min), tail);
        }
    }

    public void pop() {
        tail = tail.prev;
    }
    
    public int top() {
        return tail.val;
    }

    public int getMin() {
        return tail.min;
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

class MinStack {
    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }

    private Node head;

    public MinStack() {
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        }
        else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */