# 题目
1. 使用Java语言完成下列题目，可自由查阅资料。
2. 注意代码风格。
3. 我们团队统一使用Intellij进行开发，所以请提交完整的Intellij工程。

## 1.算法题
你截获了一份敌国词典，其语言使用的字母和英文相同，但顺序不同。
这部辞典中单词的顺序按照其语文字母顺序排列, 需要你分析出其国家语言的字母排序。
例子，若字典顺序如下：["xmc","xmq","em","ecc", "mqcc"]，正确顺序是"xemcq"

## 2.工程题
使用spring-boot框架，实现一个http服务，支持
1）输入完整的URL，返回一个对应的短网址
2）输入短网址，返回对应的原始URL
如果用到了关系数据库，工程里需要包含建表DDL

可以参考 https://bitly.com/，只需要实现后端

你的短地址域名使用localhost即可

# 操作
## 创建数据表
```sql
DROP TABLE IF EXISTS `short_link`;
CREATE TABLE `short_link`  (
                               `id` int(0) NOT NULL AUTO_INCREMENT,
                               `shorts` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                               `short_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                               `long_link` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                               `create_time` timestamp(0) NOT NULL,
                               `flag` int(0) NOT NULL DEFAULT 0,
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;
```



测试链接：http://localhost:9090/share.do?longLink=https://github.com/slsher/laiweilai/tree/main/short_link

结果：
```json
{"status":true,"message":null,"data":{"id":8,"shorts":"r9ux2iBX","shortLink":"http://localhost:9090/short/r9ux2iBX","longLink":"https://github.com/slsher/laiweilai/tree/main/short_link","createTime":"2023-02-22T22:55:40.74","flag":0},"count":null}
```
