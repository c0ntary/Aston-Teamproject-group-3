package org.example.Data;
import org.example.Entity.User;
import java.util.List;

public interface Data {
    List<User> loadData(int count);
}
