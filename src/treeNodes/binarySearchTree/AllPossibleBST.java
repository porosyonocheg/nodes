package treeNodes.binarySearchTree;

import treeNodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**Возвращает список всех возможных бинарных деревьев поиска для заданного числа узлов. Значениями узлов служат цифры,
 * начиная от 1.
 * @author Сергей Шершавин*/

public class AllPossibleBST {

    public static List<TreeNode> getBinarySearchTrees(int n) {
        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<>();
        result[0].add(null);
        for (int index = 1; index <= n; index++) {
            result[index] = new ArrayList<>();
            for (int j = 0; j < index; j++) {
                for (TreeNode left : result[j]) {
                    for (TreeNode right : result[index - j - 1]) {
                        result[index].add(new TreeNode(j + 1, left, clone(right, j+1)));
                    }
                }
            }
        }
        return result[n];
    }

    private static TreeNode clone(TreeNode node, int offset) {
        if (node == null) return null;
        return new TreeNode(node.val + offset, clone(node.left, offset), clone(node.right, offset));
    }
}
