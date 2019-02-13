/**
 * 
 * 
 * @author Alexander Lu
 * I pledge my Honor that I have abided by the Stevens Honor System
 */


import java.util.ArrayList;

public class IDLList<E extends Comparable<E>> {
    
    /**
     * 
     * 
     *
     * Inner class Node containing the data fields data, next, and prev. 
     */
    
    private class Node<E>
    {
        private E data;
        private Node<E> next = null;
        private Node<E> prev = null;
        
        /**
         * Default constructor for Node
         * @param d, d represents the data that you are putting inside the node
         */
        private Node(E d)
        {
            data = d;
            prev = null;
            next = null;
        }
        
        /**
         * Overloaded constructor for Node
         * @param d, represents the data that you are putting inside the node
         * @param p, represents the Node previous to the one you are making
         * @param n, represents the Node following the one you are making
         */
        
        private Node(E d, Node<E> p, Node<E> n)
        {
            data = d;
            prev = p;
            next = n;
        }
    }
    
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    private ArrayList<Node<E>> indices;
    
    
    /**
     * Constructor for IDLList, sets the first and last element to null by default and creates an empty ArrayList
     */
    public IDLList()
    {
        head = null;
        tail = null;
        indices = new ArrayList<Node<E>>();
    }
    
    /**
     * Adds a Node at a specified Index
     * @param index, the position of where you want the Node
     * @param elem, the data you are placing in the Node
     * @return returns a boolean 
     */
    public boolean add(int index, E elem)
    {
        if(index==0)
        {
            this.add(elem);
            return true;
        }
        if(index==size)
        {
            this.append(elem);
            return true;
        }
        else
        {
            Node<E> node = new Node<E>(elem);
            indices.add(index, node);
            indices.get(index-1).next = node;
            node.prev = indices.get(index-1);
            indices.get(index+1).prev = node;
            node.next = indices.get(index+1);
            size++;
            return true;
        }
    }
    
    
    /**
     * Adds a node to the front of the list replacing the head
     * @param elem, the data you are placing in the Node
     * @return returns a boolean
     */
    public boolean add(E elem)
    {
        if(head==null)
        {
            Node<E> node = new Node<E>(elem);
            head = node;
            tail = node;
            indices.add(0,head);
            size++;
            return true;
        }
        else
        {
            Node<E> node = new Node<E>(elem);
            Node<E> temp = head;
            head = node;
            head.next=temp;
            temp.prev = head;
            indices.add(0,head);
            size++;
            return true;
        }
    }
    
    /**
     * Adds a node to the end of the list replacing the tail
     * @param elem, the data you are placing in the Node
     * @return returns a boolean
     */
    public boolean append(E elem)
    {
        if(tail==null)
        {
            Node<E> node = new Node<E>(elem);
            tail = node;
            head = node;
            indices.add(0,node);
            size++;
            return true;
        }
        Node<E> node = new Node<E>(elem);
        Node<E> temp = tail;
        tail = node;
        tail.prev = temp;
        temp.next = tail;
        indices.add(indices.size(),tail);
        size++;
        return true;
    }
    
    /**
     * Returns the object at position index from the head
     * @param index, the specified position 
     * @return returns the object
     */
    public E get(int index)
    {
        return indices.get(index).data;
    }
    
    /**
     * 
     * @return returns the head of the list
     */
    public E getHead()
    {
        return head.data;
    }
    
    /**
     * 
     * @return returns the tail of the list
     */
    public E getLast()
    {
        return tail.data;
    }
    
    /**
     * 
     * @return returns the size of the list
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Removes the first element of the list
     * @return returns the element that was removed
     */
    public E remove()
    {
        Node<E> temp = head.next;
        E t = head.data;
        if(size==0)
        {
            return null;
        }
        if(size==1)
        {
            indices.remove(head);
            head = null;
            tail = null;
            size--;
            return t;
        }
        else
        {
            indices.remove(head);
            head = temp;
            size--;
            return t;
        }
        
    }
    
    /**
     * Removes the last element of the list
     * @return returns the element that was removed
     */
    public E removeLast()
    {
        Node<E> temp = tail.prev;
        E t = tail.data;
        if(size==0)
        {
            return null;
        }
        if(size==1)
        {
            indices.remove(tail);
            head = null;
            tail = null;
            size--;
            return t;
        }
        else
        {
            indices.remove(tail);
            tail = temp;
            size--;
            return t;
        }
        
    }
    
    /**
     * Removes element of the list at the specified index
     * @param index, position of object you want removed
     * @return returns the object removed
     */
    public E removeAtIndex(int index)
    {
        if(size==0)
        {
            return null;
        }
        if(size==1)
        {
            E temp = head.data;
            indices.remove(head);
            head=null;
            tail=null;
            size--;
            return temp;
        }
        if(index==0)
        {
            E temp = head.data;
            Node<E> t = head.next;
            indices.remove(head);
            head = t;
            size--;
            return temp;
            
        }
        if(index==size-1)
        {
            E temp = tail.data;
            Node<E> t = tail.prev;
            indices.remove(tail);
            tail = t;
            size--;
            return temp;
            
        }
        else
        {
            E temp = indices.get(index).data;
            indices.get(index-1).next = indices.get(index+1);
            indices.get(index+1).prev = indices.get(index-1);
            size--;
            indices.remove(index);
            return temp;
        }
    }
    
    /**
     * Removes the first instance of an object in a list
     * @param elem, the element which you want to be removed
     * @return returns true if elem is in the list and false if it is not 
     */
    public boolean remove (E elem)
    {
        Node<E> c = head;
        int i = 0;
        if(head==null)
        {
            return false;
        }
        if(head.data==elem)
        {
            Node<E> temp = head.next;
            indices.remove(head);
            head = temp;
            size--;
            return true;
        }
        if(tail.data==elem)
        {
            Node<E> temp = tail.prev;
            indices.remove(tail);
            tail = temp;
            size--;
            return true;
        }
        
            while(c!=null)
            {
                
                
                if(c.data.compareTo(elem)==0)
                {
                    
                    this.removeAtIndex(i);
                    return true;
                }
                else
                {
                    c = c.next;
                    i++;
                }
            
            }
        return false;
    }
    
    /**
     * Returns the list as a string 
     */
    public String toString()
    {
        String results = "";
        for(int i=0; i<size; i++) {
               results += indices.get(i).data + " ";
         }
        return results;

    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IDLList<Integer> t = new IDLList<Integer>();
        t.add(0,1);
        t.add(0,2);
        t.add(2,3);
        t.add(3,5);
        t.add(3,6);
        System.out.println(t.toString());
        t.remove(6);
        System.out.println(t.toString());
        
    }

}