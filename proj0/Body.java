public class Body{
	/***set the attribute of class body***/
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11;

	/***initialize the class Body***/
	public Body(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName){
		this.xxPos = xxPos;
		this.yyPos = yyPos;
		this.xxVel = xxVel;
		this.yyVel = yyVel;
		this.mass = mass;
		this.imgFileName = imgFileName;
	}

	/***initialize the instance b***/
	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		/***take in single Body, return a double distance between the supplied body and body that's doing the calculation***/
		double dist = Math.sqrt(Math.pow((this.xxPos - b.xxPos), 2) + Math.pow((this.yyPos - b.yyPos), 2));
		return dist;
	}

	public double calcForceExertedBy(Body b){
		if (this.equals(b)){
			return 0;
		}
		double m1 = this.mass;
		double m2 = b.mass;
		double r = this.calcDistance(b);
		double force = G*m1*m2/Math.pow(r, 2);
		return force;
	}

	public double calcForceExertedByX(Body b){
		return this.calcForceExertedBy(b) * (b.xxPos - this.xxPos) / this.calcDistance(b);
	}

	public double calcForceExertedByY(Body b){
		return this.calcForceExertedBy(b) * (b.yyPos - this.yyPos) / this.calcDistance(b);

	}


	public double calcNetForceExertedByX(Body[] bodies){
		double sum = 0;
		// enhanced loop
		for (Body b : bodies){
			if (b.equals(this)){
				continue;
			}
			sum += calcForceExertedByX(b);
		}
		return sum;

	}

	public double calcNetForceExertedByY(Body[] bodies){
		double sum = 0;
		for (Body b : bodies){
			if (b.equals(this)){
				continue;
			}
			sum += calcForceExertedByY(b);
		}
		return sum;
	}

	public void update(double time, double xForce, double yForce){
		double ax = xForce / this.mass;
		double ay = yForce / this.mass;
		this.xxVel += (ax * time);
		this.yyVel += (ay * time);
		this.xxPos += (this.xxVel * time);
		this.yyPos += (this.yyVel * time);
	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/"+ imgFileName);
	}
}