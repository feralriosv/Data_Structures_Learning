import heap.MinHeap;

public class Testing {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);

        System.out.println("🔹 Test 1: Un solo elemento");
        heap.insert(42);
        System.out.println("extractMin() = " + heap.extractMin()); // 42
        System.out.println(heap);
        System.out.println("isEmpty() = " + heap.isEmpty());       // true

        System.out.println("\n🔹 Test 2: Varios elementos");
        heap.insert(10);
        heap.insert(4);
        heap.insert(7);
        System.out.println("extractMin() = " + heap.extractMin()); // 4
        System.out.println(heap);
        System.out.println("peek() = " + heap.peek());             // 7
        System.out.println("size() = " + heap.size());             // 2

        System.out.println("\n🔹 Test 3: Extracciones sucesivas");
        heap.insert(5);
        heap.insert(1);
        System.out.println(heap);
        System.out.println("extractMin() = " + heap.extractMin()); // 1
        System.out.println(heap);
        System.out.println("extractMin() = " + heap.extractMin()); // 5
        System.out.println("peek() = " + heap.peek());             // 7 -> WRONG OUTPUT, it must be corrected

        System.out.println("\n🔹 Test 4: Con duplicados");
        MinHeap dupHeap = new MinHeap(10);
        dupHeap.insert(2);
        dupHeap.insert(2);
        dupHeap.insert(1);
        dupHeap.insert(1);
        System.out.println("extractMin() = " + dupHeap.extractMin()); // 1
        System.out.println("extractMin() = " + dupHeap.extractMin()); // 1
        System.out.println("extractMin() = " + dupHeap.extractMin()); // 2
        System.out.println("extractMin() = " + dupHeap.extractMin()); // 2

        System.out.println("\n🔹 Test 5: Heap vacío");
        MinHeap empty = new MinHeap(5);
        try {
            empty.extractMin();
        } catch (Exception e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("\n🔹 Test 6: Orden completo");
        MinHeap fullHeap = new MinHeap(10);
        fullHeap.insert(9);
        fullHeap.insert(4);
        fullHeap.insert(6);
        fullHeap.insert(3);
        fullHeap.insert(7);
        fullHeap.insert(1);
        while (!fullHeap.isEmpty()) {
            System.out.println("→ " + fullHeap.extractMin());
        }
    }
}
