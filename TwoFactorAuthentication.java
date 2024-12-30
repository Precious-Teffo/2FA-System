
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HC
 */
public class TwoFactorAuthentication {
    public static String generateOtp(){
        
        Random rand=new Random();
        int otp=rand.nextInt(999999);
        return String.valueOf(otp);
    }
    public static boolean verifyOtp(User user,String otp){
        return user.getOtp().equals(otp);
    }
    public static void main(String[] args){
        User user=new User("PreciousDoe","Khutso123");
        
        while(true){
            String loginMenu="1.Login\n2.Register\n3.Exit";
            String choice= JOptionPane.showInputDialog(loginMenu);
            
            if(choice.equals("1")){
                String username = JOptionPane.showInputDialog("Enter your username");
                String password = JOptionPane.showInputDialog("Enter your password");
                
                if(user.equals( user.getUsername())&& password.equals(user.getPassword())){
                    String otp=TwoFactorAutheticaation.generateOtp();
                    
                    user.setOtp(otp);
                    JOptionPane.showMessageDialog(null,"Your OTP is:" +otp);
                    
                    String inputOtp=JOptionPane.showInputDialog("Enter your OTP");
                    
                    if(TwoFactorAuthentication.verifyOtp(user, inputOtp)){
                        JOptionPane.showMessageDialog(null, "Login sucessful!");
                    }else{
                        JOptionPane.showMessageDialog(null, "invalid OTP");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Inavlid usernameor ");
                }
            }else if(choice.equals("2")){
                String newUsername=JOptionPane.showInputDialog("Enter your new username:");
                String newPassword=JOptionPane.showInputDialog("Enter your new password:");
                
                user=new User(newUsername,newPassword);
                
                JOptionPane.showMessageDialog(null, "Registration successful!");
            }else if(choice.equals("3")){
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid choice!");
            }
                
            }
            
        }
    }

