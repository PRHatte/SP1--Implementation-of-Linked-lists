/** @author Shubham Raosaheb Kharde(sxk173732) and Pranita Hatte (prh170230)
 *  Doubly Linked List: Implementation of Data Structure and Algorithms - Short Project 1
 */

package sxk173732;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoublyLinkedList<T> extends SinglyLinkedList<T> {

	/** Interface to support additional methods */
	public interface DoublyLinkedListIterator<T> {
		boolean hasNext();

		boolean hasPrev();

		T next();

		T prev();

		void add(T x);

		void remove();
	}

	/** Class Entry holds a single node of the list */
	static class Entry<E> extends SinglyLinkedList.Entry<E> {
		Entry<E> prev;

		Entry(E x, Entry<E> next, Entry<E> prev) {
			super(x, next);
			this.prev = prev;
		}
	}

	public DoublyLinkedList() {
		head = new Entry<>(null, null, null);
		tail = head;
		size = 0;
	}

	public DoublyLinkedListIterator<T> dllIterator() {
		return new DLLIterator();
	}

	protected class DLLIterator extends SLLIterator implements DoublyLinkedListIterator<T> {

		DLLIterator() {
			super();
		}

		@Override
		public boolean hasPrev() {
			/* Handling processing of the dummy head. */
			return (((Entry<T>) cursor).prev != null) && (((Entry<T>) cursor).prev.element != null);
		}

		@Override
		public T prev() {
			if (hasPrev()) {
				prev = ((Entry<T>) prev).prev;
				cursor = ((Entry<T>) cursor).prev;
				ready = true;
				return cursor.element;
			} else {
				throw new NoSuchElementException();
			}

		}

		// Add new element at the cursor
		// Disabling remove after this operation
		@Override
		public void add(T x) {
			Entry<T> newEntry = new Entry<T>(x, (Entry<T>) ((Entry<T>) cursor).next, (Entry<T>) cursor);
			/*
			 * Condition to check whether the next element to the cursor is null. In case of
			 * adding at tail.
			 */
			if (hasNext()) {
				((Entry<T>) ((Entry<T>) cursor).next).prev = newEntry;
			}
			cursor.next = newEntry;
			cursor = newEntry;
			ready = false; // Should call next() or prev() for removal
			prev = ((Entry<T>) cursor).prev;
			size++;
		}

		// Remove can be called only if next/prev has been called and the element has
		// not been removed
		@Override
		public void remove() {
			if (!ready) {
				throw new NoSuchElementException();
			}
			if (hasNext()) { // Handling removal at tail
				((Entry<T>) ((Entry<T>) cursor).next).prev = (Entry<T>) prev;
			}
			super.remove();
			prev = ((Entry<T>) cursor).prev;
		}
	}

	@Override
	public void add(T x) {
		add(new Entry<>(x, null, (Entry<T>) tail));
	}

	public static void main(String[] args) throws NoSuchElementException {
		int n = 10;
		if (args.length > 0) {
			n = Integer.parseInt(args[0]);
		}

		DoublyLinkedList<Integer> lst = new DoublyLinkedList<>();
		for (int i = 1; i <= n; i++) {
			lst.add(Integer.valueOf(i));
		}
		lst.printList();

		DoublyLinkedListIterator<Integer> it = lst.dllIterator();

		Scanner in = new Scanner(System.in);
		whileloop: while (in.hasNext()) {
			int com = in.nextInt();
			switch (com) {
			case 0: // Move to previous element and print it
				if (it.hasPrev()) {
					System.out.println(it.prev());
				} else {
					break whileloop;
				}
				break;
			case 1: // Move to next element and print it
				if (it.hasNext()) {
					System.out.println(it.next());
				} else {
					break whileloop;
				}
				break;
			case 2: // Remove element
				it.remove();
				lst.printList();
				break;
			case 3: // Add element at cursor
				System.out.println("Enter a number to add into list");
				it.add(in.nextInt());
				lst.printList();
				break;
			default: // Exit loop
				break whileloop;
			}
		}
		lst.printList();
		lst.unzip();
		lst.printList();
	}

}
