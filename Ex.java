class Ex {
	public static void main(String[] args) {
		Employee one = new Permanent();
		Employee two = new Salesman();
		one.sabun = 1;
		one.name = "lji";
		two.sabun = 2;
		two.name = "kcs";
		/* ���� �� ��*/

		/* ���� �� ����*/
		one.printEmployeeInfo();
		two.printEmployeeInfo();
	}
}