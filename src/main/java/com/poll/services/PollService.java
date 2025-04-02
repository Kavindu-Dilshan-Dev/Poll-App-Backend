package com.poll.services;

import com.poll.model.OptionVote;
import com.poll.model.Poll;
import com.poll.repositories.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollRepository;

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public ResponseEntity<Poll> getPollById(Long id) {
        return pollRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    public void vote(Long pollId, int optionIndex) {
        // get poll from db
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(()-> new RuntimeException("Poll Not Found!"));

        // get all options
        List<OptionVote> options = poll.getOptions();

        // if index for vote is not valid
        if (optionIndex < 0 || optionIndex >= options.size()){
            throw new IllegalArgumentException("Invalid Option Index");
        }

        // get selected option
        OptionVote selectedOption = options.get(optionIndex);

        // Increment vote for selected option

        selectedOption.setVoteCount(selectedOption.getVoteCount() +1);

        // save incremented option into database

        pollRepository.save(poll);
    }
}
