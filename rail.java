import java.util.*;
class rail{
  public static void main(String[] args)throws java.lang.Exception{
    railfencecipherhelper rf=new railfencecipherhelper();
    String msg,enc,dec;
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the plain text");
    msg=System.console().readLine();
    int depth;
    System.out.println("enter the key");
    depth=sc.nextInt();
    enc=rf.encode(msg,depth);
    dec=rf.decode(enc,depth);
    //System.out.println("plain text "+msg);
    System.out.println("encrypted message :"+enc);
    System.out.println("decrypted message :"+dec);
  }
}
class railfencecipherhelper{
  int depth;
  String encode(String msg,int depth) throws Exception{
    int r=depth;
    int l=msg.length();
    int c=l/depth;
    c=c+1;
    int k=0;
    char mat[][]=new char[r][c];
    String enc="";
    for(int i=0;i<c;i++){
      for(int j=0;j<r;j++){
         if(k!=l){
           mat[j][i]=msg.charAt(k++);
         }
         else{
           mat[j][i]='X';
         }
      }
    }
    for(int i=0;i<r;i++){
      for(int j=0;j<c;j++){
         enc+=mat[i][j];
      }
    }
    return enc;
  }
  String decode(String encmsg,int depth)throws Exception{
    int r=depth;
    int l=encmsg.length();
    int c=l/depth;
    int k=0;
    char mat[][]=new char[r][c];
    String dec="";
    for(int i=0;i<r;i++){
      for(int j=0;j<c;j++){
        mat[i][j]=encmsg.charAt(k++);
      }
    }
    for(int i=0;i<c;i++){
      for(int j=0;j<r;j++){
        dec+=mat[j][i];
      }
    }
    return dec;
  }
}
