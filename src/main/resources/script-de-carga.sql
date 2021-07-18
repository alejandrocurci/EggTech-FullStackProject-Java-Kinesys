create database kinesysbd;
use kinesysbd;

## OBRAS SOCIALES ##
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('1', '200', 'OSDE', '2615228822');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('2', '300', 'OSDE', '2615228822');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('3', '400', 'OSDE', '2615228822');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('4', 'Plata', 'GALENO', '2616778822');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('5', 'Oro', 'GALENO', '2616778822');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('6', 'Platino', 'GALENO', '2616778822');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('7', 'Plan 1', 'Swiss Medical', '2614999000');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('8', 'Plan 2', 'Swiss Medical', '2614999000');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('9', 'Plan 3', 'Swiss Medical', '2614999000');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('10', 'Plan 4', 'Swiss Medical', '2614999000');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('11', 'Plan Silver', 'Medicus', '2616282828');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('12', 'Plan Gold', 'Medicus', '2616282828');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('13', 'Plan Platinum', 'Medicus', '2616282828');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('14', 'Plan Diamond', 'Medicus', '2616282828');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('15', 'Plan A', 'OSEP', '2615330033');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('16', 'Plan B', 'OSEP', '2615330033');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('17', 'Plan C', 'OSEP', '2615330033');
INSERT INTO `kinesysbd`.`obra_social` (`id_obra_social`, `plan`, `nombre`, `telefono`) VALUES ('18', 'Plan D', 'OSEP', '2615330033');

## ROLES ##
INSERT INTO `kinesysbd`.`rol` (`id_rol`, `nombre`) VALUES ('ADMIN', 'ADMIN');
INSERT INTO `kinesysbd`.`rol` (`id_rol`, `nombre`) VALUES ('PACIENTE', 'PACIENTE');
INSERT INTO `kinesysbd`.`rol` (`id_rol`, `nombre`) VALUES ('PROFESIONAL', 'PROFESIONAL');

## ZONAS ##
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('1', 'Calle 123', 'Capital', '0');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('2', 'Calle 234', 'Capital', '1');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('3', 'Calle 333', 'Capital', '2');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('4', 'Calle 111', 'Capital', '3');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('5', 'Calle 456', 'Capital', '4');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('6', 'Calle 152', 'Capital', '5');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('7', 'Calle 142', 'Capital', '6');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('8', 'Calle 888', 'Capital', '7');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('9', 'Calle 21523', 'Capital', '8');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('10', 'Calle 232534', 'Capital', '9');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('11', 'Calle 12353', 'Capital', '10');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('12', 'Calle 12315', 'Capital', '11');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('13', 'Pasaje 123', 'Zona Sur', '0');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('14', 'Pasaje 234', 'Zona Sur', '1');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('15', 'Pasaje 333', 'Zona Sur', '2');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('16', 'Pasaje 111', 'Zona Sur', '3');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('17', 'Pasaje 456', 'Zona Sur', '4');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('18', 'Pasaje 152', 'Zona Sur', '5');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('19', 'Pasaje 142', 'Zona Sur', '6');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('20', 'Pasaje 888', 'Zona Sur', '7');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('21', 'Pasaje 21523', 'Zona Sur', '8');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('22', 'Pasaje 232534', 'Zona Sur', '20');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('23', 'Pasaje 12353', 'Zona Sur', '19');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('24', 'Pasaje 12315', 'Zona Sur', '18');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('25', 'Avenida 152', 'Villa Nueva', '12');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('26', 'Avenida 142', 'Villa Nueva', '13');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('27', 'Avenida 888', 'Villa Nueva', '14');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('28', 'Avenida 21523', 'Villa Nueva', '15');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('29', 'Avenida 232534', 'Villa Nueva', '16');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('30', 'Avenida 12353', 'Villa Nueva', '17');

## USUARIOS DE PACIENTES Y PROFESIONALES
## CLAVE ES "1234"

INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('1', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente1', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('2', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente2', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('3', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente3', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('4', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente4', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('5', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente5', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('6', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente6', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('7', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente7', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('8', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente8', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('9', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente9', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('10', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente10', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('11', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente11', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('12', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente12', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('13', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente13', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('14', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente14', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('15', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente15', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('16', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente16', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('17', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente17', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('18', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente18', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('19', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente19', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('20', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente20', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('21', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente21', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('22', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente22', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('23', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente23', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('24', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente24', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('25', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente25', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('26', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente26', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('27', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente27', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('28', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente28', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('29', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente29', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('30', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'paciente30', 'PACIENTE');

INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('111', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional1', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('112', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional2', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('113', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional3', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('114', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional4', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('115', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional5', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('116', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional6', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('117', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional7', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('118', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional8', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('119', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional9', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('120', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional10', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('121', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional11', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('122', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional12', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('123', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional13', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('124', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional14', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('125', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional15', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('126', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional16', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('127', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional17', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('128', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional18', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('129', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional19', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('130', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional20', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('131', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional21', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('132', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional22', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('133', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional23', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('134', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional24', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('135', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional25', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('136', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional26', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('137', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional27', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('138', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional28', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('139', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional29', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('140', '$2a$10$Pjbp7Gy2MedlAriX1Wi9KubU8umYxZgpOFud/S5bwYeiRDDyyT.Yu', 'profesional30', 'PROFESIONAL');

## PACIENTES ##
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('1', 'Garcia', '33900300', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '1');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('2', 'Gomez', '33289303', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '2');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('3', 'Rodriguez', '31029029', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '3');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('4', 'Lopez', '41029029', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '4');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('5', 'Alvarez', '21878265', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '5');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('6', 'Garcia', '21392028', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '6');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('7', 'Gomez', '26900328', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '7');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('8', 'Rodriguez', '27890273', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '8');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('9', 'Lopez', '34244223', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '9');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('10', 'Alvarez', '17899021', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '10');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('11', 'Garcia', '43567234', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '11');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('12', 'Gomez', '23657890', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '12');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('13', 'Rodriguez', '21342565', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '13');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('14', 'Lopez', '22343143', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '14');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('15', 'Alvarez', '43234667', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '15');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('16', 'Garcia', '34523456', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '16');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('17', 'Gomez', '39854321', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '17');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('18', 'Rodriguez', '36345786', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '18');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('19', 'Lopez', '34244224', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '19');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('20', 'Alvarez', '17899022', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '20');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('21', 'Garcia', '33900301', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '21');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('22', 'Gomez', '33289304', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '22');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('23', 'Rodriguez', '31029028', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '23');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('24', 'Lopez', '41029028', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '24');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('25', 'Alvarez', '21878266', 'mi-mail@gmail.com', 'Juan', '156778899', 'PACIENTE', '25');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('26', 'Garcia', '21392029', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '26');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('27', 'Gomez', '26900329', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '27');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('28', 'Rodriguez', '27890274', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '28');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('29', 'Lopez', '34244222', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '29');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('30', 'Alvarez', '17899020', 'mi-mail@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '30');

## PROFESIONALES
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('1', 'Gimenez', '18900212', '48', 'mail@yahoo.com', '0', '5235', 'Carlos', 'MASCULINO', '110181019', 'PROFESIONAL', '111');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('2', 'Sanchez', '29101910', '48', 'mail@yahoo.com', '1', '34564', 'Luis', 'MASCULINO', '110181019', 'PROFESIONAL', '112');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('3', 'Gimenez', '38018019', '48', 'mail@yahoo.com', '2', '26342', 'Pedro', 'MASCULINO', '110181019', 'PROFESIONAL', '113');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('4', 'Sanchez', '12930191', '48', 'mail@yahoo.com', '3', '2891', 'Julieta', 'FEMENINO', '110181019', 'PROFESIONAL', '114');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('5', 'Gimenez', '29019101', '48', 'mail@yahoo.com', '4', '77414', 'Barbara', 'FEMENINO', '110181019', 'PROFESIONAL', '115');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('6', 'Sanchez', '32019101', '48', 'mail@yahoo.com', '5', '411355', 'Sofia', 'FEMENINO', '110181019', 'PROFESIONAL', '116');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('7', 'Gimenez', '29101920', '48', 'mail@yahoo.com', '2', '11353', 'Santiago', 'MASCULINO', '110181019', 'PROFESIONAL', '117');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('8', 'Sanchez', '21029101', '48', 'mail@yahoo.com', '4', '43437', 'Ignacio', 'MASCULINO', '110181019', 'PROFESIONAL', '118');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('9', 'Gimenez', '22900101', '48', 'mail@yahoo.com', '6', '27965', 'Soledad', 'FEMENINO', '110181019', 'PROFESIONAL', '119');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('10', 'Sanchez', '32019201', '48', 'mail@yahoo.com', '0', '247894', 'Jorge', 'MASCULINO', '110181019', 'PROFESIONAL', '120');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('11', 'Gimenez', '18900213', '48', 'mail@yahoo.com', '0', '11238', 'Carlos', 'MASCULINO', '110181019', 'PROFESIONAL', '121');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('12', 'Sanchez', '29101911', '48', 'mail@yahoo.com', '1', '11568', 'Luis', 'MASCULINO', '110181019', 'PROFESIONAL', '122');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('13', 'Gimenez', '38018018', '48', 'mail@yahoo.com', '2', '45321', 'Pedro', 'MASCULINO', '110181019', 'PROFESIONAL', '123');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('14', 'Sanchez', '12930192', '48', 'mail@yahoo.com', '3', '78124', 'Julieta', 'FEMENINO', '110181019', 'PROFESIONAL', '124');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('15', 'Gimenez', '29019102', '48', 'mail@yahoo.com', '4', '34619', 'Barbara', 'FEMENINO', '110181019', 'PROFESIONAL', '125');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('16', 'Sanchez', '32019102', '48', 'mail@yahoo.com', '5', '4214', 'Sofia', 'FEMENINO', '110181019', 'PROFESIONAL', '126');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('17', 'Gimenez', '29101921', '48', 'mail@yahoo.com', '2', '17513', 'Santiago', 'MASCULINO', '110181019', 'PROFESIONAL', '127');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('18', 'Sanchez', '21029102', '48', 'mail@yahoo.com', '4', '64319', 'Ignacio', 'MASCULINO', '110181019', 'PROFESIONAL', '128');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('19', 'Gimenez', '22900102', '48', 'mail@yahoo.com', '6', '13427', 'Soledad', 'FEMENINO', '110181019', 'PROFESIONAL', '129');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('20', 'Sanchez', '32019202', '48', 'mail@yahoo.com', '0', '16437', 'Jorge', 'MASCULINO', '110181019', 'PROFESIONAL', '130');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('21', 'Gimenez', '18900281', '48', 'mail@yahoo.com', '0', '13427', 'Carlos', 'MASCULINO', '110181019', 'PROFESIONAL', '131');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('22', 'Sanchez', '29101918', '48', 'mail@yahoo.com', '1', '46372', 'Luis', 'MASCULINO', '110181019', 'PROFESIONAL', '132');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('23', 'Gimenez', '38018013', '48', 'mail@yahoo.com', '2', '12437', 'Pedro', 'MASCULINO', '110181019', 'PROFESIONAL', '133');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('24', 'Sanchez', '12930196', '48', 'mail@yahoo.com', '3', '16497', 'Julieta', 'FEMENINO', '110181019', 'PROFESIONAL', '134');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('25', 'Gimenez', '29019109', '48', 'mail@yahoo.com', '4', '13427', 'Barbara', 'FEMENINO', '110181019', 'PROFESIONAL', '135');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('26', 'Sanchez', '32019107', '48', 'mail@yahoo.com', '5', '46372', 'Sofia', 'FEMENINO', '110181019', 'PROFESIONAL', '136');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('27', 'Gimenez', '29101928', '48', 'mail@yahoo.com', '2', '61937', 'Santiago', 'MASCULINO', '110181019', 'PROFESIONAL', '137');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('28', 'Sanchez', '21029109', '48', 'mail@yahoo.com', '4', '99137', 'Ignacio', 'MASCULINO', '110181019', 'PROFESIONAL', '138');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('29', 'Gimenez', '22900105', '48', 'mail@yahoo.com', '6', '6611', 'Soledad', 'FEMENINO', '110181019', 'PROFESIONAL', '139');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('30', 'Sanchez', '32019207', '48', 'mail@yahoo.com', '0', '3761', 'Jorge', 'MASCULINO', '110181019', 'PROFESIONAL', '140');

## ZONAS PARA PROFESIONALES
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('1', '1');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('2', '2');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('3', '3');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('4', '4');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('5', '5');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('6', '6');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('7', '7');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('8', '8');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('9', '9');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('10', '10');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('11', '11');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('12', '12');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('13', '13');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('14', '14');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('15', '15');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('16', '16');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('17', '17');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('18', '18');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('19', '19');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('20', '20');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('21', '21');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('22', '22');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('23', '23');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('24', '24');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('25', '25');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('26', '26');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('27', '27');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('28', '28');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('29', '29');
INSERT INTO `kinesysbd`.`profesionales_zona_profesionales` (`profesional_id_profesional`, `zona_profesionales_id_zona`) VALUES ('30', '30');

## OBRAS SOCIALES PARA PROFESIONALES
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('1', '1');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('2', '2');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('3', '3');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('4', '4');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('5', '5');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('6', '6');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('7', '7');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('8', '8');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('9', '9');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('10', '10');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('11', '11');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('12', '12');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('13', '13');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('14', '14');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('15', '15');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('16', '16');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('17', '17');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('18', '18');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('19', '1');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('20', '2');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('21', '3');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('22', '4');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('23', '5');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('24', '6');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('25', '7');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('26', '8');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('27', '9');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('28', '10');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('29', '11');
INSERT INTO `kinesysbd`.`profesionales_obra_social_profesionales` (`profesional_id_profesional`, `obra_social_profesionales_id_obra_social`) VALUES ('30', '12');

