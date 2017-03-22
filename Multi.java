import java.util.Random;
import java.util.Scanner;
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
		while (played < 10 && failed < 3){
			failed = 0;
			Random rand = new Random();
			int nb1 = rand.nextInt(10)+1;
			int nb2 = rand.nextInt(10)+1;
			played++;
			while ( input != nb1 * nb2){
				System.out.print(nb1);
				System.out.print("x");
				System.out.print(nb2);
				System.out.println();
				input = keyboard.nextInt();
				if (input == nb1 * nb2){
					win++;
					System.out.println("Correct");
					System.out.println("=======\n");
					if (played == 10)
						System.out.println("Results");
				}
				if (input != nb1 * nb2) {
					failed++;
					if (failed == 1)
						System.out.println("False, try again");
					if (failed == 2) {
						System.out.println("False, Next Round");
						break;
					}
				}
			}
		}
		System.out.print("Won Rounds : ");
		System.out.print(win);
		System.out.print("\nLost Rounds : ");
		System.out.print(lose);
		System.out.print("\n Save Score? [y/n]");
		Scanner keyb = new Scanner (System.in);		// TODO avoid creation of a second keyboard
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
					out.print("\n");
				} catch (IOException e) {}
			keyb.close();
			keyboard.close();
		}
	}
}
