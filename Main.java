import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean rodar = true;
		LinkedList<Subject> subjectList = new LinkedList<Subject>();
		Scanner scan = new Scanner(System.in);

		while(rodar) {
	       	System.out.print("\033[H\033[2J");
			System.out.println("GPA calculator for IMFS students\n");
			System.out.println("1- Add subject");
			System.out.println("2- Remove subject");
			System.out.println("3- Edit subject");
			System.out.println("4- Calculate your GPA now!");
			System.out.print(":: ");
			while (!scan.hasNextInt()) {
      				System.out.println("Invalid input!");
      				scan.nextLine();
    			}
    			int opcao = scan.nextInt();

			switch(opcao) {
				case(1):
					subjectList.add(addSubject());
					break;

				case(2):

					break;

				case(3):

					break;

				case(4):

					break;

				default:

					break;
			}
		}
		
		scan.close();
	}
	
	public static Subject addSubject() {
		Subject holderSubject;
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
		
		holderSubject = new Subject(nameSubject, semester, workload, grade);
		
		return holderSubject;
	}
}
