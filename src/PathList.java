public class PathList{
    private IntList[] data;
    private int size;

    PathList(){
        data = new IntList[4];
        size = 0;

    }

    void add(IntList path){
        if (size == data.length){
            IntList[] bigger = new IntList[data.length * 2];
            System.arraycopy(data, 0, bigger, 0, size);
            data = bigger;
        }
        data[size++] = path;
    }

    IntList get(int index){
        return data[index];
    }

    int size(){
        return size;
    }

    void clear(){
        size = 0;
    }
}