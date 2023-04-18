// Solution 1: Sort each string and if same string, add original string to ArrayList in hashmap. O(m n log n), 
// where m is the # of strings and n is the # of characters in each string.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);
            if(!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        List<List<String>> answer = new ArrayList<>();
        answer.addAll(map.values());
        
        return answer;
    }
}

// Solution 2: For each word, create an integer array that represents the count of the characters in each string. 
// Use this array to represent values. Check https://github.com/GryffindorafAviator/LeetCode/blob/master/49.%20Group%20Anagrams.java for much better code.
// O(mn)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // make an array with indices 0 to 26, where 0 represents a and 26 represents z
        HashMap<String, ArrayList<String>> frequencyMap = new HashMap<>();
        for (String s : strs) {
            StringBuilder frequencyString = new StringBuilder("");
            int[] charCount = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int index = (int) s.charAt(i) - (int) 'a';
                charCount[index]++;
            }
            for (int j = 0; j < 26; j++) {
                    while (charCount[j] > 0) {
                        char temp = (char) (j + 97);
                        charCount[j]--;
                        frequencyString.append(temp);
                    }
                }
            if (!frequencyMap.containsKey(frequencyString.toString())) { // let frequencyString be aab
                ArrayList<String> itemsList = new ArrayList<String>();
                itemsList.add(s); // we added bab
                frequencyMap.put(frequencyString.toString(), itemsList); // now we have aab associated with bab
            }
            else {
                frequencyMap.get(frequencyString.toString()).add(s);  // we get the arraylist with bab, and appen baa, so it's [bab, abb]
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for (String s : frequencyMap.keySet()) 
            answer.add(frequencyMap.get(s));
        return answer;
    }
}
