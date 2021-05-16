package treeNodes;

/** Вор-домушник обнаружил, что все дома в его районе представляют собой структуру бинарного дерева. Нельзя влезать в два
 * прямо связанных друг с другом дома (узла). Значение каждого узла представляет собой материальную ценность,
 * хранящуюся в данном доме. Получить возможную максимальную сумму, украденную со всех доступных домов.
 * @author Сергей Шершавин*/

public class HouseRobber extends Command {
    public HouseRobber(TreeNode root) {
        super(root);
    }

    @Override
    public Object execute() {
        int[] result = dp(root);
        return Math.max(result[0], result[1]);
    }

    /**Первый элемент результирующего массива представляет собой сумму максимального из левых потомков данного узла и
     * правого потомка данного узла (случай, когда данный узел не посещается грабителем). Второй элемент представляет
     * собой сумму при обходе включающем данный узел и суммарные результаты для его потомков, исключающий самих потомков.*/

    private int[] dp(TreeNode node) {
        if (node == null) return new int[2];
        int[] left = dp(node.left);
        int[] right = dp(node.right);
        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = node.val + left[0] + right[0];
        return result;
    }
}
