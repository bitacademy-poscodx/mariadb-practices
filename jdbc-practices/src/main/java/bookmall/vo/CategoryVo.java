package bookmall.vo;

public class CategoryVo {
	private Long no;
	private String name;
	
	public CategoryVo(String name) {
		this.name = name;
	}
	
	public CategoryVo() {
	}

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", name=" + name + "]";
	}
}
