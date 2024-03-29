package lab10;

/**
 * A growable collection of ints based on a partially filled array.  
 * An IntList has a backing array containing the actual values, along 
 * with a variable 'size' indicating how many values are currently stored.
 * The initial capacity of the backing array is 10, and it doubles in size
 * whenever the capacity needs to be increased to add another element. 
 */
public class IntList {

   /**
    * The list of integers. It may contain more elements than are actually
    * filled.
    */
   private int[] list;
   
   /**
    * The actual number of elements.
    */
   private int size;
   
   /**
    * Create a new, empty list of integers.  We create spots for 10 numbers,
    * and we'll grow the array if these all fill up.
    */
   public IntList() {
      setList(new int[10]);
      size = 0;
   }
   
   /**
    * Get the number of items in the list.
    * @return number of items in list.
    */
   public int size() {
      return size;
   }
   
   /**
    * Get the item at position i
    *
    * @param i
    * Index of item to retrieve.
    *
    * @return
    * Item at position i
    *
    * @throws ArrayIndexOutOfBoundsException
    * If position invalid.
    */
   public int get(int i) {
      if (i >= size) {
         throw new ArrayIndexOutOfBoundsException();
      }
      return getList()[i];
   }
   
   /**
    * Add an int to the end of the list. The list is grown automatically if
    * its current capacity has been reached.
    *
    * @param newItem
    * Int to add.
    */
   public void add(int newItem) {
      if (size == getList().length) {
         grow();
      }
      getList()[size] = newItem;
      ++size;
   }
   
   /**
    * Inserts an int in the the list at the specified index. Existing elements are
    * shifted to the right. The list is grown automatically if its current 
    * capacity has been reached.
    *
    * @param index
    *   index for the new item
    * @param newItem
    *   item to be inserted into the list
    * Int to add.
    * 
    * @throws ArrayIndexOutOfBoundsException
    * if given index is greater than the current size
    */
   public void insert(int index, int newItem) {
     if (index > size) {
       throw new ArrayIndexOutOfBoundsException();
     }
     if (size == getList().length) {
       grow();
     }
     
     // shift elements to the right
     for (int i = size; i > index; i -= 1) {
       getList()[i] = getList()[i - 1];
     }
     getList()[index] = newItem;
     ++size;
   }
   
   /**
    * Double the capacity of the array. Automatically creates a new
    * array twice the size of the current and copies all existing
    * list data over.
    */
   private void grow() {
      int[] tmpList = new int[getList().length * 2];
      for (int i = 0; i < size; ++i) {
         tmpList[i] = getList()[i];
      }
      setList(tmpList);
   }
   
   /**
    * Find the maximum int in the list.
    *
    * @return
    * Maximum value in list.
    */
   public int getMaximum() {
      int max = getList()[0];
      for (int i = 1; i < size; ++i) {
         if (getList()[i] > max) {
            max = getList()[i];
         }
      }
      return max;
   }
   
   /**
    * Find the minimum int in the list.
    *
    * @return
    * Minimum value in list.
    */
   public int getMinimum() {
      int min = getList()[0];
      for (int i = 1; i < size; ++i) {
         if (getList()[i] < min) {
            min = getList()[i];
         }
      }
      return min;
   }
   
   /**
    * Get a string representation of the list of the form
    * [val0, val1, val2, ...].
    *
    * @return
    * Comma-separated string of elements.
    */
   public String toString() {
      String s = "[";
      if (size > 0) {
         s += getList()[0];
         for (int i = 1; i < size; ++i) {
            s += ", " + getList()[i];
         }
      }
      s += "]";
      return s;
   }

protected int[] getList() {
	return list;
}

protected void setList(int[] list) {
	this.list = list;
}
}