-- phpMyAdmin SQL Dump
-- version 4.4.10
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2017 m. Kov 30 d. 08:53
-- Server version: 5.6.23
-- PHP Version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `SuniukuViesbutis`
--

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `Darbuotojas`
--

CREATE TABLE IF NOT EXISTS `Darbuotojas` (
  `ID` varchar(5) NOT NULL,
  `Vardas` varchar(20) DEFAULT NULL,
  `Pavarde` varchar(20) DEFAULT NULL,
  `Pareigos` varchar(20) DEFAULT NULL,
  `Viesbutis` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Sukurta duomenų kopija lentelei `Darbuotojas`
--

INSERT INTO `Darbuotojas` (`ID`, `Vardas`, `Pavarde`, `Pareigos`, `Viesbutis`) VALUES
('1', 'Tomas', NULL, NULL, NULL),
('2', NULL, NULL, NULL, NULL),
('23', NULL, NULL, NULL, NULL),
('2555', NULL, NULL, NULL, NULL),
('a123', NULL, NULL, NULL, NULL),
('aaa', NULL, NULL, NULL, NULL),
('d', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `Darbuotoju_Suniuku_Sarasas`
--

CREATE TABLE IF NOT EXISTS `Darbuotoju_Suniuku_Sarasas` (
  `SuniukoID` varchar(20) NOT NULL,
  `DarbuotojoID` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Sukurta duomenų kopija lentelei `Darbuotoju_Suniuku_Sarasas`
--

INSERT INTO `Darbuotoju_Suniuku_Sarasas` (`SuniukoID`, `DarbuotojoID`) VALUES
('1', '1'),
('2', '2'),
('2344', '23'),
('566', '2555'),
('1456', 'a123'),
('aaa', 'aaa'),
('Ä?', 'd');

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `Suniukas`
--

CREATE TABLE IF NOT EXISTS `Suniukas` (
  `GyvunoID` varchar(20) NOT NULL,
  `Vardas` varchar(45) DEFAULT NULL,
  `Veisle` varchar(45) DEFAULT NULL,
  `Viesbutis` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Sukurta duomenų kopija lentelei `Suniukas`
--

INSERT INTO `Suniukas` (`GyvunoID`, `Vardas`, `Veisle`, `Viesbutis`) VALUES
('1', '1', '1', NULL),
('123', 'bobis', 'mopsas', '123'),
('1456', 'tobis', 'ciauciau', NULL),
('2', 'd', 'ee', NULL),
('2344', 'jvnjdn', 'jcdnvkjnd', NULL),
('566', 'jdf', 'jdhvk', NULL),
('aaa', 'a', 'a', NULL),
('Ä?', 'd', 'k', NULL);

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `Viesbutis`
--

CREATE TABLE IF NOT EXISTS `Viesbutis` (
  `Kodas` varchar(20) NOT NULL,
  `Pavadinimas` varchar(20) NOT NULL,
  `Adresas` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Sukurta duomenų kopija lentelei `Viesbutis`
--

INSERT INTO `Viesbutis` (`Kodas`, `Pavadinimas`, `Adresas`) VALUES
('123', 'royal', 'Upes 2');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Darbuotojas`
--
ALTER TABLE `Darbuotojas`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`),
  ADD KEY `ID_2` (`ID`),
  ADD KEY `Kodas_idx` (`Viesbutis`);

--
-- Indexes for table `Darbuotoju_Suniuku_Sarasas`
--
ALTER TABLE `Darbuotoju_Suniuku_Sarasas`
  ADD PRIMARY KEY (`SuniukoID`,`DarbuotojoID`),
  ADD KEY `DarbuotojoID_idx` (`DarbuotojoID`);

--
-- Indexes for table `Suniukas`
--
ALTER TABLE `Suniukas`
  ADD PRIMARY KEY (`GyvunoID`),
  ADD KEY `Kodas_idx` (`Viesbutis`);

--
-- Indexes for table `Viesbutis`
--
ALTER TABLE `Viesbutis`
  ADD PRIMARY KEY (`Kodas`),
  ADD UNIQUE KEY `Kodas` (`Kodas`),
  ADD KEY `Kodas_2` (`Kodas`);

--
-- Apribojimai eksportuotom lentelėm
--

--
-- Apribojimai lentelei `Darbuotojas`
--
ALTER TABLE `Darbuotojas`
  ADD CONSTRAINT `Kodas` FOREIGN KEY (`Viesbutis`) REFERENCES `Viesbutis` (`Kodas`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Apribojimai lentelei `Darbuotoju_Suniuku_Sarasas`
--
ALTER TABLE `Darbuotoju_Suniuku_Sarasas`
  ADD CONSTRAINT `DarbuotojoID` FOREIGN KEY (`DarbuotojoID`) REFERENCES `Darbuotojas` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `GyvunoID` FOREIGN KEY (`SuniukoID`) REFERENCES `Suniukas` (`GyvunoID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Apribojimai lentelei `Suniukas`
--
ALTER TABLE `Suniukas`
  ADD CONSTRAINT `Kodas1` FOREIGN KEY (`Viesbutis`) REFERENCES `Viesbutis` (`Kodas`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
