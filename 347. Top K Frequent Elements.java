
//TC - O(n)
//SC - O(n)
//we can use PQ to solve, but it will O(n log k)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0)
			return new int[] {};
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		HashMap<Integer, List<Integer>> fmap = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int key : map.keySet()) {
			int freq = map.get(key);
			if (!fmap.containsKey(freq)) {
				fmap.put(freq, new ArrayList<>());
				min = Math.min(min, freq);
				max = Math.max(max, freq);
			}
			fmap.get(freq).add(key);
			System.out.println(fmap);
		}
		int[] output = new int[k];
		int idx = 0;
		for (int i = max; i >= min && idx < k; i--) {
			List<Integer> li = fmap.get(i);
			if (li != null) {
				for (int j = 0; j < li.size() && idx < k; j++) {
					output[idx] = li.get(j);
					idx++;
				}
			}
		}

		return output;
	}
}
