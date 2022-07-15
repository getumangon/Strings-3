// https://leetcode.com/problems/expression-add-operators/submissions/

// Time Complexity: O(4^n) as we have 4 choices every time
// Space Complexity: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, 0, 0, "", target);
        return result;
    }

    private void helper(String num, int idx, long calc, long tail, String path, int target) {

        // base
        if (idx == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }

        // logic
        for (int i = idx; i < num.length(); i++) {
            // preceeding zero
            if (i != idx && num.charAt(idx) == '0')
                continue;
            long curr = Long.parseLong(num.substring(idx, i + 1));
            if (idx == 0) {
                helper(num, i + 1, curr, curr, path + curr, target);
            } else {
                // +
                helper(num, i + 1, calc + curr, curr, path + "+" + curr, target);
                // -
                helper(num, i + 1, calc - curr, -curr, path + "-" + curr, target);
                // *
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr, target);
            }
        }

    }
}