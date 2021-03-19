public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private final int RFACTOR = 2;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = items.length - 1;
        size = 0;
    }

    public void resize(int capicity){
        T[] resized = (T[]) new Object[capicity];
        System.arraycopy(items, 0, resized, 0, size);
        items = resized;
        nextFirst = size;
        nextLast = capicity - 1;
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

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size++;
        if (size == items.length) {
            size *= RFACTOR;
        }
    }

    public void addLast(T item){
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size++;
        if (size == items.length) {
            size *= RFACTOR;
        }
    }

    public T removeFirst(){
        T item;
        if (size == 0){
            return null;
        }
        item = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        size--;
        return item;
    }

    public T removeLast(){
        T item;
        if (size == 0){
            return null;
        }
        item = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = plusOne(nextFirst); i < nextLast; i = plusOne(i)) {
            System.out.println(items[i] + " ");
        }
    }

    public T get(int index){
        if(index >= size){
            return null;
        }
        return items[index];
    }



}