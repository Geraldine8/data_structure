public class Queue <T> implements Iterable<T>{

    private java.util.LinkedList <T> list = new java.util.LinkedList<T>();

    public Queue(){} //empty queue

    public Queue(T firstElement){
      list.offer(firstElement);
    }

    //Return the sie of the Queue
    public int size(){
        return  list.size();
    }

    //Returns whether or not the queue is empty

    public boolean isEmpty(){
        return size() == 0;
    }

    //Peek the element at the front of the queue
    //The method thrwos an error is the queue is empty

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return list.peekFirst();
    }

    //Poll an element from the front of the queue
    //The method throws an error is empty

    public T poll(){
        if(isEmpty()) throw  new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    //Add an element to the back of the queue

    public void offer(T elem){
        list.addLast(elem);
    }

    //Return an iterator to allow the user to transverse
    //through the elements found inside the queue

    public java.util.Iterator<T> iterator(){
        return list.iterator();
    }




}


