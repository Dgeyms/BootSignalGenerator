package org.boottrading.model;

public class Boot {
    private Long id;
    private String nameBoot;

    public Boot(String nameBoot) {
        this.nameBoot = nameBoot;
    }

    public String getNameBoot() {
        return nameBoot;
    }

    public void setNameBoot(String nameBoot) {
        this.nameBoot = nameBoot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
