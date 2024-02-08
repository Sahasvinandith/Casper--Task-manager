package com.raven.model;

import javax.swing.Icon;

public class Model_Card {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getname() {
        return name;
    }

    public void setTitle(String title) {
        this.name = name;
    }

    public String getcomment() {
        return motivation_comment;
    }

    public void setcomment(String comment) {
        this.motivation_comment = comment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Model_Card(Icon icon, String name, String motivation_comment, String description) {
        this.icon = icon;
        this.name = name;
        this.motivation_comment = motivation_comment;
        this.description = description;
    }

    public Model_Card() {
    }

    private Icon icon;
    private String name;
    private String motivation_comment;
    private String description;
}
