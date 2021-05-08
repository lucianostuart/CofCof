import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		boolean goOn = true;
		LinkedList<Subjects> subjectList = new LinkedList<Subjects>();
		Scanner scan = new Scanner(System.in);
		String answ = "n";

		do {
	       	System.out.print("\033[H\033[2J");
			System.out.println("GPA calculator for IMFS students\n");
			System.out.println("1 - Add subject");
			System.out.println("2 - Remove subject");
			System.out.println("3 - Edit subject");
			System.out.println("4 - Calculate your GPA now!");
			System.out.println("0 - Exit");
			while (!scan.hasNextInt()) {
				System.out.println("Invalid input!");
				scan.nextLine();
    		}
			int tmp = scan.nextInt();

			switch(tmp) {
				case 1:
					subjectList.add(addSubject());
					break;

				case 2:
					Integer[] toRemove = rmSubject(subjectList);
        			Arrays.sort(toRemove, Collections.reverseOrder());

					for(int i = 0; i < toRemove.length; i++) {
						subjectList.remove((int)toRemove[i]);
					}

					break;

				case 3:

					break;

				case 4:

					break;

				case 0:
					goOn = false;
					break;
			}
		} while(goOn);
		
		scan.close();
	}
	
	public static Subjects addSubject() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\033[H\033[2J");
		System.out.println("Add subject\n");
		
		System.out.print("Inform the name of the subject: ");
		String nameSubject = scan.nextLine();
		
		System.out.print("Inform its semester: ");
		while (!scan.hasNextInt()) {
			System.out.println("Invalid input!");
			scan.nextLine();
		}
		int semester = scan.nextInt();
		
		System.out.print("Inform its workload: ");
		while (!scan.hasNextInt()) {
			System.out.println("Invalid input!");
			scan.nextLine();
		}
		int workload = scan.nextInt();
		
		System.out.print("Inform your grade: ");
		while (!scan.hasNextDouble()) {
			System.out.println("Invalid input!");
			scan.nextLine();
		}
		double grade = scan.nextDouble();

		return new Subjects(nameSubject, workload, grade, semester);
	}

	public static Integer[] rmSubject(LinkedList<Subjects> subjectList) {
		Scanner scan = new Scanner(System.in);

		System.out.print("\033[H\033[2J");
		System.out.println("Subject list\n");

		for(int i = 0; i < subjectList.size(); i++) {
			System.out.print("[" + i + "]: ");
			System.out.println(subjectList.get(i).subjectName);
		}

		System.out.print("How many subjects would you like to remove:: ");
		while (!scan.hasNextInt()) {
			System.out.println("Invalid input!");
			scan.nextLine();
		}
		int nRemove = scan.nextInt();

		if(nRemove < 0 || nRemove > subjectList.size()) {
			nRemove = 0;
		}

		Integer[] toRemove = new Integer[nRemove];

		System.out.print("Inform the numbers of the subjects you would like to remove:: ");
		for(int i = 0; i < nRemove; i++) {
			while (!scan.hasNextInt()) {
				System.out.println("Invalid input!");
				scan.nextLine();
			}
			toRemove[i] = scan.nextInt();
		}

		return toRemove;
	}
}
