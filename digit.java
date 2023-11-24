import java.util.*;
import java.math.BigInteger;
import java.security.*;
public class digit{
    public static byte[] generateSignature(byte[] messageBytes,PrivateKey Key)throws Exception{
        Signature signature=Signature.getInstance("SHA256withRSA");
        signature.initSign(Key);
        signature.update(messageBytes);
        return signature.sign();
    }
    public static KeyPair generateRSAKeyPair() throws Exception{
        SecureRandom secureRandom=new SecureRandom();
        KeyPairGenerator keyPairGenerator= KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048,secureRandom);
        return keyPairGenerator.generateKeyPair();
    }
    public static boolean isVerifiedSignature(byte[] messageBytes,byte[] signatureGenerated,PublicKey publicKey){
        try{
            Signature signature=Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(messageBytes);
            return signature.verify(signatureGenerated);
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Digital standard signature\n");
        System.out.println("Enter message from sender side");
        String message=sc.next();
        try{
            KeyPair keyPair=generateRSAKeyPair();
            byte[] signature=generateSignature(message.getBytes(),keyPair.getPrivate());
            System.out.println();
            System.out.println("Signature Generated");
            for(byte b:signature){
                String hex=String.format("%02x",b);
                System.out.print(hex);
            }
            System.out.println("\n Enter message for receiver side");
            String message1=sc.next();
            KeyPair keyPair1=generateRSAKeyPair();
            byte[] signature1=generateSignature(message.getBytes(),keyPair.getPrivate());
            System.out.println("\n");
            if(isVerifiedSignature(message1.getBytes(),signature, keyPair.getPublic())){
                System.out.println("Signature is verified");
            }else{
                System.out.println("Signature is not verified");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}