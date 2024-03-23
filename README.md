# Divertimento

Divertimento es un sistema de gestión para un parque de atracciones. El sistema permite simular averías en las atracciones, asignar operarios para reparar las averías y simular el flujo de visitantes en las atracciones.

## Configuración

Para configurar el proyecto, sigue estos pasos:

1. Clona el repositorio en tu máquina local.
2. Abre el proyecto en tu IDE preferido (se recomienda IntelliJ IDEA).
3. Asegúrate de tener instalado Java 8 o superior.
4. Asegúrate de tener instalado Maven para gestionar las dependencias del proyecto.
5. Ejecuta el comando `mvn clean install` para construir el proyecto y descargar las dependencias necesarias.
6. Ejecuta la clase `Main` para iniciar el sistema.

##  Caso de estudio

Basándome en el caso de estudio, estas son las funcionalidades esperadas para el sistema de automatización de los parques de atracciones:

# Detección de Anomalías

- **Automática**: El sistema debe detectar pérdidas de anclaje en vehículos de la noria y montaña rusa.
- **Notificación**: En caso de detección, notificar inmediatamente a la Central Receptora de Averías (CRA) y a la atracción afectada.

# Gestión de Averías

- **Asignación Automática**: La CRA asigna un operario de mantenimiento libre para la avería detectada.
- **Manejo de Disponibilidad**: Si no hay operarios libres, mantener la solicitud activa hasta que uno esté disponible.

# Comunicación y Registro

- **Recepción y Estado**: Los dispositivos de los operarios deben mostrar las averías asignadas y marcar su estado a "ocupado" al atender una avería.
- **Finalización y Notificación**: Tras la revisión, marcar la avería como resuelta, notificándolo a la CRA y al componente revisado.

# Control de Afluencia

- **Contabilización de Usuarios**: Monitorear el número de personas que entran y salen de cada atracción para no exceder la capacidad máxima.
- **Verificación de Desalojo**: Asegurar que todos los usuarios abandonen la atracción al final de cada ciclo.

# Arranque y Parada de Atracciones

- **Inicio de Funcionamiento**: Iniciar solo cuando se alcanza la capacidad máxima o según criterio del operario.
- **Parada Automática**: Activarse tras el desembarco de todos los pasajeros.

# Indicadores de Estado

- **Torniquetes**: Mostrar indicadores visuales (verde para libre, amarillo para en espera de reparación) reflejando el estado de la atracción y la presencia de usuarios.

# Verificación de Seguridad

- **Previo a la Entrada**: El torniquete de entrada debe verificar que no haya averías pendientes.
- **Medidas de Seguridad**: Si hay averías pendientes o personas dentro de la atracción tras un tiempo establecido, tomar medidas para asegurar la seguridad antes del próximo uso.


Estas funcionalidades permitirán automatizar la gestión de seguridad y operaciones de las atracciones, mejorando la eficiencia y la seguridad en el parque de atracciones.

## Descripción de Clases e Interfaces

1. `IAttraction` (Interfaz): Define los métodos que todas las atracciones deben implementar. Incluye métodos para iniciar y detener la atracción, reportar averías, verificar los vehículos, permitir la entrada y salida de visitantes, y obtener información sobre el estado de la atracción.

2. `EntranceTurnstile` (Clase): Representa un torniquete de entrada a una atracción. Tiene un método `enter` que permite a los visitantes entrar a la atracción si no hay averías pendientes.

3. `Main` (Clase): Clase principal que inicia el sistema. No requiere cambios para la "Verificación de Seguridad".

4. `MainFrame` (Clase): Interfaz de usuario del sistema. Ofrece un menú principal para seleccionar opciones como listar atracciones y vehículos, simular la entrada de nuevos usuarios a la atracción, y resolver averías.

5. `IEntranceTurnstile` (Interfaz): Define los métodos que todos los torniquetes de entrada deben implementar. Incluye un método `enter` para permitir la entrada de visitantes.

6. `ExitTurnstile` (Clase): Representa un torniquete de salida de una atracción. Tiene un método `exit` para permitir la salida de visitantes.

7. `Noria` (Clase): Representa la atracción de la Noria. Implementa `IAttraction` y tiene métodos para iniciar, detener, permitir la entrada y salida de visitantes, y manejar averías.

8. `RollerCoaster` (Clase): Representa la Montaña Rusa. Como `Noria`, implementa `IAttraction` con métodos similares para manejar la atracción.

9. `IExitTurnstile` (Interfaz): Define los métodos que todos los torniquetes de salida deben implementar. Incluye un método `exit` para permitir la salida de visitantes.

10. `Vehicle` (Clase): Representa un vehículo en una atracción. Tiene métodos para verificar el anclaje del vehículo y reportar al CRA si hay una avería.

11. `AttractionController` (Clase): Responsable de controlar una atracción. Tiene métodos para iniciar y detener la atracción, y permitir la entrada y salida de visitantes.

12. `IVehicle` (Interfaz): Define los métodos que todos los vehículos deben implementar. Incluye métodos para verificar el anclaje del vehículo y reportar al CRA si hay una avería.

En resumen, este sistema de control para un parque de atracciones permite manejar las atracciones y los visitantes, detectar y resolver averías, y simular diferentes escenarios para probar el sistema.
