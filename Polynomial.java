public class Polynomial{
	double[] C = {0};
	public Polynomial(){
	}
	public Polynomial(double[] coefficient){
		int n = coefficient.length;
		C = new double[n];
		for(int i=0; i<n; i++){
			C[i] = coefficient[i];
		}
	}
	public Polynomial add(Polynomial B){
		int lengthofA = this.C.length;
		int n;
		int lengthofB = B.C.length;
		if(lengthofA < lengthofB){
			n = lengthofA;
			for(int i=0; i<n; i++){
				B.C[i] = B.C[i] + this.C[i];
			}
			return B;
		}
		else{
			n = lengthofB;
			for(int i=0; i<n; i++){
				this.C[i] = this.C[i] + B.C[i];
			}
			return this;
		}
	}
	public double evaluate(double X){
		int n = C.length;
		double answer = 0;
		answer = C[0];
		for(int i=1; i<n; i++){
			answer = answer + C[i] * Math.pow(X, i);
		}
		return answer;
	}
	public boolean hasRoot(double root){
		return (this.evaluate(root) == 0);
	}
}