package treeNodes;

/**Преобразует строку, полученную из значений узлов при inorder обходе дерева, каждый уровень которого соответствует
 * количеству дефисов между значениями, в исходное дерево
 * @author Сергей Шершавин*/

public class RecoverTreeFromPreorderTraversal {
    public static TreeNode recover(String tree) {
        return tree.isEmpty() ? null : dfs(tree, 0, new int[]{0});
    }

    /**@param s исходная строка
     * @param depth текущая глубина (корень на глубине 0)
     * @param index номер текущей позиции в строке в виде одномерного массива
     * Находим numberOfDashes - число дефисов, если оно не соответствует (на самом деле, меньше) текущей глубине,
     * значит потомков нет и возвращаем null. Находим next - индекс следующего набора дефисов (символы между предыдущим
     * набором дефисов и текущим составляют искомое значение узла на данном уровне)*/
    private static TreeNode dfs(String s, int depth, int[] index) {
        int numberOfDashes = 0;
        while (index[0] + numberOfDashes < s.length() && s.charAt(index[0] + numberOfDashes) == '-') numberOfDashes++;
        if (numberOfDashes != depth) return null;
        int next = index[0] + numberOfDashes;
        while (next < s.length() && s.charAt(next) != '-') next++;
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(index[0] + numberOfDashes, next)));
        index[0] = next;
        root.left = dfs(s, depth + 1, index);
        root.right = dfs(s, depth + 1, index);
        return root;
    }
}
