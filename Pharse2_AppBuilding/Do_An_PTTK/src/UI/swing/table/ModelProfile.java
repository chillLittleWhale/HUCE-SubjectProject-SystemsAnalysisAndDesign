 package UI.swing.table;

import javax.swing.Icon;

public class ModelProfile {

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    
    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelProfile(Icon icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public ModelProfile(Icon icon, String name, String sdt) {
        this.icon = icon;
        this.name = name;
        this.sdt = sdt;
    }
    public ModelProfile() {
    }

    private Icon icon;
    private String name;
    private String sdt;

}
