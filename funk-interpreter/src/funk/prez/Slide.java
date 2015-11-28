package funk.prez;

public class Slide {
	private Presentation parent = null;
	
	public void attach(Presentation parent) {
		this.parent = parent;
	}
	
	protected void nextSlide() {
		parent.nextSlide();
	}
	
	public void fullscreen() {
		parent.fullscreen();
	}
	
	public void windowed() {
		parent.windowed();
	}
	
	public void show() {
		
	}
	
	public void hide() {
		
	}
}
