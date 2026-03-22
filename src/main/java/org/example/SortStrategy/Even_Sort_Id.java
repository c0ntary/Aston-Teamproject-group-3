package org.example.SortStrategy;

import org.example.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class Even_Sort_Id implements SortStrategy {
    @Override
    public void sort(List<User> users) {
        List<User> evenUsers = new ArrayList<>();
        List<Integer> evenIndices = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() % 2 == 0) { //Четный айди
                evenUsers.add(users.get(i));
                evenIndices.add(i);
            }
        }

        for (int i = 0; i < evenUsers.size() - 1; i++) {
            for (int j = 0; j < evenUsers.size() - i - 1; j++) {
                if (evenUsers.get(j).getId() > (evenUsers.get(j + 1).getId())) {
                    User temp = evenUsers.get(j);
                    evenUsers.set(j, evenUsers.get(j + 1));
                    evenUsers.set(j + 1, temp);
                }
            }

        }
        for (int k = 0; k < evenIndices.size(); k++) {
            users.set(evenIndices.get(k), evenUsers.get(k));
        }
    }
}
