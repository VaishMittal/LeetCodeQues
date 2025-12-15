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
    public ListNode reverseList(ListNode head) {
        
        ListNode cur=head;
        if(cur==null)return null;
        if(cur.next==null)return cur;
        ListNode prev=null;
        ListNode nextn = cur.next;
        while(cur!=null){
            nextn=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nextn;
            
        }
        return prev;
    }
}