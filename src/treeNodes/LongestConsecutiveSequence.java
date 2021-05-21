package treeNodes;

/** Возвращает длину максимальной последовательности узлов от родителя к потомкам, значения которых возрастают ровно на 1.
 * Например, для дерева [1, 2, null, 3, null, 4, null, 5], длина такой последовательности 5.
 * @author Сергей Шершавин*/

public class LongestConsecutiveSequence extends Command {
    private int maxLength;
    public LongestConsecutiveSequence(TreeNode root) {
        super(root);
        maxLength = 0;
    }

    @Override
    public Object execute() {
        if (root != null) {
            maxLength = 1;
            traversalTree(root.left, 1, root.val);
            traversalTree(root.right, 1, root.val);
        }
        return maxLength;
    }


    private void traversalTree(TreeNode node, int length, int prev) {
        if (node == null) return;
        if (node.val - prev == 1) {
           length++;
            maxLength = Math.max(length, maxLength);
            traversalTree(node.left, length, node.val);
            traversalTree(node.right, length, node.val);
        }
        else {
            traversalTree(node.left, 1, node.val);
            traversalTree(node.right, 1, node.val);
        }
    }
}
