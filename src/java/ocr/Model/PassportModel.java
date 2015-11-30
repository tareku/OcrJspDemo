package ocr.Model;

import com.neovisionaries.i18n.CountryCode;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassportModel {

    public enum Months {

        January, February, March, April, May, June, July, August, September, October, November, December
    }

    //Return MRZ first line
    public String getFirstLine(String mrz) {
        return mrz.substring(0, 44);
    }

    //Return MRZ second line
    public String getSecondLine(String mrz) {
        return mrz.substring(45, mrz.length());
    }

    //get image and converted to byte for further use
    public byte[] setImage(HttpServletRequest request, HttpServletResponse response, byte[] passImg)
            throws ServletException, IOException {
        OutputStream oImage;
        byte barray[] = passImg;
//        response.setContentType("image/png");
//        oImage = response.getOutputStream();
//        oImage.write(barray);
//        oImage.flush();
//        oImage.close();
        return barray;

    }

    //Return MRZ Document type(usually Passport, or Unknown Document Type)
    public String getMrzDocTypeValue(char dt) {        
        String doctype;
        if(dt == 'P') doctype = "Passsport";
        else doctype = "Unknown Document Type";
        return doctype; 
    }
    
    //Return MRZ Document type(usually P, indicating a passport)
    public char getMrzDocTypeCode(String firstline) {
        char dt = firstline.charAt(0);
        return dt;
    }

    //Type (for countries that distinguish between different types of passports)
    public char getMrzType(String firstline) {
        char type = firstline.charAt(1);
        return type;
    }

    //Issuing country or organization
    public String getMrzStateCode(String firstline) {
        String state = firstline.substring(2, 5);
        return state;
    }
    
    //Issuing country or organization value ISO 
    public String getMrzStateValue(String state) {  
        CountryCode code = CountryCode.getByCode(state);            
        code.getName();
        return code.getName();
    }

    //Surname, followed by two filler characters, followed by given names
    public String getMrzNameCode(String firstline) {
        String name = firstline.substring(5, firstline.length());
        return name;
    }
    //Surname, followed by given names, without filler characters
    public String getMrzNameValue(String name) {        
        return name.replace("<", " ").trim();
    }

    //Return Passport number, followed by filler characters
    public String getMrzPassNumberCode(String secondline) {
        String num = secondline.substring(0, 9);
        return num;
    }
    
    //Return Passport number, without filler characters
    public String getMrzPassNumberValue(String num) {      
        return num.replace("<", "").trim();
    }

    //Return Passport number Check digit
    public char getMrzPassNumberCheckDigit(String secondline) {
        return secondline.charAt(9);
    }

    //Return Nationality (ISO 3166-1 alpha-3 code with modifications)
    public String getMrzNationalityCode(String secondline) {
        String nat = secondline.substring(10, 13);
        return nat;
    }
    
    //Return Nationality (ISO 3166-1 alpha-3 code with modifications)
    public String getMrzNationalityValue(String secondline) {
        String nat = secondline.substring(10, 13);
        return nat;
    }

    //Return Date of birth (YYMMDD to DDMMYYY)
    public String getMrzBirthdayCode(String secondline) {
        String birth = secondline.substring(13, 19);
//        String year = birth.substring(0, 2);
//        String month = birth.substring(2, 4);
//        String day = birth.substring(4, 6);
//        String Birthday = day + " " + Months.values()[Integer.parseInt(month) - 1] + " " + year;
//        return Birthday.trim();
        return birth;
    }
    
    //Return Date of birth (YYMMDD to DDMMYYY)
    public String getMrzBirthdayValue(String birth) {
//        String birth = secondline.substring(13, 19);
        String year = birth.substring(0, 2);
        String month = birth.substring(2, 4);
        String day = birth.substring(4, 6);
        String Birthday = day + " " + Months.values()[Integer.parseInt(month) - 1] + " " + year;
        return Birthday.trim();
    }

    //Return Date of birth Check digit
    public char getMrzBirthdayCkeck(String secondline) {
        return secondline.charAt(19);
    }

    //Return Sex(M, F)
    public char getMrzSexCode(String secondline) {
        return secondline.charAt(20);
//        char s = secondline.charAt(20);
//        String sex;
//        if(s = 'M')
//            sex = "Male":
//        else if(s = 'F')
//            sex = "Female";
//        return sex;
    }
    
    //Return Sex(M: Male, F: Female)
    public String getMrzSexValue(char s) {
//        return secondline.charAt(20);
//        char s = secondline.charAt(20);
        String sex = "";
        if(s == 'M')
            sex = "Male";
        else if(s == 'F')
            sex = "Female";
        return sex;
    }

    //Retrun Expiration date of passport (YYMMDD)
    public String getMrzExpirationDateCode(String secondline) {
        String exp = secondline.substring(21, 27);
//        String year = exp.substring(0, 2);
//        String month = exp.substring(2, 4);
//        String day = exp.substring(4, 6);
//        exp = day + " " + Months.values()[Integer.parseInt(month) - 1] + " " + year;
//        return exp.trim();
        return exp;
    }
    
     //Retrun Expiration date of passport (YYMMDD to DDMMYY)
    public String getMrzExpirationDateValue(String exp) {
//        String exp = secondline.substring(21, 27);
        String year = exp.substring(0, 2);
        String month = exp.substring(2, 4);
        String day = exp.substring(4, 6);
        exp = day + " " + Months.values()[Integer.parseInt(month) - 1] + " " + year;
        return exp.trim();
    }

    //Retrun Expiration date of passport Check digit
    public char getMrzExpirationDateCheck(String secondline) {
        return secondline.charAt(27);
    }

    //Return Personal number (may be used by the issuing country as it desires)
    public String getMrzPersonalNumberCode(String secondline) {
        String num = secondline.substring(28, 42);
        return num;
    }
    
    //Return Personal number (may be used by the issuing country as it desires)
    public String getMrzPersonalNumberValue(String num) {
//        String num = secondline.substring(28, 42);
        return num.replace("<", " ");
    }

    //Return Personal number Check digit
    public char getMrzPersonalNumberCheck(String secondline) {
        return secondline.charAt(42);
    }

    //Return Composite number Check digit
    public char getMrzCompositeNumber(String secondline) {
        return secondline.charAt(43);
    }
}
