package treeNodes;

import java.util.LinkedList;
import java.util.Queue;

/** Определяет является ли переданная последовательность символов путём от корня до листа заданного бинарного дерева
 * @author Сергей Шершавин */


public class IsSequenceAPathFromRootToLeaf {
    public static boolean check(TreeNode root, int[] sequence) {
        if (root == null) return sequence.length == 0;
        if (sequence.length == 0) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.val == sequence[index]) {
                    if (root.left == null && root.right == null && index == sequence.length - 1) return true;
                    if (root.left != null) queue.add(root.left);
                    if (root.right != null) queue.add(root.right);
                }
            }
            index++;
            if (index == sequence.length) return false;
        }
        return false;
    }
}
