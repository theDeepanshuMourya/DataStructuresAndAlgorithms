/* Note: Using 0-based indexing */

package DataStructuresAndAlgorithms.src.lists.SinglyLinkedList;

public class Main {
	static class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }

    static class LinkedList{
        private Node head;
        private int size;

        // Method to add at front of LinkedList
        public void add(int val){
            Node node = new Node(val);
            node.next = head;
            head = node;
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
                Node node = new Node(val);
                node.next = head;
                head = node;
                size++;
            }else{
                Node curr = head;

                for(int i = 0; i < index - 1; i++){
                    curr = curr.next;
                }

                Node next = curr.next;
                Node node = new Node(val);
                node.next = next;
                curr.next = node;
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
        public Node remove(){
            if(isEmpty()) {
                return null;
            }
            
            Node removedNode = head;
            head = head.next;
            size--;
            removedNode.next = null;
            return removedNode;
        }

        // Method to print LinkedList
        public void print(){
            Node curr = head;

            while(curr.next != null){
                System.out.print(curr.val + " -> ");
                curr = curr.next;
            }

            System.out.print(curr.val);

            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        System.out.println(list.isEmpty());

        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);

        list.print();

        list.addAtIndex(3, 2);
        list.addAtIndex(6, 5);
        list.addAtIndex(7, 0);

        System.out.println(list.getSize());

        list.print();

        list.remove();
        list.print();
    }
}
