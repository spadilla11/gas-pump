import java.util.Scanner;

public class Main{
    public static  String before_or_after(String choice){
        if (choice.equals("before") || choice.equals("after")) {
            return choice;
        }
        else {
            throw new IllegalArgumentException("Invalid Option");
        }
    }

    public static float get_grade(String grade){
        float price_per_g;
        if (grade.equals("regular")){
            price_per_g = 2.50f;
        }
        else if(grade.equals("mid-grade")){
            price_per_g = 3.00f;
        }
        else if(grade.equals("premium")){
            price_per_g = 3.50f;
        }
        else{
            throw new IllegalArgumentException("Invalid Option");
        }
        return price_per_g;
    }

    public static float get_gallons(float price, float grade){
        if (price >= 0 && grade >= 0){
            float gallons = price / grade;
            return gallons;
        }
        else {
            throw new IllegalArgumentException("Invalid");
        }
    }

    public static float calculate_total_cost(float grade, float gallons){
        float total = grade * gallons;
        return total;
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pay before or after?");
        System.out.print("> ");
        String choice = scanner.nextLine();
        String boa = before_or_after(choice);

        if (boa.equals("before")){
            System.out.println("How much are you spending?");
            System.out.print("> ");
            String how_much = scanner.nextLine();
            float spend_amount = Float.parseFloat(how_much);
            if (spend_amount >= 0){
                System.out.println("What grade?\n" +
                        "- Regular $2.50/gal\n" +
                        "- Mid-grade $3.00/gal\n" +
                        "- Premium $3.50/gal");
                System.out.print("> ");
                String grade = scanner.nextLine();
                float grade_price = get_grade(grade);
                float gallons = get_gallons(spend_amount, grade_price);
                System.out.printf("Thank you for your purchase!\n Payment: %s \n Amount spent: $%.2f \n Gallons purchased: %.1f\n", boa, spend_amount, gallons);
            }
        }
        else if (boa.equals("after")){
            System.out.println("What grade?\n" +
                    "- Regular $2.50/gal\n" +
                    "- Mid-grade $3.00/gal\n" +
                    "- Premium $3.50/gal");
            System.out.print("> ");
            String grade_choice = scanner.nextLine();
            float grade = get_grade(grade_choice);

            System.out.println("How many gallons of gas did you pump?");
            System.out.print("> ");
            String gallon_choice = scanner.nextLine();
            float gallons = Float.parseFloat(gallon_choice);

            float total = calculate_total_cost(grade, gallons);

            System.out.printf("Thank you for your purchase!\n Payment: %s \n Amount spent: $%.2f \n Gallons purchased: %.1f\n", boa, total, gallons);

        }


    }
}



