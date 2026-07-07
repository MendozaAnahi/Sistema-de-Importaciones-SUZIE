Proyecto Final de POO - GRUPO 2
Script de la base de datos:
```sql
Create database SUU_IMPORTACIONES;
use SUU_IMPORTACIONES;
create table Ventas(
IdVentas int primary key,
Fecha date,
Id_usuario int,
Id_sede int,
Id_metodo_pago int,
foreign key(Id_usuario) references usuarios(Id_usuario),
foreign key(Id_sede) references sedes(Id_sede),
foreign key(Id_metodo_pago) references metodospago(Id_metodo_pago)
);


