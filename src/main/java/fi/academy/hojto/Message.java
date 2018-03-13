package fi.academy.hojto;

import javax.persistence.*;

@Entity
public class Message {
    @Id @GeneratedValue
    private int id;
    private String message;
    private String user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Topic topicId;

    public Message() {
    }

    public Message(String message, String user) {
        this.message = message;
        this.user = user;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic getTopicId() {
        return topicId;
    }

    public void setTopicId(Topic topicId) {
        this.topicId = topicId;
    }

//        public int getTopicId() {
//        return topicId;
//    }
//
//    public void setTopicId(int topicId) {
//        this.topicId = topicId;
//    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", topicId=" + topicId +
                ", user='" + user + '\'' +
                '}';
    }
}
