package Core;

public class edgeNode3 extends TaskSolution {
    int CapacityOfEnode3;
    edgeNode3(){
        CapacityOfEnode3=700;
    }

    public void evalAt(){
        System.out.println("Workload is being calculated at EDGE NODE 3");
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
