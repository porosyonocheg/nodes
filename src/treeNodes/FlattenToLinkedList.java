package treeNodes;

/** Преобразует бинарное дерево в структуру схожую со связным списком: каждый узел распологается согласно preorder
 * друг за другом исключительно в правом потомке предшествующего узла
 * @author Сергей Шершавин*/

public class FlattenToLinkedList  {
    public static void flatten(TreeNode root) {
        flatten(root, null);
    }

    private static TreeNode flatten(TreeNode node, TreeNode prev) {
        if (node == null) return prev;
        prev = flatten(node.right, prev);
        prev = flatten(node.left, prev);
        node.right = prev;
        node.left = null;
        return node;
    }
}
