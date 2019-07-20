package com.practices;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CodeForces {

    private static class Ticket {

        private List<Integer> numbers;
        private int score;

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void setNumbers(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter input: ");
        String lotery[] = reader.nextLine().split(" ");
        int tickets = reader.nextInt();
        Map<Integer, Ticket> ticketListContainer =  new HashMap<>();
        int ticketNumber=0;
        List<String> ticketData= new ArrayList<>();
        String newTicket;

        while (reader.hasNextLine() && ticketNumber<tickets) {
            newTicket = reader.nextLine();
            if (!newTicket.isEmpty()) {
                ticketData.add(newTicket);
                ticketNumber++;
            } else {
                System.out.println("empty line, try again");
            }
        }
        AtomicInteger ticketnbr = new AtomicInteger(0);
        ticketData.forEach(ticket -> {
            List<Integer> ticketUnit = new ArrayList<>();
            String[] numbers = ticket.split(" ");
            Ticket ticketList =  new Ticket();
            for(int i=0;i<numbers.length; i++){
                ticketUnit.add(Integer.parseInt(numbers[i]));
            }
            ticketList.setNumbers(ticketUnit);
            ticketList.setScore(0);
            ticketListContainer.put(ticketnbr.getAndIncrement(),ticketList);
        });
        reader.close();

        ticketListContainer.forEach((key, value) -> {
            for(int i=0;i<lotery.length;i++){
                if(value.getNumbers().contains(Integer.parseInt(lotery[i]))){
                    int score = value.getScore() +1;
                    value.setScore(score);
                }
            }
        });

        ticketListContainer.forEach((key, value) -> {
            if (value.getScore() >= 3) {
                System.out.println("Lucky");
            }else {
                System.out.println("Unlucky");
            }
        });

    }
}
