// Solution 1: Sort and check. O(n log n) for sort

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false; // first check if strings are of equal length
        
        char charSArray[] = s.toCharArray(); // convert both strings to character arrays to use sort() function in Arrays library
        char charTArray[] = t.toCharArray();
        Arrays.sort(charSArray);
        Arrays.sort(charTArray);
        
        for (int i = 0; i < charSArray; i++) { // iterate through sorted array and ensure each value at index i is equal in both new char arrays
            if (charSArray[i] != charTArray[i]) return false;
        } // can also use: return Array.equals(tempArray1, tempArray2)
        
        return true;
    }
}

// Solution 2. HashMap to store character count. Can also consider some form of array of LinkedLists.

class Solution {
  public boolean isAnagram(String s, String t) {
     if (s.length() != t.length()) return false;
     HashMap<Character, Integer> sMap = new HashMap<>();
     HashMap<Character, Integer> tMap = new HashMap<>();
    
     for (int i = 0; i < s.length(); i++) {
        // use either sMap.merge or sMap.computeIfAbsent
         sMap.merge(s.charAt(i), 1, Integer::sum);
         tMap.merge(t.charAt(i), 1, Integer::sum);
     }
    
     if (!sMap.equals(tMap)) return false;
     return true;
    
    /*
    for (int i = 0; i < s.length(); i++) {
         if (sMap.get(s.charAt(i)) != tMap.get(s.charAt(i))) return false;
    } 
    Works for all test cases except the last one
    */
  }
}
