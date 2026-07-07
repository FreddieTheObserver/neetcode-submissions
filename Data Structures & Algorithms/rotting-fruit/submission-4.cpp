
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int rows = (int)grid.size();
        int cols = (int)grid[0].size();

        queue<pair<int,int>> q;
        int fresh = 0, time = 0;

        // Count fresh + push all rotten into queue (multi-source BFS)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) fresh++;
                else if (grid[r][c] == 2) q.push({r, c});
            }
        }

        int dr[4] = {1, -1, 0, 0};
        int dc[4] = {0, 0, 1, -1};

        // BFS minute by minute
        while (!q.empty() && fresh > 0) {
            int size = (int)q.size();  // all rotten oranges for this minute

            for (int i = 0; i < size; i++) {
                auto [r, c] = q.front();
                q.pop();

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (grid[nr][nc] != 1) continue; // must be fresh

                    grid[nr][nc] = 2;     // rot it
                    fresh--;
                    q.push({nr, nc});
                }
            }

            time++;
        }

        return (fresh == 0) ? time : -1;
    }
};
