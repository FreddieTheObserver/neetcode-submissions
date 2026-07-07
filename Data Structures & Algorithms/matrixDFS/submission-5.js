class Solution {
    /**
     * @param {number[][]} grid
     * @returns {number}
     */
    countPaths(grid) {
        const ROWS = grid.length;
        const COLS = grid[0].length;

        function dfs(r, c, visit) {
            if (Math.min(r, c) < 0 ||
                r === ROWS ||
                c === COLS ||
                visit.has(`${r}-${c}`) ||
                grid[r][c] === 1) {
                    return 0;
                }
            if (r === ROWS - 1 && c === COLS - 1) {
                return 1;
            }

            visit.add(`${r}-${c}`);

            let count = 0;
            count += dfs(r + 1, c, visit);
            count += dfs(r - 1, c, visit);
            count += dfs(r, c + 1, visit);
            count += dfs(r, c - 1, visit);

            visit.delete(`${r}-${c}`);
            return count;
        }
        return dfs(0, 0, new Set());
    }
}
