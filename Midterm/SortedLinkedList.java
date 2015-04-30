public class SortedLinkedList extends LinkedList{
    public void push(Integer data){
        Node temp = new Node(data);
    	Node current = head;
    	
    	while(current.getNext() != null){
            if(temp.getData() > current.getNext().getData()){
                temp.setNext(current.getNext());
                current.setNext(temp);
                length++;
                return;
            }
            current = current.getNext();
    	}
    	current.setNext(temp);
    	length++;
    }
}
