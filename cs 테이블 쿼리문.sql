
/* 공지사항 테이블 */
CREATE TABLE `km_cs_notice` (
	`no` INT(10) AUTO_INCREMENT PRIMARY KEY,
	`parent` INT(10) NULL DEFAULT '0',
	`comment` INT(10) NULL DEFAULT '0',
	`cate` VARCHAR(20) NOT NULL,
	`title` VARCHAR(255) NOT NULL,
	`content` TEXT NOT NULL ,
	`hit` INT(10) NULL DEFAULT '0',
	`uid` VARCHAR(20) NOT NULL,
	`regip` VARCHAR(100) NOT NULL,
	`rdate` DATETIME NOT NULL,
);

/* 자주하는 질문 테이블 */
CREATE TABLE `km_cs_faq` (
	`no` INT(10) AUTO_INCREMENT PRIMARY KEY,
	`comment` INT(10) NULL DEFAULT '0',
	`cate` VARCHAR(20) NOT NULL,
	`cate2` VARCHAR(20) NOT NULL,
	`title` VARCHAR(255) NOT NULL,
	`content` TEXT NOT NULL,
	`hit` INT(10) NULL DEFAULT '0',
	`uid` VARCHAR(20) NOT NULL,
	`regip` VARCHAR(100) NOT NULL,
	`rdate` DATETIME NOT NULL,
);

/* 문의하기 테이블 */
CREATE TABLE `km_cs_qna` (
	`no` INT(10) AUTO_INCREMENT PRIMARY KEY,
	`comment` INT(10) NULL DEFAULT '0',
	`cate` VARCHAR(20) NOT NULL,
	`cate2` VARCHAR(20) NOT NULL,
	`title` VARCHAR(255) NOT NULL,
	`content` TEXT NOT NULL,
	`hit` INT(10) NULL DEFAULT '0',
	`uid` VARCHAR(20) NOT NULL,
	`regip` VARCHAR(100) NOT NULL,
	`rdate` DATETIME NOT NULL,
);