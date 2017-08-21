-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 21, 2017 at 11:50 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lugares_mas_visitados`
--

-- --------------------------------------------------------

--
-- Table structure for table `lugar`
--

CREATE TABLE `lugar` (
  `id_lugar` int(11) NOT NULL,
  `nombre_lugar` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `breve_descripcion` varchar(500) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(2000) COLLATE utf8_spanish_ci NOT NULL,
  `punto_mapa` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `lugar`
--

INSERT INTO `lugar` (`id_lugar`, `nombre_lugar`, `breve_descripcion`, `descripcion`, `punto_mapa`) VALUES
(1, 'Cristo de la Concordia', 'El Cristo de la Concordia es una colosal estatua monumental de Jesucristo, que se encuentra sobre el cerro de San Pedro.', 'El Cristo de la Concordia es una colosal estatua monumental de Jesucristo, que se encuentra sobre el cerro de San Pedro en la ciudad de Cochabamba, Bolivia, a una altura de 265 metros sobre la ciudad.', '-17.384318, -66.134980'),
(2, 'Jardín botánico Martín Cárdenas', 'El Jardín Botánico Martín Cárdenas es un jardín botánico en la ciudad de Cochabamba, es miembro de la asociación de Jardines Botánicos de Latinoamérica y del Caribe', 'Este gran jardín botánico de aproximadamente dos hectáreas de extensión, lleva el nombre del insigne Doctor Martín Cárdenas, cochabambino, quien dedicó gran parte de su vida al estudio de la botánica sobre la flora de Bolivia viajando por todo el territorio nacional. El jardín tiene la finalidad de contribuir a la conservación de los recursos vegetales de la región, realizando investigaciones científicas y enseñando a través de sus instalaciones sobre áreas de botánica y medio ambiente.', '-17.377230, -66.139752'),
(3, 'Laguna La Angostura', 'La laguna La Angostura es una laguna artificial en Bolivia, ubicada en la provincia de Esteban Arze en el departamento de Cochabamba', 'La laguna La Angostura es una laguna artificial en Bolivia, ubicada en la provincia de Esteban Arze en el departamento de Cochabamba.\r\nSu nombre oficial es «Represa México», y está ubicada a 17 km de la ciudad de Cochabamba, a una altura de 2700 m sobre el nivel del mar.\r\nTiene unas dimensiones máximas de 9,7 km de largo por 2 km de ancho y una superficie de 10,5 km².', '-17.534819, -66.092864'),
(4, 'Museo Casona Santivañez', 'La Casona Santivañez declarada Patrimonio Histórico de Cochabamba, constituye una reliquia arquitectónica de estilo colonial', 'La Casona Santivañez declarada Patrimonio Histórico de Cochabamba, constituye una reliquia arquitectónica de estilo colonial, que data del siglo XIX. La elegancia, historia y colorido, caracterizan esta infraestructura de gran valor turístico para Cochabamba.\r\n\r\nPerteneció en su época a Don Juan Antonio Santivañez de Gazma y Barrao. A la muerte de los herederos, el inmueble pasó a ser propiedad de la Universidad Católica Boliviana. Posteriormente, la Honorable Municipalidad de Cochabamba, recuperó el predio sobre la base de una permuta con el fin expreso de cobijar el museo de la familia Santivañez y ser un centro de exposición artístico cultural', '-17.394657, -66.159028'),
(5, 'Parque De La Familia', 'Visita el Parque de la Familia para disfrutar de un espectáculo único: ver cinco fuentes de agua que bailan al ritmo de música clásica, folclórica o simplemente popular junto a un arco iris de luces de tecnología led y láser de última generación', 'Visita el Parque de la Familia para disfrutar de un espectáculo único: ver cinco fuentes de agua que bailan al ritmo de música clásica, folclórica o simplemente popular junto a un arco iris de luces de tecnología led y láser de última generación. \r\n\r\nEl complejo de las aguas danzantes fue construido en al menos 7.500 metros cuadrados con una inversión de más de 36 millones de bolivianos financiados por la Alcaldía de Cercado, según datos de ABI.\r\n\r\nEl sistema de entretenimiento tecnológico cuenta con una fuente de forma ovalada de 80 metros de largo por 40 metros de ancho, capaz de mover chorros de agua con una altura de 20 metros y con el destello de luces de diversos colores.', '-17.386223, -66.162789'),
(6, 'Parque de Educación Vial', 'Area recreacional de educación vial, donde los mas pequeños pueden aprender sobre la seguridad vial, a través de un pequeño circuito y recorridos divertidos', 'Área recreacional de educación vial, donde los mas pequeños pueden aprender sobre la seguridad vial, a través de un pequeño circuito y recorridos divertidos, en el cual podrán identificar las diferentes señalizaciones viales. Dentro esta área se puede apreciar igualmente diferentes juegos recreacionales, paseos a través del trencito en las diferentes calles creadas dentro el parque y diversión con cochecitos chocadores además de diferentes áreas verdes.', '-17.381062, -66.155033'),
(7, 'Parque Acuatico Mariscal Santa Cruz', 'El Parque Mariscal Santa Cruz es una verdadera y sólida opción para quienes deseen practicar deportes de diferente naturaleza', 'El Parque Mariscal Santa Cruz es una verdadera y sólida opción para quienes deseen practicar deportes de diferente naturaleza. Cuenta con amplios espacios verdes, campos deportivos y áreas para juegos o simplemente lugares de convivencia. Su infraestructura deportiva consta de canchas poli funcionales, ideales para la práctica de basket, volley ball y fútbol de salón. Los anteriores aspectos se complementan con servicios públicos y gastronómicos, lo que permite una agradable estadía de los visitantes. \r\n\r\nSe destaca como el espacio recreativo mas grande de la cuidad de Cochabamba. El objetivo de su creación fue la sensibilización ciudadana, recuperación y preservación del medio ambiente, además de la defensa de los recursos de la naturaleza como el agua, el aire , y la biodiversidad. \r\n\r\nEs un lugar de encuentro para niños y público en general, donde se puede disfrutar en familia de la piscina, entornos naturales, diferentes juegos recreativos, botes acuáticos a pedal y tener una experiencia dentro del museo subterráneo del parque.', '-17.400593, -66.174185'),
(8, 'Plaza 14 de Septiembre', 'De estilo colonial, anteriormente denominada Plaza de Armas, debe su actual nombre a la fecha más importante de la independencia de Cochabamba ante el yugo español', 'De estilo colonial, anteriormente denominada Plaza de Armas, debe su actual nombre a la fecha más importante de la independencia de Cochabamba ante el yugo español, es la plaza principal de la ciudad ubicada en el casco viejo. En su perímetro se encuentra la Catedral Metropolitana, la Prefectura, la Municipalidad entre otros organismos de la ciudad.\r\n\r\nSe ve embellecida por una fuente de agua llamada Fuente de las Tres Gracias, compuesta por tres figuras femeninas unidas por la espalda y tomadas de las manos representando tres deidades de la mitología griega: Áglae: diosa de la belleza y esplendor, Talía: del teatro y las festividades; y finalmente Eufrosina, representante del júbilo y la alegría', '-17.393795, -66.156961'),
(9, 'PARQUE DE AVES Agroflori', 'Groflori Parque de las Aves empezó como un invernadero hace aproximadamente 22 años; hace cinco años está abierto al público', 'UN ESPACIO QUE ALBERGA A MÁS DE 54 ESPECIES DE AVES EN COCHABAMBA | EL LUGAR PERFECTO PARA QUE LA SOCIEDAD CONOZCA SOBRE LA VIDA SILVESTRES Y EL CUIDADO DEL MEDIO AMBIENTE EN GENERAL.\r\n\r\nGroflori Parque de las Aves empezó como un invernadero hace aproximadamente 22 años; hace cinco años está abierto al público.', '-17.3764148, -66.2736934'),
(12, 'Museo Arqueológico de la UMSS', 'El Museo Aqueológico de la Universidad Mayor de San Simón cuenta actualmente con aproximadamente 40.000 piezas arqueológicas, etnográficas y paleontológicas', 'El Museo Aqueológico de la Universidad Mayor de San Simón cuenta actualmente con aproximadamente 40.000 piezas arqueológicas, etnográficas y paleontológicas, clasificadas e inventariadas en su mayoría procedentes del Departamento de Cochabamba y otras regiones de Bolivia. Cuenta con un equipo de investigadores que realizan estudios, proyectos y programas en coordinación con instituciones científicas, educativas y demás dentro y fuera del país', '-17.395368, -66.157361'),
(13, 'El Pueblito en Tupuraya', 'El Pueblito, en Cochabamba es un pequeño barrio antiguo, ubicado al noroeste de la ciudad, en la zona de Tupuraya', 'El Pueblito, en Cochabamba es un pequeño barrio antiguo, ubicado al noroeste de la ciudad, en la zona de Tupuraya. Se considera que fue uno de los primeros asentamientos indígenas que existieron en la ciudad, habitado por el grupo étnico Los Canas que fundaron la ciudad de Canata emplazada según los estudiosos, en lo que actualmente conocemos como El Pueblito. Tan es así que a Cochabamba también se le conoce con dicho nombre.  La zona sirvió además de residencia a los españoles en la época de la colonia. Aquí es probable que se hayan dado acontecimientos trascendentales para la historia regional como fue la fundación de Cochabamba.', '-17.375104, -66.141262'),
(16, 'Laguna Alalay', 'Esta inmensa laguna ubicada al sur de la ciudad, con una extensión aproximada de 240 hectáreas, se constituye en el gran pulmón de la ciudad.', 'Esta inmensa laguna ubicada al sur de la ciudad, con una extensión aproximada de 240 hectáreas, se constituye en el gran pulmón de la ciudad. En proceso de recuperación y descontaminación estos últimos años, va recuperando su atractivo de antaño, permitiendo que aves y especies de la región tengan a la laguna como su hábitat natural. Alalay está considerada como área de preservación, estando prohibida la caza y la pesca.\r\n\r\nLa laguna Alalay funciona como un sistema semi artificial desde hace más de 80 años, que regula las crecidas del Rio Rocha en épocas de inundación.', '-17.407693, -66.137849'),
(17, 'Casona de Mayorazgo', 'Esta casona de más de 300 años de antigüedad situada en la zona de Cala-Cala, sobre la avenida Simón López, es considerada un invaluable patrimonio de la ciudad', 'Esta casona de más de 300 años de antigüedad situada en la zona de Cala-Cala, sobre la avenida Simón López, es considerada un invaluable patrimonio de la ciudad, pues perteneció a uno de los primeros habitantes de la ciudad cuando Cochabamba aún se denominaba Villa de Oropesa. Se trata de don Garci Ruíz de Orellana que ingresó a los valles de Cochabamba hacia el año 1538 cuando se daban las luchas civiles entre los españoles. Él mismo dice en un documento que fue el primer poblador y fue la causa que dio origen a la Villa de Oropeza, que se la organizó posteriormente cuando hubo mayor afluencia de gente', '-17.365205, -66.174720'),
(18, 'Toro Toro', 'De belleza exuberante, muestra los vestigios de la historia y de su extraordinaria riqueza natural', 'El Parque Nacional de ToroToro se encuentra al norte del departamento de Potosí, provincia Charcas a una altitud de 1600 a 3600 msnm. Aunque se ubica fuera del departamento de Cochabamba, el punto de partida y el ingreso se debe hacer desde esta ciudad porque sólo les separan 138 km de distancia, atravesando el valle alto (Tarata, Huayculi, Anzaldo y Thayapaya) para llegar al Parque.\r\n\r\nToroToro tiene una superficie de 165 km2 y un clima templado, típico de la región de los valles secos interandinos. La región es típicamente montañosa con profundos cañones, valles y caídas de agua. De belleza exuberante, TotoToro muestra los vestigios de la historia y de su extraordinaria riqueza natural, siendo un lugar ideal para realizar investigaciones paleontológicas, arqueológicas y culturales por su riqueza en fósiles, huellas de dinosaurios y restos.', '-18.049188, -65.780157'),
(19, 'Inkallajta', 'Incallajta es un complejo arqueológico de la época incaica ubicada en la provincia de Carrasco, al este de la ciudad de Cochabamba', 'Incallajta es un complejo arqueológico de la época incaica ubicada en la provincia de Carrasco, al este de la ciudad de Cochabamba.\r\n\r\nFue construida por el inca Tupac Yupanqui aproximadamente en el año 1470 y reconstruida por su hijo Wayna Kapac. La finalidad de la ciudadela fue detener el avance de los pueblos orientales como los chiriguanos y otros de la Amazonía hacia los valles fértiles de Pocona y más al oeste, de Cochabamba.', '-17.646798, -65.364942');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `lugar`
--
ALTER TABLE `lugar`
  ADD PRIMARY KEY (`id_lugar`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `lugar`
--
ALTER TABLE `lugar`
  MODIFY `id_lugar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
