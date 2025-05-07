package mariadb.assignment;

import java.util.Date;

import lombok.Data;

@Data
public class Professor {
	private int no;
	private String name;
	private String id;
	private String position;
	private int salary;
	private Date hiredate;
	private int bonus;
	private int deptno;
	private String email;
	private String url;
}
