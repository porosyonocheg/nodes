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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                    root = queue.poll();
                    if (root.left != null) queue.add(root.left);
                    else lastParents.add(root);
                    if (root.right != null) queue.add(root.right);
                    else lastParents.add(root);
            }
        }
    }

    public int insert(int val) {
        TreeNode parent = lastParents.poll();
        if (parent.left == null) {
            parent.left = new TreeNode(val);
            lastParents.add(parent.left);
            lastParents.add(parent.left);
        }
        else {
            parent.right = new TreeNode(val);
            lastParents.add(parent.right);
            lastParents.add(parent.right);
        }
        return parent.val;
    }

    public TreeNode getRoot() {
        return root;
    }
}
