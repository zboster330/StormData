package project2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Double Linked list class extending java linkedlist
 * @author Zachary Boster
 *
 * @param <T>
 */
public class DoubleLinkedList<T> extends LinkedList<T> {
	
	public int count;
	public LinkedNode<T> head;
	public LinkedNode<T> tail;
	
	
	//check if list is empty
	public boolean isEmpty() {
		return (head == null);
	}
	
	//add the element to the beginning of the Linked List
	public void addFirst(T element) {
		LinkedNode Node = new LinkedNode();
		Node.value = element;
		Node.next = head;
		Node.prev = null;
		if(head!=null) {
			head.prev = Node;
		}
		head = Node;
		if (tail == null) {
			tail=Node;
		}
		count++;
	}
	
	//add the element to the End of the Linked List
	public void addLast(T element) {
		LinkedNode Node = new LinkedNode();
		Node.value = element;
		Node.next = null;
		Node.prev=tail;
		if(tail!=null)
			tail.next=Node;
		tail = Node;
		if(head==null)
			head=Node;
		count++;
	}
	
	//Print the List from the front to the back
	public void printForward() throws EmptySetException{
		LinkedNode current = head;
		while (current != null) {
			current.displayNodeValue();
			current = current.next;
		}
	}
	//Print the List from the back to the front
	public void printBackward() throws EmptySetException{
		LinkedNode current = tail;
		while (current != null) {
			current.displayNodeValue();
			current = current.prev;
		}
	}
	//Iterator for the double linked list
	public Iterator<T> iterator() { 
		return new DoubleLinkedListIterator<T>(head);
	}
	
	//returns true if the linked list contains the element
	public boolean Contains(T element) throws EmptySetException{
		if (element == null) {
			return true;
		}
		LinkedNode<T> current = head;
		while(current != null) {
			if(current.getValue().equals(element)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	//remove a specific element in the list
	public T Remove(T element) throws EmptySetException{
		if (element == null) {
			return null;
		}
		LinkedNode<T> prev = null;
		LinkedNode<T> current = head;
		while(current != null && !element.equals(current.getValue())) {
			prev = current;
			current = current.getNext();
		}
		if (current == null) {
			return null;
		}
		if (prev != null) {
			prev.setNext(current.getNext());
			if (tail == current) {
				tail = prev;
			}
		}else {
			head = current.getNext();
			if (count == 1) {
				tail = tail.getNext();
			}
		}
		count --;
		return element;
	}
	
	//insert an element at a specific location
	public void insert(int index, T element){ 
		
		if (index  < 0 || index > count) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			return;
		}
				
		if(contains(element)) {
			return;
		}
		
		LinkedNode<T> newNode = new LinkedNode<T>(element);
		
		if (head == null) {
			head = newNode;
			tail = newNode;
			count++;
			return;
		}

		int i = 0;
		LinkedNode<T> current = head;
		LinkedNode<T> prev = null;
		while(i  < index) {
			prev = current;
			current = current.getNext();
			i++;
		}
		if (current == null) {
			tail.setNext(newNode);
			tail = newNode;
		}else if (prev == null) {
			newNode.setNext(head);
			head = newNode;
		}else {
			prev.setNext(newNode);
			newNode.setNext(current);
		}
		count++;
	}
	
	//get the location of an element in the list
	public T get(int index) {
		if (index  < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}
		LinkedNode<T> current = head;
		int i = 0;
		while(current != null && i < index) {
			current = current.getNext();
			i++;
		}
		return current.getValue();
	}

	//sort the elements in the linked list by bubble sort
	public void bubbleSort(DoubleLinkedList<T> linkedSet, int i) throws EmptySetException {
/**		
	    int swapped;  
	    LinkedNode<T> ptr1;  
	    LinkedNode<T> lptr = null;  
	  
	    do
	    {  
	        swapped = 0;  
	        ptr1 = (LinkedNode<T>) linkedSet.get(i);  
	        while (linkedSet.get(i) != lptr)  
	        {  
	            if (Integer.parseInt(ptr1.value.toString()) > Integer.parseInt(ptr1.next.value.toString()))  
	            {  
	                T t = (T) ptr1.value; 
	                ptr1.value = ptr1.next.value; 
	                ptr1.next.value = t; 
	                swapped = 1;  
	            }  
	            ptr1 = ptr1.next;
	        }  
	        lptr = ptr1;  
	    }  
	    while (swapped != 0);  
	        return; 
	        **/
	}
} 
