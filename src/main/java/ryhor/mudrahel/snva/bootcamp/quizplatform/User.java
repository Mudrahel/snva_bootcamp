package ryhor.mudrahel.snva.bootcamp.quizplatform;

import java.util.Objects;

public class User {
    private String username;
    private String password;
    private String email;
    private String address;
    private String mobileNo;
    private String techInterest;

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, String email, String address, String mobileNo, String techInterest) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.mobileNo = mobileNo;
        this.techInterest = techInterest;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getTechInterest() {
        return techInterest;
    }

    public void setTechInterest(String techInterest) {
        this.techInterest = techInterest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
