public class IDGeneratorDriver
{
    public void main()
    {
        System.out.println("---------------------------------------------------");
        System.out.println("Hashtable lab 5 {with my own implemented hash table}");
        System.out.println("---------------------------------------------------");

        IdGenerator_WithMyHashTable idGen=new IdGenerator_WithMyHashTable();

        for (int i=0; i<15;i+=3)
        {
            idGen.getNumber();
        }

        System.out.println(idGen.requestNumber(3000));
        System.out.println(idGen.requestNumber(9000));
        System.out.println(idGen.requestNumber(3000));

        System.out.println("Size: "+ idGen.IDBucket.getSize());
        idGen.IDBucket.printAllElements();
        //System.out.println(idGen.IDBucket.get(4000));
        //idGen.IDBucket.remove(3000);
    }
}
