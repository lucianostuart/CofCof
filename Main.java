/*Código phoda */
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;


public class Main {
	static LinkedList<Subjects> subjectList = new LinkedList<Subjects>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean goOn = true;
		String answ = "n";
		String n;

		do {
	       	System.out.print("\033[H\033[2J");
			System.out.println("GPA calculator for IMFS students\n");
			System.out.println("1 - Add subject");
			System.out.println("2 - Remove subject");
			System.out.println("3 - Edit subject");
			System.out.println("4 - Calculate your GPA now!");
			System.out.println("5 - List all subjects");
			System.out.println("6 - Save/Load");
			System.out.println("0 - Exit");
			System.out.print(":: ");
			while (!scan.hasNextInt()) {
				System.out.println("Invalid input!");
				scan.nextLine();
    		}
			int tmp = scan.nextInt();

			switch(tmp) {
				case 1:
					addSubject();
					break;

				case 2:
					scan.nextLine();

					System.out.print("\033[H\033[2J");

					System.out.println("Remove subject");
					System.out.println("Which subject you'd like to remove?");

					n = scan.nextLine();
					for (int i = 0; i < subjectList.size(); i++) {
						if (subjectList.get(i).subjectName.toLowerCase().equals(n.toLowerCase())) {
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

					System.out.println("Edit Subject");
					System.out.println("Please inform which subject you'd like to edit:");
					n = scan.nextLine();
					
					for (int i = 0; i < subjectList.size(); i++) {
						if (subjectList.get(i).subjectName.toLowerCase().equals(n)) {	
							System.out.println("\nAre you sure you want to edit " + subjectList.get(i).subjectName + "? y/n");
							answ = scan.nextLine();
							
							if (answ.toLowerCase().equals("n") || answ.toLowerCase().equals("\n")) {
								System.out.println("\nNot edited");
								scan.nextLine();
								break;
							} else if (answ.toLowerCase().equals("y")) {
								System.out.println("\nInform what you'd like to edit:");
								System.out.println("1 - Name");
								System.out.println("2 - Workload");
								System.out.println("3 - Grade");
								System.out.println("4 - Semester");
								System.out.print(":: ");
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
								scan.nextLine();
								break;
							} else {
								System.out.println("\nImpossible to edit " + subjectList.get(i).subjectName);
								scan.nextLine();
								break;
							}
						}
					}
					break;

				case 4:
					System.out.println("Your GPA is " + calculateGPA() + " :)");

					scan.nextLine();
					scan.nextLine();
					break;

				case 5:
					for (int i = 0; i < subjectList.size(); i++) {
						System.out.print(subjectList.get(i).subjectName + " ");	
						System.out.print(subjectList.get(i).semester + " ");	
						System.out.print(subjectList.get(i).workLoad + " ");	
						System.out.println(subjectList.get(i).grade);	
					}
					scan.nextLine();
					scan.nextLine();
					break;

				case 6:
					scan.nextLine();

					System.out.print("\033[H\033[2J");
					System.out.println("Choose an option:");
					System.out.println("1 - Save current list of subjects");
					System.out.println("2 - Load a list");
					System.out.print(":: ");

					while (!scan.hasNextInt()) {
						System.out.println("Invalid input!");
						scan.nextLine();
					}
					tmp = scan.nextInt();
					
					switch(tmp) {
						case 1:
							salvarArquivo(subjectList);
							break;

						case 2:
							subjectList = new LinkedList<Subjects>(carregarArquivo());
							break;
					}


					break;

				case 0:
					goOn = false;
					break;
			}
		} while(goOn);
		
		scan.close();
	}
	
	public static void addSubject() {
		scan.nextLine();
		
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
		
		subjectList.add(new Subjects(nS, semester, workload, grade));
	}

	public static String calculateGPA() {
		double cr = 0;
		double wl = 0;
		DecimalFormat df = new DecimalFormat("0.00000");

		for (int i = 0; i < subjectList.size(); i++) {
			cr += subjectList.get(i).calculateAvg();
			wl += subjectList.get(i).workLoad;	
		}

		return df.format((cr / wl) / 10);
	}

	public static void salvarArquivo(LinkedList<Subjects> subjectList) {
		try {
            File file = new File("test.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Subjects s : subjectList) {
				bw.write("\"" + s.subjectName + "\",");
				bw.write("\"" + String.valueOf(s.semester) + "\",");
				bw.write("\"" + String.valueOf(s.workLoad) + "\",");
				bw.write("\"" + String.valueOf(s.grade) + "\",\n");
			}
            bw.flush();
            bw.close();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
			
            br.close();
			
		} catch(IOException e) {
			System.out.println("An error occured!");
		}

		
	}

	public static LinkedList<Subjects> carregarArquivo() {
		LinkedList<Subjects> holderList = new LinkedList<Subjects>();

		try {
			File file = new File("test.txt");
            file.createNewFile();
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
			String h1;
			while((h1 = br.readLine()) != null) {
				String[] h2 = h1.split("\",(\")*");
				Subjects Sub = new Subjects(h2[0].replaceAll("\"", ""), Integer.parseInt(h2[1]), Integer.parseInt(h2[2]), Double.parseDouble(h2[3]));
				holderList.add(Sub);
			}
			
            br.close();
			
		} catch(IOException e) {
			System.out.println("An error occured!");
		}

		return holderList;
	}
}
