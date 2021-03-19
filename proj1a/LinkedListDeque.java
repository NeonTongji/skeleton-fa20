public class LinkedListDeque <T> {

//    建立TNode类， T代表Deque，TNode是Deque节点
    private class TNode{
        private T item;
        private TNode prev;
        private  TNode next;

//        初始化TNode
        private TNode(T item, TNode prev, TNode next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private final TNode sentinel;
    private int size;

    //    Creates an empty linked list deque.
    public LinkedListDeque(){
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    //    constant time with no loop and recursion
    public void addFirst(T item){
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        sentinel.next.next = sentinel.next;
        size++;
    }

    //    constant time with no loop and recursion
    public void addLast(T item){
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //    constant time
    public int size(){
        return size;
    }

    public void  printDeque(){
    /* Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.
     */
        for(int i = 0; i < size; i++) {
            System.out.println(get(i) + " ");
        }
    }

    public T removeFirst(){
        /*Removes and returns the item at the front of the deque.
         *If no such item exists, returns null.
        */
        if (isEmpty()){
            return null;
        }
        T item = sentinel.next.item;
        TNode temp = sentinel.next.next;
        sentinel.next = sentinel.next.next;
        temp.prev = sentinel;
        size--;
        return item;
    }

    public T removeLast(){
        /*Removes and returns the item at the back of the deque.
         *If no such item exists, returns null.
         */
        if (isEmpty()){
            return null;
        }
        T item = sentinel.prev.item;
        TNode temp = sentinel.prev.prev;
        sentinel.prev = sentinel.prev.prev;
        temp.next = sentinel;
        size--;
        return item;
    }

    //    iteration
    public T get(int index){
        if (isEmpty()){
            return null;
        }
        TNode ptr = sentinel.next;
        while (index > 0){
            ptr = ptr.next;
            index--;
        }
        return ptr.item;
    }

    //    recursion
    public T getRecusion(int index){
        if (isEmpty()){
            return null;
        }
        return  getRecusionHelper(index, sentinel.next);
    }

    private T getRecusionHelper(int index, TNode n){
        if(index == 0){
            return n.item;
        }
        return getRecusionHelper(index - 1, n.next);
    }

}