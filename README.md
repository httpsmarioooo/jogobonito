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

### 12. Últimas Validaciones
- **Acción**: Completar las validaciones finales en la parte final del ServiceImpl.
