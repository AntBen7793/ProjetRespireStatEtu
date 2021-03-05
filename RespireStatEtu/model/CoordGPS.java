package model;

public class CoordGPS {
	private double latitude;
	private double longitude;
	
	public CoordGPS(String geometry) {
		this(getLatitudeFromGeometry(geometry),getLongitudeFromGeometry(geometry));
	}
	public CoordGPS(double lat, double lon) {
		latitude = lat;
		longitude = lon;
	}
	
	private static String[] extractLatLongFromGeometry(String geometry) {
		String extract = geometry.substring(2, geometry.length()-1);
		String[] coord = extract.split(", ");
		return coord;
	}
	private static double getLatitudeFromGeometry(String geometry) {
		return Double.parseDouble(extractLatLongFromGeometry(geometry)[0]);
	}
	private static double getLongitudeFromGeometry(String geometry) {
		return Double.parseDouble(extractLatLongFromGeometry(geometry)[1]);
	}
	public double getLatitude() {
		return latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	@Override
	public String toString() {
		return "CoordGPS [latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	
}
