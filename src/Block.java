public class Block {
    //offset = address
    int offset;
    int size;
    Block next;

    public String toString() {
        return "Offset: " + offset + " Size: " + size;
    }

    public boolean isAdjacent(Block other) {
        return false;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setSize(int size) {
        this.size = size;
    }

    Block(int offset, int size) {
        this.offset = offset;
        this.size = size;
        next = null;
    }
}