package com.akhilesh.learning.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Preferences {
    @Id
    @GeneratedValue
    private long id;
    private String fontName;
    private String style;
    private String icon;

    //<editor-fold defaultstate="collapsed" desc="Getters and setters">
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(final String fontName) {
        this.fontName = fontName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(final String style) {
        this.style = style;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(final String icon) {
        this.icon = icon;
    }

    //</editor-fold>
}
