package org.example.SortStrategy;

import org.example.User;

import java.util.List;

public class EmailSortStrategy implements SortStrategy {
    @Override
    public void sort(List<User> users) {
        users.sort((user1, user2) ->
                user1.getEmail().compareTo(user2.getEmail())
        );
    }
}