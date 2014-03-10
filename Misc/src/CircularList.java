import com.manuel_iglesias.util.SetGenerator;


public class CircularList {

	public static void main(String[] args) {
		
		int maxSize = 25;
		
		SetGenerator gen = new SetGenerator();

		int listSize = gen.random(1, maxSize);
		
		Node<Integer> list = createList(listSize);
		
		System.out.println(list);
		
		int inflection = Integer.valueOf(gen.random(0, listSize));
		
		System.out.println(inflection);
		
		list = removeNode(list, inflection);
		
		System.out.println(list);
	}

	private static Node<Integer> createList(int n) {

		Node<Integer> last = null;
		Node<Integer> curr = null;
		Node<Integer> prev = null;
		
		for (int i = n; i > 0; i--) {
			
			curr = new Node<>();
			curr.value = i;
			curr.next = prev;
			
			if(i == n) {
				last = curr;
			}
			
			prev = curr;
		}
		
		if(last != null) {
			last.next = curr;
		}
		
		return curr;
	}

	/**
	 * Removes a node from a circular linked list
	 * 
	 * @param head Head Node
	 * @param value Value to remove
	 * @return Removed Node
	 */
	private static <T> Node<T> removeNode(Node<T> head, T value) {
		
		if(head == null || value == null) {
			return null;
		}
		
		Node<T> curr = head;
		while(true) {
			if(value.equals(curr.next.value)) {
				if(curr.next == head) {
					head = head.next;
				}
				
				if(curr.next == curr) {
					return null;
				}
				
				curr.next = curr.next.next;
				
				break;
			}
			
			curr = curr.next;
			
			if(curr == head) {
				break;
			}
		}
		
		return head;
	}

	private static class Node<T> {
		public T value;
		public Node<T> next;
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			Node<T> curr = this;
			while(true) {
				sb.append(curr.value);
				
				sb.append(" -> ");
				
				if(curr.next == this) {
					sb.append(this.value);
					break;
				}
				
				curr = curr.next;
			}
			
			return sb.toString();
		}
	}

}
