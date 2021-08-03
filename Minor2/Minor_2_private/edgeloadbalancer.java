package Core;
import java.util.*;

public class edgeloadbalancer{
    List<Integer> sequence = new ArrayList<>(); 
    List<Integer> task1parameter;
    List<Integer> task1parameterlw;
    List<String> task2parameter;
    List<String> task2parameterlw;
    List<Float> task3parameter;
    List<Float> task3parameterlw;
    List<Integer[]> task4parameter;
    List<Integer[]> task4parameterlw;
    edgeNode1 en1=new edgeNode1();
    edgeNode2 en2=new edgeNode2();
    edgeNode3 en3=new edgeNode3();
    data_centre dc=new data_centre();

    edgeloadbalancer(List<Integer> sequenceList, List<Integer> task1, List<String> task2, List<Float> task3, List<Integer[]> task4){
        sequence=sequenceList;
        task1parameter=task1;
        task1parameterlw=new ArrayList<Integer>(task1parameter);

        // task1parameterlw=task1;
        // System.out.println(task1parameterlw.get(0));
        task2parameter=task2;
        task2parameterlw=new ArrayList<String>(task2parameter);

        // task2parameterlw=task2;
        task3parameter=task3;
        task3parameterlw=new ArrayList<Float>(task3parameter);

        // task3parameterlw=task3;
        task4parameter=task4;
        task4parameterlw=new ArrayList<Integer[]>(task4parameter);

        // task4parameterlw=task4;

    }
    public  void round_robin() {
        int counter=1;
        System.out.println("ROUND ROBIN SCHEDULING");
        System.out.println("");
        for(int i=0; i<sequence.size() ; i++){

                if(sequence.get(i)==1){
                    System.out.println("Calculating task: "+sequence.get(i));
                    if(counter==1){
                        if(en1.Task1Cap<=en1.CapacityOfEnode1){
                            en1.eval(1,task1parameter.get(0));
                            task1parameter.remove(0);
                            en1.CapacityOfEnode1=en1.CapacityOfEnode1-en1.Task1Cap;
                            counter++;
                        }
                        // else if(en1.Task1Cap<=en2.CapacityOfEnode2){
                        //     en2.eval(2,task1parameter);
                        //     en2.CapacityOfEnode2=-en2.Task1Cap;
                        // }
                        // else if(en1.Task1Cap<=en3.CapacityOfEnode3){
                        //     en3.eval(3,task1parameter);
                        //     en3.CapacityOfEnode3=-en3.Task1Cap;
                        // }
                        else {
                            System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                            dc.eval(1,task1parameter.get(0));
                            task1parameter.remove(0);
                            dc.CapacityOfDC=dc.CapacityOfDC-dc.Task1Cap;
                            counter++;
                           
                        }
                    }
                    else if(counter==2){
                        if(en1.Task1Cap<=en2.CapacityOfEnode2){
                                en2.eval(2,task1parameter.get(0));
                                task1parameter.remove(0);
                                en2.CapacityOfEnode2=en2.CapacityOfEnode2-en2.Task1Cap;
                                counter++;
                        }
                        else {
                            System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                            dc.eval(1,task1parameter.get(0));
                            task1parameter.remove(0);
                            dc.CapacityOfDC=dc.CapacityOfDC-dc.Task1Cap;
                            counter++;
                        }
                    }
                    else if(counter==3){
                        if(en1.Task1Cap<=en3.CapacityOfEnode3){
                                en3.eval(3,task1parameter.get(0));
                                task1parameter.remove(0);
                                en3.CapacityOfEnode3=en3.CapacityOfEnode3-en3.Task1Cap;
                                counter=1;
                            }
                        else {
                            System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                            dc.eval(1,task1parameter.get(0));
                            task1parameter.remove(0);
                            dc.CapacityOfDC=dc.CapacityOfDC-dc.Task1Cap;
                            counter=1;
                               
                        }
                        
                    }
                    // System.out.println(counter);
                }

                else if(sequence.get(i)==2){
                    System.out.println("Calculating task: "+sequence.get(i));
                    if(counter==1){
                        if(en1.Task2Cap<=en1.CapacityOfEnode1){
                            en1.eval(1,task2parameter.get(0));
                            task2parameter.remove(0);
                            en1.CapacityOfEnode1=en1.CapacityOfEnode1-en1.Task2Cap;
                            counter++;
                        }
                        // else if(en1.Task2Cap<=en2.CapacityOfEnode2){
                        //     en2.eval(2,task2parameter);
                        //     en2.CapacityOfEnode2=-en2.Task2Cap;
                        // }
                        // else if(en1.Task2Cap<=en3.CapacityOfEnode3){
                        //     en3.eval(3,task2parameter);
                        //     en3.CapacityOfEnode3=-en3.Task2Cap;
                        // }
                        else{
                            System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                            dc.eval(1,task2parameter.get(0));
                            task2parameter.remove(0);
                            dc.CapacityOfDC=dc.CapacityOfDC-dc.Task2Cap;
                            counter++;
                        }
                   }
                   else if(counter==2){
                    if(en2.Task2Cap<=en2.CapacityOfEnode2){
                        en2.eval(2,task2parameter.get(0));
                        task2parameter.remove(0);
                        en2.CapacityOfEnode2=en2.CapacityOfEnode2-en2.Task2Cap;
                        counter++;
                    }
                    else{
                        System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                        dc.eval(1,task2parameter.get(0));
                        task2parameter.remove(0);
                        dc.CapacityOfDC=dc.CapacityOfDC-dc.Task2Cap;
                        counter++;
                    }
                }
                else if(counter==3){
                    if(en1.Task2Cap<=en3.CapacityOfEnode3){
                        en3.eval(3,task2parameter.get(0));
                        task2parameter.remove(0);
                        en3.CapacityOfEnode3=en3.CapacityOfEnode3-en3.Task2Cap;
                        counter=1;
                    }
                    else{
                        System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                        dc.eval(1,task2parameter.get(0));
                        task2parameter.remove(0);
                        dc.CapacityOfDC=dc.CapacityOfDC-dc.Task2Cap;
                        counter=1;
                    }

                }
            }
                else if(sequence.get(i)==3){
                    System.out.println("Calculating task: "+sequence.get(i));
                    if(counter==1){
                    
                    if(en3.Task3Cap<=en1.CapacityOfEnode1){
                        en1.eval(1,task3parameter.get(0));
                        task3parameter.remove(0);
                        en1.CapacityOfEnode1=en1.CapacityOfEnode1-en1.Task3Cap;
                        counter++;
                    }
                    // else if(en1.Task3Cap<=en2.CapacityOfEnode2){
                    //     en2.eval(2,task3parameter);
                    //     en2.CapacityOfEnode2=-en2.Task3Cap;
                    // }
                    // else if(en1.Task3Cap<=en3.CapacityOfEnode3){
                    //     en3.eval(3,task3parameter);
                    //     en3.CapacityOfEnode3=-en3.Task3Cap;
                    // }
                    else{
                        System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                        dc.eval(1,task3parameter.get(0));
                        task3parameter.remove(0);
                        dc.CapacityOfDC=dc.CapacityOfDC-dc.Task3Cap;
                        counter++;
                    }
                }
                else if(counter==2){
                    if(en1.Task3Cap<=en2.CapacityOfEnode2){
                        en2.eval(2,task3parameter.get(0));
                        task3parameter.remove(0);
                        en2.CapacityOfEnode2=en2.CapacityOfEnode2-en2.Task3Cap;
                        counter++;
                    }
                    else{
                        System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                        dc.eval(1,task3parameter.get(0));
                        task3parameter.remove(0);
                        dc.CapacityOfDC=dc.CapacityOfDC-dc.Task3Cap;
                        counter++;
                    }

                }
                else if(counter==3){
                    if(en1.Task3Cap<=en3.CapacityOfEnode3){
                        en3.eval(3,task3parameter.get(0));
                        task3parameter.remove(0);
                        en3.CapacityOfEnode3=en3.CapacityOfEnode3-en3.Task3Cap;
                        counter=1;
                    }
                    else{
                        System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                        dc.eval(1,task3parameter.get(0));
                        task3parameter.remove(0);
                        dc.CapacityOfDC=dc.CapacityOfDC-dc.Task3Cap;
                        counter=1;
                    }

                }
            }
                else if(sequence.get(i)==4){
                    System.out.println("Calculating task: "+sequence.get(i));
                    if(counter==1){

                    if(en1.Task4Cap<=en1.CapacityOfEnode1){
                        en1.eval(1,(task4parameter.get(0)));
                        task4parameter.remove(0);
                        System.out.println("en1 cap="+en1.CapacityOfEnode1);
                        en1.CapacityOfEnode1=en1.CapacityOfEnode1-en1.Task4Cap;
                        System.out.println("en1 cap="+en1.CapacityOfEnode1);
                        counter++;
                    }
                    // else if(en1.Task3Cap<=en2.CapacityOfEnode2){
                    //     en2.eval(2,task4parameter);
                    //     en2.CapacityOfEnode2=-en2.Task4Cap;
                    // }
                    // else if(en1.Task3Cap<=en3.CapacityOfEnode3){
                    //     en3.eval(3,task4parameter);
                    //     en3.CapacityOfEnode3=-en3.Task4Cap;
                    // }
                    else{
                        System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                        dc.eval(1,(task4parameter.get(0)));
                        task4parameter.remove(0);
                        dc.CapacityOfDC=dc.CapacityOfDC-dc.Task4Cap;
                        counter++;
                    }
                }
                else if(counter==2){
                    if(en1.Task4Cap<=en2.CapacityOfEnode2){
                        en2.eval(2,(task4parameter.get(0)));
                        task4parameter.remove(0);
                        en2.CapacityOfEnode2=en2.CapacityOfEnode2-en2.Task4Cap;
                        counter++;
                    }
                    else{
                        System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                        dc.eval(1,(task4parameter.get(0)));
                        task4parameter.remove(0);
                        dc.CapacityOfDC=dc.CapacityOfDC-dc.Task4Cap;
                        counter++;
                    }
                }
                else if(counter==3){
                    if(en1.Task4Cap<=en3.CapacityOfEnode3){
                        en3.eval(3,(task4parameter.get(0)));
                        task4parameter.remove(0);
                        en3.CapacityOfEnode3=en3.CapacityOfEnode3-en3.Task4Cap;
                        counter=1;
                    }
                    else{
                        System.out.println("ERROR: Due to poor scheduling of workload the Edge node"+counter+"is overloaded. Transferring the task to Data Centre." );
                        dc.eval(1,(task4parameter.get(0)));
                        task4parameter.remove(0);
                        dc.CapacityOfDC=dc.CapacityOfDC-dc.Task4Cap;
                        counter=1;
                    }
                }

            }
        }
            en1.CapacityOfEnode1=600;
            en2.CapacityOfEnode2=700;
            en3.CapacityOfEnode3=800;
            dc.CapacityOfDC=2000;
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(" ");
            // System.out.println(task1parameterlw.get(0));

        }
    public  void least_workload() {
        System.out.println("LEAST WORKLOAD SCHEDULING");
        System.out.println("");
        ArrayList <Integer[]> maxedgecapacity= new ArrayList<>();
        maxedgecapacity.add(new Integer[]{en1.CapacityOfEnode1,1});
        maxedgecapacity.add(new Integer[]{en2.CapacityOfEnode2,2});
        maxedgecapacity.add(new Integer[]{en3.CapacityOfEnode3,3});
        
        for(int i=0;i<sequence.size();i++){
            
            for(int j=1;j<=3;j++){
                if(j==1){
                    // maxedgecapacity.add(new Integer[]{en1.CapacityOfEnode1,j});
                    maxedgecapacity.get(0)[0]=en1.CapacityOfEnode1;
                    maxedgecapacity.get(0)[1]=j;
                }
                else if(j==2){
                    // maxedgecapacity.add(new Integer[]{en2.CapacityOfEnode2,j});
                    maxedgecapacity.get(1)[0]=en2.CapacityOfEnode2;
                    maxedgecapacity.get(1)[1]=j;
                }
                else if(j==3){
                    // maxedgecapacity.add(new Integer[]{en3.CapacityOfEnode3,j});
                    maxedgecapacity.get(2)[0]=en3.CapacityOfEnode3;
                    maxedgecapacity.get(2)[1]=j;
                }

            }

            Collections.sort(maxedgecapacity, new Comparator<Integer[]>() {
                            public int compare(Integer[] array1, Integer[] array2) {
                                return array1[0].compareTo(array2[0]);
                            }
                        });
            
            if(sequence.get(i)==1){
                System.out.println("Calculating task: "+sequence.get(i));
                int o=maxedgecapacity.get(2)[1];
                if(en1.Task1Cap<=maxedgecapacity.get(2)[0]){
                    // int o=maxedgecapacity.get(2)[1];
                    if(o==1){
                        en1.eval(1,task1parameterlw.get(0));
                        task1parameterlw.remove(0);
                        en1.CapacityOfEnode1=en1.CapacityOfEnode1-en1.Task1Cap;
                    }
                    else if(o==2){
                        en2.eval(1,task1parameterlw.get(0));
                        task1parameterlw.remove(0);
                        en2.CapacityOfEnode2=en2.CapacityOfEnode2-en2.Task1Cap;

                    }
                    else if(o==3){
                        // System.out.println(task1parameterlw.get(0));
                        en3.eval(1, task1parameterlw.get(0));
                        task1parameterlw.remove(0);
                        en3.CapacityOfEnode3=en3.CapacityOfEnode3-en3.Task1Cap;
                    }
                    
                }
                else{
                    System.out.println("ERROR: The Edge node"+o+"is overloaded. Transferring the task to Data Centre." );
                    dc.eval(1, task1parameterlw.get(0));
                    task1parameterlw.remove(0);
                    dc.CapacityOfDC=dc.CapacityOfDC-dc.Task1Cap;
                }
            }
            else if(sequence.get(i)==2){
                System.out.println("Calculating task: "+sequence.get(i));
                int o=maxedgecapacity.get(2)[1];
                if(en1.Task2Cap<=maxedgecapacity.get(2)[0]){
                    // int o=maxedgecapacity.get(2)[1];
                    if(o==1){
                        en1.eval(2, task2parameterlw.get(0));
                        task2parameterlw.remove(0);
                        en1.CapacityOfEnode1=en1.CapacityOfEnode1-en1.Task2Cap;
                    }
                    else if(o==2){
                        en2.eval(2, task2parameterlw.get(0));
                        task2parameterlw.remove(0);
                        en2.CapacityOfEnode2=en2.CapacityOfEnode2-en2.Task2Cap;

                    }
                    else if(o==3){
                        en3.eval(2, task2parameterlw.get(0));
                        task2parameterlw.remove(0);
                        en3.CapacityOfEnode3=en3.CapacityOfEnode3-en3.Task2Cap;

                    }
                    
                }
                else{
                    System.out.println("ERROR: The Edge node"+o+"is overloaded. Transferring the task to Data Centre." );
                    dc.eval(2, task2parameterlw.get(0));
                    task2parameterlw.remove(0);
                    dc.CapacityOfDC=dc.CapacityOfDC-dc.Task2Cap;

                }
            }
            else if(sequence.get(i)==3){
                System.out.println("Calculating task: "+sequence.get(i));
                int o=maxedgecapacity.get(2)[1];
                if(en1.Task3Cap<=maxedgecapacity.get(2)[0]){
                    // int o=maxedgecapacity.get(2)[1];
                    if(o==1){
                        en1.eval(3, task3parameterlw.get(0));
                        task3parameterlw.remove(0);
                        en1.CapacityOfEnode1=en1.CapacityOfEnode1-en1.Task3Cap;
                    }
                    else if(o==2){
                        en2.eval(3, task3parameterlw.get(0));
                        task3parameterlw.remove(0);
                        en2.CapacityOfEnode2=en2.CapacityOfEnode2-en2.Task3Cap;
                    }
                    else if(o==3){
                        en3.eval(3, task3parameterlw.get(0));
                        task3parameterlw.remove(0);
                        en3.CapacityOfEnode3=en3.CapacityOfEnode3-en3.Task3Cap;

                    }
                    
                }
                else{
                    System.out.println("ERROR: The Edge node"+o+"is overloaded. Transferring the task to Data Centre." );
                    dc.eval(3, task3parameterlw.get(0));
                    task3parameterlw.remove(0);
                    dc.CapacityOfDC=dc.CapacityOfDC-dc.Task3Cap;
                }
            }
            else if(sequence.get(i)==4){
                System.out.println("Calculating task: "+sequence.get(i));
                int o=maxedgecapacity.get(2)[1];
                System.out.println("max cap="+ maxedgecapacity.get(2)[0]);
                if(en1.Task4Cap<=maxedgecapacity.get(2)[0]){
                    // int o=maxedgecapacity.get(2)[1];
                    if(o==1){
                        en1.eval(4,(task4parameterlw.get(0)));
                        task4parameterlw.remove(0);
                        en1.CapacityOfEnode1=en1.CapacityOfEnode1-en1.Task4Cap;

                    }
                    else if(o==2){
                        en2.eval(4, task4parameterlw.get(0));
                        task4parameterlw.remove(0);
                        en2.CapacityOfEnode2=en2.CapacityOfEnode2-en2.Task4Cap;

                    }
                    else if(o==3){
                        en3.eval(4, task4parameterlw.get(0));
                        task4parameterlw.remove(0);
                        en3.CapacityOfEnode3=en3.CapacityOfEnode3-en3.Task4Cap;

                    }
                    
                }
                else{
                    System.out.println("ERROR: The Edge node"+o+"is overloaded. Transferring the task to Data Centre." );
                    dc.eval(4, task4parameterlw.get(0));
                    task4parameterlw.remove(0);
                    dc.CapacityOfDC=dc.CapacityOfDC-dc.Task4Cap;

                }
            }
        }
    }
        
        
}

