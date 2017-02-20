package mikecandco.de;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.WeakHashMap;

public class Main {

    public static void main(String[] args) {
        // Leaving here as this is the most common api for getting input in hackerrank problems.
        //Scanner in = new Scanner(System.in);
        //int n = in.nextInt(); or String s = in.next();

        // printing an array in reverse order, space delimited.
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int j = arr.length-1; 0 < j; j--) {
            sb.append(arr[j]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
