package com.example.restapitest.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import com.example.restapitest.modal.Book;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class BookServiceImpl implements BookService {

    HashSet<Book> bookList = new HashSet<Book>();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAllBook() {
       /* if (bookList.isEmpty())
            return null;
        else
            return bookList; */
        String sql = "SELECT * FROM Books";

        List<Book> books = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Book.class));

        return books;
    }
    @Override
    public Book findBookByID(long id) {
        //Book book = bookList.stream().filter(b -> b.getId() == id).findAny().orElse(null);
        //return book;

        String sql = "SELECT * FROM Books WHERE ID = ?";

        return (Book) jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new BeanPropertyRowMapper(Book.class));
    }

    @Override
    public void addBook(Book b) {
        //bookList.add(b);
        String sql = "INSERT INTO Books (id, name, title) VALUES (?, ?, ?)";

        int result = jdbcTemplate.update(sql, b.getId(), b.getName(), b.getTitle());

        if (result > 0) {
            System.out.println("A new row has been inserted.");
        }
    }

    @Override
    public void deleteAllData() {
        bookList.clear();
    }
}

