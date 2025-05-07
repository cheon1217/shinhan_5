package ch12.sec03.exam01;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@ToString
//@Getter
//@Setter
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	public String id;
//	public Member(String id) {
//		this.id = id;
//	}
	
	public String getId() {
		return id+"님";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member target) {
			if (this.id.equals(target.id )) {
				return true;
			}
		}
		return false;
	}
}
