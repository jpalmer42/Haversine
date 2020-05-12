package org.pensar.haversine;

import java.awt.Point;

public class Haversine {
	
	private static final Double	R		= 6372.8;		// Radius of the earth in kilometers @ 30deg North
	private static final Double	PI180	= Math.PI / 180;

	private Haversine() {
	}

	public static double getDistance( Double latitudeY1, Double longitudeX1, Double latitudeY2, Double longitudeX2 ) {
		double latDistance = Math.pow( Math.sin( ( PI180 * ( latitudeY2 - latitudeY1 ) ) / 2 ), 2 );
		double lonDistance = Math.pow( Math.sin( ( PI180 * ( longitudeX2 - longitudeX1 ) ) / 2 ), 2 );
		double a = latDistance + Math.cos( PI180 * ( latitudeY1 ) ) * Math.cos( PI180 * ( latitudeY2 ) ) * lonDistance;
		double c = 2 * Math.atan2( Math.sqrt( a ), Math.sqrt( 1 - a ) );

		return R * c;
	}
	
	public static double getDistance( Point point1, Point point2 ) {
		return getDistance( point1.getY(), point1.getX(), point2.getY(), point2.getX() );
	}
}
