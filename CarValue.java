import java.util.Scanner;

public class CarValue {

    public static void main(String args[]){

        //Create scanner for standard input.
        Scanner in = new Scanner(System.in);

        String initialLine = in.nextLine();
        String[] split1 = initialLine.split(" ");

        int months = Integer.parseInt(split1[0]);
        double downPayment = Double.parseDouble(split1[1]);
        double loanValue = Double.parseDouble(split1[2]);
        //int depreciationRecords = Integer.parseInt(split1[3]);

        if (months == 0){
            System.out.println("0 months");
            in.close();
            return;
        }

        double monthlyPayment = loanValue / months;

        //Debug: Print out initial values.
        //System.out.println(months);
        //System.out.println(downPayment);
        //System.out.println(loanValue);
        //System.out.println(depreciationRecords);

        double carWorth = downPayment + loanValue;
        int currentMonth = 0;

        double[] depPercentages = new double[months+1];
        for (int i = 0; i < months+1; i++){
            if (depPercentages[i] == 0.0){
                depPercentages[i] = -1.0;
            }
        }
        while (in.hasNextLine()){
            String info = in.nextLine();
            if (info == ""){
                break;
            }
            String[] split = info.split(" ");

            //Debug
            //System.out.println("Split: " + Arrays.toString(split));

            int month = Integer.parseInt(split[0]);
            double perc = Double.parseDouble(split[1]);

            depPercentages[month] = perc;
        }

        //Debug: Print array of all depreciation values.
        //System.out.println(Arrays.toString(depPercentages));

        //Set the depreciation percentage of zero.
        double currentDepreciation = depPercentages[0];
        if (currentDepreciation == -1.0){
            currentDepreciation = 0.0;
        }

        //Debug:
        //System.out.println("Car is worth: " + carWorth);
        //System.out.println("Loan balance: " + loanValue);

        carWorth = carWorth - (carWorth * currentDepreciation);
        currentMonth += 1;

        while (carWorth <= loanValue){

            //Check to see if the current month has its own new depreciation value.
            //If so, update the currentDepreciation value.
            if (depPercentages[currentMonth] != -1.0){
                currentDepreciation = depPercentages[currentMonth];
            }

            carWorth = carWorth - (carWorth * currentDepreciation);
            currentMonth += 1;
            loanValue = loanValue - monthlyPayment;

        }

        if ((currentMonth - 1) == 1){
            System.out.println("1 month");
        }
        else{
            System.out.println((currentMonth - 1) + " months");
        }

        in.close();

    }
    
}
