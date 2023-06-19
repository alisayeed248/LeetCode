// Solution 1

public class Solution {
    public String encode(List<String> strs) {
        // given a list like ["lint", "code", "love", "you"]
        // return a string like 4#lint4#code4#love3#you 
        while (!strs.isEmpty()) {
            res = "";
            res += len(strs.get(0)) + "#" + strs.get(0);
            return res;
        }
    }
    public List<String> decode(String str) {
        List<String> res = new List<>();
        int i = 0;
        int j;
        // 4#lint4#code4#love3#you 
        while (i < len(str)) { // i < 23
            j = i; // j = 0
            while (str.charAt(j) != "#") { 
                int count = (int) str.charAt(j-1); // character before the # stored as our count
            } // currently we're at 4# where j = 1; i = 0; we want str.substring(j + 1, j + count - 1)
            res.add(str.substring(j + 1, j + count - 1));
            i = j + count + 1;
        }
        return res;
    }
}
