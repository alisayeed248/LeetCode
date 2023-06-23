class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, String currentString, int openCount, int closedCount, int n) {
        if (openCount == closedCount && openCount == n) {
            res.add(currentString);
            return;
        }

        if (openCount < n) {
            backtrack(res, currentString + "(", openCount + 1, closedCount, n);
        }
        
        if (closedCount < openCount) {
            backtrack(res, currentString + ")", openCount, closedCount + 1, n);
        }
    }
}