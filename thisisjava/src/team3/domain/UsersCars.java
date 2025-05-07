package team3.domain;

import java.util.Date;

import lombok.Data;

@Data
public class UsersCars {
	 private int ucno;
	    private int paymentsId;
	    private int carId;
	    private int userId;
	    private Date startdate;
	    private Date enddate;
	    private String price;
	    private String status;
	    private Date createdAt;

	    public UsersCars(int ucno, int paymentsId, int carId, int userId,
	                     Date startdate, Date enddate, String price, String status, Date createdAt) {
	        this.ucno = ucno;
	        this.paymentsId = paymentsId;
	        this.carId = carId;
	        this.userId = userId;
	        this.startdate = startdate;
	        this.enddate = enddate;
	        this.price = price;
	        this.status = status;
	        this.createdAt = createdAt;
	    }

	    public int getUcno() { return ucno; }
	    public int getPaymentsId() { return paymentsId; }
	    public int getCarId() { return carId; }
	    public int getUserId() { return userId; }
	    public Date getStartdate() { return startdate; }
	    public Date getEnddate() { return enddate; }
	    public String getPrice() { return price; }
	    public String getStatus() { return status; }
	    public Date getCreatedAt() { return createdAt; }

	    public void setUcno(int ucno) { this.ucno = ucno; }
	    public void setPaymentsId(int paymentsId) { this.paymentsId = paymentsId; }
	    public void setCarId(int carId) { this.carId = carId; }
	    public void setUserId(int userId) { this.userId = userId; }
	    public void setStartdate(Date startdate) { this.startdate = startdate; }
	    public void setEnddate(Date enddate) { this.enddate = enddate; }
	    public void setPrice(String price) { this.price = price; }
	    public void setStatus(String status) { this.status = status; }
	    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

	    @Override
	    public String toString() {
	        return String.format(
	            "🚗 대여번호: %-4d | 차량ID: %-4d | 💰 요금: %-8s | 📦 상태: %-10s | 📅 기간: %s ~ %s",
	            ucno, carId, price, status,
	            startdate != null ? startdate.toString() : "미정",
	            enddate != null ? enddate.toString() : "미정"
	        );
	    }


}

