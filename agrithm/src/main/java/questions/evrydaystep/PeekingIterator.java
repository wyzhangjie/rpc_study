package questions.evrydaystep;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer nextPos;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        nextPos = iterator.hasNext() ? iterator.next() : null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return nextPos;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int temp = nextPos;
        nextPos = iter.hasNext() ? iter.next() : null;
        return temp;
    }

    @Override
    public boolean hasNext() {
        return nextPos == null ? false : true;
    }
}