public class MySimpleLinkedList <T>{
    private Node<T> first;
    private int size;

    public MySimpleLinkedList(){
        this.first = null;
        this.size = 0;
    }

    /**
     * EJERCICIO 1
     */
    public void InsertFront(T info){
        Node<T> nuevo = new Node<>(info, null);
        nuevo.setNext(this.first);
        this.first=nuevo;
        this.size++;
    }

    public T extractFront(){
        if(!this.isEmpty()){
            Node<T> actual = this.first;
            first= this.first.getNext();
            size--;
            return (T) actual;
        }
        return null;
    }

    public boolean isEmpty(){
        return this.first == null;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public String toString() {
        String listText= "";
        Node<T> temp= this.first;
        while (temp != null){
            listText=listText + temp.getInfo().toString();
            temp=temp.getNext();
        }
        return listText;
    }
}
