/* You are given an array tasks where tasks[i] = [actual i, minimum i]: 
* actual i is the actual amount of energy you spend to finish the ith task...
* minimumi is the minimum amount of energy you require to begin the ith task...
For example, if the task is [10, 12] and your current energy is 11, you cannot start this task... However, if your current energy is 13, you can complete this task, and your energy will be 3 after finishing it... You can finish the tasks in any order you like... Return the minimum initial amount of energy you will need to finish all the tasks...
   * Eg 1: tasks = [[1,2],[2,4],[4,8]]                              Output = 8
   * Eg 2: tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]              Output = 33
   * Eg 3: tasks = [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]]         Output = 27
 */
import java.util.*;
public class Initial
{
    public int MinimumEffort(int tasks[][])
    {
        Arrays.sort(tasks, (a,b) -> b[1] - a[1]);   // Descending Sort on the basis of energy required column...
        int dp[] = new int[tasks.length], sum = 0;
        for(int i = 0; i < tasks.length-1; i++)
        {
            dp[i] = Math.abs(tasks[i+1][1] - (tasks[i][1] - tasks[i][0]));   // Calculating the excess energy required to just begin the next task...
            sum = sum + dp[i];    // Adding the sum of the DP Array...
        }
        sum = sum + tasks[0][1];   // Adding the excess energy to the maximized task...
        return sum;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of tasks : ");
        x = sc.nextInt();
        int work[][] = new int[x][2];
        for(int i = 0; i < work.length; i++)
        {
            System.out.print("Enter the actual energy to complete "+(i+1)+" th work : ");
            work[i][0] = sc.nextInt();
            System.out.print("Enter the initial energy to begin the "+(i+1)+" th work : ");
            work[i][1] = sc.nextInt();
        }
        Initial initial = new Initial();    // Object creation...
        System.out.println("The Minimum Effort required : "+initial.MinimumEffort(work));
        sc.close();
    }
}

// Time Complexity  - O(n log n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. We sort the tasks in descending order by the energy required to begin the task...
 * 2. We then evaluate the excess energy we require for the next successive task to just begin it, since the begin energy will always be more than or equal to the completion energy contradiction never arises in this case...
 * 3. Then we sum all the excess energies with the first task required energy to get the minimum energy to complete all the tasks...
*/