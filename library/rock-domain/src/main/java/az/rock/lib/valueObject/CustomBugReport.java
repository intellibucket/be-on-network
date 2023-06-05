package az.rock.lib.valueObject;

import java.util.List;

public class CustomBugReport {

    private String title;
    private String description;
    private String email;
    private List<Byte[]> screenshots;
    private Boolean repeatable;

    public CustomBugReport(String title, String description, String email, List<Byte[]> screenshots, Boolean repeatable) {
        this.title = title;
        this.description = description;
        this.email = email;
        this.screenshots = screenshots;
        this.repeatable = repeatable;
    }

    public CustomBugReport(){}

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public List<Byte[]> getScreenshots() {
        return screenshots;
    }

    public Boolean getRepeatable() {
        return repeatable;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRepeatable(Boolean repeatable) {
        this.repeatable = repeatable;
    }

    public void setScreenshots(List<Byte[]> screenshots) {
        this.screenshots = screenshots;
    }

    public Boolean hasScreenshots(){
        return !screenshots.isEmpty();
    }

    public Boolean hasEmail(){
        return email != null;
    }

    public Boolean hasTitle(){
        return title != null;
    }

    public Boolean hasDescription(){
        return description != null;
    }

    public Boolean hasAll(){
        return hasTitle() && hasDescription() && hasEmail() && hasScreenshots();
    }

    public Boolean hasAllExceptScreenshots(){
        return hasTitle() && hasDescription() && hasEmail();
    }

    public Boolean validScreenshots(){
        return screenshots.stream().allMatch(screenshot -> screenshot.length > 0 && screenshot.length < 4096);
    }
}
