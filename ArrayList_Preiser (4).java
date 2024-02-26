import java.util.*;

public class ArrayList_Preiser<E> extends AbstractList<E> implements List<E>
  {
    //instance variables
    private E[] myArr;
    private int size; 
    
//constructor    
    public ArrayList_Preiser()
    {
     myArr = (E[])(new Object[10]); 
    }

    public ArrayList_Preiser(Collection<? extends E>myCollection)
    {
      myArr = (E[])(new Object[10]);
      addAll(myCollection);
      size = myCollection.size();
    }

    public ArrayList_Preiser(int initialCapacity)
    {
      myArr = (E[])(new Object[initialCapacity]);
    }

    public int size ()  //returns the size of myArr
    {
      return size;
    }

    public E get(int index) //returns a value at index 
    {
      return myArr[index]; 
    }

    public void ensureCapacity(int minCapacity)//increases the size of the array 
    {
      
      E[] myArr1 = (E[])(new Object[minCapacity]);
      if(myArr.length < minCapacity)
      for(int x = 0; x < myArr.length; x++)
          {
        myArr1[x] = myArr[x];
          }
      myArr = myArr1;
    }
    public boolean add(E e){
    ensureCapacity(size+1);
    myArr[size++] = e;
    return true;
  }

    public void add(int index, E element)
    {
      if(index < 0 || index > size)
        System.out.println("Index out of bounds.");

      for(int i = size; i > index; i--)
        {
          myArr[i] = myArr[i-1];
        }

      myArr[index] = element;
      size++;
    }
    public void clear()
    {
      myArr = (E[])(new Object[10]);
      this.trimToSize();
      size = 0;
    }

    public int indexOf (Object o)
    {
      for (int x = 0; x<myArr.length; x++)
        {
          if(myArr[x].equals(o))
            return x;
        }
      return -1;
    }
    
    public boolean contains (Object o)
    {
      for (int x = 0; x<myArr.length; x++)
        {
        if(myArr[x].equals(o))
          return true;
        }
      return false;
    }

    public E set (int index, E element)
    {
      E x = myArr[index];
      myArr[index] = element;
      return x;
    }

    public int lastIndexOf (Object o)
    {
      int x = -1;
      for(int i =0; i < myArr.length; i++)
        {
          if (myArr[i]==(null))
          {
            continue;
          }
          if(myArr[i].equals(o))
            x=i;
        }
      return x;
    }
    public Object[] toArray()
    {
      
      return myArr;
    }

    public void trimToSize()
    {
      if(size < myArr.length)
      {
      E[] myArr0 = (E[])new Object[size];
    for(int i =0; i< size; i++)
      myArr0[i] = myArr[i];
        myArr = myArr0;
      }
    }
    public boolean remove(Object o)
    {
      for(int i = 0; i < size; i++){
        if(myArr[i].equals(o)){
          for(int k = i; k < size - 1; k++){
            myArr[k] = myArr[k+1];
          }
          size--;
          return true;
        }
      }
      return false;
    }
    
    protected void removeRange(int i, int j)
    {
      int b = j - i;

      for(int x = i; x < size - b; x++)
        {
          myArr[x] = myArr[x+b];
        }

      for(int y = size -b; y < size; y++)
        {
          myArr[y] = null;
        }
      size-=b;
    }
    
  public List <E> subList (int i, int j)
    {
    ArrayList_Preiser<E> myArr5 = new ArrayList_Preiser<E>();

      for(int x = i; x< j; x++)
        {
          myArr5.add(myArr[x]);
        }
      return myArr5;
    
    }

    public E remove(int  index)
    {
      E elementRemoved = myArr[index];
      E[] arr5 = (E[])new Object[size-1];
      for(int i = 0; i< index; i++)
        {
          arr5[i] = myArr[i];
        }
      for(int i = index+1; i< size; i++)
        {
          arr5[i-1] = myArr[i];
        }
      size--;
      myArr = arr5;
      return elementRemoved;
    }
  }