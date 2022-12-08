CREATE DATABASE `Kmarket`;


/* product_cate1 시작 */

CREATE TABLE `km_product_cate1` (
`cate1` TINYINT NOT NULL PRIMARY KEY, 
`c1Name` VARCHAR(20) NOT NULL);

/* product_cate1 끝 */


/* product_cate2 시작 */

CREATE TABLE `km_product_cate2` (
`cate1` INT NOT NULL, 
`cate2` INT NOT NULL, 
`c2Name` VARCHAR(20) NOT NULL);

/* product_cate2 끝 */


/* product 시작*/
CREATE TABLE `km_product` ( 
`prodNo` INT(10) AUTO_INCREMENT PRIMARY KEY, 
`prodCate1` TINYINT NOT NULL, 
`prodCate2` TINYINT NOT NULL, 
`prodName` VARCHAR(100) NOT NULL, 
`descript` VARCHAR(100) NOT NULL, 
`company` VARCHAR(100) NOT NULL, 
`seller` VARCHAR(20) not NULL, 
`price` INT NOT NULL, 
`discount` TINYINT DEFAULT 0, 
`point` INT DEFAULT 0, 
`stock` INT DEFAULT 0, 
`sold` INT DEFAULT 0, 
`delivery` INT DEFAULT 0,
`hit` INT DEFAULT 0, 
`score` TINYINT DEFAULT 0, 
`review` INT DEFAULT 0, 
`thumb1` VARCHAR(255) NOT NULL, 
`thumb2` VARCHAR(255) NOT NULL, 
`thumb3` VARCHAR(255) NOT  NULL, 
`detail` VARCHAR(255) NOT NULL, 
`status` VARCHAR(20) DEFAULT '새상품', 
`duty` VARCHAR(20) DEFAULT '과세상품', 
`receipt` VARCHAR(25) DEFAULT '발행가능 - 신용카드 전표, 온라인 현금영수증', 
`bizType` VARCHAR(20) DEFAULT '사업자 판매자', 
`origin` VARCHAR(20) DEFAULT '상세설명참고', 
`ip` VARCHAR(20) NOT NULL, 
`rdate` DATETIME NOT NULL, 
`etc1` INT default NULL, 
`etc2` INT default NULL, 
`etc3` INT default NULL, 
`etc4` INT default NULL, 
`etc5` INT default NULL);

ALTER TABLE `km_product` AUTO_INCREMENT = 1000000;

/* km_product 끝*/

/* km_product_cart 시작*/

CREATE TABLE `km_product_cart` (
`cartNo` INT AUTO_INCREMENT PRIMARY KEY, 
`uid` VARCHAR(20) NOT NULL, 
`prodNo` INT NOT NULL, 
`count` INT NOT NULL, 
`price` INT NOT NULL, 
`discount` INT NOT NULL, 
`point` INT NOT NULL, 
`delivery` INT NOT NULL, 
`total` INT NOT NULL, 
`rdate` DATETIME NOT NULL);

/* km_product_cart 끝*/


/* km_product_order 시작*/

CREATE TABLE `km_product_order` (
`ordNo` INT AUTO_INCREMENT PRIMARY KEY, 
`ordUid` VARCHAR(20) NOT NULL, 
`ordCount` INT DEFAULT 0, 
`ordPrice` INT DEFAULT 0, 
`ordDiscount` INT DEFAULT 0, 
`ordDelivery` INT DEFAULT 0, 
`savePoint` INT DEFAULT 0, 
`usedPoint` INT DEFAULT 0, 
`ordTotPrice` INT DEFAULT 0, 
`recipName` VARCHAR(20) NOT NULL, 
`recipHp` CHAR(13) NOT NULL, 
`recipZip` CHAR(5) NOT NULL, 
`recipAddr1` VARCHAR(255) NOT NULL, 
`recipAddr2` VARCHAR(255) NOT NULL, 
`ordPayment` TINYINT NOT NULL, 
`ordComplete` TINYINT NOT NULL, 
`ordDate` DATETIME NOT NULL);

/* km_product_order 끝*/


/* km_product_order_item 시작 */

CREATE TABLE `km_product_order_item` (
`ordNo` INT NOT NULL, 
`prodNo` INT NOT NULL, 
`count` INT NOT NULL, 
`price` INT NOT NULL, 
`discount` TINYINT NOT NULL, 
`point` INT NOT NULL, 
`delivery` INT NOT NULL, 
`total` INT NOT NULL);

/* km_product_order_item 끝 */


/* km_product_review 시작 */

CREATE TABLE `km_product_review` (
`revNo` INT AUTO_INCREMENT PRIMARY KEY, 
`prodNo` INT NOT NULL, 
`content` VARCHAR(255) NOT NULL, 
`uid` VARCHAR(20) NOT NULL,
`rating` TINYINT NOT NULL, 
`regip` VARCHAR(100) NOT NULL, 
`rdate` DATETIME NOT NULL);

/* km_product_review 끝 */