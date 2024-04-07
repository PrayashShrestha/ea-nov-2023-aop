package edu.miu.springaop.controller;

import edu.miu.springaop.service.CommentService;
import edu.miu.springaop.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Comment save(Comment comment){
       return commentService.save(comment);
    }

    @GetMapping
    public List<Comment> getAll(){
       return commentService.getAll();
    }
}
