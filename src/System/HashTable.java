package System;

public class HashTable <E> {

    MyList<E>[] hashTable;

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
        for(int i=0;i<fullName.length();i++){
            num+=fullName.charAt(i);}
        System.out.println("HASH: " + num%hashTable.length);
        return num%hashTable.length;
    }




}
