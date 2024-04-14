package second.statement;

/**
 * @author shkstart
 * @date: 2022.09.17
 */
public class User {
    private String user;
    private String password;

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [user=" + this.user + ", password=" + this.password + "]";
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
