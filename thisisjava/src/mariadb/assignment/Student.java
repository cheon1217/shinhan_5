package mariadb.assignment;

import java.util.Date;

import lombok.Data;

@Data
public class Student {
	private int studNo;
	private String name;
	private String id;
	private int grade;
	private String jumin;
	private Date birthday;
	private String tel;
	private int height;
	private int wieght;
	private int major1;
	private int major2;
	private int profno;
}
