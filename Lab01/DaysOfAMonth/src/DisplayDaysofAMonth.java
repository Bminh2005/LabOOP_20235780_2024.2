import java.util.Scanner;
public class DisplayDaysofAMonth {
	public static void main (String args[]) {
		Scanner keyboard = new Scanner(System.in);
		String month;
		int month_int = 0;
		int year = 0;
		boolean check_month = true;
		while (check_month) {
			System.out.print("Month: ");
			month = keyboard.nextLine();
			if(month.equals("January")||month.equals("Jan.")||month.equals("Jan")||month.equals("1")) {
				month_int = 1;
				check_month = false;
			}
			else if(month.equals("February")||month.equals("Feb.")||month.equals("Feb")||month.equals("2")) {
				month_int = 2;
				check_month = false;
			}
			else if(month.equals("March")||month.equals("Mar.")||month.equals("Mar")||month.equals("3")) {
				month_int = 1;
				check_month = false;
			}
			else if(month.equals("April")||month.equals("Apr.")||month.equals("Apr")||month.equals("4")) {
				month_int = 0;
				check_month = false;
			}
			else if(month.equals("May")||month.equals("5")) {
				month_int = 1;
				check_month = false;
			}
			else if(month.equals("June")||month.equals("Jun")||month.equals("6")) {
				month_int = 0;
				check_month = false;
			}
			else if(month.equals("July")||month.equals("Jul")||month.equals("7")) {
				month_int = 1;
				check_month = false;
			}
			else if(month.equals("August")||month.equals("Aug.")||month.equals("Aug")||month.equals("8")) {
				month_int = 1;
				check_month = false;
			}
			else if(month.equals("September")||month.equals("Sept.")||month.equals("Sep")||month.equals("9")) {
				month_int = 0;
				check_month = false;
			}
			else if(month.equals("October")||month.equals("Oct.")||month.equals("Oct")||month.equals("10")) {
				month_int = 1;
				check_month = false;
			}
			else if(month.equals("November")||month.equals("Nov.")||month.equals("Nov")||month.equals("11")) {
				month_int = 0;
				check_month = false;
			}
			else if(month.equals("December")||month.equals("Dec.")||month.equals("Dec")||month.equals("12")) {
				month_int = 1;
				check_month = false;
			}
			else {
				System.out.println("It is an invalid month. Please enter again.");
			}
		}
		check_month = true;
		while(check_month) {
		
			System.out.print("Year: ");
			year = keyboard.nextInt();
			if(year >= 1) {
				check_month = false;
			}
			else {
				System.out.println("It is an invalid year. Please enter again.");
			}
		}
		if(month_int == 0) {
			System.out.println("Days of month: 30 days");
		}
		else if(month_int == 1) {
			System.out.println("Days of month: 31 days");
		}
		else if(month_int == 2) {
			
			if(year % 4 == 0) {
				check_month = true;
			}
			if(year % 100 == 0 && year % 400 != 0) {
				check_month = false;
			}
			if(check_month) {
				System.out.println("Days of month: 29 days");
			}
			else {
				System.out.println("Days of month: 28 days");
			}
		}
		
		System.exit(0);
	}
}
