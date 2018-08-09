package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 18:25 2018/8/1
 * @Version: 1.0
 * @Description: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * @Link: https://leetcode-cn.com/problems/add-two-numbers/description/
 */
public class addTwoNumbers {

    public static void main(String[] args) {
        int a = 1;
        int b = 99999;

        ListNode l1 = ItoL(a);
        ListNode l2 = ItoL(b);
        printListNode(l1);
        printListNode(l2);
        printListNode(addTwoNumbers(l1, l2));
    }

    // data struct
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode end = null;
        int shiftAdd = 0;
        while(l1 != null && l2 != null){
            int temp = l1.val + l2.val + shiftAdd;
            ListNode cursor = new ListNode(temp % 10);
            if (head == null && end == null){
                head = cursor;
                end = cursor;
            }else {
                end.next = cursor;
                end = end.next;
            }
            if (temp / 10 != 0){ shiftAdd = 1; }else { shiftAdd = 0; } // shiftAdd = (temp/10!=0)? 1:0;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (shiftAdd == 0){     // shiftAdd = 0, l1 exist/l2 exist/nor exist
            if (l1 == null && l2 != null){
                end.next = l2;
            }else if (l2 == null && l1 != null){
                end.next = l1;
            }else {
                end.next = null;
            }
        }else {                 // shiftAdd = 1, l1 exist/l2 exist/nor exist
            if (l1 == null && l2 == null){
                end.next = new ListNode(shiftAdd);
            }else {
                ListNode existList = (l1==null)? l2:l1;
                while(existList!=null){
                    int temp = existList.val + shiftAdd;
                    if (temp / 10 != 0){ shiftAdd = 1; }else { shiftAdd = 0; } // shiftAdd = (temp/10!=0)? 1:0;
                    end.next = new ListNode(temp % 10);
                    end = end.next;
                    existList = existList.next;
                }
                if (shiftAdd == 1){
                    end.next = new ListNode(shiftAdd);
                }
            }
        }
        return head;
    }

    public static ListNode addTwoNumbers_1(ListNode l1, ListNode l2){
        int tempResult = LtoI(l1) + LtoI(l2);
        return ItoL(tempResult);
    }

    public static ListNode ItoL(int num){
        if (num <10 && num >= 0){
            return new ListNode(num);
        }
        ListNode head = new ListNode(num % 10);
        ListNode end = head;
        num = num /10;
        while(num % 10 != 0 || num / 10 != 0){
            int temp = num % 10;
            ListNode tempNode = new ListNode(temp);
            end.next = tempNode;
            end = end.next;
            num = num / 10;
        }
        end = null;
        return head;
    }

    public static int LtoI(ListNode listNode){
        int result = 0;
        int i = 0;
        while (listNode != null){
            result = (int) (result + listNode.val * Math.pow(10,i));
            i ++;
            listNode = listNode.next;
        }
        return result;
    }

    public static void printListNode(ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

}
