class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // first check if strings are of equal length
        
        char tempArray1[] = s.toCharArray(); // convert both strings to character arrays to use sort() function in Arrays library
        char tempArray2[] = t.toCharArray();
        Arrays.sort(tempArray1);
        Arrays.sort(tempArray2);
        
        for (int i = 0; i < tempArray1.length; i++) { // iterate through sorted array and ensure each value at index i is equal in both new char arrays
            if (tempArray1[i] != tempArray2[i]) return false;
        }
        
        return true;
    }
}
