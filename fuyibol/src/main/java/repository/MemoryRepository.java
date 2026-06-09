package repository;


import org.springframework.stereotype.Repository;

import entity.Training;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryRepository {

    private final List<Training> trainings =
            new ArrayList<>();

    public void save(Training training) {
        trainings.add(training);
    }

    public List<Training> findAll() {
        return trainings;
    }
}