// https://leetcode.com/problems/basic-calculator-ii/

// Time Complexity: O(n)
// Space Complexity: O(n) where n is stack space
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

import java.util.Stack;

public class basicCalculator {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        char currSign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (currSign == '+') {
                    st.push(currNum);
                } else if (currSign == '-') {
                    st.push(-currNum);
                } else if (currSign == '*') {
                    st.push(st.pop() * currNum);
                } else if (currSign == '/') {
                    st.push(st.pop() / currNum);
                }
                currNum = 0;
                currSign = c;
            }
        }

        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;
    }
}
