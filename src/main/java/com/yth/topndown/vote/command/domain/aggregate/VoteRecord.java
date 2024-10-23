//package com.yth.topndown.vote.command.domain.aggregate;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "vote_records")
//public class VoteRecord {
//
//    @EmbeddedId
//    private VoteRecordId id;
//
//    @Column(nullable = false)
//    private String voteType; // "up" 또는 "down"
//
//    // 기본 생성자
//    public VoteRecord() {}
//
//    // 필드를 사용하는 생성자
//    public VoteRecord(VoteRecordId id, String voteType) {
//        this.id = id;
//        this.voteType = voteType;
//    }
//
//    // Getters and Setters
//    public VoteRecordId getId() {
//        return id;
//    }
//
//    public void setId(VoteRecordId id) {
//        this.id = id;
//    }
//
//    public String getVoteType() {
//        return voteType;
//    }
//
//    public void setVoteType(String voteType) {
//        this.voteType = voteType;
//    }
//}
package com.yth.topndown.vote.command.domain.aggregate;

import jakarta.persistence.*;

@Entity
@Table(name = "vote_records")
public class VoteRecord {

    @EmbeddedId
    private VoteRecordId id;

    @Column(nullable = false)
    private String voteType; // "up" 또는 "down"

    // 기본 생성자
    public VoteRecord() {}

    // 필드를 사용하는 생성자
    public VoteRecord(VoteRecordId id, String voteType) {
        this.id = id;
        this.voteType = voteType;
    }

    // Getters and Setters
    public VoteRecordId getId() {
        return id;
    }

    public void setId(VoteRecordId id) {
        this.id = id;
    }

    public String getVoteType() {
        return voteType;
    }

    public void setVoteType(String voteType) {
        this.voteType = voteType;
    }
}
