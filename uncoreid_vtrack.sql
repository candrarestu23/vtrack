-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 12, 2018 at 10:53 AM
-- Server version: 5.6.38
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uncoreid_vtrack`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_kiriman`
--

CREATE TABLE `detail_kiriman` (
  `id_kiriman` int(11) NOT NULL,
  `tanggal` datetime NOT NULL,
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kendaraan`
--

CREATE TABLE `kendaraan` (
  `id_kenda` varchar(50) NOT NULL,
  `pengemudi` varchar(250) NOT NULL,
  `latitude` varchar(500) NOT NULL,
  `longitude` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kendaraan`
--

INSERT INTO `kendaraan` (`id_kenda`, `pengemudi`, `latitude`, `longitude`) VALUES
('A1771R', 'HanjaraAdhyatma', '-6.976553', '107.629600'),
('AA6137KT', 'ptimakashi', '5', '5'),
('B2089RF', 'HanjaraAdhyatma', '-6.976545', '107.629615'),
('D6137KT', 'admin', '-6.976583', '107.629592'),
('D6969AK', 'candraRestu', '-6.976543', '107.629608'),
('E5719PY', 'primakashi', '-6.976669', '107.629493'),
('L1997YZ', 'IkhwanFaruq', '-6.976646', '107.629501');

-- --------------------------------------------------------

--
-- Table structure for table `kiriman`
--

CREATE TABLE `kiriman` (
  `id_kiriman` int(11) NOT NULL,
  `tanggal` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `id_kendaraan` varchar(50) NOT NULL,
  `tujuan` varchar(250) NOT NULL,
  `pengemudi` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kiriman`
--

INSERT INTO `kiriman` (`id_kiriman`, `tanggal`, `id_kendaraan`, `tujuan`, `pengemudi`) VALUES
(1023111, '2017-05-01 10:26:26', 'A 1771 R', 'Jl RAA Sastrawinata No.3 Ciamis', 'Oki Marzuki'),
(1023112, '2017-05-02 11:26:26', 'B 2089 RFP', 'Jl Raya Cibeber km 02, Pasirsembung', 'Hanjara Adhyatma'),
(1023113, '2017-05-01 10:26:26', 'D 6969 AKP', 'Lt. 2 Asda II Setda Kab. Kuningan', 'Candra Restu'),
(1023114, '2017-05-01 10:26:26', 'D6137KT', 'Jl. Urip Sumoharjo', 'Admin'),
(1023115, '2017-05-01 10:26:26', 'E 571 PY', 'Jl. Candi Boko 1, Beran, Tridadi, Sleman', 'Claudia Cahya Primadani'),
(1023116, '2017-05-01 10:26:26', 'L 1997 YZ', 'Jl. Imam Bonjol No. 176 Denpasar', 'Ikhwan Faruq');

-- --------------------------------------------------------

--
-- Table structure for table `logistik`
--

CREATE TABLE `logistik` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(250) NOT NULL,
  `jumlah_stock` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logistik`
--

INSERT INTO `logistik` (`id_barang`, `nama_barang`, `jumlah_stock`) VALUES
(1, 'Pakaian', 25),
(2, 'Selimut', 50),
(3, 'Obat Obatan', 50),
(4, 'Makanan ', 70),
(5, 'Minuman', 100),
(6, 'Selimut', 100),
(7, 'Perlengkapan bayi', 100),
(8, 'Tempat Tidur', 100);

-- --------------------------------------------------------

--
-- Table structure for table `relawan`
--

CREATE TABLE `relawan` (
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `nama` varchar(250) NOT NULL,
  `kontak` varchar(15) NOT NULL,
  `level` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `relawan`
--

INSERT INTO `relawan` (`username`, `password`, `nama`, `kontak`, `level`) VALUES
('admin', 'admin', 'admin', '0811', 1),
('angguncs', '12345', 'Anggun Cipta Sasmi', '0857246562', 1),
('candraRestu', 'candraRestu', 'Candra Restu ', '0896969696', 1),
('HanjaraAdhyatma', 'HanjaraAdhyatma', 'Hanjara Adhyatma', '087087685', 1),
('IkhwanFaruq', 'IkhwanFaruq', 'Ikhwan Faruq', '0889767965', 1),
('OkiMarzuki', 'OkiMarzuki', 'Oki Marzuki', '09898989', 1),
('primakashi', '112355', 'claudia cahya primadani', '081140189502', 1),
('user', '12345', 'user', '0867397474747', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kendaraan`
--
ALTER TABLE `kendaraan`
  ADD PRIMARY KEY (`id_kenda`),
  ADD KEY `pengemudi` (`pengemudi`);

--
-- Indexes for table `kiriman`
--
ALTER TABLE `kiriman`
  ADD PRIMARY KEY (`id_kiriman`);

--
-- Indexes for table `logistik`
--
ALTER TABLE `logistik`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `relawan`
--
ALTER TABLE `relawan`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kiriman`
--
ALTER TABLE `kiriman`
  MODIFY `id_kiriman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1023117;
--
-- AUTO_INCREMENT for table `logistik`
--
ALTER TABLE `logistik`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
