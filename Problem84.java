
public class Problem84 
{
	public static int communityChest(int boardSpot)	
	{
		// Community Chest Cards
		int cardPick = (int)(Math.random() * 16.0);
		if (cardPick == 0)
		{
			return 0;
		}
		else if (cardPick == 1)
		{
			return 10;
		}
		return boardSpot;
	}
		
	public static int chanceCard(int boardSpot)
	{
		int cardPick = (int)(Math.random() * 16.0);
		if (cardPick == 0)
		{
			return 0;
		}
		else if (cardPick == 1)
		{
			return 10;
		}
		else if (cardPick == 2)
		{
			return 11;
		}
		else if (cardPick == 3)
		{
			return 24;
		}
		if (cardPick == 4)
		{
			return 39;
		}
		else if (cardPick == 5)
		{
			return 5;
		}
		else if (cardPick == 6 || cardPick == 7)
		{
			if (boardSpot == 7)
				return 15;
			else if (boardSpot == 22)
				return 25;
			else 
				return 5;
		}
		else if (cardPick == 8)
		{
			if (boardSpot == 7 || boardSpot == 36)
			{
				boardSpot = 12;
			}
			else
			{
				boardSpot = 28;
			}
		}
		else if (cardPick == 9)
		{
			return boardSpot - 3;
		}
		return boardSpot;
	}

	public static int boardMove(int numberOfSides, int currentBoardSpot , int[]board)
	{
		int dice1 = (int)(Math.random() * numberOfSides) + 1;
		int dice2 = (int)(Math.random() * numberOfSides) + 1;
				
		int boardSpot = (currentBoardSpot + (dice1 + dice2)) % board.length;
		
		if (dice1 == dice2)
		{
			doublesCount++;
		}
		else
		{
			doublesCount = 0;
		}
		if (doublesCount == 3)
		{
			boardSpot = 10;
			doublesCount = 0;
		}
		
		if (boardSpot == 30)
		{
			boardSpot = 10;
		}				
		
		//Chance Card Space
		if (boardSpot == 7 || boardSpot == 22 || boardSpot == 36)
		{
			boardSpot = chanceCard(boardSpot);
		}
		
		//Community Chest Space
		if (boardSpot == 33 || boardSpot == 2 || boardSpot == 17)
		{
			boardSpot = communityChest(boardSpot);
		}						
		
		
		board[boardSpot]++;
		return boardSpot;
	}
	
	public static int doublesCount = 0;
	
	public static void main (String[] args)
	{
		long starttime = System.currentTimeMillis();
		
		int iterations = 1000000;
		int boardSpot = 0;
		int[] board = new int[40];
		for (int i = 0 ; i < iterations; i++)
		{
			boardSpot = boardMove(4, boardSpot, board);
		}
		double[] probabilities = new double[40];
		for (int i = 0 ; i < 40; i++)
		{
			probabilities[i] =(double)board[i] / (double)iterations;
		}
		
		int largest = 0;
		int secondLargest = 1;
		int thirdLargest = 2;
		for (int i = 0 ; i < 40; i++)
		{
			if (probabilities[largest] < probabilities[i])
			{
				largest = i;				
			}
		}
		for (int i = 0 ; i < 40; i++)
		{
			if (probabilities[secondLargest] < probabilities[i] && probabilities[i] < probabilities[largest])
			{
				secondLargest = i;				
			}
		}
		for (int i = 0 ; i < 40; i++)
		{
			if (probabilities[thirdLargest] < probabilities[i] && probabilities[i] < probabilities[secondLargest])
			{
				thirdLargest = i;				
			}
		}
		System.out.println(largest + " " + secondLargest + " " + thirdLargest);
		System.out.println(System.currentTimeMillis() - starttime);
	}
	
	
}
