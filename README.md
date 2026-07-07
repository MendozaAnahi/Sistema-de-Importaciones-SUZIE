Proyecto Final de POO - GRUPO 2
Script de la base de datos:
```sql
Create database importaciones_suzie;
use importaciones_suzie;

-- Tabla Rol
CREATE TABLE Rol (
    RolID INT AUTO_INCREMENT PRIMARY KEY,
    NombreRol VARCHAR(50) NOT NULL
);
INSERT INTO Rol (NombreRol) VALUES ('Administrador');
INSERT INTO Rol (NombreRol) VALUES ('Cliente');

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

-- Tabla Categoría
CREATE TABLE Categoria (
    CategoriaID INT AUTO_INCREMENT PRIMARY KEY,
    NombreCategoria VARCHAR(100) NOT NULL,
    Descripcion VARCHAR(255)
);

-- Tabla Sede
CREATE TABLE Sede (
    SedeID INT AUTO_INCREMENT PRIMARY KEY,
    NombreSede VARCHAR(100) NOT NULL,
    Direccion VARCHAR(200),
    Telefono VARCHAR(20)
);

-- Tabla Proveedor
CREATE TABLE Proveedor (
    ProveedorID INT AUTO_INCREMENT PRIMARY KEY,
    NombreProveedor VARCHAR(100) NOT NULL,
    Telefono VARCHAR(20),
    Correo VARCHAR(100),
    Direccion VARCHAR(200)
);

-- Tabla Productos
CREATE TABLE Producto (
    ProductoID INT AUTO_INCREMENT PRIMARY KEY,
    NombreProducto VARCHAR(100) NOT NULL,
    Precio DECIMAL(10,2) NOT NULL,
    Stock INT NOT NULL,
    CategoriaID INT NOT NULL,
    ProveedorID INT NOT NULL,
    SedeID INT NOT NULL,
    FOREIGN KEY (CategoriaID) REFERENCES Categoria(CategoriaID),
    FOREIGN KEY (ProveedorID) REFERENCES Proveedor(ProveedorID),
    FOREIGN KEY (SedeID) REFERENCES Sede(SedeID)
);

-- Tabla Venta
CREATE TABLE Venta (
    VentaID INT AUTO_INCREMENT PRIMARY KEY,
    FechaVenta DATETIME NOT NULL,
    Total DECIMAL(10,2) NOT NULL,
    UsuarioID INT NOT NULL,
    FOREIGN KEY (UsuarioID) REFERENCES Usuario(UsuarioID)
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
