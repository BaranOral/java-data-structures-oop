
public class Runner {

    public static void main(String[] args) {
    	
        LinkedList<Simulation> simulationList = new LinkedList<>();//We have 3 simulation we store them in a linked list each simulation in a priorty queue format and we will turn it to list
        //for execution by priorty (high, normal, low)
        
        //Creating 3 simulation
        Simulation simulation1 = new Simulation(1);
        Simulation simulation2 = new Simulation(2);
        Simulation simulation3 = new Simulation(3);
        
        //Adding them in to a linked list
        simulationList.add(simulation1);
        simulationList.add(simulation2);
        simulationList.add(simulation3);

        //Arrangment of queue length()
        Computation.computationProcessGenerator(5,simulation1);
        Computation.computationProcessGenerator(9,simulation2);
        Computation.computationProcessGenerator(19,simulation3);

        int j;
        int i =0;
        //Iteration in linked list
        while (i < simulationList.getSize()) {
        	
            int waitingTime = 0;
            //Total computation list for queue
            List<Computation> list = new List<>();
            //Priorty lists
            List<Computation> highComputationList = new List<>();
            List<Computation> normalComputationList = new List<>();
            List<Computation> lowComputationList = new List<>();
            
            Simulation iteradedSimulation = simulationList.returnIndex(i);//our computation queue in the linked list
            
            System.out.println("Simulation Number: " + (i + 1));
            System.out.print("Computation Queue: ");
            
            for (j = 0; j < iteradedSimulation.getComputationQueue().size(); j++) {
            	
                Computation currenctComputation = Computation.compile(iteradedSimulation);//given comuptation
                list.add(currenctComputation);
                System.out.print(currenctComputation);
                
                assert currenctComputation != null;
                
                if (currenctComputation.getProcess().getPriority() == 1) {
                    highComputationList.add(currenctComputation);
                }
                
                if (currenctComputation.getProcess().getPriority() == 2) {
                    normalComputationList.add(currenctComputation);
                }
                
                if (currenctComputation.getProcess().getPriority() == 3) {
                    lowComputationList.add(currenctComputation);
                }
                
                if (!((j + 1) == iteradedSimulation.getComputationQueue().size())) {
                    waitingTime = waitingTime + currenctComputation.getOccupation();
                    System.out.print(" <- ");
                }
            }
            
            System.out.println();
            System.out.println("Total numbers of computations : " + (j));
            System.out.println("\n");
            
            System.out.println("Total waiting time : " + Computation.timeCounter(list));
            System.out.println("Average waiting time : " + (float) Computation.timeCounter(list) / list.size());
            System.out.println("\n");
            
            int highComputationNumber=highComputationList.size();
            int normalComputationNumber=normalComputationList.size();
            int lowComputationNumber=lowComputationList.size();
            
            float highTime = Computation.timeCounter(highComputationList);
            float normalTime = Computation.timeCounter(normalComputationList);
            float lowTime = Computation.timeCounter(lowComputationList);

            System.out.println("Total number of computations for High: " +  highComputationNumber);
            System.out.println("Total number of computations for Normal: " +  normalComputationNumber);
            System.out.println("Total number of computations for Low: " +  lowComputationNumber);
            System.out.println();

            if (highComputationNumber > 0) {
            	
                System.out.println("Total waiting time for High: " + highTime);
                System.out.println("Average waiting time for High: " + (highTime / highComputationNumber));
                System.out.println();
                
            }else {
				System.out.println("There is no High Priority computation!\n");
			}
            if (normalComputationNumber > 0) {
            	
                System.out.println("Total waiting time for Normal: " + (normalTime + Computation.timeCounter(highComputationList)));
                System.out.println("Average waiting time for Normal: " + ((normalTime + Computation.timeCounter(highComputationList)) / normalComputationNumber));
                System.out.println();

            }else {
				System.out.println("There is no Normal Priority computation!\n");
			}
            
            if (lowComputationNumber > 0) {
            	
                System.out.println("Total waiting time for Low: " + (lowTime + Computation.timeCounter(normalComputationList) + Computation.timeCounter(highComputationList)));
                System.out.println("Average waiting time for Low: " +  ((lowTime + Computation.timeCounter(normalComputationList) + Computation.timeCounter(highComputationList)) / lowComputationNumber));
                System.out.println();
            }else {
				System.out.println("There is no Low Priority computation!\n");
			}
            
            i++;
        }

    }
}