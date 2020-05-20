-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2020 at 06:43 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tiketkereta`
--

-- --------------------------------------------------------

--
-- Table structure for table `kereta`
--

CREATE TABLE `kereta` (
  `id` varchar(10) NOT NULL,
  `nkereta` varchar(20) NOT NULL,
  `kelas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kereta`
--

INSERT INTO `kereta` (`id`, `nkereta`, `kelas`) VALUES
('70707', 'Ketandan', 'VVIP'),
('6060', 'Pratameks', 'VIP'),
('50505', 'Surya Kencana', 'Reguler');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `nama` varchar(20) NOT NULL,
  `jk` varchar(20) NOT NULL,
  `tujuan` varchar(20) NOT NULL,
  `nkereta` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`nama`, `jk`, `tujuan`, `nkereta`) VALUES
('Satria', 'Pria', 'Lempuyangan', 'Pratameks'),
('nabila', 'Wanita', 'Tugu Jogja', 'Pratameks');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kereta`
--
ALTER TABLE `kereta`
  ADD PRIMARY KEY (`nkereta`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD KEY `nkereta` (`nkereta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
