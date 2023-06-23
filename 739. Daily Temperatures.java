class Solution {
    public int[] dailyTemperatures (int[] temperatures) {

        int[] answer = new int[temperatures.length];
        Stack<Pair<Integer, Integer>> tStack = new Stack<>(); // Index, temperature

        for (int i = 0; i < temperatures.length; i++) {
            while (!tStack.empty() && temperatures[i] > tStack.peek().getValue()) {
                Pair<Integer, Integer> newPair = tStack.pop();
                answer[newPair.getKey()] = i - newPair.getKey();
            }
            Pair<Integer, Integer> duo = new Pair<>(i, temperatures[i]);
            tStack.push(duo);
        }
        return answer;
    }
}