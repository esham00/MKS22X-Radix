import java.util.*;
public class MyLinkedList<E>{
    private int size;
    private Node<E> start, end;
    @SuppressWarnings("unchecked")     
    public MyLinkedList(Node<E> first, Node<E> last) {
	start = first;
	end = last;
	size = 2;
    }
    @SuppressWarnings("unchecked")
    public MyLinkedList() {
	size = 0;
    }
    @SuppressWarnings("unchecked")     
    public MyLinkedList(Node<E> value) {
	start = value;
    }
    public int size() {
	return size;
    }
    public boolean add(E value) {
	//adding to the start
	if (size == 0) {
	    start = new Node<E>(value);
	}
	//initializing end if there is only one value
	else if (size == 1) {
	    end = new Node<E>(value, start, null);
	    start.setNext(end);
	}
	else {
	    //creating a new end
	    Node<E> temp = new Node<E>(value, end, null);
	    //creating a link between the old end and new end
	    end.setNext(temp);
	    //setting the end to the new end
	    end = temp;
	}
	size++;
	return true;
    }
    public String toString() {
	String output = "[";
	Node<E> current = start;
	int i = 0;
	while (current != null) {
	    if (current.getNext() == null) {
	    	output += current.getData();
	    }
	    else {
	    	output += current.getData() + ", ";
	    }
	    current = current.getNext();
	}
	return output + "]";
    }
    @SuppressWarnings("unchecked")     
    private Node getNthNode(int index) {
	Node<E> current = start; 
	for(int i = 0; i < index; i++) {
	    current = current.getNext();
	}
	return current;
    }
    public void clear() {
	size = 0;
	start = null;
	end = null;
    }
    public void extend(MyLinkedList<E> other){
	//combining sizes
	size += other.size();
	//testing if this is empty
	if (size == other.size()) {
	    this.start = other.start;
	    this.end = other.end;
	    other.clear();
	}
	//if the other linked list is not empty then do the following procedure, does nothing if the other linked list is empty
	else if (other.size != 0) {
	    //linking the lists
	    this.end.setNext(other.start);
	    other.start.setPrev(this.end);
            end = other.end;
	    //clearing the other list
	    other.clear();
	}
     }
    public E removeFront() {
	if (size == 0) {
	    throw new NullPointerException();
	} else if (size == 1) {
	    E old = start.getData();
	    start = null;
	    end = null;
	    size--;
	    return old;
	} else {
	    E old = start.getData();
	    start = start.getNext();
	    start.setPrev(null);
	    size--;
	    return old;
	}
    }
}
@SuppressWarnings("unchecked")     
class Node<E> {
    private E data;
    private Node<E> next, prev;
    public Node(E input, Node<E> before, Node<E> after) {
    	data = input;
    	prev = before;
    	next = after;
    }
    public Node(E input) {
	data = input;
    }
    public Node(Node<E> input) {
	data = input.getData();
	next = input.getNext();
	prev = input.getPrev();
    }
    public E getData() {
	return data;
    }
    public Node getNext() {
	return next;
    }
    public Node getPrev() {
	return prev;
    }
    public E setData(E value) {
	E temp = data;
	data = value;
        return temp;
    }
    public void setNext(Node<E> after) {
	next = after;
    }
    public void setPrev(Node<E> before) {
	prev = before;
    }
    public String toString() {
	return data + "";
    }
}
