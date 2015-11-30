package ocr.Data;

public class PassportDetail {

    char doctypecode, type, passnumbercheckdigit, birthdaycheck,
            sex, expirationdatecheck, personalnumbercheck, compositenumber;
    String mrz = "", doctypevalue = "", statecode = "", statevalue = "", namecode = "",
            namevalue = "", passnumbercode = "", passnumbervalue = "", nationalitycode = "", nationalityvalue = "", birthdaycode = "", birthdayvalue = "",
            sexvalue = "", expirationdatecode = "", expirationdatevalue = "", personalnumbercode = "", personalnumbervalue = "";
    byte img[];

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public char getDoctypecode() {
        return doctypecode;
    }

    public void setDoctypecode(char doctypecode) {
        this.doctypecode = doctypecode;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getPassnumbercheckdigit() {
        return passnumbercheckdigit;
    }

    public void setPassnumbercheckdigit(char passnumbercheckdigit) {
        this.passnumbercheckdigit = passnumbercheckdigit;
    }

    public char getBirthdaycheck() {
        return birthdaycheck;
    }

    public void setBirthdaycheck(char birthdaycheck) {
        this.birthdaycheck = birthdaycheck;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public char getExpirationdatecheck() {
        return expirationdatecheck;
    }

    public void setExpirationdatecheck(char expirationdatecheck) {
        this.expirationdatecheck = expirationdatecheck;
    }

    public char getPersonalnumbercheck() {
        return personalnumbercheck;
    }

    public void setPersonalnumbercheck(char personalnumbercheck) {
        this.personalnumbercheck = personalnumbercheck;
    }

    public char getCompositenumber() {
        return compositenumber;
    }

    public void setCompositenumber(char compositenumber) {
        this.compositenumber = compositenumber;
    }

    public String getMrz() {
        return mrz;
    }

    public void setMrz(String mrz) {
        this.mrz = mrz;
    }

    public String getDoctypevalue() {
        return doctypevalue;
    }

    public void setDoctypevalue(String doctypevalue) {
        this.doctypevalue = doctypevalue;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getStatevalue() {
        return statevalue;
    }

    public void setStatevalue(String statevalue) {
        this.statevalue = statevalue;
    }

    public String getNamecode() {
        return namecode;
    }

    public void setNamecode(String namecode) {
        this.namecode = namecode;
    }

    public String getNamevalue() {
        return namevalue;
    }

    public void setNamevalue(String namevalue) {
        this.namevalue = namevalue;
    }

    public String getPassnumbercode() {
        return passnumbercode;
    }

    public void setPassnumbercode(String passnumbercode) {
        this.passnumbercode = passnumbercode;
    }

    public String getPassnumbervalue() {
        return passnumbervalue;
    }

    public void setPassnumbervalue(String passnumbervalue) {
        this.passnumbervalue = passnumbervalue;
    }

    public String getNationalitycode() {
        return nationalitycode;
    }

    public void setNationalitycode(String nationalitycode) {
        this.nationalitycode = nationalitycode;
    }

    public String getNationalityvalue() {
        return nationalityvalue;
    }

    public void setNationalityvalue(String nationalityvalue) {
        this.nationalityvalue = nationalityvalue;
    }

    public String getBirthdaycode() {
        return birthdaycode;
    }

    public void setBirthdaycode(String birthdaycode) {
        this.birthdaycode = birthdaycode;
    }

    public String getBirthdayvalue() {
        return birthdayvalue;
    }

    public void setBirthdayvalue(String birthdayvalue) {
        this.birthdayvalue = birthdayvalue;
    }

    public String getSexvalue() {
        return sexvalue;
    }

    public void setSexvalue(String sexvalue) {
        this.sexvalue = sexvalue;
    }

    public String getExpirationdatecode() {
        return expirationdatecode;
    }

    public void setExpirationdatecode(String expirationdatecode) {
        this.expirationdatecode = expirationdatecode;
    }

    public String getExpirationdatevalue() {
        return expirationdatevalue;
    }

    public void setExpirationdatevalue(String expirationdatevalue) {
        this.expirationdatevalue = expirationdatevalue;
    }

    public String getPersonalnumbercode() {
        return personalnumbercode;
    }

    public void setPersonalnumbercode(String personalnumbercode) {
        this.personalnumbercode = personalnumbercode;
    }

    public String getPersonalnumbervalue() {
        return personalnumbervalue;
    }

    public void setPersonalnumbervalue(String personalnumbervalue) {
        this.personalnumbervalue = personalnumbervalue;
    }

    @Override
    public String toString() {
        return "Document Type: " + getDoctypevalue() + "\n"
                + "Type: " + getType() + "\n"
                + "Issuing State: " + getStatevalue() + "\n"
                + "Name: " + getNamevalue() + "\n"
                + "Passport number: " + getPassnumbervalue()+ "\n"
                + "Passport number check digit: " + getPassnumbercheckdigit() + "\n"
                + "Nationality: " + getNationalityvalue() + "\n"
                + "birthday: " + getBirthdayvalue() + "\n"
                + "Birthday check number: " + getBirthdaycheck() + "\n"
                + "Sex: " + getSex() + "\n"
                + "Expiration date: " + getExpirationdatevalue() + "\n"
                + "Expiration date check: " + getExpirationdatecheck() + "\n"
                + "Personal number: " + getPersonalnumbervalue() + "\n"
                + "Personal number check: " + getPersonalnumbercheck() + "\n"
                + "Composide number: " + getCompositenumber() + "\n";
    }
}
