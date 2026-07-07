/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * @param {TreeNode} root
     * @param {number} targetSum
     * @return {boolean}
     */
    hasPathSum(root, targetSum) {
        const dfs = (node, curSum) => {
            if (!node) return false;

            curSum += node.val;
            if (!node.left && !node.right) {
                return curSum == targetSum;
            }

            return dfs(node.left, curSum) || dfs(node.right, curSum);
        };

        return dfs(root, 0)
    }
}
