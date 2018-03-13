package fi.academy.hojto;

import javax.persistence.*;

@Entity
public class Topic {
    @Id @GeneratedValue
    private int id;
    private int categoryId;
    private String header;
    private String user;
    private String firstMessage;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "message")
    private Message message;

    public Topic() {
    }

    public Topic(int categoryId, String header, String user, String firstMessage) {
        this.categoryId = categoryId;
        this.header = header;
        this.user = user;
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

    public String getFirstMessage() {
        return firstMessage;
    }

    public void setFirstMessage(String firstMessage) {
        this.firstMessage = firstMessage;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
