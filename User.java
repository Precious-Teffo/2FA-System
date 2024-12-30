import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String otp;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public void saveToDatabase() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2fa_system", "your_username", "your_password");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (username, password, otp) VALUES (?, ?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, otp);
            pstmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println("Error saving user to database: " + e.getMessage());
        }
    }

    public static User getUserFromDatabase(String username) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2fa_system", "your_username", "your_password");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"));
                user.setOtp(rs.getString("otp"));
                conn.close();
                return user;
            } else {
                conn.close();
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error getting user from database: " + e.getMessage());
            return null;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the User System!");
        System.out.println("Please select an option:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (choice) {
            case 1:
                login(scanner);
                break;
            case 2:
                register(scanner);
                break;
            case 3:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
    }
    private static void login(Scanner scanner) {
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        // TO DO: Implement login logic here
        System.out.println("Login successful!");
    }

    private static void register(Scanner scanner) {
        System.out.println("Enter your desired username:");
        String username = scanner.nextLine();

        System.out.println("Enter your desired password:");
        String password = scanner.nextLine();

        // TO DO: Implement registration logic here
        System.out.println("Registration successful!");
    }

}