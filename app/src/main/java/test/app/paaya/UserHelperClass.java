package test.app.paaya;

public  class UserHelperClass {
    String nameTxt, emailTxt, numTxt, adTxt,  gender;


    public UserHelperClass() {

    }
    public UserHelperClass(String nameTxt, String emailTxt, String numTxt, String adTxt, String gender) {
         this.nameTxt =nameTxt ;
         this.emailTxt = emailTxt;
         this.numTxt = numTxt;
         this.adTxt = adTxt;
         this.gender = gender;

    }



    public String getNameTxt() {
        return nameTxt;
    }

    public String getEmailTxt() {
        return emailTxt;
    }

    public String getNumTxt() {
        return numTxt;
    }

    public String getAdTxt() {
        return adTxt;
    }

    public String getRadio() {
        return gender;
    }

    public void setNameTxt(String nameTxt) {
        this.nameTxt = nameTxt;
    }

    public void setEmailTxt(String emailTxt) {
        this.emailTxt = emailTxt;
    }

    public void setNumTxt(String numTxt) {
        this.numTxt = numTxt;
    }

    public void setAdTxt(String adTxt) {
        this.adTxt = adTxt;
    }

    public void setRadio(String gender) {
        this.gender = gender;
    }
}
