import java.util.ArrayList;

public class Proj2Main {

	public static void main(String[] args) throws QueueUnderflowException, OutOfRangeException {
		//Provide your tests below.
		
		DequeInterface <Integer> d1 = new LinkedDeque<Integer>();
		
//		d1.dequeueFront();
		//d1.dequeueRear();
		
		d1.enqueueFront(3);		
		d1.enqueueFront(2);
		d1.enqueueFront(1);
		d1.enqueueFront(0);
				
		d1.enqueueRear(4);
		d1.enqueueRear(5);
		d1.enqueueRear(6);
		d1.enqueueRear(7);
		
//		d1.dequeueFront();
//		d1.dequeueFront();
		
//		d1.dequeueRear();
//		d1.dequeueRear();
		
//		
//		d1.dequeueNth(true, 9);
//		d1.dequeueNth(true, 3);
//		d1.dequeueNth(false, 1);
//		d1.dequeueNth(false, 4);
		//d1.enqueueRear(6);
//		d1.dequeueRear();
//		d1.dequeueFront();
//		d1.dequeueFront();
//		d1.dequeueFront();
//		d1.enqueueFront(1);
		//d1.dequeueRear();

//		System.out.println(d1.isEmpty());
//		
		System.out.println(d1.size());

		System.out.println(d1.toString());
		
		

	}
}
