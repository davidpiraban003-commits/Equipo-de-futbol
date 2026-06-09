package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import model.Player;
import model.Training;
import repository.MemoryRepository;


@Service
public class TrainingService {

    private final MemoryRepository repository;

    public TrainingService(MemoryRepository repository) {
        this.repository = repository;
    }

    public void guardarEntrenamiento(
            Training training) {

        repository.save(training);
    }

    public List<Map<String,Object>>
    obtenerTitulares() {

        List<Training> trainings =
                repository.findAll();

        if(trainings.size() < 3) {

            throw new RuntimeException(
                    "No hay suficiente información");
        }

        Map<String, Double> acumulado =
                new HashMap<>();

        Map<String, Integer> contador =
                new HashMap<>();

        for (Training training : trainings) {

            for(Player player :
                    training.getJugadores()) {

                acumulado.merge(
                        player.getNombre(),
                        player.calcularResultado(),
                        Double::sum);

                contador.merge(
                        player.getNombre(),
                        1,
                        Integer::sum);
            }
        }

        return acumulado.entrySet()
                .stream()
                .map(e -> {

                    double promedio =
                            e.getValue() /
                                    contador.get(e.getKey());

                    Map<String,Object> map =
                            new HashMap<>();

                    map.put("jugador",
                            e.getKey());

                    map.put("promedio",
                            promedio);

                    return map;
                })
                .sorted((a,b) -> Double.compare(
                        (double)b.get("promedio"),
                        (double)a.get("promedio")
                ))
                .limit(5)
                .toList();
    }
}