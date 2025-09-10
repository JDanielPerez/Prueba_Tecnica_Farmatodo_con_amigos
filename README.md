# Sistema de Tokenización de Tarjetas de Crédito y Gestión de Compras en Línea

## 📋 Descripción del Proyecto

Este proyecto consiste en el desarrollo de un sistema que simula el proceso de tokenización de tarjetas de crédito, gestión de clientes y pedidos, y flujo de compras en línea. El sistema implementa una arquitectura robusta con Spring Boot 3.5.5, incluyendo componentes para autenticación, control de errores, lógica de negocio configurable y persistencia de datos.

### 🎯 Funcionalidades Principales

- **Tokenización de tarjetas de crédito**: Recepción de datos de tarjetas y generación de tokens únicos
- **Ping API**: Endpoint `/ping` que retorna `pong` con código HTTP 200 para verificar disponibilidad
- **Gestión de clientes**: Registro y validación de clientes con datos únicos
- **Búsqueda de productos**: Funcionalidad para buscar productos con almacenamiento asíncrono de búsquedas
- **Carrito de compras**: Agregar productos al carrito
- **Gestión de pedidos y pagos**: Registro de pedidos con lógica de aprobación/rechazo configurable
- **Notificaciones por correo**: Envío de correos electrónicos en caso de éxito o fallo del pago
- **Logs centralizados**: Registro de eventos y transacciones con UUID único

## 🚀 Comandos para Iniciar el Proyecto

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+
- PostgreSQL 12+
- Git

### 1. Clonar el repositorio
```bash
git clone https://github.com/JDanielPerez/Prueba_Tecnica_Farmatodo_con_amigos.git
cd Prueba_Tecnica_Farmatodo_con_amigos
```

### 2. Configurar la base de datos
Crear una base de datos PostgreSQL y configurar las credenciales en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/farmatodo_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 3. Configurar variables de entorno
Editar el archivo `src/main/resources/application.properties` con las siguientes configuraciones:

```properties
# Configuración de la aplicación
spring.application.name=farmatodo
server.port=9090

# Configuración de base de datos
spring.datasource.url=jdbc:postgresql://localhost:5432/farmatodo_db
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver

# Configuración de JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

# Variables de configuración del negocio
spring.variables.failProbabilityConfiguration=10
spring.variables.paymentAttemptsConfiguration=10
spring.variables.quantityStockConfiguration=10

# Configuración de correo electrónico
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=tu_email@gmail.com
spring.mail.password=tu_contraseña_de_aplicacion
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
app.mail.from=tu_email@gmail.com
```

### 4. Construir el proyecto
```bash
# En Windows
mvnw.cmd clean install

# En Linux/Mac
./mvnw clean install
```

### 5. Ejecutar la aplicación
```bash
# En Windows
mvnw.cmd spring-boot:run

# En Linux/Mac
./mvnw spring-boot:run
```

La aplicación estará disponible en `http://localhost:9090`

### 6. Acceder a la documentación de la API
Una vez iniciada la aplicación, puedes acceder a:
- **Swagger UI**: `http://localhost:9090/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:9090/v3/api-docs`

## 🏗️ Estructura del Proyecto

```
Prueba_Tecnica_Farmatodo_con_amigos/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── farmatodo/
│   │   │           └── farmatodo/
│   │   │               ├── config/                    # Configuraciones de la aplicación
│   │   │               │   └── SecurityConfig.java    # Configuración de seguridad
│   │   │               ├── controllers/               # Controladores REST
│   │   │               │   ├── ControllerCustomer.java
│   │   │               │   ├── ControllerHome.java
│   │   │               │   ├── ControllerOrder.java
│   │   │               │   ├── ControllerPaymentMethod.java
│   │   │               │   ├── ControllerProduct.java
│   │   │               │   └── UserController.java
│   │   │               ├── models/                    # Modelos de datos
│   │   │               │   ├── dtos/                  # Data Transfer Objects
│   │   │               │   │   ├── CustomerDTO.java
│   │   │               │   │   ├── OrderDetailDTO.java
│   │   │               │   │   ├── PaymentMethodDto.java
│   │   │               │   │   ├── ProductDTO.java
│   │   │               │   │   └── UserRegisterDTO.java
│   │   │               │   ├── entities/              # Entidades JPA
│   │   │               │   │   ├── Customer.java
│   │   │               │   │   ├── CustomerPaymentMethod.java
│   │   │               │   │   ├── History.java
│   │   │               │   │   ├── Order.java
│   │   │               │   │   ├── OrderDetail.java
│   │   │               │   │   ├── PaymentMethod.java
│   │   │               │   │   ├── Product.java
│   │   │               │   │   └── User.java
│   │   │               │   └── enums/                 # Enumeraciones
│   │   │               │       ├── OrderStatus.java
│   │   │               │       └── PaymentStatus.java
│   │   │               ├── repositories/              # Repositorios JPA
│   │   │               │   ├── CustomerPaymentMethodRepository.java
│   │   │               │   ├── CustomerRepository.java
│   │   │               │   ├── HistoryRepository.java
│   │   │               │   ├── OrderDetailRepository.java
│   │   │               │   ├── OrderRepository.java
│   │   │               │   ├── PaymentMethodRepository.java
│   │   │               │   ├── ProductRepository.java
│   │   │               │   ├── ProductSpecifications.java
│   │   │               │   └── UserRepository.java
│   │   │               ├── services/                  # Lógica de negocio
│   │   │               │   ├── CartService.java
│   │   │               │   ├── CustomerPaymentMethodService.java
│   │   │               │   ├── CustomerService.java
│   │   │               │   ├── HistoryService.java
│   │   │               │   ├── OrderDetailService.java
│   │   │               │   ├── OrderService.java
│   │   │               │   ├── PaymentMethodService.java
│   │   │               │   ├── ProductService.java
│   │   │               │   ├── SendMailService.java
│   │   │               │   └── UserService.java
│   │   │               └── FarmatodoApplication.java  # Clase principal
│   │   └── resources/
│   │       └── application.properties                 # Configuración de la aplicación
│   └── test/                                          # Pruebas unitarias
│       └── java/
│           └── com/
│               └── farmatodo/
│                   └── farmatodo/
│                       └── FarmatodoApplicationTests.java
├── .gitignore
├── .gitattributes
├── mvnw                                                # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                                            # Maven Wrapper (Windows)
├── pom.xml                                             # Configuración de Maven
└── README.md                                           # Este archivo
```

## 🔧 Tecnologías Utilizadas

- **Spring Boot 3.5.5**: Framework principal
- **Java 17**: Lenguaje de programación
- **Spring Security**: Autenticación y autorización
- **Spring Data JPA**: Persistencia de datos
- **PostgreSQL**: Base de datos
- **Lombok**: Reducción de código boilerplate
- **Spring Mail**: Envío de correos electrónicos
- **Spring Retry**: Reintentos automáticos
- **JWT (JSON Web Tokens)**: Tokens de autenticación
- **SpringDoc OpenAPI**: Documentación de API
- **Maven**: Gestión de dependencias

## 📚 API Endpoints

### Autenticación
- `POST /user/register` - Registro de usuario
- `GET /ping` - Verificación de disponibilidad del servicio

### Clientes
- `POST /customer/save` - Registro de cliente
- `GET /customer/get` - Obtener información del cliente
- `GET /customer/ping` - Ping del servicio de clientes

### Productos
- `POST /products/save` - Crear producto
- `GET /products/search` - Buscar productos (con parámetros opcionales: name, reference)
- `GET /products/ping` - Ping del servicio de productos

### Métodos de Pago
- `POST /paymentMethod/save` - Registrar método de pago

### Pedidos
- `POST /orders/addProduct` - Agregar producto al carrito
- `POST /orders/pay` - Procesar pago de pedido
- `GET /orders/ping` - Ping del servicio de pedidos

## 🔐 Seguridad

El sistema implementa autenticación básica HTTP con Spring Security:

- **Usuario por defecto**: `Admin`
- **Contraseña por defecto**: `Admin`
- **Endpoints públicos**: `/user/register`, `/swagger-ui/**`, `/v3/api-docs/**`
- **Encriptación**: BCrypt para contraseñas

## ⚙️ Configuración de Variables

### Variables de Negocio Configurables

```properties
# Probabilidad de fallo en pagos (porcentaje 0-100)
spring.variables.failProbabilityConfiguration=10

# Número máximo de intentos de pago
spring.variables.paymentAttemptsConfiguration=10

# Cantidad mínima de stock para mostrar productos
spring.variables.quantityStockConfiguration=10
```

## 📊 Modelo de Datos

### Entidades Principales

- **User**: Usuarios del sistema
- **Customer**: Información de clientes
- **Product**: Catálogo de productos
- **Order**: Pedidos de compra
- **OrderDetail**: Detalles de productos en pedidos
- **PaymentMethod**: Métodos de pago (tarjetas)
- **CustomerPaymentMethod**: Relación cliente-método de pago
- **History**: Historial de búsquedas

### Estados de Pedidos
- `PENDING`: Pendiente
- `PAID`: Pagado
- `CANCELLED`: Cancelado
- `SHIPPED`: Enviado
- `DELIVERED`: Entregado

### Estados de Pago
- `PENDING`: Pendiente
- `PROCESSING`: Procesando
- `PAID`: Pagado
- `FAILED`: Fallido
- `CANCELLED`: Cancelado
- `REFUNDED`: Reembolsado

## 🔄 Flujo de Negocio

1. **Registro de Usuario**: El usuario se registra en el sistema
2. **Registro de Cliente**: Se completa la información del cliente
3. **Registro de Método de Pago**: Se tokeniza la tarjeta de crédito
4. **Búsqueda de Productos**: Se buscan productos disponibles
5. **Agregar al Carrito**: Se agregan productos al pedido
6. **Procesar Pago**: Se intenta procesar el pago con probabilidad de fallo configurable
7. **Notificación**: Se envía correo de confirmación o error

## 🧪 Pruebas

### Ejecutar Pruebas Unitarias
```bash
mvnw test
```

### Cobertura de Pruebas
El proyecto incluye pruebas unitarias con objetivo de 80% de cobertura.

## 📧 Configuración de Correo

Para configurar el envío de correos:

1. Configurar credenciales de Gmail en `application.properties`
2. Habilitar "Acceso de aplicaciones menos seguras" o usar contraseñas de aplicación
3. Configurar el remitente en `app.mail.from`

## 🚀 Despliegue

### Desarrollo Local
```bash
mvnw spring-boot:run
```

### Producción
```bash
mvnw clean package
java -jar target/farmatodo-0.0.1-SNAPSHOT.jar
```

## 📝 Notas de Desarrollo

- El sistema utiliza procesamiento asíncrono para el historial de búsquedas
- Los datos de tarjetas se almacenan de forma segura
- Se implementa lógica de reintentos para pagos fallidos
- El sistema es configurable mediante variables de entorno
- Se incluye documentación automática con Swagger/OpenAPI

## 🤝 Contribución

1. Fork el proyecto
2. Crear una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abrir un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👥 Autores

- **Equipo de Desarrollo Farmatodo** - *Desarrollo inicial*

## 📞 Soporte

Para soporte técnico o consultas sobre el proyecto, contactar al equipo de desarrollo.

---

**Versión**: 0.0.1-SNAPSHOT  
**Última actualización**: 2024
