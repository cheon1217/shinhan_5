package team3.domain;

import lombok.Data;

@Data
public class Branches {
    private int branchId;
    private String location;
    private String name;
    private String phone;

    public Branches() {}

    public Branches(int branchId, String location, String name, String phone) {
        this.branchId = branchId;
        this.location = location;
        this.name = name;
        this.phone = phone;
    }

    public void setBranchId(int branchId) { this.branchId = branchId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

}

