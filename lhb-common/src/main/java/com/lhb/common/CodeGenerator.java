/*
 * Copyright (c) 2016, JD.com All Rights Reserved.
 */
package com.lhb.common;



import com.lhb.common.util.CamelCaseUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 代码生成工具
 *
 * @author suntao1
 * @since 2016/01/19
 */
public class CodeGenerator {

    private static final Map<String, String> converMap = new HashMap<String, String>();

    static {
        converMap.put("INT", "Integer");
        converMap.put("BIGINT", "Long");
        converMap.put("VARCHAR", "String");
        converMap.put("CHAR", "String");
        converMap.put("DATETIME", "Date");
        converMap.put("TIMESTAMP", "Date");
        converMap.put("BIT", "Integer");
        converMap.put("SMALLINT", "Integer");
        converMap.put("DECIMAL", "BigDecimal");
        converMap.put("TINYINT", "Integer");

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void execute(String url,String templatePath, String outputPath, String tableNamePattern, Map<String,Object> extParamMap) {
        try {
            Connection connection = DriverManager.getConnection(url);
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tablesResultSet = metaData.getTables(null, "%", tableNamePattern, new String[]{"TABLE"});
            while (tablesResultSet.next()) {
                Map<String, Object> tableModel = new HashMap<String, Object>();
                String tableName = tablesResultSet.getString("TABLE_NAME");
                tableModel.put("table_name", tableName.toLowerCase());
                tableModel.put("TABLE_NAME", tableName.toUpperCase());
                tableModel.put("tableName", CamelCaseUtils.toCamelCase(tableName));
                tableModel.put("TableName", CamelCaseUtils.toCamelCaseCapitalize(tableName));
                tableModel.put("tableComment", tablesResultSet.getString("REMARKS"));
                tableModel.putAll(extParamMap);
                List<Map<String, String>> columns = new ArrayList<Map<String, String>>();
                ResultSet columnsResultSet = metaData.getColumns(null, "%", tableName, "%");
                while (columnsResultSet.next()) {
                    Map<String, String> column = new HashMap<String, String>();
                    String columnName = columnsResultSet.getString("COLUMN_NAME");
                    column.put("column_name", columnName.toLowerCase());
                    column.put("COLUMN_NAME", columnName.toUpperCase());
                    column.put("columnName", CamelCaseUtils.toCamelCase(columnName));
                    column.put("ColumnName", CamelCaseUtils.toCamelCaseCapitalize(columnName));
                    column.put("dataType", converMap.get(columnsResultSet.getString("TYPE_NAME")));
                    column.put("columnComment", columnsResultSet.getString("REMARKS"));
                    columns.add(column);
                }
                tableModel.put("columns", columns);

                File templatePathFile = new File(templatePath);
                if (templatePathFile.exists() && templatePathFile.isDirectory()) {
                    Configuration configuration = new Configuration();
                    configuration.setDirectoryForTemplateLoading(templatePathFile);
                    File[] files = templatePathFile.listFiles();
                    for (File file : files) {
                        if (file.getName().endsWith(".ftl")) {
                            //解析保存的文件名
                            String ftlFileName = file.getName();
                            CharArrayWriter writer = new CharArrayWriter();
                            Template fileNameTemplate = new Template(null,new StringReader(ftlFileName),null);
                            fileNameTemplate.process(tableModel,writer);
                            String savedFileName = writer.toString().replace(".ftl","");
                            //解析文件内容
                            Template fileContentTemplate = configuration.getTemplate(ftlFileName);
                            OutputStreamWriter outputStreamWriter = null;
                            try {
                                File outFile = new File(outputPath +"/"+savedFileName);
                                File outputPathFile = new File(outputPath);
                                if(!outputPathFile.exists()){
                                    outputPathFile.mkdirs();
                                }
                                if (outFile.exists()) {
                                    outFile.delete();
                                    outFile.createNewFile();
                                }
                                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(outFile));
                                fileContentTemplate.process(tableModel, outputStreamWriter);
                                System.out.println("文件：" + savedFileName + "已生成！");
                            } catch (Exception ex) {
                                throw ex;
                            } finally {
                                if (null != outputStreamWriter) {
                                    outputStreamWriter.flush();
                                    outputStreamWriter.close();
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("ftl模板目录不存在");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        /*String url = "jdbc:mysql://172.24.7.87:3306/finsetts_test?user=mysql&password=123456";
        String templatePath = CodeGenerator.class.getClassLoader().getResource("ftl").getPath();
        String outputPath = "E:/output/FinProject";
        String tableName = "fin_project_139";
        Map<String,Object> extParams = new HashMap<String, Object>();
        extParams.put("packagePath","com.jd.worker");
        extParams.put("author","lianghuaibin");
        extParams.put("tableComment","承兑规则");
        extParams.put("jAppName","finsetts-Jsf");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        extParams.put("since",dateFormat.format(new Date()));
        execute(url, templatePath,outputPath, tableName, extParams);*/

//        String url = "jdbc:mysql://123.57.69.90:3306/lhb?useUnicode=true&characterEncoding=UTF-8";
        String url = "jdbc:mysql://123.57.69.90:3306/lhb?user=root&password=Bin*#220807#";
        String templatePath = CodeGenerator.class.getClassLoader().getResource("ftl").getPath();
        String outputPath = "E:/output/lhb_romantic";
        String tableName = "lhb_romantic";
        Map<String,Object> extParams = new HashMap<String, Object>();
        extParams.put("packagePath","com.lhb");
        extParams.put("author","lianghuaibin");
        extParams.put("tableComment","浪漫花语表");
//        extParams.put("jAppName","finsetts-Jsf");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        extParams.put("since",dateFormat.format(new Date()));
        execute(url, templatePath,outputPath, tableName, extParams);

    }
}
