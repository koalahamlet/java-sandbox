package mikecandco.de;

import com.sun.org.apache.bcel.internal.generic.ExceptionThrower;
import com.sun.tools.javac.util.Pair;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.util.*;

/**
 * Created by mikehuff on 12/10/16.
 */
public class DayOne_NoTimeForTaxicab {


  public static void main(String[] args) {

    String input = "R4, R5, L5, L5, L3, R2, R1, R1, L5, R5, R2, L1, L3, L4, R3, L1, L1, R2, R3, R3, R1, L3, L5, R3, R1, L1, R1, R2, L1, L4, L5, R4, R2, L192, R5, L2, R53, R1, L5, R73, R5, L5, R186, L3, L2, R1, R3, L3, L3, R1, L4, L2, R3, L5, R4, R3, R1, L1, R5, R2, R1, R1, R1, R3, R2, L1, R5, R1, L5, R2, L2, L4, R3, L1, R4, L5, R4, R3, L5, L3, R4, R2, L5, L5, R2, R3, R5, R4, R2, R1, L1, L5, L2, L3, L4, L5, L4, L5, L1, R3, R4, R5, R3, L5, L4, L3, L1, L4, R2, R5, R5, R4, L2, L4, R3, R1, L2, R5, L5, R1, R1, L1, L5, L5, L2, L1, R5, R2, L4, L1, R4, R3, L3, R1, R5, L1, L4, R2, L3, R5, R3, R1, L3";
    // Read in the input, split it into the seperate instructions.
    List<String> directionList = Arrays.asList(input.split(",[ ]*")); // or Arrays.asList(str.replaceAll("\\s", "").split(","));
    String[] stockArr = new String[directionList.size()];
    String[] instructions = directionList.toArray(stockArr);


    // Keeps track of our position as x and y coordinates.
    int[] pos = new int[]{0, 0};
    // Keeps track of the x and y direction we are currently facing.
    // Positive x direction is north, positive y direction is west.
    int[] dir = new int[]{1, 0};

    // Keep track of places we have visited for part 2.
    HashSet<String> visited = new HashSet<String>();
    // We start at position (0,0), add this to the set of visited instructions.
    visited.add("(0,0)");

    // Variable for storing the solution for part 2.
    // Initialized at -1 so we know when we have already found the solution.
    int solution2 = -1;

    for (String instruction : instructions) {
      // Rotate left or right.
      dir = instruction.charAt(0) == 'L' ? new int[]{-dir[1], dir[0]} : new int[]{dir[1], -dir[0]};
      // Find the length we have to walk.
      int length = Integer.parseInt(instruction.substring(1));
      if (solution2 == -1) {
        for (int i = 1; i <= length; i++) {
          int[] nextPos = new int[]{pos[0] + i * dir[0], pos[1] + i * dir[1]};
          // String representation of the position so we can compare it to earlier visited locations.
          String nextPosString = "(" + nextPos[0] + "," + nextPos[1] + ")";
          // We visited this location before, we have found the solution to part2!
          if (visited.contains(nextPosString)) {
            System.out.print(nextPos[0]);
            System.out.print(nextPos[1]);
            solution2 = Math.abs(nextPos[0]) + Math.abs(nextPos[1]);
            break;
          }
          visited.add(nextPosString);
        }
      }
      // Update are position with the current instruction.
      pos = new int[]{pos[0] + length * dir[0], pos[1] + length * dir[1]};
    }

    int solution1 = Math.abs(pos[0]) + Math.abs(pos[1]);
    System.out.println("part1: " + solution1);
    System.out.println("part2: " + solution2);
  }




  class Student implements Comparable<Student>{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
      super();
      this.id = id;
      this.fname = fname;
      this.cgpa = cgpa;
    }
    public int getId() {
      return id;
    }
    public String getFname() {
      return fname;
    }
    public double getCgpa() {
      return cgpa;
    }

    public int compareTo(Student o) {
      if (cgpa == o.getCgpa()) {
        if (fname.equals(o.getFname())) {
          // sort by studend id.
          return id > o.getId() ? 1 : -1;
        } else {
          // sort by name
          return String.CASE_INSENSITIVE_ORDER.compare(fname, o.getFname());
        }
      } else {
        // sort by cgpa
        return cgpa > o.getCgpa() ? 1 : -1;
      }
    }
  }

  //Complete the code
  public class Solution
  {
    public  void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int testCases = Integer.parseInt(in.nextLine());

      List<Student> studentList = new ArrayList<Student>();
      while(testCases>0) {
        int id = in.nextInt();
        String fname = in.next();
        double cgpa = in.nextDouble();
        Student st = new Student(id, fname, cgpa);
        studentList.add(st);
        testCases--;
      }


      Collections.sort(studentList);

      for(Student st: studentList) {
        System.out.println(st.getFname());
      }
    }
  }


}
