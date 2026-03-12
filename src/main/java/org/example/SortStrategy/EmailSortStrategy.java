package org.example.SortStrategy;

import org.example.SortStrategy.Entity.User;


import java.util.List;

public class EmailSortStrategy implements SortStrategy {
    @Override
    public void sort(List<User> users) {
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = 0; j < users.size() - i - 1; j++) {
                if (users.get(j).getEmail().compareTo(users.get(j + 1).getEmail()) > 0) {

                    User temp = users.get(j);
                    users.set(j, users.get(j + 1));
                    users.set(j + 1, temp);
                }
            }
        }
    }

}