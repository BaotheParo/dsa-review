class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums){
            countMap.put(num,countMap.getOrDefault(num,0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : countMap.keySet()) {
            int frequency = countMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int [] result = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i>=0;i--){
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[index++] = num;
                    if (index == k) {
                        return result; // Đủ k phần tử thì return ngay
                    }
                }
            }
        }
        return result;
    }
}
