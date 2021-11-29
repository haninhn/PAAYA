package test.app.paaya;

public class LostHelperClass {

    String mainCategory, subCategory, objectColor, objectDate, userReward, objectFoundLocation, num;

    public LostHelperClass(String mainCategory, String subCategory, String objectColor, String objectDate, String userReward, String objectFoundLocation, String num) {
        this.mainCategory =mainCategory ;
        this.subCategory = subCategory;
        this.objectColor = objectColor;
        this.objectDate = objectDate;
        this.userReward = userReward;
        this.objectFoundLocation=objectFoundLocation;
        this.num=num;
    }
    public String getMainCategory() {
        return mainCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public String getObjectColor() {
        return objectColor;
    }

    public String getObjectDate() {
        return objectDate;
    }

    public String getUserQuestion() {
        return userReward;
    }

    public String getObjectFoundLocation() {
        return objectFoundLocation;
    }

    public String getNum() {
        return num;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setObjectColor(String objectColor) {
        this.objectColor = objectColor;
    }

    public void setObjectDate(String objectDate) {
        this.objectDate = objectDate;
    }

    public void setUserQuestion(String userQuestion) {
        this.userReward = userQuestion;
    }

    public void setObjectFoundLocation(String objectFoundLocation) {
        this.objectFoundLocation = objectFoundLocation;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
