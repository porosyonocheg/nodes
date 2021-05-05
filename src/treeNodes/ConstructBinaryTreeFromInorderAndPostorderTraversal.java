package treeNodes;

import java.util.ArrayDeque;
import java.util.Deque;

/** Строит бинарное дерево на основе массивов, соответствующих обходам inorder и postorder. Элементы массивов должны быть
 * корректны.
 * @author Сергей Шершавин*/

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        stack.addFirst(root);
        int ioIndex = inorder.length - 1, poIndex = postorder.length - 2;
        while(poIndex >= 0) {
            TreeNode current = stack.peekFirst();
            if (current.val != inorder[ioIndex]) {
                TreeNode right = new TreeNode(postorder[poIndex]);
                current.right = right;
                stack.addFirst(right);
                poIndex--;
            }
            else {
                while (!stack.isEmpty() && stack.peekFirst().val == inorder[ioIndex]) {
                    current = stack.pollFirst();
                    ioIndex--;
                }
                TreeNode left = new TreeNode(postorder[poIndex]);
                current.left = left;
                stack.addFirst(left);
                poIndex--;
            }
        }
        return root;
    }
}
