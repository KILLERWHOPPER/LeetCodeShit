import java.util.HashMap;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count=0;
        char last=null;
        String token="";
        HashMap<String, Integer> table=new HashMap<String, Integer>(); 
        for(char cur:s.toCharArray()){
            if(cur==last){
                table.put(token, count);
                count =0;
                continue;
            }

        }
        return 0;
    }
}
// @lc code=end

