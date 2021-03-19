public class ArrayDeque<T>  implements Deque<T>{

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int RFACTOR = 2;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = items.length - 1;
        nextLast = 0;
        size = 0;
    }

    public void resize(int capicity){
        T[] resized = (T[]) new Object[capicity];
        System.arraycopy(items, 0, resized, 0, size);
        items = resized;
        nextFirst = capicity - 1;
        nextLast = size;
    }

    private boolean isWaste() {
        return items.length >= 16 && size < (items.length / 4);
    }

    private int plusOne(int ptr){
        ptr += 1;
        if (ptr == items.length){
            ptr = 0;
        }
        return ptr;
    }

    private int minusOne(int ptr){
        ptr -= 1;
        if (ptr < 0){
            ptr = items.length - 1;
        }
        return ptr;
    }

//    @Override
//    public boolean isEmpty(){
//        return size == 0;
//    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
    }

    @Override
    public void addLast(T item){
        if (size == items.length) {
           resize(size * RFACTOR);
        }

        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;

    }

    @Override
    public T removeFirst() {

        nextFirst = plusOne(nextFirst);
        T t = items[nextFirst];
        items[nextFirst] = null;
        if (!isEmpty()) {
            size -= 1;
        }
        return t;
    }

    @Override
    public T removeLast() {

        nextLast = minusOne(nextLast);
        T t = items[nextLast];
        items[nextLast] = null;
        if (size != 0) {
            size -= 1;
        }
        return t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = plusOne(nextFirst); i < nextLast; i = plusOne(i)) {
            System.out.println(items[i] + " ");
        }
    }

    @Override
    public T get(int index){
        if(index >= size){
            return null;
        }
        return items[index];
    }

    public void insert(T item){

    }



}