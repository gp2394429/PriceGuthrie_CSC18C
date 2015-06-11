public class Driver{
    public static void main(String args[]){
        Graph g = new Graph();
        for(int i=0;i<5;i++){
            g.addVertex(i);
        }
        g.addEdge(1,2,4);
        g.addEdge(2,3,6);
        g.addEdge(1,4,1);
        g.addEdge(1,3,2);
        Graph h = g.minSpanTree();
        System.out.println(g);
        System.out.println(h);
    }
}
