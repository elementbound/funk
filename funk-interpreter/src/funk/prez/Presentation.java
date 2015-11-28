package funk.prez;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

public class Presentation {
	private List<Slide> slides = new ArrayList<>();
	int slideAt = 0;
	private boolean isWindowed = true; 
	
	public static void main(String[] args) {
		Presentation prez = new Presentation();
		
		{
			TitleSlide slide = new TitleSlide();
			
			slide.setTitle("Funk Symbol Table Support");
			slide.setSecondaryTitle("Presentation now with 70% more plot twist!");
			
			prez.addSlide(slide);
		}
		
		{
			ListSlide slide = new ListSlide();
			
			slide.setTitle("Attenshun!");
			slide.addBullet("Shit's gonna go down!");
			slide.addBullet("Right on this slide!");
			slide.addBullet("Brace yourselves!");
			
			prez.addSlide(slide);
		}
		
		prez.start();
	}
	
	//
	
	public void addSlide(Slide slide) {
		slides.add(slide);
		slide.attach(this);
	}
	
	//
	
	public void start() {
		showSlide();
	}
	
	public void nextSlide() {
		hideSlide();
		
		slideAt++;
		slideAt = slideAt % slides.size();
		
		showSlide();
	}
	
	public void prevSlide() {
		hideSlide();
		
		slideAt--;
		if(slideAt < 0) 
			slideAt = 0;
		
		showSlide();
	}
	
	//
	
	public void hideSlide() {
		slides.get(slideAt).hide();
	}
	
	public void showSlide() {
		Slide at = slides.get(slideAt);
		at.attach(this);
		
		if(isWindowed)
			at.windowed();
		else 
			at.fullscreen();
		
		at.show();
	}
	
	//
	
	public void fullscreen() {
		isWindowed = false;
	}
	
	public void windowed() {
		isWindowed = true;
	}
}
