package treeNodes;

/** Определяет количество путей от корня до листа, которые потенциально являются палиндромами. Значения узлов дерева
 * должны быть в интервале от 1 до 9 включительно.
 * @author Сергей Шершавин*/
public class PseudoPalindromicPaths extends Command {
    private int count;

    public PseudoPalindromicPaths(TreeNode root) {
        super(root);
        count = 0;
    }

    /**В палиндроме для нечётного числа узлов в пути допустимо одно значение, количество которого нечётно. Для чётного
     * числа узлов все значения узлов должны содержаться чётное число раз
     * @param depth текущая глубина, которая в конечном итоге даёт нам длину потенциального палиндрома
     * @param digits содержит число повторов для каждого значения узлов*/
    private void isPseudoPalindrom(TreeNode node, int[] digits, int depth) {
        if (node == null) return;
        digits[node.val-1]++;
        if (node.left == null && node.right == null) {
            if (depth %2 == 0) {
                for (int i : digits) {
                    if (i%2 !=0) {
                        digits[node.val-1]--;
                        return;
                    }
                }
                count++;
                digits[node.val-1]--;
                return;
            }
            boolean isOdd = false;
            for (int i : digits) {
                if (i%2 != 0) {
                    if (isOdd) {
                        digits[node.val-1]--;
                        return;
                    }
                    isOdd = true;
                }
            }
            count++;
            digits[node.val-1]--;
            return;
        }
        isPseudoPalindrom(node.left, digits, depth + 1);
        isPseudoPalindrom(node.right, digits, depth + 1);
        digits[node.val-1]--;
    }

    @Override
    public Object execute() {
        int[] digits = new int[9];
        isPseudoPalindrom(root, digits, 1);
        return count;
    }
}
