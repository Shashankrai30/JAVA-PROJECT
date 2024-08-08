package JavaProject;
import java.util.*;
import java.util.Random;
public class numberGame {
    public static void numberGameGuessing(){
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        int number=rand.nextInt(100)+1;
        int k=5;
        int guess;
        int i;
        System.out.println(
            "A number is chosen"+ " between 1 to 100."+"\n"
            + "Guess the number"+ " within 5 trials.");
        for( i=0;i<k;i++){
            System.out.print("Guess the number:");
            guess=sc.nextInt();
            if(number==guess){
                System.out.println("You guessed it right: "+guess);
                break;
            }
            else if(number>guess && i<k){
                System.out.println("Number is too low: "+guess);
            }
            else if(number<guess && i<k){
                System.out.println("Number is too high: "+guess);
            }
        }
        if(i==k){
            System.out.println("You have exhausted trials");
            System.out.print("The number was "+number);
        }
        
    }
    public static void main(String[] args) {
        numberGameGuessing();
    }
}
