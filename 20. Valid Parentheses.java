class Solution {
    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        HashMap<Character, Character> characterMap = new HashMap<>();
        characterMap.put(')', '(');
        characterMap.put('}', '{');
        characterMap.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (characterMap.containsKey(s.charAt(i))) {
                if (!characterStack.empty() && characterStack.peek() == characterMap.get(s.charAt(i))) {
                    char holder = characterStack.pop();
                } 
                else {
                    return false;
                }
            }
            else {
                characterStack.push(s.charAt(i));
            }
        }
        if (characterStack.empty()) return true;
        else return false;
    }
}