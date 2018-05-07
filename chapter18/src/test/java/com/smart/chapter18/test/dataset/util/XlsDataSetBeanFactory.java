package com.smart.chapter18.test.dataset.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.poi.ss.formula.functions.T;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;

import java.io.IOException;
import java.util.*;

/**
 * XlsDataSetBeanFactory
 * 从Excel数据集文件创建Bean
 *
 * @author ascend
 * @date 2018/5/7 16:21.
 */
public class XlsDataSetBeanFactory {
    /**
     * 从DbUnit的EXCEL数据集文件创建多个bean
     *
     * @param testClass Class
     * @param file      String
     * @param tableName String
     * @param <T>       T
     * @return List
     */
    public static <T> List<T> createBeans(Class testClass, String file, String tableName, Class<T> clazz) {
        BeanUtilsBean beanUtilsBean = createBeanUtils();

    }

    private List<Map<String, Object>> createProps(Class testClass, String file, String tableName) throws IOException, DataSetException {
        List<Map<String, Object>> propList = new ArrayList<>();
        IDataSet expected = new XlsDataSet(testClass.getResourceAsStream(file));
        ITable table = expected.getTable(tableName);
        Column[] columns = table.getTableMetaData().getColumns();
        for (int i = 0; i < table.getRowCount(); i++) {
            Map<String, Object> props = new HashMap<>();
            for (Column column : columns) {
                Object value = table.getValue(i, column.getColumnName());
                String propName = underlineToCamel(column.getColumnName());
            }
        }
    }

    private static String underlineToCamel(String str) {

    }

    private static BeanUtilsBean createBeanUtils() {
        ConvertUtilsBean convertUtilsBean = createConvertUtils();
        return new BeanUtilsBean(convertUtilsBean);
    }

    private static ConvertUtilsBean createConvertUtils() {
        DateConverter dateConverter = new DateConverter();
        dateConverter.setPattern("yyyy-MM-dd");
        ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
        convertUtilsBean.register(dateConverter, Date.class);
        convertUtilsBean.register(dateConverter, java.sql.Date.class);
        convertUtilsBean.register(dateConverter, java.sql.Timestamp.class);
        return convertUtilsBean;
    }
}
