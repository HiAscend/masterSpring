package com.smart.chapter18.test.dataset.excel;

import org.unitils.core.UnitilsException;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

/**
 * MultiSchemaXlsDataSetFactory
 *
 * @author zziaa
 * @date 2018/05/06 11:02
 */
public class MultiSchemaXlsDataSetFactory implements DataSetFactory {

    protected String defaultSchemaName;

    @Override
    public void init(Properties properties, String s) {
        this.defaultSchemaName = s;
    }

    /**
     * 创建数据集
     * @param dataSetFiles File...
     * @return MultiSchemaDataSet
     */
    @Override
    public MultiSchemaDataSet createDataSet(File... dataSetFiles) {
        try {
            MultiSchemaXlsDataSetReader xlsDataSetReader = new MultiSchemaXlsDataSetReader(defaultSchemaName);
            return xlsDataSetReader.readDataSetXls(dataSetFiles);
        } catch (Exception e) {
            throw new UnitilsException("创建数据集失败: " + Arrays.toString(dataSetFiles), e);
        }
    }

    /**
     * 获取数据集文件的扩展名
     * @return String
     */
    @Override
    public String getDataSetFileExtension() {
        return "xls";
    }
}
