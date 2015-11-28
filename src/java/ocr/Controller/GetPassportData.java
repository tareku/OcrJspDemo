package ocr.Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
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
//    String saveFile = "C:\\tmp";
//      String saveFile = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\NetBeansProjects\\OcrJspDemo\\src\\java\\temporaryImage";
//    String saveFile = "C:\\Users\\TAREK\\Documents\\NetBeansProjects\\OcrJspDemo\\src\\java\\temporaryImage";

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
        try {
//------------------------------------------------------------------------------
            //Get selected passport image
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
                        String temporaryImage = FilenameUtils.getName(itemname);
                        File tif = CreateTemporaryImage(temporaryImage);
                        item.write(tif);
                        BufferedImage img = ImageIO.read(tif);
//------------------------------------------------------------------------------               
                        String mrz = getMachineReadableZone(tif, img);
                        PassportDetail p = setPassportDetail(mrz, img, request, response);
                        //Send Results to web page
                        SetPassportImage spi = new SetPassportImage();
//                        spi.doPost(request, response);
                        request.setAttribute("PassportDetail", p);
                        RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
                        dis.forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("bye jsp post");
    }

    private File CreateTemporaryImage(String filename) {
        File f = new File(saveFile + "/" + filename);
        if (f.exists()) {
            StringBuffer sb;
            sb = new StringBuffer(filename);
            sb.insert(sb.lastIndexOf("."), "-" + new Date().getTime());
            f = new File(saveFile + "/" + sb.toString());
        }
        return f;
    }

    //Create Temporary Image
    //Convert temporary image to bufferedImage for further use
    //Return binarized BufferedImage (better OCR)
    //Extract passport MRZ 
    //Delete temporary image
    private String getMachineReadableZone(File tif, BufferedImage img) {
        String mrz = null;
        try {
            OcrModel ocrModel = new OcrModel();
            BufferedImage convertedimg = ocrModel.ConvertImage(img);
            mrz = ocrModel.dataExtract(convertedimg).toUpperCase();
            ocrModel.deleteConvertedImg(tif.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mrz;
    }

    //Set passport data from MRZ 
    private PassportDetail setPassportDetail(String mrz, BufferedImage img,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ByteArrayOutputStream baos;
        baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        baos.flush();
        byte[] passImg = baos.toByteArray();
        baos.close();
        
        PassportModel pm = new PassportModel();
        String firstline = pm.getFirstLine(mrz);
        String secondline = pm.getSecondLine(mrz);
        PassportDetail p = new PassportDetail();
        p.setImg(pm.setImage(request, response, passImg));
        p.setMrz(mrz.trim());
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
        return p;
    }

}
