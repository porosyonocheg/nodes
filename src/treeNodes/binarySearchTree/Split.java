package treeNodes.binarySearchTree;

import treeNodes.Command;
import treeNodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** Возвращает массив корней бинарных деревьев поиска, получившийся после разбиения исходного дерева на следующие:
 * одно, содержащее все узлы, значения которых не превосходят параметра value; второе - все узлы, значения которых
 * превосходят value.
 * @author Сергей Шершавин*/

public class Split extends Command {
    private final int value;
    public Split(TreeNode root, int value) {
        super(root);
        this.value = value;
    }

    @Override
    public Object execute() {
        List<Integer> firstTree = new ArrayList<>();
        List<Integer> secondTree = new ArrayList<>();
        preorderTraversal(root, firstTree, secondTree);
        return new TreeNode[]{constructTree(firstTree), constructTree(secondTree)};
    }

    private void preorderTraversal(TreeNode node, List<Integer> firstTree, List<Integer> secondTree) {
        if (node == null) return;
        if (node.val > value) secondTree.add(node.val);
        else firstTree.add(node.val);
        preorderTraversal(node.left, firstTree, secondTree);
        preorderTraversal(node.right, firstTree, secondTree);
    }

    private TreeNode constructTree(List<Integer> preorder) {
        if (preorder.isEmpty()) return null;
        TreeNode root = new TreeNode(preorder.get(0));
        for (int i = 1; i < preorder.size(); i++) {
            new InsertNewNode(root, preorder.get(i)).execute();
        }
        return root;
    }
}
