package com.smart.chapter17.web;

import com.smart.chapter17.domain.User;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * UserListExcelView
 *
 * @author zziaa
 * @date 2018/04/07 10:22
 */
public class UserListExcelView extends AbstractXlsxView {
    /**
     * Application-provided subclasses must implement this method to populate
     * the Excel workbook document, given the model.
     *
     * @param model    the model Map
     * @param workbook the Excel workbook to populate
     * @param request  in case we need locale etc. Shouldn't look at attributes.
     * @param response in case we need to set cookies. Shouldn't write to it.
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Excel文档名称必须编码为ISO-8859-1，否则会显示乱码，IE中会直接在浏览器中展示，而在chrome等浏览器中则会直接提示下载
        // 第二个参数设置为："attachment; filename=..." 会提示下载文件
        response.setHeader("Content-Disposition", "inline; filename=" + new String("用户列表".getBytes(), Charset.forName("ISO-8859-1")));
        List<User> userList = (List<User>) model.get("userList");
        Sheet sheet = workbook.createSheet("users");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("账号");
        header.createCell(1).setCellValue("姓名");
        header.createCell(2).setCellValue("生日");

        int rowNum = 1;
        for (User user : userList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(user.getUserName());
            row.createCell(1).setCellValue(user.getRealName());
            row.createCell(2).setCellValue(DateFormatUtils.format(user.getBirthday(), "yyyy-MM-------dd"));
        }

    }
}
