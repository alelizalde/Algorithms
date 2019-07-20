import java.util.Scanner;

public class Lottery {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] lottery =new int[10];
        for(int i=0;i<lottery.length;i++) {
            lottery[i] = input.nextInt();
        }

        int numTickets = input.nextInt();

        for (int i=0;i<numTickets;i++) {
            int[] tickets = new int[6];
            int score = 0;
            for (int j=0;j<tickets.length;j++) {
                tickets[j] = input.nextInt();
                for(int k=0;k<lottery.length;k++) {
                    if(tickets[j] == lottery[k]) {
                        score++;
                        break;
                    }
                }
            }

            if (score>=3) System.out.println("Lucky");
                else  System.out.println("Unlucky");
        }
    }
}