package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
//не нуждается в хранении в локальном репозитории
//Чтобы заработало Vote Story нужно user menu place уже хранить в базе
//Так как нужна связка
@Entity
@Table(name = "votestory")
public class VoteStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id", nullable = false)
    @Range(min = 1, max = 100000)
    @NotNull
    private Long userId;
    @Column(name = "place_id", nullable = false)
    @Range(min = 1, max = 100000)
    @NotNull
    private Long placeId;
    @Column(name = "vote_date", columnDefinition = "timestamp default now()")
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date voteDate;

    public VoteStory() {
    }

    public VoteStory(Long userId, Long placeId) {
        this.userId = userId;
        this.placeId = placeId;
        voteDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }
}
