package pojos;

public class PojoDummyExpData {

/*
    {
       "status":"success",
       "data":{
           "id":3,
           "employee_name":"Ashton Cox",
           "employee_salary":86000,
           "employee_age":66,
           "profile_image":""
           },
       "message":"Successfully! Record has been fetched."
 */
    private String status;
    private String message;
    private PojoDummyData data;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PojoDummyData getData() {
        return data;
    }

    public void setData(PojoDummyData data) {
        this.data = data;
    }

    public PojoDummyExpData(String status, String message, PojoDummyData data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public PojoDummyExpData() {
    }

    @Override
    public String toString() {
        return "PojoDummyExpData{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
