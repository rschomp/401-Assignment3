package a3novice;

public class GrayPixel implements Pixel {

	private double intensity;
	
	public GrayPixel(double intensity) {
		if (intensity < 0.0 || intensity > 1.0 ) {throw new RuntimeException("Explanation string");}
		this.intensity = intensity;
	}

	public double getRed() {
		return intensity;
	}

	public double getGreen() {
		return intensity;
	}

	public double getBlue() {
		return intensity;
	}


	public double getIntensity() {
		return intensity;
		
	}


	
	public char getChar() {
		double intensity = getIntensity();
		if (intensity >= 0.0 && intensity <.10) { 
			return '#';
		} else if (intensity<.20) { 
			return 'M';
		} else if (intensity<.30) {
			return 'X';
		} else if (intensity<.40) {
			return 'D';
		} else if (intensity<.50) {
			return '<';
		} else if (intensity<.60) {
			return '>';
		} else if (intensity<.70) {
			return 's';
		} else if (intensity<.80) {
			return ':';
		} else if (intensity<.90) {
			return '-';
		} else {
			return ' ';
		}
		
	
	}
	
	
	
	
}
