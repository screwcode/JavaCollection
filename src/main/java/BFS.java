import java.util.List;

/**
 * 以广度优先的顺序遍历一棵二叉树
 *
 * 提示：广度优先遍历的经典方法是使用队列
 */
public class BFS {

    /**
     * 以广度优先的顺序遍历二叉树。例如，对于如下二叉树:
     *
     *        3    <-- root
     *      /   \
     *     2      4
     *   /   \      \
     *  1     6      5
     * @param root 二叉树的根结点，例如上例中的节点3
     * @return 遍历后的节点值，在上例中，应该返回[3,2,4,1,6,5]
     */
    public static List<Integer> bfsTraverse(TreeNode root) {
        return null;
    }

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
