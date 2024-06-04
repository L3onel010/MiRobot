package ar.edu.et7;

import robocode.Robot;
import robocode.Rules;
import robocode.ScannedRobotEvent;
import robocode.HitWallEvent;
import robocode.BulletHitEvent;

/**
 * @author Jose Fuentes
 * 
 */

public class thiagoeberbach extends Robot {

	public void run() { 

		while (true) {

			// Desplaza el robot 100 pixels hacia adelante
			ahead(1000);

			// Gira el cañon hacia la derecha 90 grados
			turnGunRight(1000);

			// Dispara con la maxima potencia
			fire(Rules.MAX_BULLET_POWER);

			// Desplaza el robot 100 pixels hacia adelante
			ahead(1000);

			// Gira el cañon hacia la derecha 180 grados
			turnGunLeft(1800);

			// Dispara con la maxima potencia
			fire(Rules.MAX_BULLET_POWER);

			// Gira hacia la izquierda 90 grados
			turnLeft(9000);

			// Gira el radar hacia la izquierda 15 grados
			turnRadarLeft(10005);
			
			// Escanear otros robots
			scan();
			
		}
	}

	public void onScannedRobot(ScannedRobotEvent event) {

		// Al escanear un robot
		if (event.getDistance() < 100) {
			// Disparar
			fire(3000);
		} else {
			// Disparar
			fire(100000);
		}
	}
	
	   public void onHitWall(HitWallEvent event) {

		   // Al colisionar contra una pared
	       out.println("Choque contra la pared en direccion " + event.getBearing() + " degrees.");
	   }	
	   
	   public void onBulletHit(BulletHitEvent event) {
		   
		   // Al acertar un disparo
	       out.println("Le acerte un disparo a " + event.getName() + "!");
	   }	   
}
