package Event;

import Character.*;

	public class Hit {
		public static boolean checkHit(Samurai samurai,Trap trap1){ //to check hit samurai and trap
			if(samurai.x + samurai.SamuraiWidth > trap1.x && samurai.x < trap1.x) { // check axis-x 
				if(samurai.y - samurai.SamuraiHeight <= trap1.y - trap1.height && samurai.y + samurai.SamuraiWidth >= trap1.y - trap1.height){ //  check axis-y 
					return true;  //return to true when is hit			
				}
			}
			return false; // return to false when is not hit
		}
}

	

