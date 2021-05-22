package treeNodes;

/** Содержит методы сериализации и десериализации бинарного дерева
 * @author Сергей Шершавин*/

public class Serialization {

    /**Сериализует бинарное дерево, представляя его в виде строки
     * @param root корень сериализуемого дерева*/
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**Восстанавливает бинарное дерево из сериализованного представления в строке
     * @param data строка, содержащая сериализованное представление дерева*/
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");
        return build(nodes, new int[]{0});
    }

    private void preorder (TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(',');
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    private TreeNode build(String[] nodes, int[] index) {
        if (index[0] == nodes.length || nodes[index[0]].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        root.left = build(nodes, index);
        index[0]++;
        root.right = build(nodes, index);
        return root;
    }
}
