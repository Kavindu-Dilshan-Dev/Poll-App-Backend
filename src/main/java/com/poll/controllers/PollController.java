package com.poll.controllers;

import com.poll.model.Poll;
import com.poll.services.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import request.Vote;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {


    private final PollService pollService;

    @PostMapping("/add-poll")
    public Poll createPoll(@RequestBody Poll poll){
        return pollService.createPoll(poll);
    }

    @GetMapping("/get-all-polls")
    public List<Poll> getAllPolls(){
        return pollService.getAllPolls();
    }

    @GetMapping("/get-poll-by-id/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long id){
        return pollService.getPollById(id);
    }

    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote){
         pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }

}
