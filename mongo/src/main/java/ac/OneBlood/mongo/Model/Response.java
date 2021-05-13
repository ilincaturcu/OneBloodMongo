package ac.OneBlood.mongo.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    public Integer question_number;
    public String response;

    @Override
    public boolean equals(Object c) {
        if (c == null)
            return false;

        if (!Response.class.isAssignableFrom(c.getClass()))
            return false;

        Response obj = (Response) c;

        return this.getQuestion_number().equals(obj.getQuestion_number())
                && this.getResponse().equals(obj.getResponse());
    }
}
