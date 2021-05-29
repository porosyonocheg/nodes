package treeNodes;

/** Находит в дереве наибольшее по числу узлов поддерево, являющееся бинарным деревом поиска, и возвращает число его узлов
 * @author Сергей Шершавин*/

public class LargestBSTSubtree extends Command {

    public LargestBSTSubtree(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        int[] maxSize = new int[1];
        dfs(root, maxSize);
        return maxSize[0];
    }

    private SubtreeData dfs(TreeNode node, int[] maxSize) {
        SubtreeData sd = new SubtreeData();
        if (node == null) {
            return sd;
        }

        SubtreeData left = dfs(node.left, maxSize);
        SubtreeData right = dfs(node.right, maxSize);

        sd.left = Math.min(node.val, left.left);
        sd.right = Math.max(node.val, right.right);

        if (left.isBST && right.isBST && left.right <= node.val && right.left >= node.val) {
            sd.size = left.size + right.size + 1;
            if (sd.size > maxSize[0]) maxSize[0] = sd.size;
        }
        else {
            sd.isBST = false; // нет необходимости считать размер, если дерево не является BST
        }
        return sd;
    }

/** Класс, хранящий данные о поддереве
 * isBST - является ли поддерево BST
 * left - минимальное значение узла в поддереве
 * right - максимальное значение узла в поддереве
 * size - размер поддерева*/

    private class SubtreeData {
        private boolean isBST;
        private int left;
        private int right;
        private int size;

        private SubtreeData() {
            isBST = true;
            size = 0;
            left = Integer.MAX_VALUE;
            right = Integer.MIN_VALUE;
        }
    }
}


