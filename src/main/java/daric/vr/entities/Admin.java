package daric.vr.entities;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Admin.getAdmin", query = "select admin from Admin admin where admin.mail = :mail")
@Table (name = "ADMIN")
public class Admin {
    @Id
    @GeneratedValue
    @Column (name = "ADMIN_ID")
    private int adminId;

    @Column(name = "PASSWORD", length = 20, nullable = false)
    private String password;

    @Column(name = "MAIL", length = 20, nullable = false)
    private String mail;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
