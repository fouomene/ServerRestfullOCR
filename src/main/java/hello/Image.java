package hello;

public class Image {

    private final long id;
    private final String content;

    public Image(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
