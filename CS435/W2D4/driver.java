package W3D4;

import java.util.*;

public class Driver {
    static int[][] graph = {
            { 0, 1, 1, 0, 0, 1, 0, 0, 0 }, // A
            { 1, 0, 0, 0, 0, 1, 0, 0, 0 }, // B
            { 1, 0, 0, 0, 0, 1, 1, 0, 0 }, // C
            { 0, 0, 0, 0, 1, 0, 0, 0, 1 }, // D
            { 0, 0, 0, 1, 0, 0, 0, 0, 1 }, // E
            { 1, 1, 1, 0, 0, 0, 0, 1, 0 }, // F
            { 0, 0, 1, 0, 0, 0, 0, 1, 0 }, // G
            { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, // H
            { 0, 0, 0, 1, 1, 0, 0, 0, 0 }  // I
    };

    void main () {
        System.out.println("Components using DFS:");
        System.out.println(DFS(graph));

        System.out.println("Components using BFS:");
        System.out.println(BFS(graph));
    }

    static int DFSCheckAdjacent(int[][] arr, boolean[] visited, int v) {
        for (int k = 0; k < arr[v].length; k++) {
            if (arr[v][k] == 1 && !visited[k]) {
                return k;
            }
        }
        return -1;
    }

    static int DFS(int[][] arr) {
        int components = 0;
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            components++;

            visited[i] = true;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);

            while (!stack.isEmpty()) {
                int v = stack.peek();
                int adjacent = DFSCheckAdjacent(arr, visited, v);
                if (adjacent != -1) {
                    visited[adjacent] = true;
                    stack.push(adjacent);
                } else {
                    stack.pop();
                }
            }

        }
        return components;
    }


    static int BFS(int[][] arr) {
        int components = 0;
        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            components++;
            visited[i] = true;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int k = 0; k < arr[v].length; k++) {
                    if (arr[v][k] == 1 && !visited[k]) {
                        visited[k] = true;
                        queue.add(k);
                    }
                }
            }
        }
        return components;
    }
}

