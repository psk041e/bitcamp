package bitcamp.java106.pms.dao;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class AbstractDao<E> {
    protected LinkedList<E> collection = new LinkedList<>();
    
    public void insert(E value) {
        collection.add(value);
    }
    public Iterator<E> list() {
        return collection.iterator();
    }
    public E get(Object key) {
        int index = this.indexOf(key);
        if (index == -1)
            return null;
        return collection.get(index);
    }
    public void update(int index, E value) {
        collection.set(index, value);
    }
    public void delete(Object key) {
        int index = this.indexOf(key);
        if (index == -1)
            return;
        collection.remove(index);
    }
    public abstract int indexOf(Object key);
}
