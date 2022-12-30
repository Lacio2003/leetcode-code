/**
 * 思路：使用贪心算法，当前字符是'I'的时候，选择当前数字当中的最小值，当前字符是'D'的时候，选择当前数字当中的最大值。最后返回数组即可。
 * 时间复杂度：O(n)
 * 空间复杂度：不算返回答案的数组的话，空间复杂度为O(1)
 */
class Solution {
    public int[] diStringMatch(String s) {
        // 为了方便使用，将s的长度存储在变量s当中
        int n = s.length();
        // 存储答案的数组
        int[] ans = new int[n + 1];

        // 由题意可得，每一次的最佳选择都是选择最大值或者最小值
        int min = 0, max = n;

        // 进行每一次的最优解
        for (int i = 0; i < n; i++) {
            // 每一次是'I'，我们就填充当前数字当中的最小值
            // 每一次是'D'，我们就填充当前数字当中的最大值
            ans[i] = s.charAt(i) == 'I' ? min++ : max--;
        }

        // 当最后结束的时候，最大值和最小值一定是相等的
        ans[n] = min;

        return ans;
    }
}