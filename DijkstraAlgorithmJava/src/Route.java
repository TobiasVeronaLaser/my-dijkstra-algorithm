public class Route {
    private Node node0;
    private Node node1;
    private int value;

    public Route() throws Exception {
        this(null, null, -1);
    }

    public Route(Node node0, Node node1, int value) throws Exception {
        route(node0, node1, value);
    }

    public void route(Node node0, Node node1, int value) throws Exception {
        if (node0.getRoutes().containsKey(node1.getName()))
            throw new Exception("Nodes are already connected");
        this.node0 = node0;
        this.node1 = node1;
        this.value = value;
        node0.setRoute(node1.getName(), this);
        node1.setRoute(node0.getName(), this);
    }


    public void clear() {
        node0.removeRoute(node1.getName());
        node1.removeRoute(node0.getName());
        value = -1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" +
                this.node0.getName() + "," +
                this.node1.getName() + "," +
                this.value + ")";
    }

    public Node getNode0() {
        return node0;
    }

    private void setNode0(Node node0) {
        this.node0 = node0;
    }

    public Node getNode1() {
        return node1;
    }

    private void setNode1(Node node1) {
        this.node1 = node1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNeighbourNode(Node node) {
        if (node == node0)
            return node1;
        if (node == node1)
            return node0;
        return null;
    }
}
