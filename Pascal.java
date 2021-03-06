import java.io.*;
import java.util.Arrays;

public class Pascal {
    
    public static int mysterySeries(int x, int y) {
        if (x < 0 || y < 0 || x < y) return 0;
        if (x == y) return 1;
        return (mysterySeries(x-1, y) + mysterySeries(x-1,y-1));
    }
    
    public static long pascalNum(int x, int y) {
        if (x < 0 || y < 0 || x < y) return 0;
        return (factorial(x) / (factorial(y) * factorial(x - y)));
    }
    
    public static long factorial(int x) {
        return (x <= 1) ? 1 : x * factorial(x-1);
    }
    
    public static long[] pascalRow(int x) {
        if (x < 0) return null;
        long[] triangleRow = new long[x+1];
        for (int i = 0; i < triangleRow.length; i++) {
            triangleRow[i] = pascalNum(x, i);
        }
        return triangleRow;
    }
    
    static class TooManyArgumentsException extends Exception {
     
        public TooManyArgumentsException(String message) {
            super(message);
        }
    }
    
    public static void main(String[] args) {
        int start = -1;
        int end = -1;
        try {
            start = Integer.parseInt(args[0]);
            if (args.length == 2) end = Integer.parseInt(args[1]);
            if (args.length > 2) throw new TooManyArgumentsException("More than two numbers were entered.");
        } catch (NumberFormatException e) {
            System.out.println("Number Invalid.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            start = 0; 
            end = 5;
        } catch (TooManyArgumentsException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (end == -1) end = start;
        for (int i = start; i <= end; i++) {
            System.out.println(Arrays.toString(pascalRow(i)));
        }
    }
}