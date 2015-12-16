-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 16 Gru 2015, 13:59
-- Wersja serwera: 10.1.9-MariaDB
-- Wersja PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `edziekanat`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `administrator`
--

CREATE TABLE `administrator` (
  `id` int(10) UNSIGNED NOT NULL,
  `imie` varchar(255) NOT NULL,
  `nazwisko` varchar(255) NOT NULL,
  `adres` varchar(1024) NOT NULL,
  `Uczelnia_idUczelni` int(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `administrator`
--

INSERT INTO `administrator` (`id`, `imie`, `nazwisko`, `adres`, `Uczelnia_idUczelni`) VALUES
(1, 'Zdzisław', 'Administracyjny', 'Poznań ul. Długa 35', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grupastudencka`
--

CREATE TABLE `grupastudencka` (
  `idGrupy` varchar(8) NOT NULL,
  `rok` int(1) UNSIGNED NOT NULL,
  `Kierunek_idKierunku` int(8) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `grupastudencka`
--

INSERT INTO `grupastudencka` (`idGrupy`, `rok`, `Kierunek_idKierunku`) VALUES
('32i', 3, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grupastudencka_student`
--

CREATE TABLE `grupastudencka_student` (
  `GrupaStudencka_idGrupy` varchar(8) NOT NULL,
  `Student_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `grupastudencka_student`
--

INSERT INTO `grupastudencka_student` (`GrupaStudencka_idGrupy`, `Student_id`) VALUES
('32i', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `indeks`
--

CREATE TABLE `indeks` (
  `idIndeksu` int(10) NOT NULL,
  `dataWydania` date NOT NULL,
  `Student_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `indeks`
--

INSERT INTO `indeks` (`idIndeksu`, `dataWydania`, `Student_id`) VALUES
(1, '2015-12-08', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kierunek`
--

CREATE TABLE `kierunek` (
  `idKierunku` int(8) UNSIGNED NOT NULL,
  `nazwa` varchar(255) NOT NULL,
  `stacjonarne` binary(1) NOT NULL,
  `Wydzial_idWydzialu` int(5) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `kierunek`
--

INSERT INTO `kierunek` (`idKierunku`, `nazwa`, `stacjonarne`, `Wydzial_idWydzialu`) VALUES
(1, 'Informatyka', 0x01, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `komunikat`
--

CREATE TABLE `komunikat` (
  `idKomunikatu` int(10) NOT NULL,
  `tytul` varchar(255) NOT NULL,
  `tresc` text NOT NULL,
  `dataNadania` date NOT NULL,
  `Student_id` int(10) UNSIGNED DEFAULT NULL,
  `Pracowniknaukowodydaktyczny_id` int(10) UNSIGNED DEFAULT NULL,
  `Administrator_id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `komunikat`
--

INSERT INTO `komunikat` (`idKomunikatu`, `tytul`, `tresc`, `dataNadania`, `Student_id`, `Pracowniknaukowodydaktyczny_id`, `Administrator_id`) VALUES
(1, 'Poprawa kolokwium', 'Kiedy poprawa?', '2015-12-15', 1, 1, NULL);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `materialydydaktyczne`
--

CREATE TABLE `materialydydaktyczne` (
  `idMaterialu` int(10) UNSIGNED NOT NULL,
  `opis` text NOT NULL,
  `Przedmiot_idPrzedmiotu` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `materialydydaktyczne`
--

INSERT INTO `materialydydaktyczne` (`idMaterialu`, `opis`, `Przedmiot_idPrzedmiotu`) VALUES
(1, 'Bardzo wazne materialy', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `naleznosc`
--

CREATE TABLE `naleznosc` (
  `idNaleznosci` int(10) UNSIGNED NOT NULL,
  `opis` text NOT NULL,
  `kwota` float NOT NULL,
  `dataWystawienia` date NOT NULL,
  `dataWplaty` date DEFAULT NULL,
  `Student_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `naleznosc`
--

INSERT INTO `naleznosc` (`idNaleznosci`, `opis`, `kwota`, `dataWystawienia`, `dataWplaty`, `Student_id`) VALUES
(1, 'Za legitymacje', 20.88, '2015-12-14', NULL, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ocenaczastkowa`
--

CREATE TABLE `ocenaczastkowa` (
  `idOceny` int(12) UNSIGNED NOT NULL,
  `Ocena` float NOT NULL,
  `dataWystawienia` date NOT NULL,
  `semestr` int(2) NOT NULL,
  `Przedmiot_idPrzedmiotu` int(10) UNSIGNED NOT NULL,
  `Indeks_idIndeksu` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `ocenaczastkowa`
--

INSERT INTO `ocenaczastkowa` (`idOceny`, `Ocena`, `dataWystawienia`, `semestr`, `Przedmiot_idPrzedmiotu`, `Indeks_idIndeksu`) VALUES
(1, 2.5, '2015-12-14', 5, 1, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `pracowniknaukowodydaktyczny`
--

CREATE TABLE `pracowniknaukowodydaktyczny` (
  `id` int(10) UNSIGNED NOT NULL,
  `nazwisko` varchar(255) NOT NULL,
  `adres` varchar(1024) NOT NULL,
  `stopienNaukowy` varchar(255) NOT NULL,
  `stanowisko` varchar(255) NOT NULL,
  `haslo` varchar(255) NOT NULL,
  `Uczelnia_idUczelni` int(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `pracowniknaukowodydaktyczny`
--

INSERT INTO `pracowniknaukowodydaktyczny` (`id`, `nazwisko`, `adres`, `stopienNaukowy`, `stanowisko`, `haslo`, `Uczelnia_idUczelni`) VALUES
(1, 'Nauczycielski', 'Katowice ul. Główna 6', 'magister', 'wykładowca', 'nauczyciel', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `przedmiot`
--

CREATE TABLE `przedmiot` (
  `idPrzedmiotu` int(10) UNSIGNED NOT NULL,
  `nazwa` varchar(255) NOT NULL,
  `semestr` int(2) NOT NULL,
  `ects` int(2) NOT NULL,
  `Pracowniknaukowodydaktyczny_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `przedmiot`
--

INSERT INTO `przedmiot` (`idPrzedmiotu`, `nazwa`, `semestr`, `ects`, `Pracowniknaukowodydaktyczny_id`) VALUES
(1, 'Technologie obiektowe', 5, 5, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `salazajeciowa`
--

CREATE TABLE `salazajeciowa` (
  `numerSali` int(5) UNSIGNED NOT NULL,
  `pojemnosc` int(4) NOT NULL,
  `typ` varchar(255) NOT NULL,
  `Wydzial_idWydzialu` int(5) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `salazajeciowa`
--

INSERT INTO `salazajeciowa` (`numerSali`, `pojemnosc`, `typ`, `Wydzial_idWydzialu`) VALUES
(1, 60, 'sala komputerowa', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `student`
--

CREATE TABLE `student` (
  `id` int(10) UNSIGNED NOT NULL,
  `imie` varchar(255) NOT NULL,
  `nazwisko` varchar(255) NOT NULL,
  `stopienNaukowy` varchar(255) DEFAULT NULL,
  `adres` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `student`
--

INSERT INTO `student` (`id`, `imie`, `nazwisko`, `stopienNaukowy`, `adres`) VALUES
(1, 'Adrian', 'Studencki', NULL, 'Chrzanów ul. Piłsudskiego 23');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `stypendium`
--

CREATE TABLE `stypendium` (
  `idStypendium` int(10) UNSIGNED NOT NULL,
  `nazwa` varchar(255) NOT NULL,
  `wysokosc` float NOT NULL,
  `dataPrzyznania` date NOT NULL,
  `dataZakonczenia` date NOT NULL,
  `Student_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `stypendium`
--

INSERT INTO `stypendium` (`idStypendium`, `nazwa`, `wysokosc`, `dataPrzyznania`, `dataZakonczenia`, `Student_id`) VALUES
(1, 'Naukowe', 32.88, '2015-12-14', '2015-12-31', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uczelnia`
--

CREATE TABLE `uczelnia` (
  `idUczelni` int(3) UNSIGNED NOT NULL,
  `nazwa` varchar(255) NOT NULL,
  `adres` varchar(1024) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `uczelnia`
--

INSERT INTO `uczelnia` (`idUczelni`, `nazwa`, `adres`) VALUES
(1, 'Politechnika Krakowska', 'Kraków ul. Warszawska 24');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `administrator_id` int(10) UNSIGNED DEFAULT NULL,
  `student_id` int(10) UNSIGNED DEFAULT NULL,
  `pracowniknaukowodydaktyczny_id` int(10) UNSIGNED DEFAULT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`username`, `password`, `administrator_id`, `student_id`, `pracowniknaukowodydaktyczny_id`, `enabled`) VALUES
('admin', 'admin', 1, NULL, NULL, 1),
('student', 'student', NULL, 1, NULL, 1),
('wykladowca', 'wykladowca', NULL, NULL, 1, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user_roles`
--

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(4, 'admin', 'administrator'),
(2, 'wykladowca', 'lecturer'),
(1, 'student', 'student');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wniosek`
--

CREATE TABLE `wniosek` (
  `idWniosku` int(10) UNSIGNED NOT NULL,
  `tytul` varchar(255) NOT NULL,
  `opis` text NOT NULL,
  `dataNadania` date NOT NULL,
  `statusPrzyjecia` binary(1) NOT NULL,
  `Student_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `wniosek`
--

INSERT INTO `wniosek` (`idWniosku`, `tytul`, `opis`, `dataNadania`, `statusPrzyjecia`, `Student_id`) VALUES
(1, 'O stypendium', 'Chcę stypendium', '2015-12-15', 0x00, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wpis`
--

CREATE TABLE `wpis` (
  `idWpisu` int(10) UNSIGNED NOT NULL,
  `ocena` float NOT NULL,
  `data` date NOT NULL,
  `semestr` int(2) NOT NULL,
  `Przedmiot_idPrzedmiotu` int(10) UNSIGNED NOT NULL,
  `Indeks_idIndeksu` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `wpis`
--

INSERT INTO `wpis` (`idWpisu`, `ocena`, `data`, `semestr`, `Przedmiot_idPrzedmiotu`, `Indeks_idIndeksu`) VALUES
(1, 3.5, '2015-12-14', 5, 1, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wydzial`
--

CREATE TABLE `wydzial` (
  `idWydzialu` int(5) UNSIGNED NOT NULL,
  `nazwa` varchar(255) NOT NULL,
  `adres` varchar(1024) NOT NULL,
  `Uczelnia_idUczelni` int(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `wydzial`
--

INSERT INTO `wydzial` (`idWydzialu`, `nazwa`, `adres`, `Uczelnia_idUczelni`) VALUES
(1, 'Wydział Inżynierii Elektrycznej i Komputerowej', 'Kraków ul. Warszawska 24', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wydzial_pracowniknaukowodydaktyczny`
--

CREATE TABLE `wydzial_pracowniknaukowodydaktyczny` (
  `Wydzial_idWydzialu` int(5) UNSIGNED NOT NULL,
  `Pracowniknaukowodydaktyczny_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `wydzial_pracowniknaukowodydaktyczny`
--

INSERT INTO `wydzial_pracowniknaukowodydaktyczny` (`Wydzial_idWydzialu`, `Pracowniknaukowodydaktyczny_id`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `zaplanowanezajecia`
--

CREATE TABLE `zaplanowanezajecia` (
  `idZajec` int(10) UNSIGNED NOT NULL,
  `data` date NOT NULL,
  `Salazajeciowa_numerSali` int(5) UNSIGNED NOT NULL,
  `Przedmiot_idPrzedmiotu` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `zaplanowanezajecia`
--

INSERT INTO `zaplanowanezajecia` (`idZajec`, `data`, `Salazajeciowa_numerSali`, `Przedmiot_idPrzedmiotu`) VALUES
(1, '2015-12-15', 1, 1);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Uczelnia_idUczelni_fk` (`Uczelnia_idUczelni`);

--
-- Indexes for table `grupastudencka`
--
ALTER TABLE `grupastudencka`
  ADD PRIMARY KEY (`idGrupy`),
  ADD KEY `Kierunek_idKierunku_fk` (`Kierunek_idKierunku`);

--
-- Indexes for table `grupastudencka_student`
--
ALTER TABLE `grupastudencka_student`
  ADD PRIMARY KEY (`GrupaStudencka_idGrupy`,`Student_id`),
  ADD KEY `Student_id_fk8` (`Student_id`);

--
-- Indexes for table `indeks`
--
ALTER TABLE `indeks`
  ADD PRIMARY KEY (`idIndeksu`),
  ADD KEY `Student_id_fk4` (`Student_id`);

--
-- Indexes for table `kierunek`
--
ALTER TABLE `kierunek`
  ADD PRIMARY KEY (`idKierunku`),
  ADD UNIQUE KEY `nazwa` (`nazwa`),
  ADD KEY `Wydzial_idWydzialu_fk` (`Wydzial_idWydzialu`);

--
-- Indexes for table `komunikat`
--
ALTER TABLE `komunikat`
  ADD PRIMARY KEY (`idKomunikatu`),
  ADD KEY `Student_id_fk6` (`Student_id`),
  ADD KEY `Pracowniknaukowodydaktyczny_id_fk3` (`Pracowniknaukowodydaktyczny_id`),
  ADD KEY `Administrator_idfk5` (`Administrator_id`);

--
-- Indexes for table `materialydydaktyczne`
--
ALTER TABLE `materialydydaktyczne`
  ADD PRIMARY KEY (`idMaterialu`),
  ADD KEY `Przedmiot_idPrzedmiotu_fk3` (`Przedmiot_idPrzedmiotu`);

--
-- Indexes for table `naleznosc`
--
ALTER TABLE `naleznosc`
  ADD PRIMARY KEY (`idNaleznosci`),
  ADD KEY `Student_id_fk3` (`Student_id`);

--
-- Indexes for table `ocenaczastkowa`
--
ALTER TABLE `ocenaczastkowa`
  ADD PRIMARY KEY (`idOceny`),
  ADD KEY `Przedmiot_idPrzedmiotu_fk2` (`Przedmiot_idPrzedmiotu`),
  ADD KEY `Indeks_idIndeksu_fk2` (`Indeks_idIndeksu`);

--
-- Indexes for table `pracowniknaukowodydaktyczny`
--
ALTER TABLE `pracowniknaukowodydaktyczny`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Uczelnia_idUczelni_fk3` (`Uczelnia_idUczelni`);

--
-- Indexes for table `przedmiot`
--
ALTER TABLE `przedmiot`
  ADD PRIMARY KEY (`idPrzedmiotu`),
  ADD KEY `Pracowniknaukowodydaktyczny_id_fk2` (`Pracowniknaukowodydaktyczny_id`);

--
-- Indexes for table `salazajeciowa`
--
ALTER TABLE `salazajeciowa`
  ADD PRIMARY KEY (`numerSali`),
  ADD KEY `Wydzial_idWydzialu_fk_3` (`Wydzial_idWydzialu`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stypendium`
--
ALTER TABLE `stypendium`
  ADD PRIMARY KEY (`idStypendium`),
  ADD KEY `Student_id_fk` (`Student_id`);

--
-- Indexes for table `uczelnia`
--
ALTER TABLE `uczelnia`
  ADD PRIMARY KEY (`idUczelni`),
  ADD UNIQUE KEY `nazwa` (`nazwa`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `administrator_id_fk_role` (`administrator_id`),
  ADD UNIQUE KEY `student_id_fk_role` (`student_id`),
  ADD UNIQUE KEY `wykladowca_id_fk_role` (`pracowniknaukowodydaktyczny_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_role_id`),
  ADD UNIQUE KEY `uni_username_role` (`role`,`username`),
  ADD KEY `fk_username_idx` (`username`);

--
-- Indexes for table `wniosek`
--
ALTER TABLE `wniosek`
  ADD PRIMARY KEY (`idWniosku`),
  ADD KEY `Student_id_fk2` (`Student_id`);

--
-- Indexes for table `wpis`
--
ALTER TABLE `wpis`
  ADD PRIMARY KEY (`idWpisu`),
  ADD KEY `Przedmiot_idPrzedmiotu_fk` (`Przedmiot_idPrzedmiotu`),
  ADD KEY `Indeks_idIndeksu_fk` (`Indeks_idIndeksu`);

--
-- Indexes for table `wydzial`
--
ALTER TABLE `wydzial`
  ADD PRIMARY KEY (`idWydzialu`),
  ADD KEY `Uczelnia_idUczelni_fk2` (`Uczelnia_idUczelni`);

--
-- Indexes for table `wydzial_pracowniknaukowodydaktyczny`
--
ALTER TABLE `wydzial_pracowniknaukowodydaktyczny`
  ADD PRIMARY KEY (`Wydzial_idWydzialu`,`Pracowniknaukowodydaktyczny_id`),
  ADD KEY `Pracowniknaukowodydaktyczny_id_fk` (`Pracowniknaukowodydaktyczny_id`);

--
-- Indexes for table `zaplanowanezajecia`
--
ALTER TABLE `zaplanowanezajecia`
  ADD PRIMARY KEY (`idZajec`),
  ADD KEY `Salazajeciowa_numerSali_fk` (`Salazajeciowa_numerSali`),
  ADD KEY `Przedmiot_idPrzedmiotu_fk` (`Przedmiot_idPrzedmiotu`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `user_role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `Uczelnia_idUczelni_fk` FOREIGN KEY (`Uczelnia_idUczelni`) REFERENCES `uczelnia` (`idUczelni`);

--
-- Ograniczenia dla tabeli `grupastudencka`
--
ALTER TABLE `grupastudencka`
  ADD CONSTRAINT `Kierunek_idKierunku_fk` FOREIGN KEY (`Kierunek_idKierunku`) REFERENCES `kierunek` (`idKierunku`);

--
-- Ograniczenia dla tabeli `grupastudencka_student`
--
ALTER TABLE `grupastudencka_student`
  ADD CONSTRAINT `GrupaStudencka_IdGrupy_fk10` FOREIGN KEY (`GrupaStudencka_idGrupy`) REFERENCES `grupastudencka` (`idGrupy`),
  ADD CONSTRAINT `Student_id_fk10` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`);

--
-- Ograniczenia dla tabeli `indeks`
--
ALTER TABLE `indeks`
  ADD CONSTRAINT `Student_id_fk4` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`);

--
-- Ograniczenia dla tabeli `kierunek`
--
ALTER TABLE `kierunek`
  ADD CONSTRAINT `Wydzial_idWydzialu_fk` FOREIGN KEY (`Wydzial_idWydzialu`) REFERENCES `wydzial` (`idWydzialu`);

--
-- Ograniczenia dla tabeli `komunikat`
--
ALTER TABLE `komunikat`
  ADD CONSTRAINT `Administrator_id_fk5` FOREIGN KEY (`Administrator_id`) REFERENCES `administrator` (`id`),
  ADD CONSTRAINT `Pracowniknaukowodydaktyczny_id_fk3` FOREIGN KEY (`Pracowniknaukowodydaktyczny_id`) REFERENCES `pracowniknaukowodydaktyczny` (`id`),
  ADD CONSTRAINT `Student_id_fk6` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`);

--
-- Ograniczenia dla tabeli `materialydydaktyczne`
--
ALTER TABLE `materialydydaktyczne`
  ADD CONSTRAINT `Przedmiot_idPrzedmiotu_fk3` FOREIGN KEY (`Przedmiot_idPrzedmiotu`) REFERENCES `przedmiot` (`idPrzedmiotu`);

--
-- Ograniczenia dla tabeli `naleznosc`
--
ALTER TABLE `naleznosc`
  ADD CONSTRAINT `Student_id_fk3` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`);

--
-- Ograniczenia dla tabeli `ocenaczastkowa`
--
ALTER TABLE `ocenaczastkowa`
  ADD CONSTRAINT `Indeks_idIndeksu_fk2` FOREIGN KEY (`Indeks_idIndeksu`) REFERENCES `indeks` (`idIndeksu`),
  ADD CONSTRAINT `Przedmiot_idPrzedmiotu_fk2` FOREIGN KEY (`Przedmiot_idPrzedmiotu`) REFERENCES `przedmiot` (`idPrzedmiotu`);

--
-- Ograniczenia dla tabeli `pracowniknaukowodydaktyczny`
--
ALTER TABLE `pracowniknaukowodydaktyczny`
  ADD CONSTRAINT `Uczelnia_idUczelni_fk3` FOREIGN KEY (`Uczelnia_idUczelni`) REFERENCES `uczelnia` (`idUczelni`);

--
-- Ograniczenia dla tabeli `przedmiot`
--
ALTER TABLE `przedmiot`
  ADD CONSTRAINT `Pracowniknaukowodydaktyczny_id_fk2` FOREIGN KEY (`Pracowniknaukowodydaktyczny_id`) REFERENCES `pracowniknaukowodydaktyczny` (`id`);

--
-- Ograniczenia dla tabeli `salazajeciowa`
--
ALTER TABLE `salazajeciowa`
  ADD CONSTRAINT `Wydzial_idWydzialu_fk_3` FOREIGN KEY (`Wydzial_idWydzialu`) REFERENCES `wydzial` (`idWydzialu`);

--
-- Ograniczenia dla tabeli `stypendium`
--
ALTER TABLE `stypendium`
  ADD CONSTRAINT `Student_id_fk` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`);

--
-- Ograniczenia dla tabeli `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `administrator_id_fk_role` FOREIGN KEY (`administrator_id`) REFERENCES `administrator` (`id`),
  ADD CONSTRAINT `pracowniknaukowodydaktyczny_id_fk_role` FOREIGN KEY (`pracowniknaukowodydaktyczny_id`) REFERENCES `pracowniknaukowodydaktyczny` (`id`),
  ADD CONSTRAINT `student_id_fk_role` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

--
-- Ograniczenia dla tabeli `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Ograniczenia dla tabeli `wniosek`
--
ALTER TABLE `wniosek`
  ADD CONSTRAINT `Student_id_fk2` FOREIGN KEY (`Student_id`) REFERENCES `student` (`id`);

--
-- Ograniczenia dla tabeli `wpis`
--
ALTER TABLE `wpis`
  ADD CONSTRAINT `Indeks_idIndeksu_fk` FOREIGN KEY (`Indeks_idIndeksu`) REFERENCES `indeks` (`idIndeksu`),
  ADD CONSTRAINT `Przedmiot_idPrzedmiotu` FOREIGN KEY (`Przedmiot_idPrzedmiotu`) REFERENCES `przedmiot` (`idPrzedmiotu`);

--
-- Ograniczenia dla tabeli `wydzial`
--
ALTER TABLE `wydzial`
  ADD CONSTRAINT `Uczelnia_idUczelni_fk2` FOREIGN KEY (`Uczelnia_idUczelni`) REFERENCES `uczelnia` (`idUczelni`);

--
-- Ograniczenia dla tabeli `wydzial_pracowniknaukowodydaktyczny`
--
ALTER TABLE `wydzial_pracowniknaukowodydaktyczny`
  ADD CONSTRAINT `Pracowniknaukowodydaktyczny_id_fk` FOREIGN KEY (`Pracowniknaukowodydaktyczny_id`) REFERENCES `pracowniknaukowodydaktyczny` (`id`),
  ADD CONSTRAINT `Wydzial_idWydzialu_fk2` FOREIGN KEY (`Wydzial_idWydzialu`) REFERENCES `wydzial` (`idWydzialu`);

--
-- Ograniczenia dla tabeli `zaplanowanezajecia`
--
ALTER TABLE `zaplanowanezajecia`
  ADD CONSTRAINT `Przedmiot_idPrzedmiotu_fk` FOREIGN KEY (`Przedmiot_idPrzedmiotu`) REFERENCES `przedmiot` (`idPrzedmiotu`),
  ADD CONSTRAINT `Salazajeciowa_numerSali_fk` FOREIGN KEY (`Salazajeciowa_numerSali`) REFERENCES `salazajeciowa` (`numerSali`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
