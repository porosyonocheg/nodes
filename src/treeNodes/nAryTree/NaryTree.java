package treeNodes.nAryTree;

import java.util.ArrayList;
import java.util.List;

/**Узел N-арного дерева*/

public class NaryTree {
    public int val;
    public List<NaryTree> children;

    public NaryTree() {}

    public NaryTree(int val) {
        this.val = val;
    }

/**Конструктор содержит
 * @param val  значение узла
 * @param children список потомков узла*/

    public NaryTree(int val, List<NaryTree> children) {
        this.val = val;
        this.children = children;
    }

/**@return число узлов от корня до самого дальнего (глубокого) листового узла дерева*/
    public int maximumDepthOfTree() {
        if (children == null) return 1;
        int depth = 0;
        for (NaryTree naryTree : children){
            depth = Math.max(depth, naryTree.maximumDepthOfTree());
        }
        return 1 + depth;
    }

    /**Передаёт список значений узлов дерева в порядке их обхода:
     * @param order порядок перечисления узлов в списке: post - обратный, по умолчанию - прямой*/
    public List<Integer> treeToList(String order) {
        List<Integer> listOfNodes = new ArrayList<>();
        switch (order.toLowerCase()){
            case ("post"): postorder(listOfNodes); break;
            default: preorder(listOfNodes);
        }
        return listOfNodes;
    }

    private void postorder(List<Integer> list) {
        if (children != null) {
            for (NaryTree n : children) {
                n.postorder(list);
            }
        }
        list.add(val);
    }

    private void preorder(List<Integer> list) {
        list.add(val);
        if (children != null) {
            for (NaryTree n : children) {
                n.preorder(list);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        if (children != null) {
            sb.append(" -> ").append(children);
        }
        return sb.toString();
    }
}
