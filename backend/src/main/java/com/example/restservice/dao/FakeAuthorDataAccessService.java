package com.example.restservice.dao;

import com.example.restservice.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fake")
public class FakeAuthorDataAccessService implements AuthorDao {

    private static List<Author> DB = new ArrayList<>();

    @Override
    public int insertAuthor(UUID id, Author author) {
        DB.add(new Author(id, author.getName()));
        return 1;
    }

    @Override
    public List<Author> selectAllAuthors() {
        return DB;
    }

    @Override
    public Optional<Author> selectAuthorById(UUID id) {
        return DB.stream()
            .filter(author -> author.getId().equals(id))
            .findFirst();
    }

    @Override
    public int deleteAuthorById(UUID id) {
        Optional<Author> author = selectAuthorById(id);
        if (author.isEmpty()) {
            return 0;
        }
        DB.remove(author.get());
        return 1;
    }

    @Override
    public int updateAuthorById(UUID id, Author updateAuthor) {
        return selectAuthorById(id)
            .map(author -> {
                int indexOfAuthorToUpdate = DB.indexOf(author);
                if (indexOfAuthorToUpdate >= 0) {
                    DB.set(indexOfAuthorToUpdate, new Author(id, updateAuthor.getName()));
                    return 1;
                }
                return 0;
            }).orElse(0);
    }

}
