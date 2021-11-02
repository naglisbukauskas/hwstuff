public class Main {

    public static void main(String[] args) {
        MyMemoryAllocationTest mmat = new MyMemoryAllocationTest();
//        MyMemoryAllocation mal= new MyMemoryAllocation(500, "FF");
//        System.out.println(mal.size());

        MyMemoryAllocation mal= new MyMemoryAllocation(14, "FF");
        mal.print();
        mal.alloc(1);
        mal.alloc(3);
//        mal.alloc(2);
//        mal.alloc(2);
//        mal.alloc(1);
//        mal.alloc(1);
//        mal.alloc(1);
        mal.print();

//        mmat.testConstructor();
    }

}
