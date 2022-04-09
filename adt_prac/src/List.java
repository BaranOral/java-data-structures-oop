
public class List<T> {

    private T[] a;
    private int size;


    @SuppressWarnings("unchecked")
	public List(){
        this.a = (T[]) new Object[10];
    }

    public void add(T e) {
        if (this.size+1 < this.a.length){
            this.a[this.size()] = e;
        } else {
            this.resize();
            this.a[this.size()] = e;
        }
        this.size++;
    }

    public void add(int index, T element) {
        if (index >= 0 || index < this.size()){
            if (this.size() + 1 > a.length)
                this.resize();

            for (int i = this.size(); i > index; i--)
                this.set(i, this.get(i-1));

            this.set(index, element);
            size++;

        } else
            throw new IndexOutOfBoundsException(index + " too much for array (" + this.size() + ")");
    }

    public void addAll(T[] c) {
        for (T element : c){
            add(element);
        }
    }

    public void addAll(int index, T[] c) throws IndexOutOfBoundsException {
        int i = index;
        for (T element : c){
            add(i,element);
            i++;
        }
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < this.size())
            return a[index];
        else
            throw new IndexOutOfBoundsException(  index + " too much for array  (" + this.size() + ")");
    }

    public T remove(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < this.size())
        {
            T temp = a[index];

            for (int i = index; i < this.size() - 1; i++)
                a[index] = a[index + 1];

            size--;
            return temp;
        }
        else
            throw new IndexOutOfBoundsException( index + " too much for array (" + this.size() + ")");
    }

    public void set(int index, T element) {
        if ((index >= 0) || (index < this.size())){
            this.a[index] = element;
        } else
            throw new IndexOutOfBoundsException(index + " too much for array (" + this.size() + ")");
    }

    public int indexOf(T o) {
        for (int i = 0; i < this.size(); i++)
        {
            if (this.a[i].equals(o))
                return i;
        }

        return -1;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return this.size;
    }

    public T[] toArray() {
        return this.a;
    }

    @SuppressWarnings("unchecked")
	private void resize()
    {
        // create new array with doubled size
        T[] resizedArray = (T[]) new Object[this.a.length * 2];

        // copies elements of internal array into new array
        for (int i = 0; i < this.size(); i++)
            resizedArray[i] = this.a[i];

        // set internal array to new array
        this.a = resizedArray;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < this.size(); i++)
            out += "["+get(i).toString()+"]";

        return out;
    }


}
