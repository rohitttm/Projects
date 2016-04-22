-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 24, 2013 at 12:04 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `tutorials`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `id_product` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `url` varchar(100) NOT NULL,
  `features` text NOT NULL,
  `keywords` text NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id_product`, `name`, `description`, `price`, `url`, `features`, `keywords`) VALUES
(1, 'Apple iPad mini Wifi 32GB, black', 'The Great Apple iPad with all features.', 36500, 'http://localhost/eCell/apple7.php', 'WiFi,camera.', 'apple\r\nApple iPad mini Wifi 32GB, black\r\napple ipad'),
(2, 'Apple iPad mini Wifi Cellular 32GB, black', 'The Ultimate Apple iPad with all features.', 36500, 'http://localhost/eCell/apple1.php', 'WiFi,Multitouch,3G network.', 'apple\r\nApple iPad mini Wifi Cellular 32GB, black\r\napple ipad\r\n'),
(3, 'Apple iPhone 4 8GB, black', 'The ultimate phone with all features and with facebook and twitter integration.', 26500, 'http://localhost/eCell/apple2.php', 'WiFi,3G,Camera.', 'apple\r\niphone\r\nApple iPhone 4 8GB, black\r\n'),
(4, 'Apple iPhone 4S 16 GB, white', 'The IOS phone by Apple with all features.\r\n', 28500, 'http://localhost/eCell/apple10.php', 'WiFi,Video Calling,High rsolution Camera.', 'Apple iPhone 4S 16 GB, white\r\napple\r\niphone'),
(5, 'Apple iPhone 5 16GB, black', 'The Great smart phone with camera and other exciting features.', 50500, 'http://localhost/eCell/apple3.php', 'WiFi,HD video support.', 'apple\r\nApple iPhone 5 16GB, black\r\niphone'),
(6, 'Apple iPhone 5 32 GB, white', 'Apple iPhone-5-32GB is a GSM phone. Apple iPhone-5-32GB, a SmartPhone mobile comes with a great list of features. Apple iPhone-5-32GB price is optimal and it is a great buy.', 52500, 'http://localhost/eCell/apple4.php', 'WiFi,3G,Internet.', 'apple\r\napple iphone\r\nApple iPhone 5 32 GB, white\r\n'),
(8, 'iPad 2 16GB Wifi, white', 'iPad 2 16GB Wifi, white, a great iPad  comes with a great list of features. iPad 2 16GB Wifi, white price is optimal and it is a great buy.', 26500, 'http://localhost/eCell/apple6.php', 'WiFi,Graphics,facebook and twitter integration.', 'ipad2\r\napple ipad\r\niPad 2 16GB Wifi, white'),
(9, 'iPad 2 64GB Wifi', 'The ultimate iPad with great features in built and with optimal price.', NULL, 'http://localhost/eCell/apple9.php', 'WiFi,64GB internal memory,multitouch.', 'ipad2\r\napple ipad\r\niPad 2 64GB Wifi'),
(10, 'iPad 2 64GB Wifi, Black', 'The great ipad with all features and optimal price.', NULL, 'http://localhost/eCell/apple8.php', 'WiFi,messenger,Ultimate Gaming.', 'ipad\r\napple ipad\r\niPad 2 64GB Wifi,Black\r\n'),
(11, 'Micromax A25', 'The great Phone with all features.', NULL, 'http://localhost/eCell/micromax4.php', 'Dual Sim,Music Player,Internet.', 'micromax\r\nMicromax A25'),
(12, 'Micromax A30 Smarty 3', 'Micromax A30 Smarty 3 comes with Android and all features in optimal price.', NULL, 'http://localhost/eCell/micromax2.php', 'Android,Dual Sim,Touchscreen.,256MB RAM', 'micromax\r\nMicromax A30 Smarty 3'),
(13, 'Micromax A52', 'Micromax A52 is Android phone with camera and other exciting features.', NULL, 'http://localhost/eCell/micromax10.php', 'Camera,Android 2.3 Ginger Bread,Java Support.', 'micromax\r\nMicromax A52'),
(14, 'Micromax A73, black', 'Micromax A73, black-Android Phone and touchscreen with all other features.', NULL, 'http://localhost/eCell/micromax9.php', 'Android 2.3,Camera,Social networking.', 'micromax\r\nMicromax A73, black'),
(15, 'Micromax A87 Ninja 4.0, black white', 'Micromax A87 Ninja 4.0, black white comes with Android2.3 and it is dual sim phone.', NULL, 'http://localhost/eCell/micromax8.php', '1GHz Processor,Capacitive Touchscreen.', 'micromax\r\nMicromax A87 Ninja 4.0, black white\r\nMicromax A87 Ninja 4.0'),
(16, 'Micromax Canvas 2 A110', 'The Ultimate Phone with Android 4.0(ICS)\r\nand with all features.', NULL, 'http://localhost/eCell/micromax6.php', 'WiFi,BlueTooth,Camera(8MP).', 'micromax\r\nMicromax Canvas 2 A110'),
(17, 'Micromax Canvas 3 A116', 'The Phone with all features supported and comes with Latest version of Android4.1\r\n(jelly bin).', NULL, 'http://localhost/eCell/micromax7.php', 'WiFi enabled,1GB RAM,HD videos.', 'micromax\r\nMicromax Canvas 3 A116'),
(18, 'Micromax Funbook Infinity P275', 'Micromax Funbook Infinity P275 is a tablet \r\nfor better gaming expierence and internet surfing.', NULL, 'http://localhost/eCell/micromax3.php', '7 inch capacitive touch screen,2MP camera,\r\nWiFi,ebook reader.', 'micromax\r\nMicromax Funbook Infinity P275'),
(19, 'Micromax Ninja A89', 'Micromax Ninja A89 is a android phone and comes with all features.', NULL, 'http://localhost/eCell/micromax5.php', 'WiFi,Bluetooth,Camera.', 'micromax\r\nMicromax Ninja A89'),
(20, 'Micromax Superfone Pixel A90S', 'Micromax Superfone Pixel A90S comes with all features in optimal price.', NULL, 'http://localhost/eCell/micromax1.php', 'WiFi,Bluetooth,Camera.', 'Micromax Superfone Pixel A90S\r\nmicromax'),
(21, 'Blackberry 9220', 'Blackberry 9220 comes with all features and price is optimal.', NULL, 'http://localhost/eCell/bbm3.php', 'WiFi,Bluetooth,Camera', 'blackberry\r\nBlackberry 9220\r\nbbm'),
(22, 'BlackBerry 9300 Curve', 'BlackBerry 9300 Curve comes with all features and price is optimal.\r\n', NULL, 'http://localhost/eCell/bbm7.php', 'WiFi,Bluetooth,Camera', 'BlackBerry 9300 Curve\r\nBlackBerry\r\nbbm'),
(23, 'Blackberry 9320', 'Blackberry 9320 comes with all features and price is optimal.', NULL, 'http://localhost/eCell/bbm1.php', 'WiFi,Bluetooth,Camera', 'Blackberry 9320\r\nBlackberry \r\nbbm'),
(24, 'Blackberry 9380 Curve', 'Blackberry 9380 Curve comes with all features and price is optimal.\r\n', NULL, 'http://localhost/eCell/bbm8.php', 'WiFi,Bluetooth,Camera', 'Blackberry 9380 Curve\r\nBlackberry\r\nbbm'),
(25, 'Blackberry 9790 Bold', 'Blackberry 9790 Bold comes with all features and price is optimal.\r\n', NULL, 'http://localhost/eCell/bbm5.php', 'WiFi,Bluetooth,Camera', 'Blackberry 9790 Bold\r\nBlackberry\r\nbbm'),
(26, 'BlackBerry 9900 Bold', 'BlackBerry 9900 Bold comes with all features and price is optimal.', NULL, 'http://localhost/eCell/bbm4.php', 'WiFi,Bluetooth,Camera', 'BlackBerry 9900 Bold\r\nBlackBerry\r\nbbm'),
(27, 'BlackBerry Torch 9860', 'BlackBerry Torch 9860 comes with all features and price is optimal.', NULL, 'http://localhost/eCell/bbm2.php', 'WiFi,Bluetooth,Camera', 'BlackBerry Torch 9860\r\nBlackBerry\r\nbbm'),
(28, 'Blackberry Z10', 'Blackberry Z10 comes with all features and price is optimal.', NULL, 'http://localhost/eCell/bbm6.php', 'WiFi,Bluetooth,Camera', 'Blackberry Z10\r\nBlackberry\r\nbbm'),
(29, 'LG A180 social final, black', 'LG A180 social final, black is a general\r\nphone useful for calling ang texting.', NULL, 'http://localhost/eCell/lg1.php', 'Ringtones,Messaging', 'LG A180 social final, black'),
(30, 'LG A290, grey', 'LG A290, grey comes with all features like messaging, ringtones etc.', NULL, 'http://localhost/eCell/lg2.php', 'Mp3 player,4GB expandable memory', 'LG A290, grey\r\n'),
(31, 'LG GS155, black', 'LG GS155, black is a basic calling phone with all fedatures.', NULL, 'http://localhost/eCell/lg3.php', 'TFT display,messaging.', 'LG GS155, black'),
(32, 'LG Optimus (GT 540), black', 'LG Optimus (GT 540), black comes with all features like music player,camera.', NULL, 'http://localhost/eCell/lg4.php', 'Mp3 Player,3MP Camera.', 'LG Optimus (GT 540), black');
