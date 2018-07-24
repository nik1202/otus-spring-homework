package edu.otus.hw06.service.impl;

import edu.otus.hw06.entities.Book;
import edu.otus.hw06.entities.Comment;
import edu.otus.hw06.repository.CommentRepository;
import edu.otus.hw06.service.BookService;
import edu.otus.hw06.service.CommentService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Nik Bespalov on 22/07/2018.
 *
 * @author Nik Bespalov.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final BookService bookService;

    public CommentServiceImpl(CommentRepository commentRepository, BookService bookService) {
        this.commentRepository = commentRepository;
        this.bookService = bookService;
    }

    @Override
    public void add(@NotNull Comment comment) {
        Book existBook = bookService.getByTitle(comment.getBook().getTitle());
        if (existBook != null) {
            comment.setBook(existBook);
            commentRepository.insert(comment);
        }
    }

    @Override
    public void remove(Comment comment) {
        commentRepository.remove(comment);
    }

    @Override
    public List<Comment> getByBookTitle(String bookTitle) {
        return commentRepository.getByBook(bookTitle);
    }
}
