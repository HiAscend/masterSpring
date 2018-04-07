package com.smart.chapter17.web;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.smart.chapter17.domain.User;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * UserListPdfView
 * 需要引入一个jar，否则会出错
 *
 * @author zziaa
 * @date 2018/04/07 20:02
 */
public class UserListPdfView extends AbstractPdfView {
    /**
     * Subclasses must implement this method to build an iText PDF document,
     * given the model. Called between {@code Document.open()} and
     * {@code Document.close()} calls.
     * <p>Note that the passed-in HTTP response is just supposed to be used
     * for setting cookies or other HTTP headers. The built PDF document itself
     * will automatically get written to the response after this method returns.
     *
     * @param model    the model Map
     * @param document the iText Document to add elements to
     * @param writer   the PdfWriter to use
     * @param request  in case we need locale etc. Shouldn't look at attributes.
     * @param response in case we need to set cookies. Shouldn't write to it.
     * @throws Exception any exception that occurred during document building
     * @see Document#open()
     * @see Document#close()
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Disposition", "inline; filename=" + new String("用户列表".getBytes(), Charset.forName("ISO-8859-1")));
        List<User> userList = (List<User>) model.get("userList");
        Table table = new Table(3);
        table.setWidth(80);
        table.setBorder(1);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
        BaseFont baseFont = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
        Font font = new Font(baseFont, 10, Font.NORMAL, Color.BLUE);

        table.addCell(buildFontCell("账号", font));
        table.addCell(buildFontCell("姓名", font));
        table.addCell(buildFontCell("生日", font));

        for (User user : userList) {
            table.addCell(user.getUserName());
            table.addCell(buildFontCell(user.getRealName(), font));
            table.addCell(DateFormatUtils.format(user.getBirthday(), "yyyy-MM-dd"));
        }
        document.add(table);
    }

    private Cell buildFontCell(String context, Font font) {
        try {
            Phrase phrase = new Phrase(context, font);
            return new Cell(phrase);
        } catch (BadElementException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
