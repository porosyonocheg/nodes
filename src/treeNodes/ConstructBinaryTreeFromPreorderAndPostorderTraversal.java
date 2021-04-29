package treeNodes;

/** Строит бинарное дерево на основе массивов, соответствующих обходам preorder и postorder. Элементы массивов должны быть
 * корректны.
 * @author Сергей Шершавин*/

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    private static int preIndex = 0, postIndex = 0;

    /**Строим новое поддерево, посредством preorder. Поддерево будет полным, если значение текущего узла совпадёт с текущим
     * значением в postorder, значит новых потомков добавлять не нужно. В противном случае рекурсивно продолжаем строить
     * поддеревья для текущего узла*/
    public static TreeNode buildTree(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (root.val != postorder[postIndex]) {
            root.left = buildTree(preorder, postorder);
        }

        if (root.val != postorder[postIndex]) {
            root.right = buildTree(preorder, postorder);
        }
        postIndex++;
        return root;
    }

}
