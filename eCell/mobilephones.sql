-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 10, 2013 at 02:31 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `mobilephones`
--

-- --------------------------------------------------------

--
-- Table structure for table `mobiles`
--

CREATE TABLE IF NOT EXISTS `mobiles` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `url` varchar(100) NOT NULL,
  `features` text NOT NULL,
  `keywords` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mobiles`
--

INSERT INTO `mobiles` (`id`, `title`, `description`, `url`, `features`, `keywords`) VALUES
(1, 'Apple iPad mini Wifi 32GB, black', 'The Great Apple iPad with all features.', 'http://localhost/apple7.php', 'WiFi,camera.', 'apple\r\nApple iPad mini Wifi 32GB, black\r\napple ipad'),
(2, 'Apple iPad mini Wifi Cellular 32GB, black', 'The Ultimate Apple iPad with all features.', 'http://localhost/apple1.php', 'WiFi,Multitouch,3G network.', 'apple\r\nApple iPad mini Wifi Cellular 32GB, black\r\napple ipad\r\n'),
(3, 'Apple iPhone 4 8GB, black', 'The ultimate phone with all features and with facebook and twitter integration.', 'http://localhost/eCell/apple2.php', 'WiFi,3G,Camera.', 'apple\r\niphone\r\nApple iPhone 4 8GB, black\r\n'),
(4, 'Apple iPhone 4S 16 GB, white', 'The IOS phone by Apple with all features.\r\n', 'http://localhost/apple10.php', 'WiFi,Video Calling,High rsolution Camera.', 'Apple iPhone 4S 16 GB, white\r\napple\r\niphone'),
(5, 'Apple iPhone 5 16GB, black', 'The Great smart phone with camera and other exciting features.', 'http://localhost/apple3.php', 'WiFi,HD video support.', 'apple\r\nApple iPhone 5 16GB, black\r\niphone'),
(6, 'Apple iPhone 5 32 GB, white', 'Apple iPhone-5-32GB is a GSM phone. Apple iPhone-5-32GB, a SmartPhone mobile comes with a great list of features. Apple iPhone-5-32GB price is optimal and it is a great buy.', 'http://localhost/apple4.php', 'WiFi,3G,Internet.', 'apple\r\napple iphone\r\nApple iPhone 5 32 GB, white\r\n'),
(7, 'Apple iPhone 5 64 GB, white', 'Apple iPhone 5 64 GB, white is a GSM phone. Apple iPhone 5 64 GB, white, a SmartPhone mobile comes with a great list of features.Apple iPhone 5 64 GB, white price is optimal and it is a great buy.', 'http://localhost/apple5.php', 'WiFi,Internet,3G,Camera.', 'apple\r\napple iphone\r\nApple iPhone 5 64 GB, white'),
(8, 'iPad 2 16GB Wifi, white', 'iPad 2 16GB Wifi, white, a great iPad  comes with a great list of features. iPad 2 16GB Wifi, white price is optimal and it is a great buy.', 'http://localhost/apple6.php', 'WiFi,Graphics,facebook and twitter integration.', 'ipad2\r\napple ipad\r\niPad 2 16GB Wifi, white'),
(9, 'iPad 2 64GB Wifi', 'The ultimate iPad with great features in built and with optimal price.', 'http://localhost/apple9.php', 'WiFi,64GB internal memory,multitouch.', 'ipad2\r\napple ipad\r\niPad 2 64GB Wifi'),
(10, 'iPad 2 64GB Wifi, Black', 'The great ipad with all features and optimal price.', 'http://localhost/apple8.php', 'WiFi,messenger,Ultimate Gaming.', 'ipad\r\napple ipad\r\niPad 2 64GB Wifi,Black\r\n'),
(11, 'Micromax A25', 'The great Phone with all features.', 'http://localhost/micromax4.php', 'Dual Sim,Music Player,Internet.', 'micromax\r\nMicromax A25'),
(12, 'Micromax A30 Smarty 3', 'Micromax A30 Smarty 3 comes with Android and all features in optimal price.', 'http://localhost/micromax2.php', 'Android,Dual Sim,Touchscreen.,256MB RAM', 'micromax\r\nMicromax A30 Smarty 3'),
(13, 'Micromax A52', 'Micromax A52 is Android phone with camera and other exciting features.', 'http://localhost/micromax10.php', 'Camera,Android 2.3 Ginger Bread,Java Support.', 'micromax\r\nMicromax A52'),
(14, 'Micromax A73, black', 'Micromax A73, black-Android Phone and touchscreen with all other features.', 'http://localhost/micromax9.php', 'Android 2.3,Camera,Social networking.', 'micromax\r\nMicromax A73, black'),
(15, 'Micromax A87 Ninja 4.0, black white', 'Micromax A87 Ninja 4.0, black white comes with Android2.3 and it is dual sim phone.', 'http://localhost/micromax8.php', '1GHz Processor,Capacitive Touchscreen.', 'micromax\r\nMicromax A87 Ninja 4.0, black white\r\nMicromax A87 Ninja 4.0'),
(16, 'Micromax Canvas 2 A110', 'The Ultimate Phone with Android 4.0(ICS)\r\nand with all features.', 'http://localhost/micromax6.php', 'WiFi,BlueTooth,Camera(8MP).', 'micromax\r\nMicromax Canvas 2 A110'),
(17, 'Micromax Canvas 3 A116', 'The Phone with all features supported and comes with Latest version of Android4.1\r\n(jelly bin).', 'http://localhost/micromax7.php', 'WiFi enabled,1GB RAM,HD videos.', 'micromax\r\nMicromax Canvas 3 A116'),
(18, 'Micromax Funbook Infinity P275', 'Micromax Funbook Infinity P275 is a tablet \r\nfor better gaming expierence and internet surfing.', 'http://localhost/micromax3.php', '7 inch capacitive touch screen,2MP camera,\r\nWiFi,ebook reader.', 'micromax\r\nMicromax Funbook Infinity P275'),
(19, 'Micromax Ninja A89', 'Micromax Ninja A89 is a android phone and comes with all features.', 'http://localhost/micromax5.php', 'WiFi,Bluetooth,Camera.', 'micromax\r\nMicromax Ninja A89'),
(20, 'Micromax Superfone Pixel A90S', 'Micromax Superfone Pixel A90S comes with all features in optimal price.', 'http://localhost/micromax1.php', 'WiFi,Bluetooth,Camera.', 'Micromax Superfone Pixel A90S\r\nmicromax'),
(21, 'Blackberry 9220', 'Blackberry 9220 comes with all features and price is optimal.', 'http://localhost/bbm3.php', 'WiFi,Bluetooth,Camera', 'blackberry\r\nBlackberry 9220\r\nbbm'),
(22, 'BlackBerry 9300 Curve', 'BlackBerry 9300 Curve comes with all features and price is optimal.\r\n', 'http://localhost/bbm7.php', 'WiFi,Bluetooth,Camera', 'BlackBerry 9300 Curve\r\nBlackBerry\r\nbbm'),
(23, 'Blackberry 9320', 'Blackberry 9320 comes with all features and price is optimal.', 'http://localhost/bbm1.php', 'WiFi,Bluetooth,Camera', 'Blackberry 9320\r\nBlackberry \r\nbbm'),
(24, 'Blackberry 9380 Curve', 'Blackberry 9380 Curve comes with all features and price is optimal.\r\n', 'http://localhost/bbm8.php', 'WiFi,Bluetooth,Camera', 'Blackberry 9380 Curve\r\nBlackberry\r\nbbm'),
(25, 'Blackberry 9790 Bold', 'Blackberry 9790 Bold comes with all features and price is optimal.\r\n', 'http://localhost/bbm5.php', 'WiFi,Bluetooth,Camera', 'Blackberry 9790 Bold\r\nBlackberry\r\nbbm'),
(26, 'BlackBerry 9900 Bold', 'BlackBerry 9900 Bold comes with all features and price is optimal.', 'http://localhost/bbm4.php', 'WiFi,Bluetooth,Camera', 'BlackBerry 9900 Bold\r\nBlackBerry\r\nbbm'),
(27, 'BlackBerry Torch 9860', 'BlackBerry Torch 9860 comes with all features and price is optimal.', 'http://localhost/bbm2.php', 'WiFi,Bluetooth,Camera', 'BlackBerry Torch 9860\r\nBlackBerry\r\nbbm'),
(28, 'Blackberry Z10', 'Blackberry Z10 comes with all features and price is optimal.', 'http://localhost/bbm6.php', 'WiFi,Bluetooth,Camera', 'Blackberry Z10\r\nBlackberry\r\nbbm');
