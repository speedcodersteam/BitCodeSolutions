import java.util.*;
public class Main {

	public static void main(String[] args) {
		double rateDouble = 0,valuation=0;
		
		
		Scanner sv=new Scanner(System.in);
		System.out.print("[?]Enter Tax Rate :");
		String rate=sv.nextLine();
		try {
			rateDouble=Double.parseDouble(rate.split("%")[0]);
			if(3<=rateDouble && rateDouble<=10) {
				valuation=(2000*100)/rateDouble;
				System.out.printf("Anual Valuation Is :%.2f",valuation);
				
			}
			else {
				System.out.println("[-]Error :Rate Range Is Not Valied!");
			}
		}
		catch(Exception e) {
			System.out.println("[-]Error :Input Type Is Not Valied!");
		}
		


	}

}
