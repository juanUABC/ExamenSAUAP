-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS AsignacionUA;
USE AsignacionUA;

-- ========================
-- Tabla Profesor
-- ========================
CREATE TABLE Profesor (
    ID_profesor INT AUTO_INCREMENT PRIMARY KEY,
    nombre_profesor VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(100) NOT NULL,
    apellido_materno VARCHAR(100),
    RFC VARCHAR(13) UNIQUE NOT NULL
);

-- ========================
-- Tabla Unidad de Aprendizaje
-- ========================
CREATE TABLE Unidad_Aprendizaje (
    ID_unidad INT AUTO_INCREMENT PRIMARY KEY,
    nombre_UP VARCHAR(150) NOT NULL,
    horas_clase INT NOT NULL,
    horas_laboratorio INT NOT NULL,
    horas_taller INT NOT NULL
);

-- ========================
-- Tabla Administrador
-- ========================
CREATE TABLE Administrador (
    ID_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre_usuario VARCHAR(100) NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

-- ========================
-- Tabla Asigna (relación N:M con atributos)
-- ========================
CREATE TABLE Asigna (
    ID_asignacion INT AUTO_INCREMENT PRIMARY KEY,
    ID_profesor INT NOT NULL,
    ID_unidad INT NOT NULL,
    dia_semana ENUM('Lunes','Martes','Miercoles','Jueves','Viernes','Sabado') NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    FOREIGN KEY (ID_profesor) REFERENCES Profesor(ID_profesor) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ID_unidad) REFERENCES Unidad_Aprendizaje(ID_unidad) ON DELETE CASCADE ON UPDATE CASCADE
);