import java.util.Scanner;

public class RodSculpture {
    
    public static void main(String args[]){


        Scanner in = new Scanner(System.in);

        int length = Integer.parseInt(in.nextLine());

        if (length == 0){
            System.out.println("+x");
            in.close();
            return;
        }

        //Read in all the instructions for each point. 
        String instructionLine = in.nextLine();
        String[] instructions = instructionLine.split(" ");

        //System.out.println(Arrays.toString(instructions));

        //The starting direction is always positive x.
        String direction = "+x";

        for (int i = 0; i < instructions.length; i++){

            if (instructions[i].equals("No")){ continue; }

            if (direction == "+x"){

                switch (instructions[i]){
                    case "+z":  direction = "+z"; break;
                    case "-z":  direction = "-z"; break;
                    case "+y":  direction = "+y"; break;
                    case "-y":  direction = "-y"; break;
                    default: break;
                }
            }
            else if (direction == "-x"){

                switch (instructions[i]){
                    case "+z":  direction = "-z"; break;
                    case "-z":  direction = "+z"; break;
                    case "+y":  direction = "-y"; break;
                    case "-y":  direction = "+y"; break;
                    default: break;
                }
            }
            else if (direction == "+y"){

                switch (instructions[i]){
                    case "+z":  direction = "+y"; break;
                    case "-z":  direction = "+y"; break;
                    case "+y":  direction = "-x"; break;
                    case "-y":  direction = "+x"; break;
                    default: break;
                }
            }
            else if (direction == "-y"){

                switch (instructions[i]){
                    case "+z":  direction = "-y"; break;
                    case "-z":  direction = "-y"; break;
                    case "+y":  direction = "+x"; break;
                    case "-y":  direction = "-x"; break;
                    default: break;
                }
            }
            else if (direction == "+z"){

                switch (instructions[i]){
                    case "+z":  direction = "-x"; break;
                    case "-z":  direction = "+x"; break;
                    case "+y":  direction = "+z"; break;
                    case "-y":  direction = "+z"; break;
                    default: break;
                }
            }
            else if (direction == "-z"){

                switch (instructions[i]){
                    case "+z":  direction = "+x"; break;
                    case "-z":  direction = "-x"; break;
                    case "+y":  direction = "-z"; break;
                    case "-y":  direction = "-z"; break;
                    default: break;
                }
            }

        }

        System.out.print(direction);

        in.close();

    }

}
