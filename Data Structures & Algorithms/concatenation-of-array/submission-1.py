class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        n = []

        for i in range(2):
            for num in nums:
                n.append(num)
        return n