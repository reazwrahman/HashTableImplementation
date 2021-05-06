
// a generic class with key and value inputs
public class MyHashNode <K,V>
{
    public K key;
    public V value;

    MyHashNode <K,V> next;

    public MyHashNode(K input_key,V input_value)
    {
        this.key=input_key;
        this.value=input_value;
        this.next=null;
    }

}

