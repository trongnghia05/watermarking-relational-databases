-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 18, 2019 at 06:17 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test4`
--

-- --------------------------------------------------------

--
-- Table structure for table `con_nguoi`
--

CREATE TABLE `con_nguoi` (
  `tuoi` int(11) NOT NULL,
  `dia_chi` varchar(100) NOT NULL,
  `so_chung_minh` varchar(20) NOT NULL,
  `ten` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `con_nguoi`
--

INSERT INTO `con_nguoi` (`tuoi`, `dia_chi`, `so_chung_minh`, `ten`) VALUES
(16, 'son la', '123456', 'mai trong nghia'),
(12, 'ha noi', '345678', 'mai vu khanh linh'),
(12, 'nghe an', '555678', 'phan van tung'),
(11, 'nghe an', '678957', 'vo van  linh');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `con_nguoi`
--
ALTER TABLE `con_nguoi`
  ADD PRIMARY KEY (`so_chung_minh`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
