package programmers.level1.gymClothes;

public class DoubleLinkedList {

	Node head, tail = null;  
	
	//reserve, lost
	class Node {  
        boolean reserve;
        boolean lost;
        boolean hasClothes;
        Node previous;  
        Node next;  
   
        public Node(boolean reserve, boolean lost) {  
            this.reserve = reserve;  
            this.lost = lost;  
        }  
    }  
	   //add a node to the list  
    public void addNode(boolean reserve, boolean lost) {  
        //Create a new node  
        Node newNode = new Node(reserve, lost);  
   
        //if list is empty, head and tail points to newNode  
        if(head == null) {  
            head = tail = newNode;  
            //head's previous will be null  
            head.previous = null;  
            //tail's next will be null  
            tail.next = null;  
        }  
        else {  
            //add newNode to the end of list. tail->next set to newNode  
            tail.next = newNode;  
            //newNode->previous set to tail  
            newNode.previous = tail;  
            //newNode becomes new tail  
            tail = newNode;  
            //tail's next point to null  
            tail.next = null;  
        }  
    }  
    
    public void printNodes() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("Doubly linked list is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Print each node and then go to next.  
            System.out.print("reserved : " + current.reserve + ", lost : " + current.lost);  
            current = current.next;  
        }  
    } 
    
	public DoubleLinkedList() {
		// TODO Auto-generated constructor stub
	}

}
