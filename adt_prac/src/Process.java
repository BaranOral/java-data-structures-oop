public class Process implements IProcess{
	
	//getter setter for process
    private int priority;
    private String type;

    public Process() {
    }

    public Process(int priority, String type) {
        this.priority = priority;
        this.type = type;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    public String getType() {
        return type;
    }

    
    public int getPriority() {
        return priority;
    }

    
    public String toString() {
        return  ", priority=" + type;
    }
}
