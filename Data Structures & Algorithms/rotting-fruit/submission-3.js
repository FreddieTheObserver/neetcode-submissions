class Solution {
    /**
     * @param {number[][]} grid
     * @return {number}
     */
    orangesRotting(grid) {
            const rows = grid.length;
    const cols = grid[0].length;

    const queue = [];
    let fresh = 0;
    let time = 0;

    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            if (grid[r][c] == 1) fresh++;
            if (grid[r][c] == 2) queue.push([r, c]);
        }
    }

    const directions = [[1, 0], [-1, 0], [0, 1], [0, -1]];

    while (queue.length > 0 && fresh > 0) {
        let size = queue.length;

        for (let i = 0; i < size; i++) {
            const [r, c] = queue.shift();

            for (const [dR, dC] of directions) {
                const dr = r + dR;
                const dc = c + dC;

                if (
                    dr < 0 || dr >= rows ||
                    dc < 0 || dc >= cols ||
                    grid[dr][dc] !== 1
                ) continue;

                grid[dr][dc] = 2;
                fresh--;
                queue.push([dr, dc]);
            }
        }
        time++;
    }
    return fresh === 0 ? time : -1;
    }
}
