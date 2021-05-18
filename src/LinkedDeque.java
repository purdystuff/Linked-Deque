public class LinkedDeque<T> implements DequeInterface<T> {

	protected DLLNode<T> front;    // reference to the front of this deque
	protected DLLNode<T> rear;     // reference to the rear of this deque
	protected int numElements = 0; // number of elements in this deque
	protected DLLNode<T> pos;

	public LinkedDeque() {
		front = null;
		rear = null;
	}

	private String makeString(DLLNode<T> list) {

		if(list == null) 
			return "";

		else {	    
			return list.getInfo().toString() + ", " + makeString(list.getForward());
		}
	}

	@Override
	public String toString() {
		// Do not modify this method.
		return makeString(front);
	}

	@Override
	public void enqueueFront(T element) {

		DLLNode<T> newNode = new DLLNode<T>(element);

		if (rear == null && front == null) {
			rear = newNode;
			front = newNode;
		}

		else {

			front.setBack(newNode);
			newNode.setInfo(element);
			newNode.setForward(front);
			front = newNode;
		}
		numElements++;

	}

	@Override
	public void enqueueRear(T element) {

		DLLNode<T> newNode = new DLLNode<T>(element);

		if (rear == null && front == null) {
			rear = newNode;
			front = newNode;
		}	    
		else {

			rear.setForward(newNode);
			newNode.setInfo(element);
			newNode.setBack(rear);
			rear = newNode;
		}
		numElements++;
	}

	@Override
	public T dequeueFront() throws QueueUnderflowException {

		if(isEmpty()==true) 
			throw new QueueUnderflowException("This queue is empty.  There are no elements to be removed.");

		T element;

		element = front.getInfo();
		front = front.getForward();
		front.setBack(null);

		if (front == null)
			rear = null;


		numElements --;

		return element;
	}

	@Override
	public T dequeueRear() throws QueueUnderflowException {

		if(isEmpty()==true) 
			throw new QueueUnderflowException("This queue is empty.  There are no elements to be removed.");

		T element;

		element = rear.getInfo();
		rear = rear.getBack();
		rear.setForward(null);


		if (rear == null) 
			front= null;

		numElements --;

		return element;
	}

	@Override
	public T dequeueNth(boolean flag, int n) throws QueueUnderflowException, OutOfRangeException {

		DLLNode<T> pos = front;
		DLLNode<T> posRear = rear;
		DLLNode<T> linkForward = null;
		DLLNode<T> linkBack = null;

		if(isEmpty()==true) 
			throw new QueueUnderflowException("This queue is empty.  There are no elements to be removed.");

		if(n > numElements || n <= 0)
			throw new OutOfRangeException("This number is out of range.  There are not that many elements in this queue");
		
		T element = pos.getInfo();
		
		if (flag == true) {

			if(n == 1) {
				dequeueFront();
			}
			else {
				for(int i = 1; i<n; i++) {
					pos = pos.getForward();
				}
				linkForward = pos.getForward();
				linkBack = pos.getBack();

				linkForward.setBack(linkBack);
				linkBack.setForward(linkForward);
				numElements --;
			}

		}

		if (flag == false) {

			if(n == 1) {
				dequeueRear();
			}
			else {
				for(int i = 1; i<n; i++) {
					posRear = posRear.getBack();
				}
				linkBack = posRear.getBack();
				linkForward = posRear.getForward();

				linkBack.setForward(linkForward);
				linkForward.setBack(linkBack);

				numElements --;
			}
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		if (numElements == 0)
			return true;
		else
			return false;	
	}

	@Override
	public int size() {

		return numElements;

	}
}
