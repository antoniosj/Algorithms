package com.antoniosj.algsprinceton;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphAlgs {

    //vertex list (V)
    private final int vertices;
    private LinkedList<Integer> adjListArray[];

    public GraphAlgs(int vertices) {
        this.vertices = vertices;
        adjListArray = new LinkedList[vertices];

        for (int v = 0; v < vertices; v++) {
            adjListArray[v] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjListArray[src].addFirst(dest);
        adjListArray[dest].addFirst(src);
    }

    public void dfs(int v) {
        //marca todas como não visited (false by default no java)
        boolean visited[] = new boolean[vertices];

        //recusivo
        dfsUtil(v, visited);
    }

    public void dfsUtil(int v, boolean visited[]){

        //marca a posição atual como visitada e printa
        visited[v] = true;
        System.out.println(v + " ");

        Iterator i = adjListArray[v].listIterator();
        while (i.hasNext()) {
            int n = (int) i.next();
            if (!visited[n]){
                dfsUtil(n, visited);
            }
        }
    }

    void bfs(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[vertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adjListArray[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
