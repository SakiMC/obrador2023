-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-09-2023 a las 17:39:24
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `guia3_ejercicio4`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `ID_empleado` int(11) NOT NULL,
  `dni` bigint(20) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `acceso` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`ID_empleado`, `dni`, `apellido`, `nombre`, `acceso`, `estado`) VALUES
(1, 33487645, 'Santoro', 'Julian', 3, 0),
(2, 27444555, 'Bandera', 'Lucia', 1, 1),
(3, 30123786, 'Cardozo', 'José María', 1, 1),
(5, 22345871, 'Hitachi', 'Minako', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `herramienta`
--

CREATE TABLE `herramienta` (
  `ID_herramienta` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `stock` int(11) NOT NULL,
  `disponible` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `herramienta`
--

INSERT INTO `herramienta` (`ID_herramienta`, `nombre`, `descripcion`, `stock`, `disponible`) VALUES
(1, 'destornillador parker plano', 'automatico, con buscapolo', 50, 40),
(2, 'Amoladora garmin', 'con disco de repuesto', 10, 5),
(3, 'Martillo saca clavo', 'mango madera macizo', 30, 10),
(4, 'Escalera 2.5 metros', 'madera', 10, 1),
(5, 'Taladro Black', 'con mandril y mecha', 20, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `ID_movimiento` int(11) NOT NULL,
  `ID_empleado` int(11) NOT NULL,
  `ID_herramienta` int(11) NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `cantidad_retirada` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`ID_movimiento`, `ID_empleado`, `ID_herramienta`, `fecha_prestamo`, `fecha_devolucion`, `cantidad_retirada`) VALUES
(1, 1, 1, '2023-08-20', NULL, 5),
(2, 1, 5, '2023-08-20', '2023-08-21', 1),
(3, 2, 4, '2022-11-01', '2022-11-29', 1),
(4, 2, 3, '2023-05-10', '2023-05-20', 5),
(5, 3, 2, '2023-05-10', '2023-05-20', 2),
(6, 1, 1, '2022-08-20', '2022-08-29', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`ID_empleado`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `herramienta`
--
ALTER TABLE `herramienta`
  ADD PRIMARY KEY (`ID_herramienta`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`ID_movimiento`),
  ADD KEY `ID_empleado` (`ID_empleado`),
  ADD KEY `ID_herramienta` (`ID_herramienta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `ID_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `herramienta`
--
ALTER TABLE `herramienta`
  MODIFY `ID_herramienta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `ID_movimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `movimiento_ibfk_1` FOREIGN KEY (`ID_empleado`) REFERENCES `empleado` (`ID_empleado`),
  ADD CONSTRAINT `movimiento_ibfk_2` FOREIGN KEY (`ID_herramienta`) REFERENCES `herramienta` (`ID_herramienta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
