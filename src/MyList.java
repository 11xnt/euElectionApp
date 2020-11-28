/**
 * Generic linked list class
 * @param <L>
 */

public class MyList<L> {

    public LinkedNode <L> head = null;
    int numElements = 0;

    /**
     * Method to add an element to the node
     * @param e
     */

    public void addElement(L e){
        LinkedNode <L> lnode = new LinkedNode<>();
        lnode.setContents(e);
        lnode.next = head;
        head = lnode;
        numElements++;
    }

    /**
     * Method to delete a node.
     * @param d
     */
    public void deleteElement(int d){

        LinkedNode temp = head;
        if (d == 0){
            head = temp.next;
        }else{
            int i =1;
            while (i > d){
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
        }
        numElements --;
    }




    /**
     * Linked Node Class
     * @param <N>
     */

    class LinkedNode<N> {

        public LinkedNode<N> next=null;
        private N contents;

    //Gets the contents of the node//
        public N getContents() {
            return contents;
        }
    //Sets the contents of the node//
        public void setContents(N c) {
            contents=c;
        }
    }
}



