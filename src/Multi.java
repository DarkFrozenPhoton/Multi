import java.util.Random;
import java.util.Scanner;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

class Multi {
	public static void main(String[] args)
						throws FileNotFoundException {
		Scanner keyboard = new Scanner (System.in);
		String yes = "y";
		int failed = 0, played = 0, input = 0, lose = 0, win = 0;
		long start = System.currentTimeMillis();
		while (played < 10 && failed < 3){
			failed = 0;
			Random rand = new Random();
			int nb1 = rand.nextInt(10)+1;
			int nb2 = rand.nextInt(10)+1;
			played++;
			while ( input != nb1 * nb2){
				System.out.print(nb1);
				System.out.print(" x ");
				System.out.println(nb2);
				input = keyboard.nextInt();
				if (input == nb1 * nb2){
					win++;
					System.out.println((char)27 +"[32m Correct !" + (char)27 + "[0m");
					System.out.println("=======\n");
				}
				if (input != nb1 * nb2) {
					failed++;
					if (failed == 1)
						System.out.println((char)27 +"[31m False, try again" + (char)27 + "[0m");
					if (failed == 2) {
						System.out.println((char)27 +"[31m False, Next Round" + (char)27 + "[0m");
						lose++;
						break;
					}
				}
				if (played == 10)
					System.out.println("Results :");
			}
		}
		long time = System.currentTimeMillis() - start;
		System.out.print((char)27 + "[32m" + (char)27 + "[1m\tWon Rounds\t" + (char)27 + "[0m");
		System.out.println(win);
		System.out.print((char)27 + "[31m" + (char)27 + "[1m\tLost Rounds\t" + (char)27 + "[0m");
		System.out.println(lose);
		System.out.print((char)27 + "[34m" + (char)27 + "[1m\tTime\t\t" + (char)27 + "[0m");
		System.out.println(String.format("%d s", time / 1000));
		System.out.print("\nSave Score? [y/n]");
		Scanner keyb = new Scanner (System.in);
		String ans = keyb.nextLine();
		if (yes.equals(ans)) {
			try(FileWriter fw = new FileWriter("Scores.txt", true);
				BufferedWriter	bw	= new BufferedWriter(fw);
				PrintWriter	out	= new PrintWriter(bw))
				{
					out.print("Won Rounds : ");
					out.print(win);
					out.print("\t\t\tLost Rounds : ");
					out.print(lose);
					out.print("\t\t\tTime : ");
					out.println(String.format("%d s", time / 1000));
				} catch (IOException e) {}
			keyb.close();
			keyboard.close();
		}
	}
}
