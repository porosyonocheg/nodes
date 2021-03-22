package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**Преобразует исходное бинарное дерево поиска в сбалансированное бинарное дерево поиска
 * (глубина всех поддеревьев которого не отличается более чем на 1)
 * @author Сергей Шершавин*/

public class ConvertToBalancedTree extends Command {
    private final List<Integer> values = new ArrayList<>();

    public ConvertToBalancedTree(TreeNode root) {
        super(root);
    }

    /**Создаёт список значений узлов после обхода In-order*/
    private void createListFromBST (TreeNode node) {
        if (node == null) return;
        createListFromBST(node.left);
        values.add(node.val);
        createListFromBST(node.right);
    }

    private TreeNode sortedListToBST(int left, int right) {
        if (left > right) return null;
        int middle = left + (right-left)/2;
        TreeNode root = new TreeNode(values.get(middle));
        root.left = sortedListToBST(left, middle-1);
        root.right = sortedListToBST(middle+1, right);
        return root;
    }

    @Override
    public Object execute() {
        createListFromBST(root);
        return sortedListToBST(0, values.size()-1);
    }
}
