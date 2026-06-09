package services;



import dto.*;
import repository.MemoryRepository;
import org.springframework.stereotype.Service;
import entity.Training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrainingService {

    private final MemoryRepository repository;

    public TrainingService(MemoryRepository repository) {
        this.repository = repository;
    }

    public void guardarEntrenamiento(Training training) {

        repository.save(training);
    }

    public List<StarterPlayerDTO> obtenerTitulares() {

        List<Training> trainings = repository.findAll();

        if (trainings.size() < 3) {
            throw new RuntimeException(
                    "No hay suficiente información para determinar el equipo titular");
        }

        Map<String, Double> puntajesAcumulados =
                new HashMap<>();

        Map<String, Integer> participaciones =
                new HashMap<>();

        for (Training training : trainings) {

            for (Player player : training.getJugadores()) {

                double resultado =
                        player.calcularResultado();

                puntajesAcumulados.merge(
                        player.getNombre(),
                        resultado,
                        Double::sum
                );

                participaciones.merge(
                        player.getNombre(),
                        1,
                        Integer::sum
                );
            }
        }

        return puntajesAcumulados.entrySet()
                .stream()
                .map(entry -> {

                    String nombreJugador =
                            entry.getKey();

                    double promedio =
                            entry.getValue()
                                    / participaciones.get(nombreJugador);

                    return new StarterPlayerDTO(
                            nombreJugador,
                            Math.round(promedio * 100.0) / 100.0
                    );
                })
                .sorted((j1, j2) ->
                        Double.compare(
                                j2.getPromedio(),
                                j1.getPromedio()
                        )
                )
                .limit(5)
                .toList();
    }
}