-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-01-2025 a las 01:59:53
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `banco_central`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajeros`
--

CREATE TABLE `cajeros` (
  `id_cajero` varchar(20) NOT NULL,
  `ubicacion` varchar(100) DEFAULT NULL,
  `efectivo_disponible` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cajeros`
--

INSERT INTO `cajeros` (`id_cajero`, `ubicacion`, `efectivo_disponible`) VALUES
('CAJ001', 'Sucursal Principal', 10000),
('Cajero001', 'Sucursal Centro', 5000),
('Cajero002', 'Sucursal Norte', 8000),
('Cajero003', 'Sucursal Sur', 8000),
('Cajero004', 'Sucursal Centro', 8000),
('Cajero005', 'Sucursal Norte', 8000),
('Cajero006', 'Sucursal Sur', 8000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` varchar(10) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `direccion`) VALUES
('C001', 'Calle Falsa 123'),
('C002', 'Avenida Siempre Viva N 742'),
('C003', 'Calle Alegria N 345'),
('C004', 'Avenida Arce N 324'),
('C005', 'San Francisco N 457'),
('C006', 'Otero De La Vega N 549'),
('C007', 'Av. Principal 123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `nro_cuenta` int(11) NOT NULL,
  `saldo` double DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `tasa_interes` double DEFAULT NULL,
  `saldo_minimo` double DEFAULT NULL,
  `limite_sobregiro` double DEFAULT NULL,
  `cliente_id` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`nro_cuenta`, `saldo`, `tipo`, `tasa_interes`, `saldo_minimo`, `limite_sobregiro`, `cliente_id`) VALUES
(1001, 400, 'CORRIENTE', NULL, NULL, 1000, 'C001'),
(1002, 100, 'AHORRO', 10, 50, NULL, 'C001'),
(2001, 300, 'AHORRO', 5, 100, NULL, 'C002'),
(2002, 450, 'AHORRO', 4, 1500, NULL, 'C002'),
(3001, 780, 'CORRIENTE', NULL, NULL, 139, 'C003'),
(3002, 1000, 'CORRIENTE', NULL, NULL, 1, 'C003'),
(3003, 14522, 'CORRIENTE', NULL, NULL, 120, 'C003'),
(3004, 100, 'AHORRO', 10, 50, NULL, 'C003'),
(4001, 1200, 'CORRIENTE', NULL, NULL, 500, 'C004'),
(5001, 500, 'AHORRO', 8, 200, NULL, 'C005'),
(6001, 600, 'CORRIENTE', NULL, NULL, 300, 'C006'),
(7001, 1000, 'CORRIENTE', NULL, NULL, 500, 'C007'),
(7002, 500, 'AHORRO', 5, 100, NULL, 'C007');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetas`
--

CREATE TABLE `tarjetas` (
  `num_tarjeta` varchar(20) NOT NULL,
  `limite` double DEFAULT NULL,
  `saldo` double DEFAULT NULL,
  `cliente_id` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarjetas`
--

INSERT INTO `tarjetas` (`num_tarjeta`, `limite`, `saldo`, `cliente_id`) VALUES
('123456789', 5000, 2000, NULL),
('555555555', 4000, 2500, NULL),
('666666666', 6000, 3500, NULL),
('777777777', 8000, 1000, NULL),
('888888888', 9000, 4500, NULL),
('987654321', 3000, 1500, NULL),
('A1234', 1000, 3050, 'C001'),
('BR143', 3000, 200, 'C001'),
('D1121', 1500, 1000, 'C004'),
('E3141', 2500, 1200, 'C005'),
('F5161', 3500, 1800, 'C006'),
('F785', 3000, 10, 'C003'),
('H12658', 2300, 55, 'C003'),
('N9876', 5000, 1000, 'C007'),
('Q4753', 49483, 378, 'C003'),
('W48573', 2300, 55, 'C003');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cajeros`
--
ALTER TABLE `cajeros`
  ADD PRIMARY KEY (`id_cajero`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`nro_cuenta`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- Indices de la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  ADD PRIMARY KEY (`num_tarjeta`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`);

--
-- Filtros para la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  ADD CONSTRAINT `tarjetas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
