public class LinkedList {
	Node head = null;
	public static void main(String args[]) {
		LinkedList l = new LinkedList();
		l.insert(2);
		l.insert(5);
		l.insert(-3);
		l.push(0);
		l.insert(1);
		l.insertAfter(l.head.next.next, 100);
		l.insertLast(10);
		l.deleteKey(100);
		l.deleteKey(0);
		l.deleteKey(10);
		l.deleteKey(l.head, 3);
		l.display();
	}
	
	void insert(int x) {
		if(head == null) {
			head = new Node(x);
		}else {
			Node temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = new Node(x);
		}
	}
	
	void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"-------->");
			temp = temp.next;
		}
	}
	
	void push(int x) {
		Node created = new Node(x);
		created.next = head;
		head = created;
	}
	
	void insertAfter(Node previous, int x) {
		if(previous == null) {
			System.out.println("The previous node cannot be null");
			return;
		}
		
		Node created = new Node(x);
		created.next = previous.next;
		previous.next = created;
	}
	
	void insertLast(int x) {
		if(head == null) {
			insert(x);
			return;
		}
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		Node create = new Node(x);
		temp.next = create;
	}
	
	void deleteKey(int key) {
		if(head == null) {
			System.out.println("List is empty!!");
			return;
		}
		
		if(head.data == key) {
			head = head.next;
			return;
		}
		
		Node temp = head,prev = null;
		while(temp!= null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}
	
	void deleteKey(Node head,int pos) {
		if(pos == 1) {
			this.head = head.next;
			return;
		}
		Node current = head,prev = null;
		for(int i=1;i<pos;i++) {
			prev = current;
			current = current.next;
		}
		prev.next = current.next;
	}
}
