public class app1 {
    private User[] users;
    private int loggedInUser;
    private static int nUsers = 0;

    public app1() {
        users = new User[1];
        loggedInUser = -1;

    }

    public void addUser( String name, String  address, double moneyAmount, String pin) {
        if (nUsers >= users.length) {
            increaseArray();
        }
        users[nUsers] = new User(name.toLowerCase(), address, moneyAmount, pin);
        nUsers++;
    }
    private void increaseArray() {
        User[] tmp = new User[users.length * 2];

        for (int i = 0; i < users.length; i++) {
            tmp[i] = users[i];

        }
        users = tmp;
    }
    public boolean login(String name, String pin) {
        boolean success = false;

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].name.toLowerCase().equals(name.toLowerCase()) && users[i].pin.equals(pin)) {
                    success = true;
                    loggedInUser = i;
                }
            }
        }
        return success;
    }
    public double withdraw(double amount) {
        if (loggedInUser == -1) return -1;
        if (users[loggedInUser].moneyAmount < amount) {
            return -1;
        }
        users[loggedInUser].moneyAmount -= amount;
        return amount;
    }

    public void deposit(double amount) {
        if (loggedInUser == -1) return;
        users[loggedInUser].moneyAmount += amount;
    }
    public void logout() {
        loggedInUser = -1;
    }
    private class User {
        String name, address, pin;
        double moneyAmount;

        User(String name, String add, double money, String pin) {
            this.name = name;
            address = add;
            moneyAmount = money;
            this.pin = pin;

        }
        User(String name, String address, String pin) {
            this.name = name;
            this.pin = pin;
            this.address = address;
            moneyAmount = 0.0;


        }
    }
}

