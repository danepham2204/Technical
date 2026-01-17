
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {
  // idea: use a list to store stone, sort the list to keep the most 2 elements
  // greatest.@interface
  // complexity: O(n2logn) + O(n) -> O(n2logn)
  // space: O(n)

  public int lastStoneWeight2(int[] stones) {
    List<Integer> weightList = new ArrayList<>();
    for (int s : stones) {
      weightList.add(s);
    }

    while (weightList.size() > 1) {
      Collections.sort(weightList);
      int firstEle = weightList.remove(weightList.size() - 1);
      int secondEle = weightList.remove(weightList.size() - 1);

      // if equal just continue
      if (firstEle != secondEle) {
        weightList.add(Math.abs(firstEle - secondEle));
      }
    }

    return weightList.size() == 0 ? 0 : weightList.get(0);
  }

  // the optimal one is to use a heap to store the stones, then pop the most 2
  // elements and calculate the difference, then add the difference back to the
  // heap.
  // complexity: O(nlogn) + O(n) -> O(nlogn)
  // heapify array cost O(n), offer() and poll() cost O(logn) and loop n times
  // space O(n)
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int stone : stones) {
      pq.offer(stone);
      pq.
    }

    while (pq.size() > 1) {
      int firstEle = pq.poll();
      int secondEle = pq.poll();

      if (firstEle != secondEle) {
        pq.offer(Math.abs(firstEle - secondEle));
      }
    }

    return pq.isEmpty() ? 0 : pq.poll();
  }

  public static void main(String[] args) {
    LastStoneWeight lastStoneWeight = new LastStoneWeight();
    int[] stones = { 2, 7, 4, 1, 8, 1 };
    int result = lastStoneWeight.lastStoneWeight(stones);
    System.out.println(result); // output: 1
  }

}
