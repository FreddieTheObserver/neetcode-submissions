class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Key = number, Value = how many times it appears
        Map<Integer, Integer> count = new HashMap<>();

        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        // getOrDefault returns 0 if number not in map, then increment by 1
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        // entry.getKey() = the number
        // entry.getValue() = frequency of that number
        // freq[frequency].add(number) puts number in appropriate bucket
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        
        // Step 7: Traverse buckets from highest frequency to lowest
        // Start from freq.length - 1 (highest frequency) down to 1
        // Stop when we've collected k elements
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}