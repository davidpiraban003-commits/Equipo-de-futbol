package controller;



import dto.MessageResponseDTO;
import dto.PlayerDTO;
import dto.*;
import dto.TrainingRequestDTO;
import entity.*;
import services.TrainingService;
import dto.StarterResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(
            TrainingService trainingService) {

        this.trainingService = trainingService;
    }

    @PostMapping
    public ResponseEntity<MessageResponseDTO>
    guardarEntrenamiento(
            @RequestBody TrainingRequestDTO dto) {

        List<Player> jugadores = dto.getJugadores()
                .stream()
                .map(playerDTO -> new Player(
                        playerDTO.getNombre(),
                        playerDTO.getPotenciaTiro(),
                        playerDTO.getVelocidad(),
                        playerDTO.getPases()
                ))
                .toList();

        Training training = new Training(
                dto.getNumeroEntrenamiento(),
                jugadores
        );

        trainingService.guardarEntrenamiento(
                training);

        return ResponseEntity.ok(
                new MessageResponseDTO(
                        "Entrenamiento almacenado correctamente"
                )
        );
    }

    @GetMapping("/titulares")
    public ResponseEntity<?> obtenerTitulares() {

        try {

            List<StarterResponse> titulares =
                    trainingService.obtenerTitulares();

            return ResponseEntity.ok(titulares);

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest()
                    .body(
                            new MessageResponseDTO(
                                    e.getMessage()
                            )
                    );
        }
    }
}
