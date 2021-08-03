package Core;

public class edgeNode1 extends TaskSolution{
    int CapacityOfEnode1;
    edgeNode1(){
        CapacityOfEnode1=500;
    }

    public void evalAt(){
        System.out.println("Workload is being calculated at EDGE NODE 1");
    }

    public void eval(int taskNum, int parameter){
        evalAt();
        evalValue(taskNum, parameter);

    }
    public void eval(int taskNum, String parameter){
        evalAt();
        evalValue(taskNum, parameter);

    }
    public void eval(int taskNum, Float parameter){
        evalAt();
        evalValue(taskNum, parameter);

    }
    public void eval(int taskNum, Integer[] parameter){
        evalAt();
        evalValue(taskNum, parameter);

    }
}
