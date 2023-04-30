import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        HashMap<String,String> cardDetails=new HashMap<String,String>();
        runmenu(cardDetails);
}
    private static void runmenu(HashMap cardDetails) {
        Scanner scanner=new Scanner(System.in);
        System.out.println(
                "1. Create an account\n" +
                        "2. Log into account\n" +
                        "0. Exit");
        while(true)
        {
            int input=scanner.nextInt();
            if(input == 0)
            {
                System.out.println("Bye");
                System.exit(0);
                break;
            }

            if(input == 1)
            {
                generateCard(cardDetails);
            }
            if(input == 2)
            {
                login(cardDetails);
            }
        }
    }

    private static void generateCard(HashMap cardDetails)
    {
        Random nr=new Random();
        int pin=10+nr.nextInt(9999);
        long card=(long) 100000000+nr.nextInt(99999999);
        String preCardNr="400000"+Long.toString(card);
        //String preCardNr="400000844943340";
        System.out.println(preCardNr);

        String digits[]=preCardNr.split("");
        int[] arrayFromDigits = new int[digits.length];
        for(int i=0; i<digits.length; i++){
            arrayFromDigits[i]=Integer.parseInt(digits[i]);
        }
        int[] tempArray=arrayFromDigits;
        int checkSum=0;
        //Luhn Algorithm
        for(int i=0; i<tempArray.length; i++){
            if(i%2==0) {
                tempArray[i] += (arrayFromDigits[i]);
                if (tempArray[i] > 9) {
                    tempArray[i]-=9;
                }
            }
            checkSum+=tempArray[i];
        }


        int finalCardNr= checkSum%10==0 ? 0 : 10-(checkSum%10) ;


        System.out.println(finalCardNr);

        String finalNr= String.valueOf(finalCardNr);
        String cardNrString=preCardNr+finalNr;

        cardDetails.put(cardNrString,Integer.toString(pin));

        System.out.println(
                "Your card has been created\n"+
                        "Your card number:\n" +
                        cardNrString+"\n"+
                        "Your card PIN:\n"+
                        pin);
        runmenu(cardDetails);
    }

    private static void login(HashMap cardDetails)
    {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your card number:\n");
        String card=scanner.next();
        System.out.println(cardDetails.keySet());
        System.out.println("Enter your PIN:\n");

        String pin= scanner.next();

            if(cardDetails.containsKey(card) && cardDetails.containsValue(pin)){
                //TODO

                System.out.println("You have successfully logged in!");
                runmainmenu(cardDetails);
            }
            else
            {
                System.out.println("Wrong card number or PIN");
                runmenu(cardDetails);
            }

            System.out.println("Wrong card number or PIN");
            runmenu(cardDetails);

    }

    private static void runmainmenu(HashMap cardDetails)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("" +
                "1. Balance\n" +
                "2. Log out\n" +
                "0. Exit\n");
        while(true)
        {
            int input=scanner.nextInt();
            if(input == 0)
            {
                System.exit(0);
                break;
            }
            if(input == 1)
            {
                System.out.println("Balance: 0");
            }
            if(input == 2)
            {
                System.out.println("You have successfully logged out!");
                runmenu(cardDetails);
            }

        }
    }
}