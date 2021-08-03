package Core;

public class TaskSolution {
    int Task1Cap, Task2Cap, Task3Cap, Task4Cap;
    TaskSolution(){
        Task1Cap=200;
        Task2Cap=300;
        Task3Cap=100;
        Task4Cap=400;
    }

    public void evalTask1(int parameter){
    
    System.out.println("");
    System.out.println("OUTPUT : ");
    System.out.println("");
    String hexa = Integer.toHexString(parameter);
    System.out.println("HexaDecimal Value is : " + hexa);
    String octal = Integer.toOctalString(parameter);
    System.out.println("Octal Value is : " + octal);
    String binary = Integer.toBinaryString(parameter);
    System.out.println("Binary Value is : " + binary);
    System.out.println("");
    }

    public void evalTask2(String parameter){
        char ch[] = parameter.toCharArray();
        int n = ch.length;
        parameter="";
        for (int i=0;i<n ;i++ )
        {
           parameter=parameter+ch[i];
           for (int j=i+1;j<n ;j++ )
           {
              if (ch[i]!=' '&&(ch[i]==ch[j]||ch[i]==ch[j]+32||ch[i]==ch[j]-32))
              {
                 for (int k=j;k<n-1 ;k++ )
                 {
                    ch[k]=ch[k+1];
                 }
                 n--;
                 j--;
              }
           }
        }
        System.out.println("");
        System.out.println("OUTPUT : ");
        System.out.println("");
        System.out.println(parameter);
        System.out.println("");

    }

    public void evalTask3(Float parameter){
        

		float dollars = parameter / 64;
        System.out.println("");
        System.out.println("OUTPUT : ");
        System.out.println("");
        System.out.println(parameter+"Rupees = "+dollars + " Dollars");
        System.out.println("");
        
    }

    public void evalTask4( Integer[] parameter){
        // int[] pureList;
        int key;
		int newSize=parameter.length;//total length Of array
		for(int i=0;i<newSize-1;i++)//for select each element as key
		{	
			key=parameter[i];//store first element as Key

			for(int j=i+1;j<newSize;j++)//Start Comparing with Next Element otherwise key element will be removed
			{				
					if(key==parameter[j])
					{	
						newSize=newSize-1;//Decreasing Length to Skip Last Element which already shifted up after below loop
						for(int k=j;k<newSize;k++)//Shift Up Array to remove Duplicate 
						 {
							
							parameter[k]=parameter[k+1];// remove duplicate 
							
						 }
					    j--;//for skipped element after delete			
					}
					

			}
		
		}
		int[] pureList=new int[newSize]; //Declare Resulting Array with newSize
			System.out.println(" After Removing Elements Array=> ");

		for(int p=0;p<newSize;p++)
		{
			pureList[p]=parameter[p];
		}
        System.out.println("");
        System.out.println("OUTPUT : ");
        System.out.println("");
        for(int x: pureList)//for each loop for display output
		{
			System.out.println(x);
		}
        System.out.println("");
		// return pureList;

    }

    //----------------------------------------------------///
    
    public void evalValue(int taskNum, int parameter){
        
            evalTask1(parameter);
       
    }

    public void evalValue(int taskNum, String parameter){
        
        evalTask2(parameter);
   
    }

    public void evalValue(int taskNum, Float parameter){
        
        evalTask3(parameter);

    }
    public void evalValue(int taskNum, Integer[] parameter){
        
        evalTask4(parameter);

    }

}