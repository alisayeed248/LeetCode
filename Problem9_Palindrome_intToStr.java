class Solution {
    public boolean isPalindrome(int x) {
        // how can get a palindrome; let's try the string as an array, hashmap?
        // HashMap <Integer, Integer> newMap = new HashMap <Integer, Integer>(); // key, value
        // can't see how a hashmap can be easily used, let's just try converting int
        // to string or modulo?
        String intStr = Integer.toString(x);
        // use charAt for getting char at index and .length
        for (int i = 0; i < intStr.length(); i++) { // 0 and 2
            if (intStr.charAt(i) != intStr.charAt(intStr.length() - (i + 1))) {
                return false;
            }
        }
        return true;
        
    }
}
