CREATE DATABASE Customer; -- Create the database

USE Customer; -- Use the database
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE t_customer ( -- Create the table ' t_customer'
  id int(11) NOT NULL  AUTO_INCREMENT COMMENT '客户编号，主键',
  name varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户名，非空',
    gender VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(20),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id，主键',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名，唯一，非空',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码，非空',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `user_state` int(11) NOT NULL COMMENT '用户账号状态：\r\n0：正常 ， 1：禁用\r\n用户账号状态：\r\n0：正常 ， 1：禁用\r\n用户账号状态：0：正常 ， 1：禁用',
  `role` int(11) NOT NULL COMMENT '用户性质：0：管理员，1：普通用户',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_name`(`user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '张三', '123456', 18, '男', '123123', '厦门', 0, 1);
INSERT INTO `t_user` VALUES (2, '李四', '123456', 19, '女', '456456', '江苏', 0, 1);
INSERT INTO `t_user` VALUES (3, 'admin', '111111', 9999, '未知', '未知', '互联网', 0, 0);

SET FOREIGN_KEY_CHECKS = 1;

