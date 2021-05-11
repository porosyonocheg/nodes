package treeNodes;

/** Вставляет новый узел в максимальное бинарное дерево. Максимальным считается дерева, значения узлов которого
 * превосходят значения их потомков.
 * @author Сергей Шершавин*/

public class InsertNodeInMaximumBinaryTree {

    /** Рекурсивно ищем узел, значение которого меньше заданного, после чего добавляем этот узел в качестве
     * левого потомка нового узла, который возвращаем правым потомком узла, превосходящего его по значению.
     * @param value значение нового узла*/
    public static TreeNode insertNode(TreeNode root, int value) {
        if (root == null || value > root.val) {
            TreeNode node = new TreeNode(value);
            node.left = root;
            return node;
        }
        root.right = insertNode(root.right, value);
        return root;
    }
}
