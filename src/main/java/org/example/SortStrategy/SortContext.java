package org.example.SortStrategy;

import org.example.User;

import java.util.List;

public class SortContext {
    private SortStrategy strategy;

    public SortContext(){};
    public SortContext(SortStrategy initialStrategy) {
        this.strategy = initialStrategy;
    }

    public void setStrategy(SortStrategy strategy){
        this.strategy = strategy;
    }

    public void executeSort (List<User> users){
        if (strategy != null){
            strategy.sort(users);
        } else {
            throw new IllegalStateException("Стратегия сортировки не установлена!");
        }
    }

}
