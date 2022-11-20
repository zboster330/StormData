package project2;

/**
 * node class for double linked list
 * @author Zachary Boster
 *
 * @param <T>
 */
public class LinkedNode<T> {
	
	public T value;
	public LinkedNode<T> next;
	public LinkedNode<T> prev;
	
	public LinkedNode() {
		value = null;
		next = null;
		prev = null;
	}
	public LinkedNode(T value) {
		this.value = value;
		next = null;
		prev = null;
	}
	
	public LinkedNode(T value, LinkedNode<T> next, LinkedNode<T> prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
	
	public void displayNodeValue() {
		System.out.println(value);
	}
	
	
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public LinkedNode<T> getNext() {
		return next;
	}
	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}
	public LinkedNode<T> getPrev() {
		return prev;
	}
	public void setPrev(LinkedNode<T> prev) {
		this.prev = prev;
	}

}
