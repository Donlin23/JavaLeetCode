package ForOffer;

/**
 * @Author: Donlin
 * @Date: Created in 19:18 2018/8/15
 * @Version: 1.0
 * @Description: 面试题8: 二叉树的下一个节点
 */
public class GetNext {
    public static void main(String[] args) {
        TreeLinkNode treeLinkNode = aTreeDemo();
        TreeLinkNode next = GetNext(treeLinkNode);
        System.out.println(next.val);
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null) return null;

        TreeLinkNode pNext = null;
        if (pNode.right != null){
            TreeLinkNode pRight = pNode.right;
            while(pRight.left != null){
                pRight = pRight.left;
            }
            pNext = pRight;
        }else if (pNode.next != null){
            TreeLinkNode pCurrent = pNode;
            TreeLinkNode pParent = pNode.next;
            while (pParent != null && pCurrent == pParent.right){
                pCurrent = pParent;
                pParent = pParent.next;
            }
            pNext = pParent;
        }
        return pNext;
    }

    private static TreeLinkNode aTreeDemo(){
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode p = root;
        p.next = null; p.left = new TreeLinkNode(2); p.right = new TreeLinkNode(3);
        p.left.next = p; p = p.left; p.left = new TreeLinkNode(4);
        p.left.next = p; p.left.left = null; p.left.right = null;
        p.right = new TreeLinkNode(5); p.right.next = p; p = p.right;
        p.left = new TreeLinkNode(8); p.left.next = p; p.left.left = null; p.left.right = null;
        p.right = new TreeLinkNode(9); p.right.next = p; p.right.left = null; p.right.right = null;
        p = root.right; p.next = root;
        p.left = new TreeLinkNode(6); p.left.next = p; p.left.left = null; p.left.right = null;
        p.right = new TreeLinkNode(7); p.right.next = p; p.right.left = null; p.right.right = null;
        return root;
    }
}

class TreeLinkNode{
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
    public TreeLinkNode(int val) {
        this.val = val;
    }
}