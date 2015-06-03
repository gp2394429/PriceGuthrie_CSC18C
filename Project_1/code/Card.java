/**
 * Card.java
 *
 *
 * Author: Guthrie Price
 * Date: 5/18/2015 
 * Purpose: Represents a card for the memory puzzle
 */

public class Card extends CordObj<Character>{

    private boolean hidden; //Used for showing if the card is hidden or not

    public Card(Coordinate cord, Character chr){
        super(cord,chr);
        hidden = true;
    }

    //Returns the cards hidden state
    public boolean isHidden(){
        return hidden;
    }

    //Sets the state of the card to hidden
    public void hide(){
        hidden = true;
    }

    //Sets the state of the card to showing
    public void show(){
        hidden = false;
    }

    //Determines if the symbol in one card matches the symbol of another
    public boolean isEqual(Card card){
        return (getData() == card.getData());
    }
}
