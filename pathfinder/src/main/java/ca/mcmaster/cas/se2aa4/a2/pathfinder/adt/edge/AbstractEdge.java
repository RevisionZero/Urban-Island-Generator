package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.edge;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public abstract class AbstractEdge<T> implements Edge<T> {

    private final double weight;

    private final boolean isWeighted;

    private final T node1;
    private final T node2;

    public AbstractEdge(T node1, T node2, double weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
        isWeighted = true;
    }

    public AbstractEdge(T node1, T node2){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = 1;
        isWeighted = false;
    }

    @Override
    public boolean containsNode(T node) {
        if(node != null) {
            return node.equals(node1) || node.equals(node2);
        }
        else{
            return false;
        }
    }

    @Override
    public T getNode1(){
        return this.node1;
    }

    @Override
    public T getNode2(){
        return this.node2;
    }


    @Override
    public boolean isWeighted() {
        return isWeighted;
    }

    @Override
    public double getWeight(){
        if(isWeighted){
            return this.weight;
        }
        else{
            throw new IllegalArgumentException("This edge is not weighted!");
        }
    }

    @Override
    public boolean equals(Edge<T> edge){
        return this.node1.equals(edge.getNode1()) && this.node2.equals(edge.getNode2());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEdge<?> that = (AbstractEdge<?>) o;
        return Double.compare(that.weight, weight) == 0 && isWeighted == that.isWeighted && Objects.equals(node1, that.node1) && Objects.equals(node2, that.node2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, isWeighted, node1, node2);
    }
}
