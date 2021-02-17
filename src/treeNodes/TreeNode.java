package treeNodes;

import java.util.LinkedList;

/** Узел бинарного дерева
 * @author Сергей Шершавин
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    /**
     * Конструктор содержит
     *
     * @param val - численное значение данного узла
     */
    TreeNode(int val) {
        this.val = val;
    }

    /**
     * Конструктор содержит
     *
     * @param val   - численное значение данного узла
     * @param left  - ссылка на левый дочерний узел
     * @param right - ссылка на правый дочерний узел
     */
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    builder.append("null").append(", ");
                    continue;
                }
                else builder.append(node.val).append(", ");
                    queue.offer(node.left);
                    queue.offer(node.right);
            }
        }
        return builder.delete(builder.length()-2, builder.length()).toString();
    }
}