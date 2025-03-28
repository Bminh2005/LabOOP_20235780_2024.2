package main;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public DigitalVideoDisc() {
		super();
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
		
	public void setTitle(String title) {
		this.title = title;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		DigitalVideoDisc.nbDigitalVideoDiscs++;
		this.id = DigitalVideoDisc.nbDigitalVideoDiscs;
	}
	
	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getCategory() {
		return this.category;
	}

	public String getDirector() {
		return this.director;
	}

	public int getLength() {
		return this.length;
	}

	public float getCost() {
		return this.cost;
	}

}
