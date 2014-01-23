import java.util.Comparator;


public class Comparators{
	 Comparator<Card> Card = new Comparator<Card>()
			{
		@Override
		public int compare(Card a, Card b) {
				return Integer.compare(a.cardValue, b.cardValue);
			}
	
		};
		
	Comparator<Pair> Pair = new Comparator<Pair>()
			{
			@Override
			public int compare(Pair a, Pair b) {
					return Integer.compare(a.value.size(), b.value.size());
				}
		
			};
}
