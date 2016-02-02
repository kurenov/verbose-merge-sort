import java.util.Arrays;

/**
 *
 * verbose Merge Sort implementation written on Java
 * 
 * @author Olzhas Kurenov
 */
public class MergeSort {

  public static void main(String[] args) {
    int[] input = {8, 5, 3, 2, 1, 6, 12, 16, 9, 10, -5, 6};
    
    int[] output = mergeSort(input);

    System.out.println("Output Sorted Array");
    for (int i = 0; i < output.length; i++) {
      System.out.print(output[i] + " ");
    }
  }
  
  //recursive function
  public static int[] mergeSort(int[] a) {
    System.out.println("Sorting (" + a.length + ")");
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
    
    //Base Case
    if (a.length <= 1) {
      return a;
    }
    
    //splitting array into two & call mergerSort recursively
    int middle = a.length / 2;
    System.out.println("Splitting array at position: " + middle);
    int[] left = mergeSort(Arrays.copyOf(a, middle));
    int[] right = mergeSort(Arrays.copyOfRange(a, middle, a.length));

    return merge(left, right);
  }
  
  //merges two sorted array into one sorted array
  public static int[] merge(int[] left, int[] right) {
    int[] merged = new int[left.length + right.length];
    
    System.out.println("Merging two sub arrays");
    int i = 0, j = 0;
    for (int k = 0; k < merged.length; k++) {
      if (j >= right.length || (i < left.length && left[i] < right[j])) {
        merged[k] = left[i];
        i++;
        System.out.print(" " + merged[k]);
      } else {
        merged[k] = right[j];
        j++;
        System.out.print(" " + merged[k]);
      }
    }
    System.out.println();
    
    return merged;
  }

}
