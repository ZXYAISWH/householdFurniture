/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.56 : Database - householdfurniture
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`householdfurniture` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `householdfurniture`;

/*Table structure for table `f_furniture` */

DROP TABLE IF EXISTS `f_furniture`;

CREATE TABLE `f_furniture` (
  `furniture_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家具表的主键',
  `add_time` datetime DEFAULT NULL COMMENT '家具的添加时间',
  `classify_id` int(11) DEFAULT NULL COMMENT '家具分类表的主键',
  `clicks` int(11) DEFAULT NULL COMMENT '家具的点击量',
  `description` varchar(255) DEFAULT NULL COMMENT '家具描述',
  `furniture_img` varchar(255) DEFAULT NULL COMMENT '家具的主图',
  `furniture_name` varchar(255) DEFAULT NULL COMMENT '家具的名称',
  `furniture_no` varchar(255) DEFAULT NULL COMMENT '家具的编号',
  `key_word` varchar(255) DEFAULT NULL COMMENT '关键字(方便搜索)',
  `status` tinyint(1) DEFAULT NULL COMMENT '家具的状态',
  PRIMARY KEY (`furniture_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

/*Data for the table `f_furniture` */

insert  into `f_furniture`(`furniture_id`,`add_time`,`classify_id`,`clicks`,`description`,`furniture_img`,`furniture_name`,`furniture_no`,`key_word`,`status`) values (9,'2022-07-29 01:51:07',1,0,'源于大自然,香,美','bigYYdeFWGdXV5FWT5Y2Hvy.jpg','轻奢高档干花真花风干摆件diy芦苇绣球花花束','bestXF7Q0HST860a926WW16oFk6HI','花,鲜花,干花',0),(10,'2022-07-29 02:22:46',1,0,'很美,很香,很好看','big1x5dc4UYxe0d410I2dc1.jpg','现代简约仿真花艺绿植售楼处洽谈桌酒店餐桌','bestdhEeepqNAJp5I2S2tGq1RXz4Z','花,鲜花,干花',0),(11,'2022-07-29 02:24:34',1,0,'源于大自然,香,美','bigXavEUE40XA2dzxZcXzfv.jpg','尤加利叶干花风干天然真花花束','bestERAZXh6nCZjt3P41ArrHaUuxc','花,鲜花,干花',0),(12,'2022-07-29 02:31:01',1,0,'源于大自然,香,美','bigHdVv4IF0X432xVcUcUbG.jpg','轻奢玻璃花瓶摆件创意客厅干花插花花艺','bestIf0rjCgtaConIrRtxpt4JwwsL','花,鲜花,干花',0),(13,'2022-07-29 02:35:31',1,0,'干花摆设','bigdVH2IATUT2E0ax3EVA4Y.jpg','雏菊仿真花向日葵家居摆设玫瑰花','bestNYZdDBqdIyfD58AdUpbVWcyAK','花,鲜花,干花',0),(14,'2022-07-29 02:38:39',1,0,'干花摆设','bigYZ0Y4xHFTZ1af4w35Y2H.jpg','原野自然风格仿真花假花套装','best9mMMvx4PSKGFud1Ooj3oPv9bQ','花,鲜花,干花',0),(15,'2022-07-29 02:40:15',1,0,'干花摆设','big5UFexITTcFxz1eAz2exa.jpg','现代轻奢假花仿真花摆花装饰花束干花摆件','bestl4WQ4vNR2StIjz9apZ5mleKRr','花,鲜花,干花',0),(16,'2022-07-29 02:41:21',1,0,'干花摆设','bigceHfxvYdvb5A0TUwYyGZ.jpg','仿真花花束客厅假花摆设餐桌装饰插花摆件轻奢','bestuh7Fhfe009YU9zfixaeCKB3M0','花,鲜花,干花',0),(17,'2022-07-29 02:45:19',1,0,'干花摆设','bigvWaAFITWY5xb3VbV0b5W.jpg','ins永生玫瑰花满天星干花花束轻奢家居装饰真花','bestSIQtBibUhpiWzNcwRDkeJxzLX','花,鲜花,干花',0),(18,'2022-07-29 02:46:10',1,0,'干花摆设','bigaEIZb415xZEyv03U52Yc.jpg','干花风干天然真花花束摆设装饰ins风摆件','besthgv00ddUzPClcl9NNf1ylBctn','花,鲜花,干花',0),(19,'2022-07-29 02:47:26',1,0,'干花摆设','bigHc4W0bYxdV44dv2eaA2a.jpg','家居茶几客厅摆件装饰品花艺','bestPKMnYl5XwHkWJLOxlmgNumuiB','花,鲜花,干花',1),(20,'2022-07-29 02:48:24',1,2,'干花摆设','bigFwVV3T01Z2dVIV2U2G5c.jpg','芍药花艺花毛茛家居装饰摆件','bestr3lAl89xcMnYvTNoAvXY9cxaT','花,鲜花,干花',0),(21,'2022-07-29 02:52:06',1,0,'干花摆设','bigvbAaYfzZHVaEdFG4dVFF.jpg','阿尔贝罗玫瑰复古仿真花插花泡沫花客厅假花家居摆设','bestZfL1jl50er9xDm1sjPP6PqIo7','花,鲜花,干花',0),(22,'2022-07-29 02:54:30',2,0,'花,花瓶','bigT2xe4zYzT2A4UxVxAEYz.jpg','北欧极简陶瓷花器黑白色客厅装饰品摆件','best66ag9HiPaM99rYydmjz66B4Gg','花瓶',0),(23,'2022-07-29 02:55:17',2,0,'花,花瓶','bigAdFEVI4YXYzE22yfdwFf.jpg','陶瓷摆件书房茶室创意磨砂插干花花瓶白','besthzhNzNqFqS03Lm6B7637N5v3K','花瓶',0),(24,'2022-07-29 02:56:03',2,0,'花,花瓶','big5WUGVeAbwFzUcEevbAcW.jpg','白色陶瓷花瓶摆件 现代简约客厅干花插花花器','bestbMo74a0zL1TJXDwOkzFDHCIAs','花瓶',0),(25,'2022-07-29 02:56:53',2,0,'花,花瓶','big0ZFAZ4bV10H1xXAXZT3b.jpg','意大利Bloc Studios大理石花瓶花盆插花手工艺术Iris','bestpeIP1do0G3Gpb3LnTimW8Hxzp','花瓶',0),(26,'2022-07-29 02:57:43',2,0,'花瓶摆设','bigwevydHFU3VZXdex13eVe.jpg','花北花瓶摆件现代简约白色客厅餐桌摆件','bestCFLid2dyBev9qE8JG5zqpycCZ','花瓶',0),(27,'2022-07-29 02:58:51',2,0,'花,花瓶','bigHEaVaHdzf4IczH200Zeb.jpg','简约北欧陶瓷花瓶客厅餐厅居家装饰品卧室摆件','bestm2WOEZOgzbBryhIQjs4uCDe9a','花瓶',1),(28,'2022-07-29 02:59:39',2,0,'花,花瓶','big3wWfyyeYIzY1eacIzEyb.jpg','创意网红轻奢插干花鲜花客厅摆件','bestmevNluk1CSAyBtN8xobAWeqJd','花瓶',0),(29,'2022-07-29 03:00:35',2,0,'花,花瓶','bigbeeTY2aaUabAAVcIXIvU.jpg','干湿插花瓶家用桌面摆件瓶吹制玻璃花瓶','bestsnjKaaOEcgXNCvOlwTz63xyhS','花瓶',0),(30,'2022-07-29 03:01:26',2,0,'花,花瓶','bigzYw5d51xVz10yE45xIcA.jpg','仿真花室内装饰花新中式仿真手感玉兰花干花假花插花','bestkLGyc9MnxBLOQTdvuIla9gjnc','花瓶',1),(31,'2022-07-29 03:04:29',2,0,'花,花瓶','bigd3vdIGaf0T5GYeycfTFT.jpg','玄关柜装饰品花瓶干花插摆件','bestyJZMKgkdH7ehDOWYfkelDxtpE','花瓶',0),(32,'2022-07-29 03:05:15',2,0,'花,花瓶','bigU002evYzA3vba3ZyA0ad.jpg','客厅餐桌家居软装饰品摆件干花花器样板房间摆设','bestniAPiUDKjAaRxnrHaLzGUUGSN','花瓶',0),(33,'2022-07-29 03:06:08',2,0,'花,花瓶','bigWfvUATHZXzGY2151bvAI.jpg','现代创意玻璃花瓶透明客厅水培插花装饰','bestHzK7akviw3tUrRqCbUyQlXp0A','花瓶',1),(34,'2022-07-29 03:07:09',2,0,'花,花瓶','big144wUIa1zIdX4z3b3xW2.jpg','陶瓷花瓶摆件插花装饰客厅书房样板间软装','best88GvDwVQDnpijeTuWrxGCDjrB','花瓶',0),(35,'2022-07-29 03:08:35',2,0,'花,花瓶','bigIEwVvwZaaeXVFAUVATZy.jpg','客厅餐桌软装饰品干花瓶','bestc2YoNA5RpGnesNXQU6pdK2LFt','花瓶',0),(36,'2022-07-29 03:10:24',3,0,'餐桌桌布罩件','bigww0cEeEWZVTEE1wT3Ae4.jpg','美式桌旗北欧式高档奢华茶几巾餐桌','bestfHQq1Vn7l4mJGp3HSmDuXN6OT','桌布',0),(37,'2022-07-29 03:11:17',3,0,'餐桌桌布罩件','big2ayyYVy13aWbvTIdWWU2.jpg','简约四方老式餐桌布茶几角几桌布罩','bestUA3cWv2cYvvn92M6ez21Ku13j','桌布',0),(38,'2022-07-29 03:12:04',3,0,'餐桌桌布罩件','bigyyx43HddbEAE1bUGHyH2.jpg','ns风pvc茶几布轻奢高级感','best293IvbNUdvAHU6RrTqLKJHKtn','桌布',0),(39,'2022-07-29 03:13:07',3,0,'餐桌桌布罩件','bigH15EvEU3IXIZUydxIecA.jpg','欧式现代简约网红客厅美式茶几电视柜桌布','bestc6dYtxvFVpZ1KQmcLU0wj9TMw','桌布',0),(40,'2022-07-29 03:13:48',3,0,'餐桌桌布罩件','bigbdd0GeyWyvFEfTe3FTzY.jpg','长方形台布茶几布桌垫网红北欧ins风','bestJDfigwvXefvo9MLKT9OCnIoD0','桌布',0),(41,'2022-07-29 03:14:37',3,0,'餐桌桌布罩件','bigTHz35IHffTaAUIAXexZv.jpg','客厅奢华欧式长方形餐桌布茶几桌布','bestK7gScftJ0fcYoguQabqRm86Uf','桌布',0),(42,'2022-07-29 03:15:21',3,0,'餐桌桌布罩件','bigd2vI5U4TzxeFzGGwbdIF.jpg','桌布布艺新中式北欧式美式长方形圆形茶几布','best8CO2I7QfTwCiBhNP0N0gRO9hn','桌布',0),(43,'2022-07-29 03:16:09',3,0,'餐桌桌布罩件','bigv31xZbIw5ev1IUwFFbex.jpg','经典加厚欧式格子桌布布艺餐厅餐桌布','bestO4gNKsDBKPZhtJJLGWXAFUqeS','桌布',0),(44,'2022-07-29 03:16:52',3,0,'餐桌桌布罩件','biga3c0HcE4zVWE4bbF0Iyz.jpg','薄棉桌布布艺家用客厅小清新餐桌垫茶几垫','besta4Ajg7DKxCMi6zfuwlJpOCJ9t','桌布',0),(45,'2022-07-29 03:17:42',3,0,'餐桌桌布罩件','bigzxcW0GXZbTd1wyHwxI3a.jpg','台布茶几桌布布艺长方形餐桌布','bestlcPWLgtGuvAOfYO6ZpT4PfRY8','桌布',0),(46,'2022-07-29 03:19:04',4,0,'抱枕靠垫','bigHaW21HadWZ2zwfe2UxEf.jpg','轻奢高档酒店样板间毛绒抱枕','bestIRzPtZx8WfNYZQFPEcnc6e8CS','抱枕',0),(47,'2022-07-29 03:19:58',4,0,'抱枕靠垫','bigyybc3TUYby1a2GdGyZEZ.jpg','靠枕办公室座椅子靠背沙发护腰枕简约','bestpp5VljzDzsrIU3ylJ0QYjx2sb','抱枕',0),(48,'2022-07-29 03:20:40',4,0,'抱枕靠垫','bigFeeeTGGF4acxXWyWUZ20.jpg','现代简约抱枕靠背靠垫客厅沙发靠枕抱枕','bests0EuaSMOEHFaJvh41vv3pUQQo','抱枕',0),(49,'2022-07-29 03:21:26',4,0,'抱枕靠垫','big0dFwUWTZ4zIeEHIw431X.jpg','大号抱枕腰枕汽车办公室座椅子','bestzPrcw6cCXfgM8brUJ4Gju9eXK','抱枕',0),(50,'2022-07-29 03:22:20',4,0,'抱枕靠垫','bigI4yyz3XFyZGTZG2cdZ0W.jpg','沙发办公室床头靠枕套腰枕简约靠背','bestW9OryuxBavXwXsTBq54391zuC','抱枕',0),(51,'2022-07-29 03:23:02',4,0,'抱枕靠垫','bigGHEbAUXEZWFb1bGx4wcE.jpg','抱枕沙发客厅靠枕床头上靠垫','bestIjFiHKqv8KVgPRO4W8zhQQZgE','抱枕',0),(52,'2022-07-29 03:23:47',4,0,'抱枕靠垫','bigbz4zFwG10GyGyXwbU302.jpg','蔓越家 ins北欧床头靠垫白色抱枕沙发靠背','bestMAFcZR55kNqw3pk7s2o0Ikgvj','抱枕',0),(53,'2022-07-29 03:24:35',4,0,'抱枕靠垫','bigHzIH1fWUv03wVGwcVYYf.jpg','蔓越家 奶油色ins风撸猫感抱枕沙发腰枕靠垫','bestp3SR41gyoHGCgDZA8WMkpkINU','抱枕',0),(54,'2022-07-29 03:25:27',4,0,'抱枕靠垫','bigTTwcHWFvcGdvwT5XVcVa.jpg','抱枕女生蒲团可爱枕头榻榻米飘窗靠背垫','bestYwH2pfItEplT2I2YY5ptcIwaT','抱枕',0),(55,'2022-07-29 03:26:13',4,0,'抱枕靠垫','bigIEefXZcfxIcz3f1FE2Za.jpg','抱枕儿童可爱少女心毛绒靠垫粉','best4bY8tlwqiLm2NAEuoowPAwXNj','抱枕',0),(56,'2022-07-29 03:27:06',4,0,'抱枕靠垫','bigdGGeXW2z01YFeb4AEHyI.jpg','欧思陆抱枕套轻奢现代简约','bestDGioyxvoHuRrJg9bmAYPXT6rR','抱枕',0),(57,'2022-07-29 03:27:51',4,0,'抱枕靠垫','bigwUHZV1xTA3Y03afxYwHH.jpg','夏日清新抱枕套ins风沙发客厅靠枕','bestyqIa81GuywTYFTvIvnYEjU1kA','抱枕',0),(58,'2022-07-29 03:28:58',4,0,'抱枕靠垫','bigfHIw4TE12aZHXXy55FWY.jpg','ELIN LONYAIN现代轻奢靠垫抱','best9nBq1GI1IbM05J8ScD6jFhh3e','抱枕',0),(59,'2022-07-29 03:31:29',5,0,'墙壁装饰挂画','bigcwcGeE3ZTI4H1XW51c24.jpg','客厅侘寂风挂画玄关餐厅装饰画纯手工抽象画','bestnUKcHsYkg4x5TuatG12RmEPoL','挂画',0),(60,'2022-07-29 03:32:16',5,0,'挂壁家具','bigbv43HxW03E2Y1z2Iz5Xz.jpg','床头挂画书房茶室软装壁画','bestdWIsGTV2CzIAKrbCYDqFd9qAs','挂画',0),(61,'2022-07-29 03:32:57',5,0,'挂壁家具','big4f3xcAUvEYbYXzzcbyAz.jpg','北欧ins奶油原木风装饰画莫兰迪色挂画','best4nljZNJXPWYGlUm10u0Sm2D7j','挂壁家具',0),(62,'2022-07-29 03:33:46',5,0,'挂壁家具','bigz4Z5XycewxZ0YAcWz1cZ.jpg','Johsmpaint手绘油画 抽象花卉客厅挂画','bestHb9o1ZMGyZ81djqdYIV0Qs4yR','挂画',0),(63,'2022-07-29 03:34:36',5,0,'挂壁家具','bigGXHdVzEaE3ZIUZ155T4z.jpg','复古简美小尺寸清新花卉玄关装饰画','bestVU3qycrCJWFuZmR06RNmobOua','挂壁家具',0),(64,'2022-07-29 03:35:18',5,0,'挂壁家具','bigZXVfT010dxXY0TF0W515.jpg','岁月韶华轻奢新中式玄关玄幻装饰画','bestNfaRelK6bTbugLkorLUEatRAk','挂画',0),(65,'2022-07-29 03:36:01',5,0,'挂壁家具','bigy1U2EWvAXa10wGafGyVd.jpg','抽象装修风格挂画桌面摆件摆设壁画','bestR7w8zdBjrYCbRZQp0aTP3QtOo','挂画',0),(66,'2022-07-29 03:36:43',5,0,'挂壁家具','bigvV4IzEb2WAvEfcvEexaW.jpg','北欧侘寂风卧室装饰画床头墙壁画','bestLBPH9UciI1lvAkUPx38zj5H43','挂画',0),(67,'2022-07-29 03:37:26',5,0,'挂壁家具','bigy4UyAW0ezVUbdV2515zU.jpg','活力现代简约装饰画抽象建筑客厅沙发背景墙挂画','best3VUXa1i5VXvS4AmmMJHF5oRpx','挂壁家具',0),(68,'2022-07-29 03:38:26',5,0,'挂壁家具','big2yHTVT1dYFAc15zVYZcH.jpg','现代餐厅抽象装饰画简约公寓卧室沙发背景','best1p4ruvOWxlZZS57QopgYyNove','挂壁家具',0),(69,'2022-07-29 03:39:11',5,0,'挂壁家具','bigZZvTdTTUIca44eTYFd02.jpg','约定现代简约抽象几何立体静物客厅装饰画','bestJxyxNhvkIbS1C7k4L1xcJtfYQ','挂画',0),(70,'2022-07-29 03:40:46',6,0,'蜡艺香薰','bigWadf4UbAWaGVzFHaWyzx.png','述之有味ladybug白茶香氛香水桂花无火香薰','best6saqJTjNBknT2taUR07apsyZq','香薰',0),(71,'2022-07-29 03:41:33',6,0,'蜡艺香薰','bige5XyA35TyyGzA0H114Hb.jpg','AUDRIEY野兽 干花花草无火香薰','bestjJWzstVN0T2pg3EuMF6PUcHh0','香薰',0),(72,'2022-07-29 03:42:21',6,0,'蜡艺香薰','bigZvZIVaw2wxTGUEwe3a00.jpg','inventor设计者 樱花无火香氛家用室内香薰','bestoCJvien1LLJ9OD5WhSNpg9JL4','香薰',0),(73,'2022-07-29 03:43:07',6,0,'源于大自然,香,美','big2bbeE42Uawd14W0FWZI4.jpg','五星酒店房间北欧香薰','bestFFiL5qMYueQbeBAvdbftLkuG3','香薰',0),(74,'2022-07-29 03:43:56',6,0,'蜡艺香薰','bigXfA3bWTEvT0b3cbYUWXH.jpg','栀子花香薰室内持久家用无火香薰','bestCV6McLTqAhjMSkkjwyrRjlvMB','香薰',0),(75,'2022-07-29 03:44:44',6,0,'蜡艺香薰','big02U3VHETczAEfGE1ade5.jpg','家用室内持久留香卧室房间香水摆件香氛礼盒','bestcMOMPSCLrP6nyP66BcJIi0ecE','香薰',0),(76,'2022-07-29 03:45:43',6,0,'蜡艺香薰','bigcYdYFewYEX1fGWvv4HAG.jpg','今人金方香薰精油水晶扩香','besteJsrHAMk7AuvXL0AUqKshUq0y','香薰',1),(77,'2022-07-29 03:46:44',6,0,'很香的自然香','bigA55ZxIHZv34wZ0TY5ww5.jpg','香薰家用室内持久空气清新剂卧室香水','bestV3yHd7GrWT7mxwf2aIMRBEsr1','香薰',0),(78,'2022-07-29 03:47:27',6,0,'源于大自然香','bigdyXzz13Ha4XTbwE3xTIe.jpg','无火香薰室内持久家用','best50BGAXhMux7qmMXDV7egIXRuL','香薰',0),(79,'2022-07-29 03:48:07',6,0,'源于大自然香','bigFdEbeG20dZEed0VFaE42.jpg','香薰室内家用持久高级无火熏香摆件','bestugADHBqhngdPh5cmJ6sNJ19gn','香薰',0),(80,'2022-07-29 03:48:55',6,0,'源于大自然香','bigIycVacZf4G1e21zvvTYe.jpg','木司无火香薰精油熏香家用','bestdniInha6AF2yI6kF4YZfOWaNg','香薰',0),(81,'2022-08-04 10:37:03',4,0,'抱枕靠垫','bigz4GAAxH3dbz52vzyaycF.jpg','joyourbaby佳韵宝孕妇枕孕妇护腰枕','bestYITFXlDodwKYL4RqnkJ29D8Fu','抱枕',0);

/*Table structure for table `f_furniture_classify` */

DROP TABLE IF EXISTS `f_furniture_classify`;

CREATE TABLE `f_furniture_classify` (
  `classify_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家具类型表的主键',
  `classify_add_time` datetime DEFAULT NULL COMMENT '家具添加时间',
  `classify_inventory` int(11) DEFAULT NULL COMMENT '家具类型的库存',
  `classify_name` varchar(255) DEFAULT NULL COMMENT '家具类型的名称',
  PRIMARY KEY (`classify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `f_furniture_classify` */

insert  into `f_furniture_classify`(`classify_id`,`classify_add_time`,`classify_inventory`,`classify_name`) values (1,'2022-07-27 08:32:27',0,'干花花艺'),(2,'2022-07-27 08:51:22',0,'花瓶花器'),(3,'2022-07-27 08:56:48',0,'桌布罩件'),(4,'2022-07-27 08:56:55',0,'抱枕靠垫'),(5,'2022-07-27 08:57:13',0,'墙式壁挂'),(6,'2022-07-27 08:57:34',0,'蜡艺香薰');

/*Table structure for table `f_furniture_comment` */

DROP TABLE IF EXISTS `f_furniture_comment`;

CREATE TABLE `f_furniture_comment` (
  `furniture_comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论表的主键',
  `furniture_comment_content` varchar(255) DEFAULT NULL COMMENT '评论的内容',
  `furniture_comment_scores` double(11,2) DEFAULT NULL COMMENT '评论分数',
  `furniture_comment_time` datetime DEFAULT NULL COMMENT '评论时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户表的外键',
  `furniture_id` int(11) DEFAULT NULL COMMENT '家具表的外键',
  PRIMARY KEY (`furniture_comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `f_furniture_comment` */

insert  into `f_furniture_comment`(`furniture_comment_id`,`furniture_comment_content`,`furniture_comment_scores`,`furniture_comment_time`,`user_id`,`furniture_id`) values (1,'这个花非常的好,特别的漂亮',5.00,'2022-08-02 10:27:55',7,29),(2,'抱枕非常的舒服',5.00,'2022-08-02 11:03:18',7,50),(3,'这个花非常的棒',4.00,'2022-08-04 20:13:00',8,29);

/*Table structure for table `f_furniture_detail` */

DROP TABLE IF EXISTS `f_furniture_detail`;

CREATE TABLE `f_furniture_detail` (
  `furniture_detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家具详情表',
  `furniture_detail_contexts` varchar(255) DEFAULT NULL COMMENT '家具的详情json',
  `furniture_id` int(11) DEFAULT NULL COMMENT '家具表的外键',
  PRIMARY KEY (`furniture_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

/*Data for the table `f_furniture_detail` */

insert  into `f_furniture_detail`(`furniture_detail_id`,`furniture_detail_contexts`,`furniture_id`) values (9,'颜色:白色',9),(10,'颜色:白色',10),(11,'颜色:绿色',11),(12,'颜色:橙色',12),(13,'颜色:白色',13),(14,'颜色:蓝色',14),(15,'颜色:粉色',15),(16,'颜色:白色',16),(17,'颜色:白色',17),(18,'颜色:白色',18),(19,'颜色:白色',19),(20,'颜色:绿色',20),(21,'颜色:紫色',21),(22,'颜色:灰色',22),(23,'颜色:白色',23),(24,'颜色:白色',24),(25,'颜色:白色',25),(26,'颜色:白色',26),(27,'颜色:灰色',27),(28,'颜色:白色',28),(29,'颜色:白色',29),(30,'颜色:红色',30),(31,'颜色:黑色',31),(32,'颜色:白色',32),(33,'颜色:透明色',33),(34,'颜色:浅蓝色',34),(35,'颜色:黑色',35),(36,'颜色:黄色',36),(37,'颜色:白色',37),(38,'颜色:白色',38),(39,'颜色:白色',39),(40,'颜色:白色',40),(41,'颜色:粉色',41),(42,'颜色:绿色',42),(43,'颜色:白色',43),(44,'颜色:白色',44),(45,'颜色:蓝色',45),(46,'颜色:白色',46),(47,'颜色:白色',47),(48,'颜色:白色',48),(49,'颜色:灰色',49),(50,'颜色:黄色',50),(51,'颜色:白色',51),(52,'颜色:白色',52),(53,'颜色:白色',53),(54,'颜色:白色',54),(55,'颜色:蓝色',55),(56,'颜色:白色',56),(57,'颜色:粉色',57),(58,'颜色:灰色',58),(59,'颜色:白色',59),(60,'颜色:白色',60),(61,'颜色:灰色',61),(62,'颜色:白色',62),(63,'颜色:白色',63),(64,'颜色:橙色',64),(65,'颜色:白色',65),(66,'颜色:白色',66),(67,'颜色:白色',67),(68,'颜色:蓝色',68),(69,'颜色:橙色',69),(70,'颜色:白色',70),(71,'颜色:白色',71),(72,'颜色:白色',72),(73,'颜色:白色',73),(74,'颜色:白色',74),(75,'颜色:白色',75),(76,'颜色:黑色',76),(77,'颜色:白色',77),(78,'颜色:绿色',78),(79,'颜色:黑色',79),(80,'颜色:绿色',80),(81,'颜色:白色',81),(82,'颜色:',82);

/*Table structure for table `f_furniture_inventory` */

DROP TABLE IF EXISTS `f_furniture_inventory`;

CREATE TABLE `f_furniture_inventory` (
  `furniture_inventory_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家具库存表的主键',
  `furniture_cost` double DEFAULT NULL COMMENT '家具的成本',
  `furniture_id` int(11) DEFAULT NULL COMMENT '家具表的外键',
  `furniture_inventory` int(11) DEFAULT NULL COMMENT '家具库存',
  `furniture_price` double DEFAULT NULL COMMENT '家具品的单价',
  `furniture_properties` varchar(255) DEFAULT NULL COMMENT 'property_key:property_value 关联两张表的ID',
  `furniture_weight` double DEFAULT NULL COMMENT '家具的重量',
  PRIMARY KEY (`furniture_inventory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

/*Data for the table `f_furniture_inventory` */

insert  into `f_furniture_inventory`(`furniture_inventory_id`,`furniture_cost`,`furniture_id`,`furniture_inventory`,`furniture_price`,`furniture_properties`,`furniture_weight`) values (9,NULL,9,284,288.8,NULL,NULL),(10,NULL,10,520,452,NULL,NULL),(11,NULL,11,29,288,NULL,NULL),(12,NULL,12,454,69,NULL,NULL),(13,NULL,13,213,59,NULL,NULL),(14,NULL,14,995,88,NULL,NULL),(15,NULL,15,662,88,NULL,NULL),(16,NULL,16,955,65,NULL,NULL),(17,NULL,17,775,40,NULL,NULL),(18,NULL,18,454,56,NULL,NULL),(19,NULL,19,676,33,NULL,NULL),(20,NULL,20,563,23,NULL,NULL),(21,NULL,21,344,68,NULL,NULL),(22,NULL,22,785,230,NULL,NULL),(23,NULL,23,178,138,NULL,NULL),(24,NULL,24,464,100,NULL,NULL),(25,NULL,25,357,234,NULL,NULL),(26,NULL,26,353,156,NULL,NULL),(27,NULL,27,1700,167,NULL,NULL),(28,NULL,28,422,100,NULL,NULL),(29,NULL,29,890,99,NULL,NULL),(30,NULL,30,590,60,NULL,NULL),(31,NULL,31,123,300,NULL,NULL),(32,NULL,32,558,130,NULL,NULL),(33,NULL,33,900,60,NULL,NULL),(34,NULL,34,600,200,NULL,NULL),(35,NULL,35,500,104,NULL,NULL),(36,NULL,36,500,99,NULL,NULL),(37,NULL,37,200,50,NULL,NULL),(38,NULL,38,498,29,NULL,NULL),(39,NULL,39,300,49,NULL,NULL),(40,NULL,40,448,25,NULL,NULL),(41,NULL,41,389,57,NULL,NULL),(42,NULL,42,488,88,NULL,NULL),(43,NULL,43,200,35,NULL,NULL),(44,NULL,44,590,45,NULL,NULL),(45,NULL,45,198,100,NULL,NULL),(46,NULL,46,199,180,NULL,NULL),(47,NULL,47,489,39,NULL,NULL),(48,NULL,48,590,57,NULL,NULL),(49,NULL,49,479,57,NULL,NULL),(50,NULL,50,345,40,NULL,NULL),(51,NULL,51,477,78,NULL,NULL),(52,NULL,52,890,50,NULL,NULL),(53,NULL,53,380,100,NULL,NULL),(54,NULL,54,890,99,NULL,NULL),(55,NULL,55,890,100,NULL,NULL),(56,NULL,56,780,45,NULL,NULL),(57,NULL,57,345,89,NULL,NULL),(58,NULL,58,789,78,NULL,NULL),(59,NULL,59,190,200,NULL,NULL),(60,NULL,60,454,100,NULL,NULL),(61,NULL,61,458,230,NULL,NULL),(62,NULL,62,345,138,NULL,NULL),(63,NULL,63,345,170,NULL,NULL),(64,NULL,64,235,234,NULL,NULL),(65,NULL,65,789,345,NULL,NULL),(66,NULL,66,379,109,NULL,NULL),(67,NULL,67,782,234,NULL,NULL),(68,NULL,68,390,240,NULL,NULL),(69,NULL,69,590,288,NULL,NULL),(70,NULL,70,236,190,NULL,NULL),(71,NULL,71,190,200,NULL,NULL),(72,NULL,72,180,138,NULL,NULL),(73,NULL,73,803,109,NULL,NULL),(74,NULL,74,789,89,NULL,NULL),(75,NULL,75,480,98,NULL,NULL),(76,NULL,76,380,200,NULL,NULL),(77,NULL,77,489,190,NULL,NULL),(78,NULL,78,890,288,NULL,NULL),(79,NULL,79,127,234,NULL,NULL),(80,NULL,80,891,129,NULL,NULL),(81,NULL,81,25,138,NULL,NULL),(82,NULL,82,56,234,NULL,NULL);

/*Table structure for table `f_furniture_property` */

DROP TABLE IF EXISTS `f_furniture_property`;

CREATE TABLE `f_furniture_property` (
  `property_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家具/属性/属性值详情表',
  `furniture_id` int(11) DEFAULT NULL COMMENT '家具表的外键',
  `property_key_id` int(11) DEFAULT NULL COMMENT '家具属性的外键',
  `property_value_id` int(11) DEFAULT NULL COMMENT '家具属性值的外键',
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

/*Data for the table `f_furniture_property` */

insert  into `f_furniture_property`(`property_id`,`furniture_id`,`property_key_id`,`property_value_id`) values (9,9,9,9),(10,10,10,10),(11,11,11,11),(12,12,12,12),(13,13,13,13),(14,14,14,14),(15,15,15,15),(16,16,16,16),(17,17,17,17),(18,18,18,18),(19,19,19,19),(20,20,20,20),(21,21,21,21),(22,22,22,22),(23,23,23,23),(24,24,24,24),(25,25,25,25),(26,26,26,26),(27,27,27,27),(28,28,28,28),(29,29,29,29),(30,30,30,30),(31,31,31,31),(32,32,32,32),(33,33,33,33),(34,34,34,34),(35,35,35,35),(36,36,36,36),(37,37,37,37),(38,38,38,38),(39,39,39,39),(40,40,40,40),(41,41,41,41),(42,42,42,42),(43,43,43,43),(44,44,44,44),(45,45,45,45),(46,46,46,46),(47,47,47,47),(48,48,48,48),(49,49,49,49),(50,50,50,50),(51,51,51,51),(52,52,52,52),(53,53,53,53),(54,54,54,54),(55,55,55,55),(56,56,56,56),(57,57,57,57),(58,58,58,58),(59,59,59,59),(60,60,60,60),(61,61,61,61),(62,62,62,62),(63,63,63,63),(64,64,64,64),(65,65,65,65),(66,66,66,66),(67,67,67,67),(68,68,68,68),(69,69,69,69),(70,70,70,70),(71,71,71,71),(72,72,72,72),(73,73,73,73),(74,74,74,74),(75,75,75,75),(76,76,76,76),(77,77,77,77),(78,78,78,78),(79,79,79,79),(80,80,80,80),(81,81,81,81),(82,82,82,82);

/*Table structure for table `f_furniture_property_key` */

DROP TABLE IF EXISTS `f_furniture_property_key`;

CREATE TABLE `f_furniture_property_key` (
  `property_key_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家具属性详情表的主键',
  `furniture_id` int(11) DEFAULT NULL COMMENT '家具表的外键',
  `property_key_title` varchar(255) DEFAULT NULL COMMENT '例如:颜色 版本 尺寸',
  PRIMARY KEY (`property_key_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

/*Data for the table `f_furniture_property_key` */

insert  into `f_furniture_property_key`(`property_key_id`,`furniture_id`,`property_key_title`) values (9,9,'颜色'),(10,10,'颜色'),(11,11,'颜色'),(12,12,'颜色'),(13,13,'颜色'),(14,14,'颜色'),(15,15,'颜色'),(16,16,'颜色'),(17,17,'颜色'),(18,18,'颜色'),(19,19,'颜色'),(20,20,'颜色'),(21,21,'颜色'),(22,22,'颜色'),(23,23,'颜色'),(24,24,'颜色'),(25,25,'颜色'),(26,26,'颜色'),(27,27,'颜色'),(28,28,'颜色'),(29,29,'颜色'),(30,30,'颜色'),(31,31,'颜色'),(32,32,'颜色'),(33,33,'颜色'),(34,34,'颜色'),(35,35,'颜色'),(36,36,'颜色'),(37,37,'颜色'),(38,38,'颜色'),(39,39,'颜色'),(40,40,'颜色'),(41,41,'颜色'),(42,42,'颜色'),(43,43,'颜色'),(44,44,'颜色'),(45,45,'颜色'),(46,46,'颜色'),(47,47,'颜色'),(48,48,'颜色'),(49,49,'颜色'),(50,50,'颜色'),(51,51,'颜色'),(52,52,'颜色'),(53,53,'颜色'),(54,54,'颜色'),(55,55,'颜色'),(56,56,'颜色'),(57,57,'颜色'),(58,58,'颜色'),(59,59,'颜色'),(60,60,'颜色'),(61,61,'颜色'),(62,62,'颜色'),(63,63,'颜色'),(64,64,'颜色'),(65,65,'颜色'),(66,66,'颜色'),(67,67,'颜色'),(68,68,'颜色'),(69,69,'颜色'),(70,70,'颜色'),(71,71,'颜色'),(72,72,'颜色'),(73,73,'颜色'),(74,74,'颜色'),(75,75,'颜色'),(76,76,'颜色'),(77,77,'颜色'),(78,78,'颜色'),(79,79,'颜色'),(80,80,'颜色'),(81,81,'颜色'),(82,82,'颜色');

/*Table structure for table `f_furniture_property_value` */

DROP TABLE IF EXISTS `f_furniture_property_value`;

CREATE TABLE `f_furniture_property_value` (
  `property_value_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家具属性值详情表的主键',
  `property_key_id` int(11) DEFAULT NULL COMMENT '家具属性的外键',
  `property_value_title` varchar(255) DEFAULT NULL COMMENT '例如:颜色 版本 尺寸',
  PRIMARY KEY (`property_value_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

/*Data for the table `f_furniture_property_value` */

insert  into `f_furniture_property_value`(`property_value_id`,`property_key_id`,`property_value_title`) values (9,9,'白色'),(10,10,'白色'),(11,11,'绿色'),(12,12,'橙色'),(13,13,'白色'),(14,14,'蓝色'),(15,15,'粉色'),(16,16,'白色'),(17,17,'白色'),(18,18,'白色'),(19,19,'白色'),(20,20,'绿色'),(21,21,'紫色'),(22,22,'灰色'),(23,23,'白色'),(24,24,'白色'),(25,25,'白色'),(26,26,'白色'),(27,27,'灰色'),(28,28,'白色'),(29,29,'白色'),(30,30,'红色'),(31,31,'黑色'),(32,32,'白色'),(33,33,'透明色'),(34,34,'浅蓝色'),(35,35,'黑色'),(36,36,'黄色'),(37,37,'白色'),(38,38,'白色'),(39,39,'白色'),(40,40,'白色'),(41,41,'粉色'),(42,42,'绿色'),(43,43,'白色'),(44,44,'白色'),(45,45,'蓝色'),(46,46,'白色'),(47,47,'白色'),(48,48,'白色'),(49,49,'灰色'),(50,50,'黄色'),(51,51,'白色'),(52,52,'白色'),(53,53,'白色'),(54,54,'白色'),(55,55,'蓝色'),(56,56,'白色'),(57,57,'粉色'),(58,58,'灰色'),(59,59,'白色'),(60,60,'白色'),(61,61,'灰色'),(62,62,'白色'),(63,63,'白色'),(64,64,'橙色'),(65,65,'白色'),(66,66,'白色'),(67,67,'白色'),(68,68,'蓝色'),(69,69,'橙色'),(70,70,'白色'),(71,71,'白色'),(72,72,'白色'),(73,73,'白色'),(74,74,'白色'),(75,75,'白色'),(76,76,'黑色'),(77,77,'白色'),(78,78,'绿色'),(79,79,'黑色'),(80,80,'绿色'),(81,81,'白色'),(82,82,'');

/*Table structure for table `f_furniture_small_image` */

DROP TABLE IF EXISTS `f_furniture_small_image`;

CREATE TABLE `f_furniture_small_image` (
  `small_image_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '家具图片表的主键',
  `furniture_id` int(11) DEFAULT NULL COMMENT '家具表的外键',
  `img_add_time` datetime DEFAULT NULL COMMENT '图片添加时间',
  `img_size` int(11) DEFAULT NULL COMMENT '图片大小',
  `small_image_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `small_img_url` varchar(255) DEFAULT NULL COMMENT '家具小图',
  PRIMARY KEY (`small_image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=316 DEFAULT CHARSET=utf8;

/*Data for the table `f_furniture_small_image` */

insert  into `f_furniture_small_image`(`small_image_id`,`furniture_id`,`img_add_time`,`img_size`,`small_image_name`,`small_img_url`) values (26,9,'2022-07-29 01:51:07',NULL,NULL,'smalla5GbIfUVEa2G3I22FbWa.jpg'),(27,9,'2022-07-29 01:51:07',NULL,NULL,'smallHHWxcIddfdEvv3Ub0Hfv.jpg'),(28,9,'2022-07-29 01:51:07',NULL,NULL,'smallAHZeHFWH5aUAeZvY2WET.jpg'),(29,10,'2022-07-29 02:22:46',NULL,NULL,'smallzGTfY5XzTFceGA2fYXYV.jpg'),(30,10,'2022-07-29 02:22:46',NULL,NULL,'small1VVWvFHa55G5dVAeA1xx.jpg'),(31,10,'2022-07-29 02:22:46',NULL,NULL,'smallVXzTVxXG5UfaEIy5W5Fe.jpg'),(32,10,'2022-07-29 02:22:46',NULL,NULL,'smallb55vv1AZ0yycIGa31Wy0.jpg'),(33,11,'2022-07-29 02:24:34',NULL,NULL,'smalldfWZbVYfTZ21X51xdZFV.jpg'),(34,11,'2022-07-29 02:24:34',NULL,NULL,'smallYbEE3TXZzZ3f3zIaz1vT.jpg'),(35,11,'2022-07-29 02:24:34',NULL,NULL,'smalleewvH4xUA5wGv1yIxVIw.jpg'),(36,11,'2022-07-29 02:24:34',NULL,NULL,'smally5wdUzTdFTUzc5vF3yHa.jpg'),(37,12,'2022-07-29 02:31:01',NULL,NULL,'smallTUaXWfbUcE2ZAbbVH1IH.jpg'),(38,12,'2022-07-29 02:31:01',NULL,NULL,'smalladeVyyTvEGzUIcfeUvA5.jpg'),(39,12,'2022-07-29 02:31:01',NULL,NULL,'small1aUxYAIXaUfxy0WGYdyx.jpg'),(40,12,'2022-07-29 02:31:01',NULL,NULL,'smallXfwzTA3TFF2Y5TdZGAdZ.jpg'),(41,13,'2022-07-29 02:35:31',NULL,NULL,'smallVd24TzFfeYXd4zca30fT.jpg'),(42,13,'2022-07-29 02:35:31',NULL,NULL,'smallaXvv04w34b11XFvEbX10.jpg'),(43,13,'2022-07-29 02:35:31',NULL,NULL,'small0FU1W2EAEfVbaZ0IAyVF.jpg'),(44,13,'2022-07-29 02:35:31',NULL,NULL,'smallyTUzaaXdIwUEdVYZF4y2.jpg'),(45,14,'2022-07-29 02:38:39',NULL,NULL,'smallxaYfWdE2FA33wzUAIZXd.jpg'),(46,14,'2022-07-29 02:38:39',NULL,NULL,'small3YAxdAeUTdyZw4UXX3EI.jpg'),(47,14,'2022-07-29 02:38:39',NULL,NULL,'smallYU03UvA3FHbVGZwabTX4.jpg'),(48,14,'2022-07-29 02:38:39',NULL,NULL,'smallbZ1IHecVyaVcUcAVbGdw.jpg'),(49,15,'2022-07-29 02:40:15',NULL,NULL,'small2IAdT15ZH0EzF21zZcTA.jpg'),(50,15,'2022-07-29 02:40:15',NULL,NULL,'smallf2UEyyY4GwEf5HWIE1cb.jpg'),(51,15,'2022-07-29 02:40:15',NULL,NULL,'smallGaf0dV10vUaxXbyY5ac1.jpg'),(52,15,'2022-07-29 02:40:15',NULL,NULL,'smallc0vecebU4z2AexXe3F4w.jpg'),(53,16,'2022-07-29 02:41:21',NULL,NULL,'smallbcTATZIxfYdaUcG3THYF.jpg'),(54,16,'2022-07-29 02:41:21',NULL,NULL,'smallE1fGTaHTwGaHGF25cv4w.jpg'),(55,16,'2022-07-29 02:41:21',NULL,NULL,'smallFyTXGXcXfFdGUeaEEWHc.jpg'),(56,16,'2022-07-29 02:41:21',NULL,NULL,'smallI5YWWAeAH2fAXUVwaX1d.jpg'),(57,17,'2022-07-29 02:45:19',NULL,NULL,'smallwd5F4U2UUcGAWzexd1Yv.jpg'),(58,17,'2022-07-29 02:45:19',NULL,NULL,'smallH4w3TEcIzwbcf1wz0Yx2.jpg'),(59,17,'2022-07-29 02:45:19',NULL,NULL,'smallZcFzvbbF5UF1GdZeGbY5.jpg'),(60,17,'2022-07-29 02:45:19',NULL,NULL,'smallxb1cXUy2w5a4YXzA025X.png'),(61,18,'2022-07-29 02:46:10',NULL,NULL,'smallUTbf3TIac2VUYxVzvG11.jpg'),(62,18,'2022-07-29 02:46:10',NULL,NULL,'smallAY00HwUAvyUv02f3Vfyy.jpg'),(63,18,'2022-07-29 02:46:10',NULL,NULL,'small00fcAF0efF31HfeUHWIA.jpg'),(64,18,'2022-07-29 02:46:10',NULL,NULL,'smallAZHY23H32HwTHyXVy4vU.jpg'),(65,19,'2022-07-29 02:47:26',NULL,NULL,'small4w2GWbwZ3WUY5FUvw00f.jpg'),(66,19,'2022-07-29 02:47:26',NULL,NULL,'smallGHHWfWUfwTYWzTx04Yxa.jpg'),(67,19,'2022-07-29 02:47:26',NULL,NULL,'small2cfIeyd2xTITdFa3YFEZ.jpg'),(68,19,'2022-07-29 02:47:26',NULL,NULL,'smallZV2cvVzIEcf2H135I2fF.jpg'),(69,20,'2022-07-29 02:48:24',NULL,NULL,'smallTx2fawVwE1AbvYZIZUez.jpg'),(70,20,'2022-07-29 02:48:24',NULL,NULL,'smallVXda4eYT5W3fAE13dv4e.jpg'),(71,20,'2022-07-29 02:48:24',NULL,NULL,'smallU1XEzaTzZfwH4x2TafYY.jpg'),(72,20,'2022-07-29 02:48:24',NULL,NULL,'smallGTcYbU4E0IFafddEeH5G.jpg'),(73,21,'2022-07-29 02:52:06',NULL,NULL,'small2EIEv4AcUHAF5zG5cG2T.jpg'),(74,21,'2022-07-29 02:52:06',NULL,NULL,'smallvYdbvH2IHUcFy3a23xGc.jpg'),(75,21,'2022-07-29 02:52:06',NULL,NULL,'smally3TAYXIEx4UIF5EEdXTW.jpg'),(76,21,'2022-07-29 02:52:06',NULL,NULL,'smallZxH12eG0fWTYZeWyxHyI.jpg'),(77,22,'2022-07-29 02:54:30',NULL,NULL,'smallUaWZbWe0bH00cevbcbwX.jpg'),(78,22,'2022-07-29 02:54:30',NULL,NULL,'smallExdUTI0eX4H3FwFUZ1zA.jpg'),(79,22,'2022-07-29 02:54:30',NULL,NULL,'smallv5HWwzUbvTzddy41vbXV.jpg'),(80,22,'2022-07-29 02:54:30',NULL,NULL,'smallZdFwcv22yvXcYYVGyZvw.jpg'),(81,23,'2022-07-29 02:55:17',NULL,NULL,'smallYy5e0A5z2fAa3Ac3Fybd.jpg'),(82,23,'2022-07-29 02:55:17',NULL,NULL,'smallaYzy2XH1d040c1zFv1vF.jpg'),(83,23,'2022-07-29 02:55:17',NULL,NULL,'smallYAZGaEdEZZEGU0Hdb4v0.jpg'),(84,23,'2022-07-29 02:55:17',NULL,NULL,'smallb0EZEF25YZcGGb0HZbaY.jpg'),(85,24,'2022-07-29 02:56:03',NULL,NULL,'smallyvV0edaxT01V40bx3vxb.jpg'),(86,24,'2022-07-29 02:56:03',NULL,NULL,'smallbEYbIffZdxdW2TXbyA0V.jpg'),(87,24,'2022-07-29 02:56:03',NULL,NULL,'smalldHe41UFYceYvwAawwwxT.jpg'),(88,24,'2022-07-29 02:56:03',NULL,NULL,'small1dH3aVA401c1I4cdZYyE.jpg'),(89,25,'2022-07-29 02:56:53',NULL,NULL,'smallz3dWd0aE32z5bvEdzWIA.jpg'),(90,25,'2022-07-29 02:56:53',NULL,NULL,'smallFfUAewfxbdbeZGV0X5XE.jpg'),(91,25,'2022-07-29 02:56:53',NULL,NULL,'smallw0XwIEVcvw20bGvzvG0Z.jpg'),(92,25,'2022-07-29 02:56:53',NULL,NULL,'small2HZGbUYZTzFUf24a1wxA.jpg'),(93,26,'2022-07-29 02:57:43',NULL,NULL,'smallUEVeYz3bUcfvewY3ezyV.jpg'),(94,26,'2022-07-29 02:57:43',NULL,NULL,'small1eVFcU3X034fHW1FIZHH.jpg'),(95,26,'2022-07-29 02:57:43',NULL,NULL,'smallb2I0Yd15eeWIG0d0YAf3.jpg'),(96,26,'2022-07-29 02:57:43',NULL,NULL,'smallXxdYeZevwA2vA3d0cxYb.jpg'),(97,27,'2022-07-29 02:58:52',NULL,NULL,'smallc15evd4Ybv1vFczeHv4F.jpg'),(98,27,'2022-07-29 02:58:52',NULL,NULL,'smallEz3ZXEFwF4dTb5G4HTyE.jpg'),(99,27,'2022-07-29 02:58:52',NULL,NULL,'smallF00cz0UadavUYTxAEUeH.jpg'),(100,27,'2022-07-29 02:58:52',NULL,NULL,'smallF3xXxZ433UYxFyExHHIX.jpg'),(101,28,'2022-07-29 02:59:39',NULL,NULL,'smallH0GxA405aebGVVvAe223.jpg'),(102,28,'2022-07-29 02:59:39',NULL,NULL,'smallefaAdXdwxcFzE1T2yyfF.jpg'),(103,28,'2022-07-29 02:59:39',NULL,NULL,'small1aTAHb43cZbEHwy1dY3f.jpg'),(104,28,'2022-07-29 02:59:39',NULL,NULL,'small5GXzG1Va3GcTdGxex40Y.jpg'),(105,29,'2022-07-29 03:00:35',NULL,NULL,'smallG3FIUbbF4GXVz4f4a00b.jpg'),(106,29,'2022-07-29 03:00:35',NULL,NULL,'small2xGTcZ1Id0dYIvF140cx.jpg'),(107,29,'2022-07-29 03:00:35',NULL,NULL,'smallUffzWdYHwAzacwyTYf34.jpg'),(108,29,'2022-07-29 03:00:35',NULL,NULL,'smallbGwcafb132GzbyGzfIGz.jpg'),(109,31,'2022-07-29 03:04:29',NULL,NULL,'smallE2FayFyVya3WwxfFZ4zX.jpg'),(110,31,'2022-07-29 03:04:29',NULL,NULL,'small0YW3W5bFT5w0xfYvfIwF.jpg'),(111,31,'2022-07-29 03:04:29',NULL,NULL,'smallIevvA13UHc5FzyAzIXyd.jpg'),(112,31,'2022-07-29 03:04:29',NULL,NULL,'smallcwbAVyIeHH5vwXWxYwZY.jpg'),(113,32,'2022-07-29 03:05:15',NULL,NULL,'smalleXFHbGZ1TEHGGIZxxTHc.jpg'),(114,32,'2022-07-29 03:05:15',NULL,NULL,'smallF3EIyYd4xZYWaGEVvc4a.jpg'),(115,32,'2022-07-29 03:05:15',NULL,NULL,'smallUbbyGzI25y04fEyczfXA.jpg'),(116,32,'2022-07-29 03:05:15',NULL,NULL,'smallc5zX0ad2zWHVATEEy2fF.jpg'),(117,33,'2022-07-29 03:06:08',NULL,NULL,'small5dTxA2IIUac1FeZcT4fZ.jpg'),(118,33,'2022-07-29 03:06:08',NULL,NULL,'small5wXFwX0U2Ewb5TfXVzZ3.jpg'),(119,33,'2022-07-29 03:06:08',NULL,NULL,'smallwf202dvzz1aIX2G0V10H.jpg'),(120,33,'2022-07-29 03:06:08',NULL,NULL,'smallaW133W0wG35Hz05cW3Td.jpg'),(121,34,'2022-07-29 03:07:09',NULL,NULL,'smallx44deEdU1UWced250vwG.jpg'),(122,34,'2022-07-29 03:07:09',NULL,NULL,'smallcHHWTvT0GxY5bFz2W22w.jpg'),(123,34,'2022-07-29 03:07:09',NULL,NULL,'smallxbAIIcyy3I04dbdfe4ZT.jpg'),(124,34,'2022-07-29 03:07:09',NULL,NULL,'small4EYAyfevZ4EzUWHZTa32.jpg'),(125,35,'2022-07-29 03:08:35',NULL,NULL,'small4w5dyWX2FeawEVH3va4w.jpg'),(126,35,'2022-07-29 03:08:35',NULL,NULL,'smallA4e0aTEH0UE43WHbxawX.jpg'),(127,35,'2022-07-29 03:08:35',NULL,NULL,'smallcXFdYaZwzAHGUIIEVWGx.jpg'),(128,36,'2022-07-29 03:10:24',NULL,NULL,'smalldwY3UH5bfY12zaXvXE2e.jpg'),(129,36,'2022-07-29 03:10:24',NULL,NULL,'small3fI1vETXxYaccIcAWZv2.jpg'),(130,36,'2022-07-29 03:10:24',NULL,NULL,'smallAUY0VZVWEEcTzyXbxx3A.jpg'),(131,36,'2022-07-29 03:10:24',NULL,NULL,'smallGwwA533eFE33fwTWedYe.jpg'),(132,37,'2022-07-29 03:11:17',NULL,NULL,'smallIbFfEEfITFvXIGwe4bTI.jpg'),(133,37,'2022-07-29 03:11:17',NULL,NULL,'smalldZfddbGY22G1Ha33AwU3.jpg'),(134,37,'2022-07-29 03:11:17',NULL,NULL,'smallfwZ2IbUEb12VfGFXxXzf.jpg'),(135,37,'2022-07-29 03:11:17',NULL,NULL,'smallW4e1XZ1Y15AFzXA41053.jpg'),(136,38,'2022-07-29 03:12:04',NULL,NULL,'small3VedUvfbAWHHyZzEazZw.jpg'),(137,38,'2022-07-29 03:12:04',NULL,NULL,'smallv0UEIwT4VYfWVY1T5XYd.jpg'),(138,38,'2022-07-29 03:12:04',NULL,NULL,'smallH4IwF2bZHYZ5FezY3aXE.jpg'),(139,38,'2022-07-29 03:12:04',NULL,NULL,'smallz2bI5532X3V51Udfv31x.jpg'),(140,39,'2022-07-29 03:13:07',NULL,NULL,'smallEwcUwWIcayGdAaazEfII.jpg'),(141,39,'2022-07-29 03:13:07',NULL,NULL,'smallxb1x50XFAGUzHAF2bvXU.jpg'),(142,39,'2022-07-29 03:13:07',NULL,NULL,'smallz1FZYU1AxxT3124yE1HV.jpg'),(143,39,'2022-07-29 03:13:07',NULL,NULL,'small2HEf4yfHabHAEUUd1V5T.jpg'),(144,40,'2022-07-29 03:13:48',NULL,NULL,'smallaYc0Y2fw0XVYUvZVy1x1.jpg'),(145,40,'2022-07-29 03:13:48',NULL,NULL,'small0eEWf315eWFaavv13a5X.jpg'),(146,40,'2022-07-29 03:13:48',NULL,NULL,'smallxaF2YIYwwv5yXWTyyZdY.jpg'),(147,40,'2022-07-29 03:13:48',NULL,NULL,'small0zdwxxzvzAZAz3cTeHZc.jpg'),(148,41,'2022-07-29 03:14:37',NULL,NULL,'smallXavVfz5FH3F1H2wvVxxA.jpg'),(149,41,'2022-07-29 03:14:37',NULL,NULL,'small1ZXxTvWIVd0TeFwabHZ2.jpg'),(150,41,'2022-07-29 03:14:37',NULL,NULL,'smallFYTZZHIcZevG2yHfcEzw.jpg'),(151,41,'2022-07-29 03:14:37',NULL,NULL,'smallVyTeEYxyIfZyEG5T1ace.jpg'),(152,42,'2022-07-29 03:15:21',NULL,NULL,'smallYY3wvTyaI5z1zdv21vaz.jpg'),(153,42,'2022-07-29 03:15:21',NULL,NULL,'smallvT25TVvx323AYHx5bWzU.jpg'),(154,42,'2022-07-29 03:15:21',NULL,NULL,'smallHIcazfZTWUY0VvzVZWze.jpg'),(155,42,'2022-07-29 03:15:21',NULL,NULL,'smallX0zbeTfEd2bfG3zadVcV.jpg'),(156,43,'2022-07-29 03:16:09',NULL,NULL,'smallvbG4FA55TzxbX2Yb3GY5.jpg'),(157,43,'2022-07-29 03:16:09',NULL,NULL,'smallx40ZewfzvW0VEwWaeAA0.jpg'),(158,43,'2022-07-29 03:16:09',NULL,NULL,'smallGTVXz4vET3wyU0T0z0X3.jpg'),(159,43,'2022-07-29 03:16:09',NULL,NULL,'smallZHUAz25WXGA0Z4TyAEAY.jpg'),(160,44,'2022-07-29 03:16:52',NULL,NULL,'smallcAEzF120Tc2vVaa20b2Z.jpg'),(161,44,'2022-07-29 03:16:52',NULL,NULL,'smallEcd32VcdITY4x1010dYY.jpg'),(162,44,'2022-07-29 03:16:52',NULL,NULL,'smalldTcAwaUUHZ0Tb3VfHAxI.jpg'),(163,44,'2022-07-29 03:16:52',NULL,NULL,'small1IT51T1zTYZw51IFUUwf.jpg'),(164,45,'2022-07-29 03:17:42',NULL,NULL,'smallZ2fG03FUfdTGUaYXdFdx.jpg'),(165,45,'2022-07-29 03:17:42',NULL,NULL,'smallTXb4YTIVGXaWxEAccdyv.jpg'),(166,45,'2022-07-29 03:17:42',NULL,NULL,'smallGyE0c5WTZ2YAXaGU2Eew.jpg'),(167,45,'2022-07-29 03:17:42',NULL,NULL,'smallYIzAaZWvG53XcbV0WcwX.jpg'),(168,46,'2022-07-29 03:19:04',NULL,NULL,'smallX5cF00Izv3bwVx0Ib1VH.jpg'),(169,46,'2022-07-29 03:19:04',NULL,NULL,'smallwZ2cUGeZdH25d0fHa4XF.jpg'),(170,46,'2022-07-29 03:19:04',NULL,NULL,'smallHzwXIxZGIf0xyx2eWwx0.jpg'),(171,46,'2022-07-29 03:19:04',NULL,NULL,'smallcAXGd5ye1Hwdx2ea4WUv.jpg'),(172,47,'2022-07-29 03:19:58',NULL,NULL,'small2T0YveW5wW1yzfWUfd0x.gif'),(173,47,'2022-07-29 03:19:58',NULL,NULL,'smallzfaffGAYfvdZaz1E3yHd.jpg'),(174,47,'2022-07-29 03:19:58',NULL,NULL,'smallbv1wccZ5GGHTy34Y04Ia.jpg'),(175,47,'2022-07-29 03:19:58',NULL,NULL,'smallGyI2bVYAyIHwwwUU4vcX.jpg'),(176,48,'2022-07-29 03:20:40',NULL,NULL,'smallbeEZ4IGT0IFyG5ATHbTA.jpg'),(177,48,'2022-07-29 03:20:40',NULL,NULL,'smallZvTIUF3zzfHIHXveU0Ad.jpg'),(178,48,'2022-07-29 03:20:40',NULL,NULL,'smalleVAdfA0cc3IvAvXaYHfc.jpg'),(179,48,'2022-07-29 03:20:40',NULL,NULL,'smallbIHEvwTzd4Z51Z05EGHA.jpg'),(180,49,'2022-07-29 03:21:26',NULL,NULL,'smallXvUwvzx31fzyZ4G1xGYT.jpg'),(181,49,'2022-07-29 03:21:26',NULL,NULL,'smallZzW5Gy3ZH0wvvAFUIA3v.jpg'),(182,49,'2022-07-29 03:21:26',NULL,NULL,'smallXIXyzAGYf4A5A0UaUGZa.jpg'),(183,49,'2022-07-29 03:21:26',NULL,NULL,'small0W1Ebd0axVVwYUwceG3U.jpg'),(184,50,'2022-07-29 03:22:20',NULL,NULL,'smallcf5zyUc1aZWETcyb4b2e.jpg'),(185,50,'2022-07-29 03:22:20',NULL,NULL,'smallXe3fbYYvTxw3yTbv5bvV.jpg'),(186,50,'2022-07-29 03:22:20',NULL,NULL,'smallWvVydzzdXFHIXIYU23aa.jpg'),(187,50,'2022-07-29 03:22:20',NULL,NULL,'smalleXv3H50cefcxzIFffb54.jpg'),(188,51,'2022-07-29 03:23:02',NULL,NULL,'smallyVYVYaVyy4fZvcYZz40X.jpg'),(189,51,'2022-07-29 03:23:02',NULL,NULL,'small141vEdEb32a2ZawTay0b.jpg'),(190,51,'2022-07-29 03:23:02',NULL,NULL,'small4e543AH5fyH2yH1zWUfA.jpg'),(191,51,'2022-07-29 03:23:02',NULL,NULL,'smallAb31zYe5FUbyHvfEWyIY.jpg'),(192,52,'2022-07-29 03:23:47',NULL,NULL,'smallFTzXcW4AYEH5wffwVvAc.jpg'),(193,52,'2022-07-29 03:23:47',NULL,NULL,'small0yeUWHeA0TdAayF3ZdV4.jpg'),(194,52,'2022-07-29 03:23:47',NULL,NULL,'smallYXGbETEVXw0XfeGxzIFw.jpg'),(195,52,'2022-07-29 03:23:47',NULL,NULL,'smalld1Hx11T322Gz3FXIUdF3.jpg'),(196,53,'2022-07-29 03:24:35',NULL,NULL,'smallxX5FUYAIW3HAec3xF5fU.jpg'),(197,53,'2022-07-29 03:24:35',NULL,NULL,'small1GxaVaW4bWbVVfcTI5z1.jpg'),(198,53,'2022-07-29 03:24:35',NULL,NULL,'smallaGWTHEVvEZb4A35GXbIf.jpg'),(199,53,'2022-07-29 03:24:35',NULL,NULL,'smallv1zdza2vUeeV1UYzd0I3.jpg'),(200,54,'2022-07-29 03:25:27',NULL,NULL,'smallXz4TXza1vvF04wyvbWvF.jpg'),(201,54,'2022-07-29 03:25:27',NULL,NULL,'smallb32IIdbZWe3x50yGUX0a.jpg'),(202,54,'2022-07-29 03:25:27',NULL,NULL,'small0ebAZwx04E2TeVA5yzTb.jpg'),(203,54,'2022-07-29 03:25:27',NULL,NULL,'smallcxIIUGVYeGadey5342wb.jpg'),(204,55,'2022-07-29 03:26:13',NULL,NULL,'smallzzFa2Hyya2WXeH5eeaIE.jpg'),(205,55,'2022-07-29 03:26:13',NULL,NULL,'small0fAGbbaTa5AyY42wfIYa.jpg'),(206,55,'2022-07-29 03:26:13',NULL,NULL,'small0023X0XxW1wFA1ba1ebY.jpg'),(207,55,'2022-07-29 03:26:13',NULL,NULL,'smallWH5cUTydXecZFfIbwVcx.jpg'),(208,56,'2022-07-29 03:27:06',NULL,NULL,'smalleZwvHWYAXTEdFfFeZXvH.jpg'),(209,56,'2022-07-29 03:27:06',NULL,NULL,'smallb3abdfG1EV5Ixb1aVAX5.jpg'),(210,56,'2022-07-29 03:27:06',NULL,NULL,'smalldcwTGyWVxxAXHAE4Y2A3.jpg'),(211,56,'2022-07-29 03:27:06',NULL,NULL,'smallAVWvaEIU1A5HwVweWcez.jpg'),(212,57,'2022-07-29 03:27:51',NULL,NULL,'smallcUcGExzYdc50adGIdayW.jpg'),(213,57,'2022-07-29 03:27:51',NULL,NULL,'smallfEdfXTvaHIf5ZVG2e2e4.jpg'),(214,57,'2022-07-29 03:27:51',NULL,NULL,'smalldUwYaHdFAv5aEI5aXF3F.jpg'),(215,57,'2022-07-29 03:27:51',NULL,NULL,'smalldIcd2vXTy4yFZd34ZI4V.jpg'),(216,58,'2022-07-29 03:28:58',NULL,NULL,'smallZzxd2A42bUxv20Y4FyXZ.jpg'),(217,58,'2022-07-29 03:28:58',NULL,NULL,'smallyW4yXAxvYxV3fIzA1Ww3.jpg'),(218,58,'2022-07-29 03:28:58',NULL,NULL,'small0c3yfwx2zexae4xA33yZ.jpg'),(219,58,'2022-07-29 03:28:58',NULL,NULL,'smallxA11yFz2vwE0YXbIVFEa.jpg'),(220,59,'2022-07-29 03:31:29',NULL,NULL,'smallYIfy1XUUx5f1Ex415xzT.jpg'),(221,59,'2022-07-29 03:31:29',NULL,NULL,'smallF3zTGWYUxzwbxYIvf3zF.jpg'),(222,59,'2022-07-29 03:31:29',NULL,NULL,'smallywyYE5bVTT5HzxcXd3AT.jpg'),(223,59,'2022-07-29 03:31:29',NULL,NULL,'small12d21be4ab1wEE5E0V4a.jpg'),(224,60,'2022-07-29 03:32:16',NULL,NULL,'small0vTaXdxEGVUFwZIIbaEV.jpg'),(225,60,'2022-07-29 03:32:16',NULL,NULL,'small2ZUfXFA2xZvEFG1F4FI2.jpg'),(226,60,'2022-07-29 03:32:16',NULL,NULL,'smallXwUVwwHIYwA3HFcbTEXE.jpg'),(227,60,'2022-07-29 03:32:16',NULL,NULL,'smallAHH1HefwzbbVbbHfwcyI.jpg'),(228,61,'2022-07-29 03:32:57',NULL,NULL,'smallWyYI2dyUwAzZZ0ET2EyY.jpg'),(229,61,'2022-07-29 03:32:57',NULL,NULL,'smallIZ33F1EzGTfUEx40yGc0.jpg'),(230,61,'2022-07-29 03:32:57',NULL,NULL,'smallyyeGHbfczWGdWTAaxGze.jpg'),(231,61,'2022-07-29 03:32:57',NULL,NULL,'smallWH5W3G4AzGYfWVvfWb5w.jpg'),(232,62,'2022-07-29 03:33:46',NULL,NULL,'smallEZIGUVI503dUwvxwFYee.jpg'),(233,62,'2022-07-29 03:33:46',NULL,NULL,'smallwFVE21GvHFGHEWXAfT1Z.jpg'),(234,62,'2022-07-29 03:33:46',NULL,NULL,'smalleTZWYdVA3IccIaw5Ve5F.jpg'),(235,62,'2022-07-29 03:33:46',NULL,NULL,'smallAfXHczEIe4aeaacdxEed.jpg'),(236,63,'2022-07-29 03:34:36',NULL,NULL,'smallHTVTUHHfcE14bXUGcbW2.jpg'),(237,63,'2022-07-29 03:34:36',NULL,NULL,'small2fZxe4bGTET3wExFZec1.jpg'),(238,63,'2022-07-29 03:34:36',NULL,NULL,'smallXaY3IvYATxZ0Ta0vUGV1.jpg'),(239,63,'2022-07-29 03:34:36',NULL,NULL,'smallYFXYw2G4z0GcEA5ya0F1.jpg'),(240,64,'2022-07-29 03:35:18',NULL,NULL,'smallc14cVebwEbAGWvEYWyIz.jpg'),(241,64,'2022-07-29 03:35:18',NULL,NULL,'smallVEXvwWxd3FbvEUFf4dH2.jpg'),(242,64,'2022-07-29 03:35:18',NULL,NULL,'smallVI1w4Y0IzTZ4vTZxcUAG.jpg'),(243,64,'2022-07-29 03:35:18',NULL,NULL,'smallG5I5AZ3abawaXUU3Yv4c.jpg'),(244,65,'2022-07-29 03:36:01',NULL,NULL,'smallA0AUxbyZafxY33UWAY10.jpg'),(245,65,'2022-07-29 03:36:01',NULL,NULL,'smalle10adY5dwHGZx202eHwI.jpg'),(246,65,'2022-07-29 03:36:01',NULL,NULL,'smallc2IFVEWzbVFA5Yx3xy2b.jpg'),(247,65,'2022-07-29 03:36:01',NULL,NULL,'smallGVIeveY1vEVAFVZHZ5XZ.jpg'),(248,66,'2022-07-29 03:36:43',NULL,NULL,'smallevw1ZYda0eFAyvczZTWa.jpg'),(249,66,'2022-07-29 03:36:43',NULL,NULL,'smallfvUdYZIv5GYEX0YYaFcG.jpg'),(250,66,'2022-07-29 03:36:43',NULL,NULL,'smallI1e3bw51xdeVvdzEyzIw.jpg'),(251,66,'2022-07-29 03:36:43',NULL,NULL,'smallEYbevAUzaz2Efv4dFEf0.jpg'),(252,67,'2022-07-29 03:37:26',NULL,NULL,'smallX32aUb153d0V2F11xd4F.jpg'),(253,67,'2022-07-29 03:37:26',NULL,NULL,'small1ZAIFwYH0eHV2yYbfcWw.jpg'),(254,67,'2022-07-29 03:37:26',NULL,NULL,'smallv5Wdax42Vfy2vwyeIyvI.jpg'),(255,67,'2022-07-29 03:37:26',NULL,NULL,'smallI5WFEZwcywxHvVZyGHfG.jpg'),(256,68,'2022-07-29 03:38:26',NULL,NULL,'smallwfIYvUf1aVYEIZ0b2HzH.jpg'),(257,68,'2022-07-29 03:38:26',NULL,NULL,'smallI3Ue4eybTcy3bEdwxzvd.jpg'),(258,68,'2022-07-29 03:38:26',NULL,NULL,'small5IefAAXxbwTzf4wy1Ga2.jpg'),(259,68,'2022-07-29 03:38:26',NULL,NULL,'smallcE11ZHyUze5EXYcdwHya.jpg'),(260,69,'2022-07-29 03:39:11',NULL,NULL,'small0EX3xa1bwbwyX1E5HwGf.jpg'),(261,69,'2022-07-29 03:39:11',NULL,NULL,'small0EZxXFVcFTAbUvT52aUv.jpg'),(262,69,'2022-07-29 03:39:11',NULL,NULL,'small3EUXAaA134VdIWeIy4vf.jpg'),(263,69,'2022-07-29 03:39:11',NULL,NULL,'smallywEH1V4fFyxzdAF2Ad42.jpg'),(264,70,'2022-07-29 03:40:46',NULL,NULL,'smallf5Y3fTV4d2TxzwZaT3F2.jpg'),(265,70,'2022-07-29 03:40:46',NULL,NULL,'smallZwdIWXxFF043eY0AyTdE.jpg'),(266,70,'2022-07-29 03:40:46',NULL,NULL,'smallf55XybGZ52YdHXXeaYfX.jpg'),(267,70,'2022-07-29 03:40:46',NULL,NULL,'smallxATZfGycVvdawI1fF13V.png'),(268,71,'2022-07-29 03:41:33',NULL,NULL,'small1yTyYGzvfH5xEaUaIdY0.jpg'),(269,71,'2022-07-29 03:41:33',NULL,NULL,'smallTTf5YWb41TGFAdXAvV3I.jpg'),(270,71,'2022-07-29 03:41:33',NULL,NULL,'smallec5UfXIbATb2XfUcIUdZ.jpg'),(271,71,'2022-07-29 03:41:33',NULL,NULL,'small5xcb1IGaIbEVTeTzVzxd.jpg'),(272,72,'2022-07-29 03:42:21',NULL,NULL,'smallFUHfaf5IYd0v3H0VGzvc.jpg'),(273,72,'2022-07-29 03:42:21',NULL,NULL,'smallVI31FexUx5aAzZVHdEA0.jpg'),(274,72,'2022-07-29 03:42:21',NULL,NULL,'smallayY21fTcU0x5vaE3dIE0.jpg'),(275,72,'2022-07-29 03:42:21',NULL,NULL,'smallefGZGdXwYZ2xx4WWVfwb.png'),(276,73,'2022-07-29 03:43:07',NULL,NULL,'smally3Z3vaeGfez3V5FA3aTc.jpg'),(277,73,'2022-07-29 03:43:07',NULL,NULL,'smallaz4TAW5Z00YTF1G0WVWy.jpg'),(278,73,'2022-07-29 03:43:07',NULL,NULL,'smallcZzadY14dGAwIcVUd3Hv.jpg'),(279,73,'2022-07-29 03:43:07',NULL,NULL,'smallZxTxW4aUeAY2ZZzFT40T.jpg'),(280,74,'2022-07-29 03:43:56',NULL,NULL,'smallIHWafU3FcV23c2YGy3TZ.jpg'),(281,74,'2022-07-29 03:43:56',NULL,NULL,'smalle03EcG0HI0XWUzT5A4x3.jpg'),(282,74,'2022-07-29 03:43:56',NULL,NULL,'smallzV5w3TEEwFxE41yveWbF.jpg'),(283,74,'2022-07-29 03:43:56',NULL,NULL,'smallIT4YTTGVAYaxVf1zTV11.jpg'),(284,75,'2022-07-29 03:44:44',NULL,NULL,'smallUFcf5T2HXvdITa3IEAGe.jpg'),(285,75,'2022-07-29 03:44:44',NULL,NULL,'smallXEezT5Vxv4VAd5HF2UHW.jpg'),(286,75,'2022-07-29 03:44:44',NULL,NULL,'smallIv0bUv5ZbVY2Gvw0aZ4G.jpg'),(287,75,'2022-07-29 03:44:44',NULL,NULL,'small1XUycTId4YYw5wv23V5c.jpg'),(288,76,'2022-07-29 03:45:43',NULL,NULL,'smallvGVbw25XYz5cHfzcz5VZ.jpg'),(289,76,'2022-07-29 03:45:43',NULL,NULL,'smallE0Gd5v01Aeb3EZUv1I2b.jpg'),(290,76,'2022-07-29 03:45:43',NULL,NULL,'smallwA5Xe5AaaY5wZvxeHAfF.jpg'),(291,76,'2022-07-29 03:45:43',NULL,NULL,'small0GXy321af23FXEA1yF43.jpg'),(292,77,'2022-07-29 03:46:44',NULL,NULL,'small1Wf1HYav0zHE4Evx1Uv4.jpg'),(293,77,'2022-07-29 03:46:44',NULL,NULL,'smalle2I005TTHUybYYTzxfyd.jpg'),(294,77,'2022-07-29 03:46:44',NULL,NULL,'smallFy4EAE0WTAVwHYHIF1eE.jpg'),(295,77,'2022-07-29 03:46:44',NULL,NULL,'smallbvV0a201eUFId2xIU4GG.jpg'),(296,78,'2022-07-29 03:47:27',NULL,NULL,'smallT0XY3Uad3za1cx4ETe2F.jpg'),(297,78,'2022-07-29 03:47:27',NULL,NULL,'smallHvFVc15e5UW31x4H4yW2.jpg'),(298,78,'2022-07-29 03:47:27',NULL,NULL,'smallHzce4ZFWA3IfEXX055zH.jpg'),(299,78,'2022-07-29 03:47:27',NULL,NULL,'smallbETbF5AAIGZ12yywdv5b.jpg'),(300,79,'2022-07-29 03:48:07',NULL,NULL,'small0VZvHaFV2AEVGGvW3XV4.jpg'),(301,79,'2022-07-29 03:48:07',NULL,NULL,'smallIGTzEw4UFXWGa2FHZb0G.jpg'),(302,79,'2022-07-29 03:48:07',NULL,NULL,'smallTbUT3TaXe01f3H0vW5Hw.jpg'),(303,79,'2022-07-29 03:48:07',NULL,NULL,'smallZwcfEeYG0zaY25bVV23W.jpg'),(304,80,'2022-07-29 03:48:55',NULL,NULL,'small2AGceeXHaGbfbVXwYvcA.jpg'),(305,80,'2022-07-29 03:48:55',NULL,NULL,'smallfX2Ie5HfvYcVfIfUcTIF.jpg'),(306,80,'2022-07-29 03:48:55',NULL,NULL,'smallvFA3141Fb1E2E4zTH51A.jpg'),(307,80,'2022-07-29 03:48:55',NULL,NULL,'smallUbWZ3fI4UafEY2acVEWE.jpg'),(308,81,'2022-08-04 10:37:03',NULL,NULL,'smallyAGY525e5Z1EU4ZUZWTc.jpg'),(309,81,'2022-08-04 10:37:03',NULL,NULL,'small1EFvdF5Z5AFVxAVcf1YV.jpg'),(310,81,'2022-08-04 10:37:03',NULL,NULL,'smallxc4H4Ez0cyWyxXbExf5V.jpg'),(311,81,'2022-08-04 10:37:03',NULL,NULL,'small5T5YYFvVH0d21FddUyZd.jpg'),(312,82,'2022-08-04 10:42:06',NULL,NULL,'small1yUfHVcUGzwve5bwfTV4.jpg'),(313,82,'2022-08-04 10:42:06',NULL,NULL,'smallwfYcfHW1HZevTE5aeTxT.jpg'),(314,82,'2022-08-04 10:42:06',NULL,NULL,'smallwFv0FzycGyxc3v0fHbyI.jpg'),(315,82,'2022-08-04 10:42:06',NULL,NULL,'smalld3IdWfH2552fdFxY5yXG.jpg');

/*Table structure for table `f_user` */

DROP TABLE IF EXISTS `f_user`;

CREATE TABLE `f_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表的主键',
  `account` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `account_region` varchar(255) DEFAULT NULL COMMENT '用户账号地区',
  `birthday` datetime DEFAULT NULL COMMENT '用户的生日',
  `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
  `hobby` varchar(255) DEFAULT NULL COMMENT '用户的爱好',
  `img_url` varchar(255) DEFAULT NULL COMMENT '用户的图片路径',
  `nick_name` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(255) DEFAULT NULL COMMENT '用户的密码',
  `phone` varchar(255) DEFAULT NULL COMMENT '用户手机号',
  `sex` varchar(255) DEFAULT NULL COMMENT '用户的性别',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `f_user` */

insert  into `f_user`(`user_id`,`account`,`account_region`,`birthday`,`email`,`hobby`,`img_url`,`nick_name`,`password`,`phone`,`sex`) values (7,'zBest158318','阿拉伯联合酋长国','2022-06-28 00:00:00','3260653092@qq.com',NULL,'B6dZVXfNIJ.jpeg','绝世舞姬','YC9/OkP3w1+lv7TALRklYQosMOq9BKgN','17673024351','男'),(8,'zBest440875','不丹','2022-07-12 00:00:00',NULL,NULL,'eog9Eedbhe.png','绝世舞姬','mhDHwRihaXWsVAiMvRMcOjMtk26Nq1eA','17343067748','男');

/*Table structure for table `f_user_address` */

DROP TABLE IF EXISTS `f_user_address`;

CREATE TABLE `f_user_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址表的主键',
  `address_name` varchar(255) DEFAULT NULL COMMENT '收货人地址',
  `address_county` varchar(255) DEFAULT NULL COMMENT '收货人的县',
  `address_area` varchar(255) DEFAULT NULL COMMENT '收货人地区',
  `address_detail` varchar(255) DEFAULT NULL COMMENT '收货人详细信息',
  `address_zip_code` int(11) DEFAULT NULL COMMENT '邮政编码',
  `address_phone` varchar(255) DEFAULT NULL COMMENT '收货人电话',
  `address_province` varchar(255) DEFAULT NULL COMMENT '收货人的省份',
  `address_city` varchar(255) DEFAULT NULL COMMENT '收货人的市',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_default_address` tinyint(1) DEFAULT NULL COMMENT '是否是默认收货地址',
  `user_id` int(11) DEFAULT NULL COMMENT '用户表的外键',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `f_user_address` */

insert  into `f_user_address`(`address_id`,`address_name`,`address_county`,`address_area`,`address_detail`,`address_zip_code`,`address_phone`,`address_province`,`address_city`,`create_time`,`is_default_address`,`user_id`) values (1,'zhangsan','西湖区',NULL,'北大青鸟',41001,'17673024351','浙江省','杭州市','2022-07-26 22:15:06',NULL,7),(2,'绝世舞姬','',NULL,'北大青鸟',41001,'17673024351','天津市','西青区',NULL,NULL,7),(3,'大叔大婶大所大所多','西湖区',NULL,'很过分的复古风的事22',41001,'17673024351','浙江省','杭州市',NULL,NULL,7),(6,'王雅婷','张店区',NULL,'北大青鸟',41001,'17673024351','山东省','淄博市','2022-08-04 14:26:08',NULL,8);

/*Table structure for table `f_user_order` */

DROP TABLE IF EXISTS `f_user_order`;

CREATE TABLE `f_user_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单表的主键',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `is_pay` tinyint(4) DEFAULT NULL COMMENT '是否支付 0.支付 1.未支付',
  `is_ship` tinyint(4) DEFAULT NULL COMMENT '是否收货 0.收货 1.未收货',
  `order_no` varchar(255) DEFAULT NULL COMMENT '订单的编号',
  `pay_price` double(11,2) DEFAULT NULL COMMENT '订单实际支付价格',
  `pay_time` timestamp NULL DEFAULT NULL COMMENT '付款时间',
  `receipt_time` datetime DEFAULT NULL COMMENT '发货时间',
  `ship_number` varchar(255) DEFAULT NULL COMMENT '快递单号',
  `turnover_time` datetime DEFAULT NULL COMMENT '成交时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户表的外键',
  `is_comment` tinyint(4) DEFAULT NULL COMMENT '是否评论',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `f_user_order` */

insert  into `f_user_order`(`order_id`,`create_time`,`is_pay`,`is_ship`,`order_no`,`pay_price`,`pay_time`,`receipt_time`,`ship_number`,`turnover_time`,`user_id`,`is_comment`) values (19,'2022-08-01 14:43:36',0,0,'2208016781',297.00,'2022-08-01 14:43:41',NULL,'220801222002','2022-08-01 19:14:27',7,0),(20,'2022-08-01 14:47:05',0,0,'2208015975',120.00,'2022-08-01 20:35:42',NULL,NULL,NULL,7,0),(21,'2022-08-01 19:41:53',0,0,'2208013646',120.00,'2022-08-01 19:42:31','2022-08-01 21:07:51','220801151759','2022-08-01 21:07:51',7,NULL),(22,'2022-08-01 19:48:28',0,1,'2208018522',138.00,'2022-08-01 19:48:40',NULL,'220801520961','2022-08-01 19:48:40',7,NULL),(23,'2022-08-01 20:59:02',0,0,'2208012427',297.00,'2022-08-01 21:08:16','2022-08-04 18:55:53',NULL,'2022-08-04 18:55:53',7,NULL),(24,'2022-08-02 16:28:29',0,1,'2208029105',50.00,'2022-08-02 16:28:40',NULL,'220802920346','2022-08-02 16:28:40',7,NULL),(25,'2022-08-04 16:45:22',0,0,'2208042809',118.00,'2022-08-04 19:25:17','2022-08-07 14:11:03',NULL,'2022-08-07 14:11:03',8,NULL),(26,'2022-08-04 16:57:48',0,0,'2208048088',58.80,'2022-08-04 17:02:09','2022-08-04 19:07:58','220804729365','2022-08-04 19:07:58',8,0),(27,'2022-08-07 13:40:03',0,0,'2208073928',177.00,'2022-08-07 14:11:21','2022-08-07 15:40:54',NULL,'2022-08-07 15:40:54',8,NULL),(28,'2022-08-07 13:42:35',0,0,'2208075690',577.60,'2022-08-07 13:45:20','2022-08-07 15:40:51',NULL,'2022-08-07 15:40:51',8,NULL),(29,'2022-08-07 13:46:44',0,1,'2208074345',576.00,'2022-08-07 13:57:18',NULL,NULL,NULL,8,NULL),(30,'2022-08-07 13:48:49',0,0,'2208079885',176.00,'2022-08-07 13:48:54','2022-08-07 18:48:45','220807334335','2022-08-07 18:48:45',8,NULL),(31,'2022-08-07 13:50:51',0,1,'2208071515',66.00,'2022-08-07 13:50:55',NULL,'220807455600','2022-08-07 13:50:55',8,NULL),(32,'2022-08-07 13:52:55',0,1,'2208075522',312.00,'2022-08-07 13:52:58',NULL,'220807578891','2022-08-07 13:52:58',8,NULL),(33,'2022-08-07 13:59:36',0,1,'2208076235',176.00,'2022-08-07 14:09:45',NULL,'220807585305','2022-08-07 14:09:45',8,NULL),(34,'2022-08-07 14:13:26',0,1,'2208076778',136.00,'2022-08-07 14:13:31',NULL,'220807811546','2022-08-07 14:13:31',8,NULL),(35,'2022-08-07 14:14:24',0,1,'2208074543',176.00,'2022-08-07 14:14:31',NULL,'220807871060','2022-08-07 14:14:31',8,NULL),(36,'2022-08-07 14:15:46',0,1,'2208076119',312.00,'2022-08-07 14:15:52',NULL,'220807952221','2022-08-07 14:15:52',8,NULL),(37,'2022-08-07 14:16:49',0,1,'2208079372',168.00,'2022-08-07 14:16:52',NULL,'220807012640','2022-08-07 14:16:52',8,NULL),(38,'2022-08-07 14:21:09',0,1,'2208079553',80.00,'2022-08-07 14:21:11',NULL,'220807271732','2022-08-07 14:21:11',8,NULL),(39,'2022-08-07 14:22:30',0,1,'2208070254',300.00,'2022-08-07 14:22:32',NULL,'220807352958','2022-08-07 14:22:32',8,NULL),(40,'2022-08-07 14:24:01',0,1,'2208071770',58.00,'2022-08-07 14:24:03',NULL,'220807443661','2022-08-07 14:24:03',8,NULL),(41,'2022-08-07 14:25:09',0,1,'2208079774',300.00,'2022-08-07 14:25:12',NULL,'220807512998','2022-08-07 14:25:12',8,NULL),(42,'2022-08-07 14:29:01',0,1,'2208071188',380.00,'2022-08-07 14:29:03',NULL,'220807743195','2022-08-07 14:29:03',8,NULL),(43,'2022-08-07 14:33:09',0,1,'2208079134',69.00,'2022-08-07 14:39:19',NULL,'220807360293','2022-08-07 14:39:19',8,NULL),(45,'2022-08-07 14:45:42',0,1,'2208072002',176.00,'2022-08-07 14:45:45',NULL,'220807745580','2022-08-07 14:45:45',8,NULL),(46,'2022-08-07 14:47:20',0,1,'2208070641',460.00,'2022-08-07 14:47:33',NULL,NULL,NULL,8,NULL),(47,'2022-08-07 15:41:54',0,1,'2208074363',138.00,'2022-08-07 15:41:56',NULL,'220807116316','2022-08-07 15:41:56',8,NULL),(48,'2022-08-07 15:56:59',0,1,'2208079430',200.00,'2022-08-07 15:57:02',NULL,'220807022004','2022-08-07 15:57:02',8,NULL),(50,'2022-08-07 16:05:32',0,1,'2208072242',260.00,'2022-08-07 16:05:37',NULL,'220807537845','2022-08-07 16:05:37',8,NULL),(51,'2022-08-07 16:12:15',0,1,'2208075320',176.00,'2022-08-07 16:12:55',NULL,NULL,NULL,8,NULL),(52,'2022-08-08 14:36:18',0,1,'2208088316',46.00,'2022-08-08 14:36:22',NULL,'220808582832','2022-08-08 14:36:22',8,NULL);

/*Table structure for table `f_user_order_furniture` */

DROP TABLE IF EXISTS `f_user_order_furniture`;

CREATE TABLE `f_user_order_furniture` (
  `order_furniture_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单家具表的主键',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `furniture_id` int(11) DEFAULT NULL COMMENT '家具表的外键',
  `furniture_number` int(11) DEFAULT NULL COMMENT '购买家具的数量',
  `furniture_price` double(11,2) DEFAULT NULL COMMENT '单个家具的价格',
  `order_id` int(11) DEFAULT NULL COMMENT '订单表的外键',
  `pay_type` varchar(255) DEFAULT NULL COMMENT '支付方式',
  PRIMARY KEY (`order_furniture_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*Data for the table `f_user_order_furniture` */

insert  into `f_user_order_furniture`(`order_furniture_id`,`create_time`,`furniture_id`,`furniture_number`,`furniture_price`,`order_id`,`pay_type`) values (14,'2022-08-01 14:43:36',29,3,99.00,19,'支付宝支付'),(15,'2022-08-01 14:47:05',50,3,40.00,20,'微信支付'),(16,'2022-08-01 19:41:53',33,2,60.00,21,'微信支付'),(17,'2022-08-01 19:48:28',62,1,138.00,22,'微信支付'),(18,'2022-08-01 20:59:02',36,3,99.00,23,'支付宝支付'),(19,'2022-08-02 16:28:29',37,1,50.00,24,'微信支付'),(20,'2022-08-04 16:45:22',13,2,59.00,25,'微信支付'),(21,'2022-08-04 16:57:48',10,3,19.60,26,'支付宝支付'),(22,'2022-08-07 13:40:03',13,3,59.00,27,'支付宝支付'),(23,'2022-08-07 13:42:35',9,2,288.80,28,'支付宝支付'),(24,'2022-08-07 13:46:44',11,2,288.00,29,'支付宝支付'),(25,'2022-08-07 13:48:49',14,2,88.00,30,'支付宝支付'),(26,'2022-08-07 13:50:51',19,2,33.00,31,'支付宝支付'),(27,'2022-08-07 13:52:55',26,2,156.00,32,'支付宝支付'),(28,'2022-08-07 13:59:36',14,2,88.00,33,'支付宝支付'),(29,'2022-08-07 14:13:26',21,2,68.00,34,'支付宝支付'),(30,'2022-08-07 14:14:24',15,2,88.00,35,'支付宝支付'),(31,'2022-08-07 14:15:46',26,2,156.00,36,'支付宝支付'),(32,'2022-08-07 14:16:49',18,3,56.00,37,'支付宝支付'),(33,'2022-08-07 14:21:09',17,2,40.00,38,'支付宝支付'),(34,'2022-08-07 14:22:30',24,3,100.00,39,'支付宝支付'),(35,'2022-08-07 14:24:01',38,2,29.00,40,'支付宝支付'),(36,'2022-08-07 14:25:09',60,3,100.00,41,'支付宝支付'),(37,'2022-08-07 14:29:01',70,2,190.00,42,'支付宝支付'),(38,'2022-08-07 14:33:09',20,3,23.00,43,'支付宝支付'),(39,'2022-08-07 14:45:21',51,2,78.00,44,NULL),(40,'2022-08-07 14:45:42',42,2,88.00,45,'支付宝支付'),(41,'2022-08-07 14:47:20',22,2,230.00,46,'支付宝支付'),(42,'2022-08-07 15:41:54',12,2,69.00,47,'支付宝支付'),(43,'2022-08-07 15:56:59',45,2,100.00,48,'支付宝支付'),(44,'2022-08-07 16:05:10',17,2,40.00,49,NULL),(45,'2022-08-07 16:05:32',32,2,130.00,50,'支付宝支付'),(46,'2022-08-07 16:12:15',15,2,88.00,51,'支付宝支付'),(47,'2022-08-08 14:36:18',20,2,23.00,52,'支付宝支付');

/*Table structure for table `f_user_order_logistics` */

DROP TABLE IF EXISTS `f_user_order_logistics`;

CREATE TABLE `f_user_order_logistics` (
  `order_logistics_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物流表',
  `logistics_address_name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `logistics_address_county` varchar(255) DEFAULT NULL COMMENT '收货人的县',
  `logistics_address_area` varchar(255) DEFAULT NULL COMMENT '收货人地区',
  `logistics_address_detail` varchar(255) DEFAULT NULL COMMENT '收货人详细信息',
  `logistics_address_zip_code` int(11) DEFAULT NULL COMMENT '邮政编码',
  `logistics_address_phone` varchar(255) DEFAULT NULL COMMENT '收货人电话',
  `logistics_address_province` varchar(255) DEFAULT NULL COMMENT '收货人的省份',
  `logistics_address_city` varchar(255) DEFAULT NULL COMMENT '收货人的市',
  `logistics_create_time` datetime DEFAULT NULL COMMENT '发货时间',
  `logistics_description` varchar(255) DEFAULT NULL COMMENT '物流描述',
  `logistics_fee` double(11,2) DEFAULT NULL COMMENT '运费',
  `logistics_no` varchar(255) DEFAULT NULL COMMENT '物流单号',
  `logistics_order_no` varchar(255) DEFAULT NULL COMMENT '物流订单编号',
  `logistics_settlement_time` datetime DEFAULT NULL COMMENT '物流结算时间',
  `logistics_status` varchar(255) DEFAULT NULL COMMENT '物流状态',
  `logistics_type` varchar(255) DEFAULT NULL COMMENT '物流方式',
  `logistics_update_time` datetime DEFAULT NULL COMMENT '物流更新时间',
  `order_furniture_id` int(11) DEFAULT NULL COMMENT '订单家具表的外键',
  PRIMARY KEY (`order_logistics_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `f_user_order_logistics` */

insert  into `f_user_order_logistics`(`order_logistics_id`,`logistics_address_name`,`logistics_address_county`,`logistics_address_area`,`logistics_address_detail`,`logistics_address_zip_code`,`logistics_address_phone`,`logistics_address_province`,`logistics_address_city`,`logistics_create_time`,`logistics_description`,`logistics_fee`,`logistics_no`,`logistics_order_no`,`logistics_settlement_time`,`logistics_status`,`logistics_type`,`logistics_update_time`,`order_furniture_id`) values (2,'zhangsan','西湖区',NULL,'北大青鸟',NULL,'17673024351','浙江省','杭州市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,14),(3,'绝世舞姬','',NULL,'北大青鸟',NULL,'17673024351','天津市','西青区',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,15),(4,'绝世舞姬','',NULL,'北大青鸟',NULL,'17673024351','天津市','西青区',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,16),(5,'绝世舞姬','',NULL,'北大青鸟',NULL,'17673024351','天津市','西青区',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,17),(6,'王大妈','西湖区',NULL,'长沙北大青鸟',NULL,'17673024351','浙江省','杭州市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,18),(7,'王大妈','西湖区',NULL,'长沙北大青鸟',NULL,'17673024351','浙江省','杭州市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,19),(8,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,20),(9,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,21),(10,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,22),(11,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,23),(12,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,24),(13,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,25),(14,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,26),(15,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,27),(16,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,28),(17,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,29),(18,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,30),(19,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,31),(20,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,32),(21,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,33),(22,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,34),(23,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,35),(24,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,36),(25,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,37),(26,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,38),(27,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,39),(28,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,40),(29,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,41),(30,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,42),(31,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,43),(32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,44),(33,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,45),(34,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,46),(35,'王雅婷','张店区',NULL,'北大青鸟',NULL,'17673024351','山东省','淄博市',NULL,NULL,0.00,NULL,NULL,NULL,NULL,NULL,NULL,47);

/*Table structure for table `f_user_shopping_car` */

DROP TABLE IF EXISTS `f_user_shopping_car`;

CREATE TABLE `f_user_shopping_car` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车表的主键',
  `create_time` datetime DEFAULT NULL COMMENT '家具创建的时间',
  `furniture_id` int(11) DEFAULT NULL COMMENT '家具表的外键',
  `furniture_img` varchar(255) DEFAULT NULL COMMENT '主图',
  `furniture_number` int(11) DEFAULT NULL COMMENT '家具的数量',
  `update_time` datetime DEFAULT NULL COMMENT '家具更新的时间',
  `user_id` int(11) DEFAULT NULL COMMENT '用户表的外键',
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `f_user_shopping_car` */

insert  into `f_user_shopping_car`(`car_id`,`create_time`,`furniture_id`,`furniture_img`,`furniture_number`,`update_time`,`user_id`) values (2,'2022-08-02 15:09:31',57,NULL,3,NULL,7),(4,'2022-08-02 16:29:50',36,NULL,3,NULL,7),(5,'2022-08-02 17:44:05',37,NULL,2,NULL,7);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
