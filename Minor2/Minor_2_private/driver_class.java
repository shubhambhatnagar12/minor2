package Core;
import java.util.*;  

public class driver_class  {

    static void rectangle(int n, int m)
	{
		int i, j;
		for (i = 1; i <= n; i++)
		{
			for (j = 1; j <= m; j++)
			{
                if (i==1 || i==n || j==1 || (j==m && i!=4 && i!=5))             
                System.out.print("*");	
                else if (i==4 && j==(m-42))
                System.out.print("*");	   
                else if (i==5 && j==(m-26))
                System.out.print("*");                     
                else if (i==4 && j==50)
                System.out.print("Modelling Static and Dynamic Load Balancing");
                else if (i==5 && j==57)
                System.out.print("Mechanism in Edge Computing");
                else
                System.out.print(" "); 
	
			}
			System.out.println();
		}
	
	}
    

    public static void main(String args[]) {

        int rows = 9, columns = 154; 
        System.out.println("\t\t\t\t\t\t\t             MINOR 2 ");
        System.out.println(); 
        rectangle(rows, columns); 
        System.out.println(); 
        System.out.println("\t\t\t\t\t\t\t           Approved by: ");
        System.out.println();
        System.out.println(" Mr. Amrendra Tripathi  \t\t\t\t\t\t                                                   Dr. Deepshikha Bhargava" );
        System.out.println("       [MENTOR]  \t\t\t\t\t\t\t\t                                                     [HOD]" );
        System.out.println("\t\t\t\t\t\t\t           Submitted by: ");
        System.out.println();
        System.out.println(" Shubham Bhatnagar [151] \t\t                   Yashvardhan Singh Nathawat [192]                                 Harsh Upparwal [198]" );
        System.out.println();
        int num;
        // parameter1=0;
        // String parameter2="";
        // float parameter3=0.0f;
        // int[] parameter4={};
        //Show 4 problems
        // System.out.print("\033[H\033[2J");  
        // System.out.flush(); 
        System.out.println("THE AVAILABLE PROBLEM STATEMENTS: ");
        System.out.println("");
        System.out.println("Q1.Find the Hexadecimal, Octal and Binary Value of a given Decimal value. Parameter: Should be a Integer.");
        System.out.println("Q2.Eliminate the duplicate characters from a input string. Parameter: Should be a valid string.");
        System.out.println("Q3.Currency converter from Indian Rupees to US Dollar. Parameter: Should be a valid float value. ");
        System.out.println("Q4.Eliminate the duplicate entries from a given array of Integers. Parameter: Enter the size of arrays and then Integer values.");
        
        Scanner sc= new Scanner(System.in);
        List<Integer> sequenceList=new ArrayList<Integer>();
        
        List<Integer> parameter1=new ArrayList<Integer>();
        List<String> parameter2=new ArrayList<String>();
        List<Float> parameter3=new ArrayList<Float>();
        List<Integer[]> parameter4=new ArrayList<Integer[]>();

        System.out.println("");

        System.out.println("Enter the number of tasks you want to execute: ");
        num=sc.nextInt();
        System.out.println("");
        System.out.println("Enter the sequence in which you want tasks to be executed:");
        for(int i=0;i<num;i++){
            sequenceList.add(sc.nextInt());
        }
        
        System.out.println("");
        //start a loop asking for parameters necessary to solve the problems
        System.out.println("ENTER THE PARAMETERS FOR EACH PROBLEM BASED ON CONDITIONS SPECIFIED:");
        for(int i=0;i<num;i++){
            System.out.println("");
            System.out.println("Enter the parameter for TASK "+sequenceList.get(i));
            if(sequenceList.get(i)==1){
                
                parameter1.add(sc.nextInt());
                
            }
            else if(sequenceList.get(i)==2){
                parameter2.add(sc.next());
            }
            else if(sequenceList.get(i)==3){
                parameter3.add(sc.nextFloat());

            }
            else if(sequenceList.get(i)==4){
                
                System.out.println("Enter Size of array");
                Integer[] list;
                int len=sc.nextInt();
		        list=new Integer[len];		
		        for(int j=0;j<list.length;j++)
		        {
			        System.out.print("Enter "+j+" element :=> ");
			        list[j]=sc.nextInt();
	
		        }
                parameter4.add(list);

            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        
        //call round robin and pass the order and all the parameters
        // same for least workload
        sc.close();
        edgeloadbalancer obj= new edgeloadbalancer(sequenceList,parameter1,parameter2,parameter3,parameter4);
        // edgeloadbalancer obj2= new edgeloadbalancer(sequenceList);
        obj.round_robin();
        obj.least_workload();
        
    }
    
}

