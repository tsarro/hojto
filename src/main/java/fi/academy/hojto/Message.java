package fi.academy.hojto;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Message {
    @Id @GeneratedValue
    private int id;
    private String content;
    private String nickname;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn (name="topicid")
    private Topic topicId;

    public Message() {
    }

    public Message(String content, String nickname) {
        this.content = content;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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


    @Override
    public String toString() {
        return "Message{" +
//                "id=" + id +
                ", content='" + content + '\'' +
                ", nickname='" + nickname + '\'' +
//                ", topicId=" + topicId +
                '}';
    }
}
