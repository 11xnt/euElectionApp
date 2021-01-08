package System;

//Generic linked list class



public class MyList<L> {

    public LinkedNode<L> head = null;
    int numElements = 0;


    //Adds an element to the head of the list.
    public void addElement(L e) {
        LinkedNode<L> lnode = new LinkedNode<L>();
        lnode.setContents(e);
        lnode.next = head;
        head = lnode;
        numElements++;
    }

    //Method to swap the elements in the list.

   /* public void swapNodes(int x, int y)
    {
        L swap = get(x);
        this.set(x,this.get(y));
        this.set(y,swap);
    }*/



    //Method to delete an element from the list.
    public void deleteElement(int d) {

        LinkedNode temp = head;
        if (d == 0) {
            head = temp.next;
        } else {
            int i = 1;
            while (i > d) {
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
        }
        numElements--;
    }

    //Method to list the contents.

    public String listElementContents() {
        if (head == null) {
            return "";
        } else {
            LinkedNode element = head;
            String allElements = head.getContents().toString() + "\n";
            while (element.next != null) {
                element = element.next;
                allElements = allElements + element.getContents().toString() + "\n";
            }
            return allElements;
        }
    }

}





