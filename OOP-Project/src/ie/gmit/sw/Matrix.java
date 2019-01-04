package ie.gmit.sw;
/**
 * <h1>Title here</h1> 
 * @author Kevin Gleeson
 * @version 1.0
 * @since 2018-20-12
 */
public class Matrix {

	private int[][] model = { 
				{ 1, 0, 0, 0, 0, 0 , 0, 0, 0, 2},
				{ 0, 1, 0, 0, 0, 0 , 0, 0, 0, 2},
				{ 0, 0, 2, 0, 0, 0 , 0, 0, 0, 2},
				{ 0, 0, 0, 1, 0, 0 , 0, 0, 0, 2},
				{ 2, 2, 2, 2, 1, 0 , 0, 0, 0, 2},
				{ 3, 3, 3, 3, 1, 1 , 1, 0, 0, 1},
				{ 5, 5, 5, 5, 3, 3 , 1, 0, 0, 1},
				{ 4, 4, 4, 5, 3, 3 , 1, 0, 0, 0},
				{ 4, 4, 4, 4, 5, 3 , 1, 6, 6, 6},
				{ 4, 4, 4, 4, 4, 3 , 1, 7, 7, 7}
		};
	private int[][] objects = { 
				{ 0, 0, 0, 5, 5, 5 , 5, 5, 5, 0},
				{ 5, 0, 0, 0, 5, 5 , 5, 5, 5, 0},
				{ 5, 5, 0, 0, 0, 5 , 5, 5, 5, 9},
				{ 5, 5, 2, 0, 0, 0 , 5, 5, 5, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 5, 5, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 0, 5, 0},
				{ 0, 0, 0, 0, 0, 3 , 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0 , 0, 0, 0, 0}
		};

	public Matrix() {
		super();
	}

	public int[][] getModel() {
		return model;
	}

	public void setModel(int[][] model) {
		this.model = model;
	}

	public int[][] getObjects() {
		return objects;
	}

	public void setObjects(int[][] objects) {
		this.objects = objects;
	}

}