package edu.miu.springaop.service;

import edu.miu.springaop.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {

    Comment save(Comment comment);

    List<Comment> getAll();
}
