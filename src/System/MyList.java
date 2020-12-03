package System;

/**
 * Generic linked list class
 * @param <L>
 */

public class MyList<L> {

    public LinkedNode<L> head = null;
    int numElements = 0;

    /**
     * Method to add an element to the node
     *
     * @param e
     */

    public void addElement(L e) {
        LinkedNode<L> lnode = new LinkedNode<L>();
        lnode.setContents(e);
        lnode.next = head;
        head = lnode;
        numElements++;
    }

    /**
     * Method to delete a node.
     *
     * @param d
     */
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

    /**
     * Method to lis all of the nodes.
     *
     * @return allElements
     */
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





