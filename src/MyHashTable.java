import java.util.ArrayList;

public class MyHashTable <K,V>
{
    int capacity=10; //initial length of the table
    ArrayList< MyHashLinkedList<K,V> > tableRow;

    public MyHashTable()
    {
        tableRow=createEmptyHashTable(capacity);
    }

    //helper method for the constructor (also to liberate the function to other internal method)
    public ArrayList< MyHashLinkedList<K,V> > createEmptyHashTable(int size)
    {
        ArrayList< MyHashLinkedList<K,V> > newRow= new ArrayList<>();

        for (int i=0; i<size; i++)
        {
            MyHashLinkedList <K ,V> temp= new MyHashLinkedList<>();
            newRow.add(temp);
        }

        return newRow;
    }

    public int getHashIndex(K key)
    {
        int hashcode= key.hashCode();
        int index=hashcode % this.capacity;
        index = index < 0 ? index*-1 : index; // if negative multiply by -1, else keep index as is

        return index;
    }


    // output will be -1 if the key value pair could not be added (due to a duplicate instance)
    public int add (K key, V value)
    {
        // quickly check check if the hashtable needs to be doubled in size first
        this.dynamicallyDouble();


        int arrayIndex = getHashIndex(key);
        MyHashLinkedList<K,V> local_linkedList=tableRow.get(arrayIndex);

        //check if the key already exists, if it doesn't go ahead and insert it in the linkedlist
        boolean exists = containsKey(key);
        if (exists)
        {
            System.out.println("Error!! This key: <"+key.toString() +"> Already exists, can't be entered again");
            return -1;
        }
        else
        {
            local_linkedList.insert(key, value);// this is a linkedlist
            return arrayIndex;
        }
    }

    // will return null if key couldn't be found
    public V get(K key)
    {
        int arrayIndex=getHashIndex(key);
        MyHashLinkedList<K,V> local_linkedList=tableRow.get(arrayIndex);
        if (containsKey(key))
        {
            MyHashNode<K,V>location=local_linkedList.find_location(key);
            return location.value;
        }
        else
        {
            System.out.println("Error! entered key <"+key+"> doesn't exist");
            return null;
        }
    }


    public boolean remove(K key)
    {
        boolean removed;
        int arrayIndex=getHashIndex(key);
        MyHashLinkedList<K,V> local_linkedList=tableRow.get(arrayIndex);

        removed=local_linkedList.remove_item(key);
        if (removed)
        {
            System.out.println("Entered item <"+key+"> has been successfully removed");
        }
        else
        {
            System.out.println("Entered item <"+key+"> couldn't be removed because it doesn't exist");
        }
        return removed;
    }

    public boolean containsKey(K key)
    {
        boolean exists;

        int arrayIndex=getHashIndex(key);
        MyHashLinkedList<K,V> local_linkedList=tableRow.get(arrayIndex);
        //we will use the scan function from our linkedlist class
        exists=local_linkedList.scan_list_for(key);

        return exists;
    }

    public int getSize()
    {
        int count=0;
        for (int i=0;i<this.capacity;i++)
        {
            MyHashLinkedList<K,V> local_list=tableRow.get(i);

            if (local_list.head!=null) // save some time and only go in if the head is not null
            {
                count += local_list.get_size();
            }
        }

        return count;
    }

    public boolean isEmpty()
    {
        if (this.getSize()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void dynamicallyDouble()
    {
        //check the load factor against threshold (0.7)
        if ((this.getSize()/capacity) > 0.7)
        {
            System.out.println("Reached load factor, doubling the original capacity");
            ArrayList< MyHashLinkedList<K,V> > oldRow=tableRow; // hold the current table in a temp variable
            this.capacity*=2;
            tableRow=createEmptyHashTable(capacity);//make tableRow twice the initial size

            //for each linked list of the old tableRow
            for (int i=0; i<oldRow.size();i++)
            {
                MyHashLinkedList <K ,V> local_links =oldRow.get(i);
                MyHashNode <K,V> local_node= local_links.head;

                //traverse through all the nodes of a linkedList
                while (local_node!=null)
                {
                    //System.out.println("Moving key: "+local_node.key);
                    this.add(local_node.key,local_node.value);
                    local_node=local_node.next;

                }

            }
        }
    }

    public void printAllElements()
    {
        System.out.println("Printing all Hashtable Elements below: ");
        for (int i=0; i<tableRow.size();i++)
        {
            MyHashLinkedList<K, V> local_links = tableRow.get(i);
            MyHashNode<K, V> local_node = local_links.head;
            System.out.println("----------------------------------------");
            System.out.print("| "+i+" |");
            //traverse through all the nodes of a linkedList
            while (local_node != null)
            {
                //System.out.println("key: " + local_node.key + " value: " + local_node.value);
                System.out.print(local_node.key+"-->");
                local_node=local_node.next;
            }
            System.out.println("");
            //System.out.println("----------------------------------------");
        }

    }

}
