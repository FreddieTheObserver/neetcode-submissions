class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        const set = new Map();

        for (let i = 0; i < nums.length; i++) {
            const complement = target - nums[i];
            if (set.has(complement)) {
                return [set.get(complement), i];
            }
            set.set(nums[i], i);
        }
        return [];
    }
}
