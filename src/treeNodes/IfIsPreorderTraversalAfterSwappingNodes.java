package treeNodes;

import java.util.*;

/** Массив preorder представляет собой искомый preorder обход дерева. Если переданное дерево можно привести к данному
 * массиву путём перемены потомков любых его узлов, то вернуть список узлов, потомки которых изменили положение. Если
 * получить preorder нельзя вернуть -1.
 * @author Сергей Шершавин*/

public class IfIsPreorderTraversalAfterSwappingNodes extends Command {
    private final int[] preorder;
    public IfIsPreorderTraversalAfterSwappingNodes(TreeNode root, int[] preorder) {
        super(root);
        this.preorder = preorder;
    }

    @Override
    public Object execute() {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.val != preorder[i++]) return Collections.singletonList(-1);
            if (current.right != null && current.right.val == preorder[i]) {
                if (current.left != null) {
                    result.add(current.val);
                    stack.push(current.left);
                }
                if (current.right != null) stack.push(current.right);
            }
            else {
                if (current.right != null) stack.push(current.right);
                if (current.left != null) stack.push(current.left);
            }
        }
        return result;
    }
}
