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
        int pin=1000+nr.nextInt(9999);
        long card=(long) 1000000000+nr.nextInt(999999999);
        String cardNrString="400000"+card;
        cardDetails.put(cardNrString,Integer.toString(pin));

        System.out.println(
                "Your card has been created\n"+
                "Your card number:\n" +
                cardNrString+"\n"+
                "Your card PIN\n"+
                pin);
        runmenu(cardDetails);
    }

    private static void login(HashMap cardDetails)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your card number:\n");
        String card=scanner.next();
        System.out.println("Enter your PIN:\n");
        String pin= scanner.next();
        
        if(cardDetails.containsKey(card))
            System.out.println(cardDetails);
        {
            //TODO
            if(cardDetails.containsKey(pin)){
                System.out.println(cardDetails.keySet());
                System.out.println("You have successfully logged in!");
                runmainmenu();
            }
            else
            {
                System.out.println("Wrong card number or PIN");
                runmenu(cardDetails);
            }
        }
        else
        {
            System.out.println("Wrong card number or PIN");
            runmenu(cardDetails);
        }
    }

    private static void runmainmenu()
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

        }
    }
}