/*
 * A JAVA grading system that satisfies:
   1. Requirement for passing an exam is that, student must pass the exam by a score of 25 or more and must pass
      assesment by 15 or more to get a cerrtificate.
   2. If a student score a total grade of 39 for both grading component(i.e  exam score and assesment), the student 
        is condoned.
   3. If a student satisfy req.1 and req.2 and have paid their fees in full (where fee is 100), they are issued with 
        certificalte.
   4. A student is deemed failed if he/she does not meet req1. and req.2
   5. Program must inform student which component he/she passed/failed.
   6. Where a student fails both components he/she is repeated
 */
package gradingsystem1;
import java.util.Scanner;
import java.util.*;
import java.io.*;
/*
 * @author Dennis Tweneboah
 */
public class GradingSystem1 {
    static Scanner sc=new Scanner(System.in);
    
    static char checkGrade(double examScore, double assesScore){
        char status;
        if (examScore<25 && assesScore<15){
            status = 'R';
            System.out.println("Failed exam and assesment");
            return status ;
        }else if(examScore==24 && assesScore>14||examScore>24&&assesScore==14){
            status = 'C';
            System.out.println("Condoned");
            return status;   
        }else if(examScore>24 && assesScore>14){
            status = 'P';
            System.out.println("Passed");
            return status;
        }else{
            status = 'F';
            if(examScore<25){
                System.out.println("Failed Exam ");
            }else{
                System.out.println("Failed Assesment");
            }
            return status;
        }
    }
    static void issueCert(char status){
        String fees;
        System.out.println("Fees fully paid? y/n");
       // Scanner sc=new Scanner(System.in);
        fees = sc.next();
            switch (fees) {
                case "y":
                case "Y":
                    if(status=='P'||status=='C'){
                        System.out.println("CONGRATULATIONS!!! CERT ISSUED.");
                    }else{
                        System.out.println("NO CERT ISSUED");
                    }break;
                case "n":
                case "N":
                    System.out.println("PAY FEES IN FULL TO GET CERT.");
                    break;
                default:
                    System.out.println("Incorrect input. Enter 'Y' or 'N'.");
                    break;
            } 
       
        /*if (fees.equals("y")||fees.equals("Y")||fees.equals("n")||fees.equals("N")){*/
       
    }
    static int GetExamScore(){
        while (true){
        try{
         return sc.nextInt();
        }catch (InputMismatchException e){
            sc.next();
            System.out.println("!!! Input must be an Interger. Try again !!!");
        }
        }
    }
    static int GetAssesmentScore(){
        while (true){
        try{
           return sc.nextInt();
        }catch (InputMismatchException e){
           sc.next();
           System.out.println("!!! Input must be an Interger. Try again !!!");
        }
        }
    }
    public static void main(String[] args) {
        int examScore, assesScore, totalScore; char status;
            
        System.out.println(">>>>>>> Welcome to the Ultimate Grade Checker <<<<<<<<<<<<< ");
        System.out.println(" Enter exam score: ");
        examScore= GetExamScore();              /*Input examScore*/
        
        System.out.println(" Enter assesment score: ");
        assesScore= GetAssesmentScore();        /*Input assesScore*/
        
        totalScore= examScore + assesScore;     /*Total Score*/
        System.out.println(" Your total score is: "+totalScore);
        
        checkGrade(examScore,assesScore);
        issueCert(checkGrade(examScore,assesScore));
    
        
    }
    
}
