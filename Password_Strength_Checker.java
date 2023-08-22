import java.util.Scanner;
/* A Strong Password
 is at least 12 characters long
 has at least one uppercase letter
 has at least one lowercase letter
 has at least one digit
 has at least one special character or symbol
 */
public class Password_Strength_Checker {
    public static void main(String[] args) {
        System.out.println("\n\t\tDataFlair's Password Strength Checker \n");
        System.out.println("Enter the password: \n");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        String strength = passwordStrength(password);
        System.out.println("Strength: " + strength);
    }
    public static String passwordStrength(String pass){
        //variables to track password criteria
        boolean containsLowerChar= false, containsUpperChar = false;
        boolean containsDigit = false, containsSpecialChar = false, minLength = false;
        String special_chars = "!(){}[]:;<>?,@#$%^&*+=_-~`|./'";
        String strength;
        char[] ch= pass.toCharArray(); //Convert password to character array
        //Check each character in the password
        for(int i=0; i<pass.length(); i++){
            if(Character.isLowerCase(ch[i])){
                containsLowerChar = true;
            }
            if(Character.isUpperCase(ch[i])){
                containsUpperChar = true;
            }
            if(Character.isDigit(ch[i])){
                containsDigit = true;
            }
            if(special_chars.contains(String.valueOf(ch[i]))){
                containsSpecialChar = true;
            }
        }
        //Check minimum length of the password
        if (pass.length() >= 12){
            minLength = true;
        }
        //Determine the strength of the password based on the criteria
        if(minLength && containsDigit && containsUpperChar && containsSpecialChar && containsLowerChar){
            strength = "Strong";
        } else if (minLength && ((containsUpperChar && containsLowerChar) || containsDigit || containsSpecialChar )) {
            strength = "Medium";
        }else{
            strength = "Weak";
        }
        return strength;
    }
}