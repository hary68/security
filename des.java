import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;
public class des{
    private static Cipher encryptionCipher;
    private static Cipher decryptionCipher;
    public static void InitSecretKey(SecretKey key)throws Exception{
        encryptionCipher=Cipher.getInstance("DES");
        decryptionCipher=Cipher.getInstance("DES");
        encryptionCipher.init(Cipher.ENCRYPT_MODE,key);
        decryptionCipher.init(Cipher.DECRYPT_MODE,key);
    
    }
    public static String encrypt(String Str)throws Exception{
        byte[] messageBytes=Str.getBytes(StandardCharsets.UTF_8);
        byte[] encodeBytes=encryptionCipher.doFinal(messageBytes);
        return new String(Base64.getEncoder().encode(encodeBytes));
    

    }
    public static String decrypt(String Str)throws Exception{
        byte[] decodedBytes=Base64.getDecoder().decode(Str);
        byte[] messageBytes=decryptionCipher.doFinal(decodedBytes);
        return new String(messageBytes,StandardCharsets.UTF_8);
    }
    public static void main(String[]argv){
        try{
            SecretKey key=KeyGenerator.getInstance("DES").generateKey();
            System.out.print(key);
            InitSecretKey(key);
            Scanner sc=new Scanner(System.in);
            System.out.println("");
            System.out.println("DES Algorithm");
            System.out.println("Enter The Message:");
            String message;
            message=sc.nextLine();
            String encryptedString="";
            String decryptedString="";
            try{
                encryptedString=encrypt(message);
                decryptedString=decrypt(encryptedString);
            }
        catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println();
        System.out.println("Cipher Text:"+encryptedString );
        System.out.println("plainText:"+decryptedString);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}