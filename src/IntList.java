public class IntList {
    private int[] data;
    private int size;

    IntList() {
        data = new int[4];
        size = 0;
    }

    IntList(IntList other) {
        this.data = new int[Math.max(4, other.size)];
        System.arraycopy(other.data, 0, this.data, 0, other.size);
        this.size = other.size;
    }

    void add(int value) {
        if (size == data.length){
            int[] bigger = new int[data.length * 2];
            System.arraycopy(data, 0, bigger, 0, size);
            data = bigger;
        }
        data[size++] = value;
    }

    int size() { return size; }

    void clear() { size = 0; }

    void removeLast() {
        if (size == 0) {
            System.out.print("Список пустой");
            return;
        }
        size--;
    }
    public void print_String() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] +  " ");
        }
    }
}
