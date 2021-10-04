// author: shagun

import java.util.Scanner;

class InvalidMessageException extends Exception{
    public InvalidMessageException(String str){
        super(str);
    }
}
class Encrypter extends Validator{
    
    
    public static String encryptMessage(String name) throws InvalidMessageException{
        
        boolean a=validate(name);
        String s="";
        String s1="";
        if(a==true){
            //StringBuilder str=new StringBuilder(name);
            //StringBuilder reversed_string=str.reverse();
            for(int i=name.length()-1;i>=0;i--){
                s+=name.charAt(i);
            }
            for(int i=0;i<s.length();i++){
                if(Character.isUpperCase(s.charAt(i))){
                    s1+=Character.toLowerCase(s.charAt(i));
                    
                }
                else{
                    s1+=s.charAt(i);
                }
            }
            return s1;
            
        }
        else{
            throw new  InvalidMessageException("Try again with valid message");    
            
        }
        
    }
}

class Validator {
    public static boolean validate(String message) {
        return message.matches("[A-Za-z0-9 ]+");
    }
}

public class ExceptionHandling {
    private static final Scanner INPUT_READER = new Scanner(System.in);
    
    public static void main(String[] args) {
        String message = INPUT_READER.nextLine();
        
        try {
            String encrypted_message = Encrypter.encryptMessage(message);
            if(!encrypted_message.startsWith("InvalidMessageException: ")){
                
            }
                System.out.println(encrypted_message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}