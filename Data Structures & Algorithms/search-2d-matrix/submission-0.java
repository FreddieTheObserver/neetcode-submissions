class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> newMat = new ArrayList<>();
        
        for (int[] row : matrix) {
            for (int num : row) {
                newMat.add(num);
            }
        }

        int L = 0, R = newMat.size() - 1;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (target > newMat.get(mid)) {
                L = mid + 1;
            } else if (target < newMat.get(mid)) {
                R = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
