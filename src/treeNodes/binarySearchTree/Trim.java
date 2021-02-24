package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Модифицирует бинарное дерево поиска в заданных границах значений узлов
 * @author Сергей Шершавин*/

public class Trim extends Command {
    private int low;
    private int high;

/**Конструкто содержит
 * @param low нижняя граница значений узлов
 * @param high верхняя граница значений узлов
 * */
    public Trim(TreeNode root, int low, int high) {
        super(root);
        this.low = low;
        this.high = high;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    @Override
    public Object execute() {
        return trimBST(root, low, high);
    }
}
