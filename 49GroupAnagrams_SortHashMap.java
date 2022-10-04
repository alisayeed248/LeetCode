class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
       // convert String to character array
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

// time complexity O(nm) where n is the avg # of chars in each string, and m is the # of strings
