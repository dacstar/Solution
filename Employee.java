abstract class Employee {
	int sabun;
	String name;
	/* ���� �� ��*/

	/* ���� �� ����*/
	abstract int getSalary();
	/* ���� �� ��*/


	/* ���� �� ����*/
	void printEmployeeInfo() {
		System.out.println("���: " + sabun + ", �̸�: " +
				name + ", ���� " + getSalary());
	}
}
/* ���� �� ��*/

/* ���� �� ����*/
class Permanent extends Employee {
	int getSalary() {
		return 100;
	}
}
/* ���� �� ��*/

/* ���� �� ����*/
class Salesman extends Permanent {
	int getSalary() {
		return 10 + super.getSalary();
	}
}
/* ���� �� ��*/

/* ���� �� ����*/

/* ���� �� ��*/