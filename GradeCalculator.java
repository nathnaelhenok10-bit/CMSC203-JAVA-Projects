/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: This is a Grade calculator that reads course grading 
 * configuration and student scores, validates all inputs, 
 * computes a final numeric average and letter grade, and 
 * writes a summary report to a file. The program must use Java fundamentals,
 * Scanner for keyboard and file input, decision structures, loops, and
 * input validation.
 * Due: 9/172026
 * Platform/compiler: Java JDK 26
 * I pledge that I have completed the programming assignment 
  independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Natnael Teshome
*/

package cmsc1;
import java.io.*;//Required for File input and output
import java.util.Scanner;//required for File Data input
public class GradeCalculator {
    public static void main(String[] CMSC) throws java.io.IOException {
    	
        File configFile = new File("Gradeconfig.txt");
        File inputFile = new File("grades_input.txt");
        File outputFile = new File("grades_report.txt");
        
        if(configFile.exists()) {
        	  System.out.println();
        	  System.out.println("========================================");
        	  System.out.println("CMSC203 Project 1 - Grade Calculator");
        	  System.out.println("========================================");
        	  System.out.println();
              System.out.println("Loading configuration from gradeconfig.txt ...");
              System.out.println("Configuration loaded successfully.");
              System.out.println();
              System.out.println("Using input file: " + inputFile);
              System.out.println("Using output file: " + outputFile);
              System.out.println();
              System.out.println("Reading students scores...");
              System.out.println();
              
            Scanner config = new Scanner(configFile);
           
            Scanner input = new Scanner(inputFile);
            
            String courseTitle = config.nextLine();
            config.close();
            String firstName = input.nextLine();
            String lastName = input.nextLine();

            System.out.println("Student: " + firstName + " " + lastName);
            System.out.println("Course: " + courseTitle);
            System.out.println();
            System.out.println("Category Results:");
            System.out.println();
            
            do{
                double projectsTotal = 0;
                double quizzesTotal = 0;
                double examsTotal = 0;
                double projectsAvg,quizzesAvg,examsAvg;
                int numOfScores;
                
            
            input.nextLine();
            numOfScores = input.nextInt();

            if(numOfScores == 3){
                projectsTotal = input.nextDouble();
                projectsTotal += input.nextDouble();
                projectsTotal += input.nextDouble();
            }
            projectsAvg = projectsTotal / numOfScores;
            
            input.nextLine();
            input.nextLine();
            numOfScores = input.nextInt();

            if(numOfScores == 4){
                quizzesTotal = input.nextDouble();
                quizzesTotal += input.nextDouble();
                quizzesTotal += input.nextDouble();
                quizzesTotal += input.nextDouble();
            }
            quizzesAvg = quizzesTotal / numOfScores;
            
            input.nextLine();
            input.nextLine();
            numOfScores = input.nextInt();

            if(numOfScores == 2){
                examsTotal = input.nextDouble();
                examsTotal += input.nextDouble();
            }
            examsAvg = examsTotal / numOfScores;

            System.out.printf("Projects (40%%): Average = %.2f%%", projectsAvg);
            System.out.println();
            System.out.printf("Quizzes (30%%): Average = %.2f%%", quizzesAvg);
            System.out.println();
            System.out.printf("Exams (30%%): Average = %.2f%%", examsAvg);
            System.out.println();
            System.out.println();

            double projectGrade = projectsAvg * .40;
            double quizzGrade = quizzesAvg * .30;
            double examGrade = examsAvg * .30;

            double overall = projectGrade + quizzGrade + examGrade;

            Scanner keyboard = new Scanner(System.in);

            String sign;
            do{
                System.out.println("Apply +/- grading? (Y/N):");
                sign = keyboard.nextLine();

            } while(!sign.equalsIgnoreCase("Y") && !sign.equalsIgnoreCase("N"));
            
            String letterGrade;

                if(sign.equalsIgnoreCase("Y")){

                    if(overall >= 98){
                        letterGrade = "A+";
                    } else if (overall >= 92){
                        letterGrade = "A";
                    } else if (overall >= 90){
                        letterGrade = "A-";
                    }else if (overall >= 88){
                        letterGrade = "B+";
                    }else if (overall >= 82){
                        letterGrade = "B";
                    }else if (overall >= 80){
                        letterGrade = "B-";
                    }else if (overall >= 78){
                        letterGrade = "C+";
                    }else if (overall >= 72){
                        letterGrade = "C";
                    }else if (overall >= 70){
                        letterGrade = "C-";
                    }else if (overall >= 68){
                        letterGrade = "D+";
                    }else if (overall >= 62){
                        letterGrade = "D";
                    }else if (overall >= 60){
                        letterGrade = "D-";
                    }else{
                        letterGrade = "F";
                    }  
                	                
                } else {
                	if(overall >= 90) {
                		letterGrade = "A";
                	}else if (overall >= 80){
                        letterGrade = "B";
                	}else if (overall >= 70){
                        letterGrade = "C";
                	}else if (overall >= 60){
                        letterGrade = "D";
                	}else{
                        letterGrade = "F";
                	}
                }
                
                System.out.println();

                System.out.printf("Overall numeric average: %.2f%%", overall);
                System.out.println();
                System.out.println("Final letter grade: " + letterGrade);
                System.out.println("Program complete. Goodbye!");

            PrintWriter output = new PrintWriter(outputFile);

            System.out.println("Summary written to " + outputFile);

            output.println("Student: " + firstName + " " + lastName);
            output.println("Course: " + courseTitle);
            output.println();
            output.println("Category Results: ");
            output.println();
            output.printf("Projects (40%%): Average = %.2f%%", projectsAvg);
            output.println();
            output.printf("Quizzes (30%%): Average = %.2f%%", quizzesAvg);
            output.println();
            output.printf("Exams (30%%): Average = %.2f%%", examsAvg);
            output.println();
            output.println();
            output.printf("Overall Grade: %.2f%%", overall);
            output.println();
            output.println("Letter Grade: " + letterGrade);

            output.close();
                    

            }while (false);
        } else
            { 
              System.out.println("Configuration file not found");
            }

        System.exit(0);
           
    }
}
