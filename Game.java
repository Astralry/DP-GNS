
public class Game {

	public static void main(String[] args) {
		
		Deck d1 = new Deck();
		d1.populate();
		//System.out.println(d1.printDeck());
		d1.shuffle();
		/*for (int i=0; i<52;i++) {
		System.out.println(d1.getCard(i));
		}*/
		
		Deal G = new Deal(d1);
		G.deal();
		for (int i=0; i<15; i++) {
			for (int j=0; j<7;j++) {
				Card a = G.get(i, j);
				if (a!=null) {
					System.out.println(a);
				}
			}
			System.out.println();
		}

	}

}
