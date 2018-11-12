-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2017 at 04:41 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
('ketoprak', 95, 'ketoprak.jpg', 109, '', '0'),
('ketoprak', 96, 'ketoprak.jpg', 0, '', '0'),
('asdsasa', 98, 'http://192.168.20.35/db_makanan/uploads/ketoprak.jpg', 54, '', '0'),
('ktp', 101, 'http://192.168.20.35/db_makanan/uploads/rendang.jpg', 50, '', '0'),
('ktp', 102, 'http://192.168.20.35/db_makanan/uploads/rendang.jpg', 50, '', '0'),
('mie ayam', 105, 'http://192.168.20.35/db_makanan/uploads/IMG-20170830-WA0001.jpg', 54, '', '0'),
('sdhfjdhfjshdj', 106, 'http://192.168.20.35/db_makanan/uploads/ketoprak.jpg', 55, '', '0'),
('asdsa', 121, 'ketoprak.jpg', 107, '', '0'),
('rendang', 122, 'ketoprak.jpg', 117, '2017_09_14_10_21_09', 'aneka ayam & bebek'),
('rendang', 123, 'rendang.jpg', 114, '2017.09.14 at 10:25:49', 'pizza & pasta'),
('dsdsd', 124, 'rendang.jpg', 114, '', 'pizza & pasta'),
('lllll', 126, 'Screenshot_2017-04-16-18-40-46.png', 114, '', 'pizza & pasta'),
('sdsd', 130, 'ketoprak.jpg', 112, '2017.10.10 at 17:14:52', '0'),
('ketoprak', 131, 'ketoprak.jpg', 114, '2017.10.11 at 11:31:19', 'bakmie'),
('adsaas', 132, 'pic2017_10_09_16_52_24.jpg', 116, '2017.10.11 at 11:33:46', ''),
('ketoprak', 133, 'ketoprak.jpg', 117, '2017.10.24 at 16:19:29', 'aneka nasi');

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
('kkkkk', 'jkjkj', 'Laki - Laki ', '818888', 110, 'kkkkk', 'e60bdb8ee95a621e87a74a5f5fb59990', 'admin'),
('kkkkk', 'kjkj', 'laki-laki', '88888866565', 111, 'kkkkkl', 'e60bdb8ee95a621e87a74a5f5fb59990', 'admin'),
('ima', 'slipi', 'laki-laki', '9898888', 112, 'imastudio1', 'e60bdb8ee95a621e87a74a5f5fb59990', 'admin'),
('lllllll', 'klklklklk', 'laki-laki', '89898989', 113, 'allllllll', '52c69e3a57331081823331c4e69d3f2e', 'admin'),
('aldlsadjl', 'jkhfkahskdh', 'laki-laki', '989898989', 114, 'username', 'e60bdb8ee95a621e87a74a5f5fb59990', 'admin'),
('data', 'data', 'laki-laki', '123654', 115, 'data', 'e10adc3949ba59abbe56e057f20f883e', 'admin'),
('yusi', 'jlin', 'laki-laki', '0812', 116, 'yus', '4297f44b13955235245b2497399d7a93', 'admin'),
('andi', 'padang', 'laki-laki', '082311445674', 117, 'andi', 'fcea920f7412b5da7be0cf42b8c93759', 'user biasa');

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
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
