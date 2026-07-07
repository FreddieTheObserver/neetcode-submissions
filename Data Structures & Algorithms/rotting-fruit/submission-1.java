class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                for (int[] dir : directions) {
                    int dr = r + dir[0];
                    int dc = c + dir[1];

                    if (dr < 0 || dr >= rows || dc < 0 || dc >= cols) continue;
                    if (grid[dr][dc] != 1) continue;

                    grid[dr][dc] = 2;
                    fresh--;
                    queue.add(new int[]{dr, dc});
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
