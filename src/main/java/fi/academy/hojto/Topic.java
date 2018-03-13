package fi.academy.hojto;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {
    @Id @GeneratedValue
    private int id;
    private int categoryId;
    private String header;
    private String user;
    private String firstmessage;
    @OneToMany(mappedBy = "topicId")
    private List<Message> messages;

    public Topic() {
    }

    public Topic(int categoryId, String header, String user, String firstmessage) {
        this.categoryId = categoryId;
        this.header = header;
        this.user = user;
        this.firstmessage = firstmessage;
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

    public String getFirstmessage() {
        return firstmessage;
    }

    public void setFirstmessage(String firstmessage) {
        this.firstmessage = firstmessage;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
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
                ", categoryId=" + categoryId +
                ", header='" + header + '\'' +
                ", user='" + user + '\'' +
                ", firstmessage='" + firstmessage + '\'' +
                ", messages=" + messages +
                '}';
    }
}
