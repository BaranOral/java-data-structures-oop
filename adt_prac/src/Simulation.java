public class Simulation {
	
	//Getter setter for Simulation and Creating Priorty Queue Object for simnulation
    private int simulationNumber;
    private PriorityQueue<Computation> computationQueue = new PriorityQueue<Computation>(3);

    public Simulation(int id) {
        this.simulationNumber = id;

    }

    public int getSimulationNumber() {
        return simulationNumber;
    }

    public void setSimulationNumber(int simulationNumber) {
        this.simulationNumber = simulationNumber;
    }

    public PriorityQueue<Computation> getComputationQueue() {
        return computationQueue;
    }

    public void setComputationQueue(PriorityQueue<Computation> computationQueue) {
        this.computationQueue = computationQueue;
    }
}
