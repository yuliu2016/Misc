import java.lang.*;
import java.util.ArrayList;

class Main{
	public static void main(String args[]){
		Deck d=new Deck();
		ArrayList<Card> h1=new ArrayList<Card>();
		ArrayList<Card> h2=new ArrayList<Card>();
		boolean hand1=true;
		int i;

		for(i=0;i<10;i++){
			if(hand1){
				h1.add(d.getTopCard());
			}else{
				h2.add(d.getTopCard());
			}
			hand1=!hand1;
		}
		int h1p=0;
		int h2p=0;
		for(Card j:h1)h1p+=j.pointValue();
		for(Card k:h2)h2p+=k.pointValue();
		boolean hand1win=(h1p>h2p)?true:false;

		System.out.println("Hand 1: total points "+h1p);
		for(Card ii:h1)System.out.println(ii);
		System.out.println("\nHand 2: total points "+h2p);
		for(Card ij:h2)System.out.println(ij);

		if(hand1win){
			System.out.println("\nHand 1 wins");
		}
		else{
			System.out.println("\nHand 2 wins");
		}
	}
}