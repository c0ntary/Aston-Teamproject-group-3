package org.example.SortStrategy;

import org.example.User;

import java.util.List;

public class IdSortStrategy implements SortStrategy {
    @Override
    public void sort(List<User> users) {
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = 0; j < users.size() - i - 1; j++) {
                if (users.get(j).getId().compareTo(users.get(j + 1).getId()) > 0) {

                    User temp = users.get(j);
                    users.set(j, users.get(j + 1));
                    users.set(j + 1, temp);
                }
            }
        }
    }
}
