import java.util.Scanner;

public class Addition {

	public static void main(String[] args) {
		// Adding numbers
		Scanner input = new Scanner(System.in);
		
		int number1;
		int number2;
		int sum;
		
		System.out.print( "Type the first number: " );
		number1 = input.nextInt();
		System.out.print( "Type the second number: " );
		number2 = input.nextInt();
		
		sum = number1 + number2;
		
		System.out.print( "The sum is: "+ sum );
		
		input.close();
	}

}
