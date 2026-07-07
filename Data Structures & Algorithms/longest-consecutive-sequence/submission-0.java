class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0, cur = nums[0], streak = 0, i = 0;

        while (i < nums.length) {
            if (cur != nums[i]) {
                cur = nums[i];
                streak = 0;
            }
            while (i < nums.length && nums[i] == cur) {
                i++;
            }
            streak++;
            cur++;
            res = Math.max(res, streak);
        }
        return res;
    }
}
