import java.util.*;

public class Bankomat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long sum;
        String result = scanner.next();
        try {
            sum = Long.parseLong(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Сумма  должна быть целым числом.");
        }
        if (sum <= 0) {
            System.out.print("Значение суммы должно быть положительным.");
            System.exit(0);
        }

        String bank = scanner.nextLine();
        String[] bankStr = bank.split(" ");

        List<Integer> banknotes = new ArrayList<>();
        for (String tmp : bankStr) {
            if (tmp.equals("")){
                continue;
            }
            if (tmp.matches("[0-9]+")) {
                if (Integer.parseInt(tmp) > 0) {
                    banknotes.add(Integer.parseInt(tmp));

                }
                else {
                    System.out.print("Значение банкнот должно быть положительным.");
                    System.exit(0);
                }
            }
            else {
                System.out.print("Значение банкнот должно быть целым.");
                System.exit(0);
            }
        }
        if (banknotes.size() == 0) {
            System.out.print("Ведите значения банкнот.");
            System.exit(0);
        }
        delete_duplicates(banknotes);
        long[] counts = new long[banknotes.size()];
        for (int i = 0; i < banknotes.size()-1; i++) {
            counts[i] = 0;
        }
        System.out.println(exchange(banknotes, counts, 0, sum));
        System.out.print("Количество комбинаций: "+ combinations);
    }

    public static void delete_duplicates(List<Integer> banknotes) {
        Collections.sort(banknotes);
        int tmp;
        int size = banknotes.size();
        for(int i = 1; i < size - 1; i++) {
             tmp = banknotes.get(i - 1);
             while (banknotes.get(i) == tmp && i < size-1) {
                banknotes.remove(i);
                size--;
            }
        }
        if (banknotes.get(size - 1).equals(banknotes.get(size - 2))) {
            banknotes.remove(banknotes.get(size-1));
        }
    }

    public static String result = "";
    public static long combinations = 0;

    public static String exchange(List<Integer> banknotes, long[] counts, int index, long sum) {
        if (index >= banknotes.size()) {
            combinations++;
            for (int i = 0; i < banknotes.size(); i++) {
                for(int j = 0; j < counts[i]; j++) {
                    result += banknotes.get(i) +" ";
                }
            }
            result += "\n";
            return result;
        }
        if (index == banknotes.size() - 1) {
            if (sum % banknotes.get(index) == 0) {
                counts[index] = sum / banknotes.get(index);
                exchange(banknotes, counts, index + 1, 0);
            }
        }
        else {
            for (int i = 0; i <= sum / banknotes.get(index); i++) {
                counts[index] = i;
                exchange(banknotes, counts, index + 1, sum - banknotes.get(index) * i);
            }
        }
        return result;
    }
}

