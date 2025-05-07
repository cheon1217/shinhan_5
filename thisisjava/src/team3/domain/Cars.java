package team3.domain;

import lombok.Data;

@Data
public class Cars {

	private int carId;
    private String model;
    private int age;
    private String carNum;
    private int branchId;

    public Cars(int carId, String model, int age, String carNum, int branchId) {
        this.carId = carId;
        this.model = model;
        this.age = age;
        this.carNum = carNum;
        this.branchId = branchId;
    }

    public int getCarId() { return carId; }
    public String getModel() { return model; }
    public int getAge() { return age; }
    public String getCarNum() { return carNum; }
    public int getBranchId() { return branchId; }

    public void setCarId(int carId) { this.carId = carId; }
    public void setModel(String model) { this.model = model; }
    public void setAge(int age) { this.age = age; }
    public void setCarNum(String carNum) { this.carNum = carNum; }
    public void setBranchId(int branchId) { this.branchId = branchId; }

    @Override
    public String toString() {
        return String.format(
            "🚘 차량ID: %-4d | 모델명: %-20s | 번호판: %-10s",
            carId, model, carNum
        );
    }



}
