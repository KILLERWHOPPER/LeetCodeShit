/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        // head = oHead;
        ListNode oHead = new ListNode();
        ListNode result = oHead;
        int[] cur = new int[k];
        int index = 0;
        // int i =0;
        flag: while (head != null) {
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    index = i-1;
                    break flag;
                }
                cur[i] = head.val;
                head = head.next;

            }
            for (int i = k - 1; i >= 0; i--) {
                oHead.next = new ListNode(cur[i]);
                cur[i] = -1;
                oHead = oHead.next;
            }
        }
        if (index < k - 1) {
            for (int curVal : cur) {
                oHead.next = curVal != -1 ? new ListNode(curVal) : null;
                oHead = oHead.next != null ? oHead.next : oHead;
            }
        } else {
            for (int i = k - 1; i >= 0; i--) {
                if (cur[i] == -1) {
                    continue;
                }
                oHead.next = new ListNode(cur[i]);
                oHead = oHead.next;
            }
        }
        return result.next;
    }
}
// @lc code=end
