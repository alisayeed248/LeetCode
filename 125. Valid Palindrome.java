// Soln 1

class Solution {
    public boolean isPalindrome(String s) {
        // convert s into just letters
        String res = "";
        s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) res += Character.toLowerCase(s.charAt(i));
        }
        System.out.println(res);
        int j = res.length() - 1;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != res.charAt(j)) return false;
            if (i == j || i > j) return true;
            j--;
        }
        return true;
    }
}

// Soln 2

class Solution {
    public boolean isPalindrome(String s) {
        String sClean = ""; // Clean the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                sClean += Character.toLowerCase(s.charAt(i));
            }
            else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'
            || s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sClean += s.charAt(i);
            }
        }

        int z = 1;
        for (int i = 0; i < sClean.length(); i++) {
            if (sClean.charAt(i) != sClean.charAt(sClean.length() - z)) {
                return false; 
            }
            z += 1;
        }
        return true;
    }
}
