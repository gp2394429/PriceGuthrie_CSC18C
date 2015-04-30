public class Map {

    public Vector keys = new Vector();
    public Vector values = new Vector();
    public int size = 0;

    public Map(LinkedList x){
        for(int i=0;i<x.size();i++){
            Integer key = x.get(i);
            int keyIndex = getIndex(key);
            if(keyIndex < 0){
                keys.set(size,key);
                values.set(size,1);
                size++;
            }
            else{
                keys.set(keyIndex,key);
                values.set(keyIndex,values.get(keyIndex)+1);
            }
        }
    }
    
    public Map(Vector x){
    	for(int i=0;i<x.length();i++){
            Integer key = x.get(i);
    	    if(key != null){
    	        int keyIndex = getIndex(key);
    	        if (keyIndex < 0){
    		    keys.set(size,key);
    		    values.set(size,1);
    		    size++;
    	        }
    	        else{
    	            keys.set(keyIndex,key);
    	            values.set(keyIndex,values.get(keyIndex)+1);
    	        }
            }
        }
    }
    
    public boolean hasKey(Integer key){
    	for(int i=0;i<size;i++){
    		if(keys.get(i) == key)
    			return true;
    	}
    	return false;
    }
    
    public int getIndex(Integer key){
        for(int i=0;i<keys.length();i++){
            if(keys.get(i) == key)
                return i;
        }
        return -1;
    }

    public Integer getValue(Integer key){
        Integer i = getIndex(key);
        if(i>0)
            return values.get(i);
        else
            return new Integer(-1);
    }
    
    public String toString(){
        String result = "";
        for(int i=0;i<size;i++){
            String key = keys.get(i).toString();
            String value = values.get(i).toString();
            result = result + key + "=" + value + " ";
        }
        return result;
    }
    
}
