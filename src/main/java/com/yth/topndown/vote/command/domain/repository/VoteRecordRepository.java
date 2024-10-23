package com.yth.topndown.vote.command.domain.repository;

import com.yth.topndown.vote.command.domain.aggregate.VoteRecord;
import com.yth.topndown.vote.command.domain.aggregate.VoteRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRecordRepository extends JpaRepository<VoteRecord, VoteRecordId> {

    // 특정 게시물에 대해 특정 디바이스가 이미 투표했는지 확인하는 메서드
    boolean existsByPostIdAndDeviceId(Long postId, String deviceId);
}
