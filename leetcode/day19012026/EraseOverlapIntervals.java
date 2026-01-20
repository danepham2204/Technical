
import java.util.Arrays;

public class EraseOverlapIntervals {
  public int eraseOverlapIntervals(int[][] intvals) {
    if (intvals.length == 0) {
      return 0;
    }
    int count = 0;
    Arrays.sort(intervals, (a, b) -> {
      if (a[0] < b[0]) {
        return true;
      } else if (a[0] == b[0]) {
        return a[1] < b[1];
      }
      return false;
    });
  }
}
