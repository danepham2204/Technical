package day2402026;

public class MagicalString {
  // kolakoski sequence
  public int magicalString(int n) {
    if (n <= 3) {
      return 1;
    }

    int read = 2; // 122
    int write = 3;
    boolean isSwitch1 = true;
    int count = 1;
    StringBuilder builder = new StringBuilder("122");
    while (write < n) {
      if (builder.charAt(read) == '2') {
        builder.append(isSwitch1 ? '1' : '2');
        if (isSwitch1) {
          count += 1;
        }
        if (write + 2 < n) {
          builder.append(isSwitch1 ? '1' : '2');
          if (isSwitch1) {
            count += 1;
          }
        }
      } else {
        builder.append(isSwitch1 ? '1' : '2');
        if (isSwitch1) {
          count += 1;
        }
      }

      read++;
      write = builder.length();
      isSwitch1 = !isSwitch1;
    }

    return count;
  }

  public int optimize(int n) {
    if (n <= 3) {
      return 1;
    }

    int[] arr = new int[n + 1];
    arr[0] = 1;
    arr[1] = 2;
    arr[2] = 2;

    int read = 2; // 122
    int write = 3;
    int numToPut = 1; // put 1 first
    int count = 1;

    while (write < n) {
      for (int i = 0; i < arr[read]; i++) {
        if (write < n) {
          arr[write] = numToPut;
          write++;
          count += (numToPut == 1 ? 1 : 0);
        }
      }

      numToPut = 3 - numToPut; // switch between 1 and 2
      read += 1;
    }

    return count;
  }

  public static void main(String[] args) {
    MagicalString sol = new MagicalString();
    System.out.println(sol.optimize(6));
    System.out.println(sol.optimize(4));

  }
}
