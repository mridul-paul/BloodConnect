package bloodconnect;

import java.util.ArrayList;

public interface DatabaseOperations<T> {

    // Add object to database
    void add(T object) throws Exception;

    // Get all objects
    ArrayList<T> getAll() throws Exception;

    // Search by blood group
    ArrayList<T> searchByBloodGroup(String bloodGroup)
            throws Exception;
}