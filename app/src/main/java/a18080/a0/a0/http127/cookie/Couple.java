package a18080.a0.a0.http127.cookie;

public class Couple {
    // Fields
    private String coupleName;
    private String anniversary;
    private String password;
    private String name1;
    private String name2;
    private String birthday1;
    private String birthday2;
    private String email1;
    private String email2;

    // Constructors
    public Couple() {}
    public Couple(String[] input) {
        this.coupleName = input[0];
        this.anniversary = input[1];
        this.password = input[2];
        this.name1 = input[4];
        this.birthday1 = input[5];
        this.email1 = input[6];
        this.name2 = input[7];
        this.birthday2 = input[8];
        this.email2 = input[9];
    }

    // Properties
    public void setPassword(String pw) {
        this.password = pw;
    }

    public String getCoupleName() {
        return this.coupleName;
    }

    public void setCoupleName(String name) {
        this.coupleName = name;
    }

    public String getAnniversary() {
        return this.anniversary;
    }

    public String getName(int n) {
        if(n == 1) return this.name1;
        else return this.name2;
    }

    public void setName(int n, String name) {
        if(n == 1) this.name1 = name;
        else this.name2 = name;
    }
}
