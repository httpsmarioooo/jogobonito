## Documentación de Implementación

### 1. Crear el Repository
- **Acción**: Validar que el repositorio exista.

### 2. Crear el DTO
- **Acción**: Hacer el DTO, copiar y pegar los siguientes decoradores:
  
  **Decoradores**:
  ```java
  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  ```

- **Instrucción**: Traer todos los atributos privados (`private`) de la clase de dominio correspondiente.

### 3. Agregar el Controller
- **Inyección de Dependencias**:
  
  **Ejemplo**:
  ```java
  private JudgePerMatchRepository judgePerMatchRepository;
  private JudgePerMatchService judgePerMatchService;
  ```

- **Constructor**:
  
  **Ejemplo**:
  ```java
  public JudgePerMatchController(JudgePerMatchRepository judgePerMatchRepository, JudgePerMatchService judgePerMatchService) {
      this.judgePerMatchRepository = judgePerMatchRepository;
      this.judgePerMatchService = judgePerMatchService;
  }
  ```


### 4. Crear el Service
- **Interfaz**:
  
  **Ejemplo**:
  ```java
  public interface PlayerService {
      PlayerDTO guardarNuevoPlayer(PlayerDTO playerDTO);
  }
  ```

### 5. Crear ServiceImpl
- **Importaciones**:
  
  ```java
  import org.springframework.stereotype.Service;
  ```

- **Anotación**:
  
  ```java
  @Service
  ```

- **Implementación**:
  
  **Ejemplo**:
  ```java
  public class PlayerServiceImpl implements PlayerService {
      // Implementar métodos
  }
  ```

- **Implementar Métodos**:
  
  - Colocarse sobre el error y usar la opción para "implementar métodos".
  
  **Ejemplo**:
  ```java
  @Override
  public PlayerDTO guardarNuevoPlayer(PlayerDTO playerDTO) {
      return null;
  }
  ```

### 6. Revisar el Controller
- **Resultado**: Comprobar que ya no hay errores en las últimas líneas del código.

### 7. Copiar el Método para Guardar
- **Ejemplo**:
  
  ```java
  @PostMapping(value = "/guardarNuevoPlayer")
  public ResponseEntity<PlayerDTO> guardarNuevoPlayer(@RequestBody PlayerDTO playerDTO) {
      PlayerDTO playerResponse = playerService.guardarNuevoPlayer(playerDTO);
      return new ResponseEntity<>(playerResponse, HttpStatus.CREATED);
  }
  ```

### 8. Crear Mapper
- **Acción**: Crear el Mapper necesario para la conversión entre DTOs y entidades.

### 9. Ajustar el Controller
- **Acción**: Realizar los ajustes necesarios en el Controller.

### 10. Revisar el ServiceImpl
- **Acción**: Acceder a las excepciones en el ServiceImpl (de forma independiente).

### 11. Comenzar a Hacer Validaciones
- **Acción**: Realizar validaciones de la tabla dependiente a independiente en el ServiceImpl.

        //1. Validacion id debe de ser null

        if(playerDTO.getId() != null) {
            throw new Exception("El id debe de ser nulo");
        }

        //2. Validaciones dependencias, llaves etc

        if (playerDTO.getName() == null || playerDTO.getName().isBlank()) {
            throw new Exception("El nombre no debe ser nulo o vacío");
        }

        if (playerDTO.getPosition() == null || playerDTO.getPosition().isBlank()) {
            throw new Exception("La posición no debe ser nula o vacía");
        }

        if (playerDTO.getJerseyNumber() == null || playerDTO.getJerseyNumber().isBlank()) {
            throw new Exception("El número del jersey no debe ser nulo o vacío");
        }

        if (playerDTO.getBirthDate() == null || playerDTO.getBirthDate().after(new Date())) {
            throw new Exception("La fecha de nacimiento no debe ser nula ni futura");
        }

        if (playerDTO.getHeightCm() == null || playerDTO.getHeightCm() <= 0) {
            throw new Exception("La altura en cm debe ser mayor a 0");
        }

        if (playerDTO.getCountryOfBirth() == null || playerDTO.getCountryOfBirth().isBlank()) {
            throw new Exception("El país de nacimiento no debe ser nulo o vacío");
        }

        if(playerDTO.getTeamId() == null) {
            throw new Exception("El TeamId no debe ser nulo");
        }

### 12. Últimas Validaciones
- **Acción**: Completar las validaciones finales en la parte final del ServiceImpl.

 //Ultimas validaciones en el mismo impl en la parte final---

 
        Player player = PlayerMapper.dtoToDomain(playerDTO);
        Team team = teamRepository.getReferenceById(playerDTO.getTeamId());

        if (team == null){
            throw new Exception("El Team no existe");
        }

        player.setTeam(team);
        player = playerRepository.save(player);
        return PlayerMapper.domainToDto(player);




PASOS DE LA TEMPORADA 2 -------------------------------------------------------

1. Copiar los metodos.
2. Agregarlos en el service
3. Arreglar el impl que es copiar todo ese mogollon de codigo (dependecias).
 a. Pero primero, saldra un error, hay que agregar los metodos y ya se quitara ese error.
 b. Ya podemos copiar las dependecias.
