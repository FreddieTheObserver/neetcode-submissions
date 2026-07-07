class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        List<Integer> newList = new ArrayList<>();
        for (int[] row : matrix) {
            for (int x : row) {
                newList.add(x);
            }
        }

        int L = 0, R = newList.size() - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (target > newList.get(mid)) {
                L = mid + 1;
            } else if (target < newList.get(mid)) {
                R = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
