/**
 * @(#)CardStack.java
 *
 *
 * @author 
 * @version 1.00 2015/5/12
 */

import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

public class CardGenerator extends Stack<Card> {
	
	private int size; //size of one dimension of the space
	private Random generator;
    private char[] cardSymbols;
    private ArrayList<Coordinate> cordSpace;
    private Iterator<Coordinate> spaceIter;

    public CardGenerator(int size, char[] symbols) {
    	super();
    	this.size = size;
        cardSymbols = symbols;
    	generator = new Random();
        cordSpace = new ArrayList(Utility.pow(size,2));
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                cordSpace.add(new Coordinate(x+1,y+1));
            }
        }
    	fillStack();
    }
    
    public void fillStack(){
        Collections.shuffle(cordSpace, new Random(System.nanoTime()));
        spaceIter = cordSpace.iterator(); 
    	ArrayList<Character> temp = new ArrayList(Utility.pow(size,2)/2);
    	Card card;
    	for(int i=0;i<size*size/2;i++){
    		card = getRandCard();
    		push(card);
    		temp.add(card.getData());
    	}
    	for(int i=0;i<size*size/2;i++){
    		push(new Card(spaceIter.next(),temp.get(i)));
    	}
    }

    public void setSpace(int size){
        this.size = size;
        cordSpace = new ArrayList(Utility.pow(size,2));
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                cordSpace.add(new Coordinate(x+1,y+1));
            }
        }
    }
    
    public Card getRandCard(){
        Coordinate randCord = spaceIter.next();
        char randSymbol = cardSymbols[generator.nextInt(cardSymbols.length)];
        return new Card(randCord, randSymbol);
    }
}

