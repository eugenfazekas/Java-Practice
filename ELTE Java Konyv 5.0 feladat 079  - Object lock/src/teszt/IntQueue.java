package teszt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntQueue {
	
	int row[] ; // lista
	int first =0 , last =0, num_of_elements, row_length;
	private Lock lock = new ReentrantLock(); //zar
	// ket felteteles valtozo , "nem ures " es "nem tele" sor
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	public IntQueue(int row_length) {
		this.row_length=row_length;
		row =new int [row_length]; 
	}
	
	public void put(int value)throws InterruptedException{
		lock.lock();
		try {
			while(num_of_elements == row_length) {
				System.out.println(Thread.currentThread().getName() + " var ");
				notFull.await(); // varunk , h ne legyen tele a sor
			}
			row[last] =value;
			last = (last +1) % row_length;
			num_of_elements++;
			notEmpty.signal();
			
		}finally {
			lock.unlock(); // biztonsagos zar kezeles
		}
	}
	
	public int get() throws InterruptedException{
		
		lock.lock();
		try {
			while(num_of_elements == 0 ) {
				System.out.println(Thread.currentThread().getName() + " var ");
				notEmpty.await(); // varunk, h ne legyen ures a sor
			}
		first = (first+1) % row_length;
		num_of_elements--;
		notFull.signal();
	}finally { lock.unlock(); // biztonsagos zar kezeles
		}
		return row[first];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
