package ocr.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ocr.Data.PassportDetail;

import ocr.Model.OcrModel;
import ocr.Model.PassportModel;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class GetPassportData extends HttpServlet {

    String saveFile = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        System.out.println("Hi jsp post");
        try {
            boolean ismultipart = ServletFileUpload.isMultipartContent(request);
            if (!ismultipart) {

            } else {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);

                List items = null;

                try {
                    items = upload.parseRequest(request);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Iterator itr;
                itr = items.iterator();
                while (itr.hasNext()) {
                    FileItem item = (FileItem) itr.next();
                    if (item.isFormField()) {

                    } else {
                        String itemname = item.getName();

                        if ((itemname == null || itemname.equals(""))) {
                            continue;
                        }

                        String filename = FilenameUtils.getName(itemname);
                        File path = new File(filename);
//                        System.out.println("file path: " + path.getAbsolutePath()+" "+itemname);
//                      --------------------------------------------------------
                        OcrModel ocrModel = new OcrModel();
                        //return image absolute path
//                        String img = ocrModel.getPassport();
                        //Return binarize image path 
//                        String convertedimg = ocrModel.ConvertImage(path.getAbsolutePath());
                        //Extract data string
//                        String r = ocrModel.dataExtract(saveFile + "/" + filename).toUpperCase();
                        //Delete binarize image
//                        ocrModel.deleteConvertedImg(convertedimg);
//                        System.out.println("result: " + r);
//                      --------------------------------------------------------  
                        File f = checkExist(filename);
//                        System.out.println("new file path: " + f.getAbsolutePath());
                        item.write(f);
                        //Return binarize image path 
                        String convertedimg = ocrModel.ConvertImage(f.getAbsolutePath());
//                        System.out.println("bin file path: " + convertedimg);
                        //Extract data string
                        String mrz = ocrModel.dataExtract(convertedimg).toUpperCase();
                        //Delete binarize image
                        ocrModel.deleteConvertedImg(convertedimg);
                        ocrModel.deleteConvertedImg(f.getAbsolutePath());
                        System.out.println("result: " + mrz);                        
                        PassportModel pm = new PassportModel();
                        String firstline = pm.getFirstLine(mrz);
                        String secondline = pm.getSecondLine(mrz);
//                        System.out.println("first line: "+firstline);                        
//                        System.out.println("second line: "+secondline);                        
                        PassportDetail p = new PassportDetail();                        
                        p.setMrz(mrz);  
                        p.setDoctype(pm.getMrzDocType(firstline));
                        p.setState(pm.getMrzState(firstline));
                        p.setType(pm.getMrzType(firstline));
                        p.setName(pm.getMrzName(firstline));
                        p.setPassnumber(pm.getMrzPassNumber(secondline));
                        p.setPassnumbercheckdigit(pm.getMrzPassNumberCheckDigit(secondline));
                        p.setNationality(pm.getMrzNationality(secondline));
                        p.setBirthday(pm.getMrzBirthday(secondline));
                        p.setBirthdaycheck(pm.getMrzBirthdayCkeck(secondline));
                        p.setSex(pm.getMrzSex(secondline));
                        p.setExpirationdate(pm.getMrzExpirationDate(secondline));
                        p.setExpirationdatecheck(pm.getMrzExpirationDateCheck(secondline));
                        p.setPersonalnumber(pm.getMrzPersonalNumber(secondline));
                        p.setPersonalnumbercheck(pm.getMrzPersonalNumberCheck(secondline));
                        p.setCompositenumber(pm.getMrzCompositeNumber(secondline));
                        System.out.println(p.toString());
//                        p.setPassportPath(/*f.getAbsolutePath()*/path.getAbsolutePath());
                        request.setAttribute("PassportDetail", p);
                        RequestDispatcher dis = request.getRequestDispatcher("output.jsp");
                        dis.forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("bye jsp post");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private File checkExist(String filename) {
        File f = new File(saveFile + "/" + filename);
        if (f.exists()) {
            StringBuffer sb;
            sb = new StringBuffer(filename);
            sb.insert(sb.lastIndexOf("."), "-" + new Date().getTime());
            f = new File(saveFile + "/" + sb.toString());
        }
        return f;
    }

}
