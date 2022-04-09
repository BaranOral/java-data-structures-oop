import java.util.Random;

public class Computation {
    private int id;
    private IProcess process;
    private int occupation;
//Getter setter for Computation
    public Computation() {
    }

    public Computation(int id, IProcess process, int occupation) {
        this.id = id;
        this.process = process;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IProcess getProcess() {
        return process;
    }

    public void setProcess(IProcess process) {
        this.process = process;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

// toString Method   
    public String toString() {
        return  " P" + id  + process.toString() +  ", occupation=" + occupation ;
    }


   
   public static void computationProcessGenerator(int size, Simulation simulation){
       Random rand= new Random();
       
       for(int i=0;i<size;i++){// We couldn't figure our why it gives less size because of that we give wanted number for 3 , 5, 10 length queue
       	
           int priority = rand.nextInt(3)+1;//randomly priorty genartion
           int id = rand.nextInt(100);//random id
           int time = rand.nextInt(10)+1;//random occupation time
           
           Process process = new Process(priority,priortyStringGenerator(priority));
           Computation computation = new Computation(id,process,time);
           simulation.getComputationQueue().enque(computation,priority);//appending ADT priorty queue out object
       }
   }
   
	   //Checks priorty value for printing
	   private static String priortyStringGenerator(int priorty){
	
	  	 String retvalString = null;
	  	 
	  	 if (priorty == 1) {
	  		 retvalString = "High";
	  	 }
	  	 if(priorty == 2){
	  		 retvalString = "Normal";
	  	 }
	  	 if (priorty == 3) {
	  		 retvalString = "Low";			
			}
			
			return retvalString;  
	  }
   
   public static Computation compile(Simulation simulation) {//executed computation we take our from queue and append in to list
   	
       if (simulation.getComputationQueue().size() != 0) {
           return simulation.getComputationQueue().deque();
           
       } else {
           return null;
       }
   }
   
   public static float timeCounter(List<Computation> computationList){
     
       float time= 0;
       
       for (int i=0;i<computationList.size()-1;i++){//Always last element does not exculeded to the time computation so we take our given list iterate
    	   //it and calculate total time to get to that element
           time=time+computationList.get(i).getOccupation();
       }
       
       return time;
   }
}