package Model;

public class User {
    private String id;
    private String firstname;
    private String lastname;
    private String imageurl;
    private String email;

    public User(String id, String firstname, String lastname, String imageurl, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.imageurl = imageurl;
        this.email = email;
    }
    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
