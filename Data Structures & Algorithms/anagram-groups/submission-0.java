class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> res = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];

            for(char c: s.toCharArray()){
                count[c-'a']++;
            }


            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();

            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());

    }
}
