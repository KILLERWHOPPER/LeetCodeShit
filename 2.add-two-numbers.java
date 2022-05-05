/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int startmp = l1.val + l2.val;
        boolean carry = false;
        if (startmp >= 10) {
            startmp -= 10;
            carry = true;
        }
        ListNode result = new ListNode(startmp);
        ListNode realResult = result;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null || carry == true) {

            int tmp = 0;
            if (l1 == null&&l2!=null) {
                tmp = l2.val;
                l2 = l2.next;
                if (carry) {
                    tmp++;
                    carry = false;
                }
                if (tmp >= 10) {
                    tmp -= 10;
                    carry = true;

                }
            } else if (l2 == null&&l1!=null) {
                tmp = l1.val;
                l1 = l1.next;
                if (carry) {
                    tmp++;
                    carry = false;
                }
                if (tmp >= 10) {
                    tmp -= 10;
                    carry = true;

                }
            } else if (l1 != null && l2 != null) {
                tmp = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
                if (carry) {
                    tmp++;
                    carry = false;
                }
                if (tmp >= 10) {
                    tmp -= 10;
                    carry = true;

                }
            } else {
                tmp++;
                carry = false;
            }

            result.next = new ListNode(tmp);
            result = result.next;

        }
        return realResult;
    }
}
// @lc code=end
