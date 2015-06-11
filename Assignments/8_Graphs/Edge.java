public class Edge{

        public int v1;
        public int v2;
        public int weight;

        public Edge(int start, int end, int w){
            v1 = start;
            v2 = end;
            weight = w;
        }
        public boolean greater(Edge e){
            return weight > e.weight;
        }
    }
