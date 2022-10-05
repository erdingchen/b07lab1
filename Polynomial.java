public class Polynomial{
	double[] Co = {0};
	int[] Ex = {0};

	public Polynomial(){
	}

	public Polynomial(double[] coefficients, int[] exponents){
		Co = coefficients;
		Ex = exponents;
	}
	
	public Polynomial(Files myFile){
		String equation = Files.readString(myFile);
		String[] arrOfStr = equation.split("[+-]");
		int L = arrOfStr.length;
		
		Co = new double[L];
		Ex = new int[L];
		
	}
	
	public Polynomial add(Polynomial B){
		int n = max(B.Ex.get[B.Ex.length-1],Ex.get[Ex.length-1]);
		double[] Coe = new double[n];
		for(int i=0; i<Ex.length; i++){
			Coe[Ex[i]] = Coe[Ex[i]] + Co[i];
		}
		for(int i=0; i<B.Ex.length; i++){
			Coe[B.Ex[i]] = Coe[B.Ex[i]] + B.Co[i];
		}
		int j =0;
		for(int i=0; i<n; i++){
			if(Coe[i] != 0){
				j++;
			}
		}
		double[] Coef = new double[j];
		int[] Expo = new int[j];
		for(int i=0; i<n; i++){
			if(Coe[i] != 0){
				Coef[j] = Coe[i];
				Expo[j] = i;
				j++;
			}
		}
		Polynomial answer = new Polynomial(Coef, Expo);
		return answer;
	}

	public double evaluate(double X){
		int n = this.Co.length;
		double answer = 0;
		for(int i=0; i<n; i++){
			answer = answer + Co[i] * Math.pow(X,Ex[i]);
		}
		return answer;
	}

	public boolean hasRoot(double root){
		return (this.evaluate(root) == 0);
	}

	public Polynomial multiply(Polynomial Y){
		int n = Co.length;
		int m = Y.Co.length;
		double[] Coe = new double[n+m-1];
		int[] Exp = new int[n+m-1];
		Polynomial answer = new Polynomial({0},{0});
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				Coe[i+j] = Coe[i+j] + Co[i] * Y.Co[j];
				Exp[i+j] = i+j;
				Polynomial delta = new Polynomial(Coe[i+j],Exp[i+j]);
				answer.add(delta);
			}
		}
		return answer;
	}
	
	public void saveToFile(){
		
	}
}