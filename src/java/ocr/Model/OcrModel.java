package ocr.Model;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OcrModel {

    //Return binarized BufferedImage
    public BufferedImage ConvertImage(BufferedImage img) {
        OtsuBinarize ob = new OtsuBinarize();
        BufferedImage bin = null;
        try {
            bin = ob.BinarizeImage(img);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bin;
    }

    //Extract MRZ string
    public String dataExtract(BufferedImage convertedimg) {
        String ocrresult;
        String mrz = null;
        Tesseract instance;
        ImageIO.scanForPlugins();
        instance = Tesseract.getInstance();
        try {
//            
//            instance.setDatapath("C:\\Users\\TAREK\\Documents\\NetBeansProjects\\OcrJspDemo\\tessdata");
            instance.setDatapath("C:\\Users\\TAREK\\Documents\\NetBeansProjects\\OcrJspDemo\\src\\java\\tessdata");
            ocrresult = instance.doOCR(convertedimg);
            mrz = ocrresult.substring(ocrresult.indexOf("P<"), ocrresult.length());
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return mrz;
    }

    //Delete binarize image
    public void deleteConvertedImg(String path) {
        try {
            File img = new File(path);
            boolean b = img.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
