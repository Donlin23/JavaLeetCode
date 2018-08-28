package ForOffer;

import java.util.LinkedList;

/**
 * @Author: Donlin
 * @Date: Created in 19:40 2018/8/28
 * @Version: 1.0
 * @Description: 面试题27: 二叉树的镜像
 */
public class Mirror {

    public static void main(String[] args) {
        TreeNode root = generateTree();
        printTree(root);
        Mirror(root);
        System.out.println();
        printTree(root);
    }

    public static void Mirror(TreeNode root){
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
    }

    private static void printTree(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while ( !queue.isEmpty() ){
            TreeNode node = queue.remove();
            System.out.print(node.val + " ");
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    private static TreeNode generateTree(){
        TreeNode root = new TreeNode(8);
        TreeNode cursor = root;
        cursor.left = new TreeNode(6);cursor.right = new TreeNode(10);
        cursor = root.left; cursor.left = new TreeNode(5); cursor.right = new TreeNode(7);
        cursor = root.right; cursor.left = new TreeNode(9); cursor.right = new TreeNode(11);
        return root;
    }

    private static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
