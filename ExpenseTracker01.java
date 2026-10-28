
import java.util.Scanner;

public class ExpenseTracker01 {
	
	static void storeExpense(int[] week, int day, int val) {
		week[day] = val;
	}
	
	static void display(int[] week) {
		int sum = 0;
		for(int i = 0; i < week.length; i++) {
			sum = sum + week[i];
		}
		System.out.println("₹" + sum);
	}
	
	static void highLow(int[] week) {
		int high = 0;
		int low = 10000;
		
		for(int i = 0; i < week.length; i++) {
			if(week[i] > high) {												 
				high = week[i];
			}
		}
		
		for(int i = 0; i < week.length; i++) {
			if(week[i] < low) {
				low = week[i];
			}
		}
		
		
		System.out.println("Lowest spend day: ₹" + low);
		System.out.println("Highest spend day: ₹" + high);
		
	}

	public static void main(String[] args) {
		int[] food = new int[7];
		int[] travel = new int[7];
		int[] shopping = new int[7];
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Expense Tracker");
			System.out.println("1. Add expense");
			System.out.println("2. Display total");
			System.out.println("3. Show highest and lowest spend days");
			System.out.println("4. Exit");
			int ch = sc.nextInt();
			
			switch(ch) {
				
			case 1:
				System.out.println("Enter day from 1 to 7: ");
				int day = sc.nextInt();
				System.out.println("1. Add food expense");
				System.out.println("2. Add travel expense");
				System.out.println("3. Add shopping expense");
				int op = sc.nextInt();
				
				switch(op) {
				
				case 1:
					System.out.println("Enter food expense:");

					int foodVal = sc.nextInt();
					storeExpense(food, day, foodVal);
					System.out.println("Expense added successfully!");
					break;
					
				case 2:
					System.out.println("Enter travel expense:");
					int travelVal = sc.nextInt();
					storeExpense(food, day, travelVal);
					
		
					System.out.println("Expense added successfully!");
					break;
					
				case 3:
					System.out.println("Enter shopping1 expense:");
					int shoppingVal = sc.nextInt();
					storeExpense(food, day, shoppingVal);
					System.out.println("Expense added successfully!");
					break;
					
				default:
					System.out.println("Invalid choice");
					
				}
				break;
				
			case 2:
				System.out.println("Total expense of week (food):");
				display(food);
				System.out.println("Total expense of week (travel):");
				display(travel);
				System.out.println("Total expense of week (shopping):");
				display(shopping);
				break;
				
			case 3:
				highLow(food);
				highLow(travel);
				highLow(shopping);
				break;
				
			case 4:
				return;
				
			default:
					
			}
		}
	}
}

