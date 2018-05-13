package com.smart.chapter18.test.dataset.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;
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
     * @param testClass Class 测试类
     * @param file      String
     * @param tableName String
     * @param <T>       T
     * @return List
     * @throws Exception Exception
     */
    public static <T> List<T> createBeans(Class testClass, String file, String tableName, Class<T> clazz) throws Exception {
        BeanUtilsBean beanUtilsBean = createBeanUtils();
        List<Map<String, Object>> propsList = createProps(testClass, file, tableName);
        List<T> beans = new ArrayList<>();
        for (Map<String, Object> props : propsList) {
            T bean = clazz.newInstance();
            beanUtilsBean.populate(bean, props);
            beans.add(bean);
        }
        return beans;
    }

    /**
     * 从DbUnit的Excel数据集文件创建Bean
     *
     * @param testClass Class 测试类
     * @param file      String
     * @param tableName String
     * @param clazz     Class
     * @param <T>       T
     * @return T
     * @throws Exception Exception
     */
    public static <T> T createBean(Class testClass, String file, String tableName, Class<T> clazz) throws Exception {
        BeanUtilsBean beanUtilsBean = createBeanUtils();
        List<Map<String, Object>> propsList = createProps(testClass, file, tableName);
        T bean = clazz.newInstance();
        beanUtilsBean.populate(bean, propsList.get(0));
        return bean;
    }

    private static List<Map<String, Object>> createProps(Class testClass, String file, String tableName) throws IOException, DataSetException {
        List<Map<String, Object>> propList = new ArrayList<>();
        IDataSet expected = new XlsDataSet(testClass.getResourceAsStream(file));
        ITable table = expected.getTable(tableName);
        Column[] columns = table.getTableMetaData().getColumns();
        for (int i = 0; i < table.getRowCount(); i++) {
            Map<String, Object> props = new HashMap<>();
            for (Column column : columns) {
                Object value = table.getValue(i, column.getColumnName());
                String propName = underlineToCamel(column.getColumnName());
                props.put(propName, value);
            }
            propList.add(props);
        }
        return propList;
    }

    /**
     * 下划线转驼峰写法
     *
     * @param str 下划线写法
     * @return 驼峰写法
     */
    private static String underlineToCamel(String str) {
        // deal with str like "_bei_jing"
        int index = 0;
        boolean loop = true;
        while (loop) {
            if (str.charAt(index) == '_') {
                index++;
            } else {
                loop = false;
            }
        }

        String[] words = str.substring(index).split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (StringUtils.isNotEmpty(words[i])) {
                if (i == 0) {
                    sb.append(words[i]);
                } else {
                    sb.append(words[i].substring(0, 1).toUpperCase())
                        .append(words[i].substring(1));
                }
            }
        }
        return sb.toString();
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
