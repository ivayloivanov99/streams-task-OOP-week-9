package fmi.informatics.functional;

//������������� ���� ���� ������������� ���������� IGravity
public class Rock implements IGravity{


	public void drop(double height) {
		double heightMeters = Math.abs(height);
		double timeToHitGround = Math.sqrt(2 * heightMeters / acceleration()); 

		
		System.out.format("It took %f seconds for the rock to hit the ground", timeToHitGround);
		System.out.format("\nThe speed of impact was %f ", speedAtImpact(heightMeters));
	}
	
	@Override
	public double height() {
		return 1442.2;
	}

	
}
