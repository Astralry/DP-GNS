import java.lang.Math;

public class Deal{
	
	private Deck d;
	private int stack_value;
	
	// Deal in array of card arrays
	public Card[] deal[] = new Card[15][17];
	
	// 15 piles where max cards in any pile is 12 + 5 (initial deal length)
	public Deal(Deck d) {
		this.d = d;
		d.shuffle();
		this.stack_value = d.getCard(0).getRank();
		for (int i = 0; i<15;i++) {
			deal[i] = new Card [17];
		}
	}
	public void deal() {
		
		int c =0;
		
		for (int j=0;j<14;j++) {
			if (c==52) {
				break;
			}
			for (int k=0; k<5; k++) {
				deal[j][k] = d.getCard(c);
				c++;

				if (j<4) {
					break;
				}
				else if (j>11 && k>2) {
					break;
				}

			}
		}
		initializeStack();
	}
	
	public Card get(int a, int b){
		return deal[a][b];
	}
	
	public void place(Card a, Card b) {
		int[] index_a = index(a);
		int[] index_b = index(b);
		index_b[1] +=1;
		while (deal[index_b[0]][index_b[1]]!=null) {
			index_b[1] +=1;
			Card g = deal[index_b[0]][index_b[1]];
			if (g ==null) {
				deal[index_b[0]][index_b[1]] = a;
				break;
			}
		}
		while (deal[index_a[0]][index_a[1]]!=null) {
			deal[index_a[0]][index_a[1]] = deal[index_a[0]][index_a[1]+1];
		}
	}
	
	public void initializeStack() {
		for (int i=0;i<4;i++) {
			Card switch_card = deal[i][0];
			Card stack_card = new Card(this.stack_value,suitMap(i));
			int[] index_st = index(stack_card);
			deal[i][0] = stack_card;
			deal[index_st[0]][index_st[1]] = switch_card;
		}
	}
	//is card in the stack be 
	public boolean is_stack (Card card) {
		int[] index = index(card);
		if (index[0]<4) {
			return true;
		}
		return false;
	}
	
	//Use to establish if card can be moved 
	public boolean is_moveable(Card moving, Card pile) {
		boolean same_suit = (moving.getSuit() == pile.getSuit());
		boolean stackable = (Math.abs(moving.getRank()-pile.getRank()) == 1 || Math.abs(moving.getRank()-pile.getRank()) ==12);
		if ( same_suit && stackable) {
			return true;
		}
		return false;
	}
	public Suit suitMap(int a) {
		int i =0;
		Suit s = Suit.CLUBS;
		for (Suit suit: Suit.values()){
			if (a==i) {
				return suit;
			}
			i++;
		}
		return s;
	}
	
	public int[] index (Card card) {
		int[] index = {0,0};
		for (int i=0; i<15;i++) {
			for (int j=0; j<17;j++) {
				if (deal[i][j] == card) {
					index[0] = i;
					index[1] = j;
					return index;
				}
				else if(deal[i][j] == null) {
					break;
				}
			}
		}
		return index;
	}
	
}
