/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interiordesignproject1;

/**
 *
 * @author batoolsaeed
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


class UserDetails {

    private String username;
    private String password;
    private String bankAccount;
    private String phoneNumber;
    private String email;
    private String preferredContactMethod;
    private int id;
    public UserDetails() {
    }

    public UserDetails(String username, String password, String bankAccount, String phoneNumber, String email, int id ,String preferredContactMethod) {
        this.username = username;
        this.password = password;
        this.bankAccount = bankAccount;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id=id;
        this.preferredContactMethod = preferredContactMethod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    public void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }
     public void askPreferredContactMethod() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("What is your preferred contact method (email/phone)? ");
            this.preferredContactMethod = scanner.nextLine().trim().toLowerCase();
            System.out.println("Debug: Preferred Contact Method is " + this.preferredContactMethod);

            if (!"email".equals(preferredContactMethod) && !"phone".equals(preferredContactMethod)) {
                System.out.println("Invalid choice. Defaulting to email.");
                this.preferredContactMethod = "email";
            }
        }
    }

    public void displayContactInfo() {
        System.out.println("Debug: Preferred Contact Method in displayContactInfo is " + preferredContactMethod);

        if ("email".equalsIgnoreCase(preferredContactMethod.trim())) {
            System.out.println("Contact via Email: " + email);
        } else if ("phone".equalsIgnoreCase(preferredContactMethod.trim())) {
            System.out.println("Contact via Phone: " + phoneNumber);
        } else {
            System.out.println("No valid contact method selected.");
        }
    }

    public void displayDetails() {
        System.out.println("User Details:");
        System.out.println("Username: " + username);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Bank Account: " + bankAccount);
        System.out.println("ID : " +id);
    }
    
    public static boolean isEmployee(int userId) {
    try (Connection conn = DBConnection.getConnection()) {
        String sql = "SELECT 1 FROM Employee WHERE Employee_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public static boolean isCustomer(int userId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT 1 FROM Customer WHERE Customer_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}



class Customer extends UserDetails {
    public String membershipLevel;
    private int usageCount;
    private int choice;
    
    public Customer() {
        super(); // Calls UserDetails default constructor
        this.membershipLevel = "Basic";
        this.usageCount = 1;
        this.choice = 1;
    }
    
    public Customer(String username, String password, String bankAccount, String phoneNumber, String email,int id, String preferredContactMethod){
       super(username, password, bankAccount, phoneNumber, email, id ,preferredContactMethod);
        this.usageCount = 1;
        this.membershipLevel = "Basic";    // Default membership level is "Basic"
        this.choice= 1;
    }

   public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }
    public void setUsageCount(int usageCount) {
        this.usageCount = usageCount;
        updateMembershipLevel();
    }
    public int getPreferencesOfCustomer() {
        return choice;
    }
    public void setPreferncesOfCustomer(int choice) {
        this.choice = choice;
    } 
     // Private method to update the membership level based on usage count
    private void updateMembershipLevel() {
        if (usageCount == 1) {
            setMembershipLevel("Basic"); // Basic level for 1 usage
      } else if (usageCount == 2) {
            setMembershipLevel("Silver"); // Silver level for 2 usages
      } else if (usageCount >= 3) {
            setMembershipLevel("Gold");  // Gold level for 3 or more usages
        }
    }     
}






class Employee extends UserDetails {
    private double totalIncome;
    private int employeeLevel;
    private double employeeIncome;
    private List<String> designsHandled;

    // Constructor
    public Employee(String username, String password, String bankAccount, String phoneNumber, String email, int id, String preferredContactMethod, double employeeIncome) {
        super(username, password, bankAccount, phoneNumber, email, id, preferredContactMethod);
        this.totalIncome = 0.0;
        this.employeeLevel = 1;
        this.employeeIncome = employeeIncome;
        this.designsHandled = new ArrayList<>();
    }

    // Getters and Setters
    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(int employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public double getEmployeeIncome() {
        return employeeIncome;
    }

    public void setEmployeeIncome(double employeeIncome) {
        this.employeeIncome = employeeIncome;
    }

    public List<String> getDesignsHandled() {
        return designsHandled;
    }

    public void setDesignsHandled(List<String> designsHandled) {
        this.designsHandled = designsHandled;
    }

    // Add Design
    public void addDesign(String designName, double designIncome) {
        if (designIncome < 0) {
            System.out.println("Error: Design income cannot be negative.");
            return;
        }

        if (this.totalIncome + designIncome > 10000.0) {
            System.out.println("Error: Exceeds max monthly income.");
        } else {
            designsHandled.add(designName);
            this.totalIncome += designIncome;
            updateEmployeeLevel();
        }
    }

    public void updateEmployeeLevel() {
        int count = designsHandled.size();
        if (count >= 10) employeeLevel = 5;
        else if (count >= 5) employeeLevel = 4;
        else if (count >= 2) employeeLevel = 3;
        else employeeLevel = 2;
    }

    public void displayEmployee() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("ID: " + getId());
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Level: " + employeeLevel);
        System.out.println("Designs: " + (designsHandled.isEmpty() ? "None" : String.join(", ", designsHandled)));
    }

    // ✅ Insert into UserDetails
    public void insertEmployeeToUserDetails() {
        String sql = "INSERT INTO UserDetails (USER_id, username, password, phoneNumber, email, bankAccount, preferredContactMethod) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, getId());
            stmt.setString(2, getUsername());
            stmt.setString(3, getPassword());
            stmt.setString(4, getPhoneNumber());
            stmt.setString(5, getEmail());
            stmt.setString(6, getBankAccount());
            stmt.setString(7, getPreferredContactMethod());

            stmt.executeUpdate();
            System.out.println("✅ Inserted into UserDetails.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to insert into UserDetails.");
            e.printStackTrace();
        }
    }

    // ✅ Insert into Employee table
    public void insertEmployeeToDB() {
        String sql = "INSERT INTO Employee (Employee_id, employeeLevel, employeeIncome, designsHandled, employeeName, MAX_MONTHLY_INCOME, totalIncome) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, getId());
            stmt.setInt(2, getEmployeeLevel());
            stmt.setDouble(3, getEmployeeIncome());

            StringBuilder designsBuilder = new StringBuilder();
            for (String design : getDesignsHandled()) {
                designsBuilder.append(design).append(",");
            }
            String designsHandledStr = designsBuilder.length() > 0
                    ? designsBuilder.substring(0, designsBuilder.length() - 1)
                    : "";

            stmt.setString(4, designsHandledStr);
            stmt.setString(5, getUsername()); // employeeName
            stmt.setDouble(6, 10000.0); // Max monthly income ثابت
            stmt.setDouble(7, getTotalIncome());

            stmt.executeUpdate();
            System.out.println("✅ Inserted into Employee table.");
        } catch (SQLException e) {
            System.err.println("❌ Failed to insert into Employee.");
            e.printStackTrace();
        }
    }

    // ✅ Fetch all employees from Employee table
    public static List<Employee> getAllEmployeesFromDB() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Employee emp = new Employee(
                        rs.getString("employeeName"),
                        "", "", "", "", // password, bank, phone, email مش موجودة في جدول Employee
                        rs.getInt("Employee_id"),
                        "email", // contact method افتراضي
                        rs.getDouble("employeeIncome")
                );

                emp.setEmployeeLevel(rs.getInt("employeeLevel"));
                emp.setTotalIncome(rs.getDouble("totalIncome"));

                String handled = rs.getString("designsHandled");
                if (handled != null && !handled.isEmpty()) {
                    String[] designs = handled.split(",");
                    for (String d : designs) {
                        emp.getDesignsHandled().add(d.trim());
                    }
                }

                employees.add(emp);
            }

        } catch (SQLException e) {
            System.err.println("❌ Failed to fetch employees.");
            e.printStackTrace();
        }

        return employees;
    }
}