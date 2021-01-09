package System;

public class HashTable <E> {

    private MyList<E>[] hashTable; //aray o
    int size;

    //HashTable Constructor

    public HashTable(int size) {
        hashTable = new MyList[size];
        for(int i=0;i<hashTable.length;i++)
            hashTable[i]=new MyList<E>();
    }
    //This is what i managed to find, to add all ASCII values of the name
    // needs more research to figure out how to work with it.
    public int hashFunctionName(String fullName){
        int num=0;
        int hashIndex;
        for(int i=0;i<fullName.length();i++){
            num+=fullName.charAt(i);}
        System.out.println("HASH: " + num%hashTable.length);
        hashIndex = num%hashTable.length;
        insert(hashIndex);
        return hashIndex;
    }

    public void insert(int hashIndex) {
        //find hashCode -> place in array
        //place in array -> points to that object



    }




    public MyList<E>[] getHashTable() {
        return hashTable;
    }

    public void setHashTable(MyList<E>[] hashTable) {
        this.hashTable = hashTable;
    }
}
