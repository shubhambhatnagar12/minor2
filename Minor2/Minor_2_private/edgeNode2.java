package Core;

public class edgeNode2 extends TaskSolution {
    int CapacityOfEnode2;
    edgeNode2(){
        CapacityOfEnode2=600;
    }

    public void evalAt(){
        System.out.println("Workload is being calculated at EDGE NODE 2");
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
