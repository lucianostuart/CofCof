import java.util.LinkedList;
import java.util.Scanner;

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
					System.out.println("Subject you want ");
					String n = scan.nextLine();
					for (int i = 0; i < subjectList.size(); i++) {
						if (subjectList.get(i).subjectName.equals(n)) {	
							System.out.println("Are you sure you want to remove " + subjectList.get(i).subjectName + "? y/N");
							answ = scan.next();
							
							if (answ.toLowerCase().equals("n") || answ.toLowerCase().equals("\n")) {
								System.out.println("Not REMOVED");
							} else if (answ.toLowerCase().equals("y")) {
								System.out.println("REMOVED " + subjectList.get(i).subjectName);
								subjectList.remove(i);
							} else {
								break;
							}
						}
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
}
