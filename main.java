import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		System.out.println(greedy(new int[]{1,1,1,3,1}));
	}
	
    public static int greedy(int[] dice){
        int[] trippleScores = new int[]{1000, 200, 300, 400, 500, 600};
        int score = 0;
        for ( byte i = 0; i < dice.length; i++ ) {
            final int currentDiceValue = dice[i]; 
            byte times = (byte) Arrays.stream(dice).filter(d -> d == currentDiceValue).count();
            if ( times >= 3 && dice[i] != 0) {
                System.out.println(dice[i]);
                score += trippleScores[currentDiceValue - 1];
                byte tripple = 0;
                for (byte x = 0; x < dice.length; x++) {
                    if (dice[x] == currentDiceValue && tripple < 3) {
                        dice[x] = 0;
                        tripple++;
                    }
                }
  
            } else {
                 if ( dice[i] == 1 ) {
                     score += 100;
                 } else if ( dice[i] == 5 ) {
                     score += 50;
                 }
            }
            System.out.println(dice);
        }
        return score;
    }	
}
