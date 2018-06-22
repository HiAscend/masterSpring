package com.smart.chapter18.dao;

import com.smart.chapter18.domain.Board;
import com.smart.chapter18.test.dataset.util.XlsDataSetBeanFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import java.util.List;

/**
 * BoardDaoTest
 *
 * @author ascend
 * @date 2018/5/10 16:07.
 */
public class BoardDaoTest extends BaseDaoTest {

    @SpringBean("boardDao")
    private BoardDao boardDao;

    /**
     * 创建一个新的论坛版块,并更新
     */
    @Test
    @DataSet(value = "XiaoChun.SaveBoards.xls")//准备数据
    @ExpectedDataSet("XiaoChun.ExpectedBoards.xls")
    public void addBoard() throws Exception {
        // 通过XlsDataSetBeanFactory数据集绑定工厂创建测试实体
        List<Board> boards = XlsDataSetBeanFactory.createBeans(BoardDaoTest.class, "XiaoChun.SaveBoards.xls", "t_board", Board.class);
        for (Board board : boards) {
            boardDao.update(board);
        }
    }

    @Test
    @DataSet(value = {"XiaoChun.Boards.xls"})
    @ExpectedDataSet(value = "XiaoChun.ExpectedBoards.xls")
    public void removeBoard() {
        Board board = boardDao.get(7);
        boardDao.remove(board);
    }

    @Test
    @DataSet(value = {"XiaoChun.Boards.xls"})
    public void testGetBoard() {
        Board board = boardDao.get(1);
        Assert.assertNotNull(board);
        Assert.assertEquals(board.getBoardName(), "SpringMVC");
    }
}
