
// test interface for the hashtable implementation class
public class TestInterface
{
    public void testFunction()
    {
        MyHashTable<String, Integer> test = new MyHashTable<String, Integer>();
        int index1 = test.add("Apple", 122);
        test.add("Apple", 123);
        int index2 = test.add("MSFT", 225);
        test.add("MSFT", 230);
        test.add("MSFT", 245);
        int index3 = test.add("NOC", 325);

        //MyHashLinkedList<String,Integer> ll=new MyHashLinkedList<>();
        //ll=test.tableRow.get(0);
        //ll.print_list();
        //test.tableRow.get(index1).print_list();
        //test.tableRow.get(index2).print_list();
        //test.tableRow.get(index3).print_list();
        //int size1=test.tableRow.get(index1).get_size();
        //int size2=test.tableRow.get(index2).get_size();
        //System.out.println("size1= "+size1+" size 2 "+size2);

        //System.out.println(test.get("Apple"));
        //System.out.println(test.get("MSFT"));
        //System.out.println(test.get("NOC"));
        //System.out.println(test.get("TSLA"));

        //test.remove("Apple");
        //test.remove("TSLA");
        //System.out.println(test.get("Apple"));

        //force the load factor to exceed the initial capacity
        test.add("a1",1);
        test.add("a2",1);
        test.add("a3",1);
        test.add("a4",1);
        test.add("a5",1);
        test.add("a6",1);
        test.add("a7",1);
        test.add("a8",1);
        test.add("a9",1);
        System.out.println(test.get("MSFT"));
        System.out.println("Size: "+test.getSize());
        System.out.println("capacity: "+test.capacity);
        //System.out.println(test.get("a8").hashCode());
        //System.out.println(test.get("a9"));
        test.printAllElements();

    }
}
