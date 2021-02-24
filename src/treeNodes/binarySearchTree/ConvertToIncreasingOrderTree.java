package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

/**Преобразует бинарное дерево поиска в бинарное дерево поиска возврастающей последовательности значений узлов
 * @author  Сергей Шершавин*/

public class ConvertToIncreasingOrderTree extends Command {
    private TreeNode sortedTree = null;

    public ConvertToIncreasingOrderTree(TreeNode root) {
        super(root);
    }

    private void inOrderTreeWalk(TreeNode node) {
        if (node == null) return;
        inOrderTreeWalk(node.right);
        node.right = sortedTree;
        sortedTree = node;
        inOrderTreeWalk(node.left);
        node.left = null;
    }

    @Override
    public Object execute() {
        inOrderTreeWalk(root);
        return sortedTree;
    }
}
