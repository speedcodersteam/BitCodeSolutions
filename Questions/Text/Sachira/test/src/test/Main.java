package test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<String> likes=new ArrayList<String>();
		ArrayList<String> dislikes=new ArrayList<String>();		
		Scanner inputs=new Scanner(System.in);
		System.out.println("[?]Enter NUmber Of Clients :");
		int clients=inputs.nextInt();
		inputs.nextLine();
		for(int x=0;x<clients;x++) {
			System.out.print("[?]Likes For Client "+(x+1)+" :");
			String lik=inputs.nextLine();
			likes.add(lik.trim());
			System.out.print("[?]DisLikes For Client "+(x+1)+" :");
			String dis=inputs.nextLine();
			dislikes.add(dis.trim());	
		}
		
		
		int[] numberOfLikes=new int[clients];
		int[] numberOfDislikes=new int[clients];
		
		for(int x=0;x<clients;x++) {
			numberOfLikes[x]=Integer.parseInt(likes.get(x).split(" ",3)[0]);
			numberOfDislikes[x]=Integer.parseInt(dislikes.get(x).split(" ",3)[0]);	
		}
		
		String[][] separatedLikes=new String[clients][5];
		String[][] separatedDisLikes=new String[clients][5];
		
		HashSet<String> likesSet=new HashSet();
		HashSet<String> disLikesSet=new HashSet();
		
		for(int x=0;x<clients;x++) {
			
			for(int i=0;i<numberOfLikes[x];i++) {
				separatedLikes[x][i]=likes.get(x).split(" ",6)[i+1];
			}
			
			
			for(int i=0;i<numberOfDislikes[x];i++) {
				separatedDisLikes[x][i]=dislikes.get(x).split(" ",6)[i+1];
			}
		}
		
		for(int x=0;x<clients;x++) {
			for(String i:separatedLikes[x]) {
				likesSet.add(i);
			} 
			
			for(String i:separatedDisLikes[x]) {
				disLikesSet.add(i);
			}
			
			
		}
		
		for(int x=0;x<disLikesSet.size();x++) {
			for(String i:disLikesSet) {
				likesSet.remove(i);
			}
			
		}
		
		System.out.print(likesSet.size()+" ");
		for(String i:likesSet) {
			System.out.print(i+" ");
		}

	}
	


}
