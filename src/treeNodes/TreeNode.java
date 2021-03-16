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
            TreeNode root = createTree(values);
            this.val = root.val;
            this.left = root.left;
            this.right = root.right;
    }

    private TreeNode createTree(List<Integer> values) {
            int index = 0;
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
    /**Вставка узла с заданным значением в первое свободное место в дереве*/
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

    /**Удаление поддеревьев узлов, значение которых совпадает с переданным, используя
     * реализацию метода boolean removeNodes(TreeNode current, int value).
     * @param value значение удаляемых узлов*/
    public void removeNodes(int value) {
        if (removeNodes(this.left, value)) {
            this.left = null;
        }
        if (removeNodes(this.right, value)) {
            this.right = null;
        }
    }

    /**Удаление поддеревьев с переданным значением. Рекурсивным вызовом обнуляет ссылки на потомков, если их значение
     * совпало с переданным
     * @param value значение удаляемого узла
     * @return  true если узел с переданным значением найден в данном поддереве, false, если узла с таким значением нет*/
    private boolean removeNodes(TreeNode current, int value) {
        if (current != null) {
            if (current.val == value) return true;
            if (removeNodes(current.left, value)) {
                current.left = null;
            }
            if (removeNodes(current.right, value)) {
                current.right = null;
            }
        }
        return false;
    }

    /**Подсчёт числа узлов бинарного дерева, используя внутренний метод прямого обхода дерева*/
    public int countNodes() {
        int[] count = new int[1];
        traversalTree(this, count);
        return count[0];
    }
    private void traversalTree(TreeNode root, int[] count) {
        if (root == null) return;
        count[0]++;
        traversalTree(root.left, count);
        traversalTree(root.right, count);
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

    public Object clone() {
        if (this.left == null && this.right == null){
            return new TreeNode(this.val);
        }
        if (this.left == null) {
            return new TreeNode(this.val, null, (TreeNode)this.right.clone());
        }
        if (this.right == null) {
            return new TreeNode(this.val, (TreeNode)this.left.clone(), null);
        }
        return new TreeNode(this.val, (TreeNode)this.left.clone(), (TreeNode)this.right.clone());
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