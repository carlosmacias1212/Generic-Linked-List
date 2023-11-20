// Class:		Data Structures 02
// Term:		Spring-2022
// Name:		Carlos Macias
// Program Number:	Assignment 1
// IDE: 		IntelliJ JDK 15.0.1

public class MyLinkedListCarlosMacias<T> {
	Node head;
	Node tail;
	int size;

	public class Node{
		T data;
		Node link;
		Node(){
		}
		Node(T element){
			data = element;
			link = null;
		}
	}
	
	MyLinkedListCarlosMacias(){
		head = null;
		tail = null;
		size = 0;
	}
	public T getFirst() throws RuntimeException{
		// return the first element or throw exception for empty list

		if (head == null) {
			throw new RuntimeException("in getFirst(): no elements in the list");
		} else {
			return head.data;
		}
	}
	public T getLast() throws RuntimeException{
		// return the last element or throw exception for empty list

		if (tail == null) {
			throw new RuntimeException("in getLast(): no elements in the list");
		} else {
			return tail.data;
		}
	}
	public void addLast(T newElement){
		// add a new Node to be the last element.
		// Write code here

		//old tail now points to newNode
		Node newNode = new Node(newElement);
		if (size == 0) {
			addFirst(newElement);
		} else {
			tail.link = newNode;
			tail = newNode;
			size++;
		}
	}
	public void removeLast(){
		// Case 1: if the list is empty --> throw any Exception with a message
		// Case 2: if you have only one elements
		// Case 3: in general case
		// Caution: you must care about the [tail] after removal
		// Write code here

		if (size == 0) {
			throw new RuntimeException("in removeLast(): no elements in the list");
		} else if (size == 1) {
			tail = head = null;
			size--;
		} else {

			//find second to last node nad make its link null to get rid of last node
			Node temp = head;
			int last = size - 2;
			while (last > 0) {
				temp = temp.link;
				last--;
			}

			temp.link = null;
			tail = temp;
			size--;

		}
		
	}
	
	public int indexOf(T targetElement){
		// search the targetElement in the list, return the index of given targetElement if it exists.
		// if the list doesn't have targetElement, return -1
		// Caution: index starts with 0  (the first element's index is 0)
		// Caution: to return index, you must check the index of node while you searching


		int index = 0;
		Node temp = head;

		//traverse through list until temp = tail.next which is null
		while (temp != null) {
			if (temp.data == targetElement) {
				return index;
			} else {
				index++;
				temp = temp.link;
			}
		}
		return -1;
	}
	public Iterator iterator(){
		return new Iterator();
	}
	
	// Complete the Iterator class
	class Iterator {
		Node next; // to point [next node] object
		
		Iterator(){
			// next must be the first node of the list
                	next = head;
		}

		public T next(){
			 // return the data_field of [next node]
                	T data_field = next.data;
                	next = next.link;
                	return data_field;		
		}
		public boolean hasNext(){
			// return true when the [next node] exists
                	// return false when we don't have the [next node]
                	if (next != null) {
                	    return true;
               	 	}
                	return false;
		}
		
	}
	
	public void removeFirst() throws RuntimeException {
		if(head == null) {
			throw new RuntimeException("in removeFirst(): no elements in the list");
		}
		else if(head == tail) { // if(size==1)
			head = tail = null;
			size --;
		}
		else {
			head = head.link;
			size--;
		}
		
	}
	public void remove(int index) {
		if(index == 0) {
			removeFirst();
		}
		else if(head == tail) {
			head = tail = null;
			size--;
		} 
		else {
			Node cur = head;
			while (--index > 0) {
				cur = cur.link;
			}
			Node targetNode = cur.link;
			cur.link = targetNode.link;
			size--;
			if(cur.link == null)
				tail = cur;
		}
	}
	
	public void addFirst(T newElement){
		Node newNode = new Node(newElement);
		newNode.link = head;
		head = newNode;
		if(size==0) {
			tail = newNode;
		}
		size++;
	}
	
	public void add(int index, T newElement) {
		if(index == 0)
			addFirst(newElement);
		else {
			Node temp1 = head;
			while (--index > 0) {
				temp1 = temp1.link;
			}
			Node newNode = new Node(newElement);
			newNode.link = temp1.link;
			temp1.link = newNode;

			if (newNode.link == null) {
				tail = newNode;
			}
			size++;
		}
	}
	
	public String toString() {
		String str = "[";
		Node temp = head;
		
		while(temp != null) {
			str = str + temp.data;
			if(temp != tail) {
				str = str + ", ";
			}
			temp = temp.link;
		}		
		return str = str + "]";
	}
	
}
