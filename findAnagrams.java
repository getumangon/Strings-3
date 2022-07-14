// https://leetcode.com/problems/find-all-anagrams-in-a-string/

// Time Complexity: O(n)
// Space Complexity: O(n) where n is smallest string
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            
        }
        
        int match = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                count--;
                if(count == 0) match++;
                map.put(c, count);
            }
            
            if(i >= p.length()) {
                char output = s.charAt(i - p.length());
                 if(map.containsKey(output)){
                    int count = map.get(output);
                    count++;
                    if(count == 1) match--;
                    map.put(output, count);
                }
            }
            if(match == map.size()) result.add(i - p.length() + 1);
        }
        return result;
    }
}