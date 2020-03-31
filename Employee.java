abstract class Employee {
	int sabun;
	String name;
	/* 구간 ⓐ 끝*/

	/* 구간 ⓑ 시작*/
	abstract int getSalary();
	/* 구간 ⓑ 끝*/


	/* 구간 ⓒ 시작*/
	void printEmployeeInfo() {
		System.out.println("사번: " + sabun + ", 이름: " +
				name + ", 봉급 " + getSalary());
	}
}
/* 구간 ⓒ 끝*/

/* 구간 ⓓ 시작*/
class Permanent extends Employee {
	int getSalary() {
		return 100;
	}
}
/* 구간 ⓓ 끝*/

/* 구간 ⓔ 시작*/
class Salesman extends Permanent {
	int getSalary() {
		return 10 + super.getSalary();
	}
}
/* 구간 ⓔ 끝*/

/* 구간 ⓕ 시작*/

/* 구간 ⓖ 끝*/