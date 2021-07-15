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
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('22', 'Pasaje 232534', 'Zona Sur', '9');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('23', 'Pasaje 12353', 'Zona Sur', '10');
INSERT INTO `kinesysbd`.`zona` (`id_zona`, `domicilio`, `localidad`, `provincia`) VALUES ('24', 'Pasaje 12315', 'Zona Sur', '11');

## USUARIOS DE PACIENTES Y PROFESIONALES
## CLAVE ES "1234"
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('1', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente1', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('2', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente2', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('3', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente3', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('4', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente4', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('5', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente5', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('6', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente6', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('7', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente7', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('8', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente8', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('9', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente9', 'PACIENTE');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('10', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'paciente10', 'PACIENTE');

INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('11', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional1', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('12', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional2', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('13', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional3', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('14', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional4', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('15', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional5', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('16', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional6', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('17', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional7', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('18', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional8', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('19', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional9', 'PROFESIONAL');
INSERT INTO `kinesysbd`.`usuario` (`id`, `clave`, `nombreu`, `rol_id_rol`) VALUES ('20', '$10$RI2dOrfndDvLEd5zYxkt5eUA8wQ75dHeWkUQji.7JNif6n5P2HNI2', 'profesional10', 'PROFESIONAL');

## PACIENTES ##
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('1', 'Garcia', '33900300', 'juan@gmail.com', 'Juan', '156778899', 'PACIENTE', '1');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('2', 'Gomez', '33289303', 'juan@gmail.com', 'Juan', '156778899', 'PACIENTE', '2');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('3', 'Rodriguez', '31029029', 'juan@gmail.com', 'Juan', '156778899', 'PACIENTE', '3');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('4', 'Lopez', '41029029', 'juan@gmail.com', 'Juan', '156778899', 'PACIENTE', '4');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('5', 'Alvarez', '21878265', 'juan@gmail.com', 'Juan', '156778899', 'PACIENTE', '5');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('6', 'Garcia', '21392028', 'juan@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '6');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('7', 'Gomez', '26900328', 'juan@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '7');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('8', 'Rodriguez', '27890273', 'juan@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '8');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('9', 'Lopez', '34244223', 'juan@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '9');
INSERT INTO `kinesysbd`.`paciente` (`id_paciente`, `apellido`, `dni`, `email`, `nombre`, `telefono`, `rol_paciente_id_rol`, `usuario_paciente_id`) 
VALUES ('10', 'Alvarez', '17899021', 'juan@gmail.com', 'Rodrigo', '156778899', 'PACIENTE', '10');

## PROFESIONALES
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('1', 'Gimenez', '18900212', '48', 'mail@yahoo.com', '0', '2891', 'Carlos', 'MASCULINO', '110181019', 'PROFESIONAL', '11');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('2', 'Sanchez', '29101910', '48', 'mail@yahoo.com', '1', '2891', 'Luis', 'MASCULINO', '110181019', 'PROFESIONAL', '12');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('3', 'Gimenez', '38018019', '48', 'mail@yahoo.com', '2', '2891', 'Pedro', 'MASCULINO', '110181019', 'PROFESIONAL', '13');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('4', 'Sanchez', '12930191', '48', 'mail@yahoo.com', '3', '2891', 'Julieta', 'FEMENINO', '110181019', 'PROFESIONAL', '14');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('5', 'Gimenez', '29019101', '48', 'mail@yahoo.com', '4', '2891', 'Barbara', 'FEMENINO', '110181019', 'PROFESIONAL', '15');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('6', 'Sanchez', '32019101', '48', 'mail@yahoo.com', '5', '2891', 'Sofia', 'FEMENINO', '110181019', 'PROFESIONAL', '16');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('7', 'Gimenez', '29101920', '48', 'mail@yahoo.com', '2', '2891', 'Santiago', 'MASCULINO', '110181019', 'PROFESIONAL', '17');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('8', 'Sanchez', '21029101', '48', 'mail@yahoo.com', '4', '2891', 'Ignacio', 'MASCULINO', '110181019', 'PROFESIONAL', '18');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('9', 'Gimenez', '22900101', '48', 'mail@yahoo.com', '6', '2891', 'Soledad', 'FEMENINO', '110181019', 'PROFESIONAL', '19');
INSERT INTO `kinesysbd`.`profesionales` (`id_profesional`, `apellido`, `dni`, `edad`, `email`, `especialidad`, `matricula`, `nombre`, `sexo`, `telefono`, `rol_profesional_id_rol`, `usuario_profesional_id`) 
VALUES ('10', 'Sanchez', '32019201', '48', 'mail@yahoo.com', '0', '2891', 'Jorge', 'MASCULINO', '110181019', 'PROFESIONAL', '20');

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

