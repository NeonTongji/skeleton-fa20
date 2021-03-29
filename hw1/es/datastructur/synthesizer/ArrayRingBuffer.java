package es.datastructur.synthesizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        rb = (T[])new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }

    private int plusOne(int ptr){
        if(ptr == rb.length - 1) {
            return 0;
        }
        return ptr + 1;
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last. Don't worry about throwing the RuntimeException until you
        //       get to task 4.

        if(fillCount == capacity()) {
            throw new RuntimeException("Ring Buffer overflow");
        }

        rb[last] = x;
        fillCount++;
        last = plusOne(last);
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first. Don't worry about throwing the RuntimeException until you
        //       get to task 4.

        if(fillCount == capacity()) {
            throw new RuntimeException("Ring Buffer underflow");
        }

        T temp = rb[first];
        fillCount--;
        first = plusOne(first);
        return temp;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change. Don't worry about throwing the RuntimeException until you
        //       get to task 4.
        if(fillCount == capacity()) {
            throw new RuntimeException("Ring Buffer underflow");
        }
        return rb[first];
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.


    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {

        private int index;

        public ArrayRingBufferIterator(){
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < capacity();
        }

        @Override
        public T next() {
            T nextItem = rb[index];
            index++;
            return nextItem;
        }

        @Override
        public boolean equals(Object obj) {
            ArrayRingBuffer<T> array1 = (ArrayRingBuffer<T>) obj;
            ArrayRingBuffer<T> array2 = (ArrayRingBuffer<T>) obj;
            while(array1.iterator().hasNext()){
                if(array1.dequeue().equals(array2.dequeue())) {
                    return false;
                }
            }
            return true;
        }
    }

}
    // TODO: Remove all comments that say TODO when you're done.
