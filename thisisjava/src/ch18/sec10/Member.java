package ch18.sec10;

import java.io.Serializable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Member implements Serializable {
	private static final long serialVersionUID = -622284561026719240L;
	private String id;
	private String name;
	
	@Override
	public String toString() {
		return id + ": " + name;
	}
}
