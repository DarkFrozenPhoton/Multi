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
		Scanner keyboard=new Scanner (System.in);
		String yes = "y";
		int ndte, ndm, a, mp, mg;
		ndm = 0;
		ndte = 0;
		a = 0;
		mp = 0;
		mg = 0;
		while (ndm < 10 && ndte < 3){
			ndte =0;
			Random r = new Random();
			int b = r.nextInt(10)+1;
			int p = r.nextInt(10)+1;
			ndm=ndm+1;
			while (a!=b*p){
				System.out.print(b);
				System.out.print("x");
				System.out.print(p);
				System.out.println();
				a=keyboard.nextInt(); 
				if (a==b*p){
					mg = mg+1;
					System.out.println("Correct");
					System.out.println("============================================================================");
					if (ndm==10){
						System.out.println("Results");
					}
				}
				if (a!=b*p){
					ndte=ndte+1;
					if (ndte == 1){
						System.out.println("False, try again");
					}
					if (ndte == 2){
						System.out.println("False, Next Round");
						break;
					}
				}
			}
		}
		System.out.print("Won Rounds : ");
		System.out.print(mg);
		System.out.print("\nLost Rounds : ");
		System.out.print(mp);
		System.out.print("\n Save Score? [y/n]");
		Scanner keyb=new Scanner (System.in);
		String z=keyb.nextLine();
		if (yes.equals(z)){
			try(FileWriter fw = new FileWriter("Scores.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.print("Won Rounds : ");
				    out.print(mg);
					out.print("			Lost Rounds : ");
					out.print(mp);
					out.print("\n");
				} catch (IOException e) {
		}
		keyb.close();
		keyboard.close();
	}
}
}