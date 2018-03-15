package fi.academy.hojto;

        import javax.persistence.*;
        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.util.List;

@Entity
public class Topic {
    @Id @GeneratedValue
    private int id;
    @Column(name = "category_id")
    private int categoryId;
    private String header;
    private String user;
    private String firstmessage;
    private String ttimestamp;
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

    public Topic(int categoryId, String header, String user, String firstmessage, String ttimestamp) {
        this.categoryId = categoryId;
        this.header = header;
        this.user = user;
        this.firstmessage = firstmessage;
        this.ttimestamp = ttimestamp;
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

    public String getTtimestamp() {
        return ttimestamp;
    }

    public void setTtimestamp(String ttimestamp) {
        this.ttimestamp = ttimestamp;
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
