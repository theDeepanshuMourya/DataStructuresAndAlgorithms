/* Note: Using 0-based indexing */

package DataStructuresAndAlgorithms.src.lists.DoublyLinkedList;

public class Main {
	static class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val = val;
        }
    }

    public static class LinkedList{
        private Node head;
        private Node tail;
        private int size;

        // Method to add at the front of the LinkedList
        public void addToFront(int val){
            Node node = new Node(val);
            
            if(head == null){
                tail = node;
            }else{
                node.next = head;
                head.prev = node;
            }
            
            head = node;
            size++;
        }

        // Method to add at the end of the LinkedList
        public void addToEnd(int val){
            Node node = new Node(val);

            if(tail == null){
                head = node;
            }else{
                tail.next = node;
                node.prev = tail;
            }

            tail = node;
            size++;
        }

        // Method to get the size of the LinkedList
        public int getSize(){
            return size;
        }

        // Method to check if the list is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Method to add at a particular index
        public void addAtIndex(int val, int index){
            if(index == 0){
                addToFront(val);
            }else{
                Node curr = head;

                for(int i = 0; i < index - 1; i++){
                    curr = curr.next;
                }

                Node node = new Node(val);
                
                Node next = curr.next;
                node.next = next;
                next.prev = node;

                curr.next = node;
                node.prev = curr;
                size++;
            }
        }

        // Method to return value at current index
        public int get(int index){
            if(index > size){
                return -1;
            }else if(index == 0){
                return head.val;
            }

            Node curr = head;

            for(int i = 0; i < index - 1; i++){
                curr = curr.next;
            }

            return curr.next.val;
        }

        // Method to remove from the front of the LinkedList
        public Node removeFromFront(){
            if(isEmpty()) {
                return null;
            }
            
            Node removedNode = head;
            if(head.next == null){
                tail = null;
            }else{
                head.next.prev = null;
            }

            head = head.next;
            size--;
            removedNode.next = null;
            return removedNode;
        }

		// Method to remove from the end of the LinkedList
        public Node removeFromEnd(){
            if(isEmpty()) return null;

            Node removedNode = tail;
            if(tail.prev == null){
                head = null;
            }else{
                tail.prev.next = null;
            }

            tail = tail.prev;
            size--;
            removedNode.next = null;
            return removedNode;
        }

        // Method to print LinkedList
        public void print(){
            Node curr = head;

            while(curr.next != null){
                System.out.print(curr.val + " <-> ");
                curr = curr.next;
			}
			
			System.out.print(curr.val);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        System.out.println(list.isEmpty());

        list.addToFront(1);
        list.addToEnd(2);
        list.addToEnd(4);
        list.addToEnd(5);
        list.addToFront(0);

        list.print();

        list.addAtIndex(3, 3);

        System.out.println(list.getSize());

        list.print();

        list.removeFromEnd();
        list.removeFromFront();

        list.print();
    }
}