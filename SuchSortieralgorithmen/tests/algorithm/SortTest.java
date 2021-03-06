package algorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest
{
    private int[] list;
    private int[] unsortedList = {15, 7, 3, 4, 8, 10, 27, 3, 12, 9};
    private int[] sortedList = {3, 3, 4, 7, 8, 9, 10, 12, 15, 27};

    @BeforeEach
    void setUp()
    {
        list = new int[10];
        for (int i = 0; i <= 9; i++)
        {
            list[i]= i + 1;
        }
    }

    @Test
    void bubbleSort()
    {
        int[] myList1 = unsortedList.clone();
        Sort.bubbleSort(myList1,8,9);
        assertTrue(myList1[8]==9);
        assertTrue(myList1[9]==12);

        int[] myList2 = unsortedList.clone();
        Sort.bubbleSort(myList2,0,9);
        assertArrayEquals(myList2, sortedList);

        int[] myList3 = unsortedList.clone();
        int[] mySortedList3 = {15, 7, 3, 3, 4, 8, 10, 27, 12, 9};
        Sort.bubbleSort(myList3, 3, 7);
        assertArrayEquals(myList3, mySortedList3);
        assertThrows(IllegalArgumentException.class, ()-> Sort.bubbleSort(unsortedList, -1, 9));
        assertThrows(IllegalArgumentException.class, ()-> Sort.bubbleSort(unsortedList, 1, 10));

        int[] myList4 = unsortedList.clone();
        Sort.bubbleSort(myList4);
        assertArrayEquals(myList4, sortedList);
    }

    @Test
    void bubbleUp()
    {
        assertTrue(unsortedList[9]==9);

        int[] myList1 = unsortedList.clone(); //{15, 7, 3, 4, 8, 10, 27, 3, 12, 9}
        int[] mySortedList1 = {15, 7, 3, 4, 8 ,10, 3, 27, 12, 9};
        Sort.bubbleUp(myList1,2,7);
        assertArrayEquals(myList1, mySortedList1);

        int[] myList2 = unsortedList.clone(); //{15, 7, 3, 4, 8, 10, 27, 3, 12, 9}
        int[] mySortedList2 = {7, 3, 4, 8, 10, 15, 3, 12, 9, 27};
        Sort.bubbleUp(myList2,0,9);
        assertArrayEquals(myList2, mySortedList2);

        assertThrows(IllegalArgumentException.class,()->Sort.bubbleUp(unsortedList,-2,8));
        assertThrows(IllegalArgumentException.class,()->Sort.bubbleUp(unsortedList,2,10));
    }

    @Test
    void quickSort()
    {
        int[] myList1 = {2,6,27,15,34,62,19,25};
        int[] mySortedList1 = {2,6,15,19,25,27,34,62};
        Sort.quickSort(myList1);
        assertArrayEquals(mySortedList1, myList1);

        int[] myList2 = {2,6,27,15,34,62,19,25};
        int[] mySortedList2 = {2,6,15,19,27,34,62,25};
        Sort.quickSort(myList2,2,6);
        assertArrayEquals(mySortedList2, myList2);

        assertThrows(IllegalArgumentException.class, ()-> Sort.quickSort(list,-1,7));
        assertThrows(IllegalArgumentException.class, ()-> Sort.quickSort(list,1,10));
    }


    @Test
    void divide()
    {
        int[] myList1 = {2,6,27,15,34,62,19,25};
        int[] mySortedList1 = {2,6,19,15,25,62,27,34};
        assertTrue(Sort.divide(myList1,0,myList1.length-1)==4);
        assertArrayEquals(mySortedList1,myList1);
    }

    @Test
    void swap()
    {
        Sort.swap(list,3,8);
        assertTrue(list[3]==9);
        assertTrue(list[8]==4);

        Sort.swap(list, 8, 3);
        assertTrue(list[8]==9);
        assertTrue(list[3]==4);

        assertThrows(IllegalArgumentException.class, () ->Sort.swap(list, -1, 6));
        assertThrows(IllegalArgumentException.class, () ->Sort.swap(list, 10, 6));
        assertThrows(IllegalArgumentException.class, () ->Sort.swap(list, 4, -6));
        assertThrows(IllegalArgumentException.class, () ->Sort.swap(list, 4, 10));
    }

    @Test
    void toStringTest()
    {
        System.out.println(Sort.toString(list));
        assertThrows(IllegalArgumentException.class, () ->Sort.toString(list, -1, 5));
        assertThrows(IllegalArgumentException.class, () ->Sort.toString(list, 1, 10));
        assertThrows(IllegalArgumentException.class, () ->Sort.toString(list, 6, 3));
        System.out.println(Sort.toString(list, 2, 7));
    }

}