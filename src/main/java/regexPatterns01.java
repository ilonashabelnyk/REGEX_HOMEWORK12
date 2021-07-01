import java.util.regex.Pattern;

public class regexPatterns01 {

    // 1.	Implement boolean method to validate whether String matches regular expression
    public static boolean checkString(String arg, String regex) {
        return Pattern.compile(regex).matcher(arg).find();
    }

    // 2.	Write regular expression to validate
    // E-MAIL
    static String emailAddressPattern = "^([A-Za-z0-9_\\.-]{3,25})@([A-Za-z]{3,5})\\.([A-Za-z]{3,})$";

    // IP
    static String ipAddressPattern = "^([0-9]{3})\\.([0-9]{3})\\.([0-9]{1,3})\\.([0-9]{1,3})$";

    // BANK CARD
    // Separated by whitespace
    static String creditCardPattern01 = "^[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}$";
    static String creditCardPattern02 = "^\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}$";

    // Without separators
    static String creditCardPattern03 = "^\\d{16}$";
    static String creditCardPattern04 = "^[0-9]{16}$";

    public static void main(String[] args) {

        System.out.println("Valid e-mail address: " + checkString("eMa-._il5@Mail.Commm", emailAddressPattern));
        System.out.println("Valid e-mail address: " + checkString("eM@Mail.Com", emailAddressPattern));
        System.out.println("Valid e-mail address: " + checkString("eMail5@Ma.Com", emailAddressPattern));
        System.out.println("Valid e-mail address: " + checkString("eMail5@Mail.Com555555555555", emailAddressPattern));

        System.out.println("Valid IP address: " + checkString("111.666.999.8", ipAddressPattern));
        System.out.println("Valid IP address: " + checkString("1g1.666.999.8", ipAddressPattern));
        System.out.println("Valid IP address: " + checkString("111.66.999.8", ipAddressPattern));
        System.out.println("Valid IP address: " + checkString("111.666..999.8", ipAddressPattern));
        System.out.println("Valid IP address: " + checkString("111.666.999666.", ipAddressPattern));
        System.out.println("Valid IP address: " + checkString("111.666.999.", ipAddressPattern));

        System.out.println("Valid Credit Card with space separators: " + checkString("1111 2222 3333 4444", creditCardPattern01));
        System.out.println("Valid Credit Card with space separators: " + checkString("1111.2222.3333.4444", creditCardPattern01));
        System.out.println("Valid Credit Card with space separators: " + checkString("111 2222 3333 4444", creditCardPattern01));
        System.out.println("Valid Credit Card with space separators: " + checkString("1111 2m22 3333 4444", creditCardPattern01));

        System.out.println("Valid Credit Card without separators: " + checkString("1111222233334444", creditCardPattern03));
        System.out.println("Valid Credit Card without separators: " + checkString("1111 2222 3333 4444", creditCardPattern03));
        System.out.println("Valid Credit Card without separators: " + checkString("111.222233334444", creditCardPattern03));
        System.out.println("Valid Credit Card without separators: " + checkString("11112222333n4444", creditCardPattern03));
        System.out.println("Valid Credit Card without separators: " + checkString("111122223", creditCardPattern03));
    }
}