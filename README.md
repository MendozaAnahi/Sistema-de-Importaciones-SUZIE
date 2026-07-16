Proyecto Final de POO - GRUPO 2
Script de la base de datos:
```sql
DROP DATABASE IF EXISTS importaciones_suzie;
CREATE DATABASE importaciones_suzie;
USE importaciones_suzie;

-- 1. TABLAS PADRE
-- Tabla Rol
CREATE TABLE Rol (
    RolID INT AUTO_INCREMENT PRIMARY KEY,
    NombreRol VARCHAR(50) NOT NULL
);
INSERT INTO Rol (NombreRol) VALUES
('Administrador'), ('Vendedor');

-- Tabla Cliente
CREATE TABLE Cliente (
    ClienteID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Telefono VARCHAR(20)
);

-- Tabla Categoría
CREATE TABLE Categoria (
    CategoriaID INT AUTO_INCREMENT PRIMARY KEY,
    NombreCategoria VARCHAR(100) NOT NULL,
    Descripcion VARCHAR(255)
);
INSERT INTO Categoria (NombreCategoria, Descripcion) VALUES
('Electrónica', 'Dispositivos electrónicos y accesorios'),
('Hogar', 'Artículos para el hogar y cocina'),
('Moda', 'Ropa, calzado y accesorios'),
('Belleza', 'Productos de cuidado personal y cosméticos'),
('Juguetes', 'Juguetes para niños y adultos'),
('Deportes', 'Artículos deportivos y fitness'),
('Mascotas', 'Accesorios y productos para mascotas'),
('Oficina', 'Útiles y accesorios de oficina'),
('Automotriz', 'Accesorios para vehículos'),
('Salud', 'Productos para el cuidado de la salud');

-- Tabla Sede 
CREATE TABLE Sede (
    SedeID INT AUTO_INCREMENT PRIMARY KEY,
    NombreSede VARCHAR(100) NOT NULL,
    Direccion VARCHAR(200),
    Telefono VARCHAR(20)
);
INSERT INTO Sede (NombreSede, Direccion, Telefono) VALUES
('Sede Lima', 'Av. Javier Prado Este 1234, San Isidro, Lima', '01-4567890'),
('Sede Callao', 'Av. Sáenz Peña 456, Callao', '01-5678901'),
('Sede Norte', 'Panamericana Norte Km 15, Los Olivos, Lima', '01-7890123');

-- Tabla Proveedor 
CREATE TABLE Proveedor (
    ProveedorID INT AUTO_INCREMENT PRIMARY KEY,
    NombreProveedor VARCHAR(100) NOT NULL,
    Telefono VARCHAR(20),
    Correo VARCHAR(100),
    Direccion VARCHAR(200)
);
INSERT INTO Proveedor (NombreProveedor, Telefono, Correo, Direccion) VALUES
('Tech Perú SAC', '999111222', 'ventas@techperu.com', 'Lima Central 123'),
('Importaciones Globales', '999333444', 'contacto@iglobal.pe', 'Callao Industrial 45'),
('Textiles Andinos', '999555666', 'distribucion@tandinos.com', 'Gamarra 789'),
('Belleza Total EIRL', '999777888', 'ventas@bellezatotal.pe', 'San Borja 101'),
('Mascotas & Salud', '999000111', 'logistica@mascotasysalud.com', 'Surco 555');

-- Tabla MetodoPago 
CREATE TABLE MetodoPago (
    MetodoPagoID INT AUTO_INCREMENT PRIMARY KEY,
    NombreMetodo VARCHAR(50) NOT NULL
);
INSERT INTO MetodoPago (NombreMetodo) VALUES
('Efectivo'), ('Tarjeta de Débito'), ('Tarjeta de Crédito'), 
('Yape'), ('Plin');


-- 2. TABLAS INTERMEDIAS (Dependen de las tablas Padre)
-- Tabla Usuario
CREATE TABLE Usuario (
    UsuarioID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Correo VARCHAR(100) UNIQUE,
    Contrasena VARCHAR(255) NOT NULL,
    RolID INT NOT NULL,
    FOREIGN KEY (RolID) REFERENCES Rol(RolID)
);
INSERT INTO Usuario (Nombre, Apellido, Correo, Contrasena, RolID) VALUES
('Carlos', 'Ramirez', 'carlos.ramirez@suziemarket.com', 'admin123', 1),
('María', 'Gonzales', 'maria.gonzales@suziemarket.com', 'admin456', 1),
('José', 'Torres', 'jose.torres@suziemarket.com', 'venta123', 2),
('Ana', 'Rojas', 'ana.rojas@suziemarket.com', 'venta456', 2),
('Luis', 'Paredes', 'luis.paredes@suziemarket.com', 'venta789', 2);

-- Tabla Producto 
CREATE TABLE Producto (
    ProductoID INT AUTO_INCREMENT PRIMARY KEY,
    NombreProducto VARCHAR(150) NOT NULL,
    Descripcion VARCHAR(255),
    Precio DECIMAL(10,2) NOT NULL,
    Stock INT NOT NULL,
    Estado BOOLEAN DEFAULT 1, -- 1 = Activo (Visible en Java), 0 = Inactivo (Oculto)
    CategoriaID INT NOT NULL,
    ProveedorID INT NOT NULL,
    SedeID INT NOT NULL,
    FOREIGN KEY (CategoriaID) REFERENCES Categoria(CategoriaID),
    FOREIGN KEY (ProveedorID) REFERENCES Proveedor(ProveedorID),
    FOREIGN KEY (SedeID) REFERENCES Sede(SedeID)
);

INSERT INTO Producto
(NombreProducto, Descripcion, Precio, Stock, CategoriaID, ProveedorID, SedeID)
VALUES
-- Electrónica
('Audífonos Bluetooth', 'Audífonos inalámbricos con estuche de carga.', 79.90, 80, 1, 1, 1),
('Mouse Gamer RGB', 'Mouse ergonómico con iluminación RGB.', 95.50, 45, 1, 2, 2),
('Teclado Mecánico', 'Teclado mecánico con switches azules.', 189.90, 35, 1, 2, 1),
('Power Bank 10000mAh', 'Batería portátil de carga rápida.', 89.90, 60, 1, 1, 3),
('Smartwatch Deportivo', 'Reloj inteligente con monitor cardíaco.', 149.90, 40, 1, 3, 2),
('Tablet 10 Pulgadas', 'Tablet Android con 64GB de almacenamiento.', 550.00, 25, 1, 1, 1),
('Cámara Web 1080p', 'Cámara web con micrófono integrado para PC.', 110.00, 35, 1, 2, 2),

-- Hogar
('Organizador de Zapatos', 'Organizador de tela para 12 pares.', 39.90, 70, 2, 4, 1),
('Lámpara LED', 'Lámpara LED para escritorio con luz regulable.', 55.00, 50, 2, 4, 2),
('Juego de Ollas', 'Juego de ollas de acero inoxidable.', 220.00, 25, 2, 5, 3),
('Almohada Viscoelástica', 'Almohada ergonómica de espuma viscoelástica.', 65.90, 30, 2, 5, 1),
('Escurridor de Platos', 'Escurridor metálico para cocina.', 48.50, 40, 2, 4, 2),
('Batidora de Mano', 'Batidora eléctrica de 5 velocidades.', 65.50, 40, 2, 4, 2),
('Set de Cuchillos', 'Juego de 5 cuchillos de acero inoxidable con base.', 85.50, 30, 2, 5, 3),

-- Moda
('Polo Oversize', 'Polo unisex de algodón.', 49.90, 100, 3, 2, 1),
('Zapatillas Urbanas', 'Zapatillas deportivas para uso diario.', 159.90, 45, 3, 3, 2),
('Mochila Impermeable', 'Mochila resistente al agua de 25 litros.', 89.90, 55, 3, 2, 3),
('Gorra Deportiva', 'Gorra ajustable con protección UV.', 35.00, 80, 3, 1, 1),
('Casaca Cortaviento', 'Casaca ligera resistente al viento.', 129.90, 25, 3, 3, 2),
('Lentes de Sol', 'Lentes polarizados con protección UV400.', 45.00, 60, 3, 2, 3),
('Reloj Analógico', 'Reloj de pulsera clásico con correa de cuero.', 95.00, 40, 3, 3, 1),

-- Belleza
('Secadora de Cabello', 'Secadora profesional de 2000W.', 120.00, 20, 4, 4, 1),
('Cepillo Facial Eléctrico', 'Cepillo facial recargable.', 69.90, 35, 4, 4, 3),
('Espejo LED', 'Espejo de maquillaje con iluminación LED.', 58.90, 30, 4, 5, 2),
('Organizador de Maquillaje', 'Organizador acrílico de cosméticos.', 42.50, 60, 4, 5, 1),
('Plancha de Cabello', 'Plancha de cerámica con control de temperatura.', 89.90, 30, 4, 5, 1),

-- Juguetes
('Carro a Control Remoto', 'Vehículo RC con batería recargable.', 95.00, 40, 5, 1, 2),
('Rompecabezas 1000 Piezas', 'Rompecabezas de paisaje.', 38.00, 50, 5, 2, 1),
('Bloques de Construcción', 'Set de 500 bloques compatibles.', 89.00, 35, 5, 3, 3),
('Juego de Mesa Clásico', 'Juego de mesa de estrategia y finanzas.', 75.00, 45, 5, 2, 2),

-- Deportes
('Mancuernas 10 kg', 'Par de mancuernas recubiertas.', 145.00, 20, 6, 3, 2),
('Mat de Yoga', 'Colchoneta antideslizante.', 65.00, 45, 6, 2, 1),
('Botella Térmica', 'Botella de acero inoxidable de 1 litro.', 59.90, 70, 6, 1, 3),
('Cuerda para Saltar', 'Cuerda de velocidad ajustable con mangos de aluminio.', 25.00, 100, 6, 3, 3),

-- Mascotas
('Cama para Perro', 'Cama acolchada para mascotas medianas.', 110.00, 25, 7, 5, 2),
('Comedero Automático', 'Dispensador automático de alimento.', 135.00, 15, 7, 5, 1),
('Juguete Mordedor', 'Mordedor de goma para perros.', 25.90, 80, 7, 4, 3),
('Collar Reflectante', 'Collar ajustable para perros con banda reflectante.', 15.90, 85, 7, 5, 1),

-- Oficina
('Silla Ergonómica', 'Silla de oficina con soporte lumbar.', 399.90, 12, 8, 2, 1),
('Calculadora Científica', 'Calculadora de 240 funciones.', 85.00, 30, 8, 1, 2),
('Pack de Cuadernos', 'Paquete de 5 cuadernos universitarios.', 32.50, 100, 8, 3, 3),
('Pizarra Acrílica', 'Pizarra blanca magnética de 60x90 cm.', 55.00, 20, 8, 1, 2),

-- Automotriz
('Soporte para Celular', 'Soporte magnético para automóvil.', 39.90, 60, 9, 4, 2),
('Aspiradora Portátil', 'Aspiradora inalámbrica para auto.', 119.90, 20, 9, 4, 1),
('Compresor de Aire', 'Compresor portátil de 12V.', 179.90, 18, 9, 5, 3),
('Parasol Parabrisas', 'Parasol plegable con protección UV para autos.', 22.50, 50, 9, 4, 3),

-- Salud
('Tensiómetro Digital', 'Medidor automático de presión arterial.', 149.90, 25, 10, 5, 2),
('Masajeador Cervical', 'Masajeador eléctrico para cuello.', 189.90, 15, 10, 2, 1),
('Termómetro Digital', 'Termómetro de lectura rápida.', 35.00, 50, 10, 3, 3),
('Oxímetro de Pulso', 'Monitor de saturación de oxígeno en la sangre.', 45.00, 60, 10, 5, 1);


-- 3. TABLAS DE TRANSACCIÓN (Dependen de múltiples entidades)
-- Tabla Venta
CREATE TABLE Venta (
    VentaID INT AUTO_INCREMENT PRIMARY KEY,
    FechaVenta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    Total DECIMAL(10,2) NOT NULL,
    ClienteID INT NOT NULL,
    UsuarioID INT NOT NULL,
    MetodoPagoID INT NOT NULL, 
    FOREIGN KEY (ClienteID) REFERENCES Cliente(ClienteID),
    FOREIGN KEY (UsuarioID) REFERENCES Usuario(UsuarioID),
    FOREIGN KEY (MetodoPagoID) REFERENCES MetodoPago(MetodoPagoID) 
);

-- Tabla DetalleVenta
CREATE TABLE DetalleVenta (
    VentaID INT NOT NULL,
    ProductoID INT NOT NULL,
    Cantidad INT NOT NULL,
    PrecioUnitario DECIMAL(10,2) NOT NULL,
    Subtotal DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (VentaID, ProductoID),
    FOREIGN KEY (VentaID) REFERENCES Venta(VentaID),
    FOREIGN KEY (ProductoID) REFERENCES Producto(ProductoID)
);


-- Impresión de registros de las tablas 
-- DE CATÁLOGOS Y CONFIGURACIÓN
SELECT * FROM Rol;
SELECT * FROM Categoria;
SELECT * FROM Sede;
SELECT * FROM Proveedor;
SELECT * FROM MetodoPago;
-- TABLAS PRINCIPALES 
-- (usuarios y productos)
SELECT * FROM Usuario;
SELECT * FROM Producto;
-- TABLAS TRANSACCIONALES
-- (para cuando empiece el proceso de venta desde Java)
SELECT * FROM Cliente;
SELECT * FROM Venta;
SELECT * FROM DetalleVenta;
