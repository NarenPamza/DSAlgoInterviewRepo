package grid;

/*Java Program to Implement Traveling Salesman Problem using Nearest neighbour Algorithm
This Java Program is to Implement Traveling Salesman Problem using Nearest neighbour Algorithm.The travelling salesman problem (TSP) or travelling salesperson problem asks the following question: Given a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city exactly once and returns to the origin city? It is an NP-hard problem in combinatorial optimization, important in operations research and theoretical computer science.
Here is the source code of the Java Program to Implement Traveling Salesman Problem using Nearest neighbour Algorithm. The Java program is successfully compiled and run on a Linux system. The program output is also shown below.
*/

/*
 * 
 * 
 * 
 * Enter the number of nodes in the graph
9
Enter the adjacency matrix
000 374 200 223 108 178 252 285 240 356
374 000 255 166 433 199 135 095 136 017
200 255 000 128 277 128 180 160 131 247
223 166 128 000 430 047 052 084 040 155
108 433 277 430 000 453 478 344 389 423
178 199 128 047 453 000 091 110 064 181
252 135 180 052 478 091 000 114 083 117
285 095 160 084 344 110 114 000 047 078
240 136 131 040 389 064 083 047 000 118
356 017 247 155 423 181 117 078 118 000
the citys are visited as follows
1	5	3	2	9	7	4	6	8
 */
import java.util.InputMismatchException;
import java.util.Stack;
 
public class TSPNearestNeighbour
{
    private int numberOfNodes;
    private Stack<Integer> stack;
 
    public TSPNearestNeighbour()
    {
        stack = new Stack<Integer>();
    }
 
    public void tsp(int adjacencyMatrix[][])
    {
        numberOfNodes = adjacencyMatrix[1].length - 1;
        int[] visited = new int[numberOfNodes + 1];
        visited[1] = 1;
        stack.push(1);
        int element, dst = 0, i;
        int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(1 + "\t");
 
        while (!stack.isEmpty())
        {
            element = stack.peek();
            i = 1;
            min = Integer.MAX_VALUE;
            while (i <= numberOfNodes)
            {
                if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
                {
                    if (min > adjacencyMatrix[element][i])
                    {
                        min = adjacencyMatrix[element][i];
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);
                System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
    }
 
    public static void main(String... arg)
    {
        try
        {
            int adjacency_matrix[][] = new int[][]{
                    {0,20,42,25},
                    {20,0,30,34},
                    {42,30,0,10},
                    {25,34,10,0}
            };
            
            int number_of_nodes = 4;
            for (int i = 0; i < number_of_nodes; i++)
            {
                for (int j = 0; j < number_of_nodes; j++)
                {
                    if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
                    {
                        adjacency_matrix[j][i] = 1;
                    }
                }
            }
            System.out.println("the citys are visited as follows");
            TSPNearestNeighbour tspNearestNeighbour = new TSPNearestNeighbour();
            tspNearestNeighbour.tsp(adjacency_matrix);
        } catch (InputMismatchException inputMismatch)
         {
             System.out.println("Wrong Input format");
         }
    }
}