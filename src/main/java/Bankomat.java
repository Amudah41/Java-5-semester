import java.util.*;

import static java.lang.System.in;

public class Bankomat {

    public static void main(String[] args){
        Scanner input = new Scanner(in);
        long sum;
        String data = input.next();
        try {
            Long.parseLong(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Сумма  должна быть целым числом.");
        }
        sum = Long.parseLong(data);
        if (sum <= 0) {
            System.out.print("Значение суммы должно быть положительным.");
            System.exit(0);
        }

        String bank = input.nextLine();
        String[] banknotesStr = bank.split(" ");

        int CountOfNominals=0;
        List<Integer> banknotes = new ArrayList<>();
        for (String note : banknotesStr) {
            if (note.equals("")){
                continue;
            }
            if (note.matches("[0-9]+")) {
                if (Integer.parseInt(note) > 0) {
                    banknotes.add(Integer.parseInt(note));
                    CountOfNominals++;

                } else {
                    System.out.print("Значение банкнот должно быть положительным.");
                    System.exit(0);
                }
            } else {
                System.out.print("Значение банкнот должно быть целым.");
                System.exit(0);
            }
        }

        long[] counts = new long[CountOfNominals];
        for (int i = 0; i < CountOfNominals; i++){
            counts[i] = 0;
        }

        System.out.println(Exchange(banknotes, counts, 0, sum));
        System.out.print("Количество комбинаций: "+ Combinations);
    }

    public static String data = "";
    public static long Combinations = 0;

    public static String Exchange(List<Integer> banknotes, long[] counts, int startIndex, long totalSum) {
        if (startIndex >= banknotes.size()) {
            Combinations++;
            for (int i = 0; i < banknotes.size(); i++) {
                for(int j = 0; j < counts[i]; j++){
                    data += banknotes.get(i) +" ";
                }
            }
            data += "\n";
            return data;
        }
        if (startIndex == banknotes.size() - 1) {

            if (totalSum % banknotes.get(startIndex) == 0) {
                counts[startIndex] = totalSum / banknotes.get(startIndex);
                Exchange(banknotes, counts, startIndex + 1, 0);
            }
        }
        else {
            for (int i = 0; i <= totalSum / banknotes.get(startIndex); i++) {
                counts[startIndex] = i;
                Exchange(banknotes, counts, startIndex + 1, totalSum - banknotes.get(startIndex) * i);
            }
        }
        return data;
    }
}

