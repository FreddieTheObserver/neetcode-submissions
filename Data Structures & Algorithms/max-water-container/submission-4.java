class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while (l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            res = Math.max(res, area);

            if (heights[l] < heights[r]) {
                l += 1;
            } else {
                r -= 1;
            }
        }
        return res;
    }
}
