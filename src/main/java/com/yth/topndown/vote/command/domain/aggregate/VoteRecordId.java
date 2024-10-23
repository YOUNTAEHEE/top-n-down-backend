package com.yth.topndown.vote.command.domain.aggregate;//package com.yth.topndown.vote.command.domain.aggregate;
//
//import jakarta.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class VoteRecordId implements Serializable {
//
//    private Long postId;
//    private String ipAddress;
//
//    // 기본 생성자
//    public VoteRecordId() {}
//
//    // 필드를 사용하는 생성자
//    public VoteRecordId(Long postId, String ipAddress) {
//        this.postId = postId;
//        this.ipAddress = ipAddress;
//    }
//
//    // equals 메서드 재정의
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        VoteRecordId that = (VoteRecordId) o;
//        return Objects.equals(postId, that.postId) && Objects.equals(ipAddress, that.ipAddress);
//    }
//
//    // hashCode 메서드 재정의
//    @Override
//    public int hashCode() {
//        return Objects.hash(postId, ipAddress);
//    }
//
//    // Getters and Setters (필요에 따라 생성)
//    public Long getPostId() {
//        return postId;
//    }
//
//    public void setPostId(Long postId) {
//        this.postId = postId;
//    }
//
//    public String getIpAddress() {
//        return ipAddress;
//    }
//
//    public void setIpAddress(String ipAddress) {
//        this.ipAddress = ipAddress;
//    }
//}


//package com.yth.topndown.vote.command.domain;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class VoteRecordId implements Serializable {
//
//    @Column(name = "post_id", nullable = false)
//    private Long postId;
//
//    @Column(name = "device_id", nullable = false)
//    private String deviceId;
//
//    // 기본 생성자
//    public VoteRecordId() {}
//
//    // 필드를 사용하는 생성자
//    public VoteRecordId(Long postId, String deviceId) {
//        this.postId = postId;
//        this.deviceId = deviceId;
//    }
//
//    // Getters and Setters
//    public Long getPostId() {
//        return postId;
//    }
//
//    public void setPostId(Long postId) {
//        this.postId = postId;
//    }
//
//    public String getDeviceId() {
//        return deviceId;
//    }
//
//    public void setDeviceId(String deviceId) {
//        this.deviceId = deviceId;
//    }
//
//    // equals와 hashCode 메서드 재정의
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        VoteRecordId that = (VoteRecordId) o;
//        return Objects.equals(postId, that.postId) && Objects.equals(deviceId, that.deviceId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(postId, deviceId);
//    }
//}


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VoteRecordId implements Serializable {

    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Column(name = "device_id", nullable = false)
    private String deviceId;

    // 기본 생성자
    public VoteRecordId() {}

    // 필드를 사용하는 생성자
    public VoteRecordId(Long postId, String deviceId) {
        this.postId = postId;
        this.deviceId = deviceId;
    }

    // Getters and Setters
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    // equals와 hashCode 메서드 재정의
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteRecordId that = (VoteRecordId) o;
        return Objects.equals(postId, that.postId) && Objects.equals(deviceId, that.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, deviceId);
    }
}