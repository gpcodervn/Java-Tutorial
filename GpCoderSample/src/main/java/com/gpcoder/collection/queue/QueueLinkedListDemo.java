package com.gpcoder.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedListDemo {
	public static void main(String[] args) {
		// Khởi tạo hàng đợi LinkedList
		Queue<String> names = new LinkedList<String>();

		// offer(E): Thêm phần tử vào hàng đợi (queue).
		// Với hàng đợi LinkedList phần tử sẽ được thêm vào cuối hàng đợi.
		// Trả về true nếu trèn thành công.
		// Trả về false nếu hàng đợi không còn chỗ.
		names.offer("E");
		names.offer("A");
		names.offer("M");

		// add(E): Thêm phần tử vào hàng đợi.
		// Với hàng đợi LinkedList phần tử sẽ thêm vào cuối hàng đợi.
		// Trả về true nếu thêm thành công
		// Ném ra ngoại lệ nếu hàng đợi không còn chỗ.
		names.add("G");
		names.add("B");

		while (true) {
			// Lấy ra và loại bỏ phần tử đầu tiên ra khỏi hàng đợi.
			// Trả về null nếu không còn phần tử nào trong hàng đợi.
			String name = names.poll();
			if (name == null) {
				break;
			}
			System.out.println("Name=" + name);
		}

	}
}
