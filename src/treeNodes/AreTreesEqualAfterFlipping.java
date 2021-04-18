package treeNodes;

import java.util.LinkedList;
import java.util.Queue;

/** Возвращает true если деревья ранвы после любого количества перестановок левых и правых потомков их узлов.
 * Возвращает false в противном случае. Значения узлов должны быть уникальными.
 * @author Сергей Шершавин*/

public class AreTreesEqualAfterFlipping extends Command {
    private final TreeNode second;
    public AreTreesEqualAfterFlipping(TreeNode first, TreeNode second) {
        super(first);
        this.second = second;
    }

    @Override
    public Object execute() {
        if (root == null && second == null) return true;
        if (root == null  || second == null || root.val != second.val) return false;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        queue2.add(second);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.left == null && node1.right == null) {
                if (node2.left != null || node2.right != null) return false;
            }
            else if (node1.left == null) {
                if (node2.left != null && node2.right != null || node2.left == null && node2.right == null) return false;
                if (node2.left == null) {
                    if (node1.right.val != node2.right.val) return false;
                    queue2.add(node2.right);
                }
                else  {
                    if (node2.left.val != node1.right.val) return false;
                    node2.right = node2.left;
                    node2.left = null;
                    queue2.add(node2.right);
                }
                queue1.add(node1.right);
            }
            else if (node1.right == null) {
                if (node2.left != null && node2.right != null || node2.left == null && node2.right == null) return false;
                if (node2.right == null) {
                    if (node1.left.val != node2.left.val) return false;
                    queue2.add(node2.left);
                }
                else {
                    if (node2.right.val != node1.left.val) return false;
                    node2.left = node2.right;
                    node2.right = null;
                    queue2.add(node2.left);
                }
                queue1.add(node1.left);
            }
            else {
                if (node2.left == null || node2.right == null) return false;
                if (node1.left.val != node2.left.val) {
                    if (node1.left.val != node2.right.val || node1.right.val != node2.left.val) return false;
                    TreeNode temp;
                    temp = node2.left;
                    node2.left = node2.right;
                    node2.right = temp;
                }
                else if (node1.right.val != node2.right.val) return false;
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.left);
                queue2.add(node2.right);
            }
            if ((queue1.isEmpty() && !queue2.isEmpty()) || (!queue1.isEmpty() && queue2.isEmpty())) return false;
        }
        return true;
    }
}
