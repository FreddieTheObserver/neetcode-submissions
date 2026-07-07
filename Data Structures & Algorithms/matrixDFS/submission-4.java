class Solution {
    public int countPaths(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        return dfs(grid, 0, 0, new HashSet<>());
    }

    private int dfs(int[][] grid, int r, int c, Set<String> visit) {
        if (Math.min(r, c) < 0 || 
            r == grid.length || c == grid[0].length ||
            visit.contains(r + "," + c) || grid[r][c] == 1) {
                return 0;
            }
        
        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return 1;
        }

        visit.add(r + "," + c);

        int count = 0;
        count += dfs(grid, r + 1, c, visit);
        count += dfs(grid, r - 1, c, visit);
        count += dfs(grid, r, c + 1, visit);
        count += dfs(grid, r, c - 1, visit);

        visit.remove(r + "," + c);
        return count;
    }
}
