class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix and len(matrix) == 0:
            return False

        rows, cols = len(matrix), len(matrix[0])
        l, r = 0, rows * cols - 1
        
        while l <= r:
            m = (l + r) // 2
            r_index = m // cols
            c_index = m % cols

            val = matrix[r_index][c_index]

            if val > target:
                r = m - 1
            elif val < target:
                l = m + 1
            else:
                return True
        return False