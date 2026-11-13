class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        //1. Count the frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }
        
        //2. Create buckets where index = frequency
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(buckets[freq] == null){
                buckets[freq] =  new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        //3. Gather top k elements starting from highest freq
        int index = 0;
        for(int i = buckets.length - 1; i>=0 && index<k;i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    result[index++] = num;
                    if(index == k) break;
                }
            }
        }

        return result;
    }
}
