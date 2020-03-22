package romannumberconverter;

/**
 *
 * @author Marius.Klein
 */
public class RomanConverter {

    public static String I = "I"; //1
    public static String V = "V"; //5
    public static String X = "X"; //10
    public static String L = "L"; //50
    public static String C = "C"; //100
    public static String D = "D"; //500
    public static String M = "M"; //1000
    //max: MMMCMXCIX = 3999

    public static String convert(int num) {
        String converted = "";
        int length = String.valueOf(num).length();

        converted = ConvertToRoman(num, length);
        converted = converted.replace("0", "");
        return converted;
    }

    private static String logic(int num, String one, String five, String ten) {
        String r = null;

        StringBuilder sb = new StringBuilder(3);

        if (num <= 3) {

            if (num == 0) {
                r = "0";
            } else {

                for (int i = 0; i < num; i++) {
                    sb.append(one);
                }
                r = sb.toString();

            }

        } else if (num > 3 && num < 5) {

            r = one + five;

        } else if (num >= 5 && num < 8) {

            for (int i = 0; i < num - 5; i++) {
                sb.append(one);
            }

            r = five + sb.toString();
        } else if (num >= 8) {

            for (int i = 0; i < 10 - num; i++) {
                sb.append(one);
            }

            r = sb.toString() + ten;
        }
        return r;
    }

    private static String ConvertToRoman(int num, int length) {
        String r;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;

        String r1;
        String r2;
        String r3;
        String r4;

        r = num + "";

        if (length >= 5 || num > 3999) {
            r = "Your number has to be 3999 or smaller";
        } else {
            if (length == 4) {
                num1 = Integer.parseInt(r.substring(0, 1));
                num2 = Integer.parseInt(r.substring(1, 2));
                num3 = Integer.parseInt(r.substring(2, 3));
                num4 = Integer.parseInt(r.substring(3, 4));

                r4 = logic(num1, "M", "", "");
                r3 = logic(num2, "C", "D", "M");
                r2 = logic(num3, "X", "L", "C");
                r1 = logic(num4, "I", "V", "X");
                r = r4 + r3 + r2 + r1;

            } else if (length == 3) {
                num1 = Integer.parseInt(r.substring(0, 1));
                num2 = Integer.parseInt(r.substring(1, 2));
                num3 = Integer.parseInt(r.substring(2, 3));

                r3 = logic(num1, "C", "D", "M");
                r2 = logic(num2, "X", "L", "C");
                r1 = logic(num3, "I", "V", "X");
                r = r3 + r2 + r1;

            } else if (length == 2) {
                num1 = Integer.parseInt(r.substring(0, 1));
                num2 = Integer.parseInt(r.substring(1, 2));

                r2 = logic(num1, "X", "L", "C");
                r1 = logic(num2, "I", "V", "X");
                r = r2 + r1;
            } else if (length == 1) {
                num1 = Integer.parseInt(r.substring(0, 1));
                r1 = logic(num1, "I", "V", "X");
                r = r1;
            }

        }

        return r;
    }

}
