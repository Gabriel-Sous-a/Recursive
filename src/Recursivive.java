import java.util.ArrayList;

public class Recursivive {
    private static int counter = 0;
    private static int counterCheck = 0;
    private static int result = 0;
    private static int temp = 0;
    private static int[] recamans;
    private static int[] numTemp = new int[]{};

    public static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        }
        if (num <= 2) {
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static int sumArray(int[] arrayInt) {
        counter++;
        if (counter == 1) {
            temp = arrayInt[0];
        }
        if (counter == arrayInt.length) {
            result = arrayInt[0];
            arrayInt[0] = temp;
            counter = 0;
            return result;
        }
        arrayInt[0] = arrayInt[0] + arrayInt[counter];
        return sumArray(arrayInt);
    }

    public static int commonFactor(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return firstNumber;
        }
        return commonFactor(secondNumber, firstNumber % secondNumber);
    }

    public static int biggestNum(int[] arrayInt) {
        numTemp = arrayInt;
        counter++;
        if (counter == numTemp.length) {
            counter = 0;
            return numTemp[0];
        }
        if (numTemp[0] < numTemp[counter]) {
            numTemp[0] = numTemp[counter];
        }
        return biggestNum(numTemp);
    }

    public static int[] recamasSequence(int num) {
        counter++;
        if (counter == 1) {
            recamans = new int[num];
            recamans[0] = 0;
        }
        if (counter == num) {
            counter = 0;
            for (int i = 0; i < recamans.length; i++) {
                System.out.println(recamans[i]);
            }
            return recamans;
        }
        if ((recamans[counter] = (recamans[counter - 1] - counter)) < 0 && !checker(num)) {
            recamans[counter] = (recamans[counter - 1] + counter);
            return recamasSequence(num);
        }
        recamans[counter] = (recamans[counter - 1] - counter);
        return recamasSequence(num);
    }

    private static boolean checker(int num) {
        if (counterCheck == 0) {
            counterCheck++;
            return true;
        }

        if (counterCheck == recamans.length) {
            return false;
        }

        if (num == recamans[counterCheck]) {
            return true;
        }

        counterCheck++;
        return checker(num);
    }

    static int countLetters(String string, int size) {
        size -= 1;
        if (String.valueOf(string.charAt(size)).equals(String.valueOf(string.charAt(size)).toUpperCase())) {
            counter++;
        }
        if (size == 0) {
            int temp = counter;
            counter = 0;
            return temp;
        }
        return countLetters(string, size);
    }
}
