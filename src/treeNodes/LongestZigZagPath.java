package treeNodes;

/** Возвращает длину наибольшего зиг-загообразного пути в дереве. Зиг-загообразным путём считается путь, при котором следующий
 * потомок меняется с левого на правый или наоборот. Например [1,2,3,4,5,6,7]. Самые длинные зиг-загообразные пути: 1-2-5, 1-3-6.
 * @author Сергей Шершавин*/

public class LongestZigZagPath extends Command {
    private int longestPath;

    public LongestZigZagPath(TreeNode root) {
        super(root);
        longestPath = 0;
    }

    @Override
    public Object execute() {
        if (root == null) return 0;
        zigZagTraversal(root.left, 1, true);
        zigZagTraversal(root.right, 1, false);
        return longestPath;
    }

    private void zigZagTraversal(TreeNode node, int depth, boolean isLeft) {
        if (node == null) return;

        longestPath = Math.max(longestPath, depth);

        if (isLeft) {
            zigZagTraversal(node.right, depth + 1, false); //продолжаем путь вправо для левого узла
            zigZagTraversal(node.left, 1, true); //также проверяем путь левого потомка
        }
        else {
            zigZagTraversal(node.left, depth + 1, true);
            zigZagTraversal(node.right, 1, false);
        }
    }
}
