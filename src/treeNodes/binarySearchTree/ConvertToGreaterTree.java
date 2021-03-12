package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/**Преобразует исходное бинарное дерево поиска следующим образом: значение каждого узла увеличивается на сумму всех
 * значений узлов, превосходящих данное значение.
 * @author Сергей Шершавин*/

public class ConvertToGreaterTree extends Command {

    public ConvertToGreaterTree(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        if (root != null) {
        int[] sum = new int[1];
        convertBST(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0];
        convertBST(root.left, sum);
        }
        return root;
    }

    private void convertBST(TreeNode node, int[] sum) {
        if (node == null) return;
        convertBST(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        convertBST(node.left, sum);
    }
}
