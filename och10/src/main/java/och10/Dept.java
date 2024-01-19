package och10;

public class Dept { 
	/*dto : data 전달하는 객체 단위
(일반적 table 단위) */
	private int deptno;
	private String dname;
	private String loc;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
