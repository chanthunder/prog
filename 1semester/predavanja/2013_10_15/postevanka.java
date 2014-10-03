class Trikotnik3While {
	public static void main (String[] args) {
		int i=1;
		while(i<=5) {
			double a=BranjePodatkov.preberiDouble();
			double b=BranjePodatkov.preberiDouble();
			double c=BranjePodatkov.preberiDouble();
			if (a+b>c && a+c>b && b+c>a ) {
				double s=(a+b+c)/2;
				double p=Math.sqrt(s*(s-a)*(s-b)*(s-c));
				System.out.println(p);
			}
			else {
				System.out.println("Napacni podatki");
			}
		}
	}
}
