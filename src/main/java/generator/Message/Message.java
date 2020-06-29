package generator.Message;

public class Message {

    public Message() {
    }

    public Message(Integer target_id, String data, Integer client_id) {
        this.target_id = target_id;
        this.data = data;
        this.client_id = client_id;
    }

    private Integer target_id;
    private String data;
    private Integer client_id;

    public Integer getTarget_id() {
        return target_id;
    }

    public String getData() {
        return data;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setTarget_id(Integer target_id) {
        this.target_id = target_id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }
}
