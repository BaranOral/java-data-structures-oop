public class PriorityQueue<T> {
	
	//ADT Priorty Queue Methods
    private List<T> [] queues;
    private int totalSize;
    private int highestNonEmptyQueue;
    private int highest;
    
    
    

    @SuppressWarnings("unchecked")
	public PriorityQueue(int highest) {
    	
        queues = new List[highest + 1];
        totalSize = 0;
        this.highest = highest;
        highestNonEmptyQueue = -1;


        for (int i = 0; i < queues.length; i++) {
            queues[i] = new List<>();
        }

    }

    public void enque(T element, int priority) {
        queues[priority].add(element);

        if (highestNonEmptyQueue == -1) {
            highestNonEmptyQueue = highest;
        }
        if (priority < highestNonEmptyQueue) {
            highestNonEmptyQueue = priority;
        }
        totalSize++;
    }


    public T deque() {
        if (highestNonEmptyQueue == -1) return null;

        T element = queues[highestNonEmptyQueue].remove(0);
        if (highestNonEmptyQueue == highest && queues[highestNonEmptyQueue].isEmpty()) {
            highestNonEmptyQueue = -1;
        } else if (queues[highestNonEmptyQueue].isEmpty()) {

            int i ;
            for (i = highestNonEmptyQueue; i <= 3; i++) {
                if (!queues[i].isEmpty()) {
                    highestNonEmptyQueue = i;
                    break;
                }
            }
            if (i == 0 && queues[0].isEmpty()) {
                highestNonEmptyQueue = -1;
            }

        }
        totalSize--;
        return element;
    }

    public int size() {
        return totalSize;
    }


}