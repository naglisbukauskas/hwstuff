import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList implements Iterable {
    public Block head;
    public int size;

    public MyLinkedList(int size) {
        if(size == 0) {
            head = null;
        } else {
            head = new Block(1, size);
        }
        this.size = size;


    }

    public void insert(int offset, int size)
    {
        Block b1 = new Block(offset, size);
        if(head != null) {
            b1.next = head;
        }
        head = b1;
        this.size += size;
    }

    @Override
    public Iterator<Block> iterator() {
        return new Iterator<Block>() {

            Block curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public Block next() {
                if (hasNext()) {
                    Block data = curr;
                    curr = curr.next;
                    return data;
                }
                return null;
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
