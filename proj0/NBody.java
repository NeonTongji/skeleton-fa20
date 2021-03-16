public class NBody{
	public static double readRadius(String fileName){
		In in = new In("data/planets.txt");
		int bodyNumber = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Body[] readBodies(String fileName){
		In in = new In("data/planets.txt");
		int bodyNumber = in.readInt();
		in.readDouble();
		Body[] Planets = new Body[bodyNumber];

		int i = 0;
		while(i < bodyNumber){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String name = in.readString();
			Planets[i++] = new Body(xxPos, yyPos, xxVel, yyVel, mass, name);
		}
		return Planets;
	}

	public static void main(String[] args){
		double T = Double.valueOf(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fileName = args[2];
		double radius = NBody.readRadius(fileName);
		Body[] planets = NBody.readBodies(fileName);
		String backgrond = "images/starfield.jpg";

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0,0,backgrond);
		for(Body p : planets){
			p.draw();
		}
		StdDraw.show();

		double tick = 0.0;
		int num = planets.length;
		while(tick <= T){
			double[] ForceX = new double[num];
			double[] ForceY = new double[num];

			for(int i = 0; i < num; i++){
				ForceX[i] = planets[i].calcNetForceExertedByX(planets);
				ForceY[i] = planets[i].calcNetForceExertedByY(planets);
				planets[i].update(dt, ForceX[i], ForceY[i]);
			}

			StdDraw.picture(0,0,backgrond);
			for(Body p : planets){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			tick += dt;
		}

		StdAudio.play("audio/2001.mid");

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for(int i = 0; i < planets.length; i++){
			StdOut.printf("\"%11.4e %11.4e %11.4e %11.4e %11.4e %12s\\n\"",
					planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
					planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}
	}



}