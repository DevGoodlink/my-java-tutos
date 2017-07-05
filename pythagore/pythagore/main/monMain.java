package pythagore.main;

public class monMain {

	public static void main(String[] args) {
		System.out.println(""+DistanceTo(48.73021,9.34456,48.72473,9.36872,"k"));
		
	}
	static double DistanceTo(double lat1, double lon1, double lat2, double lon2, String unit)
	{
	    double rlat1 = Math.PI * lat1/180;
	    double rlat2 = Math.PI * lat2/180;
	    double rlon1 = Math.PI * lon1/180;
	    double rlon2 = Math.PI * lon2/180;
	 
	    double theta = lon1-lon2;
	    double rtheta = Math.PI * theta/180;
	 
	    double dist = Math.sin(rlat1) * Math.sin(rlat2) + Math.cos(rlat1) * Math.cos(rlat2) * Math.cos(rtheta);
	    dist = Math.acos(dist);
	    dist = dist * 180/Math.PI;
	    dist = dist * 60 * 1.1515;
	 
	    if (unit=="K") { dist = dist * 1.609344; }
	    if (unit == "M") { dist = dist * 1.609344 * 1000; }
	    if (unit == "N") { dist = dist * 0.8684; }
	    return dist;
	}

}
