package treeNodes;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/** Узел бинарного дерева
 * @author Сергей Шершавин
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    /**
     * Конструктор содержит
     *
     * @param val  численное значение данного узла
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * Конструктор содержит
     *
     * @param val    численное значение данного узла
     * @param left   ссылка на левый дочерний узел
     * @param right  ссылка на правый дочерний узел
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Конструктор содержит
     *
     * @param values  список численных значений узлов дерева
     */
    public TreeNode (List<Integer> values) {
            this.val = values.get(0);
            this.left = addNode(values, 1);
            this.right = addNode(values, 2);
    }

    private TreeNode addNode(List<Integer> values, int index) {
        if (index < values.size()) {
            Integer current = values.get(index);
            if (current == null) return null;
            TreeNode node = new TreeNode(current);
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(node);
            while (true) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode currentNode = queue.pop();
                    if (2*index+1 >= values.size()) return node;
                    current = values.get(2*index+1);
                    if (current != null) {
                        currentNode.left = new TreeNode(current);
                        queue.offer(currentNode.left);
                    }
                    if (2*index+2 >= values.size()) return node;
                    current = values.get(2*index+2);
                    if (current != null) {
                        currentNode.right = new TreeNode(current);
                        queue.offer(currentNode.right);
                    }
                    index++;
                }
            }
        }
        return null;
    }

    public void insertNewNode(int value) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (true) {
            TreeNode currentNode = queue.pop();
            if (currentNode.left == null) {
                currentNode.left = new TreeNode(value);
                return;
            }
            else queue.offer(currentNode.left);
            if (currentNode.right == null) {
                currentNode.right = new TreeNode(value);
                return;
            }
            else queue.offer(currentNode.right);
        }
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
        for (int i = builder.length()-1; i >=0; i--) {
            if (Character.isDigit(builder.charAt(i))) break;
            builder.deleteCharAt(i);
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}