package treeNodes;

/**Возвращает число хороших пар листьев дерева. Хорошими считаются листья, минимальная дистанция между которыми не
 * превышает distance
 * @author Сергей Шершавин*/

public class NumberOfGoodLeafPairs extends Command{
    private final int distance;
    private int count;

    /**Конструктор содержит:
     * @param distance предельная дистанция, при которой листья считаются хорошими*/
    public NumberOfGoodLeafPairs(TreeNode root, int distance) {
        super(root);
        this.distance = distance;
        count = 0;
    }

/**Создаём массив, индекс которого будет расстоянием от данного узла до листа, а значение - количество листьев на таком
 * расстоянии. Для узла, имеющего в качестве потомка лист, он будет на расстоянии 1 (index = 1).
 * Подсчитаем массивы для левых и правых поддеревьев каждого узла. Подсчитаем общее количество хороших пар
 * для данного узла. Чтобы вернуться к родительскому элементу складываем количество листов в левом и правом поддереве в
 * результирующий массив, каждый индекс которого будет больше на 1, поскольку расстояние до родителя на 1 больше*/
    private int[] countPairs(TreeNode node) {
        if (node == null) {
            return new int[distance + 1];
        }
        if (node.left == null && node.right == null) {
            int[] result = new int [distance + 1];
            result[1]++;
            return result;
        }
        int[] left = countPairs(node.left);
        int[] right = countPairs(node.right);

        int prefixSum = 0;
        for (int i = 1; i < left.length; i++) {
            prefixSum += left[i];
            count += prefixSum * right[distance - i];
        }
        int[] result = new int[distance + 1];
        for (int i = result.length - 2; i > 0; i--) {
            result[i+1] = left[i] + right[i];
        }
        return result;
    }

    @Override
    public Object execute() {
        countPairs(root);
        return count;
    }
}
