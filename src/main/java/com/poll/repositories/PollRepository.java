package com.poll.repositories;

import com.poll.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PollRepository extends JpaRepository<Poll,Long> {
}
