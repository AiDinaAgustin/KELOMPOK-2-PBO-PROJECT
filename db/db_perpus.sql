-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 01 Feb 2023 pada 15.31
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpus`
--

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `laporan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `laporan` (
`nama` varchar(25)
,`judul` varchar(50)
,`tgl_pinjam` date
,`tgl_kembali` date
,`keterangan` enum('Telat','Tidak Telat','Hilang','')
,`denda` int(11)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `lihat_transaksi`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `lihat_transaksi` (
`id_anggota` varchar(20)
,`nama` varchar(25)
,`kode_pinjam` varchar(20)
,`judul` varchar(50)
,`tgl_pinjam` date
,`tgl_hrskembali` date
,`kode_kembali` varchar(20)
,`tgl_kembali` date
,`keterangan` enum('Telat','Tidak Telat','Hilang','')
,`denda` int(11)
,`kt` enum('Sudah kembali','Belum kembali','','')
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `recomendasi`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `recomendasi` (
`kode_buku` varchar(20)
,`judul` varchar(50)
,`penerbit` varchar(30)
,`tahun_terbit` int(4)
,`kategori` varchar(20)
,`keterangan` enum('Sudah kembali','Belum kembali','','')
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_admin`
--

CREATE TABLE `tb_admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_admin`
--

INSERT INTO `tb_admin` (`username`, `password`) VALUES
('admin', '61646D696E6E7961');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_anggota`
--

CREATE TABLE `tb_anggota` (
  `id_anggota` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `telp` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `status` enum('Pinjam','TidakPinjam','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_anggota`
--

INSERT INTO `tb_anggota` (`id_anggota`, `nama`, `password`, `jk`, `telp`, `alamat`, `status`) VALUES
('A1', 'Dina', '123A', 'P', '08', 'rcb', 'Pinjam'),
('A2', 'Restu', '123', 'L', '08', 'cisande', 'Pinjam'),
('A3', 'Tegar', '123', 'L', '123', 'cicurug', 'TidakPinjam'),
('A5', 'Yulva', '123', 'P', '0856327', 'Parung', 'Pinjam'),
('OP0032', 'Tutu', '123', 'L', '085659573835', 'Gerbi', 'TidakPinjam');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_buku`
--

CREATE TABLE `tb_buku` (
  `kode_buku` varchar(20) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `penerbit` varchar(30) NOT NULL,
  `tahun_terbit` int(4) NOT NULL,
  `kategori` varchar(20) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_buku`
--

INSERT INTO `tb_buku` (`kode_buku`, `judul`, `penerbit`, `tahun_terbit`, `kategori`, `jumlah`) VALUES
('BK001', 'Dragon', 'Mobel', 2010, 'Perang', 113),
('BK002', 'saku', 'saya', 8900, '123', 130),
('BK003', 'Dia', 'Gramedia', 2011, 'Remaja', 72),
('BK004', 'mengenal huruf', 'hurf', 2005, 'Pendidikan', 17),
('BK005', 'merdeka', 'indonesiamerdeka', 2000, 'pendidikan', 10),
('BK006', 'lupus', 'gram', 2010, 'komedi', 25),
('BK007', 'dilan', 'pidi baiq', 2015, 'remaja', 120),
('BK008', 'Dialah mentari', 'gaya', 2014, 'islami', 27),
('BK009', 'marmut merah jambu', 'bukune', 2012, 'komik', 38),
('BK010', 'suara dari dilan', 'wahh', 2011, 'remaja', 49),
('BK020', 'judul', 'siapa', 2020, 'Gaje', 12),
('BK023', 'aku', 'dina', 2023, 'apa', 12);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kembali`
--

CREATE TABLE `tb_kembali` (
  `kode_kembali` varchar(20) NOT NULL,
  `kode_pinjam` varchar(20) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `tgl_kembali` date NOT NULL,
  `denda` int(11) NOT NULL,
  `keterangan` enum('Telat','Tidak Telat','Hilang','') NOT NULL,
  `jumlah` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_kembali`
--

INSERT INTO `tb_kembali` (`kode_kembali`, `kode_pinjam`, `id_anggota`, `kode_buku`, `tgl_kembali`, `denda`, `keterangan`, `jumlah`) VALUES
('K02', 'P3', 'A3', 'BK001', '2023-01-30', 0, 'Tidak Telat', 1),
('K05', 'P5', 'A5', 'BK002', '2023-01-31', 0, 'Tidak Telat', 1),
('K1', 'P1', 'A1', 'BK001', '2023-01-31', 20000, 'Hilang', 0),
('K2', 'P2', 'A2', 'BK001', '2023-01-29', 0, 'Tidak Telat', 1),
('K20', 'P10', 'A5', 'BK020', '2023-01-31', 0, 'Tidak Telat', 1),
('K6', 'P3', 'A3', 'BK001', '2023-01-31', 20000, 'Hilang', 0),
('K8', 'P4', 'A3', 'BK003', '2023-01-31', 20000, 'Hilang', 0);

--
-- Trigger `tb_kembali`
--
DELIMITER $$
CREATE TRIGGER `kembali_buku` AFTER INSERT ON `tb_kembali` FOR EACH ROW BEGIN
UPDATE tb_buku SET jumlah = jumlah + new.jumlah
WHERE kode_buku = new.kode_buku;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_petugas`
--

CREATE TABLE `tb_petugas` (
  `id_operator` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `telp` varchar(25) NOT NULL,
  `alamat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_petugas`
--

INSERT INTO `tb_petugas` (`id_operator`, `nama`, `password`, `jk`, `telp`, `alamat`) VALUES
('OP020', 'Tegar', '123', 'L', '08130004', 'Cicurug'),
('OP021', 'Restu', '123', 'L', '098712435', 'Cikukulu'),
('OP022', 'Yulva', '123', 'P', '01238378', 'Parungkuda'),
('OP023', 'Willy', '123', 'L', '0263754', 'Cigunung'),
('P2', 'Dina', '123', 'P', '08', 'rcb');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pinjam`
--

CREATE TABLE `tb_pinjam` (
  `kode_pinjam` varchar(20) NOT NULL,
  `id_anggota` varchar(20) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `kode_buku` varchar(20) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_hrskembali` date NOT NULL,
  `jumlah` int(1) NOT NULL,
  `kt` enum('Sudah kembali','Belum kembali','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_pinjam`
--

INSERT INTO `tb_pinjam` (`kode_pinjam`, `id_anggota`, `nama`, `kode_buku`, `judul`, `tgl_pinjam`, `tgl_hrskembali`, `jumlah`, `kt`) VALUES
('P1', 'A1', 'Dina', 'BK001', 'Dragon', '2023-01-20', '2023-01-27', 1, 'Sudah kembali'),
('P10', 'A5', 'Yulva', 'BK020', 'judul', '2023-01-31', '2023-02-07', 1, 'Sudah kembali'),
('P2', 'A2', 'Restu', 'BK001', 'di', '2023-01-21', '2023-02-04', 1, 'Sudah kembali'),
('P3', 'A3', 'Tegar', 'BK001', 'Dragon', '2023-01-30', '2023-02-06', 1, 'Sudah kembali'),
('P4', 'A3', 'Tegar', 'BK003', 'Dia', '2023-01-31', '2023-02-07', 1, 'Sudah kembali'),
('P5', 'A5', 'Yulva', 'BK002', 'Saku', '2023-01-31', '2023-02-07', 1, 'Sudah kembali'),
('P7', 'A2', 'Restu', 'BK004', 'mengenal', '2023-01-31', '2023-02-14', 1, 'Belum kembali'),
('P8', 'A1', 'Dina', 'BK001', 'Dragon', '2023-01-31', '2023-02-07', 1, 'Belum kembali');

--
-- Trigger `tb_pinjam`
--
DELIMITER $$
CREATE TRIGGER `pinjam_buku` AFTER INSERT ON `tb_pinjam` FOR EACH ROW BEGIN
update tb_buku SET jumlah = jumlah - new.jumlah
WHERE kode_buku = new.kode_buku;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur untuk view `laporan`
--
DROP TABLE IF EXISTS `laporan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan`  AS SELECT `tb_pinjam`.`nama` AS `nama`, `tb_pinjam`.`judul` AS `judul`, `tb_pinjam`.`tgl_pinjam` AS `tgl_pinjam`, `tb_kembali`.`tgl_kembali` AS `tgl_kembali`, `tb_kembali`.`keterangan` AS `keterangan`, `tb_kembali`.`denda` AS `denda` FROM (`tb_pinjam` join `tb_kembali` on(`tb_pinjam`.`kode_pinjam` = `tb_kembali`.`kode_pinjam`))  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `lihat_transaksi`
--
DROP TABLE IF EXISTS `lihat_transaksi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `lihat_transaksi`  AS SELECT `tb_pinjam`.`id_anggota` AS `id_anggota`, `tb_pinjam`.`nama` AS `nama`, `tb_pinjam`.`kode_pinjam` AS `kode_pinjam`, `tb_pinjam`.`judul` AS `judul`, `tb_pinjam`.`tgl_pinjam` AS `tgl_pinjam`, `tb_pinjam`.`tgl_hrskembali` AS `tgl_hrskembali`, `tb_kembali`.`kode_kembali` AS `kode_kembali`, `tb_kembali`.`tgl_kembali` AS `tgl_kembali`, `tb_kembali`.`keterangan` AS `keterangan`, `tb_kembali`.`denda` AS `denda`, `tb_pinjam`.`kt` AS `kt` FROM (`tb_pinjam` left join `tb_kembali` on(`tb_pinjam`.`kode_pinjam` = `tb_kembali`.`kode_pinjam`))  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `recomendasi`
--
DROP TABLE IF EXISTS `recomendasi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `recomendasi`  AS SELECT `tb_pinjam`.`kode_buku` AS `kode_buku`, `tb_pinjam`.`judul` AS `judul`, `tb_buku`.`penerbit` AS `penerbit`, `tb_buku`.`tahun_terbit` AS `tahun_terbit`, `tb_buku`.`kategori` AS `kategori`, `tb_pinjam`.`kt` AS `keterangan` FROM (`tb_pinjam` join `tb_buku` on(`tb_pinjam`.`kode_buku` = `tb_buku`.`kode_buku`))  ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_admin`
--
ALTER TABLE `tb_admin`
  ADD PRIMARY KEY (`username`);

--
-- Indeks untuk tabel `tb_anggota`
--
ALTER TABLE `tb_anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indeks untuk tabel `tb_buku`
--
ALTER TABLE `tb_buku`
  ADD PRIMARY KEY (`kode_buku`);

--
-- Indeks untuk tabel `tb_kembali`
--
ALTER TABLE `tb_kembali`
  ADD PRIMARY KEY (`kode_kembali`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `id_anggota` (`id_anggota`),
  ADD KEY `id_anggota_2` (`id_anggota`),
  ADD KEY `kode_buku_2` (`kode_buku`),
  ADD KEY `kode_pinjam` (`kode_pinjam`);

--
-- Indeks untuk tabel `tb_petugas`
--
ALTER TABLE `tb_petugas`
  ADD PRIMARY KEY (`id_operator`);

--
-- Indeks untuk tabel `tb_pinjam`
--
ALTER TABLE `tb_pinjam`
  ADD PRIMARY KEY (`kode_pinjam`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `id_anggota` (`id_anggota`),
  ADD KEY `kode_buku_2` (`kode_buku`),
  ADD KEY `id_anggota_2` (`id_anggota`),
  ADD KEY `kode_buku_3` (`kode_buku`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_kembali`
--
ALTER TABLE `tb_kembali`
  ADD CONSTRAINT `tb_kembali_ibfk_2` FOREIGN KEY (`kode_buku`) REFERENCES `tb_buku` (`kode_buku`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_kembali_ibfk_3` FOREIGN KEY (`kode_pinjam`) REFERENCES `tb_pinjam` (`kode_pinjam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_kembali_ibfk_4` FOREIGN KEY (`id_anggota`) REFERENCES `tb_anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `tb_pinjam`
--
ALTER TABLE `tb_pinjam`
  ADD CONSTRAINT `tb_pinjam_ibfk_1` FOREIGN KEY (`kode_buku`) REFERENCES `tb_buku` (`kode_buku`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_pinjam_ibfk_2` FOREIGN KEY (`id_anggota`) REFERENCES `tb_anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
