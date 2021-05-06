public class MyHashLinkedList<K,V>
{

    public MyHashNode<K,V> head;
    public MyHashNode<K,V> tail;

    public MyHashLinkedList()
    {
        MyHashNode<K,V> head=null;
        MyHashNode<K,V> tail=null;

    }

    public void print_list()
    {
        MyHashNode<K,V> start= head;

        while (start!=null)
        {
            String strKey=start.key.toString();
            String strValue= start.value.toString();
            System.out.println("KEY: "+strKey+" and VALUE: "+strValue);
            start=start.next;
        }
    }

    public void insert (K key, V value)
    {
        //check if the list is empty
        // if it is, create a new node and let head point to it
        if (head==null)
        {
            MyHashNode<K,V> new_node= new MyHashNode<K,V>(key,value);
            head = new_node;
        }

        else
        {
            // if it's not empty, look ahead (start.next) and keep looking
            // until a null is found, if a null is found we will insert a
            // new node, and have start.next point to it

            MyHashNode<K,V> start = head;
            while (true)
            {
                if (start.next == null)
                {
                    MyHashNode<K,V> new_node = new MyHashNode<K,V>(key,value);
                    start.next = new_node;
                    tail=new_node; // update our tail
                    break;
                }
                else
                {
                    start = start.next;
                }
            }

        }

    }

    public int get_size()
    {
        MyHashNode<K,V> start=head;
        int size=0;

        if (head==null)
        {
            size=0;
            return size;
        }
        else
        {
            while (start != null)
            {
                size+=1;
                start = start.next;
            }
        }
        return size;

    }

    public boolean remove_item(K key)
    {
        boolean removed;

        //edge case 1:
        if (head == null)
        {
            //System.out.println("The list is empty, Nothing to remove!");
            removed=false;
        }

        //edge case 2:
        // check if the item is there by using scan function
        else if (scan_list_for(key) == false)
        {
            //System.out.println("The item you are trying to remove <"+key+"> doesn't exist, Sorry");
            removed=false;
        }

        // special method to remove the head node
        else if (head.key.equals(key))
        {
            remove_head();
            //System.out.println("Entered item <"+key+"> has been removed");
            removed=true;
        }

        // method for removing all other nodes
        else
        {
            //find the item
            MyHashNode<K,V> before=head;
            MyHashNode<K,V> current=head.next;
            MyHashNode<K,V> after=current.next;

            while (true)
            {
                //if item is not there, move all 3 pointers one step ahead
                if (!current.key.equals(key))
                {
                    before=current;
                    current=after;
                    after=after.next;
                }
                // if found, have before.next point to after node and lose current node altogether
                else
                {
                    before.next=after;
                    removed=true;
                    //System.out.println("Entered item <"+key+"> has been removed");
                    break;
                }
            }
        }

        return removed;
    }


    // special method to remove the head node
    public void remove_head()
    {
        //if head node is the only element, just set head to null
        if (head.next==null)
        {
            head=null;
        }

        //otherwise
        else
        {
            head=head.next;
        }
    }


    // method for checking if a desired element exists in the list
    public boolean scan_list_for(K key)
    {
        boolean found=false;

        MyHashNode<K,V> start= head;
        while (start!=null)
        {
            if (start.key.equals(key))
            {
                found = true;
                break;
            }
            else
            {
                start=start.next;
            }
        }
        return found;
    }


    // this method will return a pointer to the address where the key is located
    public MyHashNode<K,V> find_location(K key)
    {
        MyHashNode<K,V> target_location=null;

        MyHashNode<K,V> start= head;
        while (start!=null)
        {
            if (start.key.equals(key))
            {
                target_location = start;
                break;
            }
            else
            {
                start=start.next;
            }
        }
        return target_location;
    }
}

/*
 ATTN: THE FOLLOWING TWO FUNCTIONS DON'T SEEM TO BE NECESSARY FOR A
 HASHTABLE IMPLEMENTATION. THEY WERE REFACTORED FROM A GENERAL
 LINKED LIST CLASS I WROTE BEFORE.
 */

/*public void insert_at_beginning(K key, V value)
    {
        MyHashNode<K,V> new_head= new MyHashNode<K,V>(key,value);
        MyHashNode<K,V> old_head= head;
        head=new_head;
        new_head.next=old_head;
    }

    public void insert_at_end(K key, V value)
    {
        MyHashNode<K,V> start= head;
        while (true)
        {
            if (start.next==null)
            {
                //we found the end
                MyHashNode<K,V> new_node= new MyHashNode<K,V>(key,value);
                start.next=new_node;
                tail= new_node;
                break;
            }
            else
            {
                //keep looking for the end
                start=start.next;
            }
        }
    }*/
