package mikecandco.de;

import java.util.*;

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
        return fname.compareTo(o.getFname());
      }
    } else {
      // sort by cgpa
      return cgpa > o.getCgpa() ? 1 : -1;
    }
  }
}

//Complete the code
class Solution
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

  private boolean isAnagram(String a, String b) {

    // Complete the function by writing your code here
    a = a.toLowerCase();
    char[] string1 = a.toCharArray();
    char[] string2 = b.toCharArray();

    if(a.length()== b.length()) {
      int p1 = 0;
      int p2 = 0;
      for(int i=0;i<string1.length;i++){
        int ascii = ((int) string1[i])+1;
        System.out.println(String.valueOf("Char: " + string1[i] + " ascii value of: " + ascii));
        p1 = p1*ascii;
        ascii = ((int) string2[i])+1;
        p2 = p2*ascii;
      }

      return p1 == p2;

    }

    return false;
  }

}

