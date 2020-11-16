import java.time.LocalDate;

public class TaskItem {
    private String title;
    private String description;
    private String date;
    private Boolean status;

    public TaskItem(String title, String date, String description){
        if(title.length() < 1){
            throw new IllegalArgumentException();
        }
        this.title = title;

        LocalDate dateToParse = LocalDate.parse(date);
        this.date = dateToParse.toString();

        this.description = description;

        if(this.date == date)
            this.status = false;
    }

    public TaskItem(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length() <= 0) {
            throw new IllegalArgumentException();
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        LocalDate dateToParse = LocalDate.parse(date);

        this.date = dateToParse.toString();
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

    public Boolean getStatus(){
        return this.status;
    }
}
