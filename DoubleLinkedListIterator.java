package project2;

import java.util.Iterator;
import java.util.NoSuchElementException;

//iterator for double linked list
public class DoubleLinkedListIterator<T> implements Iterator<T>  {

	LinkedNode<T> current;
	
	public DoubleLinkedListIterator(LinkedNode<T> current) {
		this.current = current;
	}
	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException("error");
		}
		T result = current.getValue();
		current = current.getNext();
		return result;
	}
}
