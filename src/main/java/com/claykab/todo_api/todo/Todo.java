package com.claykab.todo_api.todo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @SequenceGenerator(name = "todo_seq", initialValue = 1110, allocationSize = 101)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_seq")
    @Column(name = "todo_item_id", updatable = false, nullable = false)
    private long TodoId;

    @NotBlank
    @Size(min = 5, message = "A Description should have at least 5 characters")
    @Column(name = "todo_title")
    private String todoTitle;

    @NotBlank
    @Size(min = 5, message = "A Description should have at least 5 characters")
    @Column(name = "todo_description")
    private String todoDescription;


    @Column(name = "is_complete")
    private boolean isComplete;

    @FutureOrPresent
    @Column(name = "todo_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date todoDate;
    /**
     * @Column(name = "registration_date", updatable = false)
     *        @Temporal(TemporalType.TIMESTAMP)
     *
     *    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Africa/Johannesburg")
     * 	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "${ers.app.date.full.format}", timezone = "Africa/Johannesburg")
     *    @CreationTimestamp
     *    private Date registration_date;
     *
     *
     *    @Temporal(TemporalType.TIMESTAMP)
     *    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
     *    @UpdateTimestamp
     *    private Date update_date;
     */

    @Column(name = "creation_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss" )
    @CreationTimestamp
    private Date creationDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss" )
    @UpdateTimestamp
    private Date updateDate;

    public Todo() {
        //empty constructor
    }

    public Todo(long todoId, @NotBlank String todoTitle, @NotBlank String todoDescription, boolean isComplete, @FutureOrPresent Date todoDate, Date creationDate, Date updateDate) {
        TodoId = todoId;
        this.todoTitle = todoTitle;
        this.todoDescription = todoDescription;
        this.isComplete = isComplete;
        this.todoDate = todoDate;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public long getTodoId() {
        return TodoId;
    }

    public void setTodoId(long todoId) {
        TodoId = todoId;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public Date getTodoDate() {
        return todoDate;
    }

    public void setTodoDate(Date todoDate) {
        this.todoDate = todoDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
