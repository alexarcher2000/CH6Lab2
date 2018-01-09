package labs.apcs_ch6_lab_2;
import java.util.Scanner;

/**
 * Write a description of class GradeQuiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GradeQuiz
{
    // instance variables - replace the example below with your own
    private String[] key;  //answer key
    private int numQuestions;
    private double percentCorrect;
    private String[] student; //student responses
    private Scanner scan = new Scanner(System.in);

    /**
     * Constructor for objects of class GradeQuiz
     */
    public GradeQuiz()
    {

        getNumQuestions();
        key = new String[numQuestions];
        setKey();
        boolean moreQuizzes = true;
        
        while (moreQuizzes)
        {
            student = new String[numQuestions];
            studentAnswers();
            gradeStudent();
            printResults();
            System.out.println("Grade another quiz? (Y/N):");
            if (scan.next().equals("N")) moreQuizzes = false;
        }
        System.out.println("Goodbye...");
    }
    
    public void getNumQuestions()
    {
        System.out.println("Enter number of questions on quiz: ");
        numQuestions = scan.nextInt();
    }
    
    public void setKey()
    {
        for (int i = 0; i < key.length; i++)
        {
            System.out.println("Enter Answer (A, B, C, D): ");
            key[i] = scan.next();
        }
    }
    
    public void studentAnswers()
    {
         for (int i = 0; i < student.length; i++)
        {
            System.out.println("Enter Student Response (A, B, C, D): ");
            student[i] = scan.next();
        }
    }
    
    public void gradeStudent()
    {
        int correct = 0;
        for (int i = 0; i < key.length -1; i++)
        {
            if (key[i].equals(student[i])) correct++;
        }
        
        percentCorrect = (((double) correct) / key.length * 100 );
    }
    
    public void printResults()
    {
        System.out.println("You scored a " + percentCorrect + " percent on " + numQuestions + " questions");
    }
    
    
}
