package password_generator;
import java.util.Random;
public class password_generator_logic {
  public final String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  public final String lower="abcdefghijklmnopqrstuvwxyz";
  public final String number="0123456789";
  public final String symbol="!@#$%^&*()-_=+[]{};:,.<>/?";
 
  public final Random random;
  public password_generator_logic()
  {
 random=new Random();
  }
  public String generate_password(int length,boolean isupper,boolean islower,boolean isnumber,boolean issymbol)
  {
 StringBuilder password=new StringBuilder();
 String characters="";
 if(isupper)
 {
 characters+=upper;
 }
 if(islower)
 {
 characters+=lower;
 }
 if(isnumber)
 {
 characters+=number;
 }
 if(issymbol)
 {
 characters+=symbol;
 }
 for(int i=0;i<length;i++)
 {
 int index=random.nextInt(characters.length());
 char temp=characters.charAt(index);
 password.append(temp);
 }
 return password.toString();
  }
}

