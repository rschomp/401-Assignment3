package a3jedi;

public class PictureImpl implements Picture {

	private int width;
	private int height;

	private Pixel[][] array;
	
	public PictureImpl(int width, int height){
		this.width = width;
		this.height = height;
		array = new Pixel[height][width];
		
		for (int i = 0; i<height; i++) {
			
			for (int k = 0; k<width; k++) {
				setPixel(k, i, new ColorPixel (1.0, 1.0, 1.0));	
			}	
		}
	}

	public int getWidth() {
		return width;
	}

	
	public int getHeight() {
		return height;
	}


	public void setPixel(int x, int y, Pixel p) {
		array[y][x] = p;
		
	}
	
	public Pixel getPixel(int x, int y) {
		return array[y][x];
		
	}
	int count = 0;
	public int countRange(double low, double high) {
		for (int i = 0; i<height; i++) {
			
			for (int k = 0; k<width; k++) {
				if (array[i][k].getIntensity() >= low && array[i][k].getIntensity() <= high) {
					count++;
				}
			}	
		
		}
		
		return count;
		
	}
	
	public void print() {
		for (int i = 0; i<height; i++) {
			
			for (int k = 0; k<width; k++) {
				System.out.print(getPixel(k, i).getChar());	
			}	
		System.out.println();
		}
		
	}
	
	public double calculatePSNR(Picture p) {
		if (p.getWidth() != this.getWidth() || p.getHeight() != this.getHeight()) {
			throw new RuntimeException("Dimensions not equal");
		}
		
		double sum = 0;
		for (int i = 0; i<height; i++) {

			for (int k = 0; k<width; k++) {
				double first = getPixel(k,i).getIntensity();	
				double second = p.getPixel(k, i).getIntensity();
				
				double math = (first - second) * (first - second); 
				sum += math;
			}	
			
		}
		
		double MSE = sum/(height*width);
		if (MSE == 0) {
			throw new RuntimeException("MSE cannot be zero");
		}
		
		double MAX = 1.0;
		double PSNR = 20*(Math.log10(MAX)) - 10*(Math.log10(MSE));
		
		return PSNR;
	}

}
