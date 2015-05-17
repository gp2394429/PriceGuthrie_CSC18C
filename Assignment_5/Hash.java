import java.util.Arrays;
import java.util.Vector;

public class Hash{
    	
    private int size;
    private LinkedList[] hashArray;
    	
    public Hash(Vector<String> v){
    	size = 1000000;
        populate(v);
	}
	
	public Hash(Vector<String> v, int size){
		this.size = size;
		populate(v);
    }

    private void populate(Vector<String> v){
        hashArray = new LinkedList[size];
        Arrays.fill(hashArray,null);
		for(int i=0;i<v.size();i++){
			int index = hash(v.get(i));
            if(hashArray[index]==null){
                hashArray[index] = new LinkedList();
            }
			hashArray[index].append(v.get(i));
		}
	}
	
	public int hash(String s){
		double hashI=0;
		char cArray[] = s.toCharArray();
		for(int i=0;i<cArray.length;i++){
			hashI += (double)((int)cArray[i]*Math.pow(52.0,(double)i));
		}
		while(hashI>size){
	        hashI /= 10.0;
		}
		return (new Double(hashI).intValue());
	}

    public boolean find(String s){
        int index = hash(s);
        if(hashArray[index] != null){
            LinkedList l = hashArray[index];
            return l.find(s);
        }
        return false;
    }       
}
