import java.util.Scanner;

public class Base64Encoder {

    private static final String BASE64_CHARS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static String encode(String input) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i += 3) {

            int b1 = input.charAt(i);
            int b2 = (i + 1 < input.length()) ? input.charAt(i + 1) : 0;
            int b3 = (i + 2 < input.length()) ? input.charAt(i + 2) : 0;

            int bits = (b1 << 16) | (b2 << 8) | b3;

            int index1 = (bits >> 18) & 63;
            int index2 = (bits >> 12) & 63;
            int index3 = (bits >> 6) & 63;
            int index4 = bits & 63;

            // Convert indexes to Base64 characters
            result.append(BASE64_CHARS.charAt(index1));
            result.append(BASE64_CHARS.charAt(index2));

            if (i + 1 < input.length()) {
                result.append(BASE64_CHARS.charAt(index3));
            } else {
                result.append('=');
            }

            if (i + 2 < input.length()) {
                result.append(BASE64_CHARS.charAt(index4));
            } else {
                result.append('=');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();

        System.out.println(encode(str));
    }
}