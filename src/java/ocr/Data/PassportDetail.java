package ocr.Data;

public class PassportDetail {

    
    char doctype, type, passnumbercheckdigit, birthdaycheck,
            sex, expirationdatecheck, personalnumbercheck, compositenumber;
    String mrz = "", state, name = "", passnumber = "", nationality = "", birthday = "",
            expirationdate = "", personalnumber = "";
    byte img[];

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getMrz() {
        return mrz;
    }

    public void setMrz(String mrz) {
        this.mrz = mrz;
    }

    public char getDoctype() {
        return doctype;
    }

    public void setDoctype(char doctype) {
        this.doctype = doctype;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassnumber() {
        return passnumber;
    }

    public void setPassnumber(String passnumber) {
        this.passnumber = passnumber;
    }

    public char getPassnumbercheckdigit() {
        return passnumbercheckdigit;
    }

    public void setPassnumbercheckdigit(char passnumbercheckdigit) {
        this.passnumbercheckdigit = passnumbercheckdigit;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public char getExpirationdatecheck() {
        return expirationdatecheck;
    }

    public void setExpirationdatecheck(char expirationdatecheck) {
        this.expirationdatecheck = expirationdatecheck;
    }

    public String getPersonalnumber() {
        return personalnumber;
    }

    public void setPersonalnumber(String personalnumber) {
        this.personalnumber = personalnumber;
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

    @Override
    public String toString() {
        return "Document Type: " + getDoctype() + "\n"
                + "Type: " + getType() + "\n"
                + "Issuing State: " + getState() + "\n"
                + "Name: " + getName() + "\n"
                + "Passport number: " + getPassnumber() + "\n"
                + "Passport number check digit: " + getPassnumbercheckdigit() + "\n"
                + "Nationality: " + getNationality() + "\n"
                + "birthday: " + getBirthday() + "\n"
                + "Birthday check number: " + getBirthdaycheck() + "\n"
                + "Sex: " + getSex() + "\n"
                + "Expiration date: " + getExpirationdate() + "\n"
                + "Expiration date check: " + getExpirationdatecheck() + "\n"
                + "Personal number: " + getPersonalnumber() + "\n"
                + "Personal number check: " + getPersonalnumbercheck() + "\n"
                + "Composide number: " + getCompositenumber() + "\n";
    }
}
