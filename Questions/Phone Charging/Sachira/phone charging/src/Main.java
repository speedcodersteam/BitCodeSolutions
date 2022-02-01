import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<String> input=new ArrayList<String>();
	static int hours=0;
	static int minute=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		String in="";
		while(!(in.equalsIgnoreCase("e"))) {
			
			in=sc.nextLine();
			input.add(in);
		}
		input.remove("e");
		for(int x=0;x<input.size();x++) {
			hours=0;
			minute=0;
			if(input.get(x).split(" ").length!=3) {
				System.out.println(" ");
				
			}else {
				try {
					double precentage=returnPrecentage(x);
					double years=returnYears(x);
					double voltage=returnvoltage(x);
					if(precentage>=0.0&&precentage<=100.0) {
						if(voltage==1.0 || voltage==1.5) {
							if(precentage<=40.0) {
								hours+=2;
							}
							else if(precentage>40.0&&precentage<=60.0) {
								hours+=1;
							}
							else if(precentage>60.0&&precentage<=100.0) {
								minute+=30;
							}
							if(years>=2.0) {
								hours+=1;
							}
							else {
								minute+=30;
							}
							if(voltage==1.0) {
								hours+=1;
							}
							else {
								minute+=30;
							}
							
							if(minute>30) {
								int newhours=minute/60;
								hours+=newhours;
								minute=minute-newhours*60;
								
							}
							if(minute==0) {
								System.out.println(hours+" hours");
							}
							else {
								System.out.println(hours+" hours and "+minute+" minutes");
							}
							
							
							
						}
						else {
							
							System.out.println(" ");
						}
					}
					else {
						System.out.println(" ");
					}
				}
				catch(Exception e) {
					System.out.println(" ");
				}
			}
		}

	}
	public static double returnPrecentage(int index) {
		
		return Double.parseDouble(input.get(index).split(" ")[0].split("%")[0]);
	}
	public static double returnYears(int index) {
		
		return Double.parseDouble(input.get(index).split(" ")[1].split("[years][year]")[0]);
	}
	public static double returnvoltage(int index) {
		
		return Double.parseDouble(input.get(index).split(" ")[2].split("[vV]")[0]);
	}
}
