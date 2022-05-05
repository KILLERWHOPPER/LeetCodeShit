/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode merged = new ListNode();
        ListNode result = merged;
        if (lists.length == 0) {
            return null;
        }
        if(isFinished(lists)){
            return null;
        }
        int tmp = Integer.MAX_VALUE;
        int term = 0;
        int i = 0;
        for (ListNode cur : lists) {
            if (cur == null) {
                i++;
                continue;
            }
            if (cur.val < tmp) {
                tmp = cur.val;
                term = i;
            }
            i++;
        }
        merged.val = tmp;
        lists[term] = lists[term].next;
        // merged = merged.next;
        while (isntFinished(lists)) {
            tmp = Integer.MAX_VALUE;
            term = 0;
            i = 0;
            for (ListNode cur : lists) {
                if (cur != null) {
                    if (cur.val < tmp) {
                        tmp = cur.val;
                        term = i;
                    }
                }
                i++;

            }
            merged.next = new ListNode(tmp);
            lists[term] = lists[term].next;
            merged = merged.next;
        }
        return result;
    }

    private static boolean isntFinished(ListNode[] lists) {
        for (ListNode cur : lists) {
            if (cur == null) {
                continue;
            }
            return true;
        }
        return false;
    }
    private static boolean isFinished(ListNode[] lists){
        for (ListNode cur : lists) {
            if (cur != null) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
