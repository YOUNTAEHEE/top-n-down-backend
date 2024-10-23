package com.yth.topndown.vote.command.application.service;

import com.yth.topndown.vote.command.domain.aggregate.VoteRecord;
import com.yth.topndown.vote.command.domain.aggregate.VoteRecordId;
import com.yth.topndown.vote.command.domain.repository.VoteRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteRecordService {

    private final VoteRecordRepository voteRecordRepository;

    @Autowired
    public VoteRecordService(VoteRecordRepository voteRecordRepository) {
        this.voteRecordRepository = voteRecordRepository;
    }

    /**
     * 특정 디바이스가 특정 게시물에 대해 이미 투표했는지 확인합니다.
     *
     * @param postId   게시물 ID
     * @param deviceId 디바이스 ID
     * @return 이미 투표했으면 true, 아니면 false
     */
    public boolean hasVoted(Long postId, String deviceId) {
        VoteRecordId voteRecordId = new VoteRecordId(postId, deviceId);
        return voteRecordRepository.existsById(voteRecordId);
    }

    /**
     * 투표를 기록합니다.
     *
     * @param postId   게시물 ID
     * @param deviceId 디바이스 ID
     */
    public void recordVote(Long postId, String deviceId) {
        VoteRecordId voteRecordId = new VoteRecordId(postId, deviceId);
        VoteRecord voteRecord = new VoteRecord(voteRecordId, "up"); // 또는 "down"으로 설정 가능
        voteRecordRepository.save(voteRecord);
    }
}
