package fmi.informatics.functional;


//��������� ��������� IGravity � default �����
public interface IGravity {
	
	default double acceleration() {
		return 9.80665;
	}
	default double speedAtImpact(double heightMeters) {
		return Math.sqrt(2 * acceleration() * heightMeters);
		
	}

	double height();

}