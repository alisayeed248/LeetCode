class Solution {
    public int evalRPN(String[] tokens) {
        List<String> operandList = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        // 5 4 + : once we hit an operator, we go back two units and perform that operand
        //  2 1 + 3 *
        // 4 13 5 / +
        Stack<String> operandStack = new Stack<>();
        for (String i : tokens) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i <= tokens.length; i++) {
            if (!operandStack.empty() && operandList.contains(operandStack.peek())) {
                String operand = operandStack.pop();
                int a, b, val;
                switch (operand) {
                    case "*":
                        System.out.println("we");
                        a = Integer.valueOf(operandStack.pop());
                        b = Integer.valueOf(operandStack.pop());
                        val = a * b;
                        operandStack.push(Integer.toString(val));
                        i--;
                        break;
                    case "/":
                        a = Integer.valueOf(operandStack.pop());
                        b = Integer.valueOf(operandStack.pop());
                        val = b / a;
                        operandStack.push(Integer.toString(val));
                        System.out.println(operandStack.peek());
                        i--;
                        break;
                    case "+":
                        a = Integer.valueOf(operandStack.pop());
                        b = Integer.valueOf(operandStack.pop());
                        val = a + b;
                        operandStack.push(Integer.toString(val));
                        System.out.println(operandStack.peek());
                        i--;
                        break;
                    case "-":
                        a = Integer.valueOf(operandStack.pop());
                        b = Integer.valueOf(operandStack.pop());
                        val = b - a;
                        operandStack.push(Integer.toString(val));
                        i--;
                        break;
                    default:  
                        break;
                }
            }
            else {
                if (i == tokens.length) break;
                operandStack.push(tokens[i]);
                System.out.println("Current stack val: " + operandStack.peek());
                System.out.println("Current array val: " + tokens[i]);
                
                }
        }
        return Integer.valueOf(operandStack.pop());
        // Stack: 10 6 9 3 +
        // Array: 10 6 9 3 + -11
    }
}