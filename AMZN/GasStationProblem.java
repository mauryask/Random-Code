import static java.lang.System.*;
import java.util.*;

public class GasStationProblem 
{
    // T(n) : O(n*n)
    // S(n) : O(1)
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
    
    // T(n) : O(n)
    // S(n) : O(1)
    static int betterMethod(int[] petrol, int[] dist)
    {
        // petrol in the tank currently
        int petrolInTank = 0;
        // extra etrol needed to reach from starting 
        // to jth petrol pump
        int petrolNeeded = 0;
        int n = dist.length;
        int j = 0, startPoint = 0;
        
        while(j<n)
        {
           // come to petrol pump fill the tank
           petrolInTank += petrol[j];
           
           // if you have enough petrol
           // move to next petrol pump
           if(petrolInTank >= dist[j])
           {
               // petrol that spent to move to next pump
               // will be equal to distance of next pump
               // hence remaining petrol
               petrolInTank -= dist[j];
               j++;
           }
           else // dont have enough fuel
           {
               // extra fuel needed to move to next pump
               petrolNeeded += petrolInTank - dist[j];
               // start journey with new pump with empty tank like new start
               petrolInTank = 0;
               j++;
               startPoint = j;
           }
        }
        
        // check if at the last pump if 
        // petrol in tank is greater than or equal
        // to total extra petrol needed 
        // to reach from first pump to the last pump
        if(petrolInTank >= (-petrolNeeded))
            return startPoint;
        // if circle can ot be completed at all 
        return -1;
    }
    
	public static void main(String [] args)
	{
		int petrol[] = {4,6,7,4};//{2,3,4};
		int dist[] = {6,5,3,5};//{3,4,3};
		out.println(betterMethod(petrol, dist));
		//out.println(canCompleteCircuit(petrol, dist));
	}
}