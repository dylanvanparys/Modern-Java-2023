import java.util.Collection;

// Only Java 21 actually has this interface, so here's a copy in J20
public interface SequencedCollection<E> extends Collection<E> {
    // new method
    SequencedCollection<E> reversed();
    // methods promoted from Deque
    void addFirst(E elem);
    void addLast(E elem);
    E getFirst();
    E getLast();
    E removeFirst();
    E removeLast();
}


