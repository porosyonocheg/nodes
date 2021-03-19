package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Удаление узла из бинарного дерева поиска по значению. Значения узлов должны быть уникальными
 * @author Сергей Шершавин*/

public class DeleteNode extends Command {
    private final int key;

    /**Конструктор содержит:
     * @param key искомое значение удаляемого узла*/
    public DeleteNode(TreeNode root, int key) {
        super(root);
        this.key = key;
    }

    /**Рекурсивно ищем наличие значения key в дереве, если оно найдено, в общем случае возвращаем вместо найденного узла
     * наименьший дочерний узел его правого дочернего узла (или сам правый дочерний узел, если у него нет левого поддерева),
     * к которому в качестве левого дочернего узла прикрепляем ссылку на левый дочерний узел удаляемого узла*/
    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode minNext = root.right;
            while (minNext.left != null) minNext = minNext.left;
            minNext.left = root.left;
            return root.right;
        }
        return root;
    }

    @Override
    public Object execute() {
        return deleteNode(root, key);
    }
}
