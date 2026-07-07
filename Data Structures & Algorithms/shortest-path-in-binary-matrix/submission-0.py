class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])

        if grid[0][0] == 1 or grid[ROWS-1][COLS-1] == 1:
            return -1

        directions = [(0, 1), (0, -1), (1, 0), (-1, 0),
                      (1, 1), (1, -1), (-1, 1), (-1, -1)]

        queue = deque([(0, 0)])
        visit = {(0, 0)}
        length = 1  # counts cells

        while queue:
            for _ in range(len(queue)):
                r, c = queue.popleft()
                if r == ROWS - 1 and c == COLS - 1:
                    return length

                for dr, dc in directions:
                    row, col = r + dr, c + dc
                    if row < 0 or col < 0 or row >= ROWS or col >= COLS:
                        continue
                    if (row, col) in visit or grid[row][col] == 1:
                        continue

                    visit.add((row, col))
                    queue.append((row, col))

            length += 1

        return -1