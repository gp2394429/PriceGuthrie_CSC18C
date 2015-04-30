public class StatClass extends Map{
	
    private int nModes;
    private int freq;
    private Vector modes;
	
    public StatClass(LinkedList x){
    	super(x);
    	modes = mode();
    	freq = maxFreq();
    	nModes = modes.length();
    }	
    public StatClass(Vector x){
        super(x);
    	modes = mode();
    	freq = maxFreq();
    	nModes = modes.length();
    }
    
    private Integer maxFreq(){
    	Integer max= new Integer(0);
    	for(int i=0;i<size;i++){
    	    if(max<values.get(i))
    		max = values.get(i);
    	}
    	return max;
    }
    
    private Vector mode(){
    	int curIndex = 0;
    	Integer max = maxFreq();
    	Vector mode = new Vector();
        if(max > 1){
    	    for(int i=0;i<size;i++){
    	        if(max == values.get(i)){
    	            mode.set(curIndex, keys.get(i));
    	            curIndex++;
    	        }
            }
        }
    	mode.compress();
    	return mode;
    }
    
    public Vector getMode(){
    	return modes;
    }
    
    public int getFreq(){
    	return freq;
    }
    
    public int getNModes(){
    	return nModes;
    }
    
    public String toString(){
    	String modeString = "{";
    	for(int i=0;i<modes.length();i++){
    		modeString = modeString + modes.get(i);
    		if(i == modes.length()-1)
    			modeString = modeString + "}";
    		else
    			modeString = modeString +", ";
    	}
    	return "(" + nModes + ", " + freq + ", " + modeString + "}";
    }
}
