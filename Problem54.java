import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public  class Problem54 
{
	
	public static ArrayList<Card> createHand(String aHand)
	{
		String[] tokens = aHand.split(" ");		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		for (int i = 0 ; i < tokens.length; i++)
		{
			int value = 0;
			char suit = 'S';
			char charValue = tokens[i].charAt(0);
			if (charValue == 'K')
			{
				value = 13;
			}
			else if (charValue == 'Q')
			{
				value = 12;
			}
			else if (charValue == 'J')
			{
				value = 11;
			}
			else if (charValue == 'A')
			{
				value = 14;
			}
			else if (charValue == 'T')
			{
				value = 10;
			}
			else
			{
				value = Integer.parseInt(charValue + "");
			}
			
			cards.add(new Card(value, tokens[i].charAt(1)));
		}
		
		Collections.sort(cards, new Comparators().Card);		
		
		return cards;
	}	
	
	public static boolean isFourOfAKind(ArrayList<Card> h1)
	{
		if ((h1.get(0).cardValue == h1.get(1).cardValue && h1.get(1).cardValue == h1.get(2).cardValue && h1.get(2).cardValue == h1.get(3).cardValue) || 
	    		(h1.get(1).cardValue == h1.get(2).cardValue && h1.get(2).cardValue == h1.get(3).cardValue && h1.get(3).cardValue == h1.get(4).cardValue))	
	    {
			return true;
	    }
		return false;
	}
	
	public static boolean isFullHouse(ArrayList<Card> h1)
	{
	   if ((h1.get(0).cardValue == h1.get(1).cardValue && h1.get(2).cardValue == h1.get(3).cardValue && h1.get(3).cardValue == h1.get(4).cardValue) || 
		    		(h1.get(0).cardValue == h1.get(1).cardValue && h1.get(1).cardValue == h1.get(2).cardValue && h1.get(3).cardValue == h1.get(4).cardValue))	
	    {
		   return true;
	    }
	   return false;
	}
	
	public static boolean isThreeOfAKind(ArrayList<Card> h1)
	{
	  if (h1.get(0).cardValue == h1.get(1).cardValue && h1.get(1).cardValue == h1.get(2).cardValue ||
    	  h1.get(1).cardValue == h1.get(2).cardValue && h1.get(2).cardValue == h1.get(3).cardValue ||
	      h1.get(2).cardValue == h1.get(3).cardValue && h1.get(3).cardValue == h1.get(4).cardValue)
	    {
		  return true;
	    }
	  return false;
	}
	
	public static boolean isTwoPair(ArrayList<Card> h1)
	{
		 if (h1.get(0).cardValue == h1.get(1).cardValue && h1.get(2).cardValue == h1.get(3).cardValue ||
    		h1.get(0).cardValue == h1.get(1).cardValue && h1.get(3).cardValue == h1.get(4).cardValue ||
    		h1.get(1).cardValue == h1.get(2).cardValue && h1.get(3).cardValue == h1.get(4).cardValue ||
 		    h1.get(0).cardValue == h1.get(1).cardValue && h1.get(2).cardValue == h1.get(3).cardValue)
		    {
			 	return true;
		    }	
		 return false;
	}
	
	public static boolean isPair(ArrayList<Card> h1)
	{
		   if (h1.get(0).cardValue == h1.get(1).cardValue  ||
	    		h1.get(1).cardValue == h1.get(2).cardValue ||
				h1.get(2).cardValue == h1.get(3).cardValue ||
				h1.get(3).cardValue == h1.get(4).cardValue)
		    {
		    	return true;
		    }
		   return false;
	}
	
	public static int largestPairValue(ArrayList<Card> h1)
	{
		
		int numberOfMatches = 0;
		int largestNumberOfMatches = 0;
		int largestValue = 0;
		
		for (int i = h1.size() - 1 ; i >= 1; i--)
		{
			if (h1.get(i).cardValue == h1.get(i-1).cardValue)
			{
				numberOfMatches++;							
				if (largestNumberOfMatches < numberOfMatches)
				{
					largestValue = h1.get(i).cardValue;
					largestNumberOfMatches = numberOfMatches;
				}
			}
			else
			{
				numberOfMatches = 0;
			}
			
		}
		return largestValue;
	}
	
	public static int getHighCard(ArrayList<Card> h1)
	{
		return h1.get(h1.size() - 1).cardValue;
	}
	
	public static void cleanUpHands(ArrayList<Card> h1 , ArrayList<Card> h2)
	{
		ArrayList<Card> newHand = new ArrayList<Card>();
		for (int i = 0 ; i < h1.size(); i++)
		{
			if (h1.get(i).cardValue != largestPairValue(h1))
				newHand.add(h1.get(i));						
		}
		h1 = newHand;
		
		newHand = new ArrayList<Card>();		
		for (int i = 0 ; i < h2.size(); i++)
		{
			if (h2.get(i).cardValue != largestPairValue(h2))
				newHand.add(h2.get(i));					
		}
		h2 = newHand;
	}
	public static boolean isFlush(ArrayList<Card> h1)
	{
		boolean sameSuit = true;
		char currentSuit = 0;
		for (int i = 0 ; i < h1.size(); i++)
		{
					
			if (i != 0 && currentSuit != h1.get(i).cardSuit)
			{
				sameSuit = false;
			}
			
		}
		return sameSuit;
	}
	
	public static boolean isStraightFlush(ArrayList<Card> h1)
	{		
		if (isFlush(h1) && isStraight(h1))
			return true;		
		return false;
	}
	
	public static boolean isStraight(ArrayList<Card> h1)
	{
		for (int i = 1 ; i < h1.size(); i++)
		{
			if (h1.get(i).cardValue - h1.get(i-1).cardValue != 1)
				return false;
		}
		return true;
	}
	
	public static boolean isRoyalFlush(ArrayList<Card> h1)
	{
		
		boolean highStraight = false;
		//Check for High Straight
		if (h1.get(0).cardValue == 1 && h1.get(0).cardValue == 10 && h1.get(0).cardValue == 11 && h1.get(0).cardValue == 12 && h1.get(0).cardValue == 13)
				highStraight = true;
				// Check for Straight		
	
		if (highStraight && isFlush(h1))
			return true;
		return false;
	}
	
	public static int evaluateHand(ArrayList<Card> h1, ArrayList<Card> h2)
	{
		int h1Rank = getRankOfHand(h1);
		int h2Rank = getRankOfHand(h2);
		
		if (h1Rank > h2Rank)
			return 1;
		else if (h2Rank > h1Rank)
			return 2;
		else
		{
			if (isRoyalFlush(h1))
			{
				return 0;
			}
			else if (isStraightFlush(h1) || isStraight(h1))
			{
				if (getHighCard(h1) > getHighCard(h2))
					return 1;
				else if (getHighCard(h1) < getHighCard(h2))
					return 2;
				else 
				{
					return 0;
				}
			}
			else if (isFourOfAKind(h1) || isFullHouse(h1) || isThreeOfAKind(h1))
			{
				if (largestPairValue(h1) > largestPairValue(h2))
					return 1;
				else if (largestPairValue(h1) < largestPairValue(h2))
					return 2;				
			}
			else if (isTwoPair(h1))
			{
				if (largestPairValue(h1) > largestPairValue(h2))
					return 1;
				else if (largestPairValue(h2) > largestPairValue(h1))
					return 2;
				else 
				{													
					cleanUpHands(h1, h2);
					if (largestPairValue(h1) > largestPairValue(h2))
						return 1;
					else if (largestPairValue(h2) > largestPairValue(h1))
						return 2;
					cleanUpHands(h1, h2);
				}
			}
			else if (isPair(h1))
			{
				if (largestPairValue(h1) > largestPairValue(h2))
					return 1;
				else if (largestPairValue(h2) > largestPairValue(h1))
					return 2;
				
				cleanUpHands(h1,h2);
			}
			
			while (h1.size() > 0)
			{
				if (getHighCard(h1) > getHighCard(h2))
					return 1;
				else if (getHighCard(h2) > getHighCard(h1))			
					return 2;
				
				h1.remove(h1.size() - 1);
				h2.remove(h2.size() - 1);
			}
			return 0;
		}
		
		
	}
	
	public static int getRankOfHand(ArrayList<Card> h1)
	{
		if (isRoyalFlush(h1))
			return 10;
		else if (isStraightFlush(h1))
			return 9;
		else if (isFourOfAKind(h1))
			return 8;
		else if (isFullHouse(h1))
			return 7;
		else if (isFlush(h1))
			return 6;
		else if (isStraight(h1))
			return 5;
		else if (isThreeOfAKind(h1))
			return 4;
		else if (isTwoPair(h1))
			return 3;
		else if (isPair(h1))
			return 2;
		
		return 1;
	}
	
	public static void main (String[] args) throws IOException
	{
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("I:\\Project Euler Workspace\\Problem26\\src\\poker.txt"));
			int counter = 0;
			while (br.ready())
			{
				String readLine = br.readLine();
				
				String firstHand = readLine.substring(0, readLine.length() / 2);
				String secondHand = readLine.substring(readLine.length() /2 + 1, readLine.length());
				
				ArrayList<Card> cardsa = createHand(firstHand);
				ArrayList<Card> cardsb = createHand(secondHand);	
				
				System.out.println(cardsa + " " + cardsb);
				System.out.println(evaluateHand(cardsa, cardsb));
				
				if (evaluateHand(cardsa, cardsb) == 1)
				{
					counter++;
				}
				
			}
		
			System.out.println(counter);
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
	
	

