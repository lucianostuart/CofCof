/*Código phoda */
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean goOn = true;
		LinkedList<Subjects> subjectList = new LinkedList<Subjects>();
		Scanner scan = new Scanner(System.in);
		String answ = "n";
		String n;

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
					scan.nextLine();

					System.out.println("Remove subject");
					System.out.println("Which subject you'd like to remove?");

					n = scan.nextLine();
					for (int i = 0; i < subjectList.size(); i++) {
						if (subjectList.get(i).subjectName.toLowerCase().equals(n)) {
							System.out.println(subjectList.get(i).subjectName + " will be removed. You sure? (y/N)"+ "\n Fo' shizzle my nizzle");
							answ = scan.next();

							if (answ.toLowerCase().equals("y")) {
								subjectList.remove(i);
							} else {
								break;
							}
						}
					}
					break;

				case 3:
					scan.nextLine();

					System.out.print("\033[H\033[2J");
					
					System.out.println("Please inform which subject you'd like to edit:");
					
					n = scan.nextLine();
					
					for (int i = 0; i < subjectList.size(); i++) {
						if (subjectList.get(i).subjectName.equals(n)) {	
							System.out.println("\nAre you sure you want to edit " + subjectList.get(i).subjectName + "? y/n");
							answ = scan.next();
							
							if (answ.toLowerCase().equals("n") || answ.toLowerCase().equals("\n")) {
								System.out.println("\nNot edited");
								scan.next();
								break;
							} else if (answ.toLowerCase().equals("y")) {
								System.out.println("\nInform what you'd like to edit:");
								System.out.println("1- Name");
								System.out.println("2- Workload");
								System.out.println("3- Grade");
								System.out.println("4- Semester");
								tmp = scan.nextInt();
								scan.nextLine();
								
								switch(tmp) {
									case 1:
										System.out.println("\nInform the new name for the subject:");
										subjectList.get(i).subjectName = scan.nextLine();
										break;

									case 2:
										System.out.println("\nInform the new workload for the subject:");
										subjectList.get(i).workLoad = scan.nextInt();
										break;

									case 3:
										System.out.println("\nInform the new grade for the subject:");
										subjectList.get(i).grade = scan.nextDouble();
										break;

									case 4:
										System.out.println("\nInform the new semester for the subject:");
										subjectList.get(i).semester = scan.nextInt();
										break;

									default:
										System.out.println("\nbip bup bip?");
										break;
								}

								System.out.println("\nEDITED " + subjectList.get(i).subjectName);
								scan.next();
								break;
							} else {
								System.out.println("\nImpossible to edit " + subjectList.get(i).subjectName);
								scan.next();
								break;
							}
						}
					}
					break;

				case 4:

					break;

				case 5:
					for (int i = 0; i < subjectList.size(); i++) {
						System.out.println(subjectList.get(i).subjectName);	
					}
					scan.nextLine();
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
		String nS = scan.nextLine();
		
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
		
		return new Subjects(nS, workload, grade, semester);
	}
}
