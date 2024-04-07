package edu.miu.springaop.service;

import edu.miu.springaop.entity.Comment;
import edu.miu.springaop.repository.CommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepo commentRepo;
    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepo.findAll();
    }
}
