package treeNodes;

/** Определяет находятся ли переданные узлы на одинаковой глубине, имея при этом разных родителей. Подразумевается,
 * что значения узлов дерева уникальны.
 * @author Сергей Шершавин*/

public class Cousins extends Command {
    private final int firstNodeValue;
    private final int secondNodeValue;
    private boolean flag = false;

    public Cousins(TreeNode root, int firstNodeValue, int secondNodeValue) {
        super(root);
        this.firstNodeValue = firstNodeValue;
        this.secondNodeValue = secondNodeValue;
    }

/**Записывает в переданный массив данные о глубине искомого узла и численном значении его родителя*/
    private void findNode(TreeNode root, int target, int[] depth) {
        if (root == null) {
            depth[0]--;
            return;
        }
        if (root.val == target) {
            flag = true;
            return;
        }
        if (root.left == null && root.right == null) {
            depth[0]--;
            return;
        }
        if (root.left != null && !flag) {
            depth[0]++;
            depth[1] = root.val;
            findNode(root.left, target, depth);
        }

        if (root.right != null && !flag) {
            depth[0]++;
            depth[1] = root.val;
            findNode(root.right, target, depth);
        }
        if (!flag) depth[0]--;
    }

    @Override
    public Object execute() {
        int[] first = new int[2];
        findNode(root, firstNodeValue, first);
        flag = false;
        int[] second = new int[2];
        findNode(root, secondNodeValue, second);
        return first[0] == second[0] && first[1] != second[1];
    }
}
