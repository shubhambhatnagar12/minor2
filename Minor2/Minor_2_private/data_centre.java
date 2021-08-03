package Core;

public class data_centre extends TaskSolution {
    int CapacityOfDC;
    data_centre(){
        CapacityOfDC=2000;
    }

    public void evalAt(){
        System.out.println("Workload is being calculated at the DATA CENTER");
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
