package treeNodes;

import java.util.HashMap;
import java.util.Map;

/** Строит бинарное дерево на основе массивов, соответствующих обходам preorder и inorder. Элементы массивов должны быть
 * уникальны и корректны.
 * @author Сергей Шершавин*/

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**Из массива inorder получаем мапу ставящую в соответствие значение в массиве его индексу и передаем во
     * вспомогательный метод*/
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) return null;
            Map<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
            return buildTree(preorder, 0, 0, inorder.length - 1, inorderMap);
    }

    /**@param preStart текущая позиция в массиве preorder
     * @param inStart начало текущего отрезка в массиве inorder
     * @param inEnd конец текущего отрезка в массиве inorder
     * По preStart и посредством inMap определяем положение текущего узла в inorder, а также количество элементов в inorder слева от него
     * Неотрицательная разница inStart и inEnd говорит нам, что существуют ещё узлы на данном поддереве*/
    private static TreeNode buildTree(int[] preorder, int preStart, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, inRoot + 1, inEnd, inMap);
        return root;
    }
}
