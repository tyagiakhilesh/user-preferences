package com.akhilesh.learning.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries(
        @NamedQuery(
                name = "com.akhilesh.learning.db.entity.UserEntity.findAll",
                query = "SELECT u FROM UserEntity u"
        )
)
public class UserEntity {
    @Id
    private String userId;
    private String userName;
    private String emailId;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Preferences preferences;

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(final Preferences preferences) {
        this.preferences = preferences;
    }

    //</editor-fold>
}
