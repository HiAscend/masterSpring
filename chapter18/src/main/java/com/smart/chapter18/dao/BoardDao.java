package com.smart.chapter18.dao;

import com.smart.chapter18.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

/**
 * BoardDao
 *
 * @author ascend
 * @date 2018/5/2 15:30.
 */
@Repository
public class BoardDao extends BaseDao<Board> {
    private static final String GET_BOARD_NUM = "select count(f.boardId) from Board f";

    /**
     * 获取板块数量
     *
     * @return long
     */
    public long getBoardNum() {
        Iterator<?> iterator = getHibernateTemplate().iterate(GET_BOARD_NUM);
        return Long.parseLong(iterator.next().toString());
    }


}
