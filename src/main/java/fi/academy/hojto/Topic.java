package fi.academy.hojto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topic {
    @Id @GeneratedValue
    private int id;
    private String header;
    private String user;
    private String message;

    public Topic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
