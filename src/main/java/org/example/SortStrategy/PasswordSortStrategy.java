package org.example.SortStrategy;

import org.example.User;

import java.util.List;

public class PasswordSortStrategy implements SortStrategy {
    @Override
    public void sort(List<User> users) {
        users.sort((user1, user2) ->
                user1.getPassword().compareTo(user2.getPassword()));
    }
}
