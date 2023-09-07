package mml.wallet.domain.entities;

public class User {
    private String documentNumber;
    private String name;
    private String email;
    private String password;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    double balance;
    public User(String documentNumber, String name, String email, String password) {
        this.documentNumber = documentNumber;
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
