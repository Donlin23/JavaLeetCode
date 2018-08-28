package ForOffer;

/**
 * @Author: Donlin
 * @Date: Created in 20:04 2018/8/28
 * @Version: 1.0
 * @Description: 面试题28: 对称的二叉树
 */
public class isSymmetrical {
    public static void main(String[] args) {
        TreeNode root = generateTree();
        System.out.println(isSymmetrical(root));
    }

    public static boolean isSymmetrical(TreeNode root){
        return isSymmetrical(root,root);
    }

    private static boolean isSymmetrical(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
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
