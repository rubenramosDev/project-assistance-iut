package com.iut.assistance.production.models.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status_users")
public class StatusUser {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer code;

    //RELATIONS
    @OneToMany(mappedBy = "statusUser")
    private List<User> user;

    public StatusUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
