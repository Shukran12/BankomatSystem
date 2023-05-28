public class Users {
    private String name;
    private String pass;
    private int balance;





    public Users(String name, String pass, int balance) {
        this.name = name;
        this.pass = pass;
        this.balance = balance;
    }

    public String getName() {

        return name;
    }

    public String getPass() {
        return pass;
    }

    public int getBalance() {
        return balance;
    }
    public int setBalance(int balance){
        this.balance = balance;
        return balance;
    }


}
