
-- 需要 MySQL 5.6.5以上的版本
CREATE DATABASE channel_data;
USE channel_data;


-- 广告信息商表
CREATE TABLE advert_info(
`adverter_code` VARCHAR(50) NOT NULL  COMMENT '广告商标识',
`app_code` VARCHAR(50) NOT NULL COMMENT '应用标识',
`adverter_name` VARCHAR(100) NOT NULL COMMENT '广告商名',
`balance_ratio` INT NOT NULL COMMENT '结算比例',
PRIMARY KEY (`adverter_code`,`app_code`)

)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='广告信息商表';


-- 应用信息表
CREATE TABLE app_info(
`app_code` VARCHAR(50) NOT NULL  COMMENT '应用标识',
`app_name` VARCHAR(100) NOT NULL COMMENT '应用名',
`token` VARCHAR(50) COMMENT '校验token',
`come_from` VARCHAR(50)  COMMENT '渠道标识',
`callback_url` VARCHAR(500) COMMENT '回调地址',
`other_params` VARCHAR(200) COMMENT '其他参数',
`status` TINYINT NOT NULL DEFAULT 0 COMMENT '应用开关',
PRIMARY KEY (`app_code`)
)ENGINE=INNODB  DEFAULT CHARSET=utf8 COMMENT='应用信息表';


-- 上报记录表
CREATE TABLE report_log(
`idfa` VARCHAR(50) NOT NULL  COMMENT 'idfa',
`adverter_code` VARCHAR(100)  COMMENT '广告商标识',
`app_code` VARCHAR(50) NOT NULL COMMENT '应用标识',
`click_id` VARCHAR(50)  COMMENT '广告点击id',
`callback` VARCHAR(500) COMMENT '回调地址',
`report_time` DATETIME COMMENT '上报时间',
PRIMARY KEY (`idfa`,`app_code`)
)ENGINE=INNODB  DEFAULT CHARSET=utf8 COMMENT='上报记录表';

-- 回调记录表
CREATE TABLE callback_log(
  `idfa` VARCHAR(50) NOT NULL  COMMENT 'idfa',
  `adverter_code` VARCHAR(100)  COMMENT '广告商标识',
  `app_code` VARCHAR(50) NOT NULL COMMENT '应用标识',
  `ip` VARCHAR(50) COMMENT 'ip地址',
  `callback` VARCHAR(500) COMMENT '回调地址',
  `click_id` VARCHAR(50)  COMMENT '广告点击id',
  `is_call` TINYINT COMMENT '是否已回调,0:否，1:是',
  `is_finish` TINYINT COMMENT '回调是否成功,0:不成功，1：成功',
  `is_balance` TINYINT COMMENT '是否需要结算,0表示不需要，1表示需要',
  `create_time` DATETIME COMMENT '上报时间',
  `update_time` DATETIME COMMENT '修改时间',
  PRIMARY KEY (`idfa`,`app_code`)
)ENGINE=INNODB  DEFAULT CHARSET=utf8 COMMENT='回调记录表';


-- 结算表
CREATE TABLE balance_amount(
  `adverter_code` VARCHAR(50) NOT NULL COMMENT '广告商标识',
  `app_code` VARCHAR(50) NOT NULL COMMENT '应用标识',
  `balance_count` BIGINT COMMENT '结算量',
  `total_count`  BIGINT COMMENT '每日回调总量',
  `balance_date` DATE COMMENT '结算日期',
  `create_time` DATETIME COMMENT '创建时间',
  PRIMARY KEY (`adverter_code`,`app_code`)
)ENGINE=INNODB  DEFAULT CHARSET=utf8 COMMENT='结算表';




