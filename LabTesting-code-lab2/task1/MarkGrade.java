
public class MarkGrade {
	
	private Grade grade;
	Integer mark;

	public MarkGrade(Integer mark, Grade grade) {
		this.grade 	= grade;
		this.mark 	= mark;
	}
	
	@Override
	public boolean equals(Object obj) {
		MarkGrade mg 	= (MarkGrade) obj;
		return mg.grade == this.grade && mg.mark == this.mark;
	}
	
	@Override
	public String toString() {
		return this.mark + " " + this.grade;
	}
}
