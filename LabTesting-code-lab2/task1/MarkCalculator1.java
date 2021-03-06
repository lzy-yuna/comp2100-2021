
public class MarkCalculator1 implements MarkCalculator {

	public MarkGrade calculateMark(int lab, int assignment1, int assignment2,
			int finalexam, boolean attendedFinal)
			throws ComponentOutOfRangeException {

		if (!(0 <= lab && lab <= 10 && 0 <= assignment1 && assignment1 <= 10
				&& 0 <= assignment2 && assignment2 <= 10 && 0 <= finalexam && finalexam <= 100))
			throw new ComponentOutOfRangeException();
		
		int m = (assignment1 * 150 + assignment2 * 150 + lab * 100 + finalexam * 60);
		int raw = ((m % 100 < 50) ? (m / 100) : (m / 100) + 1);

		if (raw < 45)
			return new MarkGrade(raw, Grade.N);
		else if (raw < 50)
			return new MarkGrade(raw, Grade.PX);
		else if (raw < 60)
			return new MarkGrade(raw, Grade.P);
		else if (raw < 70)
			return new MarkGrade(raw, Grade.C);
		else if (raw < 80)
			return new MarkGrade(raw, Grade.D);
		else
			return new MarkGrade(raw, Grade.HD);
	}
}
