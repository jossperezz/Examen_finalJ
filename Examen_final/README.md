
Sistema de Gestión para Club de Voleibol (CVO)

---

Integrantes del Grupo y Roles
| Nombre                     | Rol              | Código  |
|----------------------------|------------------|---------|
| Joseph Caleb Perez         | Desarrollador    | 192464  |

---

**Descripción del Problema y Solución Propuesta**  
**Problema:**  
El Club de Voleibol Ocaña necesita un sistema para gestionar:  
- Registro de jugadores (activos/inactivos).  
- Control de pagos de mensualidades (12 meses anuales).  
- estadísticas financieras.  

**Solución:**  
Aplicación Java con arquitectura orientada a objetos que permite:  
1. Registrar jugadores con datos personales.  
2. Registrar pagos de mensualidades por mes.  
3. Consultar estados de pagos individuales y globales.   
4. Calcular ingresos totales y estadísticas del club.  

---

### **Explicación de Clases y Métodos Principales**  

#### **1. `Persona.java` (Clase Base)**  
- **Propósito:** Almacena datos comunes a todas las personas (nombre, fecha de nacimiento).  
- **Métodos clave:**  
  - `toString()`: Devuelve una representación en cadena de los datos.  

#### **2. `Jugador.java` (Hereda de `Persona`)**  
- **Propósito:** Gestiona la información específica de los jugadores (pagos, estado).  
- **Atributos:**  
  - `id`: Identificador único.  
  - `activo`: Estado del jugador (activo/inactivo).  
  - `mensualidades[12]`: Arreglo para almacenar pagos por mes.  
- **Métodos clave:**  
  - `pagarMensualidad(int mes, double monto)`: Registra un pago en un mes específico.  
  - `contarMesesPendientes()`: Retorna meses sin pagar.  
  - `calcularTotalPagado()`: Suma todos los pagos realizados.  

#### **3. `ClubVoleibol.java` (Clase Principal)**  
- **Propósito:** Administra todas las operaciones del club.  
- **Atributos:**  
  - `jugadores[]`: Lista de jugadores (máximo 30).  
  - `NOMBRES_MESES[]`: Nombres de meses para reportes.  
- **Métodos clave:**  
  - `agregarJugador()`: Añade un nuevo jugador.  
  - `registrarPago()`: Registra un pago para un jugador (si está activo).   
  - `calcularIngresosTotales()`: Suma los pagos de todos los jugadores activos.  

#### **4. `Main.java` (Interfaz de Usuario)**  
- **Propósito:** Menú interactivo para gestionar el sistema.  
- **Flujo:**  
  - Inicialización del club y muestra de menú.  
  - Opciones:  
    1. Registrar jugador.  
    2. Registrar pago.  
    3. Consultar estado de pagos.  
    4. Listar jugadores activos.   
    5. Estadísticas del club.  
    0. Salir.  

---

### **Instrucciones para Ejecutar el Programa**  
1. **Compilación:**  
   ```bash
   javac Main.java
   ```

2. **Ejecución:**  
   ```bash
   java Main
   ```

3. **Uso:**  
   - Seguir las opciones del menú interactivo.  
   - Ejemplo:  
     === MENÚ PRINCIPAL ===
     1. Registrar nuevo jugador
     2. Registrar pago mensualidad
     3. Consultar estado de pagos
     ... 
     ```

---



#### **Registro de Jugador**  
=== REGISTRAR JUGADOR ===
Nombre completo: María González
Fecha de nacimiento (dd/mm/aaaa): 22/08/2005
¡Jugador registrado exitosamente!


#### **Estadísticas del Club**  
```plaintext
=== ESTADÍSTICAS DEL CLUB ===
Total jugadores: 15
Jugadores activos: 12
Ingresos totales: $4800.0

---

### **Notas Adicionales**  
- **Validaciones:**  
  - El ID del jugador debe ser válido.  
  - Los meses deben estar entre 1 y 12.  
  - Montos de pago mayores a 0.  
- **Persistencia:** Los datos se pierden al cerrar la aplicación (no usa base de datos).  

🔧 **Desarrollado por Joseph Caleb Perez Carrascal (192464)**  
