public class Card
{
	public int cardValue;
	public char cardSuit;
	
	public Card(int cardValue , char cardSuit)
	{
		this.cardValue = cardValue;
		this.cardSuit = cardSuit;
	}	
	
	@Override
	public String toString()
	{		
		return cardValue + "" + cardSuit;	
	}
	
}