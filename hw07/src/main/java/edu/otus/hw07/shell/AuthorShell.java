package edu.otus.hw07.shell;

import edu.otus.hw07.entities.Author;
import edu.otus.hw07.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * Created by Nik Bespalov on 17/07/2018.
 *
 * @author Nik Bespalov.
 */
@ShellComponent
public class AuthorShell {

    private final AuthorService authorService;

    @Autowired
    public AuthorShell(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod("add author")
    public void add_author(@ShellOption String name) {
        authorService.add(Author.builder().authorName(name).build());
    }

    @ShellMethod("remove author")
    public void remove_author(@ShellOption String name) {
        authorService.remove(Author.builder().authorName(name).build());
    }

    @ShellMethod("get all authors")
    public void get_all_authors() {
        authorService.getAll().forEach(System.out::println);
    }

    @ShellMethod("get by name")
    public void get_author(@ShellOption String name) {
        System.out.println(authorService.getByName(name));
    }
}
