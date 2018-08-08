package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 20:25 2018/8/8
 * @Version: 1.0
 * @Description: Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * @Link: https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 */
public class mergeTwoLists {
    public static void main(String[] args) {

        int[] l1 = {1,2,4};
        int[] l2 = {1,3,4};

        ListNode a = assignmentListNode(l1);
        ListNode b = assignmentListNode(l2);

        printListNode(a);
        printListNode(b);

        ListNode result = mergeTwoLists(a, b);
        printListNode(result);
    }

    public static void printListNode(ListNode listNode){
        while(listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode assignmentListNode(int[] list){
        ListNode head = null;
        ListNode end = null;
        for (int i = 0; i < list.length; i++) {
            ListNode cursor = new ListNode(list[i]);
            if (head == null && end == null){
                head = cursor;
                end = cursor;
            }else {
                end.next = cursor;
                end = end.next;
            }

        }
        return head;
    }

    // data struct
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode cursor = null;
        ListNode temp;
        while(l1 != null && l2 != null){
            if (l1.val > l2.val){
                temp = l2;
                l2 = l2.next;
            }else {
                temp = l1;
                l1 = l1.next;
            }
            if (head == null ){
                head = temp;
                cursor = temp;
            }else {
                cursor.next = temp;
                cursor = cursor.next;
            }
        }
        if (l1 != null){ cursor.next = l1; }
        if (l2 != null){ cursor.next = l2; }
        return head;
    }
}
