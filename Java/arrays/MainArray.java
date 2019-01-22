package arrays;

import java.util.ArrayList;
import java.util.List;

public class MainArray {

  public static void main(String[] args) {
     int[] nums = new int[5];

     //O(1)
     int n = nums[3];

     //O(N) Linear search
     for (int i = 0; i < nums.length; i++) {
        System.out.println("the number is: " + nums[i]);
     }

     //arraylist is not synchronized (thread-safe) which means: Don't control the quantity of threads at the same time.
     //thread safe allows only one thread at time.
     List<String> names = new ArrayList<>();

     names.add("name1");
     names.add("name2");
     names.add("name3");

     names.remove(0);

     System.out.println(names.get(0));


  }
}
