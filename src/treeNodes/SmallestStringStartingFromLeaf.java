package treeNodes;

/**Возвращает наименьшую строку в лексикографическом порядке, собранную из значений узлов дерева по пути от листа к корню
 * Бинарное дерево должно содержать значения от 0 до 25 включительно, соответствующие буквам латинского алфавита от a до z
 * соответственно.
 * @author Сергей Шершавин*/

public class SmallestStringStartingFromLeaf extends Command {
    public SmallestStringStartingFromLeaf(TreeNode root) {
        super(root);
    }

    private void traversalTree(TreeNode node, StringBuilder sb, String[] result) {
        sb.append((char)(node.val + 97));
        if (node.left == null && node.right == null) {
            String current = new StringBuilder(sb).reverse().toString();
            if (current.compareTo(result[0]) < 0) result[0] = current;
        }
        if (node.left != null) traversalTree(node.left, sb, result);
        if (node.right != null) traversalTree(node.right, sb, result);
        sb.setLength(sb.length() - 1);
    }

    @Override
    public Object execute() {
        String[] result = new String[]{"|"}; // чтобы не проверять на null или пустую строку, данная строка
                                            // лексикографически больше любой другой строки, составленной из латинских букв
        traversalTree(root, new StringBuilder(), result);
        return result[0];
    }
}
