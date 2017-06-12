package com.shrikanth.queue;

/**
 * First-In-First-Out(FIFO):
 * 
 * Definition: "First inserted element should be deleted First".
 * 
 * EnQueue(): A new element should be inserted at top of the old elements
 * (Existing)
 * 
 * deQueue() : The old element(Which is inserted very first) should be deleted.
 * 
 * @author srikanth
 */
public class QueueImpl {

	public int[] queueArray;

	/**
	 * Important Tip: front & rear are act like a index pointer.
	 * 
	 * whenever we were inserting the new elements we have incrementing the
	 * front index and we have remaining same as rear because whenever user want
	 * to deQueue, then we should have primary element index in our hand to
	 * delete.
	 */

	public int frontPtr;
	public int rearPtr;
	public int queueSize;

	QueueImpl() {

		frontPtr = -1;
		rearPtr = -1;
		queueSize = 3;
		queueArray = new int[queueSize];
	}

	/**
	 * lets say, we inserted 3 elements in our queue(Size=3).That time, insert
	 * element(5); front = 0; insert element(10); front = 1; insert element
	 * (15); front = 2; ( Queue is full now)
	 * 
	 * based on above observation we can create a logic to re-size the Queue
	 * 
	 * queue size = front+1; so,if front+1 => queue size; then increase the
	 * QueueSize
	 * 
	 * Place the new data in to the Queue array, using by increment frontptr.
	 * 
	 * @param newData
	 */
	public void enQueue(int newData) {

		if (frontPtr + 1 >= queueSize)
			resizeQueue();

		queueArray[++frontPtr] = newData;
	}

	private void resizeQueue() {

		int[] temp = queueArray;
		queueSize = queueSize * 2;
		queueArray = new int[queueSize];

		for (int i = 0; i <= frontPtr; i++) {

			queueArray[i] = temp[i];
		}

	}

	/**
	 * step 1: frontPtr is greater than rear pointer, then elements exist in the
	 * Queue go ahead and delete the element
	 * 
	 * Otherwise, return 0
	 * 
	 * @param newData
	 * @return
	 */
	public int deQueue(int newData) {

		if (frontPtr > rearPtr)
			return queueArray[++rearPtr];

		return 0;

	}

	public boolean isEmptyQueue() {

		return frontPtr <= rearPtr;

	}
}
