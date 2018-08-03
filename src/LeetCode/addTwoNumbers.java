package LeetCode;

/**
 * @Author: Donlin
 * @Date: Created in 18:25 2018/8/1
 * @Version: 1.0
 * @Description:
 */
public class addTwoNumbers {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }

    public static ListNode addTwoNumbers_2(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null){
            return null;
        }

        ListNode head = new ListNode((l1.val + l2.val) % 10);
        int shiftAdd = (l1.val + l2.val) / 10;      // set as a add flag to shift
        ListNode end = head;
        int temp1,temp2;

        while (true){
            if ((l1 = l1.next) == null){
                if (shiftAdd == 0){
                    end.next = l2.next;
                    return head;
                }else {
                    temp1 = 0;
                }
            }else {
                temp1 = l1.val;
            }
            if ((l2 = l2.next) == null){
                if (shiftAdd == 0){
                    end.next = l1.next;
                    return head;
                }else {
                    temp2 = 0;
                }
            }else {
                temp2 = l2.val;
            }

            int temp = temp1 + temp2 + shiftAdd;
            shiftAdd = temp / 10;
            ListNode tempNode = new ListNode(temp % 10);
            end.next = tempNode;
            end = end.next;
        }
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

    public static void main(String[] args) {
        int a = 342;
        int b = 465;

        ListNode l1 = ItoL(342);
        ListNode l2 = ItoL(465);
        printListNode(l1);
        printListNode(l2);
        ListNode resultListNode = addTwoNumbers_1(l1, l2);
        printListNode(resultListNode);

    }
}
