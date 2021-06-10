package treeNodes;

import java.util.LinkedList;
import java.util.Queue;

/**Вставка нового узла в полное бинарное дерево с сохранением структуры.
 * @see IsComplete
 * @author Сергей Шершавин*/

public class CBTInserter {
    private final TreeNode root;
    private final Queue<TreeNode> lastParents;
    public CBTInserter(TreeNode root) {
        this.root = root;
        lastParents = new LinkedList<>();
        lastParents.add(root);
        while (true) {
            root = lastParents.peek();
            if (root.left == null || root.right == null) break;
            lastParents.poll();
            lastParents.add(root.left);
            lastParents.add(root.right);
        }
        if (root.left != null) lastParents.add(root.left);
    }

    public int insert(int val) {
        TreeNode parent = lastParents.peek();
        if (parent.left == null) {
            parent.left = new TreeNode(val);
            lastParents.add(parent.left);
        }
        else {
            parent.right = new TreeNode(val);
            lastParents.add(parent.right);
            lastParents.poll();
        }
        return parent.val;
    }

    public TreeNode getRoot() {
        return root;
    }
}
