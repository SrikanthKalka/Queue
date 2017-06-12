package com.shrikanth.queue;

public class QueueMainTest {

	public static void main(String[] args) {

		QueueImpl testQueue = new QueueImpl();

		testQueue.enQueue(5);
		testQueue.enQueue(10);
		testQueue.enQueue(15);
		testQueue.enQueue(20);
		testQueue.enQueue(30);

		System.out.println("Queue-Array Elements: "
				+ testQueue.queueArray.toString());

	}

}
