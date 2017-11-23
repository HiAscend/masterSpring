# 将语句的结束符调整为//， 否则存储过程中的";"语句结束符会被错误解析
DELIMITER //
CREATE PROCEDURE P_GET_TOPIC_NUM(IN in_user_id INT, OUT out_num INT)
  BEGIN
    SELECT COUNT(*)
    INTO out_num
    FROM t_topic
    WHERE user_id = in_user_id;
  END //
# 重新将语句结束符调整为;
DELIMITER ;

