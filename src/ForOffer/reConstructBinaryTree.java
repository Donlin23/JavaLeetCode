package ForOffer;

/**
 * @Author: Donlin
 * @Date: Created in 16:28 2018/8/14
 * @Version: 1.0
 * @Description: 面试题7: 重建二叉树
 */
public class reConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        printTreePreoder(treeNode);
    }

    public static void printTreePreoder(TreeNode treeNode){
        if (treeNode != null){
            System.out.println(treeNode.val);
            printTreePreoder(treeNode.left);
            printTreePreoder(treeNode.right);
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in){
        if (pre == null || in == null || pre.length <= 0|| in.length <= 0)
            return null;
        return ConstructCore(pre, in, 0, pre.length-1, 0, in.length-1);
    }

    private static TreeNode ConstructCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd){
        // 前序遍历序列的第一个数字就是根节点的值
        int rootValue = pre[preStart];
        TreeNode root = new TreeNode(rootValue);
        root.left = root.right = null;

        if (pre[0] == pre[pre.length-1] && pre[0] == in[0] && in[0] == in[in.length - 1]){
            return root;
        }

        // 在中序遍历序列中找到根节点的值
        int rootIn = inStart;
        while (in[rootIn] != rootValue && rootIn <= inEnd){
            rootIn++;
        }

        int leftLength = rootIn - inStart;
        int leftPreLeft = preStart + leftLength;
        if (leftLength > 0){        // 构建左子树
            root.left = ConstructCore(pre, in, preStart+1, leftPreLeft, inStart, rootIn-1);
        }
        if (leftLength < preEnd - preStart){
            root.right = ConstructCore(pre, in, leftPreLeft+1, preEnd, rootIn+1, inEnd);
        }
        return root;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
