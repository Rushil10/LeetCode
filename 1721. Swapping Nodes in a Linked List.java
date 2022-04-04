/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode start = head;
        ListNode left = null;
        ListNode right = null;
        int cnt = 0;
        while(start!=null){
            start=start.next;
            cnt++;
        }
        int s = cnt-k+1;
        int st = 1;
        start=head;
        while(start!=null){
            if(left!=null && right!=null){
                break;
            }
            if(st==k){
                left=start;
            }
            if(st==s){
                right=start;
            }
            start=start.next;
            st++;
        }
        int val = left.val;
        left.val = right.val;
        right.val = val;
        return head;
    }
}