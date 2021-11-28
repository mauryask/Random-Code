import static java.lang.System.*;
import java.util.*;

public class GasStationProblem 
{
    static int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int n = gas.length;
        
        for(int i=0; i<n; i++)
        {
            int gasInTank = 0;
            int j = i;            
            boolean flag = true;
            
            do 
            {
                gasInTank += gas[j];
                
                if(gasInTank < cost[j])
                {
                    flag = false;
                    break;
                }
                
                gasInTank -= cost[j];
                j++;
                j = j%n;
                
            }while(i!=j);
            
            if(flag)
              return i;
        }
        
        return -1;
    } 
	
	public static void main(String [] args)
	{
		int gas[] = {1,2,3,4,5};
		int cost[] = {3,4,5,1,2};
		out.println(canCompleteCircuit(gas, cost));
	}
}