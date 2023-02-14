import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in), 200);
        char[] chars = new char[200];
        try {
            bf.read(chars);
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int check = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '\u0000') {
                check = i;
                break;
            }
        }
        char[] result = Arrays.copyOfRange(chars, 0, check);

        printChar(result);
    }

    static void printChar(char[] message) {
        Map<Character, Integer> map = new HashMap<>(message.length);
        int maxCharCount = 0;
        for (int i = 0; i < message.length; i++) {
            if (message[i] == ' ' || message[i] == '\n') {
                continue;
            }
            if (!map.containsKey(message[i])) {
                map.put(message[i], 0);
            }
            map.put(message[i], map.get(message[i]) + 1);
        }
        maxCharCount = Collections.max(map.values());
        Set<Character> treeSet = new TreeSet<>(map.keySet());
        for (int i = maxCharCount; i > 0; i--) {
            for (char el : treeSet) {
                if (map.get(el) >= i) {
                    System.out.print('#');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }

        for (char el : treeSet) {
            System.out.print(el);
        }
    }
}
