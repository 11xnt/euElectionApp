package System;

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


