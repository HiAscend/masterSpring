package com.smart.chapter18.test.dataset.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.dbunit.dataset.*;
import org.dbunit.dataset.excel.XlsDataSet;
import org.unitils.core.UnitilsException;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.util.*;
import java.util.regex.Pattern;

/**
 * MultiSchemaXlsDataSetReader
 *
 * @author zziaa
 * @date 2018/05/06 11:21
 */
public class MultiSchemaXlsDataSetReader {
    private String defaultSchemaName;

    public MultiSchemaXlsDataSetReader(String defaultSchemaName) {
        this.defaultSchemaName = defaultSchemaName;
    }

    public MultiSchemaDataSet readDataSetXls(File... dataSetFiles) {
        try {
            Map<String, List<ITable>> tableMap = getTables(dataSetFiles);
            MultiSchemaDataSet dataSet = new MultiSchemaDataSet();
            for (Map.Entry<String, List<ITable>> entry : tableMap.entrySet()) {
                List<ITable> tables = entry.getValue();
                DefaultDataSet defaultDataSet = new DefaultDataSet(tables.toArray(new ITable[]{}));
                dataSet.setDataSetForSchema(entry.getKey(), defaultDataSet);
            }
            return dataSet;
        } catch (Exception e) {
            throw new UnitilsException("UnitilsException", e);
        }
    }

    public Map<String, List<ITable>> getTables(File... dataSetFiles) {
        Pattern pattern = Pattern.compile("\\.");
        Map<String, List<ITable>> tableMap = new HashMap<>();
        try {
            for (File file : dataSetFiles) {
                IDataSet dataSet = new XlsDataSet(file);
                String[] tableNames = dataSet.getTableNames();
                for (String each : tableNames) {
                    String schema = null;
                    String tableName = null;
                    String[] temp = pattern.split(each);
                    if (temp.length == 2) {
                        schema = temp[0];
                        tableName = temp[1];
                    } else {
                        schema = defaultSchemaName;
                        tableName = each;
                    }
                    ITable table = dataSet.getTable(each);
                    if (!tableMap.containsKey(tableName)) {
                        tableMap.put(schema, new ArrayList<ITable>());
                    }
                    tableMap.get(schema).add(new XlsTable(table, tableName));
                }
            }
        } catch (Exception e) {
            throw new UnitilsException("UnitilsException:" + Arrays.toString(dataSetFiles), e);
        }
        return tableMap;
    }

    class XlsTable extends AbstractTable {
        private ITable delegate;
        private String tableName;

        public XlsTable(ITable delegate, String tableName) {
            this.delegate = delegate;
            this.tableName = tableName;
        }

        /**
         * Returns this table metadata.
         */
        @Override
        public ITableMetaData getTableMetaData() {
            ITableMetaData metaData = delegate.getTableMetaData();
            try {
                return new DefaultTableMetaData(tableName, metaData.getColumns(), metaData.getPrimaryKeys());
            } catch (DataSetException e) {
                throw new UnitilsException("Don't get the meta info from " + metaData, e);
            }
        }

        /**
         * Returns this table row count.
         */
        @Override
        public int getRowCount() {
            return delegate.getRowCount();
        }

        /**
         * Returns this table value for the specified row and column.
         *
         * @param row    The row index, starting with 0
         * @param column The name of the column
         * @return The value
         * @throws NoSuchColumnException   if specified column name do not exist in
         *                                 this table
         * @throws RowOutOfBoundsException if specified row is less than zero or
         *                                 equals or greater than <code>getRowCount</code>
         */
        @Override
        public Object getValue(int row, String column) throws DataSetException {
            Object delta = delegate.getValue(row, column);
            if (delta instanceof String && StringUtils.isEmpty(delta.toString())) {
                return null;
            }
            if (delta instanceof Long) {
                delta = DateFormatUtils.format(new Date(Long.parseLong(delta.toString())), "yyyy-MM-dd");
            }
            return delta;
        }
    }
}
