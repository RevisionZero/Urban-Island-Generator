package ca.mcmaster.cas.se2aa4.a2.pathfinder.adt.util;

public class Pair<T, E> {
    private final T node;
    private final E priority;

    /**
     *
     * @param node The first element of the pair.
     * @param priority The second element of the pair.
     */
    public Pair(T node, E priority) {
        this.node = node;
        this.priority = priority;
    }

    /**
     *
     * @return The node of type {@link T} of this pair.
     */
    public T getNode(){
        return this.node;
    }

    /**
     *
     * @return Returns the priority of type {@link E} of the pair.
     */
    public E getPriority() {
        return this.priority;
    }
}
