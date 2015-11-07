/**
 * Created by HP on 19.10.2015.
 */
public class Tree {

    private Node root;
    private Node parent;

    /**
     * Klasa tworząca węzeł
     */
    private class Node {

        private Node left;
        private Node right;
        private Node parent;
        private Item item;

        public Node(double value,int index){
            item = new Item(value,index);
            left = null;
            right = null;
            parent = null;
        }

        /**
         * Klasa przechowująca wartości i numer indeksu.
         */
        private class Item{

            private double value;
            private int index;
            private int deep;

            public Item(double value, int index){
                this.index = index;
                this.value = value;
            }
        }

    }

    public Node getRoot(){
        return root;
    }

    /**
     * Dodawaine wartości do drzewa.
     * @param node wskażnik do węzła.
     * @param index dodawana wartość.
     * @return wskażnik do dziecka node.
     */
    public Node insert(Node node, double value, int index){
        if(root == null) {
            root = new Node(value, index);
            node = root;
            root.item.deep = 1;
        }
        else{
            Node actual = node;
            if(actual != null) {
                parent = actual;
                actual = (actual.item.index > index)? insert(actual.left, value, index) : insert(actual.right, value, index);
            }
            if (parent != null) {
                if (parent.item.index > index) {
                    parent.left = new Node(value, index);
                    parent.left.parent = parent;
                    parent.left.item.deep = parent.item.deep + 1;
                } else if (parent.item.index < index) {
                    parent.right = new Node(value, index);
                    parent.right.parent = parent;
                    parent.right.item.deep = parent.item.deep + 1;
                }
            }
        }
        return node;
    }


    /**
     * Metoda szuka podanej wartości w drzewie.
     * @param index szukany index.
     * @return wskażnik na strukture.
     */
    private Node serachNode(Node node, int index){
        if(node != null && node.item.index != index)
            node = (node.item.value > index)? serachNode(node.left, index) : serachNode(node.right, index);
        else if(node != null && node.item.index == index)
            return node;
        else if(node == null) {
            System.out.println("Nie znaleziono podanej wartości");
        }
        return node;
    }

    /**
     * Metoda szuka podanej warrości w drzewe.
     * @param node wskażnik na strukturę.
     * @param index szukany index.
     * @return wartość w podanym indekise.
     */
    public double serach(Node node, int index){
        Node tmp = serachNode(node, index);
        if(tmp != null)
            return tmp.item.value;
        else
            return 0;
    }

    /**
     * Metoda drukuje wartości z drzewa.
     * @param node korzeń drzewa.
     */
    public void get(Node node){
        if(node != null){
            get(node.left);
            System.out.println("Wartość: "+node.item.value+"  indeks: "+node.item.index + "  głębokość: " +node.item.deep);
            get(node.right);
        }
    }

}
