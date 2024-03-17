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

1. **Detección de Anomalías en Atracciones**: 
   - Sensor de anclaje en vehículos de la noria y vagones de la montaña rusa.
   - Notificación automática a la Central Receptora de Averías (CRA) y a la atracción específica en caso de detectar problemas de anclaje.

2. **Gestión de Averías y Mantenimiento**:
   - Sistema en la CRA para asignar automáticamente averías a operarios de mantenimiento disponibles.
   - Notificación a atracciones y componentes afectados cuando no haya operarios disponibles.
   - Dispositivo para cada operario que recibe notificaciones de averías y muestra su estado (libre/ocupado).
   - Actualización de estado por parte del operario en su dispositivo tras completar una reparación.
   - Comunicación automática entre el dispositivo del operario, la CRA y la atracción sobre la finalización del mantenimiento.

3. **Control de Acceso y Conteo de Usuarios**:
   - Torniquetes en la entrada y salida para contabilizar el número de personas que entran y salen de una atracción.
   - Prevención de sobrecarga de la atracción mediante control de capacidad máxima.
   - Asegurar que todos los usuarios abandonen la atracción tras cada uso.

4. **Gestión de Operaciones de Atracciones**:
   - Sistema de arranque y parada de atracciones basado en la información de llenado y estado de la atracción.
   - Comunicación entre torniquetes y el controlador de la atracción para gestionar el flujo de usuarios y el inicio o parada de la atracción.
   - Indicadores de estado en los torniquetes (verde para libre, amarillo para espera de reparación).

5. **Verificación de Seguridad antes de Iniciar Atracciones**:
   - Consulta automática al estado de la atracción (averías pendientes) antes de permitir la entrada de nuevos usuarios.
   - Sistema de alarma si el torniquete de salida no se libera después de un tiempo determinado, indicando la posibilidad de que alguien se haya quedado dentro.

Estas funcionalidades permitirán automatizar la gestión de seguridad y operaciones de las atracciones, mejorando la eficiencia y la seguridad en el parque de atracciones.
