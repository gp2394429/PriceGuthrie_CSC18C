public class Vector{

    private int size;
    private Integer[] array;

    public Vector(){
        size = 20;
        array = new Integer[size];
        for(int i=0;i<size;i++){
            array[i] = null;
        }
    }

    public Vector(int size){
        this.size = size;
        array = new Integer[size];
        for(int i=0;i<size;i++){
            array[i] = null;
        }
    }
	
    public void set(int index, Integer item){
        if(index >= size){
            resize();
        }
        array[index] = item;
    }

    public Integer get(int index){
        return array[index];
    }

    public int length(){
        return size;
    }

    public void sort(){ 
        int max;
        Integer temp;
        for(int i = 0;i<size-1;i++){
            max = i;
            for(int j = i+1;j<size;j++){
                if(array[max] == null){
                    max = j;
                }
                else if(array[j] != null){
                    if(array[j] > array[max]){
                        max = j;
                    }
                }
            }
            if(max != i){
                temp = array[i];
                array[i] = array[max];
                array[max] = temp;
            }
        }
    }

    public void resize(){
        Integer newArray[] = new Integer[size*2];
        for(int i = 0;i<size;i++){
            newArray[i] = array[i];
        }
        size *= 2;
        array = newArray;
    }

    public void compress(){
        int count = 0;
        for(int i=0;i<size;i++){
            if(array[i] != null)
                count++;
        }
        Integer newArray[] = new Integer[count];
        int curIndex = 0;
        for(int i=0;i<size;i++){
            if(array[i] != null){
                newArray[curIndex] = array[i];
                curIndex++;
            }
        }
        size = count;
        array = newArray;
    }

    public String toString(){
        String result = "[";
        String c;

        for(int i = 0;i<size;i++){
            if(array[i] == null)
                c = ".";
            else
                c = array[i].toString();
            result = result + c;
            if(i == size-1)
                result = result + "]";
            else
                result = result + " ";
        }
        return result;
    }
}




