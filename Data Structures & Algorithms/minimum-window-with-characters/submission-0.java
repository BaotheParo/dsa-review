class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length()<t.length()) return "";
        Map<Character, Integer> countT = new HashMap<>();
        for(char c: t.toCharArray()){
            countT.put(c,countT.getOrDefault(c,0)+1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int have=0, need=countT.size();

        int minLen = Integer.MAX_VALUE;
        int resLeft = -1, resRight = -1;

        int left = 0;
        for (int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0)+1);
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }
            while (have == need){
                if((right-left+1)<minLen){
                    minLen = right - left + 1;
                    resLeft = left;
                    resRight = right;
                }
                char charLeft = s.charAt(left);
                window.put(charLeft, window.get(charLeft)-1);
                if (countT.containsKey(charLeft) && window.get(charLeft)< countT.get(charLeft)){
                    have--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight + 1);
    }
}
