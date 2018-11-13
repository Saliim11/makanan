-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 13, 2018 at 03:06 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_makanan`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblkategorimakanan`
--

CREATE TABLE `tblkategorimakanan` (
  `id_kategori` varchar(30) NOT NULL,
  `nama_kategori` varchar(38) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblkategorimakanan`
--

INSERT INTO `tblkategorimakanan` (`id_kategori`, `nama_kategori`) VALUES
('1', 'martabak'),
('2', 'aneka nasi'),
('3', 'aneka ayam & bebek'),
('4', 'snack & jajanan'),
('5', 'pizza & pasta'),
('6', 'bakmie');

-- --------------------------------------------------------

--
-- Table structure for table `tblmakanan`
--

CREATE TABLE `tblmakanan` (
  `makanan` varchar(30) NOT NULL,
  `id_makanan` int(20) NOT NULL,
  `foto_makanan` varchar(300) NOT NULL,
  `id_user` int(11) NOT NULL,
  `insert_time` varchar(100) NOT NULL,
  `id_kategori` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblmakanan`
--

INSERT INTO `tblmakanan` (`makanan`, `id_makanan`, `foto_makanan`, `id_user`, `insert_time`, `id_kategori`) VALUES
('ketoprak', 95, 'ketoprak.jpg', 109, '', '3'),
('ketoprak', 96, 'ketoprak.jpg', 0, '', '3'),
('asdsasa', 98, 'http://192.168.20.35/db_makanan/uploads/ketoprak.jpg', 54, '', '4'),
('ktp', 101, 'http://192.168.20.35/db_makanan/uploads/rendang.jpg', 50, '', '1'),
('ktp', 102, 'http://192.168.20.35/db_makanan/uploads/rendang.jpg', 50, '', '2'),
('mie ayam', 105, 'http://192.168.20.35/db_makanan/uploads/IMG-20170830-WA0001.jpg', 54, '', '6'),
('sdhfjdhfjshdj', 106, 'http://192.168.20.35/db_makanan/uploads/ketoprak.jpg', 55, '', '5'),
('asdsa', 121, 'ketoprak.jpg', 107, '', '2'),
('rendang', 122, 'ketoprak.jpg', 117, '2017_09_14_10_21_09', '3'),
('rendang', 123, 'rendang.jpg', 114, '2017.09.14 at 10:25:49', '5'),
('dsdsd', 124, 'rendang.jpg', 114, '', '5'),
('lllll', 126, 'Screenshot_2017-04-16-18-40-46.png', 114, '', '5'),
('sdsd', 130, 'ketoprak.jpg', 114, '2017.10.10 at 17:14:52', '1'),
('ketoprak', 131, 'ketoprak.jpg', 114, '2017.10.11 at 11:31:19', '6'),
('adsaas', 132, 'pic2017_10_09_16_52_24.jpg', 116, '2017.10.11 at 11:33:46', '6'),
('ketoprak', 133, 'ketoprak.jpg', 117, '2017.10.24 at 16:19:29', '2');

-- --------------------------------------------------------

--
-- Table structure for table `tbluser`
--

CREATE TABLE `tbluser` (
  `nama` varchar(30) NOT NULL,
  `alamat` varchar(30) NOT NULL,
  `jenkel` varchar(30) NOT NULL,
  `no_telp` varchar(12) NOT NULL,
  `id_user` int(11) NOT NULL,
  `username` varchar(130) NOT NULL,
  `password` varchar(120) NOT NULL,
  `level` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbluser`
--

INSERT INTO `tbluser` (`nama`, `alamat`, `jenkel`, `no_telp`, `id_user`, `username`, `password`, `level`) VALUES
('asdsad', 'sfdsf', 'Laki - Laki ', '023232', 107, 'sdsdsd', '96e79218965eb72c92a549dd5a330112', 'admin'),
('andi', 'padang', 'sds', '8222', 108, 'sandi', 'sandi11', 'admin'),
('andi', 'padang', 'laki-laki', '082311445674', 109, 'imastudio', 'e10adc3949ba59abbe56e057f20f883e', 'admin'),
('ima', 'slipi', 'laki-laki', '9898888', 112, 'imastudio1', 'e60bdb8ee95a621e87a74a5f5fb59990', 'admin'),
('Hasbi', 'Lombok', '???', '***********', 114, 'pace', '576031f7b5341875417575767997d17f', 'admin'),
('data', 'data', 'laki-laki', '123654', 115, 'data', 'e10adc3949ba59abbe56e057f20f883e', 'admin'),
('yusi', 'jlin', 'laki-laki', '0812', 116, 'yus', '4297f44b13955235245b2497399d7a93', 'admin'),
('andi', 'padang', 'laki-laki', '082311445674', 117, 'andi', 'fcea920f7412b5da7be0cf42b8c93759', 'user biasa'),
('Saliim', 'Jl.Dayeuh', 'Laki', '0821******94', 131, 'soehim', '81dc9bdb52d04dc20036dbd8313ed055', 'user biasa'),
('Qalbun', 'jl. Gotong Royong', 'Laki', '0821********', 132, 'qalbun', '962012d09b8170d912f0669f6d7d9d07', 'user biasa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblkategorimakanan`
--
ALTER TABLE `tblkategorimakanan`
  ADD PRIMARY KEY (`id_kategori`,`nama_kategori`);

--
-- Indexes for table `tblmakanan`
--
ALTER TABLE `tblmakanan`
  ADD PRIMARY KEY (`id_makanan`,`id_kategori`);

--
-- Indexes for table `tbluser`
--
ALTER TABLE `tbluser`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblmakanan`
--
ALTER TABLE `tblmakanan`
  MODIFY `id_makanan` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=134;
--
-- AUTO_INCREMENT for table `tbluser`
--
ALTER TABLE `tbluser`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=133;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
