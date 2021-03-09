package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/** Находит ближайшего общего предка (узел) для двух переданных значений узлов в данном бинарном дереве поиска
 * @author Сергей Шершавин*/

public class LowestCommonAncestorInBST extends Command {
    private int val1, val2;

    /**Конструктор содержит параметры:
     * @param val1 значение одного из искомых узлов
     * @param val2 значение второго из искомых узлов*/
    public LowestCommonAncestorInBST(TreeNode root, int val1, int val2) {
        super(root);
        this.val1 = val1;
        this.val2 = val2;
    }

    /** @return узел, являющийся наименьшим общим предком для узлов с переданными значениями
     * если узлов с переданными значениями нет в дереве, ищет такого предка, как если бы они были*/
    private TreeNode lowestCommonAncestor(TreeNode root, int val1, int val2) {
        if (root.left == null && root.right == null) return root;
        if (val1  > root.val && val2 > root.val) return lowestCommonAncestor(root.right, val1, val2);
        else if (val1  < root.val && val2 < root.val) return lowestCommonAncestor(root.left, val1, val2);
        else {
            return root;
        }
    }

    @Override
    public Object execute() {
        return lowestCommonAncestor(root, val1, val2);
    }
}
