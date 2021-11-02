import java.util.Iterator;
public class MyMemoryAllocation extends MemoryAllocation{

    String algorithm;
    int usableMemory;
    private static MyLinkedList free_list;
    private static MyLinkedList used_list;

    public MyMemoryAllocation(int mem_size, String algorithm) {
        super(mem_size, algorithm);
        //0 is reserved as an error code to indiciate a failed allocation, so a legit address starts with 1. Usable memory is n - 1;

        free_list = new MyLinkedList(mem_size - 1);
        used_list = new MyLinkedList(0);
        this.algorithm = algorithm;

    }

    public void printAvailableBlocks() {

    }

    @Override
    public int alloc(int size) {
        // If the memory of requested size is available, the function returns an address (offset) of the beginning of allocated memory. Otherwise it returns 0.
//        return switch (algorithm) {
//            case "FF" -> allocWithFF(size);
//            case "BF" -> allocWithBF(size);
//            case "NF" -> allocWithNF(size);
//            default -> 0;
//        };
//        if(algorithm.equals("FF")) {
//            return allocWithFF(size);
//        }
//        return 0;
        return allocWithFF(size);
    }

    static int allocWithFF(int size) {
        Iterator<Block> listIterator = free_list.iterator();
        Block block = free_list.head;
        while(listIterator.hasNext()) {
            if (block.getSize() >= size) {
                int address = block.getOffset();
                used_list.insert(address, size);
                block.setOffset(address + size);
                block.setSize(block.getSize() - size);
                block = listIterator.next();
                return block.getOffset();
            }
        }
        return 0;
    }

    static int allocWithBF(int size) {
        return 0;
    }

    static int allocWithNF(int size) {
        return 0;
    }


    @Override
    public void free(int addr) {

    }

    @Override
    public int size() {
        Iterator<Block> listIterator = free_list.iterator();
        int totalSize = 0;
        Block block = free_list.head;
        while(listIterator.hasNext()) {
            totalSize += block.size;
            block = listIterator.next();
        }
        return totalSize;
    }

    @Override
    public int max_size() {
        Iterator<Block> listIterator = free_list.iterator();
        int maxSize = 0;
        Block block = free_list.head;
        while(listIterator.hasNext()) {
            if(block.size > maxSize) {
                maxSize = block.size;
            }
            block = listIterator.next();
        }
        return maxSize;
    }

    @Override
    public void print() {
        System.out.println("Free List: ");
        Iterator<Block> listIterator = free_list.iterator();
        Block block = listIterator.next();
        System.out.print("[" + block.offset + " -> " + (block.offset + block.size) + "], ");
        while (listIterator.hasNext()) {
            block = listIterator.next();
            System.out.print("[" + block.offset + " -> " + (block.offset + block.size) + "], ");
        }

        System.out.println();
        System.out.println("Used List: ");
        if(used_list.size != 0) {
            listIterator = used_list.iterator();
            block = listIterator.next();
            System.out.print("[" + block.offset + " -> " + (block.offset + block.size) + "], ");
            while (listIterator.hasNext()) {
                block = listIterator.next();
                System.out.print("[" + block.offset + " -> " + (block.offset + block.size) + "], ");
            }
        } else {
            System.out.println("used list is empty");
        }
    }
}
