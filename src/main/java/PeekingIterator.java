import java.util.Iterator;

/**
 * Created by sunhongbo on 16/5/12.
 */
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> mIterator;

    Integer cache;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        mIterator = iterator;
        cache = iterator.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = cache;
        cache = mIterator.hasNext() ? mIterator.next() : null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return (mIterator.hasNext() || cache != null);
    }
}
