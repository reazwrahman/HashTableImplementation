public class IdGenerator_WithMyHashTable
{

    MyHashTable <Integer, java.lang.Boolean> IDBucket;

    private int lower_bound=0;
    private int upper_bound=9999999;

    private int counter=0;

    public IdGenerator_WithMyHashTable()
    {
        IDBucket = new MyHashTable<Integer, Boolean>();
    }

    public int getNumber()
    {
        int ID;
        while (true)
        {
            if (IDBucket.containsKey(counter)==false)
            {
                IDBucket.add(counter,Boolean.TRUE);
                ID=counter;
                counter++;
                break;
            }
            else
            {
                counter++;
            }
        }

        System.out.println("An ID is assigned, your ID is "+ID);
        return ID;
    }

    public int requestNumber(int number)
    {
        int result;
        if (IDBucket.containsKey(number)==false) // if not in hashtable
        {
            IDBucket.add(number,Boolean.TRUE);
            System.out.println("Your requested ID <"+number+"> has been successfully registered in the system");
            result=1;
        }
        else
        {
            System.out.println("Sorry, The requested ID <"+number+"> has already been taken");
            result=0;
        }
        return result;
    }


}
