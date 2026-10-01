/*
 * Class: CMSC203 20798
 * Instructor: Prof. Ahmed Tarek
 * Description: 
 * Due: 9/302026
 * Platform/compiler: Java JDK 26
 * I pledge that I have completed the programming assignment 
  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Natnael Teshome
*/
package assignment2;
import java.util.Scanner;
public class PatientDriverApp {

	public static void main(String[] args) {
		
		 Scanner keyboard = new Scanner(System.in);
		 
		 System.out.println("Patient info: ");
		 System.out.println();
		 
		 System.out.print("First Name: ");
		 String firstName = keyboard.nextLine();
		 
		 System.out.print("Middle Name: ");
		 String middleName = keyboard.nextLine();
		 
		 System.out.print("Last Name: ");
		 String lastName = keyboard.nextLine();
		 
		 System.out.print("Address: ");
		 String address = keyboard.nextLine();
		 
		 System.out.print("City: ");
		 String city = keyboard.nextLine();
		 
		 System.out.print("State: ");
		 String state = keyboard.nextLine();
		 
		 System.out.print("Zip Code: ");
		 int zipCode = keyboard.nextInt();
		 keyboard.nextLine();
		 
		 System.out.print("Emergency Name: ");
		 String emergencyName = keyboard.nextLine();
		 
		 System.out.print("Emergency Contact: ");
		 String emergencyCont = keyboard.nextLine();
		 
		 Patient patient = new Patient (firstName, middleName, lastName, address, city, state, zipCode, emergencyName, emergencyCont);
		 
		 System.out.println();
		 System.out.print("\tProcedure: ");
		 String procedureName1 = keyboard.nextLine();
		 System.out.print("\tProcedure Date: ");
		 String procedureDate1 = keyboard.nextLine();
		 System.out.print("\tPractitioner: ");
		 String practitionerName1 = keyboard.nextLine();
		 System.out.print("\tCharges: $");
		 double charge1 = keyboard.nextDouble();
		 keyboard.nextLine();
		 System.out.println();
		 
		 Procedure procedure1 = new Procedure(procedureName1, procedureDate1);
		 procedure1.setPractitionerName(practitionerName1);
		 procedure1.setCharges(charge1);
		 
		 System.out.print("\tProcedure: ");
		 String procedureName2 = keyboard.nextLine();
		 
		 System.out.print("\tProcedure Date: ");
		 String procedureDate2 = keyboard.nextLine();
		 
		 System.out.print("\tPractitioner: ");
		 String practitionerName2 = keyboard.nextLine();
		 
		 System.out.print("\tCharges: $");
		 double charge2 = keyboard.nextDouble();
		 keyboard.nextLine();
		 System.out.println();
		 
		 Procedure procedure2 = new Procedure(procedureName2, procedureDate2, practitionerName2, charge2);
		 
		 System.out.print("\tProcedure: ");
		 String procedureName3 = keyboard.nextLine();
		 System.out.print("\tProcedure Date: ");
		 String procedureDate3 = keyboard.nextLine();
		 System.out.print("\tPractitioner: ");
		 String practitionerName3 = keyboard.nextLine();
		 System.out.print("\tCharges: $");
		 double charge3 = keyboard.nextDouble();
		 keyboard.nextLine();
		 System.out.println();
		 
		 Procedure procedure3 = new Procedure();
		 
		 procedure3.setProcedureName(procedureName3);
		 procedure3.setProcedureDate(procedureDate3);
		 procedure3.setPractitionerName(practitionerName3);
		 procedure3.setCharges(charge3);
		 
		 displayPatient(patient);
		 
		 System.out.println();
		 
		 displayProcedure(procedure1, procedure2, procedure3);
		 
		 double totalCharges = calculateCharges (procedure1, procedure2, procedure3);
		 
		 System.out.printf("Total Charges: $" + totalCharges);
		 
		 System.out.println();
		 System.out.println();
		 
		 System.out.println("Student name: Natnael Teshome");
		 System.out.println("MC#: M21205461" );
		 System.out.println("Due Date: 09/30/2026");
		 System.out.println();
		 

	}
	
	public static void displayPatient(Patient patient) {
		System.out.println(patient);
	}
	
	public static void displayProcedure(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
		
		System.out.println(procedure1);
		System.out.println();
		System.out.println(procedure2);
		System.out.println();
		System.out.println(procedure3);
		System.out.println();
	}
	
	public static double calculateCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
		double total;
		
		total = procedure1.getCharges() + procedure2.getCharges() + procedure3.getCharges();
		
		return total;
	}

}
