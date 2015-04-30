public class PriorityList extends LinkedList{
    
    public boolean exists(Integer x){
        Node current = head;
        while(current.getNext() != null){
            if(current.getNext().getData() == x){
                Node temp = current.getNext();
                current.setNext(current.getNext().getNext());
                temp.setNext(head.getNext());
                head.setNext(temp);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
}
