-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2022 at 05:12 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `addevent`
--

CREATE TABLE `addevent` (
  `id` int(20) NOT NULL,
  `etype` text NOT NULL,
  `capacity` int(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `location` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `time` time(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `addevent`
--

INSERT INTO `addevent` (`id`, `etype`, `capacity`, `address`, `location`, `date`, `time`) VALUES
(1, 'Politics', 200, 'Mumbai naka,nashik', 'nashik', '0000-00-00', '10:10:11.000000'),
(2, 'Politics', 200, 'Mumbai naka,nashik', 'nashik', '0000-00-00', '10:10:11.000000'),
(3, 'Politics', 200, 'Mumbai naka,nashik', 'nashik', '2022-10-10', '10:10:11.000000'),
(4, 'Sport', 10, 'nashik', 'nashik', '2022-02-02', '21:20:20.000000'),
(5, 'kaka', 100, 'nashik', 'nashik', '0000-00-00', '20:08:22.000000'),
(6, 'kaka', 900, 'kaka', 'kaak', '0000-00-00', '21:11:11.000000'),
(7, 'nashik', 100, 'nashikkaka', 'kkdk', '0000-00-00', '21:05:09.000000'),
(8, 'politics', 1000, 'mumbai', 'ghatkopar', '0000-00-00', '11:08:22.000000');

-- --------------------------------------------------------

--
-- Table structure for table `bookevent`
--

CREATE TABLE `bookevent` (
  `id` int(20) NOT NULL,
  `totalmember` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `username` text NOT NULL,
  `password` varchar(300) NOT NULL,
  `email` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `fullname`, `username`, `password`, `email`) VALUES
(1, 'vishu', 'demo', '$2y$10$9x7u8tIYd4DpqMQezMx1MOc02z9nQv9h4c.wYjbO5F0LHhyCaepra', 'demo@gmail.com'),
(2, 'lalit', 'lalit', '$2y$10$vyh.lODDd0zjBFHN6aD9tOhjkoJ5Rc5HOEPPIzXZT.q4bFBYglQd2', 'laiit12@gmail.com'),
(3, 'dhanu', 'dhanu', '$2y$10$uNauVE1TCa6ioLvF7RalkOePGTrZugboUIE8fvoUgMu/ZUXD7Wsm.', 'dhanu12@gmail.com'),
(4, 'demo', 'customer', '$2y$10$hkT.Y7JgVhAe/P/P8.wEoujx.4IyOBnCuSN9ViIcyynA01zyKX8Ly', 'demo1'),
(5, 'Rahul', 'rahul', '$2y$10$cQ45eTK2KheGp/0Tz4zWv.Mc4oyUQOhnckvxwvv4obO5aOmU1Ghbu', 'rahul@123gmail.com'),
(6, 'nilam', 'nilam', '$2y$10$QhfRsLt39sqcIY3wiPkZjOh2HTo6a623W9qtg9sIEOOylarIacrz6', 'nilam'),
(7, 'nikhil', 'nikhil', '$2y$10$i5kMF3uGUHz2etWzmis40uVP19XuL1cjA6kVv0OVEWv3AiUPcskpi', 'nikhil');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `username` text NOT NULL,
  `password` varchar(300) NOT NULL,
  `email` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `fullname`, `username`, `password`, `email`) VALUES
(1, 'pritam', 'pritam', '$2y$10$21Du0D62EuBPwWQy9tlOOefLTGCbu68ubmFbIJSipnC92ow9upXXi', 'pritam98@gmail.com'),
(2, 'pritam', 'pritam', '$2y$10$uM/tQtDT3JWkCxRDuM3ZHesajXswkkRs92sp.Jcs4yEIph.v2fQCK', 'pritam98@gmail.com'),
(3, 'pritam', 'pritam', '$2y$10$fZQ9Couj7dmlzU3tgAJdx.rRojVWUF3f4kMQPQ/YmtTXiwreHz1MK', 'pritam98@gmail.com'),
(4, 'pritam', 'pritam', '$2y$10$FJ3RygeopTmAlDRXCkzLQelbraW5VKZGNxTimBd3Wlq32wmwwTS56', 'pritam98@gmail.com'),
(5, 'karan', 'karan', '$2y$10$yLse2STi/YmaoHpI.1K5IuBzBD11TeBVZyDeLPmkUwbOxb9reQ.I6', 'karan@123'),
(6, 'karan', 'karan', '$2y$10$9VSaxE8vZ8XlHRZ/VqXZzOwp2TFDCOsFWbrBo5PlsHnailoz76XQ2', 'karan@123'),
(7, 'nashik', 'nashik', '$2y$10$/h63zBqVoEvWhozUKVjNeukERYNe9l8rUH43u5tgajWXzxjQHS9Ru', 'nashik1@gmail.com'),
(8, 'anu', 'anu', '$2y$10$A5wPAClvCnqCIXtFY4PduevS9Zp.U57QDD0Ras0ftxiSkq90r8AZ6', 'anu89@gmail.com'),
(9, 'vishal', 'vishal', '$2y$10$bUl9VnSq4gsGtH6bfCymPe8yIWLgUSvPb4Kul4Y6PW3jbnHrvC/Du', 'vishal'),
(10, 'vishal', 'vishal', '$2y$10$mN.JLxTVJgReLb8VnFW8deUe6dhRxJCsGrV9TenA7VX93mhcrDw7u', 'vishal'),
(11, 'kunal', 'kunal99', '$2y$10$l6NRFr7sCNTxj/NifQ014O92IJuoWjf94xNCCtZlfBw7DJovEMJxy', 'kunal'),
(12, 'demo', 'employee', '$2y$10$67s.zCfFhwmXv.ZhMq2qr.4EUNj1ADjncEmnOsRv00o2tIGo8EHt2', 'demo123'),
(13, 'rajnish', 'rajnish', '$2y$10$nJodtGElYC0Y1sPqKubUo.dlYqo0hvbgctaFXcHVZjFWbFggVDnIq', 'rajnish@123');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `feed1` varchar(100) NOT NULL,
  `feed2` varchar(100) NOT NULL,
  `feed3` varchar(100) NOT NULL,
  `feed4` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `feed1`, `feed2`, `feed3`, `feed4`) VALUES
(1, 'naski', 'kaka', 'kaka', 'xksmk'),
(2, 'kaka', 'bchdbjh', 'kjdnckjn', 'cndjnkj'),
(3, 'kk', 'kkk', 'kkkk', 'kkkkkk'),
(4, 'kaka1', 'kaka2', 'kaka3', 'kaka4'),
(5, 'nashk', 'kaka', 'ksan', 'kakaka'),
(6, 'ddd', 'ddd', 'ddd', 'ddd'),
(7, 'ddd', 'ddd', 'ddd', 'ddd'),
(8, 'k1', '1k2', 'kakak', 'sklkl'),
(9, 'k1', '1k2', 'kakak', 'sklkl'),
(10, 'k1', '1k2', 'kakak', 'sklkl'),
(11, '1', '2', '3', '4'),
(12, '1', '2', '3', '4'),
(13, '1', '2', '3', '4'),
(14, '1', '2', '3', '444'),
(15, 'kakak', 'k', 'kk', 'kkkk'),
(16, '1', '2', '3', '4'),
(17, 'nashik', 'nashik1', 'nashik2', 'nashik4'),
(18, 'nashik', 'nashik1', 'nashik2', 'nashik4'),
(19, 'z', 'zzzzz', 'zzzz', 'zzzzzzz'),
(20, '12', '21', '31', '41'),
(21, '9911', '1111', '12345', '54321'),
(22, '9911', '1111', '12345', '54321'),
(23, '9911', '1111', '12345', '54321'),
(24, '9911', '1111', '12345', '54321999'),
(25, '12', 'xxxxx', 'xsxs', 'wsw'),
(26, 'nashik', 'nashik', 'nasuk', 'nahaik'),
(27, 'nashik', 'nashik', '', 'nashik');

-- --------------------------------------------------------

--
-- Table structure for table `form`
--

CREATE TABLE `form` (
  `id` int(25) NOT NULL,
  `fname` varchar(40) NOT NULL,
  `edate` date NOT NULL,
  `venue` varchar(100) NOT NULL,
  `ename` varchar(100) NOT NULL,
  `etype` varchar(100) NOT NULL,
  `photo` varchar(100) NOT NULL,
  `decor` varchar(100) NOT NULL,
  `cater` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `form`
--

INSERT INTO `form` (`id`, `fname`, `edate`, `venue`, `ename`, `etype`, `photo`, `decor`, `cater`) VALUES
(8, 'rajnish', '2022-03-24', 'nashik', 'politics', 'politcian', 'karan', 'harsh', 'kakakak'),
(9, 'nashik', '0000-00-00', 'nandurbar', 'national', 'nike', 'nitin', 'nikhil', 'nilesh'),
(10, 'nashik', '0000-00-00', 'nandurbar', 'national', 'nike', 'nitin', 'nikhil', 'nilesh'),
(11, 'nashik', '0000-00-00', 'nil', 'nika', 'kaka', 'ncnci', 'nxcjsnj', 'nxjsn'),
(12, 'demi', '0000-00-00', 'demo', 'demo', 'demo', 'demo', 'demo', 'demo'),
(13, 'demi', '0000-00-00', 'demo', 'demo', 'demo', 'demo', 'demo', 'demo'),
(14, 'demi', '0000-00-00', 'demo', 'demo', 'demo', 'demo', 'demo', 'demo'),
(15, 'demo1', '0000-00-00', 'demo3', 'demo4', 'demo4', 'demo', 'demo6', 'dedd'),
(16, 'demo1', '0000-00-00', 'demo3', 'demo4', 'demo4', 'demo', 'demo6', 'dedd'),
(17, 'demo1', '0000-00-00', 'demo3', 'demo4', 'demo4', 'demo', 'demo6', 'dedd'),
(18, 'duplicate', '0000-00-00', 'duplicate', 'duplivat', 'xkjsnj', 'kjsnkj', 'lkxnskln', 'ncns'),
(19, 'duplicate', '0000-00-00', 'duplicate', 'duplivat', 'xkjsnj', 'kjsnkj', 'lkxnskln', 'ncns'),
(20, 'nashik', '0000-00-00', 'nashik', 'nashik', 'nashik', 'nashik', 'nashik', 'nashik'),
(21, 'nashik', '0000-00-00', 'nashik', 'nashik', 'nashik', 'nashik', 'nashik', 'nashik'),
(22, 'nashik', '0000-00-00', 'nashik', 'nashik', 'nashik', 'nashik', 'nashik', 'nashik'),
(23, 'duplicate', '0000-00-00', 'nandurbar', 'nandurbar', 'low', 'ketan', 'lalit', 'hemant'),
(24, 'duplicate1', '2010-02-02', 'nashik', 'nashik', 'jaja', 'karan', 'jabya', 'kiran'),
(25, 'aniket', '2010-10-10', 'kulkutta', 'kulkutta', 'gujrathi', 'lala', 'naan', 'mama'),
(26, 'aniket', '2010-10-10', 'kulkutta', 'kulkutta', 'gujrathi', 'lala', 'naan', 'mama'),
(27, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(28, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(29, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(30, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(31, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(32, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(33, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(34, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(35, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(36, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(37, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(38, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(39, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(40, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(41, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(42, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(43, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(44, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(45, 'duplicate1', '0000-00-00', 'nashik', 'nashik', 'politics', 'yash', 'yash', 'yash'),
(46, 'demo', '0000-00-00', 'mumbai', 'mumbai', 'abc', 'xyz', 'abc', 'azp'),
(47, 'antional', '0000-00-00', 'klakl', 'klakl', 'mcmckm;', 'dm;lm;', 'mdkkcm', 'cfnv k'),
(48, 'rajendra', '0000-00-00', 'mumbai', 'mumbai', 'school', 'ketan', 'dinesh', 'harsh');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `id` int(20) NOT NULL,
  `ename` text NOT NULL,
  `eprice` int(20) NOT NULL,
  `photo` int(20) NOT NULL,
  `cater` int(20) NOT NULL,
  `decor` int(11) NOT NULL,
  `gst` int(50) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`id`, `ename`, `eprice`, `photo`, `cater`, `decor`, `gst`, `total`) VALUES
(1, 'sport', 20000, 20000, 10, 0, 22000, 0),
(37, 'Sport', 1000, 1000, 1000, 1000, 10, 4010),
(38, 'Sport', 1000, 1000, 1000, 100, 2, 3102),
(39, 'district', 10, 20, 20202, 202, 2, 20436);

-- --------------------------------------------------------

--
-- Table structure for table `typeevent`
--

CREATE TABLE `typeevent` (
  `id` int(11) NOT NULL,
  `setype` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `typeevent`
--

INSERT INTO `typeevent` (`id`, `setype`) VALUES
(1, 'nashik');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `fullname` varchar(200) NOT NULL,
  `username` text NOT NULL,
  `password` varchar(300) NOT NULL,
  `email` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `fullname`, `username`, `password`, `email`) VALUES
(1, 'demo', 'demo', '$2y$10$LDyM4iYsIVxrcp8FnqHiHuSl.8egjrJCHqvzSzKG5SDLZ0nSmFzvq', 'demo'),
(2, 'bhushan', 'bhushan', '$2y$10$ZBjQy.D5rmBSossUUH7QLuZ03qcwMY4Gwb1ITOtQqPKB/5xXuthWe', 'bhushan@123'),
(3, 'asd', '123', '$2y$10$IvzMJPsqZvHXdJQd3wN9huelrxT5WvoLp5Q.TjuY5HXv.euKlyXFS', 'asdf@123.com'),
(4, 'nashiu', '567', '$2y$10$292cGwwrZdIc/E37VYbBJupx6XKfgYt.1WES.X6qQxTIDQc8dDPL6', 'nxkask jkjsj  '),
(5, 'lalit', 'lalit', '$2y$10$HdbRXdCQXhziAadESMnb.O3XgUDKZ53DshxaHdIoOVb82LphZifMa', 'laitwani12@gmail.com'),
(6, 'harsh', 'kaka', '$2y$10$C/6k1oq9Qqc.Xf0oyGYW2unOLlTWABBl2VzoMc5Mq6w3NmB3YH5VW', 'harsh2@gmail.com'),
(7, 'lalit', 'lalit', '$2y$10$2YP4AfCShDHDRsx4NCpRPull934XOSR995gH2iSMGXOj5YqRUfJc2', 'lalit34@gmail.com'),
(8, 'rajnish', 'rajinish', '$2y$10$fNwcW3z2gWDNiyUGOmilu.jsvCsSvvmN6b2RbdTuH7Iaha5buNcSy', 'rajnish123@gmail.com'),
(9, 'kanabana', 'kaka', '$2y$10$XqRB8Aaf8co4Xjq0Xkk7nOyhQ86GxBaiMgYsV4WRIwKB8zg..8wRm', 'kanabana2@gmail.com'),
(10, 'kaka', 'kaka', '$2y$10$CWVbRfn8gO28U.e3QJ9CVu2a/ectdbhNwMm.16JRswL85R4MX.IRa', 'kaka@123'),
(11, 'vishL', 'vishu', '$2y$10$vqEr8nmAWYUdekjLZYzL3u3jqmkBn6bPxsyYPz71oBH/b1sJ9Qmbq', 'vishal98@gmailovm'),
(12, 'vishL', 'vishu', '$2y$10$gmgh2QViwXvU0bBLIiADMOWqr83ttZwAOHfWGyBYCf3xLhyUSo4pu', 'vishal98@gmailovm'),
(13, 'nashk', 'nana', '$2y$10$tJMzztdSzZ/ZZZbP4UmgFeJteW93QkRhnXQiKz/9ZBLoBOI6DjmW6', 'anana'),
(14, 'amit', 'amit', '$2y$10$oXAJ.GmkvYnoEyriwTOWR.rfrD4d4ciPh/vJeK8v6Q0IwUfIiDWM.', 'amit87@gmail.com'),
(15, 'vishal', 'vishal', '$2y$10$.5QvJ4oXFen1LVa176GOTujzRW63Tv9feusIkrdGZ1gksgEybI3mG', 'vishal12@gmail.com'),
(16, 'nashik', 'nashik', '$2y$10$OsLnv/6SxW7UMnv7sW4Z2u5.4qIUN2hQ2zw9eyHfKCYNvydYrqdjG', 'nashik'),
(17, 'nashik', 'nashik', '$2y$10$5eRg5LZK7gYAA3qf0S9ZZeT5hLaAV7TUA6U1mQCtC3K9o8hs6hrn6', 'nashik'),
(18, 'nashuk', 'mama', '$2y$10$qkjlQgVcN9NGVWbOtoMqPO5/E0Lvvat1kAkV/t2ldd79gSfQt.XIm', 'mama'),
(19, 'kunal', 'kunal', '$2y$10$UL3RxqX48pPnwImX/PKTA.8z.dKnewhMfwk7UU85ib.cqnyACx0U2', 'kunal'),
(20, 'pratik', 'pratik', '$2y$10$UYgRX69PltNB7Ay/IENfJeVgervG6IZzznf4fnoGzZAr8CLqiASs.', 'pratik'),
(21, 'kaka', 'kaka', '$2y$10$Zunp/eLbWjWOTCOcUz.WEuhSqyC4yotc4HkkoLKk.4ToXTzdy9UCu', 'kaka'),
(22, 'amruta', 'amruta', '$2y$10$rDBCPh3vCdKYayfyMEhk4uRq49cUqT9/8zgwEll4OatDA2k/pM8yy', 'amruta'),
(23, 'didi', 'didi', '$2y$10$ITsTvfFas4cL8rxE4Mdnme3Llwe0EPk7/udEsc73J4h1cIJtQejQS', 'didi'),
(25, 'kakaka', 'kaka', '$2y$10$2xUZG9WYei4JvcfK.eRIHOdge1CINRYA.21ekWf.v4ErOBTYp3FH2', 'kaka'),
(26, 'aniket', 'aniket', '$2y$10$3J6zmAtdQMcbvSWLr/SLweN4WsnPNiYi.sJNew7tj5URzbp7CvR7W', 'ankiet98@gmail.com'),
(27, 'aniket', 'aniket', '$2y$10$8OGXtM2qmXugOzl1/4IZOev9883r5.Bfd6aOXVTqax3mf8etOlT6S', 'aniket99@gmail.com'),
(28, 'demo', 'demo', '$2y$10$IS1vxKWvRk9MBfnBNqTG7.R0ocnFHKRNozQKpQfTRksSvcqQoNjWO', 'demo00@gmail.com'),
(29, 'demo1', 'demo1', '$2y$10$KBxVv0SQmmPmj3p8EUEGWuwUNJU4Acyj.hdukXdq3GywTPW09Jde2', 'demo12@gmail.com'),
(30, 'vishal', 'vishal', '$2y$10$CwFYUpyF9DNK9UJbJO1ONePxtoP/lTLz9B.JDSN8EuRxLhCQIGHsG', 'vishal11@gmail.com'),
(31, 'vishal1', 'vishal1', '$2y$10$wmQ7WlTJ0Uukl8DuOH9n/uVgoQWDcCc8PhADZvR8mqLK4japnqpam', 'vishal123@gmail.com'),
(32, 'niki', 'niki', '$2y$10$K.QqmgN5r03uPwiW26uXx.wNLkPhBn5z.4WMQM32nwKCTfykrDv1C', 'niki'),
(33, 'demo', 'demo', '$2y$10$kiOs1v1ok3MWIUF9rq.Bm.fatZvx0t/GURgbcIo1iHHcvf7sto6T6', 'demo1'),
(34, 'amruta', 'amruta', '$2y$10$ZBOdg1NzU89BOI9u4iey8OQfYYS1vmMZecqLwEOJ8tK1hZiqETs8K', 'amruta98@gmail.com'),
(35, 'shubham', 'shubh', '$2y$10$7tqYunXztE3Xy3BVxCfQPejk1b8Y/EgbaWWML051MjuqCmrCn66AC', 'shubh99@gmail.com'),
(36, 'amruta', 'amruta', '$2y$10$ndvttGY0k.eRQAmBHKwJR.jmOesA/yrN3URp733Wyw06FVCWaQgty', 'amruta89@gmail.com'),
(37, 'aniket', 'aniket', '$2y$10$zgRM5hQvGRuDkO/M59XjRe/TBsDAhQNKbf4yjF1EI/OtQx61Kasp6', 'aniket89@gmail.com'),
(38, 'Mahesh', 'mahesh', '$2y$10$mHscCtvV79VHcVDuXsvWZOFgxhhnO5mWcNjbDE3G3hHwUONjuk6oy', 'mahesh98@gmail.com'),
(39, 'demo1', 'login', '$2y$10$HRBbwhvBHXecF/YF5Gh9hOSlRc6kniFcabZz4CO4nt.s/93hANA2O', 'demo');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `addevent`
--
ALTER TABLE `addevent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `form`
--
ALTER TABLE `form`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `typeevent`
--
ALTER TABLE `typeevent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `addevent`
--
ALTER TABLE `addevent`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `form`
--
ALTER TABLE `form`
  MODIFY `id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `typeevent`
--
ALTER TABLE `typeevent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
