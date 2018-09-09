# Host: localhost  (Version 5.0.22-community-nt)
# Date: 2018-09-09 15:19:45
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "producto"
#

CREATE TABLE `producto` (
  `PK_PRODUCTO` int(5) NOT NULL auto_increment,
  `NOMBRE` varchar(50) NOT NULL default '',
  `STOCK` int(6) NOT NULL default '0',
  `VALOR_VENTA_UNIDAD` decimal(30,2) NOT NULL default '0.00',
  PRIMARY KEY  (`PK_PRODUCTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "producto"
#


#
# Structure for table "pedido"
#

CREATE TABLE `pedido` (
  `PK_PEDIDO` int(5) NOT NULL auto_increment,
  `FK_PK_PRODUCTO` int(5) NOT NULL default '0',
  `CANTIDAD` int(5) NOT NULL default '0',
  `FECHA` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`PK_PEDIDO`),
  KEY `FK_PK_PRODUCTO` (`FK_PK_PRODUCTO`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`FK_PK_PRODUCTO`) REFERENCES `producto` (`PK_PRODUCTO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "pedido"
#


#
# Structure for table "usuario"
#

CREATE TABLE `usuario` (
  `PK_USUARIO` int(5) NOT NULL auto_increment,
  `NOMBRE_USUARIO` varchar(50) NOT NULL default '',
  `CONTRASENA` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`PK_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "usuario"
#

INSERT INTO `usuario` VALUES (1,'root','[30,-71,-42,-101,-21,-92,-115,-66,-63,124,-36,126,36,52,103,-62]');

#
# Structure for table "venta"
#

CREATE TABLE `venta` (
  `PK_VENTA` int(5) NOT NULL auto_increment,
  `ID_CLIENTE` bigint(15) NOT NULL default '0',
  `NOMBRE_CLIENTE` varchar(100) NOT NULL default '',
  `FECHA` datetime NOT NULL default '0000-00-00 00:00:00',
  `VALOR_TOTAL` decimal(10,2) NOT NULL default '0.00',
  `FK_PK_USUARIO` int(5) NOT NULL default '0',
  PRIMARY KEY  (`PK_VENTA`),
  KEY `FK_PK_USUARIO` (`FK_PK_USUARIO`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`FK_PK_USUARIO`) REFERENCES `usuario` (`PK_USUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "venta"
#


#
# Structure for table "venta_detalle"
#

CREATE TABLE `venta_detalle` (
  `PK_VENTA_DETALLE` int(5) NOT NULL auto_increment,
  `FK_PK_VENTA` int(5) NOT NULL default '0',
  `FK_PK_PRODUCTO` int(5) NOT NULL default '0',
  `CANTIDAD` int(5) NOT NULL default '0',
  PRIMARY KEY  (`PK_VENTA_DETALLE`),
  KEY `FK_PK_VENTA` (`FK_PK_VENTA`),
  KEY `FK_PK_PRODUCTO` (`FK_PK_PRODUCTO`),
  CONSTRAINT `venta_detalle_ibfk_1` FOREIGN KEY (`FK_PK_VENTA`) REFERENCES `venta` (`PK_VENTA`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `venta_detalle_ibfk_2` FOREIGN KEY (`FK_PK_PRODUCTO`) REFERENCES `producto` (`PK_PRODUCTO`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "venta_detalle"
#

