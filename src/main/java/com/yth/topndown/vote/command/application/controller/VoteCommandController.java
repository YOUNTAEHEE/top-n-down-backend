package com.yth.topndown.vote.command.application.controller;

import com.yth.topndown.vote.command.application.service.VoteRecordService;
import com.google.common.hash.Hashing;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api")
public class VoteCommandController {

    private final VoteRecordService voteRecordService;

    @Autowired
    public VoteCommandController(VoteRecordService voteRecordService) {
        this.voteRecordService = voteRecordService;
    }

    @PostMapping("/vote")
    public ResponseEntity<String> vote(@RequestParam Long postId, HttpServletRequest request) {
        String deviceId = generateDeviceId(request);  // 디바이스 ID 생성

        if (voteRecordService.hasVoted(postId, deviceId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("이미 투표한 디바이스입니다.");
        }

        voteRecordService.recordVote(postId, deviceId);
        return ResponseEntity.ok("투표가 완료되었습니다.");
    }

    private String generateDeviceId(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        String acceptHeader = request.getHeader("Accept");
        String deviceId = userAgent + acceptHeader; // 간단한 예시, 실제로는 더 복잡하게 구성 가능

        return Hashing.sha256().hashString(deviceId, StandardCharsets.UTF_8).toString();
    }
}
