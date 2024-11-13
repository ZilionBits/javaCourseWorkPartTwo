import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write testcode here

        int[] values = {6, 5, 8, 7, 11};

        System.out.println("smallest: " + smallest(values));
        System.out.println("Index of smallest: " + indexOfTheSmallest(values));

        int[] values2 = {-1, 6, 9, 8, 12};
        System.out.println("Smallest index from index: " + indexOfTheSmallestStartingFrom(values2, 1));
        System.out.println("Smallest index from index: " + indexOfTheSmallestStartingFrom(values2, 2));
        System.out.println("Smallest index from index: " + indexOfTheSmallestStartingFrom(values2, 4));

        int[] values3 = {3, 2, 5, 4, 8};
        System.out.println(Arrays.toString(values3));

        swap(values3, 1, 0);
        System.out.println(Arrays.toString(values3));

        swap(values3, 0, 3);
        System.out.println(Arrays.toString(values3));

        int[] values4 = {8, 3, 7, 9, 1, 2, 4};
        sort(values4);

    }

    public static int smallest(int[] array){
        int smallest = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; i++){
            if(array[i] < smallest){
                smallest = array[i];
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallest(int[] array){

        int indexOfNumber;
        int smallestNumber = smallest(array);


        for(indexOfNumber = 0; indexOfNumber < array.length; indexOfNumber++){
            if(smallestNumber == array[indexOfNumber]){
                return indexOfNumber;
            }

        }
        return -1;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int index){

        int indexOfNumber = 0;
        int number = Integer.MAX_VALUE;

        for(int i = index; i < array.length; i++){
            if(array[i] < number){
                number = array[i];
                indexOfNumber = i;
            }
        }

        return indexOfNumber;
    }

    public static void swap(int[] array, int index1, int index2){

        int tempIndex1 = array[index1];

        array[index1] = array[index2];
        array[index2] = tempIndex1;

    }

    public static void sort(int[] array){

        int smallestNumberIndex;

        for(int i = 0; i < array.length; i++){

            System.out.println(Arrays.toString(array));

            smallestNumberIndex = indexOfTheSmallestStartingFrom(array, i);

            swap(array, i , smallestNumberIndex);

        }

    }

}
