-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-01-2021 a las 23:37:23
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `financiero`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abonos`
--

CREATE TABLE `abonos` (
  `id_abono` int(11) NOT NULL,
  `id_detventa` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time DEFAULT NULL,
  `abono` double NOT NULL,
  `mora` double NOT NULL,
  `prox_pago` date NOT NULL,
  `comentario` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `abonos`
--

INSERT INTO `abonos` (`id_abono`, `id_detventa`, `fecha`, `hora`, `abono`, `mora`, `prox_pago`, `comentario`) VALUES
(2, 3, '2021-01-15', '00:00:00', 0, 0, '2021-02-14', NULL),
(3, 3, '2021-01-16', NULL, 80, 0, '2021-03-16', NULL),
(4, 3, '2021-01-16', NULL, 100, 0, '2021-04-15', NULL),
(5, 6, '2021-01-16', NULL, 0, 0, '2021-02-15', NULL),
(6, 7, '2021-01-16', NULL, 0, 0, '2021-02-15', NULL),
(7, 7, '2021-01-16', NULL, 100, 0, '2021-03-17', NULL),
(8, 3, '2021-01-16', NULL, 80, 0, '2021-05-15', NULL),
(9, 7, '2021-01-16', NULL, 80, 0, '2021-04-16', NULL),
(10, 9, '2021-01-16', NULL, 0, 0, '2021-02-15', NULL),
(11, 12, '2021-01-16', NULL, 0, 0, '2021-02-15', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `descripcion` varchar(75) COLLATE utf8_spanish_ci NOT NULL,
  `catNombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `descripcion`, `catNombre`) VALUES
(1, 'BAÑO, PISOS, ETC', 'LIMPIEZA'),
(2, 'PLANCHAS, OLLAS, ETC', 'COCINA'),
(3, 'PC, SMARTPHONE, ETC', 'TECNOLOGIA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombres` varchar(65) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(65) COLLATE utf8_spanish_ci NOT NULL,
  `DUI` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `sexo` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(75) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombres`, `apellidos`, `DUI`, `sexo`, `telefono`, `email`, `direccion`, `estado`) VALUES
(1, 'Juan Vladimir', 'Perez Molina', '23451648-9', 'Masculino', '23934589', 'perez@email', 'direcccc', 1),
(2, 'Rosa Pamela', 'Zaragosa Merino', '4578897-7', 'Femenino', '2389-4545', 'email', 'ddi', 0),
(3, 'Juan Manuel ', 'Lopez', '03984028-3', 'masculino', '7489-2384', 'juan@gmail.com', 'La casa de la esquina 2', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `id_compra` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_proveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`id_compra`, `fecha`, `id_proveedor`) VALUES
(1, '2020-02-05', 1),
(2, '2020-01-16', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detcompra`
--

CREATE TABLE `detcompra` (
  `id_detCompra` int(11) NOT NULL,
  `precCompra` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `detcompra`
--

INSERT INTO `detcompra` (`id_detCompra`, `precCompra`, `cantidad`, `id_producto`, `fecha`) VALUES
(6, 2500, 3, 6, '2021-01-12'),
(7, 3000, 4, 8, '2021-01-12'),
(8, 800, 2, 6, '2021-01-13'),
(9, 8000, 6, 9, '2021-01-17');

--
-- Disparadores `detcompra`
--
DELIMITER $$
CREATE TRIGGER `Trigger_IncStock` AFTER INSERT ON `detcompra` FOR EACH ROW update productos 
set stock = stock + new.cantidad,
precio = (new.precCompra*1.05)/new.cantidad
where productos.id_producto = new.id_producto
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detventa`
--

CREATE TABLE `detventa` (
  `id_detVenta` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL,
  `idProd` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `meses` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  `cuota` double DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `detventa`
--

INSERT INTO `detventa` (`id_detVenta`, `id_venta`, `idProd`, `cantidad`, `meses`, `estado`, `cuota`, `total`) VALUES
(1, 20, 8, 2, 0, 1, NULL, 2000),
(2, 22, 6, 1, 24, 0, 80, 1920),
(3, 23, 6, 1, 24, 0, 80, 1920),
(4, 24, 8, 1, 0, 1, 0, 450),
(5, 25, 6, 1, 0, 1, 0, 1200),
(6, 26, 6, 1, 0, 1, 0, 1200),
(7, 27, 6, 1, 24, 0, 80, 1920),
(8, 28, 8, 1, 0, 1, 0, 450),
(9, 29, 8, 1, 12, 0, 48.75, 1785),
(10, 29, 6, 1, 0, 1, 0, 1785),
(11, 30, 8, 1, 0, 1, 0, 450),
(12, 30, 6, 1, 36, 0, 63.333333333333336, 2280);

--
-- Disparadores `detventa`
--
DELIMITER $$
CREATE TRIGGER `Trigger_DecStock` AFTER INSERT ON `detventa` FOR EACH ROW update productos set stock = stock - new.cantidad 
where productos.id_producto = new.idProd
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `dui` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `nombres` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `apellidos` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `sexo` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `fechaNac` date NOT NULL,
  `telefono` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(75) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `cargo` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`dui`, `nombres`, `apellidos`, `sexo`, `fechaNac`, `telefono`, `email`, `direccion`, `cargo`) VALUES
('45897845-8', 'Josué', 'Cornejo', 'Másculino.', '2019-12-17', '2393-4689', 'josue@yahoo.com', 'sdf', 'Administrador.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id_marca`, `nombre`, `descripcion`) VALUES
(1, 'GARCILLEJA', 'No te conozco, lo siento'),
(2, 'SAMSUNG', 'Una empresa coreana'),
(3, 'LG', 'Otros coreanos, o eso creo'),
(4, 'DELL', 'EQUIPO ELECTRONICO'),
(5, 'HP', 'EQUIPO INFORMATICO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `margenganancia`
--

CREATE TABLE `margenganancia` (
  `id_margen` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `porcentaje` decimal(10,0) NOT NULL,
  `categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `margenganancia`
--

INSERT INTO `margenganancia` (`id_margen`, `fecha`, `porcentaje`, `categoria`) VALUES
(1, '2020-01-13', '10', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(75) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `modelo` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `stock` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre`, `descripcion`, `modelo`, `stock`, `id_marca`, `id_categoria`, `id_proveedor`, `precio`) VALUES
(6, 'Smartphone', '4G LTE 3gb ram', 'S20', 0, 2, 1, 4, 1200),
(8, 'Samsung Galaxy S6', '3 gb ram\n32 gb almacenamiento\n4g lte', 'SM-G925P', 0, 2, 2, 4, 450),
(9, 'SmartTV', 'Pantalla plana de 42 pulgadas\nBluetooth 4.2\nHDMI VGA\n5000 colores\n', 'JDU746', 6, 2, 3, 4, 1400);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id_proveedor` int(11) NOT NULL,
  `nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `direccion` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` varchar(11) COLLATE utf8_spanish_ci NOT NULL,
  `correo` varchar(75) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id_proveedor`, `nombre`, `direccion`, `telefono`, `correo`) VALUES
(1, 'PROPAC', 'Col. Navarra 2', '7342-4241', 'propac@gmail.com'),
(2, 'EL SURCO SA DE CV', 'San Vicente y Usulutan', '7834-6894', 'elsurco@gmail.com'),
(3, 'TECNYMED EL SALVADOR', 'Col. España', '7342-8935', 'tecnymed@gmail.com'),
(4, 'THADER', 'Col. Medica', '7424-5245', 'thader@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `empleado` varchar(11) COLLATE utf8_spanish_ci DEFAULT NULL,
  `cliente` int(11) NOT NULL,
  `factura` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `fecha`, `empleado`, `cliente`, `factura`) VALUES
(18, '2019-12-21', '45897845-8', 2, 'F-00000'),
(19, '2019-12-21', '45897845-8', 1, 'F-00001'),
(20, '2020-12-08', '45897845-8', 2, 'F-00002'),
(21, '2020-12-09', '45897845-8', 2, 'F-00003'),
(22, '2020-12-11', '45897845-8', 2, 'F-00004'),
(23, '2021-01-15', NULL, 1, 'F-00005'),
(24, '2021-01-16', NULL, 1, 'F-00006'),
(25, '2021-01-16', NULL, 1, 'F-00007'),
(26, '2021-01-16', NULL, 2, 'F-00008'),
(27, '2021-01-16', NULL, 2, 'F-00009'),
(28, '2021-01-16', NULL, 1, 'F-00010'),
(29, '2021-01-16', NULL, 1, 'F-00011'),
(30, '2021-01-16', NULL, 2, 'F-00012');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `abonos`
--
ALTER TABLE `abonos`
  ADD PRIMARY KEY (`id_abono`),
  ADD KEY `fk_idDetVenta` (`id_detventa`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `id_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `detcompra`
--
ALTER TABLE `detcompra`
  ADD PRIMARY KEY (`id_detCompra`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `detventa`
--
ALTER TABLE `detventa`
  ADD PRIMARY KEY (`id_detVenta`),
  ADD KEY `id_venta` (`id_venta`),
  ADD KEY `idProd` (`idProd`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`dui`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id_marca`);

--
-- Indices de la tabla `margenganancia`
--
ALTER TABLE `margenganancia`
  ADD PRIMARY KEY (`id_margen`),
  ADD UNIQUE KEY `categoria` (`categoria`) USING BTREE;

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_marca` (`id_marca`),
  ADD KEY `id_categoria` (`id_categoria`),
  ADD KEY `id_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id_proveedor`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `empleado` (`empleado`),
  ADD KEY `cliente` (`cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `abonos`
--
ALTER TABLE `abonos`
  MODIFY `id_abono` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detcompra`
--
ALTER TABLE `detcompra`
  MODIFY `id_detCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `detventa`
--
ALTER TABLE `detventa`
  MODIFY `id_detVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id_marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `margenganancia`
--
ALTER TABLE `margenganancia`
  MODIFY `id_margen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id_proveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `abonos`
--
ALTER TABLE `abonos`
  ADD CONSTRAINT `abonos_ibfk_1` FOREIGN KEY (`id_detventa`) REFERENCES `detventa` (`id_detVenta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`);

--
-- Filtros para la tabla `detcompra`
--
ALTER TABLE `detcompra`
  ADD CONSTRAINT `detcompra_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);

--
-- Filtros para la tabla `detventa`
--
ALTER TABLE `detventa`
  ADD CONSTRAINT `detventa_ibfk_1` FOREIGN KEY (`idProd`) REFERENCES `productos` (`id_producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detventa_ibfk_2` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `margenganancia`
--
ALTER TABLE `margenganancia`
  ADD CONSTRAINT `margenganancia_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categoria` (`id_categoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`),
  ADD CONSTRAINT `productos_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  ADD CONSTRAINT `productos_ibfk_3` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id_proveedor`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`empleado`) REFERENCES `empleados` (`dui`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `venta_ibfk_3` FOREIGN KEY (`cliente`) REFERENCES `clientes` (`id_cliente`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
