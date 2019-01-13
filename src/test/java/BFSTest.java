import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BFSTest {
    /**
     *        3
     *      /   \
     *     2      4
     *   /   \      \
     *  1     6      5
     */
    @Test
    public void test1() {
        BFS.TreeNode node1 = new BFS.TreeNode(1, null, null);
        BFS.TreeNode node6 = new BFS.TreeNode(6, null, null);
        BFS.TreeNode node5 = new BFS.TreeNode(5, null, null);

        BFS.TreeNode node2 = new BFS.TreeNode(2, node1, node6);
        BFS.TreeNode node4 = new BFS.TreeNode(4, null, node5);

        BFS.TreeNode node3 = new BFS.TreeNode(3, node2, node4);

        Assertions.assertEquals(Arrays.asList(3, 2, 4, 1, 6, 5), BFS.bfsTraverse(node3), "遍历结果应该是：[3,2,4,1,6,5]!");
    }

    /**
     *           15
     *          /  \
     *        10    20
     *        /      \
     *       5        30
     */
    @Test
    public void test2() {
        BFS.TreeNode node5 = new BFS.TreeNode(5, null, null);
        BFS.TreeNode node30 = new BFS.TreeNode(30, null, null);

        BFS.TreeNode node10 = new BFS.TreeNode(10, node5, null);
        BFS.TreeNode node20 = new BFS.TreeNode(20, null, node30);

        BFS.TreeNode node15 = new BFS.TreeNode(15, node10, node20);

        Assertions.assertEquals(Arrays.asList(15, 10, 20, 5, 30), BFS.bfsTraverse(node15), "遍历结果应该是：[15,10,20,5,30]!");
    }
}