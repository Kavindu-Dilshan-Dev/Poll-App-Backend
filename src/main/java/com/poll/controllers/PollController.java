package com.poll.controllers;

import com.poll.model.Poll;
import com.poll.services.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {


    private final PollService pollService;

    @PostMapping("/add-poll")
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }
}
