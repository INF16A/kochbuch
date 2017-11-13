package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;

/**
 * @author 💩 Alexander Krieg
 * @author Daniel Abel
 * @author Marc Reinke
 */

@Data
public class CommentRequest
{
    @NonNull
    private String text;
    @NonNull
    private Date creationDate;
    @NonNull
    private long recipe_id;
    @NonNull
    private long user_id;

    public long getRecipeId(){
        return this.recipe_id;
    }
    public long getUserId(){
        return this.user_id;
    }
    public Date getCreationDate(){
        return this.creationDate;
    }
    public String getText(){
        return this.text;
    }
}