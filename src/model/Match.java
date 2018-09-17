package model;

public class Match {
	private String id;	
	//Jugadores de lista enlazada
	private Player players;
	public Match(String id) {
		
		this.id = id;
		
	}
	
	
	 public int factorial(int num) {
			int factorial=1;
			
			for (int i = num; i > 0; i--) {
	            factorial = factorial * i;
	        }
			
			
			return factorial;
			
		}
		
		
		public double probablyPoisson(int k) {
			double probably=0;
			double  u=0;
			probably=(Math.pow(u, k)*Math.pow(Math.E,-u))/factorial(k);
			
			
			
			return probably;
		}
	

}
