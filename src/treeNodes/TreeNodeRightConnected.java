package treeNodes;

import java.util.ArrayDeque;
import java.util.Deque;

/**Бинарное дерево с ссылкой на следующего правого потомка на данной глубине
 * @author Сергей Шершавин*/

public class TreeNodeRightConnected  {
    private int val;
    private TreeNodeRightConnected left;
    private TreeNodeRightConnected right;
    private TreeNodeRightConnected next;

    public TreeNodeRightConnected() {}

    public TreeNodeRightConnected(int val) {
        this.val = val;
        next = null;
    }

    public TreeNodeRightConnected(int val, TreeNodeRightConnected left, TreeNodeRightConnected right) {
        this.left = left;
        this.right = right;
        this.val = val;
        this.next = null;
    }

    public TreeNodeRightConnected(int val, TreeNodeRightConnected left, TreeNodeRightConnected right, TreeNodeRightConnected next) {
        this.left = left;
        this.right = right;
        this.val = val;
        this.next = next;
    }

    /**Заполняет поле next для всех потомков дерева в соответствии со структурой*/
    public static TreeNodeRightConnected connect(TreeNodeRightConnected root) {
        if (root == null) return null;
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right; // если правый потомок существует, то он и становится следующим для левого
            }
            else {
                root.left.next = findNext(root); // иначе ищем первого потомка среди следующих узлов, если он существует
            }
        }
        if (root.right != null) {
            root.right.next = findNext(root);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private static TreeNodeRightConnected findNext(TreeNodeRightConnected node) {
        while (node.next != null) {
            node = node.next;
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
        }
        return null;
    }

    @Override
    public String toString() {
        Deque<TreeNodeRightConnected> queue = new ArrayDeque<>();
        queue.addLast(this);
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                TreeNodeRightConnected current = queue.pollFirst();
                builder.append(current.val).append(" -> ");
                if (current.next == null) builder.append('#').append('\n');
                else builder.append('{').append(current.next.val).append("}, ");
                if (current.left != null) queue.addLast(current.left);
                if (current.right != null) queue.addLast(current.right);
            }
        }
        return builder.toString();
    }
}
