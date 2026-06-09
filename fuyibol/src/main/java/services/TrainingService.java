package services;

import dto.StarterPlayerDTO;
import entity.*;

import repository.MemoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        if (trainings.size() != 3) {
            throw new RuntimeException(
                    "Deben existir exactamente 3 entrenamientos para calcular el equipo titular");
        }

        Map<String, Double> puntajesAcumulados = new HashMap<>();
        Map<String, Integer> participaciones = new HashMap<>();

        for (Training training : trainings) {

            for (Player player : training.getJugadores()) {

                double resultado = player.calcularResultado();

                puntajesAcumulados.put(
                        player.getNombre(),
                        puntajesAcumulados.getOrDefault(
                                player.getNombre(), 0.0
                        ) + resultado
                );

                participaciones.put(
                        player.getNombre(),
                        participaciones.getOrDefault(
                                player.getNombre(), 0
                        ) + 1
                );
            }
        }

        List<StarterPlayerDTO> titulares = new ArrayList<>();

        for (String nombreJugador : puntajesAcumulados.keySet()) {

            double promedio =
                    puntajesAcumulados.get(nombreJugador)
                            / participaciones.get(nombreJugador);

            titulares.add(
                    new StarterPlayerDTO(
                            nombreJugador,
                            promedio
                    )
            );
        }

        return titulares;
    }
}