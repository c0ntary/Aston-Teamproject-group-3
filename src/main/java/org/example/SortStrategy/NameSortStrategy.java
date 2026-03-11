package org.example.SortStrategy;

import org.example.User;

import java.util.List;

public class NameSortStrategy implements SortStrategy{

    @Override
    public void sort(List<User> users) {
        users.sort((user1, user2) ->
                user1.getName().compareTo(user2.getName()));
    }
}
