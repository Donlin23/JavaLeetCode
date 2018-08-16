package ForOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: Donlin
 * @Date: Created in 16:02 2018/8/14
 * @Version: 1.0
 * @Description: 面试题6: 从尾到头打印链表
 */
public class printListFromTailToHead {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,};
        ListNode listNode = assignmentListNode(nums);

        ArrayList<Integer> arrayList = printListFromTailToHead(listNode);
        for (int a : arrayList) {
            System.out.println(a);
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()){
            list.add(stack.peek());
            stack.pop();
        }
        return list;
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
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}